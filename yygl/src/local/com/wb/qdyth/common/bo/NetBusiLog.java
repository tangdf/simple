package com.wb.qdyth.common.bo;


import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.wb.jdbcutils.annos.Column;
import com.wb.jdbcutils.annos.Sequence;
import com.wb.jdbcutils.annos.Table;

@Table(name="NET_BUSILOG"
)
public class NetBusiLog {


     private Long logid;
     private Long lsh;
     private String userid;
     private Date time;
     private String busiid;
     private String opttype;
     private String link;
     private String clzt;
     private String memo;
    
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	@Sequence(name="SEQUENCE", sequencename="SEQ_NET_ID")
	@Column(id=true,name="logid")
	public Long getLogid() {
		return logid;
	}
	public void setLogid(Long logid) {
		this.logid = logid;
	}

	@Column(name="LSH")
	public Long getLsh() {
		return lsh;
	}

	public void setLsh(Long lsh) {
		this.lsh = lsh;
	}

	@Column(name="USERID")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name="TIME")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name="BUSIID")
	public String getBusiid() {
		return busiid;
	}

	public void setBusiid(String busiid) {
		this.busiid = busiid;
	}

	@Column(name="OPTTYPE")
	public String getOpttype() {
		return opttype;
	}

	public void setOpttype(String opttype) {
		this.opttype = opttype;
	}
	
	@Column(name="LINK")
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name="CLZT")
	public String getClzt() {
		return clzt;
	}

	public void setClzt(String clzt) {
		this.clzt = clzt;
	}

	@Column(name="MEMO", length=200)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}


