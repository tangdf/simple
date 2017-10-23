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
    <title> 年度社会保险个人权益记录单（城镇职工）</title>
   
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
	    LODOP.ADD_PRINT_HTM('1cm','1cm','18.5cm','27cm', document.getElementById("content").innerHTML);
	}

	function print() {
		create();
		var flag=LODOP.PRINT();
		if(flag==true){
			//document.getElementById('print').style.display='none';
		}
		
	}
	
	function preview() {
		create();
		LODOP.PREVIEW();
	}
</script>
<style>
table td{align:center}
td{border: 1px solid #000;}
body {

}
</style>
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
   
  <div id="from_div"  align="center" style="position:absolute; left:0px; top:0px; ">
	 
	   			<div style="border: 1px solid #000000;text-align:left; font-size:8px; border-collapse: collapse;float:right;margin-right:0px;clear:both;" >
	   			 温馨提示：<br>1.请及时对记录单内容进行核对，如有异议请到参保地经办机构进行核实、处理。 <br/>
	   			  2.您还可以通过以下方式查询个人权益 记录：登录青岛市人力资源和社会保障网<br/>（www.qdhrss.gov.cn），拨打人力资源和社会保障局民生服务热线12333。<br/>
	   			  3.<font color="red">如果打印出的版式有问题可以通过文件--打印来操作，或者去业务经办柜台打印。</font>
	   			</div>
	   			<div style="clear:both; "><center><strong><b><font size="5"> ${vo.data03}年度社会保险个人权益记录单（城镇职工）</font></b><br/></strong></center></div>
	   			<div style="clear:both; "><center>（${vo.data03}年 1月至${vo.data03}年12月）</center></div>
	   			<div style="clear:both; text-align:right;float:right;padding-right:0px;">
	   			 	<font size="2"> 单位: 元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font> </div>
	   <table width="98%"  id="t_main" border="1" align="center" style="border-color: black ; font-size:10px; border-collapse: collapse">
	   		<tr height="30">
	   			<td align="center" colspan="12" nowrap="nowrap">
					<strong><b><font size="2">个人基本信息（个人投保编号:${vo.data04})</font></b></strong>
				</td>
	   		</tr>
			<COLGROUP>
				<COL width='8%' align="center" >
				<COL width='8%' align="center" >
				<COL width='8%' align="center" >
				<COL width='8%' align="center" >
				<COL width='8%' align="center" >
				<COL width='8%' align="center" >
				<COL width='8%' align="center" >
				<COL width='8%' align="center" >
				<COL width='8%' align="center" >
				<COL width='8%' align="center" >
				<COL width='8%' align="center" >
				<COL width='8%' align="center" >
			</COLGROUP>
			<tr height="23">
				<td nowrap="nowrap" colspan="1">
					姓名
				</td>
				<td colspan="2">
					${vo.data11}&nbsp;
				</td>
				
				<td nowrap="nowrap" colspan="2">
					单位名称
				</td>
				<td colspan="3" nowrap="nowrap">
					${vo.data08}&nbsp;
				</td>
				<td nowrap="nowrap" colspan="2">
					社会保障号码
				</td>
				<td colspan="2">
					${vo.data10}&nbsp;
				</td>
			</tr>
			<tr height="23">
			
				<td  rowspan="2" colspan="3">
					首次参保日期
				</td>
				<td nowrap="nowrap" colspan="3">
					养老保险
				</td>
				<td nowrap="nowrap" colspan="3">
					医疗保险
				</td>
				<td nowrap="nowrap" colspan="3">
					失业保险
				</td>
				
			</tr>
			<tr height="23">
				<td colspan="3">
				${vo.data12}
				</td>	
				<td nowrap="nowrap" colspan="3">
				${vo.data13}
				</td >	
				<td colspan="3">
				${vo.data14}
				</td >
			
			</tr>
			<tr height="30">
		   			<td nowrap="nowrap" colspan="12" align="center">
						<strong><b><font size="2">缴费情况</font></b></strong>
					</td>
		   	</tr>
			<tr height="23">
			   	<td nowrap="nowrap" colspan="4">
			   		个人月缴费基数
			   	</td>
				<td nowrap="nowrap" colspan="2">
				          养老缴费信息
				</td>
				<td nowrap="nowrap" colspan="2">
					医疗缴费信息
				</td>
				<td  nowrap="nowrap"  colspan="2">
			                      失业缴费信息
				</td>
				<td  colspan="1" rowspan="2" >
			    <font  style="font-size: 8px">工伤缴费信息<br>(单位缴费)</font>
				</td>
				<td  colspan="1" rowspan="2"  >
			     <font style="font-size: 8px">生育缴费信息<br>(单位缴费)</font>
				</td>
			</tr>
			<tr height="23">
				<td nowrap="nowrap" colspan="2">
			    养老
				</td>
		       
				<td nowrap="nowrap">
				 医疗
				</td>
				<td nowrap="nowrap">
				失业
				</td>
				<td nowrap="nowrap">
				单位缴费
				</td>
				<td nowrap="nowrap">
				个人缴费
				</td>
			<td nowrap="nowrap">
				单位缴费
				</td>
				<td nowrap="nowrap">
				个人缴费
				</td>
				<td nowrap="nowrap">
				单位缴费
				</td>
				<td nowrap="nowrap">
				个人缴费
				</td>
			
			</tr>
			<tr height="23">
				<td nowrap="nowrap" colspan="2">
				${vo.data17}&nbsp;
				</td>
		
				<td nowrap="nowrap">
				${vo.data18}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data19}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data22}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data23}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data24}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data25}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data26}&nbsp;
				</td>
					<td nowrap="nowrap">
				${vo.data27}&nbsp;
				</td>
					<td nowrap="nowrap">
				${vo.data28}&nbsp;
				</td>
					<td nowrap="nowrap">
				${vo.data29}&nbsp;
				</td>
			</tr>
			<tr height="23">
			   	<td nowrap="nowrap" colspan="3">
			   		本年个人补缴欠费金额
			   	</td>
				<td nowrap="nowrap" colspan="3">
				          补缴历年月数
				</td>
				<td nowrap="nowrap" colspan="3">
					截止${vo.data03}年末实际缴费月数
				</td>
				<td  colspan="3">
			                      累计欠缴月数
				</td>
				
			</tr>
			<tr height="23">
				<td nowrap="nowrap" colspan="1">
			    养老
				</td>
		       
				<td nowrap="nowrap">
				 医疗
				</td>
				<td nowrap="nowrap">
				失业
				</td>
					<td nowrap="nowrap" colspan="1">
			    养老
				</td>
		       
				<td nowrap="nowrap">
				 医疗
				</td>
				<td nowrap="nowrap">
				失业
				</td>
					<td nowrap="nowrap" colspan="1">
			    养老
				</td>
		       
				<td nowrap="nowrap">
				 医疗
				</td>
				<td nowrap="nowrap">
				失业
				</td>
					<td nowrap="nowrap" colspan="1">
			    养老
				</td>
		       
				<td nowrap="nowrap">
				 医疗
				</td>
				<td nowrap="nowrap">
				失业
				</td>
				</tr>
			<tr height="23">
				<td nowrap="nowrap">
				${vo.data30}&nbsp;
				</td>
		
				<td nowrap="nowrap">
				${vo.data31}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data32}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data33}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data34}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data35}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data36}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data37}&nbsp;
				</td>
				<td nowrap="nowrap">
				${vo.data38}&nbsp;
				</td>
					<td nowrap="nowrap">
				${vo.data39}&nbsp;
				</td>
					<td nowrap="nowrap">
				${vo.data40}&nbsp;
				</td>
					<td nowrap="nowrap">
				${vo.data41}&nbsp;
				</td>
			
			</tr>
			<tr height="30">
		   			<td nowrap="nowrap" colspan="12" align="center">
						<strong><b><font size="2">基本养老保险个人账户情况(仅对按企业职工有关规定参保缴费的人员显示)</font></b></strong>
					</td>
		   	</tr>
		   	<tr height="23">
			   	<td nowrap="nowrap" colspan="3">
			   		截止上年末个人账户累计储存额
			   	</td>
				<td nowrap="nowrap" colspan="2">
				          当年记账金额
				</td>
				<td nowrap="nowrap" colspan="3">
					截止上年末个人账户累<br>计储存额${vo.data03}年记账利息
				</td>
				<td  colspan="2">
			                      当年记账金额利息
				</td>
				
				<td  colspan="2">
			                      至本年末账户累计储存额
				</td>
				
			</tr>
			 	<tr height="23">
			   <td nowrap="nowrap" colspan="3">
			   		${vo.data42}&nbsp;
			   	</td>
				<td nowrap="nowrap" colspan="2">
				       ${vo.data43}&nbsp;
				</td>
				<td nowrap="nowrap" colspan="3">
					${vo.data44}&nbsp;
				</td>
				<td  colspan="2">
			           ${vo.data45}&nbsp;     
				</td>
				<td  colspan="2">
			        ${vo.data46}&nbsp;
				</td>
			</tr>
		
			<tr height="30">
		   			<td nowrap="nowrap" colspan="12" align="center">
						<strong><b><font size="2"> 医疗保险待遇享受情况（仅对发生医疗待遇支付职工显示,以结算日期为准统计）</font></b></strong>
					</td>
		   	</tr>
		   	<tr height="23">
			   	<td  colspan="1" align="center">
			   		医疗费发<br>生总额
			   	</td>
				<td  colspan="2" align="center">
				        基本医疗保险<br>统筹金支付额
				</td>
				<td  colspan="2" align="center">
					大额医疗补助金<br>支付额
				</td>
				<td  colspan="2" align="center">
			                      特殊人员医疗补助金<br>支付额
				</td>
				
				<td  colspan="1" align="center">
			                     大病医疗救助额
				</td>
				<td  colspan="2">
			                     民政医疗救助额
				</td>
				<td nowrap="nowrap" colspan="2">
			                     个人实际负担额
				</td>
			</tr>
			 	<tr height="23">
			   	<td nowrap="nowrap" colspan="1">
			   		${vo.data52 }
			   	</td>
				<td nowrap="nowrap" colspan="2">
				    ${vo.data53 }
				</td>
				<td nowrap="nowrap" colspan="2">
				${vo.data54 }
				</td>
				<td  colspan="2">
			      ${vo.data55 }
				</td>
				<td  colspan="1">
			   ${vo.data56 }
				</td>
				<td  colspan="2">
			   ${vo.data57 }
				</td>
				<td  colspan="2">
			   ${vo.data65 }
				</td>
			</tr>
			<tr height="30">
		   			<td nowrap="nowrap" colspan="12" align="center">
						<strong><b><font size="2">工伤保险待遇享受情况（仅对工伤职工显示）</font></b></strong>
					</td>
		   	</tr>
		   	
		   		<tr height="23">
			   	<td nowrap="nowrap" colspan="3">
			   		一次性伤残补助金		
			   	</td>
				
				<td nowrap="nowrap" colspan="6">
					1-4级伤残津贴 		
				</td>
				
				<td  colspan="3">
			                  一次性医疗补助金	
				</td>
				
			</tr>
		   	<tr height="23">
			   	<td nowrap="nowrap" colspan="1">
			   		级别			
			   	</td>
				<td nowrap="nowrap" colspan="2">
				        金额			
				</td>
				<td nowrap="nowrap" colspan="2">
					 级别			
				</td>
				<td  colspan="2">
			        月标准			
				</td>
				<td  colspan="2">
			         护理费			
				</td>
				<td  colspan="2">
			                  级别		
				</td>
				<td  colspan="1">
			                 金额		
				</td>
			</tr>
			 	<tr height="23">
			   	<td nowrap="nowrap" colspan="1">
			   	${vo.data66 }				</td>
				<td nowrap="nowrap" colspan="2">
				${vo.data67 }				</td>
				<td nowrap="nowrap" colspan="2">
				${vo.data68 }				</td>
				<td  colspan="2">
			    ${vo.data69 }				</td>
				<td  colspan="2">
			     ${vo.data70 }				</td>
				<td  colspan="2">
			     ${vo.data71 }				</td>
				<td  colspan="1">
			     ${vo.data72 }				</td>
			</tr>
			<tr height="30">
		   			<td nowrap="nowrap" colspan="12" align="center">
						<strong><b><font size="2">生育保险待遇享受情况（仅对享受生育保险待遇人员显示）</font></b></strong>
					</td>
		   	</tr>
		   	<tr height="23">
			   	<td nowrap="nowrap" colspan="4" rowspan="2">
			   		生育医疗费(手工报销)金额									
			   	</td>
				<td nowrap="nowrap" colspan="4">
				        生育津贴				
				</td>
				<td nowrap="nowrap" colspan="6" rowspan="2">
					男职工生育补助金			
				</td>
			
				
					</tr>
				<tr>
				<td colspan="2">发放天数</td>
				<td colspan="2">发放金额</td>
				
				</tr>
		
			 	<tr height="23">
			   	<td nowrap="nowrap" colspan="4">
			   ${vo.data73 }			   	</td>
				<td nowrap="nowrap" colspan="2">
				${vo.data76 }				</td>
				<td nowrap="nowrap" colspan="2">
				${vo.data77 }				</td>
				<td nowrap="nowrap" colspan="4">
				${vo.data78 }				</td>
	
				
			</tr>
		
		</table>
		<div style="text-align:left;font-size:12px;padding-left:12px;">
	说明：<br/>  
   1、 本表是目前参保缴费状态下参保人员基本信息、${vo.data03 }年度缴纳社会保险信息、养老保险个人账户及${vo.data03 }年度参保险种发生过待遇支付信息的权益记录单 ；  <br/>
   2、 单位名称为参保人员目前参保所在单位(管理部门)名称；<br/>  
   3、 社会保障号码为公民身份证号码（18位）；  <br/>
   4、 个人月缴费基数为参保人员${vo.data03 }年度平均月缴费基数，其中工伤、生育保险因个人不缴费而不显示基数；<br/>  
   5、 本年个人补缴欠费金额为参保人员${vo.data03 }年度补缴之前历年欠费的个人缴费部分金额；<br/>  
   6、 截止本年末实际缴费月数为参保人员截止${vo.data03 }年末的实际缴费月数（不含欠缴月数）；<br/>  
   7、 截止上年末个人账户累计储存额为参保人员${vo.data03-1 }年末个人账户累计储存额、当年记账金额为${vo.data03 }年度计入个人 账户本金、截止上年末个人账户累计储蓄额当年记账利息为截止${vo.data03-1}年末储蓄额在${vo.data03 }年的记账利息、当年记账利息为${vo.data03 }年缴费计入个人账户本金产生的记账利息；  <br/>
   8、 至本年末账户累计储存额为参保人员“截止上年末个人账户累计储存额”、“当年记账金额”、“截止上年末个人账户累计储蓄额当年记账利息”、“当年记账利息”之和；<br/>  
   9、 医疗保险待遇享受情况是以结算日期为${vo.data03 }年度内发生的各项医保待遇支付及个人实际负担情况;<br/>
   10、 一次性伤残补助金为职工因工致残${vo.data03 }年度被鉴定为一级至十级的，按照伤残等级标准由社会保险经办机构发放的一次性待遇金额；<br/> 
   11、 1-4级伤残津贴为职工因工致残被鉴定为一级至四级的，由社会保险经办机构按月发放的待遇金额。其中，经劳 动能力鉴定委员会确认需要生活护理的，由社会保险经办机构按照生活护理等级标准按月发放生活护理费；<br/> 
   12、 一次性工伤医疗补助金为被鉴定为五级至十级工伤职工，${vo.data03 }年度与用人单位解除或终止劳动合同，由社会保险经办机 构按照伤残等级标准发放的待遇金额；<br/> 
   13、生育医疗费（手工报销）金额为${vo.data03 }年度职工个人或单位在社保经办机构报销的生育医疗费金额，不含职工在定点医院结算报销的医疗费； <br/>
   14、生育津贴发放天数和发放金额为${vo.data03 }年度实际发放职工的生育津贴天数和金额，生育津贴跨年度发放的分段记录在不同年度权益记录单中显示；<br/>
   15、本表按国家、省有关规定打印发放，作为参保人员核对本人信息使用，不作为待遇计发凭证；<br/> 
   16、请参保人员认真核实本人通讯地址及个人权益记录单信息，信息不全或有误的，请持本人身份证原件及复印件到参保所属区、市社会保险经办机构核实更改。<br/> 
 <br/>
 <br/>
 <table style="font-size:12px;" width="100%">
 	<tr>
 		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 		
 		<td rowspan=6" align="center">
 			
 		</td>
 	</tr>
 	<tr>
 		<td>打印时间： ${vo.data62 } 年 ${vo.data63 } 月 ${vo.data64 } 日 </td>
 	</tr>
    <tr>
    	<td>社会保险经办名称：${vo.data59 } </td>
 	</tr>
 	 <tr>
 	 	<td>地址：${vo.data61 } </td>
 	</tr>
 	<tr>
 	 	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	</tr>
 </table>


		</div>
   	 </div>
   	 </div>
  </center>
 <script type="text/javascript">
 var ss =document.getElementById('t_main').getElementsByTagName("td");
 for (var i=0;i<ss.length;i++){
	ss[i].align='center';
	 }
 </script>
  </body>
</html>
