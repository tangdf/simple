<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>医师信息查询</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/miniui/jquery.form.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
	fieldset{border:solid 1px #aaa; padding:10px;} 
    </style>
</head>
<body>
	<fieldset id="fd2" style="width: 97%">
        <legend><span>查询条件</span></legend>
        <div class="fieldset-body">
        <div id="form1">
          <table class="form-table" border="0" cellpadding="1"  cellspacing="4">
           <colgroup align="right" width="8%"></colgroup>
           <colgroup align="left" width="18%"></colgroup>
          <colgroup align="right" width="5%"></colgroup>
           <colgroup align="left" width="5%"></colgroup>
             <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="20%"></colgroup>
          <colgroup align="left" width="13%"></colgroup>
                <tr>
                    <td class="form-label">姓名:</td>
                    <td>
                       <input id="data01" name="data01" class="mini-textbox" style="width:150px;"  vtype="maxLength:100"  /> 
                    </td>
                    <td class="form-label"></td>
                    <td>
                     <input id="lsh" name="lsh" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" visible="false"  /> 
                    </td>
                    <td class="form-label">身份证号：</td>
                    <td>
                          <input id="data02" name="data02" class="mini-textbox" style="width:150px;"  vtype="maxLength:100" /> 
                    </td>
                      <td>
	                <input value="查询" type="button" onclick="query();" />
	            </td>
                </tr>
            </table>
            </div>
        </div>
    </fieldset>
    <div>
    
    <table style="width:100%">
    <tr style="width:100%"  align="left">
    <td style="width:100%" colspan="2">
    <div>
	<font color="red" size="3">操作前请下载最新模板</font> 
	<br/><a href="<%=request.getContextPath()%>/file/model.xls" class="download" style="font-size: 15px;">导入表格模板下载</a> 
	</div>
    </td>
    </tr>
    <tr align="left">
    <td align="left">
    <form method="post" enctype="multipart/form-data" name="uploadForm" id="uploadForm" 
		action="<%=request.getContextPath()%>/work/f20010108/importYs.action" target="hidden_frame">  
		<table>  
		 <tr> 
			<td>上传文件: </td>  
			<td><input id="upfile" type="file" name="upfile"></td>   
			<td><input type="button" value="提交" onclick="checkData()"></td>  
			<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
		 </tr>  
		</table> 
	</form>
    </td>
    </tr>
    
    </table>
    
	
	</div>
	
	<fieldset id="fd3" style="width: 97%">
		<legend><span>信息列表</span></legend>
	<div class="fieldset-body" style="width:750px;">
	<div class="mini-tabs" activeIndex="0"  style="width:750px;height:280px;" id="tabs">
    
    <div title="医师人员信息" >
        <div style="width:750px;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-add" onclick="addData()" plain="true" tooltip="增加...">增加</a>
                        <a class="mini-button" iconCls="icon-remove" onclick="removeData()" plain="true">删除</a>
                        <span class="separator"></span>
                        <a class="mini-button" iconCls="icon-edit" onclick="editData()" plain="true">编辑</a>            
                    </td>
                </tr>
            </table>           
        </div>
    </div>
    <div id="datagrid1" class="mini-datagrid" style="width:750px;height:280px;" 
        url="<%=request.getContextPath()%>/work/f20010108/queryYsInfo.action"  allowResize="true"allowResize="true" 
        allowCellEdit="true" allowCellSelect="true" multiSelect="true" 
        editNextOnEnterKey="true"  editNextRowCell="true"  >
        <div property="columns">
         	<div type="checkcolumn" ></div> 
         	<div name="dataid" field="dataid" headerAlign="center" align="center" visible="false"  ></div>
         	<div name="lsh" field="lsh" headerAlign="center" align="center" visible="false"  ></div> 
         	<div name="clr" field="clr" headerAlign="center" align="center" visible="false"></div> 
		    <div name="action" width="120" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;">#</div>
            <div field="data01" width="70" headerAlign="center" align="center" >姓名</div>
		    <div field="data02" width="150" headerAlign="center" align="center" >身份证号</div>   
		    <div field="data03" width="100" headerAlign="center" align="center" renderer="onGenderRenderer">性别</div>
		    <div field="data04" width="100" headerAlign="center" align="center" renderer="onRylb">人员类别</div>   
		    <div field="data05" width="100" headerAlign="center" align="center" >资格证号</div>   
		    <div field="data06" width="150" headerAlign="center" align="center" >职业（注册）证号</div>   
		    <div field="data07" width="100" headerAlign="center" align="center" renderer="onZylb">职业类别</div>   
		    <div field="data08" width="100" headerAlign="center" align="center" >执业范围</div>   
		    <div field="data09" width="100" headerAlign="center" align="center" renderer="onZc">职称</div>   
		    <div field="data10" width="100" headerAlign="center" align="center" >所在科室</div>   
		    <div field="data11" width="50" headerAlign="center" align="center" >备注</div>                     
		    <div field="clzt" width="60" headerAlign="center" align="center" visible="true" >处理状态</div>
		    <div field="data58" width="200" headerAlign="center" align="center" onmouseover="fo()">人员重复情况</div>
		    <div field="data52" width="1" headerAlign="center" align="center" visible="true"  >重复标志</div>
        </div>
    </div>
    </div>
    <div title="导入失败信息">
        <div id="datagrid2" class="mini-datagrid" style="width:750px;height:280px;" 
        url="<%=request.getContextPath()%>/work/f20010108/queryErrInfo.action" allowResize="true" 
        allowCellEdit="true" allowCellSelect="true" multiSelect="true" 
        editNextOnEnterKey="true"  editNextRowCell="true" pagerButtons="#buttons">
        <div property="columns">
            <div field="cause" width="150" headerAlign="center" align="center" >失败原因</div> 
            <div field="data01" width="70" headerAlign="center" align="center" >姓名</div>  
		    <div field="data02" width="150" headerAlign="center" align="center" >身份证号</div>   
		    <div field="data03" width="100" headerAlign="center" align="center" renderer="onGenderRenderer">性别</div>
		    <div field="data04" width="100" headerAlign="center" align="center" renderer="onRylb">人员类别</div>   
		    <div field="data05" width="100" headerAlign="center" align="center" >资格证号</div>   
		    <div field="data06" width="150" headerAlign="center" align="center" >职业（注册）证号</div>   
		    <div field="data07" width="100" headerAlign="center" align="center" renderer="onZylb">职业类别</div>   
		    <div field="data08" width="100" headerAlign="center" align="center" >执业范围</div>   
		    <div field="data09" width="100" headerAlign="center" align="center" renderer="onZc">职称</div>   
		    <div field="data10" width="100" headerAlign="center" align="center" >所在科室</div>   
		    <div field="data11" width="150" headerAlign="center" align="center" >备注</div>
        </div>
    	</div>
	    <div id="buttons">
	    	<input id="pc" class="mini-hidden"/>
	        <span class="separator"></span>
	        <a class="mini-button" iconCls="icon-download" onClick="exportError()" plain="true">导出失败信息</a>
	    </div>
    </div>
    
</div>
        </div>
	</fieldset>
	
	
	<br />
    
    <script type="text/javascript">
        
        mini.parse();
		query();
        var grid = mini.get("datagrid1");
        //grid.hideColumn("dataid");
        //加载数据
        $(".mini-button").ajaxStart(function(){
        	mini.mask({
    			tl:document.body,
    			cls:'mini-mask-loading',
    			html:'加载中。。。'}
    			);
    	});
        $(".mini-button").ajaxStop(function(){
        	mini.unmask(document.body);
    	});
        
        
		function query(){
		 	Web.util.load("datagrid1",{data01:mini.get('data01').getValue(),data02:mini.get('data02').getValue()});
		}
		grid.on("drawcell",
				function(e) {
					var record = e.record, column = e.column, field = e.field, value = e.value;
					var rows = e.data;
					//违规明细,红色标识
					//alert(field)
					if (field == "data52" && value == '1') {
						e.rowStyle = "color:red";
					}
			});
        function addData() {          
            mini.open({
			    url: '<%=request.getContextPath()%>/pages/f20/f2001/f200101/f20010108/addys.jsp',
			    title: "新增医师人员信息", width: 700, height: 420,
			    onload: function () {
			        var iframe = this.getIFrameEl();
			        //var lsh=mini.get('lsh').getValue();
			       
			        //var data = { lsh: lsh,dataid:dataid};
			        //iframe.contentWindow.SetData(data);
			    },
                    ondestroy: function (action) {
                        grid.reload();
                        
                    }
			});
        }
        function editData() {  
  			var rows = grid.getSelecteds();
            if (rows.length !=1) {
            		alert('请选择一行进行编辑！');
            		return false;
            }else{	
            	var row = grid.getSelected();
            	mini.open({
				    url: '<%=request.getContextPath()%>/pages/f20/f2001/f200101/f20010108/editys.jsp',
				    title: "编辑医师人员信息", width: 700, height: 420,
				    onload: function () {
				        var iframe = this.getIFrameEl();
				        var data = { action: "edit", data01: row.data01};
                        iframe.contentWindow.SetData(row);
				    },
                    ondestroy: function (action) {
                        grid.reload();
                        
                    }
				});	
            }       	        
           
        }
        function onRylb(e) {
            if (e.value == 1) return "退休";
            if (e.value == 2) return "在职";
            else return "";
        }
         function onZylb(e) {
            if (e.value == 1) return "临床";
            if (e.value == 2) return "中医";
            if (e.value == 3) return "口腔";
            if (e.value == 4) return "公共卫生";
            else return "";
        }
         function onZc(e) {
        	if (e.value == 0) return "无";
            if (e.value == 1) return "初级";
            if (e.value == 2) return "中级";
            if (e.value == 3) return "高级";
            else return "";
        }
        var Genders = [{ id: 1, text: '男' }, { id: 2, text: '女'}];        
        function onGenderRenderer(e) {
            for (var i = 0, l = Genders.length; i < l; i++) {
                var g = Genders[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
        function onActionRenderer(e) {
        	
            var grid = e.sender;
            var record = e.record;
            var dataid = record.dataid;
            var rowIndex = e.rowIndex;

            var s = '<a class="New_Button" href="javascript:queryFj(\'' + dataid + '\')">编辑附件</a> ';
                       
            return s;
        }
        function queryFj(dataid){
        	mini.open({
			    url: '<%=request.getContextPath()%>/pages/f20/f2001/f200101/f20010103/clfj.jsp',
			    title: "医师附件", width: 1000, height: 600,
			    onload: function () {
			        var iframe = this.getIFrameEl();
		             //var dataid = record.dataid;
			        var data = {lsh:dataid};
			        iframe.contentWindow.SetData(data);
			    }
			});
        }
         function removeData() {
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                if(rows[0].clzt != "提交"){
	                if(confirm("确定要删除数据吗？"))
					 {
					 	//var data = grid.getSelecteds();
			            var json = mini.encode(rows);
			            if(json!=null&&json!='[]'){
			            	$.ajax({
				                url: "<%=request.getContextPath() %>/work/f20010108/deleteDataListInfo.action",
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
                    mini.alert("量化评分表已提交，不可删除");
                }
            }else{
            	alert('请选择要删除的数据');
            }
        }
        function saveData() {            
            var lsh=mini.get('lsh').getValue();
            //var dataid=mini.get('dataid').getValue();
            var data = grid.getSelecteds();
            var json = mini.encode(data);
            if(json!=null&&json!='[]'){
            	$.ajax({
	                url: "<%=request.getContextPath() %>/work/f20010108/saveDataListInfo.action",
	                data: { dataJson: json,lsh:lsh},
	                type: "post",
	                success: function (text) {
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

    	function fo(){}
    	function checkData(){  
    		var fileDir = document.getElementById("upfile").value; 
    		//alert(fileDir); 
    		var suffix = fileDir.substr(fileDir.lastIndexOf("."));  
    		if("" == fileDir){  
    			mini.alert("选择需要导入的Excel文件！");  
    			return false;  
    		}  
    		if(".xls" != suffix ){  
    			mini.alert("选择.xls格式的文件导入！");  
    			return false;  
    		}
    		//uploadForm.submit();
    		var form = $("form[name=uploadForm]");
    		var options  = {  
    			url:'${pageContext.servletContext.contextPath}/work/f20010108/importYs.action',  
    			type:'post',  
    			success:function(data){  
    				var jsondata = eval("("+data+")");
    				var message = jsondata.message;
    				var pc = jsondata.pc;
    				if(pc!=''){
        				mini.get("pc").setValue(pc);//赋值，方便导出excel
    					var grid2 = mini.get("datagrid2");
        				Web.util.load("datagrid2",{data01:pc});
        			}
        			mini.get("tabs").activeTab(mini.get("tabs").getTab(1));
    				mini.alert(message);
    				
    			}  
    		};  
    		//使用ajaxSubmit回调函数
    		form.ajaxSubmit(options);
    	}

		//导出失败excel
        function exportError(){
            var pc = mini.get("pc").getValue();
			window.location.href="${pageContext.servletContext.contextPath}/work/f20010108/exportYs.action?pc="+pc+"&lx=200108";
        }
    </script>
</body>
</html>
