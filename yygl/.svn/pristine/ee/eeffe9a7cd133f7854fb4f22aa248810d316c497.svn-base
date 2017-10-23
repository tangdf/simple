<!-- 
本例是一个表格的打印
说明：
1、使用object对象来注册一个打印控件
2、使用document.getElementById获取到打印控件，使用CheckLodop检查是否安装打印控件，检验版本
3、使用c:forEach标签来遍历数据，使用EL来读取属性
4、使用table来展现数据，使用到了thead、tfoot、tbody，主要是用于分页打印，这里设置每10行记录打印一页
5、使用fmt:formatNumber将数值格式化为2位精度
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <title> 机构信息打印</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>
<style>
#main_table td{border: 1px solid #000;}
</style>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/resource/scripts/gridUtils.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resource/scripts/formUtils.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resource/scripts/storeUtils.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resource/scripts/utils.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resource/scripts/dateutil.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/lodop/CheckActivX.js"></script>
<!-- 设置一个常量WebRoot,保存当前应用的contextpath -->
<script type="text/javascript">var WebRoot='${pageContext.request.contextPath}';</script>

<!-- 注册一个Lodop控件 -->
<object id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
	<param name="CompanyName" value="万达信息股份有限公司">
	<param name="License" value="649717666688688748719056235623">
</object>

<script type="text/javascript">
	var LODOP = document.getElementById("LODOP");//这行语句是为了符合DTD规范
	CheckLodop();

	function create() {
		LODOP.PRINT_INIT("");

		
		//假设我们使用A4纸张打印 A4=21cm * 29.7cm
		//页边距我们设置为 1cm (top、left、rifht、bottom)
		//width =21-1*2 =21-2=19
		//height =29.7-1*2=29.7-2=27.7cm
		LODOP.SET_PRINT_PAGESIZE(1,'21cm','29.7cm','A4')
	    LODOP.ADD_PRINT_HTM('1cm','1.5cm','18.5cm','27cm', document.getElementById("content").innerHTML);
	}

	function print() {
		create();
		var flag=LODOP.PRINT();
		if(flag==true){
			var button=Ext.getCmp('do_submit');
			document.getElementById('print').style.display='none';
		}
		
	}
	
	function preview() {
		create();
		LODOP.PREVIEW();
	}
