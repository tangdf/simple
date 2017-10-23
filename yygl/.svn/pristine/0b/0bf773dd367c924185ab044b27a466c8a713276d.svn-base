<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>在职养老账户查询</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
    </style>
</head>
  
  <body>
  	<div id="datagrid1" class="mini-datagrid" style="width:100%;height:360px;"
  	 url="<%=request.getContextPath()%>/work/f10010501/loadPensionAccounts.action" idField="id" allowHeaderWrap="true">
  	 <div property="columns">
  	 	<div type="indexcolumn"></div>
  	 	<div field="aae001" width="100" headerAlign="center"  align="center">年度</div>
  	 	<div field="aac001" width="100" headerAlign="center"  align="center">个人编号</div>
  	 	<div field="aac147" width="160" headerAlign="center"  align="center">身份证号</div>
  	 	<div field="aac003" width="100" headerAlign="center"  align="center">姓名</div>
  	 	<div field="aae253" width="120" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">截止上年末单位部分累计本息</div>
  	 	<div field="aae254" width="120" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">截止上年末个人部分累计本息</div>
  	 	<div field="aae262" width="120" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">本年单位划拨部分本金</div>
  	 	<div field="aae263" width="120" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">本年单位划拨部分利息</div>
  	 	<div field="aae264" width="120" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">本年个人部分本金</div>
  	 	<div field="aae265" width="120" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">本年个人部分利息</div>
  	 	<div field="aae259" width="120" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">截止上年末单位部分累计本息在本年产生的利息</div>
  	 	<div field="aae260" width="120" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">截止上年末个人部分累计本息在本年产生的利息</div>
  	 	<div field="aae255" width="120" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">截止上年末个人账户财政补助（补贴）部分划转累计本金</div>
  	 	<div field="aae252" width="120" headerAlign="center"  align="center" decimalPlaces="2" dataType="float">账户年度余额</div>
  	 </div>	
  	</div>
  	<div style="padding-top:5px;">
		本年度的缴费划账户金额在年底记息结转后显示，如需查询本年的缴费情况，请到缴费信息查询中查看明细	
	</div>
  <script type="text/javascript">
  	mini.parse();
  	//加载数据
  	Web.util.load("datagrid1");
  </script>
  </body>
</html>
