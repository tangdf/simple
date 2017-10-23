package com.wb.qdyth.f1003.f100301;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wb.qdyth.f1003.common.service.FastQueryService;
import com.wb.qdyth.f1003.common.vo.JdzscxVo;
import com.wb.utils.web.JsonUtils;

	/**
	 * 鉴定证书查询
	 */
	@Controller
	@RequestMapping(value="/public/f10030103/")
	public class F10030103Action {

		@Autowired
		private FastQueryService fastQueryService;
		
		@RequestMapping("index.action")
		public String index(){
			return "/f10/f1003/f100301/f10030103/index";
		}
		@RequestMapping("queryJdzscx.action")
		@ResponseBody
		public String queryJdcjcx(String cardcode, String name){
			JdzscxVo vo=fastQueryService.queryJdzscxVo(cardcode, name);
			return JsonUtils.getJsonData(vo);
		}
		public FastQueryService getFastQueryService() {
			return fastQueryService;
		}
		public void setFastQueryService(FastQueryService fastQueryService) {
			this.fastQueryService = fastQueryService;
		}
	
	}

	