</script>

  <body>
   <div>
	<a id="print" href="javascript:print();">打印</a>
	<a href="javascript:preview();">预览</a>
	<a href="javascript:window.history.back();">返回</a>
   </div>
 <center>
 <div id="content">
   <div id="from_div" align="center" style="left:0px; top:0px;">
	   <table width="96%"  border="0" align="center">
	   		<tr>
	   			 <td align="right" colspan="6" nowrap="nowrap">
	   			 		<font size="3"> </font>
	   			 </td>
	   		</tr>
	   		<tr>
	   			 <td align="center" colspan="6" nowrap="nowrap">
	   			 	<strong><b><font size="5">青岛市社会医疗保险</font></b><br/><br/></strong>
	   			 	<strong><b><font size="5">住院定点医疗机构申请表</font></b><br/><br/></strong>
	   			 </td>
	   		</tr>
	   </table>
	   <table width="96%" id="main_table" border="1" align="center" style="border-color: black ;border-collapse: collapse">
			<COLGROUP>
				<COL width='15%' align="center" >
				<COL width='20%' align="center" >
				<COL width='15%' align="center" >
				<COL width='20%' align="center" >
				<COL width='20%' align="center" >
			</COLGROUP>
			<tr height="23">
				<td nowrap="nowrap">
					单位名称<!-- ${vo.data02==1?'男':'女'}&nbsp; -->
				</td>
				<td colspan="4">
					${vo.data01}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td>
					单位地址
				</td>
				<td nowrap="nowrap" colspan="4">
					${vo.data02}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td>
					邮政编码
				</td>
				<td nowrap="nowrap" >
					${vo.data10}&nbsp;
				</td>
				<td>
					法人代表人姓名及身份证号
				</td>
				<td nowrap="nowrap" >
					${vo.data03}&nbsp;
				</td>
				<td nowrap="nowrap" >
					${vo.data04}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td>
					联系人
				</td>
				<td nowrap="nowrap" >
					${vo.data05}&nbsp;
				</td>
				<td colspan="2">
					联系电话
				</td>
				<td nowrap="nowrap" >
					${vo.data06}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td colspan="5">
					医疗机构
				</td>
			</tr>
			<tr height="23">
				<td rowspan="10">
					大型医疗设备情况
				</td>
				<td >
					名称
				</td>
				<td>
					数量
				</td>
				<td >
					所有制类型
				</td>
				<td >
					${vo.data07==1?'公立':'私营'}&nbsp;
				</td>
			</tr>
			<tr height="23">
				
				<td >
					${list[0].data01}
				</td>
				<td>
					${list[0].data02}
				</td>
				<td >
					类别
				</td>
				<td >
					<c:if test="${vo.data08=='11'}">综合</c:if>
					<c:if test="${vo.data08=='12'}">中医</c:if>
					<c:if test="${vo.data08=='15'}">专科</c:if>
				</td>
			</tr>
			<tr height="23">
				
				<td >
					${list[1].data01}
				</td>
				<td>
					${list[1].data02}
				</td>
				<td >
					性质
				</td>
				<td >
					${vo.data09==1?'盈利':'非盈利'}&nbsp;
				</td>
			</tr>
			<tr height="23">
				
				<td >
					${list[2].data01}
				</td>
				<td>
					${list[2].data02}
				</td>
				<td >
					实行药品零差率制度情况
				</td>
				<td >
					${vo.data11==1?'实行':'不实行'}&nbsp;
				</td>
			</tr>
			<tr height="23">
				
				<td >
					${list[3].data01}
				</td>
				<td>
					${list[3].data04}
				</td>
				<td >
					医疗机构等级
				</td>
				<td >
					<c:if test="${vo.data12=='1'}">一级</c:if>
					<c:if test="${vo.data12=='2'}">二级</c:if>
					<c:if test="${vo.data12=='3'}">三级</c:if>
					<c:if test="${vo.data12=='4'}">社区</c:if>
				</td>
			</tr>
			<tr height="23">
				
				<td >
					${list[4].data01}
				</td>
				<td>
					${list[4].data02}
				</td>
				<td colspan="2">
					                床位数    ${vo.data13}   张
				</td>
			</tr>
			<tr height="23">
				
				<td >
					${list[5].data01}
				</td>
				<td>
					${list[5].data02}
				</td>
				<td colspan="2">
					                   固定资产   ${vo.data14}    万元
				</td>
			</tr>
			<tr height="23">
				
				<td >
					${list[6].data01}
				</td>
				<td>
					${list[6].data02}
				</td>
				<td colspan="2">
					                 年业务收入     ${vo.data15}    万元
				</td>
			</tr>
			<tr height="23">
				
				<td >
					${list[7].data01}
				</td>
				<td>
					${list[7].data02}
				</td>
				<td colspan="2">
					               住院人次    ${vo.data16}     人次/年；门诊人次     ${vo.data17}     人次/年
				</td>
			</tr>
			<tr height="23">
				
				<td >
					${list[8].data01}
				</td>
				<td>
					${list[8].data02}
				</td>
				<td colspan="2">
					           卫生技术人员情况（按附表内容填写）
				</td>
			</tr>
			<tr height="23">
				<td colspan="2">
					《设置医疗机构批准书》批准文号
				</td>
				<td colspan="3">
					        ${vo.data18}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td colspan="2">
					《医疗机构执业许可证》登记号
				</td>
				<td colspan="3">
					         ${vo.data19}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td colspan="2">
					《营业执照》注册号
				</td>
				<td colspan="3">
					         ${vo.data20}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td colspan="2">
					《事业单位法人证书》证号
				</td>
				<td colspan="3">
					        ${vo.data21}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td colspan="2">
					《民办非企业单位登记证书》证号
				</td>
				<td colspan="3">
					        ${vo.data22}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td colspan="2">
					等级评审批准文件文号
				</td>
				<td colspan="3">
					        ${vo.data23}&nbsp;
				</td>
			</tr>
			<tr height="180">
				<td>
					医疗机构简介
				</td>
				<td colspan="4">
					        
					        
					        
					        
					     <font size="2">   ${vo.data24}&nbsp;</font><br>
					        
					        
					      <font size="2">  本单位自查符合青岛市社会医疗保险住院定点医疗机构申请条件，自愿承担青岛市社会医疗保险服务，
					      申请成为医疗保险住院定点医疗机构。承诺提供的所有材料真实、完整、有效。
					      承诺本医疗机构没有《青岛市社会医疗保险住院定点医疗机构协议管理办法（试行）》第八条规定的情形。如承诺内容和材料与事实不符，愿承担由此造成的一切后果。
					      </font><br><br> 
					        
					         法定代表人签字：   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					         （单位印章）

          																   年    月    日 
				</td>
			</tr>
			<tr height="80">
				<td>
					所在地社会保险<br>
					经办机构意见
				</td>
				<td colspan="4">
					        		（印章）

								年    月    日 
				</td>
			</tr>
			<tr height="80">
				<td>
					青岛市社会保险<br>
					事业局意见
				</td>
				<td colspan="4">
					        		（印章）

								年    月    日 
				</td>
			</tr>
		</table>
		
   	 </div>
   	 	<table width="96%"  border="0" align="center" style="border-color: black ;border-collapse: collapse;font-size:12px">
	   	<tr>
	   		<td colspan="10">
	   			<table width="100%" border="0" align="center">
	   				<tr>
	   					<td align="left"><font size="2"></font></td>
	   				</tr>
	   			</table>
				<font size="3">1、该表反正面打印。2、该表一式三份。<br/></font>
			</td>
	   	</tr>
   	</table>
   	 </div>
  </center>
 
  </body>
</html>
