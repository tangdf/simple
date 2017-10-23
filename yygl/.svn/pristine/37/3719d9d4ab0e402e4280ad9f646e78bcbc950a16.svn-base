<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>居民医疗保险查询</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
	fieldset{border:solid 1px #aaa; padding:10px;} 
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
                       <input id="aac002" name="aac002" class="mini-textbox" style="width:160px;"  vtype="rangeChar:15,18"  /> 
                    </td>
                    <td class="form-label">人员编号：</td>
                    <td>
                          <input id="aac001" name="aac001" class="mini-textbox"  vtype="int"  /> 
                    </td>
                      <td>
	                <input value="查询" type="button" onclick="query();" />
	            </td>
                </tr>
            </table>
            </div>
        </div>
    </fieldset>
           <div id="datagrid1" class="mini-datagrid" style="width:100%;height:315px; margin-top: 5px" 
             url="<%=request.getContextPath()%>/public/f10030101/queryJmylxx.action"  allowResize="true">
		        <div property="columns">
		        <div field="aac003" width="50" headerAlign="center" align="center" >姓名</div>    
		        <div field="aac002" width="150" headerAlign="center" align="center" >身份证号</div> 
		        <div field="aac016" width="150" headerAlign="center" align="center" >参保身份</div>
		        <div field="aae143" width="70" headerAlign="center" align="center" >缴费状态</div>
		        <div field="aae002" width="60" headerAlign="center" align="center">缴费年度</div> 
		        <div field="aae039" width="78" headerAlign="center" align="center">到账日期</div>
		        <div field="cae371" width="60" headerAlign="center" align="center">到账标志</div>
		        <div field="aae038" width="78" headerAlign="center" align="center">待遇享受日期</div>
		        <div field="rac122" width="40" headerAlign="center" align="center">金额</div>
		    	</div>
			</div> 
<script type="text/javascript">
mini.parse();

//加载数据
function query(){
	  var form = new mini.Form("#form1");
      form.validate();
      if (form.isValid() == false) return;
      if(mini.get("aac002").getValue()==''&&mini.get("aac001").getValue()==''){
    	  mini.alert("请至少输入一个查询条件！");
    	  return;
      }
      
 Web.util.load("datagrid1",{aac002:mini.get("aac002").getValue(),aac001:mini.get("aac001").getValue()});
}

</script>
</body>
</html>
