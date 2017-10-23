package com.wb.qdyth.f2001.f200101;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wb.jdbcutils.Page;
import com.wb.qdyth.f2001.common.service.YlbxService;
import com.wb.qdyth.f2001.common.vo.Kb77VO;
import com.wb.qdyth.f2001.common.vo.NetDataListVO;
import com.wb.qdyth.f2001.common.vo.NetDataMainAttachmentVO;
import com.wb.utils.web.JsonUtils;
import com.wb.utils.web.RequestUtils;

/**
 * 量化评分表
 * @author yzs
 * 2016-9-07
 */
@Controller
@RequestMapping(value="/work/f20010118/")
public class F20010118Action {
	
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
		return "/f20/f2001/f200101/f20010118/index";
	}
	@RequestMapping("createLhpfbInfo.action")
	@ResponseBody
	public String createLhpfbInfo(){
		String ss=ylbxService.checkLhpfb("200118");
		return ss;
	}
	/**
	 * 量化评分表主信息查询
	 * @param request
	 * @param lsh
	 * @return
	 */
	@RequestMapping("queryLhpfb.action")
	@ResponseBody
	public String queryLhpfb(HttpServletRequest request,NetDataListVO netDataListVO){
		int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
//		int pageSize=21;
		int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
		
		Page page=new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		ylbxService.queryLhpfb(page, "200118",netDataListVO);
		return JsonUtils.getJsonByPage(page);
	}
	/**
	 * 量化评分表查询
	 * @param request
	 * @param lsh
	 * @return
	 */
	@RequestMapping("queryLhpfbInfo.action")
	@ResponseBody
	public String queryLhpfbInfo(HttpServletRequest request,NetDataListVO netDataListVO){
//		int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
		int pageSize=20;
		int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
		
		Page page=new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		ylbxService.queryLhpfbInfo(page, "200118",netDataListVO);
		return JsonUtils.getJsonByPage(page);
	}
	/**
	 * 保存
	 * @param request
	 * @return
	 */
	@RequestMapping("saveDataListInfo.action")
	@ResponseBody
	public String saveDataListInfo(HttpServletRequest request) {
		String dataJson=request.getParameter("dataJson");
		//Long lsh=Long.valueOf(request.getParameter("lsh"));
		//Long dataid=Long.valueOf(request.getParameter("dataid"));
		List<Map<String, Object>> list=JsonUtils.parseJSON2List(dataJson);
		List<NetDataListVO> listvo=new ArrayList<NetDataListVO>();
		for(int i=0;i<list.size();i++){
			Map<String, Object> map=list.get(i);
			NetDataListVO vo=new NetDataListVO();
			vo.setDataid(Long.valueOf(map.get("dataid").toString()));
			vo.setLsh(Long.valueOf(map.get("lsh").toString()));
			if(map.get("data01")!=null){
				vo.setData01(map.get("data01").toString());
			}
			if(map.get("data02")!=null){
				vo.setData02(map.get("data02").toString());
			}
			if(map.get("data29")!=null){
				vo.setData29(map.get("data29").toString());
			}
			if(map.get("data04")!=null){
				vo.setData04(map.get("data04").toString());
			}
			if(map.get("data05")!=null){
				vo.setData05(map.get("data05").toString());
			}
			if(map.get("data30")!=null){
				vo.setData30(map.get("data30").toString());
			}
			if(map.get("data07")!=null){
				vo.setData07(map.get("data07").toString());
			}
			if(map.get("data08")!=null){
				vo.setData08(map.get("data08").toString());
			}
			if(map.get("data09")!=null){
				vo.setData09(map.get("data09").toString());
			}
			if(map.get("data10")!=null){
				vo.setData10(map.get("data10").toString());
			}
			if(map.get("data19")!=null){
				vo.setData19(map.get("data19").toString());
			}
			if(map.get("data20")!=null){
				vo.setData20(map.get("data20").toString());
			}
			listvo.add(vo);
			
		}
		String ss=ylbxService.saveDataListInfo(listvo, Long.valueOf(1),"200118");
		return ss;
	}
	
	/**
	 * 提交
	 * @param request
	 * @return
	 */
	@RequestMapping("saveAllListInfo.action")
	@ResponseBody
	public String saveAllListInfo(HttpServletRequest request) {
		String  ss=ylbxService.saveAllListInfo();
		return ss;
	}
	/**
	 * 查询是否在申报期
	 * @param request
	 * @return
	 */
	@RequestMapping("checkTime.action")
	@ResponseBody
	public String checkTime(HttpServletRequest request) {
		Kb77VO  vo=ylbxService.checkTime();
		return JsonUtils.getJsonData(vo);
	}
	/**
	 * 附件查询
	 * @param request
	 * @param lsh
	 * @return
	 */
	@RequestMapping("queryPfbFjInfo.action")
	@ResponseBody
	public String queryPfbFjInfo(HttpServletRequest request,String busiid,String data01){
		int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
		int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
		
		Page page=new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		ylbxService.queryAllFjInfo(page, busiid,data01);
		return JsonUtils.getJsonByPage(page);
	}
	/**
	 *附件下载
	 * @param request
	 * @return
	 */
	@RequestMapping("downloadAttachMent.action")
	@ResponseBody
	public void downloadAttachMent(HttpServletRequest request,HttpServletResponse response) {
		
		String file_name=request.getParameter("file_name");
		
		Long fileid=Long.valueOf(request.getParameter("fileid"));
		
		response.setCharacterEncoding("UTF-8");
//		response.setContentType("multipart/form-data");
		response.setContentType("application/x-octet-stream");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ file_name);
		response.setBufferSize(4096);
		NetDataMainAttachmentVO vo=ylbxService.queryDataAttachMentById(fileid);
		InputStream inputStream = null;
		try {
			
			try {
				inputStream = vo.getFile_content().getBinaryStream();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			OutputStream os = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
			os.close();

			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 回退
	 * @param request
	 * @return
	 */
	@RequestMapping("updateListForS.action")
	@ResponseBody
	public String updateListForS(HttpServletRequest request) {
		Long lsh = Long.valueOf(request.getParameter("lsh"));
		
		System.out.println(lsh);
		String  ss=ylbxService.updateListForS(lsh);
		return ss;
	}

	/**
	 * 量化评分表处理信息查询
	 * @param request
	 * @param userid
	 * @return
	 */
	@RequestMapping("queryClzt.action")
	@ResponseBody
	public String queryClzt(HttpServletRequest request){
		int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
//		int pageSize=21;
		int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
		String userid = request.getParameter("userid");
		Page page=new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		ylbxService.queryClzt(page,userid);
		return JsonUtils.getJsonByPage(page);
	}
}
