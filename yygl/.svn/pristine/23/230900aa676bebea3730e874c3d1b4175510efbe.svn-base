<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	    <script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
<title>个人信息</title>
 <style type="text/css"> 
            #progress {display:none;background: white; height: 20px; padding: 2px; border: 1px solid green; margin: 2px;} 
            #progress span {background: green; height: 16px; text-align: center; padding: 1px; margin: 1px; 
                display: block; color: yellow; font-weight: bold; font-size: 14px; width: 0%;} 
        </style> 
</head>
<body>
<form id="form1"  action="${pageContext.request.contextPath}/work/f100102/showPrint.action?vtype=${vtype}" method="post">
	<table>
		<tr>
		<td><font color="red">注：此证明每天只可打印一次，多次打印的以第一次打印时生成的信息为准。<br/> 点击【生成信息】按钮，生成打印信息</font></td></tr>
		<tr>
			<td>
				<input type="button" id="btn_submit"  value="生成信息" onclick="submit1()" />
				<div id="processId"></div>
			</td>
		</tr>
	</table>
<div id="progress"><span> </span></div> 

</form>		

</body>
<script type="text/javascript">
var progress_node_id = "progress"; 
function SetProgress(progress) { 
    if (progress) { 
        $("#" + progress_node_id + " > span").css("width", String(progress) + "%"); 
        $("#" + progress_node_id + " > span").html(String(progress) + "%"); 
    } 
} 

var i = 1; 
function doProgress() { 
    if (i <= 99) { 
        setTimeout("doProgress()", 500); 
        SetProgress(i); 
        i++; 
    } 
} 

function submit1(){
	$("#processId").text("查询过程中请耐心等待，不要关闭该页面正在准备打印数据，请稍候...");
	$("#form1").submit();
	document.getElementById("btn_submit").disabled = true;
	document.getElementById('progress').style.display ='block';
	doProgress();
}
</script>
</html>