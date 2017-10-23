<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>医疗保险审批查询</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
    </style>
</head>
  
  <body>
  	<div id="datagrid1" class="mini-datagrid" style="width:100%;height:400px;"
  	 url="<%=request.getContextPath()%>/work/f10010401/loadMedicalApproval.action" idField="id">
  	 <div property="columns">
  	 	<div type="indexcolumn"></div>
  	 	<div field="aac003" width="100" headerAlign="center"  align="center">姓名</div>
  	 	<div field="akb020" width="240" headerAlign="center"  align="center">医疗机构</div>
  	 	<div field="aae030" width="100" headerAlign="center"  align="center">开始时间</div>
  	 	<div field="aae031" width="100" headerAlign="center"  align="center">终止时间</div>
  	 	<div field="ckc042" width="160" headerAlign="center"  align="center">审批类别</div>
  	 	<div field="aka120" width="100" headerAlign="center"  align="center">病种</div>
  	 	<div field="aae013" width="100" headerAlign="center"  align="center">备注</div>
  	 </div>	
  	</div>
  <script type="text/javascript">
  	mini.parse();
  	//加载数据
  	Web.util.load("datagrid1");
  </script>
  </body>
</html>
