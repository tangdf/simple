package com.wb.qdyth.common.bo;


import java.util.Date;


import org.apache.commons.lang.builder.ToStringBuilder;

import com.wb.jdbcutils.annos.Column;
import com.wb.jdbcutils.annos.Sequence;
import com.wb.jdbcutils.annos.Table;


/**
* Mobile_user_binding
*/
@Table(name="MOBILE_USER_BINDING")
public class MobileUserBinding  implements java.io.Serializable {

     private static final long serialVersionUID = 1L;
     private long mobile_user_binding_id;//人员编号
     private Long aac001;//人员编号
     private String aac147;//身份证号码
     private String m_phone;//手机号码(加密)
     private String m_mail;//必须要争邮箱格式
     private String address;//地址
     private Date createtime;//创建是时间
     private Date updatetime;//修改时间
     private String status;//有效状态
     private String aae103;//备注

     public MobileUserBinding(){
     }

     public MobileUserBinding(long mobile_user_binding_id,Long aac001,String aac147,String m_phone,String m_mail,String address,Date createtime,Date updatetime,String status,String aae103){
          this.mobile_user_binding_id = mobile_user_binding_id;
          this.aac001 = aac001;
          this.aac147 = aac147;
          this.m_phone = m_phone;
          this.m_mail = m_mail;
          this.address = address;
          this.createtime = createtime;
          this.updatetime = updatetime;
          this.status = status;
          this.aae103 = aae103;
     }

     @Sequence(name="SEQ_MOBILE_USER_BINDING_ID",sequencename="SEQ_MOBILE_USER_BINDING_ID")
     @Column(name = "MOBILE_USER_BINDING_ID",id=true)
     public long getMobile_user_binding_id(){
          return this.mobile_user_binding_id;
     }
     public void setMobile_user_binding_id(long mobile_user_binding_id){
          this.mobile_user_binding_id = mobile_user_binding_id;
     }

     @Column(name = "AAC001",  nullable = false,precision = 16, scale = 0)
     public Long getAac001(){
          return this.aac001;
     }
     public void setAac001(Long aac001){
          this.aac001 = aac001;
     }

     @Column(name = "AAC147", length = 18)
     public String getAac147(){
          return this.aac147;
     }
     public void setAac147(String aac147){
          this.aac147 = aac147;
     }

     @Column(name = "M_PHONE", length = 20)
     public String getM_phone(){
          return this.m_phone;
     }
     public void setM_phone(String m_phone){
          this.m_phone = m_phone;
     }

     @Column(name = "M_MAIL", length = 50)
     public String getM_mail(){
          return this.m_mail;
     }
     public void setM_mail(String m_mail){
          this.m_mail = m_mail;
     }

     @Column(name = "ADDRESS", length = 500)
     public String getAddress(){
          return this.address;
     }
     public void setAddress(String address){
          this.address = address;
     }

     @Column(name = "CREATETIME", length = 7)
     public Date getCreatetime(){
          return this.createtime;
     }
     public void setCreatetime(Date createtime){
          this.createtime = createtime;
     }

     @Column(name = "UPDATETIME", length = 7)
     public Date getUpdatetime(){
          return this.updatetime;
     }
     public void setUpdatetime(Date updatetime){
          this.updatetime = updatetime;
     }

     @Column(name = "STATUS", length = 2)
     public String getStatus(){
          return this.status;
     }
     public void setStatus(String status){
          this.status = status;
     }

     @Column(name = "AAE103", length = 500)
     public String getAae103(){
          return this.aae103;
     }
     public void setAae103(String aae103){
          this.aae103 = aae103;
     }

     @Override
     public String toString() {
          return ToStringBuilder.reflectionToString(this);
     }

}