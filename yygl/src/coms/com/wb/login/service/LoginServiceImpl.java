package com.wb.login.service;

import java.util.ArrayList;
import java.util.List;

import com.wb.jdbcutils.CommonJdbcUtils;
import com.wb.login.model.LogLoginBO;
import com.wb.login.model.LoginSpDTO;
import com.wb.login.model.Resourcevo;
import com.wb.qdyth.common.bo.UaasUserPassport;
import com.wb.user.model.UaasUserVO;

public class LoginServiceImpl implements LoginService{
	public UaasUserVO getUser(String domain, String Loginname, String password){
		String sql = "select a.*,b.USERKEY,b.GROUPID from uaas_user a,uaas_upda b WHERE a.ID=b.UERS_ID AND a.loginname=? and password=? and a.status=1";
		return CommonJdbcUtils.queryFirst(sql,UaasUserVO.class,Loginname,password);
	}
	public UaasUserVO getUserByUserId(String Userid){
		String sql = "select a.*,b.USERKEY,b.GROUPID from uaas_user a,uaas_upda b WHERE a.ID=b.UERS_ID AND a.id=? and a.status=1";
		return CommonJdbcUtils.queryFirst(sql,UaasUserVO.class,Userid);
	}
	public List<UaasUserVO> getUsersByUserId(String Userid){
		String sql = "select a.*,b.USERKEY,b.GROUPID from uaas_user a,uaas_upda b WHERE a.ID=b.UERS_ID AND a.id=? and a.status=1";
		return CommonJdbcUtils.query(sql,UaasUserVO.class,Userid);
	}
	public List<Resourcevo> getParentResourceByUserid(Long userid, String application){
		String sql = "select a.RESOURCEID id,a.name text,a.icon1 iconCls from app_resource a, app_permission b, UAAS_UPDA c "+
					 "where a.resourceid=b.resourceid and b.groupid=c.groupid "+
					 "and c.UERS_ID=? and a.appid=? and nvl(a.domainid,0)<>-1  and b.status=1 and a.status=1 and a.parentresourceid is null " +
					 "order by priority";
		return CommonJdbcUtils.query(sql, Resourcevo.class, userid, application);
		
	}
	public List<Resourcevo> getPubParentResourceByUserid(String application,String resourcetype){
		String sql = "SELECT RESOURCEID id,name text,icon1 iconCls FROM APP_RESOURCE WHERE resourcetype=? and nvl(domainid,0)<>-1 " +
				"and status=1 AND appid=? AND parentresourceid IS NULL ORDER BY PRIORITY ";
		return CommonJdbcUtils.query(sql, Resourcevo.class, resourcetype,application);
	}
	
	public List<Resourcevo> getResourceByResourceidAndResourceType(Long resourceid, String application,String resourcetype){
		String sql = "SELECT RESOURCEID id,PARENTRESOURCEID pid,name text,icon1 iconCls,URL FROM " +
				"( select * FROM app_resource WHERE PARENTresourceid=? and resourcetype=? " +
				"AND appid=? and status=1 " +
				"UNION select * FROM app_resource WHERE  " +
				"PARENTresourceid in(select resourceid FROM app_resource " +
				"WHERE PARENTresourceid=? AND appid=? and resourcetype=? and status=1 ) " +
				"and resourcetype=?) ORDER BY parentresourceid,priority";
		return CommonJdbcUtils.query(sql, Resourcevo.class, resourceid, resourcetype,application,resourceid,application,resourcetype,resourcetype);
	}
	public List<Resourcevo> getResourceByResourceid(Long resourceid, String application,String groupid){
		String sql = "SELECT RESOURCEID id,PARENTRESOURCEID pid,name text,icon1 iconCls,url url FROM " +
		        "( select app_resource.* FROM app_resource,app_permission WHERE APP_RESOURCE.resourceid=app_permission.resourceid AND app_permission.groupid=? AND app_permission.status='1' and PARENTresourceid=?  " +
		        "AND appid=? and app_resource.status=1 " +
		        "UNION select * FROM app_resource WHERE  " +
		        "PARENTresourceid in(select app_resource.resourceid FROM app_resource,app_permission " +
		        "WHERE APP_RESOURCE.resourceid=app_permission.resourceid AND app_permission.groupid=? AND app_permission.status='1' and PARENTresourceid=? AND appid=?  and app_resource.status=1 ) " +
		        ")   ORDER BY parentresourceid,priority";
		return CommonJdbcUtils.query(sql, Resourcevo.class, groupid,resourceid,application,groupid,resourceid,application);
	}
	public List<Resourcevo> getResourceByResourceids(Long resourceid, String application,List<String> groupids){
		List<Resourcevo> returnVos=new ArrayList<Resourcevo>();
		for (String groupid:groupids){
			returnVos.addAll(getResourceByResourceid(resourceid,  application, groupid));
		} 
		return returnVos;
	}
	public Resourcevo getUrlByResourceid(Long resourceid, String application){
		String sql = "select url,name from app_resource where resourceid=? and appid=? and status=1";
		return CommonJdbcUtils.queryObject(sql, Resourcevo.class, resourceid, application);
	}
	public Resourcevo getResourceByResourceid(Long resourceid){
		String sql = "select url,name,RESOURCETYPE from app_resource where resourceid=?";
		return CommonJdbcUtils.queryObject(sql, Resourcevo.class, resourceid);
	}
	/**
	 * 调用登陆后台
	 * @param dto
	 */
	public void callLoginSP(LoginSpDTO dto){
		CommonJdbcUtils.call(dto);
	}
	/**
	 * 记录登陆日志 
	 * @param bo
	 */
	public void saveLoginLog(LogLoginBO bo){
		CommonJdbcUtils.save(bo);
	}
}
