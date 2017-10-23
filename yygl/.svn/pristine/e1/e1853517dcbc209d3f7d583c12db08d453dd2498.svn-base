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
           <div id="datagrid1" class="mini-datagrid" style="width:100%;height:400px;" 
             url="<%=request.getContextPath()%>/work/f10010304/loadUnemploymentPay.action"  idField="id" allowResize="true">
		    <div property="columns">
		        <div type="indexcolumn" ></div>
		        <div field="aac003" width="100" headerAlign="center" align="center" >姓名</div>    
		        <div field="aab004" width="240" headerAlign="center" align="center" >单位名称</div>                            
		        <div field="aae002" width="100" headerAlign="center" align="center" >缴费年月</div>
		        <div field="aae003" width="100" headerAlign="center" align="center">应缴年月</div> 
		        <div field="aae143" width="100" headerAlign="center" align="center">缴费类型</div>
		        <div field="ajc020" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">缴费基数</div>
		        <div field="ajc030" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">个人缴费</div>
		        <div field="aae115" width="100" headerAlign="center" align="center">缴费标志</div>
		    	</div>
			</div>   


<script type="text/javascript">
mini.parse();
//加载数据
 Web.util.load("datagrid1");

</script>
</body>
</html>