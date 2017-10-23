<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>量化评分表查询</title>
	<script type="text/javascript" src="<c:url value="/resources/miniui/boot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/frame.js"/>"></script>
	 <style type="text/css">
	body{background-color:#fff;}   
	fieldset{border:solid 1px #aaa; padding:10px;} 
    </style>
</head>
<body>
	
	<input id="bz" name="bz" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  visible="false" value="1" /> 
   <!-- <input id="dataid" name="dataid" class="mini-textbox" style="width:160px;"  vtype="maxLength:50"  visible="false"  />  --> 
    <div style="width:100%;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-save" onclick="saveData()" plain="true">保存</a>  
                         <a class="mini-button" iconCls="icon-save" onclick="saveData1()" plain="true">提交</a>          
                    </td>
                </tr>
            </table>           
        </div>
    </div>
    <div id="datagrid1" class="mini-datagrid" style="width:100%;height:360px;" 
        url="<%=request.getContextPath()%>/work/f20010118/queryLhpfbInfo.action"  idField="id" 
        allowResize="true" oncellcommitedit="OnCellCommitEdit"
        allowCellEdit="true" allowCellSelect="true" multiSelect="true" pageSize="20" oncellbeginedit="OnCellBeginEdit"
        editNextOnEnterKey="true"  editNextRowCell="true" ondrawsummarycell="onDrawSummaryCell" showSummaryRow="true"  >
        <div property="columns">
         	<div name="dataid" field="dataid" headerAlign="center" align="center"   ></div>  
         	<div name="lsh" field="lsh" headerAlign="center" align="center"   >流水号</div> 
         	<div name="status" field="status" headerAlign="center" align="center"   ></div>  	
         	<div name="action" width="120" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;">#</div>
            <div name="data01"  field="data01" headerAlign="center" allowSort="true" width="250" >评定项目
            </div> 
            <div name="data02"  field="data02" headerAlign="center" allowSort="true" width="150" ><font color="red"> 医院项目内容</font>
            	<input property="editor" class="mini-textbox" style="width:100%;" minWidth="50" />
            </div> 
            <div name="data29"  field="data29" headerAlign="center" allowSort="true" width="300" >基准分标准
            </div> 
            <div name="data04"  field="data04" headerAlign="center" allowSort="true" width="50" >基准分
            </div>    
            <div name="data05"  field="data05" headerAlign="center"  allowSort="true" width="50" ><font color="red"> 自评分</font>
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="50" />
            </div>  
            <div name="data99"  field="data99" headerAlign="center" allowSort="true" width="70" >系统打分
            </div>
            <div name="data30"  field="data30" headerAlign="center" allowSort="true" width="300" >择优分标准
            </div>   
            <div name="data07"  field="data07" headerAlign="center" allowSort="true" width="200" >医院加分条件
            </div> 
            <div name="data08"  field="data08" headerAlign="center" allowSort="true" width="150" >择优最高加分
            </div> 
            <div name="data09"  field="data09" headerAlign="center"  allowSort="true" width="50" ><font color="red"> 自评分</font>
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="50" />
            </div>
            <div name="data100"  field="data100" headerAlign="center" allowSort="true" width="70" >系统打分
            </div> 
            <div name="data10"  field="data10" headerAlign="center" allowSort="true" width="70" >查看材料</div>  
              
             <div name="data19"  field="data19" headerAlign="center" allowSort="true" width="150" >经办人</div> 
            <div name="data20"  field="data20" headerAlign="center" allowSort="true" width="150"  dateFormat="yyyy-MM-dd">经办时间</div>                
        </div>
    </div>
    <script type="text/javascript">
        
        mini.parse();
		query();
        var grid = mini.get("datagrid1");
        grid.hideColumn("dataid");
        // grid.hideColumn("lsh");
          grid.hideColumn("status");
          grid.hideColumn("data10");
        //加载数据
		function query(){
		 	Web.util.load("datagrid1",{bz:mini.get('bz').getValue()});
		}
		function queryData(){
			query();
		}
		 function shjg(e) {
            if (e.value == 1) return "通过";
            else if(e.value == 2)  return "不通过";
            else  return "";
        }
        function OnCellCommitEdit(e) {
            var grid = e.sender;
            var record = e.record;
            var field = e.field;
            var value = e.value;
            var uid = record._uid;
            var row = grid.getRowByUID(uid); 
            //校验数字
            if(!/^[0-9]*$/.test(value)){
				alert("请输入数字！");
				e.cancel = true;
				return;
            }
            if(field=='data05'){
            	var data04=parseInt(row.data04);
               	if(value!=0 && value!=data04){
               		alert("自评分只能为0或"+data04+"!");
               		e.cancel = true;
               	}
            	/*if(value>data04){
            		alert("自评分不能大于基准分！");
            		e.cancel = true;
            	}*/
            	//基础分评分只能有0和规定分值
            	
            }
            if(field=='data09'){
            	var data08=parseInt(row.data08);
               	if(value>data08){
               		alert("自评分不能大于择优最高加分！");
               		e.cancel = true;
               	}          	
            }
         }
        /////////////--------20170809------//////////////////////////
		function OnCellBeginEdit(e) {
		    var record = e.record, field = e.field;

			/*------------设置第18-20项自评分和业务人员评分变灰---------------*/
		    if (field == "data05" && (e.rowIndex=="17"||e.rowIndex=="18"||e.rowIndex=="19")) {
		        e.cancel = true;    //第18-20行，自评分不允许修改
		    }
		    /*------------择优评分部分,无加分内容项变灰---------------*/
		    if (field == "data09" && (e.rowIndex=="1"||e.rowIndex=="4"||e.rowIndex=="5"||e.rowIndex=="6"
			    	||e.rowIndex=="8"||e.rowIndex=="12"||e.rowIndex=="14"||e.rowIndex=="15"||e.rowIndex=="16")) {
		        e.cancel = true;
		    }
		}
		
         function onDrawSummaryCell(e) {
            var result = e.result;
            var grid = e.sender;
            var rows = e.data;
            
            if (e.field == "data05") {
                var total = 0;
                for (var i = 0, l = rows.length; i < l; i++) {
                    var row = rows[i];
                    var t = row.data05;
                    if(t!=''){
                    	total += parseInt(t);
                    }
                    
                }
                e.cellHtml = "总计: " + total;
            }if (e.field == "data04") {
                var total = 0;
                for (var i = 0, l = rows.length; i < l; i++) {
                    var row = rows[i];
                    var t = row.data04;
                    if(t!=''){
                    	total += parseInt(t);
                    }
                    
                }
                e.cellHtml = "总计: " + total;
            }if (e.field == "data08") {
                var total = 0;
                for (var i = 0, l = rows.length; i < l; i++) {
                    var row = rows[i];
                    var t = row.data08;
                    if(t!=''){
                    	total += parseInt(t);
                    }
                    
                }
                e.cellHtml = "总计: " + total;
            }if (e.field == "data09") {
                var total = 0;
                for (var i = 0, l = rows.length; i < l; i++) {
                    var row = rows[i];
                    var t = row.data09;
                    if(t!=''){
                    	total += parseInt(t);
                    }
                    
                }
                e.cellHtml = "总计: " + total;
            }if (e.field == "data21") { //基准分自动打分
                var total = 0;
                for (var i = 0, l = rows.length; i < l; i++) {
                    var row = rows[i];
                    var t = row.data21;
                    if(t!=''){
                    	total += parseInt(t);
                    }
                    
                }
                e.cellHtml = "总计: " + total;
            }if (e.field == "data22") { //择优分自动打分
                var total = 0;
                for (var i = 0, l = rows.length; i < l; i++) {
                    var row = rows[i];
                    var t = row.data22;
                    if(t!=''){
                    	total += parseInt(t);
                    }
                    
                }
                e.cellHtml = "总计: " + total;
            }            
        }
		function createData(){
			$.ajax({
	                url: "<%=request.getContextPath() %>/work/f20010118/createLhpfbInfo.action",
	                data: { },
	                type: "post",
	                success: function (data) {
	                	if(data=='1'){
	                		alert('生成成功！');
	                		query();
	                	}else if(data=='2'){
	                		alert('已经生成或者没有审核不通过的信息，不需要再生成！');
	                	}else{
	                		alert('不是此业务信息！');
	                	}
	                    
	                    
	                }
	            });
		}
        function addRow() {          
            var newRow = { name: "New Row" };
            grid.addRow(newRow, 0);

            grid.beginEditCell(newRow, "LoginName");
        }
       function onActionRenderer(e) {
        	
            var grid = e.sender;
            var record = e.record;
            var data10 = record.data10;
            var data01 = record.data01;
            var rowIndex = e.rowIndex;

            var s = '<a class="New_Button" href="javascript:queryFj(\'' + data10 + '\',\'' + data01 + '\')">查看附件</a> ';
                       
            return s;
        }
        function queryFj(data10,data01){
        	if(data10=='200108'){
        		alert('请到医师受理信息中查询附件信息');
        	}else if(data10=='200109'){
        		alert('请到医技受理信息中查询附件信息');
        	}else if(data10=='200110'){
        		alert('请到护理人员受理信息中查询附件信息');
        	}else if(data10=='200119'){
        		alert('缺少材料');
        	}else{
        		mini.open({
			    url: '<%=request.getContextPath()%>/pages/f20/f2001/f200101/f20010118/pfbfj.jsp',
			    title: data01, width: 1000, height: 600,
			    onload: function () {
			        var iframe = this.getIFrameEl();
		             //var dataid = record.dataid;
			        var data = {data10:data10,data01:data01};
			        iframe.contentWindow.SetData(data);
			    }
			});
        	}
        	
        }
         function removeRow() {
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                if(confirm("确定要删除数据吗？"))
				 {
				 	//var data = grid.getSelecteds();
		            var json = mini.encode(rows);
		            if(json!=null&&json!='[]'){
		            	$.ajax({
			                url: "<%=request.getContextPath() %>/work/f20010101/deleteDataListInfo.action",
			                data: { dataJson: json},
			                type: "post",
			                success: function (text) {
			                	alert('删除成功！');
			                    query();
			                },
			                error: function (jqXHR, textStatus, errorThrown) {
			                    alert(jqXHR.responseText);
			                    //alert('删除成功！');
			                    //query();
			                }
			            });
		            }
				}
            }else{
            	alert('请选择要删除的数据');
            }
        }
        function saveData() {
            var data = grid.getChanges();
            var json = mini.encode(data);
            if(json!=null&&json!='[]'){
            	$.ajax({
	                url: "<%=request.getContextPath() %>/work/f20010118/saveDataListInfo.action",
	                data: { dataJson: json},
	                type: "post",
	                success: function (text) {
	                	if(text=='2'){
	                		alert("已经提交，不能再次修改");
	                		return false;
	                	}else if(text == '3'){
		                	alert("已经初审，不能再次修改");
		                	return false;
	                	}else if(text == '4'){
		                	alert("已经复审，不能再次修改");
		                	return false;
	                	}
	                     alert('保存成功！');
	                    query();
	                },
	                error: function (jqXHR, textStatus, errorThrown) {
	                    alert(jqXHR.responseText);
	                }
	            });
            }else{
            	alert('没有要保存的信息');
            }
        }
        function saveData1() {
            //经过系统自动打分基准分低于60分或者择优分值低于20分的，无法进行评估表格的提交
        	var jzf=0;
            var zyf=0;
        	var rows = grid.getData();
        	for(var i=0,l=rows.length;i<l;i++){
				var row = rows[i];
				if(row.data99!=null && row.data99!=""){		
					jzf = jzf + Number(row.data99); //系统打分不为空
				}else{
            		jzf = jzf + Number(row.data05); //系统打分为空，计算自评分
            	}
				if(row.data100!=null && row.data100!=""){
					zyf = zyf + Number(row.data100); //系统打分不为空
				}else{
					zyf = zyf + Number(row.data09); //系统打分为空，计算自评分
            	}
        	}
			if(jzf<60){
				alert("基准分低于60分，不能提交");
				return false;
			}
			if(zyf<20){
				alert("择优分低于20分，不能提交");
				return false;
			}
        	//查询是否在申报期
        	$.ajax({
	                url: "<%=request.getContextPath() %>/work/f20010118/checkTime.action",
	                data: {},
	                type: "post",
	                success: function (data) {
	                	map = $.parseJSON(data); 
	                	var bz=map.bz;
	                	if(bz=='1'){
	                		if(confirm("请确认所有受理信息已经准确保存，提交之后不可以再修改！确认提交吗？"))
							{
								$.ajax({
					                url: "<%=request.getContextPath() %>/work/f20010118/saveAllListInfo.action",
					                data: {},
					                type: "post",
					                success: function (text) {
					                	if(text=='1'){
					                		alert('提交成功！');
					                	}else{
					                		alert('已经提交过，不可再提交	');
					                	}
					                },
					                error: function (jqXHR, textStatus, errorThrown) {
					                    alert(jqXHR.responseText);
							            //query();
					                }
					            });
						    }
	                	}else{
	                		alert('不在申报期内,申报期为'+map.starttime+'-'+map.endtime);
	                	}
	                },
	                error: function (jqXHR, textStatus, errorThrown) {
	                    alert(jqXHR.responseText);
			            //query();
	                }
	            });    
        }
    </script>
</body>
</html>
