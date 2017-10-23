<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>老工伤查询</title>
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
          <colgroup align="left" width="30%"></colgroup>
                <tr>
                    <td class="form-label">身份证号:</td>
                    <td>
                       <input id="aac147" name="aac147" class="mini-textbox" style="width:160px;" vtype="maxLength:18"  /> 
                    </td>
                      <td>
	                <input value="查询" type="button" onclick="query();" />
	            </td>
                </tr>
            </table>
            </div>
        </div>
    </fieldset>
           <div id="datagrid1" class="mini-datagrid" style="width:100%;height:285px; margin-top: 5px" 
             url="<%=request.getContextPath()%>/public/f10030108/queryLgscx.action"  allowResize="true">
		        <div property="columns">
		        <div field="aac003" width="80" headerAlign="center" align="center" >姓名</div>    
		        <div field="alc020" width="180" headerAlign="center" align="center" >工伤发生时间</div> 
		        <div field="clc200" width="50" headerAlign="center" align="center" >工伤类别</div>
		    	</div>
			</div> 
<script type="text/javascript">
mini.parse();

//加载数据
function query(){
	  var form = new mini.Form("#form1");
      form.validate();
      if (form.isValid() == false) return;
 Web.util.load("datagrid1",{aac147:mini.get("aac147").getValue()});
}
Web.util.load("datagrid1");
</script>
</body>
</html>
