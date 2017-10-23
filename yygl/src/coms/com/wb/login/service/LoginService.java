package com.wb.login.service;

import java.util.List;

import com.wb.jdbcutils.CommonJdbcUtils;
import com.wb.login.model.LogLoginBO;
import com.wb.login.model.LoginSpDTO;
import com.wb.login.model.Resourcevo;
import com.wb.qdyth.common.bo.UaasUserPassport;
import com.wb.user.model.UaasUserVO;

public interface LoginService {
	public UaasUserVO getUser(String domain, String Loginname, String password);
	public UaasUserVO getUserByUserId(String Userid);
	public List<UaasUserVO> getUsersByUserId(String Userid);
	public List<Resourcevo> getParentResourceByUserid(Long userid, String application);
	public List<Resourcevo> getPubParentResourceByUserid(String application,String resourcetype);
	public List<Resourcevo> getResourceByResourceidAndResourceType(Long resourceid, String application,String resourcetype);
	public List<Resourcevo> getResourceByResourceid(Long resourceid, String application,String groupid);
	public List<Resourcevo> getResourceByResourceids(Long resourceid, String application,List<String> groupids);
	public Resourcevo getUrlByResourceid(Long resourceid, String application);
	public Resourcevo getResourceByResourceid(Long resourceid);
	/**
	 * 调用登陆后台
	 * @param dto
	 */
	public void callLoginSP(LoginSpDTO dto);
	/**
	 * 记录登陆日志 
	 * @param bo
	 */
	public void saveLoginLog(LogLoginBO bo);
}
