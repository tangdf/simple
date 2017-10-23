package com.wb.user.model;

import java.util.Date;


public class UaasUpdaVO {
	private Long uers_id;
	private Long groupid;
	private String userkey;
	private String loginname;
	private String passwords;
	private Date cdate;
	private String aae013;
	public Long getUers_id() {
		return uers_id;
	}
	public void setUers_id(Long uersId) {
		uers_id = uersId;
	}
	public Long getGroupid() {
		return groupid;
	}
	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}
	public String getUserkey() {
		return userkey;
	}
	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getAae013() {
		return aae013;
	}
	public void setAae013(String aae013) {
		this.aae013 = aae013;
	}
}
