<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
<style type="text/css">
#welcome a {text-decoration:underline;color:#CC0000;};
#displayjd {font-size:16px;padding:40px;}
#jd{font-weight:bold;color:#CC0000;}
fieldset{border:solid 1px #aaa; padding:10px;} 
</style>	
<title></title>
</head>
<body>

	<c:if test="${po==null}">
			<div id="welcome" style="margin-top:100px;padding:20px;"><center>
			<font color="blue" size="3">订制信息与个人权益自助查询打印信息完全一致，如只为核对、留存，
			通过“个人权益信息单打印”模块办理即可。若需订制,<a href="javascript:display();">请继续</a></font> 
			</center>
			</div>
    <fieldset id="fd2">
        <legend><span>订制信息</span></legend>
        <div class="fieldset-body">			
<form id="form1"  method="post"  action="">
			<table width="721px" cellpadding="0" cellspacing="0" class="table_box" align="center">
		<tr>
			<td width="725" height="80" class="content" valign="top">
				<table width="95%" border="0" align="center" cellpadding="2" cellspacing="3" >
					<tr><td><br></td></tr>
					<tr>
						<td align="left" colspan="2">邮寄地址:
						<input type="text" id="aae006_1" size="7" value="山东省"/>省
						<input type="text" id="aae006_2" size="7" value="青岛市"/>市
						<input type="text" id="aae006_3" size="7" value=""/>区（市）
						<input type="text" id="aae006_4" size="8" value=""/>路（街道）</td>
					</tr>
					<tr>
						<td align="left" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;详细地址（号、户)<input type="text" size="40" id="aae006_5" value=""/></td>
					</tr>
					<tr><td colspan="2"></td></tr>
					<tr>
						<td align="left">邮政编码:<input id="aae007" type="text" />
						<td align="left">移动电话:<input id="aae005" type="text"  /></td>
					</tr>
						<tr><td colspan="2"><br/></td></tr>
						<tr><td colspan="2"><br></td></tr>
				</table>	
			</td>
			</tr>
		<tr>
		<td colspan="6" align="center"><input type="button" id="dosubmit" value="提交" size="15" class="menu_bj_1" /></td>
		</tr>
	</table>
	</form>
	    </div>
        </fieldset>
	</c:if>
	<c:if test="${po!=null}">
	<div id="displayjd">
	<center>您的个人权益单订制进度为：<span id="jd">${po.aae016}</span>,请耐心等待！</CENTER>
	<br/>
	<div style="color:#888888">
  通讯地址：${po.aae006 }</br>
  联系电话：${po.aae005 }</br>
  邮政编码：${po.aae007 }</br>
 中断原因：${po.aae013 }
 </div>
 </div>
	</c:if>
</body>
<script type="text/javascript">
$("#fd2").hide();
var aae016=$("#jd").html();
if(aae016=='0'){
	$("#jd").html("未处理")
}else if(aae016=='1'){
	$("#jd").html("已交邮局")
}else if(aae016=='2'){
	$("#jd").html("已邮寄")
}else if(aae016=='9'){
	$("#jd").html("中断")
}
function display(){
	$("#welcome").fadeOut("slow");
	$("#fd2").fadeIn("slow");
}
$(document).ready(function(){
		$("#aae005").blur(function(){
			 re1 = /^1\d{10}$/;//手机号
			if(!re1.test($(this).val())){
				alert('请填写正确手机号码');
				$(this).val('');
				}
			});
		$("#aae006").blur(function(){
			if($(this).val().length==0){
				alert('通讯地址不能为空！');
				}
			if($(this).val().length>=100){
				alert('通讯地址不能超过100个字符！');
				$(this).val('');
				}
			});
		$("#aae007").blur(function(){
			if($(this).val().length!=6||isNaN($(this).val())){
				alert('邮政编码格式不对！');
				$(this).val('');
				}
			});
		
	
	$("#dosubmit").click(function(){
		
		if($.trim($("#aae006_5").val())==''){
			alert('详细地址不能为空！');
			return;
			}
		var aae006=$("#aae006_1").val()+$("#aae006_2").val()+$("#aae006_3").val()+$("#aae006_4").val()+$("#aae006_5").val();
		if(aae006.length>=100){
			alert('通讯地址总长度不能超过100个字符！');
			return ;
			}
		if($.trim($("#aae005").val())==''){
			alert('电话不能为空！');
			return;
			}
		if($.trim($("#aae007").val())==''){
			alert('邮编不能为空！');
			return;
			}
		$.ajax({
			   type: "POST",
			   contentType: "application/x-www-form-urlencoded; charset=utf-8",
			   url: "${pageContext.request.contextPath}/work/f10010201/savePsOrder.action",
			   data: {aae005:$("#aae005").val(),aae006:aae006,aae007:$("#aae007").val()},
			   success: function(data){
				   if(data != null && data != ''){
						alert(data);
						return false;
						}else{
							alert('提交成功,请等待处理！');
							$("#dosubmit").attr("disabled", "disabled");
						}
			   }
			});
	});
});
</script>
</html>