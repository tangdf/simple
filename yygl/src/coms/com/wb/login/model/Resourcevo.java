package com.wb.login.model;

public class Resourcevo implements java.io.Serializable{
	Long resourceid;
	Long domainid;
	Long parentresourceid;
	String code;
	String name;
	String url;
	Long priority;
	Integer status;
	String resourcetype;
	Long id;
	Long pid;
	String text;
	String iconCls;
	public Long getResourceid() {
		return resourceid;
	}
	public void setResourceid(Long resourceid) {
		this.resourceid = resourceid;
	}
	public Long getDomainid() {
		return domainid;
	}
	public void setDomainid(Long domainid) {
		this.domainid = domainid;
	}
	public Long getParentresourceid() {
		return parentresourceid;
	}
	public void setParentresourceid(Long parentresourceid) {
		this.parentresourceid = parentresourceid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getPriority() {
		return priority;
	}
	public void setPriority(Long priority) {
		this.priority = priority;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getResourcetype() {
		return resourcetype;
	}
	public void setResourcetype(String resourcetype) {
		this.resourcetype = resourcetype;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
}
