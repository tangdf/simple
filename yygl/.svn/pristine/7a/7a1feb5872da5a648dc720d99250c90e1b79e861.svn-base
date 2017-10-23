package com.wb.qdyth.f1001.f100105;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wb.login.SessionUtils;
import com.wb.qdyth.f1001.common.service.EmpService;
import com.wb.qdyth.f1001.common.vo.PensionVO;
import com.wb.qdyth.f1001.common.vo.RetireResignQueryVO;

/**
 * 退休退职人员调待查询
 */
@Controller
@RequestMapping(value="/work/f10010504/")
public class F10010504Action {
	@Autowired
	private EmpService empService;
	
	@RequestMapping("index.action")
	public String index(){
		return "/f10/f1001/f100105/f10010504/index";
	}
	@RequestMapping("queryTxtzTdDetails.action")
	public String queryTxtzTdDetails(HttpServletRequest request){
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		
		try{
			RetireResignQueryVO retireResignQueryVO=new RetireResignQueryVO();
			retireResignQueryVO.setAac001(aac001);
			RetireResignQueryVO baseVO = empService.queryTxtzTdDetails(retireResignQueryVO);
			List<PensionVO> pensionVOList = empService.getPensionList(retireResignQueryVO);
			List<PensionVO> exceptPensionVOList=empService.getExcPensionList(retireResignQueryVO);
			request.setAttribute("baseVO", baseVO);
			request.setAttribute("pensionVOList", pensionVOList);
			request.setAttribute("exceptPensionVOList", exceptPensionVOList);
			}catch(Exception e){
				e.printStackTrace();
			}
		return "/f10/f1001/f100105/f10010504/print";
	}
}
