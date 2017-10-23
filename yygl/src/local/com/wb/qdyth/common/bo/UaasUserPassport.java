/**
 *UaasUser.java
 *Sep 23, 2007
 */
package com.wb.qdyth.common.bo;

import java.util.Date;

import com.wb.jdbcutils.annos.Column;
import com.wb.jdbcutils.annos.Table;

/**
 * 
 * @author xue
 *
 */
@Table(name = "UAAS_USER_PASSPORT")
public class UaasUserPassport implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long userid;
	private String userkey;
	private String loginname;
	private String question1;
	private String answer1;
	private String question2;
	private String answer2;
	private Date cdate;
	@Column(name = "USERID",id= true)
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	@Column(name = "USERKEY")
	public String getUserkey() {
		return userkey;
	}
	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}
	@Column(name = "LOGINNAME")
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	@Column(name = "QUESTION1")
	public String getQuestion1() {
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	@Column(name = "ANSWER1")
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	@Column(name = "QUESTION2")
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	@Column(name = "ANSWER2")
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	@Column(name = "CDATE")
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
}
