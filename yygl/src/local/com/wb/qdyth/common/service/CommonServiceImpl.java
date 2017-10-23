package com.wb.qdyth.common.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.wb.exceptions.BusinessException;
import com.wb.jdbcutils.CommonJdbcUtils;
import com.wb.qdyth.common.bo.Ac01Dto;
import com.wb.qdyth.common.bo.MobileUserBinding;
import com.wb.qdyth.common.bo.NetBusiLog;
import com.wb.qdyth.common.bo.NetData;
import com.wb.qdyth.common.bo.NetDataMain;
import com.wb.qdyth.common.bo.NetStatus;
import com.wb.qdyth.common.bo.PasswordResetVO;
import com.wb.qdyth.common.bo.SpUpdatePasswordSPDTO;
import com.wb.qdyth.common.bo.UaasUserPassport;
import com.wb.user.model.UaasUpdaVO;
import com.wb.user.utils.BusinessContextUtils;

/**
 * 个人查询工程共用Service
 * @author xue
 * 2015-9-27
 */
public class CommonServiceImpl implements CommonService{
	//日志输出
	private static Logger logger = Logger.getLogger(CommonServiceImpl.class);

	/**
	 * 
	 * @param busiid
	 * @param links
	 * @return
	 */
	public Long creatBusinessLog(String busiid, String...links){
		Long userid = BusinessContextUtils.getUserContext().getId();
		Long type =  BusinessContextUtils.getUserContext().getAuthenticType();
		String aac001=BusinessContextUtils.getUserContext().getUserkey();
		String sql=" select a.* from net_data_main a ,net_data b,net_status c where a.lsh=b.lsh and a.lsh=c.lsh and b.userid=? and b.busiid=? and c.link='1' and  c.undo='1'";		
		NetDataMain ndm=CommonJdbcUtils.queryFirst(sql.toString(), NetDataMain.class,userid,busiid);
		if(ndm!=null){
			throw new BusinessException("您上次提交的更改尚未处理，请过段时间再做操作！");
		}
		String lsh=CommonJdbcUtils.getSequenceValue("seq_net_lsh");
		NetStatus status = new NetStatus();
		status.setLsh(Long.valueOf(lsh));
		if(links==null||links.length==0){
			status.setLink("1");
			status.setClzt("1");
		}else if(links.length==1){
			status.setLink(links[0]);
			status.setClzt("1");
		}else if(links.length==2){
			status.setLink(links[0]);
			status.setClzt(links[1]);
		}
		status.setType(String.valueOf(type));
		status.setUndo("1");
		CommonJdbcUtils.save(status);
		NetBusiLog busiLog = new NetBusiLog();
		busiLog.setLsh(status.getLsh());
		busiLog.setUserid(String.valueOf(userid));
		busiLog.setTime(new Date());
		busiLog.setBusiid(busiid);
		busiLog.setLink(status.getLink());
		busiLog.setClzt(status.getClzt());
		CommonJdbcUtils.save(busiLog);
		return status.getLsh();
	}
	
	/**
	 *  @param busiid
	 * @param name
	 * @param links
	 * @return
	 */
	public Long getlsh(String busiid,String name, String...links){
		Long userid = BusinessContextUtils.getUserContext().getId();
		Long type =  BusinessContextUtils.getUserContext().getAuthenticType();
		String aac001=BusinessContextUtils.getUserContext().getUserkey();
		String sql=" select a.* from net_data_main a ,net_data b,net_status c where a.lsh=b.lsh and a.lsh=c.lsh and b.aac001=? and b.busiid=? and c.link='1' and  c.undo='1' and a.data01=? ";		
		NetDataMain ndm=CommonJdbcUtils.queryFirst(sql.toString(), NetDataMain.class,aac001,busiid,name);
		if(ndm!=null){
			throw new BusinessException("您上次提交的更改尚未处理，请过段时间再做操作！");
		}
		String lsh=CommonJdbcUtils.getSequenceValue("seq_net_lsh");
		NetStatus status = new NetStatus();
		status.setLsh(Long.valueOf(lsh));
		if(links==null||links.length==0){
			status.setLink("1");
			status.setClzt("1");
		}else if(links.length==1){
			status.setLink(links[0]);
			status.setClzt("1");
		}else if(links.length==2){
			status.setLink(links[0]);
			status.setClzt(links[1]);
		}
		status.setType(String.valueOf(type));
		status.setUndo("1");
		CommonJdbcUtils.save(status);
		NetBusiLog busiLog = new NetBusiLog();
		busiLog.setLsh(status.getLsh());
		busiLog.setUserid(String.valueOf(userid));
		busiLog.setTime(new Date());
		busiLog.setBusiid(busiid);
		busiLog.setLink(status.getLink());
		busiLog.setClzt(status.getClzt());
		CommonJdbcUtils.save(busiLog);
		return status.getLsh();
	}
	
