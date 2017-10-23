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
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/lodop/CheckActivX.js"></script>
<!-- 设置一个常量WebRoot,保存当前应用的contextpath -->
<script type="text/javascript">var WebRoot='${pageContext.request.contextPath}';</script>

<!-- 注册一个Lodop控件 -->
<object id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
	<param name="CompanyName" value="万达信息股份有限公司">
	<param name="License" value="649717666688688748719056235623">
</object>
<style>
#main_table td{border: 1px solid #000;}
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
	    LODOP.ADD_PRINT_HTM('1cm','1.5cm','18.5cm','27cm', document.getElementById("content").innerHTML);
	}

	function print() {
		create();
		var flag=LODOP.PRINT();
		if(flag==true){
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
   <div id="imgdiv" style="position:absolute; left:280px; top:35px;z-index: 0; ">
   		<img width="130px" height="130px" src="${pageContext.request.contextPath}/pages/f10/f1001/f100102/image/zj_zhang.jpg" />
 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   </div>
   <div id="from_div" align="center" style="left:0px; top:0px; " >
   <table width="96%"  border="0" align="center">
   		<tr>
   			 <td align="center" colspan="7">
   			 	<strong><font size="5">青岛市职工社会保险参保证明</font></strong><font size="2"><br/> (同养老保险关系接续单)  (个人专用) </font> 
   			 </td>
   		</tr>
   		<tr>
   		<td align="center" colspan="3">
   			 	<font size="2">（打印日期：${vo.data01}年${vo.data02}月${vo.data03}日）</font> 
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
   	<table width="96%" id="main_table" cellpadding="3" border="1" align="center" style="border-color: black ;border-collapse: collapse;font-size:12px">
	<COLGROUP>
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
		<COL width='5%' align="center">
	</COLGROUP>
	<tr height="23">
		<td nowrap="nowrap" colspan="3" align="right">
			社会保障编号
		</td>
		<td nowrap="nowrap" colspan="4">
		    ${vo.data04 }
		</td>
		<td nowrap="nowrap" colspan="3" align="right">
			姓名
		</td>
		<td nowrap="nowrap" colspan="4">
			${vo.data05 }
		</td>
		<td nowrap="nowrap" colspan="2" align="right">
			性别
		</td>
		<td nowrap="nowrap" colspan="4">
			${vo.data06}
		</td>
	</tr>
	<tr height="23">
		<td nowrap="nowrap" rowspan="2" colspan="3" align="right">
			当前缴费险种
		</td>
		<td nowrap="nowrap" colspan="4" align="center">
		    职工基本养老保险
		</td>
		<td nowrap="nowrap" colspan="3" align="center">
			职工基本医疗保险
		</td>
		<td nowrap="nowrap" colspan="2" align="center">
			失业保险
		</td>
		<td nowrap="nowrap" colspan="2" align="center">
			工伤保险
		</td>
		<td nowrap="nowrap" colspan="2" align="center">
			生育保险
		</td>
		<td nowrap="nowrap" rowspan="2" colspan="1" align="right">
			所在参保单位<br/>连续缴费月数
		</td>
		<td nowrap="nowrap" rowspan="2" colspan="3" align="left">
			${vo.data18}
		</td>
	</tr>
	<tr height="23">
		<td nowrap="nowrap" colspan="4" align="center">
		    ${vo.data07}
		</td>
		<td nowrap="nowrap" colspan="3" align="center">
		    ${vo.data08}
		</td>
		<td nowrap="nowrap" colspan="2" align="center">
			${vo.data09}
		</td>
		<td nowrap="nowrap" colspan="2" align="center">
			${vo.data10}
		</td>
		<td nowrap="nowrap" colspan="2" align="center">
			${vo.data11}
		</td>
	</tr>
	
	<tr>
   		<td  align="center" colspan="20">
			最后24个月缴费情况（   ${vo.data12} 年${vo.data13}  月-  ${vo.data14} 年 ${vo.data15}月）
		</td>
   	</tr>
	<tr height="23">
		<td rowspan="2" align="center">
		年
		</td>
		<td rowspan="2" align="center">
		月
		</td>
		<td colspan="2" align="center">
		职工基本养老保险
		</td>
		<td colspan="2" align="center">
		职工基本医疗保险
		</td>	
		<td colspan="2" align="center">
		失业保险
		</td>
		<td rowspan="2" align="center">
		缴费状态
		</td>
		<td rowspan="2" colspan="11" align="center">
		参保单位名称
		</td>		
	</tr>
	<tr height="23">
		<td align="center">
		缴费基数
		</td>
		<td align="center">
		个人缴费
		</td>
		<td align="center">
		缴费基数
		</td>
		<td align="center">
		个人缴费
		</td>
		<td align="center">
		缴费基数
		</td>
		<td align="center">
		个人缴费
		</td>		
	</tr>
	<c:forEach items="${vo.printList2}" var="rec">
	<tr height="23">
		<td align="center">${rec.data07}</td>
		<td align="center">${rec.data08}</td>
		<td align="center">${rec.data01}</td>
		<td align="center">${rec.data02}</td>
		<td align="center">${rec.data03}</td>
		<td align="center">${rec.data04}</td>
		<td align="center">${rec.data05}</td>
		<td align="center">${rec.data06}</td>
		<td align="center">${rec.data09}</td>
		<td colspan="11">${rec.data12}</td>
	</tr>
	</c:forEach>
	</table>
   	<table width="96%"  border="1" align="center" style="border-color: black ;border-collapse: collapse;font-size:12px">
	   	<tr>
	   		<td colspan="10">
	   			<table width="96%" border="0" align="center">
	   				<tr>
	   					<td align="left"><font size="2">备注：</font></td>
	   				</tr>
	   			</table>
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;1、本证明涉及个人信息，因个人保管不当或向第三方泄露引起的一切后果由参保个人承担。<br/></font>
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;2、上述信息为当前参保缴费单位的信息，供参考，不作为待遇计发的最终依据。<br/></font>
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;3、用人单位职工参加工伤保险、生育保险的，由用人单位依法缴费，个人不缴费。<br/></font>
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;4、可登陆青岛市人力资源和社会保障信息网(www.qdhrss.gov.cn),凭“校验码”比对本证明情况。<br/></font>
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;5、本证明自打印三个月内有效。<br/></font>
			</td>
	   	</tr>
	   	  	
	   
   	</table>
   	 </div>
   	 </div>
   	</center>
 
  </body>
</html>
