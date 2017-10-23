package com.wb.qdyth.f1001.f100109;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wb.contain.listener.model.APPAA10;
import com.wb.login.SessionUtils;
import com.wb.qdyth.f1001.common.vo.UserVO;
import com.wb.qdyth.f1001.f100109.vo.Psbank;
import com.wb.qdyth.f1001.f100109.vs.SbkService;
import com.wb.utils.web.JsonUtils;

/**
 * 社会保障卡申领
 * @author xue
 * 2015-9-25
 */
@Controller
@RequestMapping(value="/work/f10010901/")
public class F10010901Action {

	@Autowired
	private SbkService sbkService;
	
	@RequestMapping("index.action")
	public String index(){
		return "/f10/f1001/f100109/f10010901/index";
	}
	/**
	 * 查询申请信息
	 * @param request
	 * @return
	 */
	@RequestMapping("querySbkApplyInfo.action")
	@ResponseBody
	public String querySbkApplyInfo(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		UserVO vo=sbkService.querySbkApplyInfo(aac001);
		return JsonUtils.getJsonData(vo);
	}
	/**
	 * 查询银行列表
	 * @param request
	 * @return
	 */
	@RequestMapping("queryYhlb.action")
	@ResponseBody
	public String queryYhlb(HttpServletRequest request) {
		List<APPAA10> aae008=sbkService.queryYhlb();
		return JsonUtils.getJsonDataFromCollection(aae008);
	}
	/**
	 * 查询网点编码
	 * @param request
	 * @return
	 */
	@RequestMapping("queryWdbm.action")
	@ResponseBody
	public String queryWdbm(HttpServletRequest request) {
		String aea001One=request.getParameter("aea001One");
		List<APPAA10> aae008=sbkService.queryWdbm(aea001One);
		return JsonUtils.getJsonDataFromCollection(aae008);
	}
	/**
	 * 查询网点编码
	 * @param request
	 * @return
	 */
	@RequestMapping("queryWdxx2.action")
	@ResponseBody
	public String queryWdxx2(HttpServletRequest request) {
		String nodeid=request.getParameter("nodeid");
		List<APPAA10> aae008=sbkService.queryWdxx2(nodeid);
		return JsonUtils.getJsonDataFromCollection(aae008);
	}
	/**
	 * 保存银行绑定信息
	 * @param request
	 * @param vo
	 * @return
	 */
	@RequestMapping("saveSbkApplyInfo.action")
	@ResponseBody
	public String saveSbkApplyInfo(HttpServletRequest request,UserVO vo) {
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		vo.setAac001(aac001);
		Psbank pb=sbkService.saveSbkApplyInfo(vo);
		return JsonUtils.getJsonData(pb);
	}
	public SbkService getSbkService() {
		return sbkService;
	}
	public void setSbkService(SbkService sbkService) {
		this.sbkService = sbkService;
	}
	

}
