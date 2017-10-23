<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>基本信息</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
    </style>
</head>
<body>
           <div id="datagrid1" class="mini-datagrid" style="width:100%;height:400px;" 
             url="<%=request.getContextPath()%>/work/f10010301/loadCurrentPay.action"  idField="id" >
		    <div property="columns">
		        <div type="indexcolumn" ></div>
		        <div field="aac003" width="100" headerAlign="center" align="center">姓名</div>    
		        <div field="aae030" width="100" headerAlign="center" align="center">开始时间</div>                            
		        <div field="aae031" width="100" headerAlign="center" align="center">结束时间</div>
		        <div field="aab001" width="100" headerAlign="center" align="center">单位编号</div> 
		        <div field="aab004" width="240" headerAlign="center" align="center">单位名称</div>
		        <div field="aac040" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">工资</div>
		        <div field="aic020" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">养老缴费基数</div>
		        <div field="akc010" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">医疗缴费基数</div>
		        <div field="ajc020" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">失业缴费基数</div>
		        <div field="alc001" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">工伤缴费基数</div>
		        <div field="amc001" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">生育缴费基数</div>                                   
		    	</div>
			</div>   


<script type="text/javascript">
mini.parse();
//加载数据
 Web.util.load("datagrid1");

</script>
</body>
</html>
