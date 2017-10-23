<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="<c:url value="/resource/css/qdweb_style.css"/>"
	rel="stylesheet" type="text/css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>

		<!--[if IE 6]> 
<script src="<c:url value="/resource/scripts/js/DD_belatedPNG_0.0.8a-min.js"/>" type="text/javascript"></script>
<script type="text/javascript">
	DD_belatedPNG.fix('.sub_nav li.current .sub_01,.sub_nav li.current .sub_02,.sub_nav li.current .sub_03,.sub_nav li.current .sub_04,.sub_nav li.current .sub_05,html,body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,p,blockquote,th,td,img,span,address,caption,cite,code,dfn,em,strong,th,var');
</script>
<![endif]-->
	</head>

	<body>
		<!-- <form name="processForm" method="post"  action="<%=request.getContextPath()%>/work/m01/f1225/showss.action" >
	请选择年度
       <select name="retireResignQueryVO.an_aae001" id="selectAge" title="年度" onchange="query1()" >  
       <option value=""></option>  
       <option value="2005">2005</option>  
       <option value="2006">2006</option>  
       <option value="2007">2007</option>        
       <option value="2008">2008</option>    
       <option value="2009">2009</option>    
       <option value="2010">2010</option>   
       <option value="2011">2011</option>    
       <option value="2012">2012</option>          
       <option value="2013">2013</option>     
       <option value="2014">2014</option>   
     </select>   
	</form>
	 -->
		<table width="99%" border="1" bordercolor="black" align="center"
			cellpadding="2" cellspacing="0">

			<tr align="center">
				<td colspan="12" align="center">
					<font size="3"> ${baseVO.now_date}年企业退休退职人员调待情况明细表</font>
				</td>
			</tr>
			<tr>
				<td align="left" width="10%" colspan="2">
					<font size="2">职工编号:</font>
				</td>
				<td align="left" width="10%" colspan="2">
					<font size="2">${baseVO.aac001}</font>
				</td>
				<td align="left" width="10%" colspan="2">
					<font size="2">姓 名:</font>
				</td>
				<td align="left" width="10%" colspan="2">
					<font size="2">${baseVO.aac003}</font>
				</td>
				<td align="left" width="10%" colspan="2">
					<font size="2">退休类别:</font>
				</td>
				<td align="left" width="10%" colspan="2">
					<font size="2">${baseVO.aac082}</font>
				</td>
			</tr>
			<tr>
				<td align="left" width="10%" colspan="2">
					<font size="2">出生日期:</font>
				</td>
				<td align="left" colspan="2">
					<font size="2">${baseVO.aac006}</font>
				</td>
				<td align="left" colspan="2">
					<font size="2">参加工作日期:</font>
				</td>
				<td align="left" colspan="2">
					<font size="2">${baseVO.aac007}</font>
				</td>
				<td align="left" colspan="2">
					<font size="2">退休日期:</font>
				</td>
				<td align="left" colspan="2">
					<font size="2">${baseVO.aic162}</font>
				</td>
			</tr>
			<tr>
				<td align="left" width="10%" colspan="2">
					<font size="2">单位名称:</font>
				</td>
				<td align="left" colspan="10">
					<font size="2">${baseVO.aab004}</font>
				</td>
			</tr>
			<tr>
				<td colspan="12" align="center">
					<font size="2">${baseVO.now_date}年调整待遇情况</font>
				</td>
			</tr>
			<tr>
				<td width="9%" rowspan="2">
					<font size="2">本次调待前月基本养老金</font>
				</td>
				<td width="8%" rowspan="2">
					<font size="2">普调固定</font>
				</td>
				<td width="8%" rowspan="2">
					<font size="2">普调比例</font>
				</td>
				<td width="8%" rowspan="2">
					<font size="2">普调年限</font>
				</td>
				<td width="8%" rowspan="1" colspan="4" align="center">
					<font size="2">适当调高</font>
				</td>
				<td width="8%" rowspan="2">
					<font size="2">月增合计</font>
				</td>
				<td width="8%" rowspan="2">
					<font size="2">补发月数</font>
				</td>
				<td width="8%" rowspan="2">
					<font size="2">补发合计</font>
				</td>
			</tr>
			<tr>
				<td width="10%" colspan="2">
					<font size="2">小计</font>
				</td>
				
				<td width="9%">
					<font size="2">军转干</font>
				</td>
				<td width="9%">
					<font size="2">按年龄</font>
				</td>
			</tr>
			<tr>
				<td width="8%">
					(1)
				</td>
				<td width="8%">
					(2)
				</td>
				<td width="8%">
					(3)
				</td>
				<td width="8%">
					(4)
				</td>
				<td width="8%" colspan="2">
					(5)
				</td>
				<td width="8%">
					(6)
				</td>
				<td width="8%">
					(7)
				</td>
				<td width="8%">
					(8)
				</td>
				<td width="8%">
					(9)
				</td>
				<td width="8%">
					(10)
				</td>
				
			</tr>
			<tr>
				<td width="8%" height="16">
					<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.aic003}"/></font>
				</td>
				<td width="8%">
					<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.aic111}"/></font>
				</td>
				<td width="8%">
					<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.aic112}"/></font>
				</td>
				<td width="8%">
					<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.aic121}"/></font>
				</td>
				<td width="8%" colspan="2">
					<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.xj}"/></font>
				</td>
				
				<td width="8%">
					<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.aic115}"/></font>
				</td>
				<td width="8%">
					<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.aic117}"/></font>
				</td>
				<td width="8%">
					<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.aic110}"/></font>
				</td>
				<td width="8%">
					<font size="2">${baseVO.bfys}</font>
				</td>
				<td width="8%">
					<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.bfhj}"/></font>
				</td>
			</tr>
		</table>
		<br>
		<table width="90%" border="1" bordercolor="black" align="center"
			cellpadding="2" cellspacing="0">
			<tr>
				<td colspan="8" align="center">
					<font size="2">月基本养老待遇</font>
				</td>
			</tr>
			<tr>
				<td width="5%" align="center">
					<font size="2">序号</font>
				</td>
				<td width="15%" align="center">
					<font size="2">离休待遇类别</font>
				</td>
				<td width="10%" align="center">
					<font size="2">开始年月</font>
				</td>
				<td width="10%" align="center">
					<font size="2">养老待遇金额</font>
				</td>
				<td width="5%" align="center">
					<font size="2">序号</font>
				</td>
				<td width="15%" align="center">
					<font size="2">离休待遇类别</font>
				</td>
				<td width="10%" align="center">
					<font size="2">开始年月</font>
				</td>
				<td width="10%" align="center">
					<font size="2">养老待遇金额</font>
				</td>
				<%--<td width="10%">
					序号
				</td>
				<td width="10%">
					离休待遇类别
				</td>
				<td width="10%">
					开始年月
				</td>
				<td width="10%">
					养老待遇金额
				</td>
			--%>
			</tr>
			<c:forEach items="${pensionVOList}" var="pensionVO"
				varStatus="status">
				<c:if test="${status.index mod 2 == 0}">
					<tr>
						<td width="5%" align="center">
							<font size="2">${status.count}</font>
						</td>
						<td width="15%">
							<font size="2">${pensionVO.aaa037}</font>
						</td>
						<td width="10%" align="center">
							<font size="2">${pensionVO.aae041}</font>
						</td>
						<td width="10%" align="center">
							<font size="2"><fmt:formatNumber pattern="0.00" value="${pensionVO.aae019}"/></font>
						</td>
				</c:if>
				<c:if test="${status.index mod 2 != 0}">
					<td width="5%" align="center">
						<font size="2">${status.count}</font>
					</td>
					<td width="15%">
						<font size="2">${pensionVO.aaa037}</font>
					</td>
					<td width="10%" align="center">
						<font size="2">${pensionVO.aae041}</font>
					</td>
					<td width="10%" align="center">
						<font size="2"><fmt:formatNumber pattern="0.00" value="${pensionVO.aae019}"/></font>
					</td>
					</tr>
				</c:if>
			</c:forEach>
			<tr>
				<td colspan="2">
					<font size="2">调待前月基本养老金小计</font>
				</td>
				<td colspan="6">
					<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.aae019sum}"/></font>
				</td>
			</tr>
		</table>
		<br>
		<table width="90%" border="1" bordercolor="black" align="center"
			cellpadding="2" cellspacing="0">
			<tr>
				<td colspan="8" align="center">
					<font size="2">月基本养老外待遇</font>
				</td>
			</tr>
			<tr>
				<td width="5%" align="center">
					<font size="2">序号</font>
				</td>
				<td width="15%" align="center">
					<font size="2">离休待遇类别</font>
				</td>
				<td width="10%" align="center">
					<font size="2">开始年月</font>
				</td>
				<td width="10%" align="center">
					<font size="2">养老待遇金额</font>
				</td>
				<td width="5%" align="center">
					<font size="2">序号</font>
				</td>
				<td width="15%" align="center">
					<font size="2">离休待遇类别</font>
				</td>
				<td width="10%" align="center">
					<font size="2">开始年月</font>
				</td>
				<td width="10%" align="center">
					<font size="2">养老待遇金额</font>
				</td>
				
			</tr>
			<c:forEach items="${exceptPensionVOList}" var="exceptPensionVO"
				varStatus="status">
				<c:if test="${status.index mod 2 == 0}">
					<tr>
						<td width="5%" align="center">
							<font size="2">${status.count}</font>
						</td>
						<td width="15%">
							<font size="2">${exceptPensionVO.aaa037}</font>
						</td>
						<td width="10%" align="center">
							<font size="2">${exceptPensionVO.aae041}</font>
						</td>
						<td width="10%" align="center">
							<font size="2"><fmt:formatNumber pattern="0.00" value="${exceptPensionVO.aae019}"/></font>
						</td>
				</c:if>
				<c:if test="${status.index mod 2 != 0}">
					<td width="5%" align="center">
						<font size="2">${status.count}</font>
					</td>
					<td width="15%">
						<font size="2">${exceptPensionVO.aaa037}</font>
					</td>
					<td width="10%" align="center">
						<font size="2">${exceptPensionVO.aae041}</font>
					</td>
					<td width="10%" align="center">
						<font size="2"><fmt:formatNumber pattern="0.00" value="${exceptPensionVO.aae019}"/></font>
					</td>
					</tr>
				</c:if>
				<c:if test="${status.last}">
					<c:if test="${status.count mod 2 != 0}">
						<td width="10%" align="center"></td>
						<td width="10%"></td>
						<td width="10%" align="center"></td>
						<td width="10%" align="center"></td>
						</tr>
					</c:if>
				</c:if>
			</c:forEach>
			<tr>
				<td colspan="2">
					<font size="2">调待前月基本养老金外小计</font>
				</td>
				<td colspan="6">
				<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.aae019sumexc}"/></font>
				</td>
			</tr>
			<tr>
				<td colspan="2" width="25%">
					<font size="2">本次调待前月养老金合计</font>
				</td>
				<td colspan="2">
				<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.aae019sumexc+baseVO.aae019sum}"/></font>
				</td>
				<td colspan="2" width="25%">
					<font size="2">本次调待后月养老金合计</font>
				</td>
				<td colspan="2">
				<font size="2"><fmt:formatNumber pattern="0.00" value="${baseVO.aae019sumexc+baseVO.aae019sum+baseVO.aic110}"/></font>
				</td>
			</tr>
			<tr>
				<td colspan="8">
					<font size="2">说明:1、栏次关系:(4)=(5)+(6)+(7)+(8)+(9),(10)=(2)+(3)+(4),(12)=(10)*(11)</font>
				</td>
			</tr>
			<tr>
				<td colspan="8">
					<font size="2">2、本次调待前每月领取养老待遇合计金额=本次调待前月基本养老金合计金额+本次前月基本养老金外的其他养老待遇合计金额.</font>
				</td>
			</tr>
		</table>
		</div>
	    </center>
	</cw:form>
	</body>
</html>