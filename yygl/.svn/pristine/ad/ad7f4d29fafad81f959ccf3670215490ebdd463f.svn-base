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
<body>
    <fieldset id="fd2">
        <legend><span>个人信息</span></legend>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="4">
           <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
          <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
          <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
                <tr>
                    <td class="form-label">职工编号：</td>
                    <td>
                        <span id="aac001"></span>
                    </td>
                    <td class="form-label">姓名：</td>
                    <td>
                        <span id="aac003"></span>
                    </td>
                    <td class="form-label">身份证号：</td>
                    <td>
                        <span id="aac002"></span>
                    </td>
                </tr>
                <tr>
                   <td class="form-label">民族：</td>
                    <td>
                         <span id="aac005"></span>
                    </td>
                    <td class="form-label">性别：</td>
                    <td >
                        <span id="aac004"></span>
                    </td>
               		 <td class="form-label">出生日期：</td>
                    <td>
                        <span id="aac006"></span>
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">户籍性质：</td>
                    <td >
                        <span id="aac009"></span>
                    </td>
                   
               		 <td class="form-label">户籍所在地址：</td>
                    <td colspan="3">
                       <span id="aac010"></span>
                    </td>
                </tr>
                <tr>
                    <td class="form-label">特殊人群标志：</td>
                    <td >
                        <span id=""></span>
                    </td>
                    <td class="form-label">居住地址：</td>
                    <td colspan="3">
                        <span id="aae006"></span>
                    </td>
                </tr>
            </table>
        </div>
    </fieldset>
</body>
<script type="text/javascript">
//加载数据
 var url = '<%=request.getContextPath()%>/work/f10020101/loadJmylUserInfo.action';
 Web.util.request(url,'POST',{},
	function(data){
		for (var v in data){
			  	$("#"+v).html(data[v]);
			}
	}
);
</script>
</html>
