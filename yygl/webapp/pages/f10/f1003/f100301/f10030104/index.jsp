<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>工伤认定查询</title>
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
                   <td class="form-label">人员编号：</td>
                    <td>
                          <input id="aac001" name="aac001" class="mini-textbox"  vtype="int"  /> 
                    </td>
                    <td class="form-label">姓名:</td>
                    <td>
                       <input id="aac003" name="aac003" class="mini-textbox" vtype="maxLength:50"  /> 
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
             url="<%=request.getContextPath()%>/public/f10030104/queryGsrdcx.action"  allowResize="true">
		        <div property="columns">
		        <div field="aac003" width="50" headerAlign="center" align="center" >姓名</div>    
		        <div field="aab004" width="180" headerAlign="center" align="center" >单位</div> 
		        <div field="alc022" width="150" headerAlign="center" align="center" >伤害部位</div>
		        <div field="alc021" width="70" headerAlign="center" align="center" >伤害程度</div>
		        <div field="clc207" width="60" headerAlign="center" align="center">受理标志</div> 
		        <div field="ala015" width="78" headerAlign="center" align="center">认定标志</div>
		        <div field="alc031" width="78" headerAlign="center" align="center">认定日期</div>
		    	</div>
			</div> 
<script type="text/javascript">
mini.parse();

//加载数据
function query(){
	  var form = new mini.Form("#form1");
      form.validate();
      if (form.isValid() == false) return;
      if(mini.get("aac003").getValue()==''&&mini.get("aac001").getValue()==''){
    	  mini.alert("请至少输入一个查询条件！");
    	  return;
      }
 Web.util.load("datagrid1",{aac003:mini.get("aac003").getValue(),aac001:mini.get("aac001").getValue()});
}

</script>
</body>
</html>
