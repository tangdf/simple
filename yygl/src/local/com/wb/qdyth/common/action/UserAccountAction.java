package com.wb.qdyth.common.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wb.login.SessionUtils;
import com.wb.qdyth.common.bo.Ac01Dto;
import com.wb.qdyth.common.bo.MobileUserBinding;
import com.wb.qdyth.common.bo.PasswordResetVO;
import com.wb.qdyth.common.bo.UaasUserPassport;
import com.wb.qdyth.common.service.CommonService;
import com.wb.user.model.UaasUpdaVO;
import com.wb.utils.web.JsonUtils;

	/**
	 * 个人账户管理
	 */
	@Controller
	public class UserAccountAction {

		@Autowired
		private CommonService commonService;
		
		@RequestMapping("/work/userAccount/index_updatePassword.action")
		public String index_updatePassword(){
			return "/common/userAccount/updatePassword";
		}
		@RequestMapping("/work/userAccount/index_updatePassport.action")
		public String index_updatePassport(){
			return "/common/userAccount/updatePassport";
		}
		/**
		 * 修改密码
		 * @param request
		 * @param oldpassword
		 * @param password
		 * @return
		 */
		@RequestMapping("/work/userAccount/updatePassword.action")
		@ResponseBody
		public String updatePassword(HttpServletRequest request,String oldpassword,String password){
			HttpSession session=request.getSession();
			Long userid=(Long)session.getAttribute(SessionUtils.USERID);
			UaasUpdaVO uaasUpdaVO=commonService.queryUaasUpdaByUserId(userid.toString());
			PasswordResetVO passwordResetVO =new PasswordResetVO();
			passwordResetVO.setGroupid(uaasUpdaVO.getGroupid()==null?"":uaasUpdaVO.getGroupid().toString());
			passwordResetVO.setOldpassword(oldpassword);
			passwordResetVO.setPassword(password);
			passwordResetVO.setUserid(String.valueOf(userid));
			commonService.updatePassword(passwordResetVO);
			return JsonUtils.getJsonData(passwordResetVO);
		}
		@RequestMapping("/public/userAccount/updatePasswordPublic.action")
		@ResponseBody
		public String updatePasswordPublic(HttpServletRequest request,String userid,String password){
			PasswordResetVO passwordResetVO =new PasswordResetVO();
			UaasUpdaVO uaasUpdaVO=commonService.queryUaasUpdaByUserId(userid.toString());
			passwordResetVO.setGroupid(uaasUpdaVO.getGroupid()==null?"":uaasUpdaVO.getGroupid().toString());
			passwordResetVO.setPassword(password);
			passwordResetVO.setUserid(userid);
			commonService.updatePassword(passwordResetVO);
			return JsonUtils.getJsonData(passwordResetVO);
		}
		/**
		 * 密保问题修改
		 * @param request
		 * @param oldpassword
		 * @param password
		 * @return
		 */
		@RequestMapping("/work/userAccount/updatePassport.action")
		@ResponseBody
		public String updatePassport(HttpServletRequest request){
			HttpSession session=request.getSession();
			Long userid=(Long)session.getAttribute(SessionUtils.USERID);
			PasswordResetVO passwordResetVO =new PasswordResetVO();
			passwordResetVO.setUserid(String.valueOf(userid));
			passwordResetVO.setQuestion1(request.getParameter("question1"));
			passwordResetVO.setQuestion2(request.getParameter("question2"));
			passwordResetVO.setAnswer1(request.getParameter("answer1"));
			passwordResetVO.setAnswer2(request.getParameter("answer2"));
			commonService.updatePassport(passwordResetVO);
			return JsonUtils.getJsonData(passwordResetVO);
		}
		
		/**
		 * 找回密码-返回找回密码入口
		 * @return
		 */
		@RequestMapping("/public/userAccount/index_findPassword.action")
		public String index_findPassword(){
			return "/common/userAccount/finddPassword";
		}
		/**
		 * 找回密码-返回修改密码窗口
		 * @return
		 */
		@RequestMapping("/public/userAccount/index_passwordReset.action")
		public String index_passwordReset(HttpServletRequest request){
			String userid=request.getParameter("userid");
			if(userid==null){//手机找回
				String aac001=request.getParameter("aac001");
				String phone=request.getParameter("phone");
				UaasUpdaVO vo=commonService.getUpadByMobileBing(phone, aac001);
				if(vo==null)
				request.setAttribute("errorMsg","未找到人员信息！");
				else
				userid=vo.getUers_id().toString();
			}
			request.setAttribute("userid",userid);
			return "/common/userAccount/passwordReset";
		}
		/**
		 * 找回密码-入口分配
		 * @return
		 */
		@RequestMapping("/public/userAccount/findPassword.action")
		public String findPassword(HttpServletRequest request, String aac001,String aac002){
			//验证人员信息
			Ac01Dto ac01dto=commonService.getRybh(aac001,aac002);
			if(ac01dto==null){
				request.setAttribute("message","未找到正确匹配的人员！");
				 return "/common/userAccount/finddPassword";
			}
			//取出密保问题,在存密保问题则通过密保找回
			UaasUserPassport uaasUserPassport=commonService.getUaasPassport(ac01dto.getAac001());
			if(uaasUserPassport!=null){
				request.setAttribute("uaasUserPassport",uaasUserPassport);
				request.setAttribute("userid",uaasUserPassport.getUserid());
				return "/common/userAccount/mbQuestion";
			}else{
			//取出绑定手机号
			MobileUserBinding mobileUserBinding=commonService.getUaasMobileByAac147(ac01dto.getAac001(),aac002);
				if(mobileUserBinding==null){
					//返回绑定界面
					request.setAttribute("ac01dto",ac01dto);
					return "/common/userAccount/phoneBd";
				}else{
					//发送短信
					request.setAttribute("mobileUserBinding",mobileUserBinding);
					return "redirect:/public/userAccount/sendSmsFind.action?aac001="+aac001+"&phone="+mobileUserBinding.getM_phone();
				}
			}
		}
		/**
		 * 验证密保问题是否正确
		 * @param request
		 * @param uaasUserPassport
		 * @return
		 */
		@RequestMapping("/public/userAccount/validatePassport.action")
		@ResponseBody
		public String validatePassport(HttpServletRequest request,UaasUserPassport uaasUserPassport){
			UaasUserPassport uup=commonService.getUaasPassport(uaasUserPassport);
			if(uup!=null){
				request.setAttribute("uup", uup);
				return JsonUtils.getJsonData(uup);
			}else{
				return "{error:\'密保问题不正确！\'}";
			}
		}
		/**
		 * 发送验证码用于手机绑定
		 * @param request
		 * @throws IOException
		 */
		@RequestMapping("/public/userAccount/sendSmsBind.action")
		@ResponseBody
		public String sendSmsBind(HttpServletRequest request,HttpServletResponse response) throws IOException{
			response.setCharacterEncoding("UTF-8");
			//String aac002=request.getParameter("aac002");
			String aac001=request.getParameter("aac001");
			String phone=request.getParameter("phone");
			try{
				MobileUserBinding mubdto=commonService.getUaasMobileByPhone(aac001,phone);
				if(mubdto!=null){
					return "{error:\'该账号已经绑定手机！\'}";
				}
				String code=commonService.genCode();
				String result=SendSms.SendMessageData(phone, "您正在办理手机绑定业务，验证码为："+code+"，5分钟内有效。【青岛市人社局】", "绑定手机");
				if(result==null){
					return "{error:\'验证码发送失败！\'}";
				}
				request.getSession().setAttribute("CODE_FIND_"+aac001, code);//手机找回密码验证
				request.getSession().setAttribute("TIME_FIND_"+aac001, new Date());//手机找回密码验证时间
				request.getSession().setAttribute("PHONE_FIND_"+aac001, phone);//手机找回密码验证时间
				return "{success:true}";
			}catch(Exception e){
				e.printStackTrace();
				return "{error:\'错误！\'}";
			}
		}
		/**
		 * 发送验证码用于密码找回
		 * @param request
		 * @throws IOException
		 */
		@RequestMapping("/public/userAccount/sendSmsFind.action")
		public String sendSmsFind(HttpServletRequest request,HttpServletResponse response) throws IOException{
			String result="";
			try{
				String aac002=request.getParameter("aac002");
				String aac001=request.getParameter("aac001");
				String phone=request.getParameter("phone");
				String code=commonService.genCode();
				result=SendSms.SendMessageData(phone, "您正在办理手机找回密码业务，验证码为："+code+"，5分钟内有效。【青岛市人社局】", "找回密码");
				if(result==null||"null".equals(result)){
					result="验证码发送失败！";
				}
				request.setAttribute("aac002", aac002);
				request.setAttribute("aac001", aac001);
				request.setAttribute("phoneNumber", transPhone(phone));
				request.setAttribute("phone", phone);
				request.getSession().setAttribute("CODE_FIND_"+aac001, code);//手机找回密码验证
				request.getSession().setAttribute("TIME_FIND_"+aac001, new Date());//手机找回密码验证时间
			}catch(Exception e){
				e.printStackTrace();
				result="验证码发送失败！";
			}
			if("验证码发送失败！".equals(result)) request.setAttribute("errorMsg", result);
			return "/common/userAccount/mbPhoneFind";
		}
		/**
		 * 验证验证码是否正确
		 * @param request
		 * @return
		 */
		@RequestMapping("/public/userAccount/mbPhoneBdVali.action")
		@ResponseBody
		public String mbPhoneBdVali(HttpServletRequest request){
			//String aac002=request.getParameter("aac002");
			String aac001=request.getParameter("aac001");
			String code=request.getParameter("code");
			String result="";
			try{
				String session_code=(String)request.getSession().getAttribute("CODE_FIND_"+aac001);//手机找回密码验证
				Date session_time=(Date)request.getSession().getAttribute("TIME_FIND_"+aac001);//手机找回密码验证时间
				//String phone=(String)request.getSession().getAttribute("PHONE_FIND_"+aac001);//手机找回密码验证时间
				if(session_code==null||!session_code.equals(code)){
					result="检验码不正确！";
				} ;
				//超过5分钟
				if(new Date().getTime()-session_time.getTime()>300000){
					result="检验码已过期！";
				}	
			}catch(Exception e){
				result="出错！";
			}
			return result;
		}
		/**
		 * 个人网上手机绑定
		 * @param request
		 * @return
		 */
		@RequestMapping("/public/userAccount/phoneBind.action")
		@ResponseBody
		public String phoneBind(HttpServletRequest request){
			String aac002=request.getParameter("aac002");
			String aac001=request.getParameter("aac001");
			String aac003=request.getParameter("aac003");
			String code=request.getParameter("code");
			//String flag=request.getParameter("flag");
			
			try{
				String session_code=(String)request.getSession().getAttribute("CODE_FIND_"+aac001);//手机找回密码验证
				Date session_time=(Date)request.getSession().getAttribute("TIME_FIND_"+aac001);//手机找回密码验证时间
				String phone=(String)request.getSession().getAttribute("PHONE_FIND_"+aac001);//手机找回密码验证时间
				if(session_code==null||!session_code.equals(code)){
					return "{error:\'检验码不正确！\'}";
				} ;
				//超过5分钟
				if(new Date().getTime()-session_time.getTime()>300000){
					return "{error:\'检验码已过期！\'}";
				}	
				MobileUserBinding mub=new MobileUserBinding();
				mub.setAac001(Long.valueOf(aac001));
				mub.setAac147(aac002);
				mub.setM_phone(phone);
				mub.setStatus("1");
				mub.setCreatetime(new Date());
				mub.setAae103("个人网上手机绑定");
				commonService.savePhoneBdInfo(mub);
				request.getSession().setAttribute("aac002", aac002);
				request.getSession().setAttribute("aac001", aac001);
				request.getSession().setAttribute("aac003", aac003);
				request.getSession().setAttribute("phone", phone);

				return JsonUtils.getJsonData(mub);
			}catch(Exception e){
				e.printStackTrace();
				return "{error:\'手机绑定失败！\'}";
			}
			
		}
		/**
		 * 手机号加*号
		 * @param phoneNumber
		 * @return
		 */
		public static String transPhone(String phoneNumber){
			if(phoneNumber!=null&&phoneNumber.trim().length()==11){
				return phoneNumber.substring(0,3)+"****"+phoneNumber.substring(7);
			}
			return phoneNumber;
		}
		public CommonService getCommonService() {
			return commonService;
		}
		public void setCommonService(CommonService commonService) {
			this.commonService = commonService;
		}
	
	}

	

