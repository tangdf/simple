package com.wb.qdyth.common.service;

import org.springframework.web.multipart.MultipartFile;

import com.wb.qdyth.common.bo.Ac01Dto;
import com.wb.qdyth.common.bo.MobileUserBinding;
import com.wb.qdyth.common.bo.NetData;
import com.wb.qdyth.common.bo.PasswordResetVO;
import com.wb.qdyth.common.bo.UaasUserPassport;
import com.wb.user.model.UaasUpdaVO;

/**
 * 个人查询工程共用Service
 * @author xue
 * 2015-9-27
 */
public interface CommonService {

	/**
	 * 
	 * @param busiid
	 * @param links
	 * @return
	 */
	public Long creatBusinessLog(String busiid, String...links);
	
	public Long getlsh(String busiid,String name, String...links);
	
	/**
	 * 保存业务主表net_data
	 * @param lsh
	 * @param busiid
	 */
	public NetData saveNetDate(Long lsh,String busiid);
	/**
	 * 根据ID查询UaasUpad
	 * @param userid
	 * @return
	 */
	public UaasUpdaVO queryUaasUpdaByUserId(String userid);
	/**
	 * 修改密码
	 * @param passwordResetVO
	 * @return
	 */
	public void updatePassword(PasswordResetVO passwordResetVO);
	/**
	 * 修改密保问题
	 * @param passwordResetVO
	 * @return
	 */
	public void updatePassport(PasswordResetVO passwordResetVO);
	/**
	 * 查询人员信息
	 * @param aac001
	 * @param aac002
	 * @return
	 */
	public Ac01Dto getRybh(String aac001,String aac002);
	/**
	 * 取出密保问题
	 * @return
	 */
	public UaasUserPassport getUaasPassport(String aac001);
	/**
	 * 取出密保问题
	 * @return
	 */
	public UaasUserPassport getUaasPassport(UaasUserPassport uup);
	/**
	 * 取出手机绑定问题
	 * @return
	 */
	public MobileUserBinding getUaasMobile(String aac001);
	/**
	 * 取出手机绑定信息
	 * @return
	 */
	public MobileUserBinding getUaasMobileByAac147(String aac001,String aac147);
	/**
	 * 取出手机绑定信息
	 * @return
	 */
	public MobileUserBinding getUaasMobileByPhone(String aac001,String phone);
	/**
	 * 生成手机验证码
	 * @return
	 */
	public String genCode() ;
	/**
	 * 插入手机绑定信息
	 * @param mub
	 */
	public void savePhoneBdInfo(MobileUserBinding mub);
	/**
	 * 根据手机绑定信息获取uaasupda
	 * @param phone
	 * @param aac001
	 * @return
	 */
	public UaasUpdaVO getUpadByMobileBing(String phone,String aac001);
	/**
	 * 文件上传
	 * @param files
	 * @param lsh
	 */
	public void uploadfile_wq(MultipartFile[] files, String lsh,String busiid);
}
