<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>医疗设备查询</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
	fieldset{border:solid 1px #aaa; padding:10px;} 
    </style>
</head>
<body>
	 <input id="lsh" name="lsh" class="mini-textbox"  vtype="maxLength:50" visible="false"  /> 
   <!-- <input id="dataid" name="dataid" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  visible="false"  />  --> 
    <div style="width:100%;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-add" onclick="addRow()" plain="true" tooltip="增加...">增加</a>
                        <a class="mini-button" iconCls="icon-remove" onclick="removeRow()" plain="true">删除</a>
                        <span class="separator"></span>
                        <a class="mini-button" iconCls="icon-save" onclick="saveData()" plain="true">保存</a>            
                    </td>
                </tr>
            </table>           
        </div>
    </div>
    <div id="datagrid1" class="mini-datagrid" style="width:100%;height:310px;" 
        url="<%=request.getContextPath()%>/work/f20010101/queryYlsb.action"  idField="id" 
        allowResize="true" 
        allowCellEdit="true" allowCellSelect="true" multiSelect="true" 
        editNextOnEnterKey="true"  editNextRowCell="true" 
        
    >
        <div property="columns">
         	<div type="checkcolumn" ></div> 
         	<div name="dataid" field="dataid" headerAlign="center" align="center"   ></div>   	
            <div name="data01"  field="data01" headerAlign="center" allowSort="true" width="50" >名称
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="50" />
            </div> 
            <div name="data02"  field="data02" headerAlign="center" allowSort="true" width="50" >数量
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="50" />
            </div>                      
        </div>
    </div>
    <script type="text/javascript">
        
        mini.parse();
		function SetData(data) {
			mini.get('lsh').setValue(data['lsh']);
			//mini.get('dataid').setValue(data['dataid']);
			query();
    	}
        var grid = mini.get("datagrid1");
        grid.hideColumn("dataid");
        //加载数据
		function query(){
		 	Web.util.load("datagrid1",{lsh:mini.get("lsh").getValue()});
		}
        function addRow() {          
            var newRow = { name: "New Row" };
            grid.addRow(newRow, 0);

            grid.beginEditCell(newRow, "LoginName");
        }
        /**function removeRow() {
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                grid.removeRows(rows, true);
            }
        }**/
         function removeRow() {
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                if(confirm("确定要删除数据吗？"))
				 {
				 	//var data = grid.getSelecteds();
		            var json = mini.encode(rows);
		            if(json!=null&&json!='[]'){
		            	$.ajax({
			                url: "<%=request.getContextPath() %>/work/f20010101/deleteDataListInfo.action",
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
            }
        }
        function saveData() {            
            var lsh=mini.get('lsh').getValue();
            //var dataid=mini.get('dataid').getValue();
           // var data = grid.getSelecteds();
            //var json = mini.encode(data);
            var data = grid.getChanges();
            var json = mini.encode(data);
            if(json!=null&&json!='[]'){
            	$.ajax({
	                url: "<%=request.getContextPath() %>/work/f20010101/saveDataListInfo.action",
	                data: { dataJson: json,lsh:lsh},
	                type: "post",
	                success: function (text) {
	                	if(text=='2'){
	                		alert("所有受理信息已经提交，不能再次新增！");
	                		return false;
	                	}
	                     alert('保存成功！');
	                    query();
	                },
	                error: function (jqXHR, textStatus, errorThrown) {
	                    alert(jqXHR.responseText);
			            //query();
	                }
	            });
            }else{
            	alert('没有要保存的信息');
            }
            
        }


       /** grid.on("celleditenter", function (e) {
            var index = grid.indexOf(e.record);
            if (index == grid.getData().length - 1) {
                var row = {};
                grid.addRow(row);
            }
        });

        grid.on("beforeload", function (e) {
            if (grid.getChanges().length > 0) {
                if (confirm("有增删改的数据未保存，是否取消本次操作？")) {
                    e.cancel = true;
                }
            }
        });
		**/


        
    </script>
</body>
</html>