	/**
	 * 保存业务主表net_data
	 * @param lsh
	 * @param busiid
	 */
	public NetData saveNetDate(Long lsh,String busiid){
		NetData netdata = new NetData();
		netdata.setLsh(lsh);
		netdata.setUserid(String.valueOf(BusinessContextUtils.getUserContext().getId()));
		netdata.setObjname(BusinessContextUtils.getUserContext().getName());
		netdata.setObjtype(BusinessContextUtils.getUserContext().getUserkey());
		netdata.setAac001(BusinessContextUtils.getUserContext().getUserkey());
		netdata.setBusiid(busiid);
		netdata.setTime(new Date());
		CommonJdbcUtils.save(netdata);
		return netdata;
		
	}
	/**
	 * 根据ID查询UaasUpad
	 * @param userid
	 * @return
	 */
	public UaasUpdaVO queryUaasUpdaByUserId(String userid){
		String sql="select * from uaas_upda where uers_id=?";
		return CommonJdbcUtils.queryFirst(sql, UaasUpdaVO.class, userid);
	}
	/**
	 * 修改密码
	 * @param passwordResetVO
	 * @return
	 */
	public void updatePassword(PasswordResetVO passwordResetVO){
	    
		SpUpdatePasswordSPDTO spdto=new SpUpdatePasswordSPDTO();
		spdto.setGroupid(passwordResetVO.getGroupid());
		spdto.setPassword(passwordResetVO.getOldpassword());
		spdto.setNewpassword(passwordResetVO.getPassword());
		spdto.setUserid(passwordResetVO.getUserid());
		CommonJdbcUtils.call("SP_UPDATEPASSWORD", spdto);
		if(spdto.getRetcod()!=0){
			throw new BusinessException(spdto.getRetmsg());
		}
	}
	/**
	 * 修改密保问题
	 * @param passwordResetVO
	 * @return
	 */
	public void updatePassport(PasswordResetVO passwordResetVO){

		try{
		String sql = "select * from uaas_upda where uers_id=?";
		UaasUpdaVO pda = CommonJdbcUtils.queryFirst(sql, UaasUpdaVO.class, passwordResetVO.getUserid());
		if(pda==null)
		throw new BusinessException("此用户不存在！");
		if((passwordResetVO.getQuestion1()).equals(passwordResetVO.getQuestion2())){
			throw new BusinessException("请不要选择相同的密保问题！");
		}
		if((passwordResetVO.getQuestion1()==null||passwordResetVO.getQuestion1().equals(""))||(passwordResetVO.getAnswer1()==null||passwordResetVO.getAnswer1().equals(""))){
			throw new BusinessException("请完整填写第一个密保问题！");
		}
		if((passwordResetVO.getQuestion2()==null||passwordResetVO.getQuestion2().equals(""))||(passwordResetVO.getAnswer2()==null||passwordResetVO.getAnswer2().equals(""))){
			throw new BusinessException("请完整填写第二个密保问题！");
		}
		UaasUserPassport uup=new UaasUserPassport();
		uup.setUserid(Long.valueOf(passwordResetVO.getUserid()));
		uup.setUserkey(pda.getUserkey());
		uup.setLoginname(pda.getLoginname());
		uup.setQuestion1(passwordResetVO.getQuestion1());
		uup.setAnswer1(passwordResetVO.getAnswer1());
		uup.setQuestion2(passwordResetVO.getQuestion2());
		uup.setAnswer2(passwordResetVO.getAnswer2());
		uup.setCdate(new Date());
		CommonJdbcUtils.saveOrUpdate(uup);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException("修改密保问题出错！");
		}
}
	/**
	 * 查询人员信息
	 * @param aac001
	 * @param aac002
	 * @return
	 */
	public Ac01Dto getRybh(String aac001,String aac002){
		String sql=" SELECT grid aac001,zjhm aac002 FROM QDSBK.TB_GRXX_ZL@qdweb_jx A  " +
				"WHERE A.ZJHM = ?  AND SJZT <> '11' AND " +
				"A.SBKKH = ? ";
		Ac01Dto ac01dto=CommonJdbcUtils.queryFirst(sql, Ac01Dto.class, aac002,aac001);
		if(ac01dto!=null) return ac01dto;
		try{
			Integer aac001_v=Integer.parseInt(aac001);
		}
		catch(Exception e){
			return null;
		}
		sql = "select aac001,aac002 from ac01@qdweb_jx where " +
				" aac147=? and aac001=? and nvl(aac008,'0')='1' ";
	    return CommonJdbcUtils.queryFirst(sql, Ac01Dto.class, aac002,aac001);
		
	}
	/**
	 * 取出密保问题
	 * @return
	 */
	public UaasUserPassport getUaasPassport(String aac001){
		String sql = "select * from uaas_user_passport where userkey=? ";
	    return CommonJdbcUtils.queryFirst(sql, UaasUserPassport.class, aac001);
	}
	/**
	 * 取出手机绑定信息
	 * @return
	 */
	public MobileUserBinding getUaasMobile(String aac001){
		String sql = "SELECT * FROM mobile_user_binding WHERE aac001=? ";
	    return CommonJdbcUtils.queryFirst(sql, MobileUserBinding.class, aac001);
	}
	/**
	 * 取出手机绑定信息
	 * @return
	 */
	public MobileUserBinding getUaasMobileByAac147(String aac001,String aac147){
		String sql = "SELECT * FROM mobile_user_binding WHERE aac001=? and aac147=? ";
	    return CommonJdbcUtils.queryFirst(sql, MobileUserBinding.class, aac001,aac147);
	}
	/**
	 * 取出手机绑定信息
	 * @return
	 */
	public MobileUserBinding getUaasMobileByPhone(String aac001,String phone){
		String sql = "SELECT * FROM mobile_user_binding WHERE aac001=? and m_phone=? ";
	    return CommonJdbcUtils.queryFirst(sql, MobileUserBinding.class, aac001,phone);
	}
	/**
	 * 取出密保问题
	 * @return
	 */
	public UaasUserPassport getUaasPassport(UaasUserPassport uup){
		String sql = "SELECT * FROM uaas_user_passport " +
				"WHERE userid=? AND question1=? AND answer1=? " +
				"and question2=? AND answer2=? ";
	    return CommonJdbcUtils.queryFirst(sql, UaasUserPassport.class, 
	    		uup.getUserid(),uup.getQuestion1(),uup.getAnswer1(),
	    		uup.getQuestion2(),uup.getAnswer2());
	}
	/**
	 * 生成手机验证码
	 * @return
	 */
	public String genCode() {
		Double d=Math.floor(Math.random()*10000);
		Long l=d.longValue();
		return leftPad(l.toString(),4,'0');
	}
	public static String leftPad(String str,int length,char ch){  
		char[] chs = new char[length];  
		Arrays.fill(chs, ch);//把数组chs填充成ch  
		char[] src = str.toCharArray();//把字符串转换成字符数组  
		System.arraycopy(src, 0, chs,  
		       length-src.length,src.length);  
		//从src的0位置开始复制到chs中从length-src.length到src.lengtth  
		//右填充  
		return new String(chs);  
	         
	} 
	/**
	 * 插入手机绑定信息
	 * @param mub
	 */
	public void savePhoneBdInfo(MobileUserBinding mub){
		CommonJdbcUtils.save(mub);
	}
	/**
	 * 根据手机绑定信息获取uaasupda
	 * @param phone
	 * @param aac001
	 * @return
	 */
	public UaasUpdaVO getUpadByMobileBing(String phone,String aac001){
		String sql="SELECT b.uers_id FROM mobile_user_binding a,uaas_upda b " +
				"WHERE a.aac147=b.loginname AND a.aac001=b.userkey and a.m_phone=? and a.aac001=?";
		return CommonJdbcUtils.queryFirst(sql, UaasUpdaVO.class, phone,aac001);
	}
	/**
	 * 文件上传
	 */
	public void uploadfile_wq(MultipartFile[] files, String lsh,String busiid) {
		Connection conn=null;
		PreparedStatement pst = null;
		Statement stmt=null;
		try {
			conn=CommonJdbcUtils.getCommonJdbcCore().getDataSource().getConnection();
			conn.setAutoCommit(false);    
			
			String sql="insert into net_data_main_attachment values(?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			stmt = conn.createStatement();
			 if(files!=null&&files.length>0){
				 for(int i=0;i<files.length;i++){
					 ResultSet rs = null;
					 MultipartFile file = files[i]; 
					 if(file != null && !file.isEmpty()){
						 String sb_sql=" select to_char(sysdate,'yyyymmdd')||SEQ_fileid.Nextval fileid from dual ";
						 rs = stmt.executeQuery(sb_sql.toString());
						 String vfileid="";
						 if(rs.next()){
								vfileid = rs.getString(1);
							}
						 pst.setString(1, vfileid);  
						 pst.setString(2, lsh);  
						 pst.setString(3, "");  
						 if("200108".equals(busiid)||"200109".equals(busiid)||"200110".equals(busiid)){
							 if(i==0){
								 pst.setString(4, "身份证");
							 }else if(i==1){
								 pst.setString(4, "资格证");
							 }else if(i==2){
								 pst.setString(4, "执业（注册）证");
							 }else if(i==3){
								 pst.setString(4, "职称");
							 }else if(i==4){
								 pst.setString(4, "退休材料");
							 }
						 }else{
							 pst.setString(4, file.getOriginalFilename());  
						 }
						 
						 pst.setString(5, "");  
						 pst.setString(6, file.getContentType());  
						 InputStream in=null;
						try {
							in = file.getInputStream();
							 ByteArrayOutputStream baos = new ByteArrayOutputStream();
						     byte[] b = new byte[1024]; 
						     int len;
						     while((len = in.read(b)) != -1){
						         baos.write(b, 0, len);
						     }
						     pst.setBytes(7, baos.toByteArray());
							 pst.addBatch();
							 in.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 }
					
				 }
				 int[] count=pst.executeBatch();
				 logger.info("count(net_data_main_attachment) ===="+count.length);
				 conn.commit();  
			 }
		
		} catch (SQLException e1) {
			 try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			logger.info("上传文件保存异常");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally { 
			try{
				if(conn!=null){
					conn.close();
				}
				if(pst!=null){
					 pst.close();
				}
				if(stmt!=null){
					stmt.close();
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
