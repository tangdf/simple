
package com.wb.qdyth.common.bo;

import java.sql.Blob;



import org.apache.commons.lang.builder.ToStringBuilder;

import com.wb.jdbcutils.annos.Column;
import com.wb.jdbcutils.annos.Table;


/**
* Net_data_main_attachment
*/
@Table(name="NET_DATA_MAIN_ATTACHMENT")
public class Net_data_main_attachment  {


     private String fileid;
     private String lsh;
     private String status;
     private String file_name;
     private String file_path;
     private String content_type;
     private Blob file_content;

     public Net_data_main_attachment(){
     }

     public Net_data_main_attachment(String fileid,String lsh,String status,String file_name,String file_path,String content_type, Blob file_content){
          this.fileid = fileid;
          this.lsh = lsh;
          this.status = status;
          this.file_name = file_name;
          this.file_path = file_path;
          this.content_type = content_type;
          this.file_content = file_content;
     }

     @Column(name = "FILEID",   nullable = false,length = 16)
     public String getFileid(){
          return this.fileid;
     }
     public void setFileid(String fileid){
          this.fileid = fileid;
     }

     @Column(name = "LSH", length = 16)
     public String getLsh(){
          return this.lsh;
     }
     public void setLsh(String lsh){
          this.lsh = lsh;
     }

     @Column(name = "STATUS", length = 3)
     public String getStatus(){
          return this.status;
     }
     public void setStatus(String status){
          this.status = status;
     }

     @Column(name = "FILE_NAME", length = 200)
     public String getFile_name(){
          return this.file_name;
     }
     public void setFile_name(String file_name){
          this.file_name = file_name;
     }

     @Column(name = "FILE_PATH", length = 200)
     public String getFile_path(){
          return this.file_path;
     }
     public void setFile_path(String file_path){
          this.file_path = file_path;
     }

     @Column(name = "CONTENT_TYPE", length = 200)
     public String getContent_type(){
          return this.content_type;
     }
     public void setContent_type(String content_type){
          this.content_type = content_type;
     }

     public Blob getFile_content(){
          return this.file_content;
     }
     public void setFile_content(Blob file_content){
          this.file_content = file_content;
     }

     @Override
     public String toString() {
          return ToStringBuilder.reflectionToString(this);
     }

}
