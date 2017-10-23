package com.wb.qdyth.f1001.common.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wb.exceptions.BusinessException;
import com.wb.jdbcutils.CommonJdbcUtils;
import com.wb.jdbcutils.Page;
import com.wb.qdyth.common.bo.NetData;
import com.wb.qdyth.common.bo.NetDataMain;
import com.wb.qdyth.common.service.CommonService;
import com.wb.qdyth.f1001.common.vo.BornInfoVO;
import com.wb.qdyth.f1001.common.vo.MedicalInfoVO;
import com.wb.qdyth.f1001.common.vo.PaymentVO;
import com.wb.qdyth.f1001.common.vo.PensionInfoVO;
import com.wb.qdyth.f1001.common.vo.Person_qy;
import com.wb.qdyth.f1001.common.vo.PrintDataList;
import com.wb.qdyth.f1001.common.vo.PrintDataMain;
import com.wb.qdyth.f1001.common.vo.Psorder;
import com.wb.qdyth.f1001.common.vo.RetireInfoDTO;
import com.wb.qdyth.f1001.common.vo.ReturnPrintVO;
import com.wb.qdyth.f1001.common.vo.UserVO;
import com.wb.qdyth.f1001.common.vo.WorkInjuryVO;
import com.wb.user.utils.BusinessContextUtils;
import com.wb.utils.web.common.DateTools;
import com.wb.utils.web.common.NumberTools;
import com.wb.utils.web.common.RmbUtil;




/**
 * 个人自助打印
 * @author xue
 * 2015-11-10
 */
public interface PrintService {
	public ReturnPrintVO execGetPrintInfo(String aac001, String ptype);
	
	/**
	 * 获取个人权益信息
	 * @param aac001
	 * @param ptype
	 * @return
	 * data300 如果等于2，说明是机关事业，则不需要再查询，直接显示“机关事业参保人员，请到业务窗口核实个人权益单”；
	 */
	public ReturnPrintVO getPsnInsureInfo(String aac001, String ptype);
	/**
	 * 获取养老参保凭证
	 * @param aac001
	 * @param ptype
	 * @return
	 */
	public ReturnPrintVO getPsn110Cert(String aac001, String ptype);
	/**
	 * 获取医疗参保凭证
	 * @param aac001
	 * @param ptype
	 * @return
	 */
	public ReturnPrintVO getPsn310Cert(String aac001, String ptype);
	/**
	 * 社会保险参保证明
	 * @param aac001
	 * @param ptype
	 * @return
	 */
	public ReturnPrintVO getPsnInsureCertify(String aac001, String ptype);
	/**
	 * 个人累积参保缴费证明
	 * @param aac001
	 * @param ptype
	 * @return
	 */
	public ReturnPrintVO getPsnInsureCertifyPrint_lj(String aac001, String ptype);
	/**
	 * 基本养老保障关系接续单
	 * @param aac001
	 * @param ptype
	 * @return
	 */
	public ReturnPrintVO getPsn110InsureCertify(String aac001, String ptype);
	public ReturnPrintVO getPsnRetireInfo(String aac001, String ptype);
	public String getAa10DataById(String aaa100,String aaa102);
	/**
	 * 根据单号查询
	 * @param id
	 * @return
	 */
	public ReturnPrintVO getInfoById(String id);
	public ReturnPrintVO getPsnRetireList(String aac001, String ptype);
	/*public String getYear(String aac001){
		
		String sql="select * from qdyth.ic09@qdweb_jx where aac001=?";
		RetireInfoDTO ic09Data=CommonJdbcUtils.queryFirst(sql,RetireInfoDTO.class , aac001);
		if(ic09Data.getAic162()<20060101){
			
			return 
		}
	}*/
	public String savePsorder(String aac001,Integer aae001,String aae005,String aae006,String aae007);
	
	public ReturnPrintVO getReturnPrintVOById(String id,String sql);
	public Psorder getPsorderByAac001Aae001(String aac001,Integer aae001);
}
