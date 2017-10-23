<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title> 个人累积参保缴费证明</title>
   
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
			<div id="imgdiv" style="position:absolute; left:280px; top:0px;z-index: 0; ">
   				<img width="130px" height="130px" src="${pageContext.request.contextPath}/pages/f10/f1001/f100102/image/zj_zhang.jpg" />
 					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   			</div>
				<div id="from_div" align="center" style="left:0px; top:0px; " >
					<table width="96%"  border="0" align="center">
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
						<tr>
							<td align="center" colspan="7">
								<strong><font size="5">青岛市职工个人累积参保缴费证明</font></strong><br/> 
							</td>
						</tr>
						<tr>
							<td align="center">
								<font size="2">（打印日期：${vo.data01}年${vo.data02}月${vo.data03}日）</font> 
							</td>
						</tr>
						<tr>
							<td align="right">
								<font size="2"> 校验码：${vo.id}</font> 
							</td>
						</tr>
					</table>
					<table width="96%" cellpadding="3" border="1" align="center" style="border-color: black ;border-collapse: collapse;font-size:12px">
						<tr height='25'>
							<td nowrap="nowrap" colspan="3" align="center">
								个人编号
							</td>
							<td nowrap="nowrap" colspan="4" align="center">
								${vo.aae001 }
							</td>
							<td nowrap="nowrap" colspan="3" align="center">
								姓名
							</td>
							<td nowrap="nowrap" colspan="4" align="center">
								${vo.data05 }
							</td>
							<td nowrap="nowrap" colspan="3" align="center">
								身份证号
							</td>
							<td nowrap="nowrap" colspan="3" align="center">
								${vo.data04 }
							</td>
						</tr>
						<tr height='28'align='center' colspan="20">
							<td colspan="20"><font size="4"><br/> 现参保单位参加险种情况 </font></td>
						</tr>
						<tr height='25'> 
							<td colspan="2" align="center">基本养<br/>老保险</td>
							<td nowrap="nowrap" colspan="2" align="center">
								${vo.data07}
							</td>
							<td colspan="2" align="center">基本医<br/>疗保险</td>
							<td nowrap="nowrap" colspan="2" align="center">
								${vo.data08}
							</td>
							<td colspan="2" align="center">失业<br/>保险</td>
							<td nowrap="nowrap" colspan="2" align="center">
								${vo.data09}
							</td>
							<td colspan="2" align="center">工伤<br/>保险</td>
							<td nowrap="nowrap" colspan="2" align="center">
								${vo.data10}
							</td>
							<td colspan="2" align="center">生育<br/>保险</td>
							<td nowrap="nowrap" colspan="2" align="center">
								${vo.data11}
							</td>
						</tr>
						<tr height='28'align='center' colspan="20">
							<td colspan="20"><font size="4"><br/> 本市参保缴费信息 </font></td>
						</tr>
						<tr height='25'>
							<td colspan="4" align="center">单位编号</td>
							<td colspan="10" align="center">单位名称</td>
							<td colspan="2" align="center">缴费开<br/>始时间</td>
							<td colspan="2" align="center">缴费终<br/>止时间</td>
							<td colspan="2" align="center">累计缴<br/>费月数</td>
						</tr>
						<c:forEach items="${vo.printList1}" var="rec">
						<tr height="25">
							<td align="center" colspan="4" >${rec.data01}</td>
							<td align="center" colspan="10">${rec.data02}</td>
							<td align="center" colspan="2" >${rec.data03}</td>
							<td align="center" colspan="2" >${rec.data04}</td>
							<td align="center" colspan="2" >${rec.data05}</td>
						</tr>
						</c:forEach>
						<tr height='25'>
							<td align='center' colspan='14'>本市累积缴费月数合计</td>
							<td colspan='6' ALIGN="center">${vo.data12}</td>
						</tr>
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
									<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;2、上述信息，仅供参考，不作为待遇计发的最终依据。<br/></font>
									<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;3、用人单位职工参加工伤保险、生育保险的，由用人单位依法缴费，个人不缴费。<br/></font>
									<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;4、可登陆青岛市人力资源和社会保障信息网(www.qdhrss.gov.cn),凭“校验码”校验对本证明情况。<br/></font>
									<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;5、本证明自打印三个月内有效。<br/></font>
							</td>
						</tr>	  	
					</table>
				</div>
			</div>
		</center>
	</body>
</html>