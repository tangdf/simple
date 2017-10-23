<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>病种目录查询</title>
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
           <colgroup align="right" width="8%"></colgroup>
           <colgroup align="left" width="30%"></colgroup>
          <colgroup align="left" width="20%"></colgroup>
           <colgroup align="left" width="18%"></colgroup>
                <tr>
                    <td class="form-label">病种名称：</td>
                    <td>
                        <input id="cxtj1" name="cxtj1" class="mini-textbox"  vtype="maxLength:50" /> 
                    </td>
                    <td>
                     <div id="cxtj2" class="mini-radiobuttonlist" repeatItems="2"  
    					textField="text" valueField="id" value="1" data="[{id:'1',text:'汉字'},{id:'2',text:'拼音缩写'}]" >
					</div> 
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
             url="<%=request.getContextPath()%>/public/f10030113/queryBzmlcx.action"  allowResize="true">
		        <div property="columns">
		        <div field="aka120" width="100" headerAlign="center" align="center" >病种编码</div>    
		        <div field="aka121" width="150" headerAlign="center" align="center" >病种名称</div> 
		        <div field="aka122" width="70" headerAlign="center" align="center" >疾病科类</div>
		        <div field="cke146" width="70" headerAlign="center" align="center" >病种性质</div>
		        <div field="aae030" width="70" headerAlign="center" align="center" >开始日期</div>
		        <div field="aae031" width="70" headerAlign="center" align="center" >终止日期</div>
		    	</div>
			</div> 
<script type="text/javascript">
mini.parse();

//加载数据
function query(){
	  var form = new mini.Form("#form1");
      form.validate();
      if (form.isValid() == false) return;
      
 Web.util.load("datagrid1",{cxtj1:mini.get("cxtj1").getValue(),cxtj2:mini.get("cxtj2").getValue()});
}
query();
</script>
</body>
</html>
