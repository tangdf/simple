package com.wb.qdyth.f1001.f100101;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wb.login.SessionUtils;
import com.wb.qdyth.f1001.common.service.EmpService;
import com.wb.qdyth.f1001.common.vo.UserVO;
import com.wb.utils.web.JsonUtils;

/**
 * 参保信息
 * @author xue
 * 2015-9-25
 */
@Controller
@RequestMapping(value="/work/f10010103/")
public class F10010103Action{

	@Autowired
	private EmpService empService;
	@RequestMapping("index.action")
	public String index(){
		return "/f10/f1001/f100101/f10010103/index";
	}
	/**
	 * 查询人员信息
	 * @param request
	 * @return
	 */
	@RequestMapping("loadBaseInfo.action")
	@ResponseBody
	public String loadBaseInfo(HttpServletRequest request){
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		UserVO vo=empService.queryUserInfo(aac001);
		return JsonUtils.getJsonData(vo);
	}
	/**
	 * 更新人员信息
	 * @param request
	 * @param vo
	 * @return
	 */
	@RequestMapping("saveBaseInfo.action")
	@ResponseBody
	public String saveBaseInfo(UserVO vo){
		empService.saveBaseInfo(vo);
		return JsonUtils.getJsonData(vo);
	}
	public EmpService getEmpService() {
		return empService;
	}
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	

}
