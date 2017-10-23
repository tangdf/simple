package com.wb.login.model;

import com.wb.jdbcutils.annos.Column;
import com.wb.jdbcutils.annos.Sequence;
import com.wb.jdbcutils.annos.Table;

@Table(name="APP_ORGAN_NODE")
public class OrganNodedo implements java.io.Serializable{
	private Long nodeid;
	private Long parentnodeid;
	private Long nodetypeid;
	private Long domainid;
	private Long groupid;
	private String value;
	private String name;
	private String description;
	private int status;
	
	@Sequence(name="SEQUENCE", sequencename="SEQ_APP_NODEID")
	@Column(id=true,name="NODEID")
	public Long getNodeid() {
		return nodeid;
	}
	public void setNodeid(Long nodeid) {
		this.nodeid = nodeid;
	}
	
	@Column(name="PARENTNODEID")
	public Long getParentnodeid() {
		return parentnodeid;
	}
	public void setParentnodeid(Long parentnodeid) {
		this.parentnodeid = parentnodeid;
	}
	
	@Column(name="NODETYPEID")
	public Long getNodetypeid() {
		return nodetypeid;
	}
	public void setNodetypeid(Long nodetypeid) {
		this.nodetypeid = nodetypeid;
	}
	
	@Column(name="DOMAINID")
	public Long getDomainid() {
		return domainid;
	}
	public void setDomainid(Long domainid) {
		this.domainid = domainid;
	}
	
	@Column(name="GROUPID")
	public Long getGroupid() {
		return groupid;
	}
	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}
	
	@Column(name="VALUE", length=100)
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Column(name="NAME", length=100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="DESCRIPTION", length=300)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="STATUS")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
