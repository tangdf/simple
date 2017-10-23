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
<fieldset id="fd1">
        <legend><span>单位信息</span></legend>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="4">
           <colgroup align="right" width="10%"></colgroup>
           <colgroup align="left" width="20%"></colgroup>
           <colgroup align="right" width="10%"></colgroup>
           <colgroup align="left" width="20%"></colgroup>
           <colgroup align="right" width="10%"></colgroup>
           <colgroup align="left" width="20%"></colgroup>
                <tr>
                    <td class="form-label">单位编号：</td>
                    <td>
                         <span id="aab001"></span>
                    </td>
                    <td class="form-label">单位类型：</td>
                    <td>
                         <span id="aab019"></span>
                    </td>
                    <td class="form-label">单位状态：</td>
                    <td>
                         <span id="aae119"></span>
                    </td>
                </tr>
                <tr>
                    <td class="form-label">行政区划：</td>
                    <td >
                         <span id="zab001"></span>
                    </td>
                    <td class="form-label">单位名称：</td>
                    <td colspan="3">
                         <span id="aab004"></span>
                    </td>
                </tr>
            </table>
        </div>
    </fieldset>
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
                    <td class="form-label">性别：</td>
                    <td >
                        <span id="aac004"></span>
                    </td>
                    <td class="form-label">参加工作日期：</td>
                    <td>
                         <span id="aac007"></span>
                    </td>
               		 <td class="form-label">出生日期：</td>
                    <td>
                        <span id="aac006"></span>
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">人员状态：</td>
                    <td >
                        <span id="aac008"></span>
                    </td>
                    <td class="form-label">民族：</td>
                    <td>
                         <span id="aac005"></span>
                    </td>
               		 <td class="form-label">特殊工种：</td>
                    <td>
                       <span id="aac019"></span>
                    </td>
                </tr>
                <tr>
                    <td class="form-label">退休类别：</td>
                    <td >
                        <span id="aac022"></span>
                    </td>
                    <td class="form-label">养老统筹级别：</td>
                    <td>
                        <span id="aac021"></span>
                    </td>
               		 <td class="form-label">保健类别：</td>
                    <td>
                       <span id="aac017"></span>
                    </td>
                </tr>
                <tr>
                    <td class="form-label">特殊缴费类型：</td>
                    <td >
                       <span id="ckc204"></span>
                    </td>
                    <td class="form-label">养老视同月数：</td>
                    <td>
                       <span id="aic001"></span>
                    </td>
               		 <td class="form-label">养老建账户前月数：</td>
                    <td>
                        <span id="aic002"></span>
                    </td>
                </tr>
                <tr>
                    <td class="form-label">制卡状态：</td>
                    <td >
                        <span id="zkzt"></span>
                    </td>
                    <td class="form-label">发卡银行：</td>
                    <td>
                         <span id="yhbm"></span>
                    </td>
               		 <td class="form-label">银行地址：</td>
                    <td>
                        <span id="jbwddz"></span>
                    </td>
                </tr>
            </table>
        </div>
    </fieldset>
</body>
<script type="text/javascript">
//加载数据
 var url = '<%=request.getContextPath()%>/work/f10010101/loadUserInfo.action';
 Web.util.request(url,'POST',{},
	function(data){
		for (var v in data){
			 if('zkzt'==v){
				 	//如果是制卡状态，需要字典转换
					$("#"+v).html(codeRender(v,data[v]));
			  }else{
			  	$("#"+v).html(data[v]);
			  }
			}
	}
);
</script>
</html>
