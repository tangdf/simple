package com.wb.qdyth.f2001.f200101;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wb.jdbcutils.Page;
import com.wb.qdyth.f2001.common.service.YlbxService;
import com.wb.qdyth.f2001.common.vo.NetDataMainAttachmentVO;
import com.wb.qdyth.f2001.common.vo.NetDataMainVO;
import com.wb.utils.web.JsonUtils;
import com.wb.utils.web.RequestUtils;

/**
 * 医院医疗收费标准与物价部门制定价格标准对比清单受理
 * @author yzs
 * 2016-9-07
 */
@Controller
@RequestMapping(value="/work/f20010115/")
public class F20010115Action {
	
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
		return "/f20/f2001/f200101/f20010115/index";
	}
	/**
	 * 保存
	 */
	@RequestMapping("saveSfdbInfo.action")
	@ResponseBody
	public String saveSfdbInfo(@RequestParam("file") MultipartFile[] files,
			HttpServletRequest request, NetDataMainVO netDataMainVO) {
		NetDataMainVO vo=ylbxService.saveYljgInfo(files,netDataMainVO, "200115");
		return JsonUtils.getJsonData(vo);
	}
	
	/**
	 * 附件查询
	 * @param request
	 * @param lsh
	 * @return
	 */
	@RequestMapping("querySfdbFjInfo.action")
	@ResponseBody
	public String querySfdbFjInfo(HttpServletRequest request,String lsh){
		int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
		int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
		
		Page page=new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		ylbxService.queryFjInfo(page, lsh);
		return JsonUtils.getJsonByPage(page);
	}
	/**
	 * 查询信息
	 * @param request
	 * @return
	 */
	@RequestMapping("querySfdbInfo.action")
	@ResponseBody
	public String querySfdbInfo(HttpServletRequest request) {
		NetDataMainVO vo=ylbxService.queryNetDataMain("200115");
		if(vo!=null){
			return JsonUtils.getJsonData(vo);
		}else{
			return "";
		}
		
	}
	/**
	 *附件删除
	 * @param request
	 * @return
	 */
	@RequestMapping("deleteDataAttachMentInfo.action")
	@ResponseBody
	public String deleteDataAttachMentInfo(HttpServletRequest request) {
		String dataJson=request.getParameter("dataJson");
		List<Map<String, Object>> list=JsonUtils.parseJSON2List(dataJson);
		StringBuffer bf=new  StringBuffer();
		for(int i=0;i<list.size();i++){
			Map<String, Object> map=list.get(i);
			if(map.get("fileid")!=null){
				bf.append(map.get("fileid")+",");
			}
		}
		if(bf!=null&&!"".equals(bf)){
			ylbxService.deleteDataAttachMentInfo(bf.toString());
		}
		
		return "";
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

}
