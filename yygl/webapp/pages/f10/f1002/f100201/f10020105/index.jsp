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
             url="<%=request.getContextPath()%>/work/f10020105/queryTreatDetailInfo.action"  idField="id" allowResize="true">
		    <div property="columns">
		        <div type="indexcolumn" ></div>
		        <div field="aac003" width="60" headerAlign="center" align="center" allowSort="true">姓名</div>                            
		        <div field="aae002" width="100" headerAlign="center" align="center" >发放年月</div>
		        <div field="aae019" width="100" headerAlign="center" align="center">金额</div>
		    	</div>
			</div>   

</body>
<script type="text/javascript">
mini.parse();
//加载数据
 Web.util.load("datagrid1");

</script>
</html>
