package com.olivia.control;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class RolePlayer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public long getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(long identityCard) {
		this.identityCard = identityCard;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	//public List getList() {
	//	return list;
    //}
	//public void setList(List list) {
	//	this.list = list;
	//}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	@Column(nullable=true)
	private String userName;
	@Column(length=100)
	private String password;
	private int money;
	private long identityCard;
	private Date date;
	//private List<String> list=new ArrayList<String>();
	@Override
    public String toString(){
    	return this.userName+this.money;
    }
}
