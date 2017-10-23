package com.wb.qdyth.f1001.f100103;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wb.jdbcutils.Page;
import com.wb.login.SessionUtils;
import com.wb.qdyth.f1001.common.service.EmpService;
import com.wb.utils.web.JsonUtils;
import com.wb.utils.web.RequestUtils;

	/**
	 * 当前年度缴费基数
	 */
	@Controller
	@RequestMapping(value="/work/f10010301/")
	public class F10010301Action {

		@Autowired
		private EmpService empService;
		
		@RequestMapping("index.action")
		public String index(){
			return "/f10/f1001/f100103/f10010301/index";
		}
		@RequestMapping("loadCurrentPay.action")
		@ResponseBody
		public String loadCurrentPay(HttpServletRequest request){
			HttpSession session=request.getSession();
			String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
			
			int pageSize = RequestUtils.getParameter(request, "pageSize", 0);
			int pageIndex = RequestUtils.getParameter(request, "pageIndex", 0);
			
			Page page = new Page();
			page.setPageno(pageIndex+1);
			page.setPagesize(pageSize);
			empService.queryCurrentPay(page, aac001);
			return JsonUtils.getJsonByPage(page);
		}
		
		public void setEmpService(EmpService empService) {
			this.empService = empService;
		}
		public EmpService getEmpService() {
			return empService;
		}

	}

	

