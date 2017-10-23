<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>工伤定期待遇补退明细</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
    </style>
</head>
<body>
           <div id="datagrid1" class="mini-datagrid" style="width:100%;height:360px;" 
             url="<%=request.getContextPath()%>/work/f10010601/loadWorkInjuryTreatment1.action"  idField="aac003" allowResize="true" >
		    <div property="columns">
		        <div type="indexcolumn" ></div>
		        <div name="action"  width="100" headerAlign="center" align="center" renderer="onActionRenderer">操作</div>
		        <div field="aac003" width="100" headerAlign="center" align="center">姓名</div>    
		        <div field="aae002" width="100" headerAlign="center" align="center">费款所属期</div>                            
		        <div field="aaa103" width="100" headerAlign="center" align="center">补扣发类型</div>
		        <div field="aae019" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">待遇金额</div>                                   
		    	<div name="aaz166column" field="aaz166" width="100" headerAlign="center" align="center">人员待遇补扣发事件ID</div>
		    </div>
			</div> 
			
			<div id="editwindow" class="mini-window" title="工伤定期待遇补退详细信息" style="width:650px;"
			showModal="true" allowResize="true" allowDrag="true">
				<div id="editform" class="form">
					<input class="mini-hidden" name="id"/>
					<table style="width:100%;">
						<tr>
							<td style="width:100px;">待遇项目：</td>
							<td style="width:150px;"><input name="aaa037" class="mini-textbox" /></td>
							<td style="width:100px;">补扣发标志：</td>
							<td style="width:150px;"><input name="aaa103" class="mini-textbox" /></td>
						</tr>
						<tr>
							<td style="width:100px;">费款所属期：</td>
							<td style="width:150px;"><input name="aae002" class="mini-textbox" /></td>
							<td style="width:100px;">对应费款所属期：</td>
							<td style="width:150px;"><input name="aae003" class="mini-textbox" /></td>
						</tr>
						<tr>
							<td style="width:100px;">核发金额：</td>
							<td style="width:150px;"><input name="aae129" class="mini-textbox" /></td>
						</tr>
					</table>
				</div>
			</div> 
			
			<div>
				<table class="form-table" border="0" cellpadding="1" cellspacing="4">
						<tr align="center">
                    		<td >
                    		金额合计：<span id="aae019sum" ></span>
                    		</td>
                		</tr>	
				</table>
			</div>


<script type="text/javascript">
mini.parse();

//加载数据
 Web.util.load("datagrid1");
 var grid=mini.get("datagrid1");
 grid.hideColumn("aaz166column");//隐藏aaz166项
 //var aaz166=grid.getRow(6);
 //数据合计
 var url = '<%=request.getContextPath()%>/work/f10010601/loadSumWorkInjuryTreatment1.action';
 Web.util.request(url,'POST',{},
	function(data){
	for (var v in data)
	{$("#"+v).html(data[v]); }
	});
//详细信息弹出
	function onActionRenderer(e){
		//var grid=e.sender;
		//var record=e.record;
		//var uid=record._uid;
		//var rowIndex=e.rowIndex;
		var s='<a class="Button" href="javascript:getInfo()">详细</a>';
		return s;
	}
	function getInfo() {
		var editwindow=mini.get("editwindow");
		editwindow.show();
		var form=new mini.Form("#editform");
		var aaz166=grid.getSelected().aaz166;
		//var aaz166=datagrid1.getSelected().getColumn(aaz166column);
		$.ajax({
			url:"${pageContext.request.contextPath}/work/f10010601/getInfo.action?aaz166=" + aaz166,
			type:"post",
			data:{aaz166:aaz166},
			success: function (text){	
				var o=mini.decode(text);
				form.setData(o);
				}
			});
	//Web.util.request(url,'POST',{aaz166:aaz166},
	//function(data){
	//for (var v in data)
	//{$("#"+v).html(data[v]); }
	//});
		
	}	
</script>
</body>
</html>