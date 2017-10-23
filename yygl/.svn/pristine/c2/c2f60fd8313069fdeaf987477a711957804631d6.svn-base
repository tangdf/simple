package com.wb.qdyth.f1003.f100301;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wb.jdbcutils.Page;
import com.wb.qdyth.f1003.common.service.FastQueryService;
import com.wb.utils.web.JsonUtils;
import com.wb.utils.web.RequestUtils;

	/**
	 *  定点医院药房查询 
	 */
	@Controller
	@RequestMapping(value="/public/f10030111/")
	public class F10030111Action {

		@Autowired
		private FastQueryService fastQueryService;
		
		
		public FastQueryService getFastQueryService() {
			return fastQueryService;
		}
		public void setFastQueryService(FastQueryService fastQueryService) {
			this.fastQueryService = fastQueryService;
		}
		@RequestMapping("index.action")
		public String index(){
			return "/f10/f1003/f100301/f10030111/index";
		}
		@RequestMapping("queryDdyyyfcx.action")
		@ResponseBody
		public String queryDdyyyfcx(HttpServletRequest request,String cxtj1,String cxtj2,String cxtj3 ){
			int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
			int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
			
			Page page=new Page();
			page.setPageno(pageIndex+1);
			page.setPagesize(pageSize);
			fastQueryService.queryDdyyyfcx(page, cxtj1);
			return JsonUtils.getJsonByPage(page);
		}
	
	}

	

