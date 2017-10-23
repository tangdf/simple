package com.wb.qdyth.f1001.common.service;

import java.util.List;

import com.wb.jdbcutils.Page;
import com.wb.qdyth.f1001.common.vo.BornInfoVO;
import com.wb.qdyth.f1001.common.vo.PaymentVO;
import com.wb.qdyth.f1001.common.vo.PensionInfoVO;
import com.wb.qdyth.f1001.common.vo.PensionVO;
import com.wb.qdyth.f1001.common.vo.RetireResignQueryVO;
import com.wb.qdyth.f1001.common.vo.UserVO;
import com.wb.qdyth.f1001.common.vo.WorkInjuryVO;




/**
 * 职工信息查询公用Service
 * @author xue
 * 2015-9-25
 */
public interface EmpService {
	/**
	 * 查询人员基本信息
	 * @return
	 */
	public UserVO queryUserInfo(String aac001);
	/**
	 * 查询个人参保信息
	 * @return
	 */
	public void queryInsureInfo(Page page,String aac001);
	/**
	 * 人员基本信息修改
	 * @param vo
	 */
	public void saveBaseInfo(UserVO vo);

	/**
	 * 当前年度缴费基数
	 * @return
	 */
	public void queryCurrentPay(Page page,String aac001);
	/**
	 * 养老缴费明细查询+缴费合计查询
	 * @return
	 */
	public void queryAgedPay(Page page,String aac001);
	public PaymentVO querySumPay(String aac001);
	/**
	 * 医疗缴费明细查询
	 * @return
	 */
	public void queryMedicalPay(Page page,String aac001);
	/**
	 * 失业缴费明细查询
	 * @return
	 */
	public void queryUnemploymentPay(Page page,String aac001);
	/**
	 * 医疗保险审批查询
	 * @return
	 */
	public void queryMedicalApproval(Page page,String aac001);
	/**
	 * 医疗住院结算查询
	 * @return
	 */
	public void queryMedicalSettlement(Page page,String aac001);
	/**
	 * 医疗年度情况查询
	 * @return
	 */
	public void queryMedicalAnnualInfo(Page page,String aac001);
	/**
	 * 在职养老账户查询
	 * @return
	 */
	public void queryPensionAccounts(Page page,String aac001);
	/**
	 * 退休待遇项目查询+金额合计查询
	 * @return
	 */
	public void queryRetirementBenifits(Page page,String aac001);
	public PensionInfoVO querySumTreatment(String aac001);
	/**
	 * 养老金发放明细查询+金额合计查询
	 * @return
	 */
	public void queryPensionDetails(Page page,String aac001);
	public PensionInfoVO querySumPensionDetails(String aac001);
	/**
	 * 工伤定期待遇补退明细查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryWorkInjuryTreatment1(Page page,String aac001);
	public WorkInjuryVO getWorkInjuryInfo(Long aaz166);
	public WorkInjuryVO querySumWorkInjury1(String aac001);
	/**
	 * 工伤定期待遇发放明细查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryWorkInjuryTreatment2(Page page,String aac001);
	public WorkInjuryVO querySumWorkInjury2(String aac001);
	/**
	 * 工伤一次性伤残补助金明细查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryWorkInjuryTreatment3(Page page,String aac001);
	public WorkInjuryVO querySumWorkInjury3(String aac001);
	/**
	 * 工伤待遇明细查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryWorkInjuryTreatment4(Page page,String aac001);
	public WorkInjuryVO querySumWorkInjury4(String aac001);
	/**
	 * 生育待遇明细查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryBornTreatment(Page page,String aac001);
	public BornInfoVO querySumBornTreatment(String aac001);
	/**
	 * 生育诊疗费查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryBornMedicalFee(Page page,String aac001);
	public BornInfoVO querySumBornMedicalFee(String aac001);
	/**
	 * 男职工补助金查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryMaleAllowance(Page page,String aac001);
	public BornInfoVO querySumMaleAllowance(String aac001);
	public RetireResignQueryVO queryTxtzTdDetails(RetireResignQueryVO retireResignQueryVO);
	 /**
	  * 月基本养老待遇 
	  * @param retireResignQueryVO
	  * @return
	  */
	 public List<PensionVO> getPensionList(RetireResignQueryVO retireResignQueryVO);
	 /**
	  * 月基本养老外待遇
	  * @param retireResignQueryVO
	  * @return
	  */
	 public List<PensionVO> getExcPensionList(RetireResignQueryVO retireResignQueryVO);
}
