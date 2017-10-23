<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>基本信息</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/fileupload/swfupload.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	   <link href="<c:url value="/resources/miniui/themes/blue/skin.css"/>" rel="stylesheet" type="text/css" />
	 <script type="text/javascript" src="<c:url value="/resources/miniui/jquery.js"/>"></script>
	 <script type="text/javascript" src="<c:url value="/resources/miniui/jquery.form.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}
    fieldset{border:solid 1px #aaa; padding:10px;}        
    </style>
</head>
<body>
<form action="<%=request.getContextPath()%>/work/f20010101/printJgInfo.action" method="post"  id="uploadForm" name="uploadForm">
<fieldset id="fd1">
        <legend><span>机构申请信息</span></legend>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="2">
           <colgroup align="right" width="25%"></colgroup>
           <colgroup align="left" width="25%"></colgroup>
           <colgroup align="right" width="25%"></colgroup>
           <colgroup align="left" width="25%"></colgroup>
                <tr>
                    <td class="form-label">单位名称：</td>
                    <td>
                         <input id="data01" name="data01" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" /> 
                    </td>
                    <td class="form-label">单位地址：</td>
                    <td>
                         <input id="data02" name="data02" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                   
                </tr>
                <tr>
                    <td class="form-label">法人姓名：</td>
                    <td >
                         <input id="data03" name="data03" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                    <td class="form-label">身份证号：</td>
                    <td>
                         <input id="data04" name="data04" class="mini-textbox" style="width:160px;"  vtype="maxLength:18"  /> 
                    </td>
                </tr>
                <tr>
                    <td class="form-label">联系人：</td>
                    <td >
                         <input id="data05" name="data05" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                    <td class="form-label">联系电话：</td>
                    <td>
                         <input id="data06" name="data06" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">所有制类型:</td>
                    <td>
                        <input id="data07" class="mini-combobox" style="width:100px;" textField="text" valueField="id" emptyText="请选择..."
				       data="[{id:'1',text:'公立'},{id:'3',text:'私营'}]"  allowInput="true" showNullItem="true" nullItemText="请选择..."/> 
                    </td>
                    <td class="form-label">机构类别：</td>
                    <td>
                       <input id="data08" class="mini-combobox" style="width:100px;" textField="text" valueField="id" emptyText="请选择..." required="true"
				       data="[{id:'10',text:'其它'},{id:'11',text:'综合'},{id:'12',text:'中医'},{id:'13',text:'眼科'},{id:'14',text:'妇产'},{id:'15',text:'中西医结合'},{id:'16',text:'肿瘤'},{id:'17',text:'精神病医院'},{id:'18',text:'康复医院'}]" allowInput="false" showNullItem="true" nullItemText="请选择..."/> 
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">性质：</td>
                    <td>
                            <input id="data09" class="mini-combobox" style="width:100px;" textField="text" valueField="id" emptyText="请选择..."
				       data="[{id:'1',text:'盈利'},{id:'2',text:'非盈利'}]"   allowInput="true" showNullItem="true" nullItemText="请选择..."/> 
                    </td>
                     <td class="form-label">邮政编码：</td>
                    <td>
                         <input id="data10" name="data10" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">实行药品零差率:</td>
                    <td>
                        <input id="data11" class="mini-combobox" style="width:100px;" textField="text" valueField="id" emptyText="请选择..."
				       data="[{id:'1',text:'实行'},{id:'3',text:'不实行'}]"  allowInput="true" showNullItem="true" nullItemText="请选择..."/> 
                    </td>
                    <td class="form-label">医疗机构等级：</td>
                    <td>
                       <input id="data12" class="mini-combobox" style="width:100px;" textField="text" valueField="id" emptyText="请选择..."
				       data="[{id:'1',text:'一级'},{id:'2',text:'二级'},{id:'3',text:'三级'},{id:'4',text:'社区'}]"  allowInput="true" showNullItem="true" nullItemText="请选择..."/> 
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">床位数(张)：</td>
                    <td>
                         <input id="data13" name="data13" class="mini-textbox" style="width:160px;"   vtype="float" required="true" /> 
                    </td>
                    <td class="form-label">固定资产(万元)：</td>
                    <td>
                         <input id="data14" name="data14" class="mini-textbox" style="width:160px;"  vtype="float" required="true" /> 
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">年业务收入(万元)：</td>
                    <td>
                         <input id="data15" name="data15" class="mini-textbox" style="width:160px;"  vtype="float" required="true" /> 
                    </td>
                    <td class="form-label"></td>
                    <td>
                         <input id="lsh" name="lsh" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" visible="false"  /> 
                         <input id="dataid" name="dataid" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  visible="false"  /> 
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">住院人次(人次/年)：</td>
                    <td>
                         <input id="data16" name="data16" class="mini-textbox" style="width:160px;"   vtype="float" required="true" /> 
                    </td>
                    <td class="form-label">门诊人次(人次/年)：</td>
                    <td>
                         <input id="data17" name="data17" class="mini-textbox" style="width:160px;"    vtype="float" required="true"/> 
                    </td>
                </tr>
                <tr>
                    <td class="form-label">《设置医疗机构批准书》批准文号：</td>
                    <td>
                         <input id="data18" name="data18" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                    <td class="form-label">《医疗机构执业许可证》登记号：</td>
                    <td>
                         <input id="data19" name="data19" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                </tr>
                <tr>
                    <td class="form-label">《营业执照》注册号：</td>
                    <td>
                         <input id="data20" name="data20" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                    <td class="form-label">《事业单位法人证书》证号：</td>
                    <td>
                         <input id="data21" name="data21" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                </tr>
                <tr>
                    <td class="form-label">《民办非企业单位登记证书》证号：</td>
                    <td>
                         <input id="data22" name="data22" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                    <td class="form-label">等级评审批准文件文号：</td>
                    <td>
                         <input id="data23" name="data23" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                </tr>
            </table>
        </div>
    </fieldset>
    <fieldset id="fd4">
        <legend><span>医疗机构简介</span></legend>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="2">
           <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="85%"></colgroup>
                <tr>
                    <td class="form-label">医疗机构简介：</td>
                    <td>
                         <input id="data24" name="data24" class="mini-textarea" style="width:600px;" required="true"  vtype="maxLength:500"  /> 
                    </td>
                </tr>
            </table>
        </div>
    </fieldset>
      <a class="mini-button" iconCls="icon-save" onclick="saveData()" id="dosubmit" plain="true">保存</a>  
    <!--    <a class="mini-button" iconCls="icon-save" onclick="saveData()" id="dosubmit1" plain="true">提交</a> --> 
       <a class="mini-button" onclick="search()">大型医疗设备情况</a>
         <!--    <a class="mini-button" iconCls="icon-print" onclick="printjg()">机构信息打印</a>--> 
       	<table>
		<tr>
			<td>
				<a class="mini-button" id="btn_submit" iconCls="icon-print" onclick="printjg()">机构信息打印</a>
				<div id="processId"></div>
			</td>
		</tr>
	</table>
<div id="progress"><span> </span></div> 
    </form>
 <!-- <form action="<%=request.getContextPath() %>/work/f20010101/saveYljgInfo.action" enctype="multipart/form-data" method="post" target="upload-result" id="uploadForm" name="uploadForm">
    <fieldset id="fd3">
        <legend><span>文件上传</span></legend>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="4">
           <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
          <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
          <colgroup align="right" width="15%"></colgroup>
           <colgroup align="left" width="15%"></colgroup>
                <tr>
                	 <td class="form-label">机构名称：</td>
                    <td>
                    	 <input id="data01" name="data01" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  /> 
                    </td>
                    <td class="form-label">附件上传：</td>
                    <td>
                    	<input type="file" name="file" id="file_up1" size="40" onchange="selecton('file_up1')" />
                    	<input type="file" name="file" id="file_up2" size="40" onchange="selecton('file_up2')" />
                    </td>
                </tr>
            </table>
        </div>
    </fieldset>
      
</form>
				<iframe id="upload-result" name="upload-result" frameborder="0" width="100%" height="30" style="display:none">
				</iframe> -->			
				
</body>
<script type="text/javascript">
mini.parse();
//加载数据
 var url = '<%=request.getContextPath()%>/work/f20010101/queryYljgInfo.action';
 Web.util.request(url,'POST',{},
	function(data){
		if(data!=null&&data!=''){
			mini.get('lsh').setValue(data['lsh']);
			mini.get('dataid').setValue(data['dataid']);
			for (var v in data){
				if(data[v]!=null&&data[v]!=''){
					var obj = mini.get(v);
					obj.setValue(data[v]);
				}
			}	
			
		}
	}
);
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

function printjg(){
	$("#processId").text("查询过程中请耐心等待，不要关闭该页面正在准备打印数据，请稍候...");
	$("#uploadForm").submit();
	document.getElementById("btn_submit").disabled = true;
	document.getElementById('progress').style.display ='block';
	doProgress();
}
/** function printjg(){
 	 var lsh=mini.get('lsh').getValue();
 	 
 	 if(lsh==''){
 	 	alert('请先保存机构信息，再打印！');
 	 	return false;
 	 }
 	var url= '<%=request.getContextPath()%>/work/f20010101/printJgInfo.action?lsh='+lsh;
	window.showModalDialog(url,"help:no;status:no;",
						"dialogWidth:72;dialogHeight:700px");
			
 }**/
     function search() {
			mini.open({
			    url: '<%=request.getContextPath()%>/pages/f20/f2001/f200101/f20010101/mequipment.jsp',
			    title: "大型医疗设备", width: 620, height: 400,
			    onload: function () {
			        var iframe = this.getIFrameEl();
			        var lsh=mini.get('lsh').getValue();
			        var dataid=mini.get('dataid').getValue();
			        var data = { lsh: lsh,dataid:dataid};
			        iframe.contentWindow.SetData(data);
			    }
			});
        }
	$("#dosubmit").click(function(){
		//form表单校验
		var fm = new mini.Form("#uploadForm");
		fm.validate();
        if (fm.isValid() == false) return;
		document.getElementById("dosubmit").disabled=true;
		var form = $("form[name=uploadForm]");  
		var data07=mini.get('data07').getValue();
		var data08=mini.get('data08').getValue();
		var data09=mini.get('data09').getValue();
		var data11=mini.get('data11').getValue();
		var data12=mini.get('data12').getValue();
		var data04 = mini.get('data04').getValue();
		if(data04.length>18){
			mini.alert("身份证号不得大于18位");
			document.getElementById("dosubmit").disabled=false;
			return false;
		}
		var options  = {    
		url:'<%=request.getContextPath() %>/work/f20010101/saveYljgInfo.action?data07='+data07+'&data08='+data08+'&data09='+data09+'&data11='+data11+'&data12='+data12,   
			type:'post',    
			success:function(data)    
			 {    
				if(data != null && data != ''){
					
					map = $.parseJSON(data); 
					var status=map.status;
					if(status!=''&&status=='2'){
						alert('已经提交，不能再次修改！');
						document.getElementById("dosubmit").disabled=false;
						return false;
					}
					mini.get('lsh').setValue(map.lsh);
					mini.get('dataid').setValue(map.dataid);
					alert('保存成功！');
					document.getElementById("dosubmit").disabled=false;
				}else{
					alert('提交成功,请等待处理！');
					document.getElementById("dosubmit").disabled=false;
					//$("#dosubmit").attr("disabled", "disabled");
				} 
			}    
		};    
		form.ajaxSubmit(options);
	});
//判断上传类型
	function selecton(id){
	  	var s=document.getElementById(id);
	  	var  aa=s.value;
		var re = /.jpg$/i;
		var re1 = /.png$/i;
		var re2 = /.bmp$/i;
		var re3 = /.gif$/i;
		var re4 = /.jpeg$/i;
		var re5 = /.doc$/i;
		var re6 = /.docx$/i;
		if(re.test(aa)||re1.test(aa)||re2.test(aa)||re3.test(aa)||re4.test(aa)||re5.test(aa)||re6.test(aa)){
		}else{
			  alert('只允许上传图片或者WORD格式，请重新上传!');
		      s.outerHTML=s.outerHTML;
	  	}
	}
</script>
</html>
