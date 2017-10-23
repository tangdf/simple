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
    <script type="text/javascript">
		var clzt =[{
			id:'1',
			text:'医院保存'
		},{
			id:'2',
			text:'医院提交'
		},{
			id:'3',
			text:'初审'
		},{
			id:'4',
			text:'复审保存'
		},{
			id:'5',
			text:'复审提交'
		}];

		var zt = [{id:'1',
					text:'提交'},
				{id:'2',
					text:'回退'}];
		
	</script>
</head>
<body>
	<fieldset id="fd2">
        <legend><span>查询条件</span></legend>
        <div class="fieldset-body">
        <div id="editForm1" class="cxTabbox">
        <form id="form1" action="#" onsubmit="return false">
          <table class="form-table" border="0" cellpadding="0"  cellspacing="0">
                <tr>
                    <td>流水号:</td>
                    <td>
                        <input id="lsh" name="lsh" class="mini-textbox" style="width:150px;"  vtype="maxLength:100"  /> 
                    </td>
                    <td>提交起始时间：</td>
					<td>
						<div class="inputL" style="width: 150px">
							<div class="inputR">
								<div class="inputC">
									<input id="timeStart" name="timeStart"  class="mini-datepicker" value=""/>
								</div>
							</div>
						</div>
					</td>
					<td class="textR">提交终止时间：</td>
					<td>
						<div class="inputL" style="width: 150px">
							<div class="inputR">
								<div class="inputC">
									<input id="timeEnd" name="timeEnd"  class="mini-datepicker" />
								</div>
							</div>
						</div>
					</td>
					<td>
	                	<input value="查询" type="button" onclick="queryData();" />
	            	</td>
				</tr>
            </table>
            </form>
            </div>
        </div>
    </fieldset>
    <div id="datagrid1" class="mini-datagrid" style="width:100%;height:220px;" 
        url="<%=request.getContextPath()%>/work/f20010118/queryLhpfb.action"  idField="id" 
        allowResize="true" 
        allowCellEdit="false" allowCellSelect="true" multiSelect="true" pageSize="10"
        editNextOnEnterKey="true"  editNextRowCell="true"  showSummaryRow="true" 
        onselectionchanged="onSelectionChanged">
       <div property="columns">
       		<div name="action1" width="70" headerAlign="center" align="center" renderer="onActionRenderer1" cellStyle="padding:0;">修改</div>
         	<div name="action" width="120" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;">#</div>
         	<div field="clzt" name="clzt" type="comboboxcolumn" width="70" headerAlign="center" align="center">
				处理状态<input property="editor" class="mini-combobox"
					style="width:100%" data="clzt" />
			</div>
         	<%--<div name="clzt" field="clzt" headerAlign="center" align="center"   >处理状态</div>--%>  
         	<div name="lsh" field="lsh" headerAlign="center" align="center"   >流水号</div>  	
         	<div name="objname"  field="objname" headerAlign="center" allowSort="true" width="150" >机构名称</div> 
            <div name="userid"  field="userid" headerAlign="center" allowSort="true" width="150" >用户ID
            </div> 
            <div name="time"  field="time" headerAlign="center" allowSort="true" width="100" >提交时间
            </div>      
        </div>
    </div>
	<div style="width:100%;padding-top:10px;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        	回退操作记录      
                    </td>
                </tr>
            </table>           
        </div>
    </div>
    <div id="datagrid2" class="mini-datagrid" style="width:100%;height:200px;" 
        url="<%=request.getContextPath()%>/work/f20010118/queryClzt.action"  idField="id" 
        allowResize="true" pageSize="10"
        allowCellEdit="true" allowCellSelect="true" multiSelect="true" showSummaryRow="true">
        <div property="columns">
	       	<div field="clzt" name="clzt" type="comboboxcolumn" width="70" headerAlign="center" align="center">
				处理状态<input property="editor" class="mini-combobox"
					style="width:100%" data="zt" />
			</div>
	        <div name="clr"  field="clr" headerAlign="center" align="center" allowSort="true" width="150" >处理人</div> 
	        <div name="clsj"  field="clsj" headerAlign="center" align="center" allowSort="true" width="250" >处理时间 </div>
        </div> 
    </div>	
    <script type="text/javascript">
        
        mini.parse();
        var queryForm = new mini.Form("form1");
        
		query();
        var grid = mini.get("datagrid1");
        var grid2 = mini.get("datagrid2");
        //加载数据
		function query(){
			var data = queryForm.getData(true);
		 	Web.util.load("datagrid1",data);
		}
		function queryData(){
			query();
		}
       function onActionRenderer(e) {
        	
            var grid = e.sender;
            var record = e.record;
            var lsh = record.lsh;

            var s = '<a class="New_Button" href="javascript:queryLhpfb(\'' + lsh + '\')">量化评分表信息</a> ';
                       
            return s;
        }
        function queryLhpfb(lsh){
        	mini.open({
				    url: '<%=request.getContextPath()%>/pages/f20/f2001/f200101/f20010102/lhpfbIndex.jsp',
				    title: '量化评分表信息查询', width: 1200, height: 500,
				    onload: function () {
				        var iframe = this.getIFrameEl();
				        var data = {lsh:lsh};
				        iframe.contentWindow.SetData(data);
				    }
				});
        	
        }

        //修改
		function onActionRenderer1(e) {
        	
            var grid = e.sender;
            var record = e.record;
            var userid = record.userid;
            var clzt = record.clzt;
            var lsh = record.lsh;

            var s = '<a class="New_Button" href="javascript:update(\'' + userid + '\',\'' + clzt + '\',\''+lsh+'\')">回退</a> ';
                       
            return s;
        }
		function update(userid,clzt,lsh){
			if(clzt=='2'){
				$.ajax({
		           url: '<%=request.getContextPath() %>/work/f20010118/updateListForS.action',
		            type: "post",
		            data: { userid:userid,lsh:lsh},
		            success: function (text) {
		            	mini.unmask(document.body);
		                if(text=='1'){
		            	 	mini.showMessageBox({
		        				title: "提示",
		        				message: "回退成功！",
		        				buttons: ["确定"],
		        				iconCls: "mini-messagebox-info",
		        				callback: function(action){
		            	 			query();
		         			}});
		            	}else{
		            	  mini.alert(text.msg);
		                }  
		            }
		        });
			}else{
				mini.alert("该量化评分表已审核，不能回退");
			}
        }

		function onSelectionChanged(e) {
	        
            var grid1 = e.sender;
            var record = grid1.getSelected();
            var userid = record.userid;
           grid2.load({userid:userid});
        }
         
    </script>
</body>
</html>
