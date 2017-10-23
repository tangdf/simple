<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>社保卡个人申领</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}
    fieldset{border:solid 1px #aaa; padding:10px;}        
    </style>
</head>
<body>

    <fieldset id="fd1">
        <legend><span>个人信息</span></legend>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="4">
           <colgroup align="right" width="10%"></colgroup>
           <colgroup align="left" width="10%"></colgroup>
          <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="25%"></colgroup>
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
                    <td class="form-label">民族：</td>
                    <td>
                         <span id="aac005"></span>
                    </td>
               		 <td class="form-label">出生日期：</td>
                    <td>
                        <span id="aac006"></span>
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">照片：</td>
                    <td >
                        <span id="photo"></span>
                    </td>
                    <td class="form-label">照片上传：</td>
                    <td colspan="3">
                         <span id="photo1">此功能正在开发中，无制卡照片者请先到发卡银行指定网点现场采集照片！</span>
                    </td>
                </tr>
               <tr><td colspan="6" align="left"><font color="red">注：上述信息如果有误，请携带有关证明材料到参保所在地的社会保险经办机构修改。</font></td></tr>
            </table>
        </div>
    </fieldset>
    <div id="form1">
    <fieldset id="fd2">
        <legend><span>制卡银行选定</span></legend>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="4">
           <colgroup align="right" width="10%"></colgroup>
           <colgroup align="left" width="30%"></colgroup>
          <colgroup align="right" width="10%"></colgroup>
           <colgroup align="left" width="50%"></colgroup>
                <tr>
                    <td class="form-label">经办银行：</td>
                    <td>
                       <input id="aea001One" class="mini-combobox" style="width:150px;" textField="aaa103" valueField="aaa102" emptyText="请选择..."
    url="<%=request.getContextPath()%>/work/f10010901/queryYhlb.action"  onvaluechanged="onYhchanged" required="true"  showNullItem="true" nullItemText="请选择..."/>
                    </td>
                    <td class="form-label">经办网点：</td>
                    <td colspan="3">
                        <input id="nodeid" name="nodeid"  class="mini-combobox" textField="aaa103" valueField="aaa102" required="true"
                         onvaluechanged="onWdchanged" style="width:250px" showNullItem="false" /> 
                    </td>
                </tr>
               <tr>
                    <td class="form-label">网点电话：</td>
                    <td>
                       <input id="wddh" name="wddh" class="mini-textbox" readOnly="readonly" style="width:240px" vtype="maxLength:50" /> 
                    </td>
                    <td class="form-label">网点地址：</td>
                    <td colspan="3">
                        <input id="wddz" name="wddz" class="mini-textbox" readOnly="readonly" style="width:250px" vtype="maxLength:100" /> 
                    </td>
                </tr>
            </table>
        </div>
    </fieldset>
    <fieldset id="fd3">
        <legend><span>个人信息补充</span></legend>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="4">
           <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
          <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
          <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
                <tr>
                    <td class="form-label">移动电话1：</td>
                    <td>
                        <input id="aae005" name="aae005" class="mini-textbox" required="true" vtype="int;maxLength:11" /> 
                    </td>
                    <td class="form-label">移动电话1：</td>
                    <td>
                        <input id="ext3" name="ext3" class="mini-textbox" vtype="int;maxLength:11"   /> 
                    </td>
                    <td class="form-label">固定电话：</td>
                    <td>
                        <input id="ext1" name="ext1" class="mini-textbox" vtype="int"  vtype="maxLength:20" /> 
                    </td>
                </tr>
                <tr>
                    <td class="form-label">邮政编码：</td>
                    <td >
                        <input id="aae007" name="aae007" class="mini-textbox"   vtype="maxLength:6" /> 
                    </td>
                    <td class="form-label">通讯地址：</td>
                    <td colspan="3">
                        <input id="aae006" name="aae006" class="mini-textbox" style="width:200px;"  vtype="maxLength:100" /> 
                    </td>
                    </tr>
            </table>
        </div>
    </fieldset>
    </div>
    注意事项：<br/>
1、通过银行参保缴费的灵活就业人员,务必提供真实有效手机号码，便于银行跟您联系制卡事宜。<br/>
2、您提交的社保卡申领信息，将于次日0:00生效，请您见谅。<br/>
3、如有不明之处，请咨询12345市政务服务热线。
<center>
	    <a class="mini-button" id="dosubmit" onclick="onClick" >提&nbsp;&nbsp;&nbsp;&nbsp;交</a>
</center>
</body>
<script type="text/javascript">
mini.parse();
function onYhchanged(){
	var aea001One=mini.get("aea001One").getValue();
	var nodeid=mini.get("nodeid");
	nodeid.setValue("");
	mini.get("wddh").setValue("");
	mini.get("wddz").setValue("");
	var url="<%=request.getContextPath()%>/work/f10010901/queryWdbm.action?aea001One="+aea001One;
	nodeid.setUrl(url);
	//nodeid.select(0);
}
function onWdchanged(){
	var nodeid=mini.get("nodeid").getValue();
	var wddh=mini.get("wddh");
	var wddz=mini.get("wddz");
	wddh.setValue("");
	wddz.setValue("");
	var url="<%=request.getContextPath()%>/work/f10010901/queryWdxx2.action?nodeid="+nodeid;
	 Web.util.request(url,'POST',{},
		function(data){
			mini.get("wddz").setValue(data[0].aaa102);
			mini.get("wddh").setValue(data[0].aaa103);
		});
}
//提交
function onClick(){
	 var form = new mini.Form("#form1");
     form.validate();
     if (form.isValid() == false) return;
     var url="<%=request.getContextPath()%>/work/f10010901/saveSbkApplyInfo.action";
     Web.util.formSubmit("form1",url,"post",function(){
    	 mini.alert("您修改的社保卡申领信息已提交成功，将于次日0:00生效，新卡制成后，<br>银行会电话通知您办理领卡、激活手续。<br>如有疑问请致电您选择的银行网点！");
    	 $("#dosubmit").hide();
     });
}
//加载数据
 var url = '<%=request.getContextPath()%>/work/f10010901/querySbkApplyInfo.action';
 Web.util.request(url,'POST',{},
	function(data){
			      $("#aac001").html(data["aac001"]);
			      $("#aac002").html(data["aac002"]);
			      $("#aac003").html(data["aac003"]);
			      $("#aac004").html(data["aac004"]);
			      $("#aac005").html(data["aac005"]);
			      $("#aac006").html(data["aac006"]);
			      $("#photo").html(data["photo"]);
			      mini.get("aea001One").setValue(data["jbyh"]);
			      mini.get("nodeid").setValue(data["nodeid"]);
			      mini.get("wddz").setValue(data["wddz"]);
			      mini.get("wddh").setValue(data["wddh"]);
			      
			      //如果已经绑定不再显示个人补充信息
			      if(mini.get("nodeid").getValue()!=''&&mini.get("nodeid").getValue()!=null){
			    	  mini.get("aea001One").setReadOnly(true);
			    	  mini.get("nodeid").setReadOnly(true);
			    	  $("#fd3").hide();
			      }else{
			      mini.get("aae005").setValue(data["aae005"]);
			      mini.get("ext3").setValue(data["ext3"]);
			      mini.get("ext1").setValue(data["ext1"]);
			      mini.get("aae006").setValue(data["aae006"]);
			      mini.get("aae007").setValue(data["aae007"]);
			      }
			      //显示已经绑定的提示信息
			      if(data.lsh!=null&&data.lsh!=''){
			    	  mini.alert("您已办理社保卡申领，办理编号为："+data.lsh);
			    	  $("#dosubmit").hide();
			      }
			      if(data.lsh1!=null&&data.lsh1!=''){
			    	  mini.alert("您已办理社保卡申领，不能再次办理，谢谢！");
			    	  $("#dosubmit").hide();
			      }
	}
);

</script>
</html>
