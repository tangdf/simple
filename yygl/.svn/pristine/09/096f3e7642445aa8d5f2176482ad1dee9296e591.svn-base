<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>国家、省、市重点学科证明材料复印件</title>
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
<form action="#" enctype="multipart/form-data" method="post" target="upload-result" id="uploadForm" name="uploadForm">
    <fieldset id="fd3">
        <legend><span>文件上传</span></legend>
        <div class="fieldset-body">
        	<div>
        	<input id="lsh" name="lsh" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" visible="false"  /> 
            <input id="dataid" name="dataid" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  visible="false"  /> 
        	
        	</div>
            <div id="div1">
             <font color="red">注:国家、省、市重点学科证明材料复印件以照片形式上传</font></br>
            <input type="file" name="file" id="file_up1" size="40" onchange="selecton('file_up1')" />
            <a class="mini-button" iconCls="icon-add" onclick="addFile()" plain="true">新增</a> 
        	<a class="mini-button" iconCls="icon-cancel" onclick="cancelFile()" plain="true">删除</a>
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
 var url = '<%=request.getContextPath()%>/work/f20010117/queryXkzmInfo.action';
 Web.util.request(url,'POST',{},
	function(data){
		if(data!=null&&data!=''){
			var data1 = mini.decode(data); 
			form.setData(data1);
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
			    title: "重点学科证明材料附件", width: 1000, height: 600,
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
		//var data25=mini.get('data25').getValue();
		var options  = {    
		url:'<%=request.getContextPath() %>/work/f20010117/saveXkzmInfo.action',   
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
					//$("#dosubmit").attr("disabled", "disabled");
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
