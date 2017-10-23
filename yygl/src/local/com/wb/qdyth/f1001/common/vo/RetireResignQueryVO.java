package com.wb.qdyth.f1001.common.vo;

import java.math.BigDecimal;

public class RetireResignQueryVO {
	private String aac001;//个人编号 
	private String aac003;//姓名     
	private String an_aae001;//页面年度
	private String aab001;
	private String aab004;//单位名称
	private String aac082;//退休类别
	private String aic162;//退休时间
	private String aac006;//出生日期
	private String aac007;//参加工作时间	
	private String aic230;//离退休待遇类别
	private String aic231;//开始年月
	private BigDecimal aic142;//养老待遇金额
	private BigDecimal aic003;//基本养老金
	private BigDecimal aic111;//普调固定
	private BigDecimal aic112;//普调比例
	private BigDecimal xj;//小计
	private BigDecimal aic113;//1949参加革命工作
	private BigDecimal aic114;//高级职称增加
	private BigDecimal aic115;//军转干增加
	private BigDecimal aic116;//工商业者
	private BigDecimal aic117;//年龄增加
	private BigDecimal aic110;//月增合计
	private BigDecimal aic121;//工龄增加
	private String aic008;//军转干标志
	private Integer aae001;//页面年度
	private Long bfys;//补发月数
	private BigDecimal bfhj;//补发合计
	//养老外待遇
	private String aic231w;//开始年月
	private Long aic142w;//养老待遇金额
	private String aic230w;//离退休待遇类别
	private BigDecimal aae019sum;//调待前月基本养老金小计 
	private BigDecimal aae019sumexc;//调待前月基本养老金外小计 
	private BigDecimal aae019sumall;//本次调待前月养老金合计 
	private String now_date;
	public String getAac001() {
		return aac001;
	}
	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}
	public String getAac003() {
		return aac003;
	}
	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}
	public String getAn_aae001() {
		return an_aae001;
	}
	public void setAn_aae001(String anAae001) {
		an_aae001 = anAae001;
	}
	public String getAab001() {
		return aab001;
	}
	public void setAab001(String aab001) {
		this.aab001 = aab001;
	}
	public String getAab004() {
		return aab004;
	}
	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}
	public String getAac082() {
		return aac082;
	}
	public void setAac082(String aac082) {
		this.aac082 = aac082;
	}
	public String getAic162() {
		return aic162;
	}
	public void setAic162(String aic162) {
		this.aic162 = aic162;
	}
	public String getAac006() {
		return aac006;
	}
	public void setAac006(String aac006) {
		this.aac006 = aac006;
	}
	public String getAac007() {
		return aac007;
	}
	public void setAac007(String aac007) {
		this.aac007 = aac007;
	}
	public String getAic230() {
		return aic230;
	}
	public void setAic230(String aic230) {
		this.aic230 = aic230;
	}
	public String getAic231() {
		return aic231;
	}
	public void setAic231(String aic231) {
		this.aic231 = aic231;
	}
	public BigDecimal getAic142() {
		return aic142;
	}
	public void setAic142(BigDecimal aic142) {
		this.aic142 = aic142;
	}
	public BigDecimal getAic003() {
		return aic003;
	}
	public void setAic003(BigDecimal aic003) {
		this.aic003 = aic003;
	}
	public BigDecimal getAic111() {
		return aic111;
	}
	public void setAic111(BigDecimal aic111) {
		this.aic111 = aic111;
	}
	public BigDecimal getAic112() {
		return aic112;
	}
	public void setAic112(BigDecimal aic112) {
		this.aic112 = aic112;
	}
	public BigDecimal getXj() {
		return xj;
	}
	public void setXj(BigDecimal xj) {
		this.xj = xj;
	}
	public BigDecimal getAic113() {
		return aic113;
	}
	public void setAic113(BigDecimal aic113) {
		this.aic113 = aic113;
	}
	public BigDecimal getAic114() {
		return aic114;
	}
	public void setAic114(BigDecimal aic114) {
		this.aic114 = aic114;
	}
	public BigDecimal getAic115() {
		return aic115;
	}
	public void setAic115(BigDecimal aic115) {
		this.aic115 = aic115;
	}
	public BigDecimal getAic116() {
		return aic116;
	}
	public void setAic116(BigDecimal aic116) {
		this.aic116 = aic116;
	}
	public BigDecimal getAic117() {
		return aic117;
	}
	public void setAic117(BigDecimal aic117) {
		this.aic117 = aic117;
	}
	public String getAic008() {
		return aic008;
	}
	public void setAic008(String aic008) {
		this.aic008 = aic008;
	}
	public Integer getAae001() {
		return aae001;
	}
	public void setAae001(Integer aae001) {
		this.aae001 = aae001;
	}
	public Long getBfys() {
		return bfys;
	}
	public void setBfys(Long bfys) {
		this.bfys = bfys;
	}
	public BigDecimal getBfhj() {
		return bfhj;
	}
	public void setBfhj(BigDecimal bfhj) {
		this.bfhj = bfhj;
	}
	public String getAic231w() {
		return aic231w;
	}
	public void setAic231w(String aic231w) {
		this.aic231w = aic231w;
	}
	public Long getAic142w() {
		return aic142w;
	}
	public void setAic142w(Long aic142w) {
		this.aic142w = aic142w;
	}
	public String getAic230w() {
		return aic230w;
	}
	public void setAic230w(String aic230w) {
		this.aic230w = aic230w;
	}
	public BigDecimal getAic110() {
		return aic110;
	}
	public void setAic110(BigDecimal aic110) {
		this.aic110 = aic110;
	}
	public BigDecimal getAae019sum() {
		return aae019sum;
	}
	public void setAae019sum(BigDecimal aae019sum) {
		this.aae019sum = aae019sum;
	}
	public BigDecimal getAae019sumexc() {
		return aae019sumexc;
	}
	public void setAae019sumexc(BigDecimal aae019sumexc) {
		this.aae019sumexc = aae019sumexc;
	}
	public BigDecimal getAae019sumall() {
		return aae019sumall;
	}
	public void setAae019sumall(BigDecimal aae019sumall) {
		this.aae019sumall = aae019sumall;
	}
	public String getNow_date() {
		return now_date;
	}
	public void setNow_date(String nowDate) {
		now_date = nowDate;
	}
	public BigDecimal getAic121() {
		return aic121;
	}
	public void setAic121(BigDecimal aic121) {
		this.aic121 = aic121;
	}
	
}
