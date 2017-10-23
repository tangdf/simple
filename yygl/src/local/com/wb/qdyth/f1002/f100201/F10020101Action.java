package com.wb.qdyth.f1002.f100201;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wb.login.SessionUtils;
import com.wb.qdyth.f1002.common.service.JmylService;
import com.wb.qdyth.f1002.common.vo.PersonBaseQueryVO;
import com.wb.utils.web.JsonUtils;

/**
 * 人员基本信息
 * @author xue
 * 2015-9-25
 */
@Controller
@RequestMapping(value="/work/f10020101/")
public class F10020101Action {

	@Autowired
	private JmylService jmylService;
	
	@RequestMapping("index.action")
	public String index(){
		return "/f10/f1002/f100201/f10020101/index";
	}
	@RequestMapping("loadJmylUserInfo.action")
	@ResponseBody
	public String loadJmylUserInfo(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		PersonBaseQueryVO vo=jmylService.queryUserInfo(aac001);
		return JsonUtils.getJsonData(vo);
	}
	public JmylService getJmylService() {
		return jmylService;
	}
	public void setJmylService(JmylService jmylService) {
		this.jmylService = jmylService;
	}
	

}
