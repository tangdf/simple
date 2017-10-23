<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>医疗住院结算查询</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
    </style>
</head>
  
  <body>
  	<div id="datagrid1" class="mini-datagrid" style="width:100%;height:360px;"
  	 url="<%=request.getContextPath()%>/work/f10010402/loadMedicalSettlement.action" idField="id">
  	 <div property="columns">
  	 	<div type="indexcolumn"></div>
  	 	<div field="ckb104" width="240" headerAlign="center"  align="center">医疗机构</div>
  	 	<div field="ckc022" width="100" headerAlign="center"  align="center">医疗类型</div>
  	 	<div field="aaz267" width="100" headerAlign="center"  align="center">领取地点</div>
  	 	<div field="aka030" width="160" headerAlign="center"  align="center">结算类型</div>
  	 	<div field="cke012" width="100" headerAlign="center"  align="center">结算日期</div>
  	 	<div field="aae030" width="100" headerAlign="center"  align="center">入院日期</div>
  	 	<div field="aae031" width="100" headerAlign="center"  align="center">出院日期</div>
  	 	<div field="akc264" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">医疗费总额</div>
  	 	<div field="ake039" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">统筹支付金额</div>
  	 	<div field="ake029" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">救助金支付</div>
  	 	<div field="bzbtzc" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">补助补贴支出</div>
  	 	<div field="cke412" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">范围外大额补助</div>
  	 	<div field="cke413" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">特病救助</div>
  	 	<div field="cke414" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">范围内大额补助</div>
  	 	<div field="cke415" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">超限救助</div>
  	 	<div field="jzzf" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">大病救助支付额</div>
  	 	<div field="ake038" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">账户支付金额</div>
  	 	<div field="grxjzf" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">个人现金支付</div>
  	 	<div field="ckc070" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">起付线</div>
  	 	<div field="akc266" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">本次纳入统筹额</div>
  	 	<div field="akc253" width="100" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">个人自费金额</div>
  	 </div>	
  	</div>
  	<div style="padding-top:5px;">
		具体领取细则，请查看首页关于发放城镇大病医疗救助过渡期第一批救助金的公告	
	</div>
  <script type="text/javascript">
  	mini.parse();
  	//加载数据
  	Web.util.load("datagrid1");
  </script>
  </body>
</html>