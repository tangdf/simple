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
    <title> 养老参保凭证打印</title>
   
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
   <div id="imgdiv" style="position:absolute; left:280px; top:35px;z-index: 0; ">
   		<img width="130px" height="130px" src="${pageContext.request.contextPath}/pages/f10/f1001/f100102/image/zj_zhang.jpg" />
 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   </div>
   <div id="from_div" align="center" style="left:0px; top:0px; ">
	   <table width="96%"  border="0" align="center">
	   		<tr>
	   			 <td align="right" colspan="6" nowrap="nowrap">
	   			 		<font size="3"> 编号：${vo.data19}</font>
	   			 </td>
	   		</tr>
	   		<tr>
	   			 <td align="center" colspan="6" nowrap="nowrap">
	   			 	<strong><b><font size="5">基本养老保险参保缴费凭证</font></b><br/><br/></strong>
	   			 </td>
	   		</tr>
	   		<tr>
	   			 <td align="right" colspan="6" nowrap="nowrap">
	   			 	<font size="3"> 校验码：${vo.id}</font>
	   			 </td>
	   		</tr>
	   		<tr align='right'>
   		<td align="right" colspan="7">
   			 	<font size="2"> 凭此校验码，全国可上网确认真伪，无需盖章 (www.qdhrss.gov.cn)</font> 
   			 </td>
   		
   		</tr>
	   </table>
	   <table width="96%" id="main_table" border="1" align="center" style="border-color: black ;border-collapse: collapse">
	   		<tr height="30">
	   			<td align="center" colspan="6" nowrap="nowrap">
					<strong><b><font size="3">参保人员基本信息</font></b></strong>
				</td>
	   		</tr>
			<COLGROUP>
				<COL width='10%' align="center" >
				<COL width='23%' align="center" >
				<COL width='10%' align="center" >
				<COL width='23%' align="center" >
				<COL width='10%' align="center" >
				<COL width='23%' align="center" >
			</COLGROUP>
			<tr height="23">
				<td nowrap="nowrap">
					姓名
				</td>
				<td>
					${vo.data01}&nbsp;
				</td>
				<td nowrap="nowrap" >
					性别
				</td>
				<td>
					${vo.data02==1?'男':'女'}&nbsp;
				</td>
				<td nowrap="nowrap">
					个人编号
				</td>
				<td>
					${vo.data03}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td>
					公民身份号码
				</td>
				<td nowrap="nowrap" colspan="2">
					${vo.data04}&nbsp;
				</td>
				<td >
					户籍地地址
				</td>
				<td colspan="2">
					${vo.data05}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td>
					在本地参保起止时间
				</td>	
				<td nowrap="nowrap">
					${vo.data06}—${vo.data07 }
				</td>	
				<td >
					本地实际缴费月数</td>
				<td>
					${vo.data08}&nbsp;
				</td>
				<td>
					本地参保期间个人账户储存额
				</td>	
				<td >
					${vo.data09}&nbsp;
				</td>	
			</tr>
			<tr height="30">
		   			<td nowrap="nowrap" colspan="6" align="center">
						<strong><b><font size="3">社会保险经办机构信息</font></b></strong>
					</td>
		   	</tr>
			<tr height="23">
			   	<td nowrap="nowrap">
			   		行政区划
			   	</td>
				<td nowrap="nowrap" colspan="2">
					${vo.data10}&nbsp;
				</td>
				<td nowrap="nowrap">
					机构名称
				</td>
				<td  colspan="2">
					${vo.data11}&nbsp;
				</td>
			</tr>
			<tr height="23">
				<td nowrap="nowrap">
					联系电话
				</td>
				<td>
					${vo.data12}&nbsp;
				</td>	
				<td nowrap="nowrap" >
					机构地址</td>
				<td>
					${vo.data13}&nbsp;
				</td>
				<td nowrap="nowrap" >
					邮政编码
				</td>	
				<td>
					${vo.data14}&nbsp;
				</td>
			</tr>
		</table>
		<table width="96%"  border="0" align="center">
			<tr height="10%">
		   		<td align="left" colspan="3"><font size="3">经办人（签章）：${vo.data15}&nbsp;</font></td>
		   		<td align="center" colspan="3"><font size="3">社会保险经办机构（章）：</font></td>
		   	</tr>
		   	<tr  height="20%">
		   		<td align="left"  colspan="3"><font size="3">&nbsp;</font></td>
		   		<td align="center" colspan="3"><font size="3"> ${vo.data16}年${vo.data17}月${vo.data18}日  </font></td>
		   	</tr>
		   	
		   	<tr>
		   		<td colspan="6" align="left"><font size="3">（本函一式两联，一联发给原参保地社保机构，一联留存）</font><br/><br/></td>
		   	</tr>
		   	<tr>
		   		<td align="center"  colspan="6"><strong><b><font size="5">重要提示</font></b></strong></td>
		   	</tr>
		   	<tr>
		   		<td align="left"  colspan="6"><font style="font-size: 20px">&nbsp;&nbsp;&nbsp; 1．本凭证是您参加基本养老保险的权益记录，是申请办理基本养老保险关系转移接续手续的重要凭证，请妥善保管。</font></td>
		   	</tr>
		   	<tr>
		   		<td align="left"  colspan="6"><font style="font-size: 20px">&nbsp;&nbsp;&nbsp;2．当您跨省(自治区、直辖市)流动就业时，基本养老保险关系在原参保地社会保险经办机构保留，个人账户储存额按规定继续计算利息。到新就业地参保时，请向当地社会保险经办机构出示本凭证，办理基本养老保险关系转移接续手续。</font></td>
		   	</tr>
		   	<tr>
		   		<td align="left"  colspan="6"><font style="font-size: 20px">&nbsp;&nbsp;&nbsp;3．本凭证如不慎遗失，请与填发此凭证的社会保险经办机构联系，申请补办。联系方式可到任何一个社会保险经办机构查询。</font></td>
		   	</tr>
		   	<tr>
	   		<td colspan="6">
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
			</td>
	   	</tr>
	   	</table>
   	 </div>
   	 </div>
  </center>
 
  </body>
</html>
