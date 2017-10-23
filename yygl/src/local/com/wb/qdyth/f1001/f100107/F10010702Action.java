package com.wb.qdyth.f1001.f100107;
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
import com.wb.qdyth.f1001.common.vo.BornInfoVO;
import com.wb.utils.web.JsonUtils;
import com.wb.utils.web.RequestUtils;

/**
 * 生育诊疗费查询
 */
@Controller
@RequestMapping(value="/work/f10010702/")
public class F10010702Action {
	@Autowired
	private EmpService empService;
	
	@RequestMapping("index.action")
	public String index(){
		return "/f10/f1001/f100107/f10010702/index";
	}
	@RequestMapping("loadBornMedicalFee.action")
	@ResponseBody
	public String loadBornMedicalFee(HttpServletRequest request){
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		
		int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
		int pageIndex=RequestUtils.getParameter(request, "pageIndex", 0);
		
		Page page=new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		empService.queryBornMedicalFee(page, aac001);
		return JsonUtils.getJsonByPage(page);
	}
//	@RequestMapping("loadSumBornMedicalFee.action")
//	@ResponseBody
//	public String loadSumBornMedicalFee(HttpServletRequest request){
//		HttpSession session=request.getSession();
//		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
//		BornInfoVO vo=empService.querySumBornMedicalFee(aac001);
//		return JsonUtils.getJsonData(vo);
//	}
}
