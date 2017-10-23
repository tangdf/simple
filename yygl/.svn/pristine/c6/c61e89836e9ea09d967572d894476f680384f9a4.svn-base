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
    <title> 医疗参保凭证</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style>
#main_table td{border: 1px solid #000;}
</style>	
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
		var wwornn=${wwornn};
		if(flag==true&&wwornn==2){
			//var button=Ext.getCmp('do_submit');
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
   			 <td align="center" colspan="7">
   			 	<strong><b><font size="5">参 保 凭 证</font></b><font size="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（第&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 联）</font><br/><br/></strong>
   			 </td>
   		</tr>
   		<tr></tr>
   		<tr>
   			 <td align="left" colspan="4">
   			 	<font size="3">&nbsp;&nbsp;&nbsp;&nbsp;凭证号：鲁&nbsp;&nbsp;&nbsp;&nbsp;${vo.data16}&nbsp;&nbsp;&nbsp;&nbsp;年 
   			 	&nbsp;&nbsp;&nbsp;&nbsp;第&nbsp;${vo.data19}&nbsp;&nbsp;号</font> 
   			 </td>
   			 <td align="right" colspan="3">
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
   		<tr height="10%">
   			<td align="center" colspan="7">
				<strong><font size="3">基 本 信 息</font></strong>
			</td>
   		</tr>
	<COLGROUP>
		<COL width='10%' align="center">
		<COL width='10%' align="center">
		<COL width='23%' align="center">
		<COL width='10%' align="center">
		<COL width='23%' align="center">
		<COL width='10%' align="center">
		<COL width='23%' align="center">
	</COLGROUP>
	<tr height="23">
		<td nowrap="nowrap" rowspan="2">
			参保人
		</td>
		<td nowrap="nowrap">
			姓名
		</td>
		<td>
			${vo.data01}&nbsp;
		</td>
		<td nowrap="nowrap">
			公民身份号码
		</td>
		<td>
			${vo.data04}&nbsp;
		</td>
		<td nowrap="nowrap">
			医疗保障编号
		</td>
		<td>
			${vo.data03}&nbsp;
		</td>
	</tr>
	<tr height="23">
		<td nowrap="nowrap">
			户籍地地址
		</td>
		<td colspan="3">
			${vo.data05}&nbsp;
		</td>
		<td nowrap="nowrap">
			户籍类型
		</td>
		<td>
			${vo.data20 }  &nbsp;
		</td>
	</tr>
	<tr height="23">
		<td nowrap="nowrap">
			户主
		</td>	
		<td nowrap="nowrap">
			姓名
		</td>
		<td>
		&nbsp;&nbsp;
		</td>
		<td nowrap="nowrap">
			公民身份号码
		</td>
		<td colspan="3">
			&nbsp;&nbsp;
		</td>
	</tr>
	<tr height="10%">
   		<td  align="center" colspan="7">
			<font size="3">参 保 信 息</font>
		</td>
   	</tr>
	<tr height="23">
		<td nowrap="nowrap" colspan="2">
			医疗保障类型
		</td>	
		<td colspan="2">
			职工医保&nbsp;
		</td>
	    <td nowrap="nowrap" >
	   		参保地**
	    </td>
		<td colspan="2" >
			${vo.data11}&nbsp;
		</td>
	</tr>
	<tr height="23">
		<td nowrap="nowrap" rowspan="2" colspan="2">
			参保时间
		</td>
		<td colspan="2">
			开始年月：&nbsp;&nbsp;${vo.data06}
		</td>
		<td nowrap="nowrap" rowspan="2">
			待遇享受起止时间
		</td>
		<td colspan="2">
			开始年月：&nbsp;&nbsp;${vo.data06}
		</td>			
	</tr>
	<tr height="23">
		<td colspan="2">
			截止年月：&nbsp;&nbsp;${vo.data07}
		</td>
		<td colspan="2">
			截止年月：&nbsp;&nbsp;${vo.data07}
		</td>
	</tr>
	<tr height="23">
		<td nowrap="nowrap" rowspan="2" colspan="2">
			个人账户余额
		</td>	
		<td colspan="5" align="left">
			（小写）￥${vo.data09}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font style="align: right">元</font>
		</td>	
	</tr>
	<tr>
		<td colspan="5" align="left">
			（大写）${vo.data21}
		</td>
	</tr>
	<tr height="10%">
   		<td align="center" colspan="7">
   			<font size="3">经 办 机 构 信 息</font>
		</td>
   	</tr>
   	<tr height="23">
		<td nowrap="nowrap" colspan="3">
			办理机构名称
		</td>	
		<td colspan="4">
			${vo.data11}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（盖章）
		</td>
	</tr>
	<tr>
		<td nowrap="nowrap" colspan="3">
			联系人
		</td>	
		<td colspan="2">
			${vo.data15}&nbsp;
		</td>
		<td nowrap="nowrap">
			电话
		</td>	
		<td>
			${vo.data12}&nbsp;
		</td>		
	  </tr>
	  	<tr align="right" >
	     	<td nowrap="nowrap" colspan="3">打印时间</td>
	     	<td nowrap="nowrap" colspan="4"> ${vo.data16} 年 ${vo.data17}月 ${vo.data18}日</td>
	   	
	   	</tr>
	</table>
	<table width="96%"  border="0" align="center">
	   	<tr>
	   		<td colspan="7"><font size="3">*尚未将公民身份证号码作为城镇职工基本医疗保险、城镇居民基本医疗保险参保人员唯一身份识别码的统筹地区填写医疗保险编号。</font></td>
	   	</tr>
	   		<tr>
	   		<td colspan="7"><font size="3">**填写办理参保登记的机构名称。</font></td>
	   	</tr>
	   		<tr>
	   		<td colspan="7"><font size="3">此表由参保人员转出地经办机构提供</font></td>
	   	</tr>
   	</table>
   	<table width="96%"  border="1" align="center" style="border-color: black ;border-collapse: collapse">
	   	<tr>
	   		<td colspan="7">
	   			<table width="96%" border="0" align="center">
	   				<tr>
	   					<td align="center"><strong><font size="2">注  意  事  项</font></strong></td>
	   				</tr>
	   			</table>
				<br/>
				<font size="3">&nbsp;&nbsp;&nbsp;&nbsp;1、本凭证是根据国家有关规定制发，是参保的权益记录，以及申请办理基本医疗保险关系转移接续手续的重要凭证，请妥善保存。<br/></font>
				<font size="3">&nbsp;&nbsp;&nbsp;&nbsp;2、本凭证一式三联。第一联用于参保人员办理基本医疗保险关系转移；第二联由原参保统筹地区经办机构存档备查；第三联由参保人员自己留存。<br/></font>
				<font size="3">&nbsp;&nbsp;&nbsp;&nbsp;3、跨统筹地区流动就业人员，有接收单位的，将此凭证交由单位按照规定办理参保接续手续。<br/></font>
				<font size="3">&nbsp;&nbsp;&nbsp;&nbsp;4、其他跨统筹地区流动就业人员，应携带此凭证及有效证件在3个月内到指定办理机构办理相关登记手续。<br/></font>
				<font size="3">&nbsp;&nbsp;&nbsp;&nbsp;5、本凭证如不慎遗失，请与出具此凭证的机构联系，申请补办。<br/></font>
				<table width="96%" border="0" align="center">
	   				<tr>
	   					<td align="right"><font size="3">人力资源和社会保障部监制</font></td>
	   				</tr>
	   				<tr>
	   		<td colspan="10">
	   			<table width="100%" border="0" align="center">
	   				<tr>
	   					<td align="left"><font size="2">备注：</font></td>
	   				</tr>
	   			</table>
				<font size="2">1、本证明涉及个人信息，因个人保管不当或向第三方泄露引起的一切后果由参保个人承担。<br/></font>
				<font size="2">2、上述信息为当前参保缴费单位的信息，供参考，不作为待遇计发的最终依据。<br/></font>
				<font size="2">3、个人账户金额是打印时前一天的卡金余额，根据青岛市政策该金额不转移，做账户一次性支付。<br/></font>
				<font size="2">4、用人单位职工参加工伤保险、生育保险的，由用人单位依法缴费，个人不缴费。<br/></font>
				<font size="2">5、可登陆青岛市人力资源和社会保障信息网(www.qdhrss.gov.cn),凭“校验码”比对本证明情况。<br/></font>
				<font size="2">6、本证明自打印三个月内有效。<br/></font>
			</td>
	   	</tr>	
	   			</table>
			</td>
	   	</tr>
	   	  	
	   
   	</table>
   	 </div>
   	 </div>
   	</center>
 
  </body>
</html>
