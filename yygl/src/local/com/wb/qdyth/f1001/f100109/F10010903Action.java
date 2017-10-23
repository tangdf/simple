package com.wb.qdyth.f1001.f100109;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wb.login.SessionUtils;
import com.wb.qdyth.f1001.common.service.EmpService;
import com.wb.qdyth.f1001.common.vo.UserVO;
import com.wb.qdyth.f1001.f100109.vo.PersonQueryVO;
import com.wb.qdyth.f1001.f100109.vs.SbkService;
import com.wb.utils.web.JsonUtils;

/**
 * 社会保障卡口头挂失
 * @author xue
 * 2015-9-25
 */
@Controller
@RequestMapping(value="/work/f10010903/")
public class F10010903Action {

	@Autowired
	private SbkService sbkService;
	
	@RequestMapping("index.action")
	public String index(){
		return "/f10/f1001/f100109/f10010903/index";
	}
	@RequestMapping("querySbkye.action")
	@ResponseBody
	public String querySbkye(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		PersonQueryVO vo=sbkService.querySbkye(aac001);
		return JsonUtils.getJsonData(vo);
	}
	@RequestMapping("saveLsgs.action")
	@ResponseBody
	public String saveLsgs(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		String aac002=(String)session.getAttribute(SessionUtils.NAME);
		Long userid=(Long)session.getAttribute(SessionUtils.USERID);
		String ylkzt=request.getParameter("aaa030");
		sbkService.saveLsgs(aac001, aac002, ylkzt,userid);
		PersonQueryVO vo=new PersonQueryVO();
		return JsonUtils.getJsonData(vo);
	}
	public SbkService getSbkService() {
		return sbkService;
	}
	public void setSbkService(SbkService sbkService) {
		this.sbkService = sbkService;
	}
	

}
