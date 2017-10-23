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
             url="<%=request.getContextPath()%>/work/f10010902/querySbkApplyProgress.action" sizeList="[14,30,50,100]" pageSize="14" idField="id" allowResize="true">
		    <div property="columns">
		        <div field="aaz500" width="100" headerAlign="center" align="center" allowSort="true">社保保障卡号</div>    
		        <div field="aaz514" width="100" headerAlign="center" align="center" allowSort="true">变动类型</div>                            
		        <div field="flag" width="70" headerAlign="center" align="center" headerAlign="center">是否成功</div>
		        <div field="aae035" width="140" headerAlign="center" dateFormat="yyyy-MM-dd HH:mm:ss" align="center">变动日期</div>
		        <div field="aae037" width="100" headerAlign="center" align="center">变动说明</div>   
		        <div field="aae301" width="140" headerAlign="center" dateFormat="yyyy-MM-dd HH:mm:ss" align="center">操作时间</div>   
		        <div field="realname" width="100" headerAlign="center" align="center">操作员</div>   
		        <div field="czywd" width="100" headerAlign="center" align="center">操作员网点</div>   
		        <div field="wddh" width="100" headerAlign="center" align="center">联系电话</div>                                       
		    	</div>
			</div>   

</body>
<script type="text/javascript">
mini.parse();
//加载数据
 Web.util.load("datagrid1");

</script>
</html>
