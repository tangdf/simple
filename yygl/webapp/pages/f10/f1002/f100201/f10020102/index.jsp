<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人账户查询</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
    </style>
</head>
<body>
           <div id="datagrid1" class="mini-datagrid" style="width:100%;height:340px;" 
             url="<%=request.getContextPath()%>/work/f10020102/queryAccountInfo.action"  idField="id" allowResize="true">
		    <div property="columns">
		        <div type="indexcolumn" ></div>
		        <div field="aac002" width="120" headerAlign="center" align="center" allowSort="true">身份证号码</div>    
		        <div field="aac003" width="60" headerAlign="center" align="center" allowSort="true">姓名</div>                            
		        <div field="aae238" width="100" headerAlign="center" align="center" >个人缴费累计金额</div>
		        <div field="czbtljje" width="100" headerAlign="center" align="center">财政补贴累计金额</div>  
		        <div field="jtjfje" width="100" headerAlign="center" align="center">集体缴费金额</div>
		        <div field="aae240" width="150" headerAlign="center" align="center">个人账户缴费累计金额</div>                                  
		    	</div>
			</div>   

</body>
<script type="text/javascript">
mini.parse();
//加载数据
 Web.util.load("datagrid1");

</script>
</html>
