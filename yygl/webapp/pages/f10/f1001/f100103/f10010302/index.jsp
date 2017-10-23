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
           <div id="datagrid1" class="mini-datagrid" style="width:100%;height:320px;" 
             url="<%=request.getContextPath()%>/work/f10010302/loadAgedPay.action"  idField="aac003" allowResize="true" 
             >
		    <div property="columns">
		        <div type="indexcolumn" ></div>
		        <div field="aac003" width="100" headerAlign="center" align="center">姓名</div>    
		        <div field="aae002" width="100" headerAlign="center" align="center">缴费年月</div>                            
		        <div field="aae003" width="100" headerAlign="center" align="center">应属年月</div>
		        <div field="aab004" width="240" headerAlign="center" align="center">单位名称</div> 
		        <div field="aae143" width="160" headerAlign="center" align="center">缴费类别</div>
		        <div field="aic020" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">个人基数</div>
		        <div field="aic021" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">个人缴费</div>
		        <div field="aic024" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">单位划入账户</div>
		        <div field="cic070" width="100" headerAlign="center" align="center" decimalPlaces="2" dataType="float">社平划入</div>
		        <div field="aae114" width="100" headerAlign="center" align="center">缴费标志</div>                                   
		    	</div>
			</div>  
			
			<div>
				<table class="form-table" border="0" cellpadding="1" cellspacing="4">
						<tr align="center">
                    		<td >
                    		个人缴费合计：<span id="aic021sum" ></span>&nbsp;&nbsp;单位划入账户合计：<span id="aic024sum" ></span>&nbsp;&nbsp;社平划入合计：<span id="cic070sum" ></span>
                    		</td>
                		</tr>	
				</table>
				<div>备注：
				灵活就业人员个人按缴费基数20%的比例缴纳基本养老保险费，
				上述明细显示的“个人缴费”金额为个人缴费中按缴费基数乘以8%的比例计入个人账户的金额。
				</div> 
			</div>


<script type="text/javascript">
mini.parse();
//加载数据
 Web.util.load("datagrid1");
 //数据合计
 var url = '<%=request.getContextPath()%>/work/f10010302/loadSumPay.action';
 Web.util.request(url,'POST',{},
	function(data){
	for (var v in data)
	{$("#"+v).html(data[v]); }
	});
</script>
</body>
</html>