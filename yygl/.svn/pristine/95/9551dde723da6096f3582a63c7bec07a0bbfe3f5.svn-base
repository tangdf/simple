package com.wb.qdyth.f2001.f200101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wb.jdbcutils.Page;
import com.wb.qdyth.f2001.common.service.YlbxService;
import com.wb.qdyth.f2001.common.vo.NetDataListVO;
import com.wb.qdyth.f2001.common.vo.NetDataMainAttachmentVO;
import com.wb.qdyth.f2001.common.vo.NetDataMainVO;
import com.wb.utils.web.ExportExcel;
import com.wb.utils.web.JsonUtils;
import com.wb.utils.web.RequestUtils;

/**
 * 护理人员信息受理
 * @author yzs
 * 2016-9-07
 */
@Controller
@RequestMapping(value="/work/f20010110/")
public class F20010110Action {
	
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
		return "/f20/f2001/f200101/f20010110/index";
	}
	/**
	 * 保存
	 */
	@RequestMapping("saveHlInfo.action")
	@ResponseBody
	public String saveHlInfo(@RequestParam("file") MultipartFile[] files,
			HttpServletRequest request, NetDataMainVO netDataMainVO) {
		NetDataMainVO vo=ylbxService.saveYljgInfo(files,netDataMainVO, "200110");
		return JsonUtils.getJsonData(vo);
	}
	/**
	 * 护理人员信息删除
	 * @param request
	 * @return
	 */
	@RequestMapping("deleteDataListInfo.action")
	@ResponseBody
	public String deleteDataListInfo(HttpServletRequest request) {
		Long a = System.currentTimeMillis();
		System.out.println(a);
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
		Long lsh = (Long) list.get(0).get("lsh");
		if(bf!=null&&!"".equals(bf)){
			ylbxService.deleteDataListInfo(bf.toString(),"200110",lsh);
		}
		Long b = System.currentTimeMillis();
		System.out.println(b);
		System.out.println(b-a);
		return "";
	}
	
	/**
	 * 附件查询
	 * @param request
	 * @param lsh
	 * @return
	 */
	@RequestMapping("queryHlFjInfo.action")
	@ResponseBody
	public String queryHlFjInfo(HttpServletRequest request,String lsh){
		int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
		int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
		
		Page page=new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		ylbxService.queryFjInfo(page, lsh);
		return JsonUtils.getJsonByPage(page);
	}
	/**
	 * 查询
	 * @param request
	 * @return
	 */
	@RequestMapping("queryHlInfo.action")
	@ResponseBody
	public String queryHlInfo(HttpServletRequest request, NetDataListVO netDataListVO) {
		int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
		int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
		
		Page page=new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		ylbxService.queryNetDataList(page, "200110",netDataListVO);
		return JsonUtils.getJsonByPage(page);
		
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
//		List<Object> list1=new ArrayList<Object>();
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
	@RequestMapping("importHl.action")
	@ResponseBody
	public void importHl(@RequestParam("upfile") MultipartFile myfile,HttpServletRequest request,HttpServletResponse response) {
		List<List<Object>> listob = null;
		try {
			//用utf-8编码，解决中文乱码
			//response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
	        CommonsMultipartFile cf= (CommonsMultipartFile)myfile; 
	        DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
	        File file1 = fi.getStoreLocation();
			myfile.transferTo(file1);
			FileInputStream file = new FileInputStream(file1);
			//System.out.println("文件size:"+String.valueOf(file.available()/1000)+"k");
			try {
				listob = new ExportExcel().getBankListByExcel(file); 
				file.close();
				String message="导入完成!";
				List<NetDataMainVO> errorlist = new ArrayList<NetDataMainVO>();
				//该处可调用service相应方法进行数据保存到数据库中，现只对数据输出  
				for (int i = 0; i < listob.size(); i++) {  
					NetDataMainVO errvo = new NetDataMainVO();
					List<Object> lo = listob.get(i); 
					String data01 =lo.get(0).toString();
					String data02 =lo.get(1).toString();
					String data03 =lo.get(2).toString();
					String data04 =lo.get(3).toString();
					String data05 =lo.get(4).toString();
					String data06 =lo.get(5).toString();
					String data07 =lo.get(6).toString();
					String data08 =lo.get(7).toString();
					String data09 =lo.get(8).toString();
					String data10 =lo.get(9).toString();
					String data11 =lo.get(10).toString();
					if("男".equals(data03)){
						data03="1";
					}else if("女".equals(data03)){
						data03="2";
					}else{
						data03="";
					}
					if("退休".equals(data04)){
						data04="1";
					}else if("在职".equals(data04)){
						data04="2";
					}else{
						data04="";
					}
					if("临床".equals(data07)){
						data07="1";
					}else if("中医".equals(data07)){
						data07="2";
					}else if("口腔".equals(data07)){
						data07="3";
					}else if("公共卫生".equals(data07)){
						data07="4";
					}else{
						data07="";
					}
					if("初级".equals(data09)){
						data09="1";
					}else if("中级".equals(data09)){
						data09="2";
					}else if("高级".equals(data09)){
						data09="3";
					}else{
						data09="";
					}
					errvo.setData01(data01);
					errvo.setData02(data02);
					errvo.setData03(data03);
					errvo.setData04(data04);
					errvo.setData05(data05);
					errvo.setData06(data06);
					errvo.setData07(data07);
					errvo.setData08(data08);
					errvo.setData09(data09);
					errvo.setData10(data10);
					errvo.setData11(data11);
					NetDataMainVO netDataMainVO = new NetDataMainVO();
					if("".equals(data01)){
						//message="导入失败:第"+(i+1)+"行姓名不能为空！";
						errvo.setName("姓名不能为空！");
						errorlist.add(errvo);
						continue;
					}else{
						netDataMainVO.setData01(data01);
					}
					if("".equals(data02)){
						//message="导入失败:第"+(i+1)+"行身份证号不能为空！";
						errvo.setName("身份证号不能为空！");
						errorlist.add(errvo);
						continue;
					}else{
						if(data02.length()>18){
							//message="导入失败:第"+(i+1)+"行身份证号不得大于18位！";
							errvo.setName("身份证号不得大于18位！");
							errorlist.add(errvo);
							continue;
						}else{
							netDataMainVO.setData02(data02);
						}
					}
					if("".equals(data03)){
						//message="导入失败:第"+(i+1)+"行性别不能为空！";
						errvo.setName("性别不能为空！");
						errorlist.add(errvo);
						continue;
					}else{
						netDataMainVO.setData03(data03);
					}
					if("".equals(data04)){
						//message="导入失败:第"+(i+1)+"行人员类别不能为空！";
						errvo.setName("人员类别不能为空！");
						errorlist.add(errvo);
						continue;
					}else{
						netDataMainVO.setData04(data04);
					}
					if("".equals(data05)){
						//message="导入失败:第"+(i+1)+"行资格证号不能为空！";
						errvo.setName("资格证号不能为空！");
						errorlist.add(errvo);
						continue;
					}else{
						netDataMainVO.setData05(data05);
					}
					if("".equals(data06)){
						//message="导入失败:第"+(i+1)+"行执业（注册）证号不能为空！";
						errvo.setName("执业（注册）证号不能为空！");
						errorlist.add(errvo);
						continue;
					}else{
						netDataMainVO.setData06(data06);
					}
					if("".equals(data07)){
						//message="导入失败:第"+(i+1)+"行职业类别不能为空！";
						errvo.setName("职业类别不能为空！");
						errorlist.add(errvo);
						continue;
					}else{
						netDataMainVO.setData07(data07);
					}
					if("".equals(data08)){
						//message="导入失败:第"+(i+1)+"行职业范围不能为空！";
						errvo.setName("职业范围不能为空！");
						errorlist.add(errvo);
						continue;
					}else{
						netDataMainVO.setData08(data08);
					}
					if("".equals(data09)){
						//message="导入失败:第"+(i+1)+"行职称不能为空！";
						errvo.setName("职称不能为空！");
						errorlist.add(errvo);
						continue;
					}else{
						netDataMainVO.setData09(data09);
					}
					if("".equals(data10)){
						//message="导入失败:第"+(i+1)+"行所在科室不能为空！";
						errvo.setName("所在科室不能为空！");
						errorlist.add(errvo);
						continue;
					}else{
						netDataMainVO.setData10(data10);
					}
					netDataMainVO.setData11(data11);
					NetDataMainVO vo=ylbxService.validateYsInfo(netDataMainVO, "200110");
					if(vo!=null){
						if(vo.getStatus()!=null){
							if("3".equals(vo.getStatus())){
								//message="导入失败:第"+(i+1)+"行"+vo.getName();
								errvo.setName(vo.getName());
								errorlist.add(errvo);
								continue;
							}else if("1".equals(vo.getStatus())||"10".equals(vo.getStatus())){
								NetDataMainVO vo2=ylbxService.saveYljgInfo(null,netDataMainVO, "200110");
								if(vo2!=null){
									if(vo2.getStatus()!=null){
										if("2".equals(vo2.getStatus())){
											//message = "导入失败：量化评分表已经提交，无法继续修改！";
											errvo.setName("量化评分表已经提交，无法继续修改！");
											errorlist.add(errvo);
											continue;
										}else if("3".equals(vo2.getStatus())||"4".equals(vo2.getStatus())){
											//message="导入失败:第"+(i+1)+"行"+vo.getName();
											errvo.setName(vo.getName());
											errorlist.add(errvo);
											continue;
										}else if("1".equals(vo2.getStatus())){
											continue;
										}else{
											//message="导入失败，请检查文件!";
											errvo.setName("导入失败，请检查文件!");
											errorlist.add(errvo);
											continue;
										}
									}else{
										//message="导入失败，请检查文件!";
										errvo.setName("导入失败，请检查文件!");
										errorlist.add(errvo);
										continue;
									}
								}else{
									//message="导入失败，请检查文件!";
									errvo.setName("导入失败，请检查文件!");
									errorlist.add(errvo);
									continue;
								}
							}else{
								//message="导入失败，请检查文件!";
								errvo.setName("导入失败，请检查文件!");
								errorlist.add(errvo);
								continue;
							}
						}else{
							//message="导入失败，请检查文件!";
							errvo.setName("导入失败，请检查文件!");
							errorlist.add(errvo);
							continue;
						}
					}
					else{
						//message="导入失败，请检查文件!";
						errvo.setName("导入失败，请检查文件!");
						errorlist.add(errvo);
						continue;
					}
					
				}
				message=message+"成功"+(listob.size()-errorlist.size())+"条，"+"失败"+errorlist.size()+"条";
				out.println(ylbxService.getError(message, errorlist,"200110"));
				//out.println(getError(message));					
			} catch (Exception e) {
				out.println(ylbxService.getError("导入失败，请检查文件!",null,"200110"));
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 查询
	 * @param request
	 * @return
	 */
	@RequestMapping("queryErrInfo.action")
	@ResponseBody
	public String queryErrInfo(HttpServletRequest request, NetDataListVO netDataListVO) {
		int pageSize=RequestUtils.getParameter(request, "pageSize", 0);
		int pageIndex=RequestUtils.getParameter(request,"pageIndex" , 0);
		
		Page page=new Page();
		page.setPageno(pageIndex+1);
		page.setPagesize(pageSize);
		ylbxService.queryNetDataList2(page, "200110",netDataListVO);
		return JsonUtils.getJsonByPage(page);
		
	}
}
