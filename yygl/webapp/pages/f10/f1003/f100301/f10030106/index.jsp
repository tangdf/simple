<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>劳动能力鉴定查询</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
	fieldset{border:solid 1px #aaa; padding:5px;} 
    </style>
</head>
<body>
<fieldset id="fd2">
        <legend><span>查询条件</span></legend>
        <div class="fieldset-body">
        <div id="form1">
          <table class="form-table" border="0" cellpadding="1"  cellspacing="4">
           <colgroup align="right" width="10%"></colgroup>
           <colgroup align="left" width="20%"></colgroup>
          <colgroup align="right" width="10%"></colgroup>
            <colgroup align="left" width="20%"></colgroup>
          <colgroup align="left" width="30%"></colgroup>
               <tr>
                    <td class="form-label">身份证号:</td>
                    <td>
                       <input id="aac002" name="aac002" class="mini-textbox" style="width:160px;"  vtype="rangeChar:15,18" required="true" /> 
                    </td>
                    <td class="form-label">人员编号：</td>
                    <td>
                          <input id="aac001" name="aac001" class="mini-textbox"  vtype="int" required="true"  /> 
                    </td>
                      <td>
	                <input value="查询" type="button" onclick="query();" />
	            </td>
                </tr>
                <tr>
						<td colspan="5" align="left"><font color="red"> 
			注：具体领取细则，请查看首页关于发放城镇大病医疗救助过渡期第一批救助金的公告 。<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本查询可以为参保职工和居民提供大病医疗救助信息查询。
						</font></td>
					</tr>
            </table>
            </div>
        </div>
    </fieldset>
           <div id="datagrid1" class="mini-datagrid" style="width:100%;height:275px; margin-top: 5px" 
             url="<%=request.getContextPath()%>/public/f10030106/queryDbyljzcx.action"  allowResize="true">
		        <div property="columns">
		        <div field="aac003" width="50" headerAlign="center" align="center" >姓名</div>    
		        <div field="aaz267" width="150" headerAlign="center" align="center" >领取地点</div> 
		        <div field="aka030" width="80" headerAlign="center" align="center" >结算类型</div>
		        <div field="jzzf" width="120" headerAlign="center" align="center" >大病救助合计金额</div>
		        <div field="cke412" width="120" headerAlign="center" align="center">范围外大额救助</div> 
		        <div field="cke413" width="78" headerAlign="center" align="center">特病救助</div>
		        <div field="cke414" width="78" headerAlign="center" align="center">范围内大额救助</div>
		        <div field="cke415" width="78" headerAlign="center" align="center">超限救助</div>
		        <div field="aae030" width="78" headerAlign="center" align="center">医疗年度开始日期</div>
		        <div field="aae031" width="78" headerAlign="center" align="center">医疗年度终止日期助</div>
		        
		    	</div>
			</div> 
<script type="text/javascript">
mini.parse();

//加载数据
function query(){
	  var form = new mini.Form("#form1");
      form.validate();
      if (form.isValid() == false) return;
 Web.util.load("datagrid1",{aac002:mini.get("aac002").getValue(),aac001:mini.get("aac001").getValue()});
}
</script>
</body>
</html>
