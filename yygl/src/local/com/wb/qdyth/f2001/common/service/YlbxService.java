package com.wb.qdyth.f2001.common.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wb.jdbcutils.Page;
import com.wb.qdyth.f2001.common.vo.ExportVO;
import com.wb.qdyth.f2001.common.vo.Kb77VO;
import com.wb.qdyth.f2001.common.vo.NetDataListVO;
import com.wb.qdyth.f2001.common.vo.NetDataMainAttachmentVO;
import com.wb.qdyth.f2001.common.vo.NetDataMainVO;

public interface YlbxService {
	/***
	 * 医疗机构信息保存
	 */
	public NetDataMainVO saveYljgInfo(MultipartFile[] files,NetDataMainVO netDataMainVO,String busiid) ;
	/**
	 * 医疗机构信息查询
	 * @param page
	 * @param cxtj1
	 * @param cxtj2
	 * @param cxtj3
	 */
	public void queryYlbxInfo(Page page,String cxtj1,String cxtj2,String cxtj3);
	
	/**
	 * 附件查询
	 * @param page
	 * @param lsh
	 */
	public void queryFjInfo(Page page,String lsh);
	public void queryAllFjInfo(Page page,String busiid,String data01);
	/**
	 * 医疗设备信息查询
	 * @param page
	 * @param lsh
	 */
	public void queryYlsb(Page page,String lsh);
	/***
	 * 根据业务id查询
	 */
	public NetDataMainVO queryNetDataMain(String busiid) ;
	/***
	 * 根据业务id查询
	 */
	public void queryNetDataList(Page page,String busiid, NetDataListVO netDataListVO) ;
	/***
	 * 量化评分表查询
	 */
	public void queryLhpfbInfo(Page page,String busiid, NetDataListVO netDataListVO) ;
	public void queryLhpfb(Page page,String busiid, NetDataListVO netDataListVO) ;
	
	
	/***
	 * 根据业务id查询
	 */
	public List<NetDataListVO> queryNetDataList(String lsh) ;
	/***
	 * 保存医疗设备信息
	 */
	public String saveDataListInfo(List<NetDataListVO> list,Long lsh,String busiid) ;
	/**
	 * 受理信息提交
	 */
	public String saveAllListInfo() ;
	public Kb77VO checkTime() ;
	/***
	 * 删除医疗设备信息
	 */
	public void deleteDataListInfo(String dataid,String busiid, Long lsh) ;
	
	/***
	 * 附件删除
	 */
	public void deleteDataAttachMentInfo(String fileid) ;
	
	/***
	 * 根据附件id查询
	 */
	public NetDataMainAttachmentVO queryDataAttachMentById(Long fileid) ;
	/**
	 * 检查是否有量化评分表
	 * @return
	 */
	public String checkLhpfb(String busiid) ;
	
	/**
	 * 回退已提交量化评分表
	 * @return
	 */
	public String updateListForS(Long lsh);
	
	/**
	 * 处理状态查询
	 * @param page
	 * @param netDataListVO
	 */
	public void queryClzt(Page page, String userid);
	
	public NetDataMainVO validateYsInfo(NetDataMainVO netDataMainVO,String busiid);
	public void queryNetDataList2(Page page, String string,
			NetDataListVO netDataListVO);
	public String getError(String message,List<NetDataMainVO> vos,String busiid);
	/**
	 * 导出失败信息
	 * @param string
	 * @param pc
	 * @return
	 */
	public List<ExportVO> exportYs(String busiid, String pc);

}
