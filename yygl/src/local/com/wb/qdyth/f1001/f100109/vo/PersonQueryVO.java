package com.wb.qdyth.f1001.f100109.vo;

import com.wb.qdyth.f1001.common.vo.UserVO;




public class PersonQueryVO extends UserVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;            
	private String sbkh;//社保卡号         
	private String ylkzt;//银联卡状态
	private String ye;//卡金余额
	private String ckz004;//银联医疗结算号
	private String azz180;
	private String aaz500;
	private String aaz501;
	private String aaa030;

	public String getSbkh() {
		return sbkh;
	}

	public void setSbkh(String sbkh) {
		this.sbkh = sbkh;
	}

	public String getYlkzt() {
		return ylkzt;
	}

	public void setYlkzt(String ylkzt) {
		this.ylkzt = ylkzt;
	}

	public String getYe() {
		return ye;
	}

	public void setYe(String ye) {
		this.ye = ye;
	}

	public String getCkz004() {
		return ckz004;
	}

	public void setCkz004(String ckz004) {
		this.ckz004 = ckz004;
	}

	public String getAzz180() {
		return azz180;
	}

	public void setAzz180(String azz180) {
		this.azz180 = azz180;
	}

	public String getAaz500() {
		return aaz500;
	}

	public void setAaz500(String aaz500) {
		this.aaz500 = aaz500;
	}

	public String getAaz501() {
		return aaz501;
	}

	public void setAaz501(String aaz501) {
		this.aaz501 = aaz501;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAaa030() {
		return aaa030;
	}

	public void setAaa030(String aaa030) {
		this.aaa030 = aaa030;
	}
	

}
