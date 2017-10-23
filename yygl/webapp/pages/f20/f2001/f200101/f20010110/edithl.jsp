<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>护理人员申请信息</title>
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
<fieldset id="fd1">
        <legend><span>护理人员申请信息</span></legend>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="2">
           <colgroup align="right" width="10%"></colgroup>
           <colgroup align="left" width="30%"></colgroup>
           <colgroup align="right" width="20%"></colgroup>
           <colgroup align="left" width="30%"></colgroup>
                <tr>
                    <td class="form-label">姓名：</td>
                    <td >
                         <input id="data01" name="data01" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  required="true"/> 
                    </td>
                    <td class="form-label">性别：</td>
                    <td>
                          <input id="data03" class="mini-combobox" style="width:100px;" textField="text" valueField="id" emptyText="请选择..."
				       data="[{id:'1',text:'男'},{id:'2',text:'女'}]"  allowInput="true" showNullItem="true" nullItemText="请选择..." required="true"/> 
                    </td>
                </tr>
                <tr>
                    <td class="form-label">身份证号：</td>
                    <td >
                         <input id="data02" name="data02" class="mini-textbox" style="width:160px;"  vtype="maxLength:18" required="true" /> 
                    </td>
                    <td class="form-label">人员类别：</td>
                    <td>
                         <input id="data04" class="mini-combobox" style="width:100px;" textField="text" valueField="id" emptyText="请选择..."
				       data="[{id:'1',text:'退休'},{id:'2',text:'在职'}]"  allowInput="true" showNullItem="true" nullItemText="请选择..." required="true"/> 
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">资格证号:</td>
                    <td>
                          <input id="data05" name="data05" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" required="true" />  
                    </td>
                    <td class="form-label">执业（注册）证号：</td>
                    <td>
                    	<input id="data06" name="data06" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" required="true" />  
                     </td>
                </tr>
                 <tr>
                    <td class="form-label">职业类别：</td>
                    <td>
                        <input id="data07" class="mini-combobox" style="width:100px;" textField="text" valueField="id" emptyText="请选择..."
				       data="[{id:'1',text:'临床'},{id:'2',text:'中医'},{id:'3',text:'口腔'},{id:'4',text:'公共卫生'}]"  allowInput="true" showNullItem="true" nullItemText="请选择..." required="true"/>  
                      
                    </td>
                     <td class="form-label">职业范围：</td>
                    <td>
                         <input id="data08" name="data08" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" required="true" /> 
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">职称:</td>
                    <td>
                        <input id="data09" class="mini-combobox" style="width:100px;" textField="text" valueField="id" emptyText="请选择..."
				       data="[{id:'0',text:'无'},{id:'1',text:'初级'},{id:'2',text:'中级'},{id:'3',text:'高级'}]"  allowInput="true" showNullItem="true" nullItemText="请选择..." required="true"/>  
                      <input class="mini-hidden" id="clr"/>
                    </td>
                    <td class="form-label">所在科室：</td>
                    <td>
                        <input id="data10" name="data10" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" required="true" /> 
                    </td>
                </tr>
                 <tr>
                    <td class="form-label">备注：</td>
                    <td>
                         <input id="data11" name="data11" class="mini-textbox" style="width:160px;"  vtype="maxLength:100"  /> 
                    </td>
                </tr>
            </table>
        </div>
    </fieldset>
   <fieldset id="fd3">
        <legend><span>文件上传</span></legend>
        <div class="fieldset-body">
        	<div>
        	<input id="lsh" name="lsh" class="mini-textbox" style="width:160px;"  vtype="maxLength:50" visible="false"  /> 
            <input id="dataid" name="dataid" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  visible="false"  /> 
        	
        	</div>
            <div id="div1">
             <font color="red">注:以照片形式上传，每项材料如果是多张照片，必须合并成一张进行上传！</font></br>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证:<input type="file" name="file" id="file_up1" size="40" onchange="selecton('file_up1')" /><br />
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资格证:<input type="file" name="file" id="file_up2" size="40" onchange="selecton('file_up2')" /><br />
           &nbsp;&nbsp;&nbsp;执业（注册）证:<input type="file" name="file" id="file_up3" size="40" onchange="selecton('file_up3')" /><br />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;职称:<input type="file" name="file" id="file_up4" size="40" onchange="selecton('file_up4')" /><br />
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;退休材料:<input type="file" name="file" id="file_up5" size="40" onchange="selecton('file_up5')" />
           <!--  <a class="mini-button" iconCls="icon-add" onclick="addFile()"  plain="true">新增</a> 
        	<a class="mini-button" iconCls="icon-cancel" onclick="cancelFile()"  plain="true">删除</a>
        	<a class="mini-button" iconCls="icon-search" onclick="search()">查看附件</a> </br> -->
        	 <a class="mini-button" iconCls="icon-save" onclick="click()" id="dosubmit" plain="true">保存</a>   
            </div>
            
        </div>
        
    </fieldset>
     
    </form>
				
