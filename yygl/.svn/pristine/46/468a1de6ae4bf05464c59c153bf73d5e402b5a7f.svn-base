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
    fieldset{border:solid 1px #aaa; padding:10px;}        
    </style>
</head>
<body onload="loadForm();">
    <fieldset id="fd2">
        <legend><span>个人信息修改</span></legend>
        <div class="fieldset-body">
        <div id="form1">
          <table class="form-table" border="0" cellpadding="1"  cellspacing="4">
           <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
          <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
                <tr>
                    <td class="form-label">联系电话:</td>
                    <td>
                       <input id="aae005" name="aae005" class="mini-textbox" vtype="maxLength:24" /> 
                    </td>
                    <td class="form-label">邮政编码：</td>
                    <td>
                          <input id="aae007" name="aae007" class="mini-textbox"  vtype="rangeLength:6,6" /> 
                    </td>
                </tr>
                <tr>
                    <td class="form-label">通讯地址:</td>
                    <td colspan="3">
                          <input id="aae006" name="aae006" class="mini-textbox" style="width:240px" vtype="maxLength:50" /> 
                    </td>
                </tr>
                <tr>
            	<td></td>
	            <td colspan="2">
	                <input value="提交" type="button" onclick="submitForm()" />
	            </td>
	            <td></td>
        		</tr>
            </table>
            </div>
        </div>
    </fieldset>
</body>
<script type="text/javascript">
mini.parse();
function loadForm() {
  //加载表单数据
   var url = '<%=request.getContextPath()%>/work/f10010103/loadBaseInfo.action';
   Web.util.formLoad("form1",url);
}
function submitForm() {
	 var form = new mini.Form("#form1");
     form.validate();
     if (form.isValid() == false) return;
     
	//提交表单数据
	var url = '<%=request.getContextPath()%>/work/f10010103/saveBaseInfo.action';
	Web.util.formSubmit("form1",url,"post",function(data,textstatus){
			mini.alert("提交 成功！ ");
		});
      
   }
</script>
</html>
