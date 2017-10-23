<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>职业介绍机构查询</title>
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
           <colgroup align="left" width="18%"></colgroup>
          <colgroup align="right" width="8%"></colgroup>
           <colgroup align="left" width="18%"></colgroup>
             <colgroup align="right" width="8%"></colgroup>
           <colgroup align="left" width="18%"></colgroup>
          <colgroup align="left" width="13%"></colgroup>
                <tr>
                    <td class="form-label">名称:</td>
                    <td>
                       <input id="cxtj1" name="cxtj1" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                    <td class="form-label">区市：</td>
                    <td>
                     <input id="cxtj2" class="mini-combobox" style="width:100px;" textField="text" valueField="id" emptyText="请选择..."
				       data="[{id:'37020100',text:'市南区'},{id:'37020200',text:'市北区'},
				       {id:'37020300',text:'四方区'},{id:'37020400',text:'李沧区'},
				       {id:'37020500',text:'黄岛区'},{id:'37020600',text:'崂山区'},
				       {id:'37020700',text:'城阳区'},{id:'37020800',text:'胶州市'},
				       {id:'37020900',text:'胶南市'},{id:'37021000',text:'平度市'},
				       {id:'37021100',text:'即墨市'},{id:'37021200',text:'莱西市'}]"  allowInput="true" showNullItem="true" nullItemText="请选择..."/> 
                    </td>
                    <td class="form-label">地址：</td>
                    <td>
                          <input id="cxtj3" name="cxtj3" class="mini-textbox"  vtype="maxLength:50" /> 
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
             url="<%=request.getContextPath()%>/public/f10030109/queryZyjsjjcx.action"  allowResize="true">
		        <div property="columns">
		        <div field="fboroughid" width="100" headerAlign="center" align="center" >所在区</div>    
		        <div field="fname" width="150" headerAlign="center" align="center" >机构名称</div> 
		        <div field="faddr" width="150" headerAlign="center" align="center" >地址</div>
		        <div field="ftel" width="70" headerAlign="center" align="center" >电话</div>
		    	</div>
			</div> 
<script type="text/javascript">
mini.parse();

//加载数据
function query(){
	  var form = new mini.Form("#form1");
      form.validate();
      if (form.isValid() == false) return;
      
 Web.util.load("datagrid1",{cxtj1:mini.get("cxtj1").getValue(),cxtj2:mini.get("cxtj2").getValue(),cxtj3:mini.get("cxtj3").getValue()});
}
query();
</script>
</body>
</html>
