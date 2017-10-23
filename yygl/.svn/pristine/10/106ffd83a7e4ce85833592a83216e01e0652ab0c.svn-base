<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>医疗年度情况查询</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
    </style>
</head>
  
  <body>
  	<div id="datagrid1" class="mini-datagrid" style="width:100%;height:400px;"
  	 url="<%=request.getContextPath()%>/work/f10010403/loadMedicalAnnualInfo.action" idField="id">
  	 <div property="columns">
  	 	<div type="indexcolumn"></div>
  	 	<div field="cke002" width="100" headerAlign="center"  align="center">年度</div>
  	 	<div field="aae030" width="100" headerAlign="center"  align="center">开始时间</div>
  	 	<div field="aae031" width="100" headerAlign="center"  align="center">终止时间</div>
  	 	<div field="akc264" width="160" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">本年医疗费累计</div>
  	 	<div field="akc266" width="180" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">纳入统筹医疗费总额</div>
  	 	<div field="ake039" width="180" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">本年统筹支付累计</div>
  	 	<div field="ake029" width="180" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">本年救助金支出累计</div>
  	 	<div field="aka030a" width="160" headerAlign="center"  align="center">本年住院次数</div>
  	 	<div field="aka030b" width="160" headerAlign="center"  align="center">本年大病住院次数</div>
  	 </div>	
  	</div>
  <script type="text/javascript">
  	mini.parse();
  	//加载数据
  	Web.util.load("datagrid1");
  </script>
  </body>
</html>
