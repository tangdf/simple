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
 <fieldset id="fd2">
        <legend><span>账户信息</span></legend>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="4">
           <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
          <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
          <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
                <tr>
                    <td class="form-label">姓名：</td>
                    <td>
                        <span id="aac003"></span>
                    </td>
                    <td class="form-label">身份证号：</td>
                    <td>
                        <span id="aac002"></span>
                    </td>
                      <td class="form-label">当年缴费档次：</td>
                    <td>
                        <span id="dnjfdc"></span>
                    </td>
                </tr>
            </table>
        </div>
    </fieldset>
           <div id="datagrid1" class="mini-datagrid" style="width:100%;height:340px;" 
             url="<%=request.getContextPath()%>/work/f10020104/queryPayStautsInfo.action"  idField="id" allowResize="true">
		    <div property="columns">
		        <div type="indexcolumn" ></div>
		        <div field="aae002" width="100" headerAlign="center" align="center" allowSort="true">缴费时间</div>    
		        <div field="aae003" width="120" headerAlign="center" align="center" allowSort="true">费款所属年</div>                            
		        <div field="grjfje" width="100" headerAlign="center" align="center" >个人缴费金额</div>
		        <div field="jtjfje" width="100" headerAlign="center" align="center">集体缴费金额</div>  
		        <div field="czbtje" width="100" headerAlign="center" align="center">财政补助金额</div>
		        <div field="aae079" width="100" headerAlign="center" align="center">到账时间</div>                                  
		    	</div>
			</div>   

</body>
<script type="text/javascript">
mini.parse();
//加载数据
var url = '<%=request.getContextPath()%>/work/f10020104/queryJmylJfInfo.action';
Web.util.request(url,'POST',{},
	function(data){
		for (var v in data){
			  	$("#"+v).html(data[v]);
			}
	}
);
//加载数据
 Web.util.load("datagrid1");

</script>
</html>