</body>
<script type="text/javascript">
mini.parse();
var form = new mini.Form("uploadForm");
 var FieldCount=1;
 //标准方法接口定义
	function SetData(data) {
		data = mini.clone(data);
		form.setData(data);
		mini.get('data03').setValue(data.data03);
		mini.get('data04').setValue(data.data04);
		mini.get('data07').setValue(data.data07);
		mini.get('data09').setValue(data.data09);
		mini.get('clr').setValue(data.clr);  
	}

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
$('#dosubmit').ajaxStart(function(){
	mini.mask({
			tl:document.body,
			cls:'mini-mask-loading',
			html:'加载中。。。'}
			);
});
$('#dosubmit').ajaxStop(function(){
	mini.unmask(document.body);
});
//$("#dosubmit").click(function(){ 
	function click(){
		document.getElementById("dosubmit").disabled=true;    
		var form1 = new mini.Form("uploadForm");     
        form1.validate();
        if (form1.isValid() == false){
        	document.getElementById("dosubmit").disabled=false;	
             return;
        }
		var form = $("form[name=uploadForm]");  
		var data03=mini.get('data03').getValue();
		var data04=mini.get('data04').getValue();
		var data07=mini.get('data07').getValue();
		var data09=mini.get('data09').getValue();
		var data02 = mini.get('data02').getValue();
		if(data02.length >18){
			mini.alert("身份证号不得大于18位");
			document.getElementById("dosubmit").disabled=false;
			return false;
		}
		//职称附件
		var clr = mini.get("clr").getValue();
		if(clr=="" || clr=="null"){
			var file_up4=$("#file_up4").val();
			if(data09!="0"){
				if(file_up4==''){
					alert("请上传职称附件");
					document.getElementById("dosubmit").disabled=false;
					return false;
				}
			}
		}
		var data01 = mini.get('data01').getValue();
		var data02 = mini.get('data02').getValue();
		var data03 = mini.get('data03').getValue();
		var data04 = mini.get('data04').getValue();
		var data05 = mini.get('data05').getValue();
		var data06 = mini.get('data06').getValue();
		var data07 = mini.get('data07').getValue();
		var data08 = mini.get('data08').getValue();
		var data09 = mini.get('data09').getValue();
		var data10 = mini.get('data10').getValue();
		var data11 = mini.get('data11').getValue();
		var dataid = mini.get('dataid').getValue();
		var lsh = mini.get('lsh').getValue();
		
		var options  = {    
		url:'<%=request.getContextPath() %>/work/f20010110/saveHlInfo.action?data03='+data03+'&data04='+data04+'&data07='+data07+'&data09='+data09,
			type:'post',    
			success:function(data)    
			 {    
				if(data != null && data != ''){
					map = $.parseJSON(data); 
					var status=map.status;
					if(status!= '' && status == '1'){
						mini.alert('保存成功！');
						document.getElementById("dosubmit").disabled=false;
					}else if(status!=''&&status=='2'){
						alert('已经提交，不能再次修改！');
						document.getElementById("dosubmit").disabled=false;
						return false;
					}else if(status!=''&&status=='3'){
						var name=map.name;
						alert(name);
						document.getElementById("dosubmit").disabled=false;
						return false;
					}
					mini.alert('保存成功！');
					document.getElementById("dosubmit").disabled=false;
					
				}else{
					alert('提交成功,请等待处理！');
				}
				closeWin();
			}    
		};    
		$.post('<%=request.getContextPath()%>/work/f20010108/validateYsInfo.action',
				{
					data01 : data01,
					data02 : data02,
					data03 : data03,
					data04 : data04,
					data05 : data05,
					data06 : data06,
					data07 : data07,
					data08 : data08,
					data09 : data09,
					data10 : data10,
					data11: data11,
					dataid:dataid,
					lsh:lsh
				},function(data){
					
					if(data != null && data != ''){
						map = $.parseJSON(data); 
						var status=map.status;
						if(status != ''&& status == 1){
							form.ajaxSubmit(options);
							document.getElementById("dosubmit").disabled=false;
						}else if(status!=''&&status=='3'){
							var name=map.name;
							alert(name);
							document.getElementById("dosubmit").disabled=false;
							return false;
						}else if(status != '' && status == '10'){
							var name=map.name;
							mini.confirm(name,"警告",function(action){
								if(action == "ok"){
									form.ajaxSubmit(options);
								}else{
									document.getElementById("dosubmit").disabled=false;
								}
							})
						}else{
							document.getElementById("dosubmit").disabled=false;
							return false;
						}
					}
					
				});
	}
	//});
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
	function closeWin(){
				CloseWindow();
			}
		
			 function CloseWindow(action) {            
		         if (window.CloseOwnerWindow){
		              return window.CloseOwnerWindow(action);
		         }else{
		             window.close();
		         }            
		     }
</script>
</html>
