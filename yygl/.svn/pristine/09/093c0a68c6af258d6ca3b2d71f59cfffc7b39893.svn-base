package com.wb.qdyth.f2001.f200101;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wb.jdbcutils.Page;
import com.wb.qdyth.f2001.common.service.YlbxService;
import com.wb.qdyth.f2001.common.vo.NetDataListVO;
import com.wb.qdyth.f2001.common.vo.NetDataMainVO;
import com.wb.utils.web.JsonUtils;
import com.wb.utils.web.RequestUtils;

/**
 * 医疗机构信息受理
 * @author yzs
 * 2015-9-25
 */
@Controller
@RequestMapping(value="/work/f20010101/")
public class F20010101Action {
	
//	private NetDataMainVO netDataMainVO;
	@Autowired
	private YlbxService ylbxService;
	
	
	
	public YlbxService getYlbxService() {
		return ylbxService;
	}
	public void setYlbxService(YlbxService ylbxService) {
		this.ylbxService = ylbxService;
	}
	@RequestMapping("index.action")
	public String index(){
		ylbxService.checkLhpfb("200118");
		return "/f20/f2001/f200101/f20010101/index";
	}
	@RequestMapping("queryInfo.action")
	public String queryInfo(){
		return "/f20/f2001/f200101/f20010102/lhpfb";
	}
	/**
	@RequestMapping("loadUserInfo.action")
	@ResponseBody
	public String loadUserInfo(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String aac001=(String)session.getAttribute(SessionUtils.USERKEY);
		UserVO vo=empService.queryUserInfo(aac001);
		return JsonUtils.getJsonData(vo);
	}
	**/
	/**
	 * 医疗机构文件上传
	 */
//	@RequestMapping("uploadfile.action")
//	@ResponseBody
//	public String uploadfile(@RequestParam("file") MultipartFile[] files,
//            HttpServletRequest request, NetDataMainVO netDataMainVO) {
//		
////		String data01=request.getParameter("data01");
//		String data01=netDataMainVO.getData01();
////		BeanUtils.copyProperties(netDataMainVO, netdataMain);
//		 if(files!=null&&files.length>0){
//			 ylbxService.uploadfile_wq(files, "33312123");
//		 }
//		return null;
//	}
	/**
	 * 医疗机构信息保存
	 */
	@RequestMapping("saveYljgInfo.action")
	@ResponseBody
	public String saveYljgInfo(HttpServletRequest request, NetDataMainVO netDataMainVO) {
		NetDataMainVO vo=ylbxService.saveYljgInfo(null,netDataMainVO, "2001");
		return JsonUtils.getJsonData(vo);
	}
	/**
	 * 查询医疗机构信息
	 * @param request
	 * @return
	 */
	@RequestMapping("queryYljgInfo.action")
	@ResponseBody
	public String queryYljgInfo(HttpServletRequest request) {
		NetDataMainVO vo=ylbxService.queryNetDataMain("2001");
		if(vo!=null){
			return JsonUtils.getJsonData(vo);
		}else{
			return "";
		}
		
	}
	/**
	 * 医疗设备信息保存
	 * @param request
	 * @return
	 */
	@RequestMapping("saveDataListInfo.action")
	@ResponseBody
	public String saveDataListInfo(HttpServletRequest request) {
		String dataJson=request.getParameter("dataJson");
		Long lsh=Long.valueOf(request.getParameter("lsh"));
		//Long dataid=Long.valueOf(request.getParameter("dataid"));
		List<Map<String, Object>> list=JsonUtils.parseJSON2List(dataJson);
		List<NetDataListVO> listvo=new ArrayList<NetDataListVO>();
		for(int i=0;i<list.size();i++){
			Map<String, Object> map=list.get(i);
			NetDataListVO vo=new NetDataListVO();
			if(map.get("dataid")!=null){
				vo.setDataid(Long.valueOf(map.get("dataid").toString()));
			}
			vo.setLsh(lsh);
			vo.setData01(map.get("data01").toString());
			vo.setData02(map.get("data02").toString());
			listvo.add(vo);
			
		}
		String ss=ylbxService.saveDataListInfo(listvo, lsh,"2001");
		return ss;
	}
	/**
	 * 医疗设备信息删除
	 * @param request
	 * @return
	 */
	@RequestMapping("deleteDataListInfo.action")
	@ResponseBody
	public String deleteDataListInfo(HttpServletRequest request) {
		String dataJson=request.getParameter("dataJson");
		List<Map<String, Object>> list=JsonUtils.parseJSON2List(dataJson);
//		List<Object> list1=new ArrayList<Object>();
		StringBuffer bf=new  StringBuffer();
		for(int i=0;i<list.size();i++){
			Map<String, Object> map=list.get(i);
			if(map.get("dataid")!=null){
				bf.append(map.get("dataid")+",");
			}
		}
		Long lsh = null;
		if(bf!=null&&!"".equals(bf)){
			ylbxService.deleteDataListInfo(bf.toString(),"2001",lsh);
		}
		
		return "";
	}
	/**
	 * 医疗机构信息保存
	 */
	/**@RequestMapping("saveYljgInfo.action")
	@ResponseBody
	public String saveYljgInfo(@RequestParam("file") MultipartFile[] files,
            HttpServletRequest request, NetDataMainVO netDataMainVO) {
		
		 if(files!=null&&files.length>0){
			 //判断文件大小
			 
			 ylbxService.saveYljgInfo(files,netDataMainVO, "2001");
		 }
		return "保存成功";
	}**/
	/**
	 * 医疗保险机构信息查询
	 * @param request
	 * @param cxtj1
	 * @param cxtj2
	 * @param cxtj3
	 * @return
	 */
	@RequestMapping("queryYlbxInfo.action")
	@ResponseBody
	public String queryYlbxInfo(HttpServletRequest request,String cxtj1,String cxtj2,String cxtj3 ){
		int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
		int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
		
		Page page=new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		ylbxService.queryYlbxInfo(page, cxtj1, cxtj2, cxtj3);
		return JsonUtils.getJsonByPage(page);
	}
	/**
	 * 医疗设备信息查询
	 * @param request
	 * @param cxtj1
	 * @return
	 */
	@RequestMapping("queryYlsb.action")
	@ResponseBody
	public String queryYlsb(HttpServletRequest request,String lsh ){
		int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
		int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
		
		Page page=new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		ylbxService.queryYlsb(page, lsh);
		return JsonUtils.getJsonByPage(page);
	}
	/**
	 * 机构信息打印
	 * @return
	 */
	@RequestMapping("printJgInfo.action")
	public String printJgInfo(HttpServletRequest request,String lsh){
		NetDataMainVO vo= ylbxService.queryNetDataMain("2001");
		List<NetDataListVO>  list=ylbxService.queryNetDataList(lsh);
		request.setAttribute("vo", vo);
		request.setAttribute("list", list);
		return "/f20/f2001/f200101/f20010101/print_jg";
	}

}
