package com.wb.qdyth.common.bo;

import com.wb.jdbcutils.annos.Callable;
import com.wb.jdbcutils.annos.In;
import com.wb.jdbcutils.annos.Out;

@Callable
public class SpUpdatePasswordSPDTO {

	@In(order =1)
	private String userid;//USERID   
	@In(order =2)
	private String groupid;//GROUPID 
	@In(order =3)
	private Long userkey;//USERKEY 
	@In(order =4)
	private String loginname;//LOGINNAME;// 
	@In(order =5)
	private String password;//PASSWORD 
	@In(order =6)
	private String newpassword;
	@Out(order =7)
	private Integer retcod;
	@Out(order =8)
	private String retmsg;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public Long getUserkey() {
		return userkey;
	}
	public void setUserkey(Long userkey) {
		this.userkey = userkey;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public Integer getRetcod() {
		return retcod;
	}
	public void setRetcod(Integer retcod) {
		this.retcod = retcod;
	}
	public String getRetmsg() {
		return retmsg;
	}
	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}
}
