<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>缴费信息查询</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
    </style>
</head>
<body>
           <div id="datagrid1" class="mini-datagrid" style="width:100%;height:310px;" 
             url="<%=request.getContextPath()%>/work/f10010303/loadMedicalPay.action"  idField="id" allowResize="true">
		    <div property="columns">
		        <div type="indexcolumn" ></div>
		        <div field="aac003" width="100" headerAlign="center" align="center" >姓名</div>    
		        <div field="aae002" width="100" headerAlign="center" align="center" >缴费年月</div>                            
		        <div field="aae003" width="100" headerAlign="center" align="center" >应属年月</div>
		        <div field="aab004" width="240" headerAlign="center" align="center">单位名称</div> 
		        <div field="aae143" width="100" headerAlign="center" align="center">缴费类型</div>
		        <div field="akc010" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">缴费基数</div>
		        <div field="akc060" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">个人缴费</div>
		        <div field="caa024" width="120" headerAlign="center" align="center" decimalPlaces="2" dataType="float">单位划入个人账户额</div>
		        <div field="zkc010" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">大额补助</div>
		        <div field="akc061" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">共划入账户</div>
		        <div field="ckc030" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">公务员补助</div>                                   
		    	<div field="aae114" width="100" headerAlign="center" align="center">缴费标志</div> 
		    	</div>
			</div> 
			
			<div style="padding-top:5px;">备注：<br/>
			灵活就业人员个人按缴费基数11%（五市目前按9%）的比例缴纳基本医疗保险费，
			上述明细显示的“个人缴费”金额为个人缴费中按缴费基数的2%计算的金额。
			</div>  


<script type="text/javascript">
mini.parse();
//加载数据
 Web.util.load("datagrid1");

</script>
</body>
</html>
