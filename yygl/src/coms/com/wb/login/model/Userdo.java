package com.wb.login.model;

import com.wb.jdbcutils.annos.Column;
import com.wb.jdbcutils.annos.Sequence;
import com.wb.jdbcutils.annos.Table;

@Table(name="APP_USER")
public class Userdo implements java.io.Serializable{
	private Long userid;
	private String loginname;
	private String password;
	private String name;
	private Long domainid;
	private String sex;
	private String telephone;
	private String address;
	private String fax;
	private String email;
	private int admin;
	private int status;
	
	@Sequence(name="SEQUENCE",sequencename="SEQ_APP_USERID")
	@Column(id=true,name="USERID")
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	@Column(name="DOMAINID")
	public Long getDomainid() {
		return domainid;
	}
	public void setDomainid(Long domainid) {
		this.domainid = domainid;
	}
	
	@Column(name="SEX", length=1)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name="TELEPHONE", length=100)
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Column(name="ADDRESS", length=500)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="FAX", length=100)
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Column(name="EMAIL", length=500)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="STATUS")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(name="NAME", length=200)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="ADMIN")
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	@Column(name="LOGINNAME", length=100)
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	@Column(name="PASSWORD", length=300)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
