package com.olivia.control.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Party implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id @GeneratedValue(strategy=GenerationType.AUTO)
private int code;
@Column(length=100,nullable=false)
private  String partyName;
@Column(length=50,nullable=false)
private int level;
private long buildTime;
@Column(length=255)
private String description;
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getPartyName() {
	return partyName;
}
public void setPartyName(String partyName) {
	this.partyName = partyName;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public long getBuildTime() {
	return buildTime;
}
public void setBuildTime(long buildTime) {
	this.buildTime = buildTime;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
