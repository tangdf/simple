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
import com.wb.utils.web.JsonUtils;
import com.wb.utils.web.RequestUtils;

/**
 * 社会保障卡申领进度查询 
 * @author xue
 * 2015-9-25
 */
@Controller
@RequestMapping(value="/work/f10010902/")
public class F10010902Action {

	@Autowired
	private SbkService sbkService;
	
	@RequestMapping("index.action")
	public String index(){
		return "/f10/f1001/f100109/f10010902/index";
	}
	@RequestMapping("querySbkApplyProgress.action")
	@ResponseBody
	public String querySbkApplyProgress(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		
		int pageSize = RequestUtils.getParameter(request, "pageSize", 0);
		int pageIndex = RequestUtils.getParameter(request, "pageIndex", 0);
		
		Page page = new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		sbkService.querySbkApplyProgress(page, aac001);
		return JsonUtils.getJsonByPage(page);
	}
	
	

}
