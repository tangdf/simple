package com.wb.login.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wb.login.ApplicationUtils;
import com.wb.login.SessionUtils;
import com.wb.login.model.LogLoginBO;
import com.wb.login.model.LoginSpDTO;
import com.wb.login.service.LoginService;
import com.wb.user.model.UaasUserVO;
import com.wb.utils.web.RequestUtils;

@Controller
public class LoginAction {
	private String domain;
	
	private static Logger logger = Logger.getLogger(LoginAction.class);
	private LoginService loginService;

	@RequestMapping(value="login.action")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		String loginname = RequestUtils.getParameter(request, "loginname", null);
		String password = RequestUtils.getParameter(request, "password", null);
		String pid = RequestUtils.getParameter(request, "pid", null);
		String checkCode = RequestUtils.getParameter(request, "checkCode", null);
		ModelAndView m=new ModelAndView();
		/**
		 * 验证码判断
		 */
		String captchaToken=(String)request.getSession().getAttribute("captchaToken");
		if(checkCode==null||!checkCode.equalsIgnoreCase(captchaToken)){
			String returnUrl="";
			if("1001".equals(pid)) returnUrl="login_zg";
			if("1002".equals(pid)) returnUrl="login_jmyl";
			if("2001".equals(pid)) returnUrl="login_shyl";
			m.setViewName(returnUrl);
			m.addObject("message","验证码不正确!");
			return m;
		}
		/**
		 * 登陆日志
		 */
		LogLoginBO loginBO=new LogLoginBO();
		loginBO.setCdate(new Date());
		loginBO.setLoginname(loginname);
		loginBO.setPassword(password);
		loginBO.setPid(pid);
		loginBO.setIp(request.getRemoteAddr());
		/**
		 * 调用登陆验证后台
		 */
		LoginSpDTO dto=new LoginSpDTO();
		dto.setLoginname(loginname);
		dto.setPassword(password);
		dto.setPid(pid);
		loginService.callLoginSP(dto);
		
		if(dto.getRetcode()<0){//登陆失败
			m.addObject("message",dto.getRetmsg());
			m.setViewName(dto.getViewname());
			loginBO.setIssuccess("0");//登陆失败
			loginBO.setMessage(dto.getRetmsg());
			loginBO.setUserid(dto.getUserid()==null?null:Long.valueOf(dto.getUserid()));
		}else{//登陆成功
			List<UaasUserVO> users = loginService.getUsersByUserId(dto.getUserid());
			setSessionContext(request.getSession(),users.get(0));
			setSessionContextUsers(request.getSession(),users);
			logger.info("登录成功,登录人:"+loginname);
			m.setViewName(dto.getViewname());
			loginBO.setIssuccess("1");//登陆成功
			loginBO.setMessage(dto.getRetmsg());
			loginBO.setUserid(dto.getUserid()==null?null:Long.valueOf(dto.getUserid()));
		}
		//记录登陆日志
		saveLoginLog(loginBO);
	    return m;
	}
	
	@RequestMapping(value="ajaxlogin.action")
	@ResponseBody//直接返回，不跳转jsp
	public Map<String, Object> ajaxlogin(){
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		return modelMap;
	}
	
	private void setSessionContext(HttpSession session, UaasUserVO user){
		session.setAttribute(SessionUtils.UAASUSER,user);
		session.setAttribute(SessionUtils.LOGINTOKEN,user.getId());
		session.setAttribute(SessionUtils.USERID,user.getId());
		session.setAttribute(SessionUtils.LOGINNAME,user.getLoginName());
		session.setAttribute(SessionUtils.USERKEY,user.getUserkey());
		session.setAttribute(SessionUtils.GROUPID,user.getGroupid());
		session.setAttribute(SessionUtils.NAME,user.getName());
		session.setAttribute(SessionUtils.PASSWORD,user.getPassword());
		session.setAttribute(SessionUtils.DOMAIN,domain);
		session.setAttribute(SessionUtils.APPLICATION, session.getServletContext().getInitParameter(ApplicationUtils.APPLICATION));
	}
	private void setSessionContextUsers(HttpSession session, List<UaasUserVO> users){
		List<String> groupids=new ArrayList<String>();
		for(UaasUserVO vo:users){
			groupids.add(vo.getGroupid());
		}
		session.setAttribute(SessionUtils.GROUPIDS,groupids);
	}
	private void saveLoginLog(LogLoginBO bo){
		loginService.saveLoginLog(bo);
	}
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}
