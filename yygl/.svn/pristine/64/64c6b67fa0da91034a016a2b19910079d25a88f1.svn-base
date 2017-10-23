package com.wb.qdyth.f1003.f100301;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wb.qdyth.f1001.common.service.PrintService;
import com.wb.qdyth.f1001.common.vo.ReturnPrintVO;

	/**
	 * 个人自助打印打印查询 
	 */
	@Controller
	@RequestMapping(value="/public/f10030107/")
	public class F10030107Action {

		@Autowired
		private PrintService printService;
		
		public PrintService getPrintService() {
			return printService;
		}
		public void setPrintService(PrintService printService) {
			this.printService = printService;
		}
		@RequestMapping("index.action")
		public String index(){
			return "/f10/f1003/f100301/f10030107/index";
		}
		@RequestMapping("queryGrzzdycx.action")
		public String queryGrzzdycx(HttpServletRequest request,String id ){
				String vtype="";
			 if(id!=null&&!"".equals(id.trim())){//用于外网公开查询
				 ReturnPrintVO vo=this.printService.getInfoById(id);
				 if(vo==null){
					 vo=new ReturnPrintVO();
					 vo.setError("未找到数据！");
					 request.setAttribute("vo", vo);
					 return "/f10/f1001/f100102/nullerror";
				 } 
				 request.setAttribute("vo", vo);
				 vtype=vo.getType().toLowerCase();
				 if("pa1".equalsIgnoreCase(vtype)  && "2".equalsIgnoreCase(vo.getData300())){
						return "/f10/f1001/f100102/pa1cab106_2";
					}
					//<!-- 退休审批表 -->
				    if("pc2".equalsIgnoreCase(vtype)) {
				    	return "/f10/f1001/f100102/print_txsp";
				    }else{
				    	return "/f10/f1001/f100102/print_"+vtype;
				    }
		   }
			 return "/f10/f1001/f100102/nullerror";
		}
	
	}

	

