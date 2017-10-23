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
           <div id="datagrid1" class="mini-datagrid" style="width:100%;height:350px;" 
             url="<%=request.getContextPath()%>/work/f10010904/querySbkConsume.action" sizeList="[12,30,50,100]" pageSize="12" idField="id" allowResize="true">
		    <div property="columns">
		        <div field="ckc175" width="100" headerAlign="center" align="center" allowSort="true">交易日期</div>    
		        <div field="ckc176" width="100" headerAlign="center" align="center" allowSort="true">交易时间</div>                            
		        <div field="ckc178a" width="70" headerAlign="center" align="center" headerAlign="center">注入金额</div>
		        <div field="ckc178s" width="140" headerAlign="center"  align="center">消费金额</div>
		        <div field="cke325" width="100" headerAlign="center" align="center">余额</div>   
		        <div field="ckc180" width="140" headerAlign="center" align="center">交易名称</div>   
		        <div field="cke322" width="100" headerAlign="center" align="center">交易地点</div>   
		    	</div>
			</div>   
注入金额合计:<span id="ckc178s"></span> 消费金额合计:<span id="ckc178a"></span><br/>
注：社保卡交易明细查询显示的是截止到<span id="presysdate"></span>的交易明细。
</body>
<script type="text/javascript">
mini.parse();
//加载数据
 Web.util.load("datagrid1");
//数据合计
 var url = '<%=request.getContextPath()%>/work/f10010904/querySbkConsumeSum.action';
 Web.util.request(url,'POST',{},
	function(data){
	for (var v in data)
	{$("#"+v).html(data[v]); }
	});
</script>
</html>
