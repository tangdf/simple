<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>许可证附件</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
	fieldset{border:solid 1px #aaa; padding:10px;} 
    </style>
</head>
<body>
	 <input id="lsh" name="lsh" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" visible="false"  /> 
   <!-- <input id="dataid" name="dataid" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  visible="false"  />  --> 
    <div style="width:100%;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-remove" onclick="removeRow()" plain="true">删除</a>         
                    </td>
                </tr>
            </table>           
        </div>
    </div>
      <div id="datagrid1" class="mini-datagrid" style="width:100%;height:150px; margin-top: 5px" 
             url="<%=request.getContextPath()%>/work/f20010103/queryXkzFjInfo.action"  allowResize="true"allowResize="true" 
        allowCellEdit="true" allowCellSelect="true" multiSelect="true" 
        editNextOnEnterKey="true"  editNextRowCell="true" onselectionchanged="onSelectionChanged"  >
		        <div property="columns"> 
		        <div field="fileid" width="70" headerAlign="center" align="center"  visible="false" >文件id</div>
		        <div field="file_name" width="100" headerAlign="center" align="center" >文件名</div> 
		</div>
	</div>
	<div id="unitinfoshow" align="center">
			     <img id="pic2" name="pic2"  alt="图片在此显示" style="height:1000px;width:800px" />
			</div>
    <script type="text/javascript">
        
        mini.parse();
		function SetData(data) {
			mini.get('lsh').setValue(data['lsh']);
			//mini.get('dataid').setValue(data['dataid']);
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

            var s ='<a href="<%=request.getContextPath()%>/work/f20010103/downloadAttachMent.action?fileid='+fileid+'&file_name='+file_name+'" >下载</a>';

         
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
        function showDetail(grid, rowIndex, columnIndex, e) {
		     var records = Wssip.grid.getGridSelectRows('psngrid',true);
		     if(records.length != 0){
			     var bdc246 = records[0].get('bdc246');
			     var url = "${pageContext.request.contextPath}/d1/f18050803/queryScanFileInfo.action?bdc246="+bdc246;
			     document.getElementById("pic2").src = url;
		     }
		 }
        function downloadFj(fileid,file_name) {
           $.ajax({
                url:  "<%=request.getContextPath() %>/work/f20010103/downloadAttachMent.action?fileid=" + fileid+"&file_name="+file_name,
                success: function (text) {
                	alert(111)
                   //grid.reload();
                   return text;
                 },
                 error: function () {
                 }
            });
        }
        //加载数据
		function query(){
		 	Web.util.load("datagrid1",{lsh:mini.get("lsh").getValue()});
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
			                url: "<%=request.getContextPath() %>/work/f20010103/deleteDataAttachMentInfo.action",
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
