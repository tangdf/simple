package com.wb.qdyth.common.bo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
* Dfjgsj
*/
@Entity
@Table(name="DFJGSJ")
public class DfJgsj {

     private static final long serialVersionUID = 1L;
     private long userid;//
     private String mj;//面积
     private String ys;//医师人数
     private String gjys;//高级医师人数
     private String yj;//医技人数
     private String hs;//护士人数
     private String zjhs;//中级护士人数
     private String wj;//卫技人数
     private String data01;//状态 0：老数据1：新数据
     private String data02;//插入时间
     private String data03;//
     private String data04;//
     private String data05;//
     private String cws;//床位数
     private String zysj;//执业开始时间

     @Id
     @Column(name = "USERID",  unique = true, nullable = false,precision = 16, scale = 0)
     public long getUserid(){
          return this.userid;
     }
     public void setUserid(long userid){
          this.userid = userid;
     }

     @Column(name = "MJ", length = 100)
     public String getMj(){
          return this.mj;
     }
     public void setMj(String mj){
          this.mj = mj;
     }

     @Column(name = "YS", length = 100)
     public String getYs(){
          return this.ys;
     }
     public void setYs(String ys){
          this.ys = ys;
     }

     @Column(name = "GJYS", length = 100)
     public String getGjys(){
          return this.gjys;
     }
     public void setGjys(String gjys){
          this.gjys = gjys;
     }

     @Column(name = "YJ", length = 100)
     public String getYj(){
          return this.yj;
     }
     public void setYj(String yj){
          this.yj = yj;
     }

     @Column(name = "HS", length = 100)
     public String getHs(){
          return this.hs;
     }
     public void setHs(String hs){
          this.hs = hs;
     }

     @Column(name = "ZJHS", length = 100)
     public String getZjhs(){
          return this.zjhs;
     }
     public void setZjhs(String zjhs){
          this.zjhs = zjhs;
     }

     @Column(name = "WJ", length = 100)
     public String getWj(){
          return this.wj;
     }
     public void setWj(String wj){
          this.wj = wj;
     }

     @Column(name = "DATA01", length = 100)
     public String getData01(){
          return this.data01;
     }
     public void setData01(String data01){
          this.data01 = data01;
     }

     @Column(name = "DATA02", length = 100)
     public String getData02(){
          return this.data02;
     }
     public void setData02(String data02){
          this.data02 = data02;
     }

     @Column(name = "DATA03", length = 100)
     public String getData03(){
          return this.data03;
     }
     public void setData03(String data03){
          this.data03 = data03;
     }

     @Column(name = "DATA04", length = 100)
     public String getData04(){
          return this.data04;
     }
     public void setData04(String data04){
          this.data04 = data04;
     }

     @Column(name = "DATA05", length = 100)
     public String getData05(){
          return this.data05;
     }
     public void setData05(String data05){
          this.data05 = data05;
     }
     
     @Column(name = "CWS", length = 100)
     public String getCws() {
		return this.cws;
	 }
	 public void setCws(String cws) {
		this.cws = cws;
	 }
	 
	 @Column(name = "ZYSJ", length = 100)
     public String getZysj() {
		return this.zysj;
	 }
	 public void setZysj(String zysj) {
		this.zysj = zysj;
	 }
	@Override
     public String toString() {
          return ToStringBuilder.reflectionToString(this);
     }

}