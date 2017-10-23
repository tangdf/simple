package com.wb.qdyth.f1001.f100102;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wb.login.SessionUtils;
import com.wb.qdyth.f1001.common.service.PrintService;
import com.wb.qdyth.f1001.common.vo.Psorder;


/**
 * 个人权益单订制
 * @author xue
 * 2015-11-10
 */
@Controller
@RequestMapping(value="/work/f10010201/")
public class F10010201Action  {

	@Autowired
	private PrintService printService;
	
	@RequestMapping("index.action")
	public String index(HttpServletRequest request){
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		Integer aae001=Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date()))-1;
		Psorder po=printService.getPsorderByAac001Aae001(aac001, aae001);
		request.setAttribute("po", po);
		return "/f10/f1001/f100102/f10010201/psorder";
	}
	 /**
	  * 个人权益单订制
	  * @return
	 * @throws IOException 
	  */
	@RequestMapping("savePsOrder.action")
	 public void savePsOrder(HttpServletRequest request,HttpServletResponse response) throws IOException{
		 response.setCharacterEncoding("UTF-8");
		 HttpSession session=request.getSession();
		 String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		 String aae005=request.getParameter("aae005");
		 String aae006=request.getParameter("aae006");
		 String aae007=request.getParameter("aae007");
		 Integer aae001=Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date()))-1;
		 String result="";
		 try {
			 result = this.printService.savePsorder(aac001, aae001, aae005, aae006, aae007);
		} catch (Exception e) {
			result = "提交失败！";
		}finally{
			try {
				response.getWriter().write(result);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		response.getWriter().close(); 
	 }
	public PrintService getPrintService() {
		return printService;
	}
	public void setPrintService(PrintService printService) {
		this.printService = printService;
	}

}
