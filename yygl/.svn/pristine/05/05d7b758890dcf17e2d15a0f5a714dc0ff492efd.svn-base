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
   			 	<strong><font size="5">青岛市从业人员退休审批表</font></strong>
   			 </td>
   		</tr>
   		
   		<tr>
   			 <td align="right" colspan="3">
   			 	<font size="2"> 校验码：${vo.id}</font> 
   			 </td>
   		</tr>
   		
   	</table>
  <table width="95%"  align="center" cellpadding="3" style="border-color: black ;border-collapse: collapse;font-size:12px">
  <COLGROUP>
		<COL width='16%' align="center">
		<COL width='16%' align="center">
		<COL width='16%' align="center">
		<COL width='16%' align="center">
		<COL width='16%' align="center">
		<COL width='16%' align="center">
	</COLGROUP>
				<tr >
	    			<td width="10%" nowrap="nowrap" align="center" bgcolor="white"><font size="2">单位编号</font></td>
	    			<td width="10%" nowrap="nowrap" align="center" bgcolor="white"><font size="2">${vo.data01}</font></td>
	    			<td width="10%" nowrap="nowrap" align="center" bgcolor="white"><font size="2">单位名称</font></td>
	    			<td width="20%" nowrap="nowrap" align="center" bgcolor="white"><font size="2">${vo.data02}</font></td>
	    			<td width="10%" nowrap="nowrap" align="center" bgcolor="white"><font size="2">经济类型</font></td>
	    			<td width="10%" nowrap="nowrap" align="center" bgcolor="white"><font size="2">${vo.data03}</font></td>
	    			<td width="10%" nowrap="nowrap" align="center" bgcolor="white"><font size="2">${vo.data04}</font></td>
	    		</tr>
	    	</table>
	    		<table  width="90%"  bgcolor="black">
	    			<tr height="23">
	    				<td width="120" nowrap="nowrap" align="center" bgcolor="white"><font size="2">职工编号</font></td>
	    				<td width="20%" nowrap="nowrap" align="center" bgcolor="white"><font size="2">${vo.aae001}</font></td>
	    				<td width="20%" nowrap="nowrap" align="center" bgcolor="white" colspan="2"><font size="2">公民身份证号码</font></td>
	    				<td width="20%" nowrap="nowrap" align="center" bgcolor="white" colspan="2"><font size="2">${vo.data05}</font></td>
	    				<td width="100" nowrap="nowrap" align="center" bgcolor="white"><font size="2">离退休类别</font></td>
	    				<td width="120" bgcolor="white" align="center"><font size="2">${vo.data06}</font></td>
	    			</tr>
	    			<tr height="23">
	    				<td nowrap="nowrap" align="center" bgcolor="white"><font size="2">姓&nbsp;名</font></td>
	    				<td bgcolor="white" align="center" width="50"><font size="2">${vo.data07}</font></td>
	    				<td nowrap="nowrap" align="center" bgcolor="white"><font size="2">性&nbsp;别</font></td>
	    				<td bgcolor="white" align="center" width="50"><font size="2">${vo.data08}</font></td>
	    				<td nowrap="nowrap" align="center" bgcolor="white"><font size="2">民&nbsp;族</font></td>
	    				<td bgcolor="white" align="center"><font size="2">${vo.data09}</font></td>
	    				<td nowrap="nowrap" align="center" bgcolor="white"><font size="2">出生日期</font></td>
	    				<td bgcolor="white" align="center"><font size="2">${vo.data10}</font></td>
	    			</tr>
	    			<tr height="23">
	    				<td align="center" bgcolor="white"><font size="2">离退休时间</font></td>
	    				<td align="center" bgcolor="white"><font size="2">${vo.data56}</font></td>
	    				<td align="center" bgcolor="white" colspan="2"><font size="2">档案编号</font></td>
	    				<td align="center" bgcolor="white" colspan="2"></td>
	    				<td align="center" bgcolor="white"><font size="2">纳入统筹年月</font></td>
	    				<td align="center" bgcolor="white"><font size="2">${vo.data57}</font></td>
	    			</tr>
	    			<tr height="23">
	    				<td align="center" bgcolor="white"><font size="2">帐户前年限</font></td>
	    				<td bgcolor="white" align="center"><font size="2">${vo.data11}</font></td>
	    				<td align="center" bgcolor="white"><font size="2">帐户后年限</font></td>
	    				<td bgcolor="white" align="center"><font size="2">${vo.data12}</font></td>
	    				<td align="center" bgcolor="white"><font size="2">合&nbsp;计</font></td>
	    				<td bgcolor="white" align="center"><font size="2">${vo.data13}</font></td>
	    				<td align="center" bgcolor="white"><font size="2">缴费起止时间</font></td>
	    				<td bgcolor="white" align="center"> <font size="2">${vo.data14}</font></td>
	    			</tr>
	    			<tr height="23">
	    				<td align="center" bgcolor="white"><font size="2">参加工作时间</font></td>
	    				<td align="center" bgcolor="white"><font size="2">${vo.data15}</font></td>
	    				<td align="center" bgcolor="white" colspan="2"><font size="2">工龄补贴</font></td>
	    				<td align="center" bgcolor="white" colspan="2"><font size="2">${vo.data16}</font></td>
	    				<td align="center" bgcolor="white"><font size="2">档案出生时间</font></td>
	    				<td align="center" bgcolor="white"><font size="2">${vo.data17}</font></td>
	    			</tr>
	    			<tr height="23">
	    				<td align="center" bgcolor="white"><font size="2">联系电话</font></td>
	    				<td align="center" bgcolor="white"><font size="2">${vo.data18}</font></td>
	    				<td align="center" bgcolor="white" colspan="2"><font size="2">联系地址</font></td>
	    				<td align="center" bgcolor="white" colspan="4"><font size="2">${vo.data19}</font></td>
	    			</tr>
	    			<tr height="23">
	    				<td align="center" bgcolor="white"><font size="2">街道编码</font></td>
	    				<td align="center" bgcolor="white"><font size="2">${vo.data20}</font></td>
	    				<td align="center" bgcolor="white"><font size="2">银行编号</font></td>
	    				<td align="center" bgcolor="white" colspan="2"><font size="2">${vo.data21}</font></td>
	    				<td align="center" bgcolor="white"><font size="2">银行账号</font></td>
	    				<td align="center" bgcolor="white" colspan="2"><font size="2">${vo.data22}</font></td>
	    			</tr>
	    			<tr height="23">
	    				<td nowrap="nowrap" align="center" bgcolor="white" colspan="8"><font size="2">按原办法计发养老金(鲁政发[1997]109号)</font></td>
	    			</tr>
	    			<tr height="23">
	    				<td align="center" bgcolor="white"><font size="2">基础养老金</font></td>
	    				<td align="left" bgcolor="white" colspan="7"><font size="2">
	    					(2005年在岗月均工资)&nbsp;${vo.data23}&nbsp;（元）
	    					&nbsp;×&nbsp;${vo.data24}&nbsp;(计发比例)
	    					&nbsp;=&nbsp;${vo.data25}&nbsp;元</font>
	    				</td>
	    			</tr>
	    			<tr height="23">
	    				<td align="center" bgcolor="white"><font size="2">个人账户养老金</font></td>
	    				<td align="left" bgcolor="white" colspan="7"><font size="2">
	    					(个人账户存储额)&nbsp;${vo.data26}&nbsp;（元）&nbsp;&nbsp;
	    					÷&nbsp;&nbsp;${vo.data27}&nbsp;&nbsp;
	    					=&nbsp;&nbsp;${vo.data28}&nbsp;元</font>
	    				</td>
	    			</tr>
	    			<tr height="23">
	    				<td align="center" bgcolor="white"><font size="2">过渡性养老金</font></td>
	    				<td align="left" bgcolor="white" colspan="7"><font size="2">
	    					(2005年在岗月均工资)&nbsp;${vo.data23}&nbsp;（元）&nbsp;×&nbsp;
	    					${vo.data29}&nbsp;(平均指数)&nbsp;
	    					×&nbsp;${vo.data30}&nbsp;(帐户前)&nbsp;×1.4%&nbsp;&nbsp;
	    					=&nbsp;&nbsp;${vo.data31}&nbsp;元</font>
	    				</td>
	    			</tr>
	    			<tr height="23">
	    				<td align="center" bgcolor="white"><font size="2">过渡性调节金</font></td>
	    				<td align="left" bgcolor="white" colspan="7"><font size="2">
	    					120元&nbsp;&nbsp;＋&nbsp;&nbsp;
	    					${vo.data32}&nbsp;元&nbsp;(工龄补贴)&nbsp;&nbsp;
	    					=&nbsp;&nbsp;${vo.data33}&nbsp;元
	    				</font></td>
	    			</tr>
	    			
	    			<tr height="23">
	    				<td width="10%" align="center" bgcolor="white"><font size="2">提前退休差额</font></td>
	    				<td width="20%" align="left" bgcolor="white" colspan="7"><font size="2">
	    				${vo.data35}&nbsp;&nbsp;=&nbsp;&nbsp;${vo.data36}&nbsp;&nbsp;元
	    				</font></td>
	    			</tr>
	    			<tr height="23">
	    				<td align="center" bgcolor="white"><font size="2">养老金总额</font></td>
	    				<td align="left" bgcolor="white" colspan="7"><font size="2">${vo.data37}元</font></td>
	    			</tr>
	    			<tr height="23">
	    				<td align="center" bgcolor="white"><font size="2">每月应领取养老金总额</font></td>
	    				<td align="left" bgcolor="white" colspan="7"><font size="2">
	    					${vo.data37}&nbsp;&nbsp;&nbsp;元
	    				</font></td>
	    			</tr>
	    			<tr height="150">
	    				<td align="center" bgcolor="white">
	    				<font size="2">该同志具备办理：<br/>${vo.data06}<br/>的条件</font>
	    				</td>
	    				<td align="center" bgcolor="white">
	    					<font size="2">单位<br/>审批<br/>意见</font>
	    				</td>
	    				<td colspan="3" bgcolor="white" style="text-align:right;vertical-align:text-bottom;">
	    					<font size="2">(签章)</font>
	    				</td>
	    				<td width="10%" align="center" bgcolor="white">
	    					<font size="2">社保<br/>审批<br/>意见</font>
	    				</td>
	    				<td width="20%" colspan="2" bgcolor="white" style="text-align:right;vertical-align:text-bottom;">
	    					
							<br/>
	    					<font size="2">(签章)&nbsp;&nbsp;&nbsp;${vo.data50}</font>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td width="10%" align="center" bgcolor="white"><font size="2">备注</font></td>
	    				<td width="40%" colspan="4" bgcolor="white"><font size="2">开放城市补贴：${vo.data51}元、
	    				电煤补贴：${vo.data52}元、水价补贴：${vo.data53}元、物价补贴：${vo.data54}元
	    				、房屋补贴：${vo.data55}元</font></td>
	    				<td width="10%" align="center" bgcolor="white">
	    					<font size="2">个人<br/>签章</font>
	    				</td>
	    				<td width="20%" colspan="2" bgcolor="white"></td>
	    			</tr>
	    			<tr>
	    				<td colspan="8" bgcolor="white" align="left"><font size="2">
 说明 ：1、计算过渡性养老金的缴费年限是指建立个人账户前缴费年限。<br/>
	   2、过渡性调节金中：120元加工龄补贴的合计最多不超过150元。<br/>
	   				</font></td>
	    			</tr>
			</table>
   	
   	 </div>
   	</center>
 
  </body>
</html>
