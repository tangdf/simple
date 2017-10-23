package com.wb.qdyth.f1003.f100301;

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
import com.wb.qdyth.f1003.common.service.FastQueryService;
import com.wb.utils.web.JsonUtils;
import com.wb.utils.web.RequestUtils;

	/**
	 * 工伤认定查询 
	 */
	@Controller
	@RequestMapping(value="/public/f10030104/")
	public class F10030104Action {

		@Autowired
		private FastQueryService fastQueryService;
		
		@RequestMapping("index.action")
		public String index(){
			return "/f10/f1003/f100301/f10030104/index";
		}
		@RequestMapping("queryGsrdcx.action")
		@ResponseBody
		public String queryJmylxx(HttpServletRequest request,String aac003,Long aac001){
			
			int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
			int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
			
			Page page=new Page();
			page.setPageno(pageIndex+1);
			page.setPagesize(pageSize);
			fastQueryService.queryGsrdcx(page, aac001, aac003);
			return JsonUtils.getJsonByPage(page);
		}
		public FastQueryService getFastQueryService() {
			return fastQueryService;
		}
		public void setFastQueryService(FastQueryService fastQueryService) {
			this.fastQueryService = fastQueryService;
		}
	
	}

	

