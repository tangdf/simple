package com.wb.qdyth.f1001.f100102;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wb.login.SessionUtils;
import com.wb.qdyth.f1001.common.service.PrintService;
import com.wb.qdyth.f1001.common.vo.ReturnPrintVO;
import com.wb.user.utils.BusinessContextUtils;


/**
 * 个人自助打印
 * @author xue
 * 2015-11-10
 */
@Controller
@RequestMapping(value="/work/f100102/")
public class F100102Action  {

	@Autowired
	private PrintService printService;
	
	@RequestMapping("index.action")
	public String index(HttpServletRequest request){
		String vtype=request.getParameter("vtype");
		request.setAttribute("vtype", vtype);
		return "/f10/f1001/f100102/prePrint";
	}
	/**
	 * 查询人员信息
	 * @param request
	 * @return
	 */
	@RequestMapping("showPrint.action")
	public String showPrint(HttpServletRequest request,String vtype){
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		Long au=BusinessContextUtils.getUserContext().getAuthenticType();////1外网  2自主服务
			ReturnPrintVO vo=printService.execGetPrintInfo(aac001, vtype);
			request.setAttribute("vo", vo);
		    request.setAttribute("wwornn", au);
			if(vo.getError()!=null&&vo.getError().length()>0) 
				return "/f10/f1001/f100102/nullerror";
			
			if("pa1".equalsIgnoreCase(vtype) && vo != null && "2".equalsIgnoreCase(vo.getData300())){
				return "/f10/f1001/f100102/pa1cab106_2";
			}
			//<!-- 退休审批表 -->
		    if("pc2".equalsIgnoreCase(vtype)) {
		    	return "/f10/f1001/f100102/print_txsp";
		    }else{
		    	return "/f10/f1001/f100102/print_"+vtype;
		    }
	}
	
	public PrintService getPrintService() {
		return printService;
	}
	public void setPrintService(PrintService printService) {
		this.printService = printService;
	}

}
