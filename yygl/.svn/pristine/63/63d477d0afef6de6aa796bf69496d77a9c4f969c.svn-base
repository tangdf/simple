package com.wb.qdyth.f1002.f100201;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wb.jdbcutils.Page;
import com.wb.login.SessionUtils;
import com.wb.qdyth.f1002.common.service.JmylService;
import com.wb.qdyth.f1002.common.vo.PersonBaseQueryVO;
import com.wb.utils.web.JsonUtils;
import com.wb.utils.web.RequestUtils;

/**
 * 缴费信息查询
 * @author xue
 * 2015-9-25
 */
@Controller
@RequestMapping(value="/work/f10020104/")
public class F10020104Action {

	@Autowired
	private JmylService jmylService;
	
	@RequestMapping("index.action")
	public String index(){
		return "/f10/f1002/f100201/f10020104/index";
	}
	@RequestMapping("queryJmylJfInfo.action")
	@ResponseBody
	public String queryJmylJfInfo(HttpServletRequest request){
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		PersonBaseQueryVO vo = jmylService.queryJmylJfInfo(aac001);
		return JsonUtils.getJsonData(vo);
	}
	@RequestMapping("queryPayStautsInfo.action")
	@ResponseBody
	public String queryPayStautsInfo(HttpServletRequest request){
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		
		int pageSize = RequestUtils.getParameter(request, "pageSize", 0);
		int pageIndex = RequestUtils.getParameter(request, "pageIndex", 0);
		
		Page page = new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		jmylService.queryPayStautsInfo(page, aac001);
		return JsonUtils.getJsonByPage(page);
	}
	public JmylService getJmylService() {
		return jmylService;
	}
	public void setJmylService(JmylService jmylService) {
		this.jmylService = jmylService;
	}
	

}
