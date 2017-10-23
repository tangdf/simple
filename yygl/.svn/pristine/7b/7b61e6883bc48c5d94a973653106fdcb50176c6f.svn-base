<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户登录</title>
<style type="text/css">
body, div, ul, ol, li, dl, dt, dd, h1, h2, h3, h4, h5, h6, p, span, em, strong, img, form, fieldset, input, textarea, button, pre, table, tr, th, td, blockquote, code, label, cite, i { padding: 0; margin: 0 }
.login { width: 100%; height: 400px; overflow: hidden; }
.lin { height: 35px; border-bottom: 1px solid #116aad; }
.lin li { width: 120px; text-align: center; height: 35px; float: left; display: inline; line-height: 35px; font-size: 14px; }
.lin li.current { width: 120px; text-align: center; height: 35px; float: left; display: inline; background: #00A2CA; line-height: 35px; color: #fff; }
.dn { display: none; }
</style>
</head>
<body>
<div class="login">
  <ul class="lin">
    <li class="current" onmouseover="tab('lin',0,3)" id="lin_title_0">城镇职工保险</li>
   <li onmouseover="tab('lin',1,3)" id="lin_title_1">居民养老保险</li>
     <li onmouseover="tab('lin',2,3)" id="lin_title_2">社会医疗保险</li>
  </ul>
  <div  id="lin_main_0" class="">
   <iframe id="mainframe0" src="<%=request.getContextPath()%>/pages/login_zg.jsp" frameborder="0"  style="width:100%;" height="440px" border="0"></iframe>
  </div>
  <div  id="lin_main_1" class="dn">
  <iframe id="mainframe1" src="<%=request.getContextPath()%>/pages/login_jmyl.jsp" frameborder="0"  style="width:100%;" height="440px" border="0"></iframe>
  </div> 
  <div  id="lin_main_2" class="dn">
  <iframe id="mainframe0" src="<%=request.getContextPath()%>/pages/login_shyl.jsp" frameborder="0"  style="width:100%;" height="440px" border="0"></iframe>
  </div>
</div>

</div>
<script type="text/javascript">

function tab(id,curnum,tnum){
			for (var i = 0; i< tnum;i++ ){
				if(curnum == i){
					document.getElementById(id+"_title_"+curnum).className = "current";
					document.getElementById(id+"_main_"+curnum).style.display = "block";
				}else{
					document.getElementById(id+"_title_"+i).className = "";
					document.getElementById(id+"_main_"+i).style.display = "none";
				}
			}
		}
</script>
</body>
</html>
