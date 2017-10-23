<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>医疗机构执业许可证</title>
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
<form action="<%=request.getContextPath() %>/work/f20010103/saveXkzInfo.action" enctype="multipart/form-data" method="post" target="upload-result" id="uploadForm" name="uploadForm">
    <fieldset id="fd3">
        <legend><span>文件上传</span></legend>
        <div class="fieldset-body">
        	<div>
        	<input id="lsh" name="lsh" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" visible="false"  /> 
            <input id="dataid" name="dataid" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  visible="false"  /> 
        	开始日期 : 
        	<input name="data26" id="data26" class="mini-datepicker"  dateFormat="yyyyMMdd" /> 
        	&emsp;终止日期 : 
        	<input name="data25" id="data25" class="mini-datepicker"  dateFormat="yyyyMMdd" /> 
        	</div>
            <div id="div1">
             <font color="red">注:《医疗机构执业许可证》正、副本复印件以照片形式上传</font></br>
            <input type="file" name="file" id="file_up1" size="40" onchange="selecton('file_up1')" />
            <a class="mini-button" iconCls="icon-add" onclick="addFile()"  plain="true">新增</a> 
        	<a class="mini-button" iconCls="icon-cancel" onclick="cancelFile()"  plain="true">删除</a>
        	<a class="mini-button" iconCls="icon-save" onclick="saveData()" id="dosubmit" plain="true">保存</a> 
        	<a class="mini-button" iconCls="icon-edit" onclick="search()">编辑附件</a> </br>
            </div>
            
        </div>
        
    </fieldset>
    
</form>

<script type="text/javascript">
mini.parse();
var form = new mini.Form("#uploadForm");
//加载数据
 var url = '<%=request.getContextPath()%>/work/f20010103/queryXkzInfo.action';
 Web.util.request(url,'POST',{},
	function(data){
		if(data!=null&&data!=''){
			var data1 = mini.decode(data); 
			form.setData(data1);
			//alert(mini.get('lsh').getValue());
			/**mini.get('lsh').setValue(data['lsh']);
			//alert(data['lsh'])
			for (var v in data){
				if(data[v]!=null&&data[v]!=''){
					//alert(data[v]);
					var obj = mini.get(v);
					obj.setValue(data[v]);
				}
			}	**/
		}
	}
);

var FieldCount=1;
function addFile(){
 	FieldCount++;
	$("#div1").append("<input type=\"file\" name=\"file\" id=\"file_up"+FieldCount+"\" size=\"40\" onchange=\"selecton('file_up"+FieldCount+"')\" />");

}

function cancelFile(){
	if(FieldCount>1){
		$("#file_up"+FieldCount).remove();
		FieldCount=FieldCount-1;
		//alert(FieldCount);
	}
	
}
function search() {
			mini.open({
			    url: '<%=request.getContextPath()%>/pages/f20/f2001/f200101/f20010103/clfj.jsp',
			    title: "许可证附件", width: 1000, height: 600,
			    onload: function () {
			        var iframe = this.getIFrameEl();
			        var lsh=mini.get('lsh').getValue();
			        var dataid=mini.get('dataid').getValue();
			        var data = { lsh: lsh,dataid:dataid};
			        iframe.contentWindow.SetData(data);
			    }
			});
        }
function saveData(){
		document.getElementById("dosubmit").disabled=true;
	    var form = $("form[name=uploadForm]");  
	    var data26=mini.get('data26').getValue();
		var data25=mini.get('data25').getValue();
		if(data26=="" || data26=="null"){
			alert("请选择开始日期！");
			document.getElementById("dosubmit").disabled=false;
			return;
		}
		/**var data = form.getData();      //获取表单多个控件的数据
		var json = mini.encode(data);   //序列化成JSON
		$.ajax({
		    url: '<%=request.getContextPath() %>/work/f20010103/saveXkzInfo.action',  
		    type: "post",
		    data: { submitData: json },
		    success: function (text) {
		        alert("提交成功，返回结果:" + text);
		    }
		});**/
		var options  = {    
		url:'<%=request.getContextPath() %>/work/f20010103/saveXkzInfo.action?data25='+data25+'&data26='+data26, 
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
					}else if(status!=''&&status=='3'){
						var name=map.name;
						alert(name);
						document.getElementById("dosubmit").disabled=false;
						return false;
					}
					mini.get('lsh').setValue(map.lsh);
					mini.get('dataid').setValue(map.dataid);
					alert('保存成功！');
					document.getElementById("dosubmit").disabled=false;
					//清除附件信息
					for(var i=1;i<=FieldCount;i++){
						var s=document.getElementById("file_up"+i);
						s.outerHTML=s.outerHTML;
					}
				}else{
					alert('提交成功,请等待处理！');
					document.getElementById("dosubmit").disabled=false;
				} 
			}    
		};    
		form.ajaxSubmit(options);
		
}
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
		if(re.test(aa)||re1.test(aa)||re2.test(aa)||re3.test(aa)||re4.test(aa)){
		}else{
			  alert('只允许上传图片格式，请重新上传!');
		      s.outerHTML=s.outerHTML;
	  	}
	}
</script>
</body>
</html>
