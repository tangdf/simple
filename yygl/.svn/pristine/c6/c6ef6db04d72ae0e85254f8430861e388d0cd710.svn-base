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
    <title> 社会保险参保证明</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>
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
<style>
td{border: 1px solid #000;}
</style>
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
	    LODOP.ADD_PRINT_HTM('1cm','1cm','18.5cm','28cm', document.getElementById("from_div").innerHTML);
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
   <div id="from_div" style="width: 800px" >
    <table width="96%"  border="0" align="center">
   		<tr>
   			 <td align="center" colspan="7">
   			 	<strong><font size="5">基本养老保险关系接续单</font></strong>
   			 </td>
   		</tr>
   		<tr>
   		<td align="center" colspan="3">
   			 	<font size="2">（打印日期：${vo.data15}年${vo.data16}月${vo.data17}日）</font> 
   			 </td>
   		</tr>
   		<tr>
   			 <td align="right" colspan="3">
   			 	<font size="2"> 校验码：${vo.id}</font> 
   			 </td>
   		</tr>
   		<tr align='right'>
   		<td align="right" colspan="7">
   			 	<font size="2"> 凭此校验码，全国可上网确认真伪，无需盖章 (www.qdhrss.gov.cn)</font> 
   			 </td>
   		
   		</tr>
   	</table>
  <table width="95%" border="1" align="center" cellpadding="3" style="border-color: black ;border-collapse: collapse;font-size:12px">
  <COLGROUP>
		<COL width='16%' align="center">
		<COL width='16%' align="center">
		<COL width='16%' align="center">
		<COL width='16%' align="center">
		<COL width='16%' align="center">
		<COL width='16%' align="center">
	</COLGROUP>
				<tr>
					<td align=right colspan="1">
						单位名称
					</td>
					<td align="left" colspan="5">
						${vo.data01}
					</td>
				</tr>
				<tr class="odd">
					<td align="right">
						个人编号
					</td>
					<td align="left">
						${vo.data02}
					</td>
					<td align="right">
						姓 名
					</td>
					<td align="left">
						${vo.data03}
					</td>
					<td align="right">
						性 别
					</td>
					<td align="left">
						${vo.data04}
					</td>
				</tr>
				<tr>
					<td align="right" colspan="2">
						身份证号
					</td>
					<td align="left" colspan="4">
						${vo.data05}
					</td>
				</tr>
				<tr>
					<td align="right" colspan="1">
						参加工作时间
					</td>
					<td align="left" colspan="2">
						${vo.data06}
					</td>
					<td align="right" colspan="1">
						个人身份
					</td>
					<td align="left" colspan="2">
						${vo.data07}
					</td>
				</tr>
				<tr class="even">
					<td align="right" colspan="1">
						缴费截止时间
					</td>
					<td align="left" colspan="2">
						${vo.data08}
					</td>
					<td align="right" colspan="1">
						欠缴月数
					</td>
					<td align="left" colspan="2">
						${vo.data09}
					</td>
				</tr>
				<tr class="odd">
					<td align="right" colspan="3">
						缴费年限（实际缴费月数）
					</td>
					<td align="left" colspan="2">
						${vo.data10}个月
					</td>
					<td>单位：元</td>
				</tr>
				<tr class="odd">
					<td align="center">
						缴费月份
					</td>
					<td align="center">
						缴费基数
					</td>
					<td align="center" colspan="2">
						单位划入额
					</td>
					<td align="center" colspan="2">
						个人缴纳额
					</td>
				</tr>
				<c:forEach items="${vo.printList1}" var="rec">
					<tr class="odd">
						<td align="center">
							${rec.data01}
						</td>
						<td align="center">
							${rec.data02}
						</td>
						<td align="center" colspan="2">
							${rec.data03}
						</td>
						<td align="center" colspan="2">
							${rec.data04}
						</td>
					</tr>
				</c:forEach>
				<tr class="odd">
					<td align="center" colspan="2">
						合计
					</td>
					<td align="center" colspan="2">
						${vo.printList1[0].data05}
					</td>
					<td align="center" colspan="2">
						${vo.printList1[0].data06}
					</td>
				</tr>
				<tr class="odd">
					<td align="center" colspan="1">
						本年储存额本息
					</td>
					<td align="center" colspan="2">
						${vo.data11}
					</td>
					<td align="center" colspan="1">
						其中个人
					</td>
					<td align="center" colspan="2">
						${vo.data12}
					</td>
				</tr>
				<tr class="odd">
					<td align="center" colspan="1">
						累计储存额本息
					</td>
					<td align="center" colspan="2">
						${vo.data13}
					</td>
					<td align="center" colspan="1">
						其中个人
					</td>
					<td align="center" colspan="2">
						${vo.data14}
					</td>
				</tr>
				<tr class="odd">
					<td align="left" colspan="6">
						核发单位：青岛市社会劳动保险事业局
					</td>
				</tr>
				<tr class="odd">
					<td align="left" colspan="3">
						经办人：网上自助
					</td>
					<td align="left" colspan="3">
						单位名称为目前所在单位
					</td>
				</tr>
			</table>
   	<table width="96%"  border="0" align="center" style="border-color: black ;border-collapse: collapse;font-size:12px">
	   	<tr>
	   		<td colspan="10">
	   			<table width="100%" border="0" align="center">
	   				<tr>
	   					<td align="left"><font size="2">备注：</font></td>
	   				</tr>
	   			</table>
				<font size="2">1、本证明涉及个人信息，因个人保管不当或向第三方泄露引起的一切后果由参保个人承担。<br/></font>
				<font size="2">2、上述信息为当前参保缴费单位的信息，供参考，不作为待遇计发的最终依据。<br/></font>
				<font size="2">3、用人单位职工参加工伤保险、生育保险的，由用人单位依法缴费，个人不缴费。<br/></font>
				<font size="2">4、可登陆青岛市人力资源和社会保障信息网(www.qdhrss.gov.cn),凭“校验码”比对本证明情况。<br/></font>
				<font size="2">5、本证明自打印三个月内有效。<br/></font>
				<font size="2">6、本表作为了解参保缴费信息使用，不作为今后待遇计发凭证。<br/></font>
			</td>
	   	</tr>
	   	  	
	   
   	</table>
   	 </div>
   	</center>
 
  </body>
</html>
