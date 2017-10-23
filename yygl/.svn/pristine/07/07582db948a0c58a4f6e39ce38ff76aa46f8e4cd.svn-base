package com.wb.qdyth.f1003.f100301;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wb.exceptions.BusinessException;
import com.wb.qdyth.f1003.common.service.FastQueryService;
import com.wb.qdyth.f1003.common.vo.JdcjcxVo;
import com.wb.utils.web.JsonUtils;

	/**
	 * 居民医疗保险查询 
	 */
	@Controller
	@RequestMapping(value="/public/f10030102/")
	public class F10030102Action {

		@Autowired
		private FastQueryService fastQueryService;
		
		@RequestMapping("index.action")
		public String index(){
			return "/f10/f1003/f100301/f10030102/index";
		}
		@RequestMapping("queryJdcjcx.action")
		@ResponseBody
		public String queryJdcjcx(String sfzh,String code){
			JdcjcxVo vo=fastQueryService.queryJdcjcxVo(sfzh, code);
			return JsonUtils.getJsonData(vo);
		}
		public FastQueryService getFastQueryService() {
			return fastQueryService;
		}
		public void setFastQueryService(FastQueryService fastQueryService) {
			this.fastQueryService = fastQueryService;
		}
	
	}

	

