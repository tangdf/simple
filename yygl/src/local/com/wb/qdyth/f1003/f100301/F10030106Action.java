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
	 * 大病医疗救助信息查询
	 */
	@Controller
	@RequestMapping(value="/public/f10030106/")
	public class F10030106Action {

		@Autowired
		private FastQueryService fastQueryService;
		
		@RequestMapping("index.action")
		public String index(){
			return "/f10/f1003/f100301/f10030106/index";
		}
		@RequestMapping("queryDbyljzcx.action")
		@ResponseBody
		public String queryDbyljzcx(HttpServletRequest request,String aac002,String aac001){
			
			int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
			int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
			
			Page page=new Page();
			page.setPageno(pageIndex+1);
			page.setPagesize(pageSize);
			fastQueryService.queryDbyljzcx(page,aac002,aac001);
			return JsonUtils.getJsonByPage(page);
		}
		public FastQueryService getFastQueryService() {
			return fastQueryService;
		}
		public void setFastQueryService(FastQueryService fastQueryService) {
			this.fastQueryService = fastQueryService;
		}
	
	}

	

