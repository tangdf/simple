<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>量化评分表附件</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
	fieldset{border:solid 1px #aaa; padding:10px;} 
    </style>
</head>
<body>
	<!-- <input id="lsh" name="lsh" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" visible="false"  />  --> 
   <!-- <input id="dataid" name="dataid" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  visible="false"  />  --> 
		<div id="div1" style="display:none">
			执业开始时间: <input name="data26s" id="data26s" class="mini-datepicker"  dateFormat="yyyyMMdd" />
			&emsp;执业终止时间: <input name="data25" id="data25" class="mini-datepicker"  dateFormat="yyyyMMdd" />
		</div>
       	<div id="div2" style="display:none">开始营业时间 : <input name="data26" id="data26" class="mini-datepicker"  dateFormat="yyyyMMdd" /> </div>
        <div id="div3" style="display:none">
        医院等级 : <input id="data27" name="data27" class="mini-combobox" style="width:100px;" textField="text" valueField="id" emptyText="请选择..."
				       data="[{id:'1',text:'一级'},{id:'2',text:'二级'},{id:'3',text:'三级'},{id:'4',text:'社区'}]"  allowInput="true" showNullItem="true" nullItemText="请选择..."/> 	
        </div>
        <div id="div4" style="display:none">
        建筑面积（平方米） : <input id="data28" name="data28" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"    /> 
        </div>
    <input id="data10" name="data10" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" visible="false"   /> 
    <input id="data01" name="data01" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" visible="false"   /> 
      <div id="datagrid1" class="mini-datagrid" style="width:100%;height:150px; margin-top: 5px" 
             url="<%=request.getContextPath()%>/work/f20010118/queryPfbFjInfo.action"  allowResize="true"allowResize="true" 
        allowCellEdit="true" allowCellSelect="true" multiSelect="true" 
        editNextOnEnterKey="true"  editNextRowCell="true"  onselectionchanged="onSelectionChanged" >
		        <div property="columns">
		      <!--    <div name="action" width="120" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;">#</div>-->
		        <div field="fileid" width="70" headerAlign="center" align="center"  visible="false" >文件id</div>
		        <div field="file_name" width="100" headerAlign="center" align="center" >文件名</div> 
		</div>
	</div>
	<div id="unitinfoshow" align="center">
			     <img id="pic2" name="pic2"  alt="图片在此显示" style="height:1000px;width:800px"/>
			</div>
    <script type="text/javascript">
        
        mini.parse();
       // var form = new mini.Form("#form1");
		function SetData(data) {
			//mini.get('lsh').setValue(data['lsh']);
			mini.get('data10').setValue(data['data10']);
			mini.get('data01').setValue(data['data01']);
			query();
    	}
        var grid = mini.get("datagrid1");
       // grid.hideColumn("fileid");
        function onActionRenderer(e) {
            var grid = e.sender;
            var record = e.record;
            var fileid = record.fileid;
            var file_name = record.file_name;
            var rowIndex = e.rowIndex;

            var s = 
              '<a href="<%=request.getContextPath()%>/work/f20010118/downloadAttachMent.action?fileid='+fileid+'&file_name='+file_name+'" >下载</a>';

         
            return s;
        }
        function onSelectionChanged(e) {
        
            var grid = e.sender;
            var record = grid.getSelected();
            var fileid = record.fileid;
            var file_name = record.file_name;
            if (record) {
            	 var url ='<%=request.getContextPath()%>/work/f20010103/downloadAttachMent.action?fileid='+fileid+'&file_name='+file_name;
			     document.getElementById("pic2").src = url;
            }
        }
        //加载数据
		function query(){
			var busiid=mini.get("data10").getValue();
			var data01=mini.get("data01").getValue();
		 	Web.util.load("datagrid1",{busiid :busiid,data01:data01});
		 	if(busiid=='200103'){
		 		 var url = '<%=request.getContextPath()%>/work/f20010103/queryXkzInfo.action';
				 Web.util.request(url,'POST',{},
					function(data){
						if(data!=null&&data!=''){
							var data1 = mini.decode(data); 
							mini.get('data25').setValue(data1.data25);
							mini.get('data26s').setValue(data1.data26);
							document.getElementById("div1").style.display="";
							document.getElementById("div0").style.display="";
						}
					}
				);
		 	}else if(busiid=='200105'){
		 		 var url = '<%=request.getContextPath()%>/work/f20010105/queryYyzzInfo.action';
				 Web.util.request(url,'POST',{},
					function(data){
						if(data!=null&&data!=''){
							var data1 = mini.decode(data); 
							mini.get('data26').setValue(data1.data25);
							document.getElementById("div2").style.display="";
						}
					}
				);
		 	}else if(busiid=='200106'){
		 		  var url = '<%=request.getContextPath()%>/work/f20010106/queryYydjInfo.action';
				 Web.util.request(url,'POST',{},
					function(data){
						if(data!=null&&data!=''){
							var data1 = mini.decode(data); 
							mini.get('data27').setValue(data1.data25);
							document.getElementById("div3").style.display="";
						}
					}
				);
		 	}else if(busiid=='200107'){
		 		  var url = '<%=request.getContextPath()%>/work/f20010107/queryYlfwInfo.action';
				 Web.util.request(url,'POST',{},
					function(data){
						if(data!=null&&data!=''){
							var data1 = mini.decode(data); 
							mini.get('data28').setValue(data1.data25);
							document.getElementById("div4").style.display="";
						}
					}
				);
		 	}
		 	
		}
         function removeRow() {
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                if(confirm("确定要删除数据吗？"))
				 {
				 	//var data = grid.getSelecteds();
		            var json = mini.encode(rows);
		            if(json!=null&&json!='[]'){
		            	$.ajax({
			                url: "<%=request.getContextPath() %>/work/f20010117/deleteDataAttachMentInfo.action",
			                data: { dataJson: json},
			                type: "post",
			                success: function (text) {
			                	alert('删除成功！');
			                    query();
			                },
			                error: function (jqXHR, textStatus, errorThrown) {
			                    alert(jqXHR.responseText);
			                    //alert('删除成功！');
			                    //query();
			                }
			            });
		            }
				}
            }else{
            	alert('请选择要删除的数据');
            	return false;
            }
        }
       


        
    </script>
</body>
</html>
