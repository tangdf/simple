<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>社保卡口头挂失</title>
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
                    <td class="form-label">社保卡号：</td>
                    <td >
                        <span id="sbkh"></span>
                    </td>
                    <td class="form-label">银联卡状态：</td>
                    <td>
                         <span id="ylkzt"></span>
                         <span id="aaa030" style="display:none"></span>
                    </td>
               		 <td class="form-label">银联医疗结算号：</td>
                    <td>
                        <span id="ckz004"></span>
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">卡金余额：</td>
                    <td >
                        <span id="ye"></span>
                    </td>
                    <td class="form-label">绑定银行：</td>
                    <td>
                         <span id="yhbm"></span>
                    </td>
               		 <td class="form-label">绑定网点：</td>
                    <td>
                       <span id="jbwd"></span>
                    </td>
                </tr>
            </table>
        </div>
    </fieldset>
    <br/>
    <div align="center">
       <input type="button" id="dosubmit" onclick="saveGs();" value="口头挂失" size="15"  />
    </div>
    <div>
    注：<br/>
    1、口头挂失确认提交后即时生效，该卡各应用功能冻结、暂停使用。<br/>
    2、如果您找回原卡的，可持本人有效身份证件到发卡银行任意一家服务网点办理解除挂失手续，该卡各应用功能即时恢复正常
       使用。已办理补换卡手续的不能办理解除挂失手续。<br/>
    3、口头挂失后，持卡人应及时持本人有效身份证件到发卡银行任意一家服务网点办理书面挂失和补换卡手续。<br/> 
    	
    </div>
</body>
<script type="text/javascript">
mini.parse();
//加载数据
 var url = '<%=request.getContextPath()%>/work/f10010903/querySbkye.action';
 Web.util.request(url,'POST',{},
	function(data){
		for (var v in data){
			  	$("#"+v).html(data[v]);
			}
	}
);
 function saveGs(){
	 //return;
	 var url = '<%=request.getContextPath()%>/work/f10010903/saveLsgs.action';
	 Web.util.request(url,'POST',{aaa030:$("#aaa030").html()},
		function(data){
		 	mini.alert('社保卡挂失成功！');
			$("#dosubmit").attr("disabled", "disabled");
		}
	);
 }
</script>
</html>
