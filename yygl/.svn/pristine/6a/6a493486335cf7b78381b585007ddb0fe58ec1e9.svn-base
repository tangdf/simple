package com.wb.qdyth.f1001.f100109;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wb.jdbcutils.Page;
import com.wb.login.SessionUtils;
import com.wb.qdyth.f1001.f100109.vs.SbkService;
import com.wb.qdyth.f1001.f100109.vo.SbkVO;
import com.wb.utils.web.JsonUtils;
import com.wb.utils.web.RequestUtils;

/**
 * 社会保障卡消费明细查询
 * @author xue
 * 2015-9-25
 */
@Controller
@RequestMapping(value="/work/f10010904/")
public class F10010904Action {

	@Autowired
	private SbkService sbkService;
	
	@RequestMapping("index.action")
	public String index(){
		return "/f10/f1001/f100109/f10010904/index";
	}
	@RequestMapping("querySbkConsume.action")
	@ResponseBody
	public String querySbkConsume(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		
		int pageSize = RequestUtils.getParameter(request, "pageSize", 0);
		int pageIndex = RequestUtils.getParameter(request, "pageIndex", 0);
		
		Page page = new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		sbkService.querySbkConsume(page, aac001);
		return JsonUtils.getJsonByPage(page);
	}
	@RequestMapping("querySbkConsumeSum.action")
	@ResponseBody
	public String querySbkConsumeSum(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		SbkVO vo=sbkService.querySbkConsumeSum( aac001);
		return JsonUtils.getJsonData(vo);
	}
	public SbkService getSbkService() {
		return sbkService;
	}
	public void setSbkService(SbkService sbkService) {
		this.sbkService = sbkService;
	}

}
