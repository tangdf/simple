package com.wb.qdyth.f1001.f100109.vo;

public class RetMessageHead {
	private String trxtype;//交易类型
	private String lgntype;//登录身份类型
	private String retcode;//响应代码
	private String lgninstcode;//登录机构代码
	private String lgnpartner;//分行代码
	private String lgnmerchcode;//登录网点代码
	private String lgnusercode;//登录操作员代码
	private String term_trace;//端末流水号
	
	public String getTrxtype() {
		return trxtype;
	}
	public void setTrxtype(String trxtype) {
		this.trxtype = trxtype;
	}
	public String getLgntype() {
		return lgntype;
	}
	public void setLgntype(String lgntype) {
		this.lgntype = lgntype;
	}
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	public String getLgninstcode() {
		return lgninstcode;
	}
	public void setLgninstcode(String lgninstcode) {
		this.lgninstcode = lgninstcode;
	}
	public String getLgnpartner() {
		return lgnpartner;
	}
	public void setLgnpartner(String lgnpartner) {
		this.lgnpartner = lgnpartner;
	}
	public String getLgnmerchcode() {
		return lgnmerchcode;
	}
	public void setLgnmerchcode(String lgnmerchcode) {
		this.lgnmerchcode = lgnmerchcode;
	}
	public String getLgnusercode() {
		return lgnusercode;
	}
	public void setLgnusercode(String lgnusercode) {
		this.lgnusercode = lgnusercode;
	}
	public String getTerm_trace() {
		return term_trace;
	}
	public void setTerm_trace(String termTrace) {
		term_trace = termTrace;
	}
	
}
