package com.wb.qdyth.f1001.common.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.wb.jdbcutils.CommonJdbcUtils;
import com.wb.qdyth.common.bo.NetDataMain;
import com.wb.qdyth.common.service.CommonService;
import com.wb.qdyth.f1001.common.vo.CertPrintSPDTO;
import com.wb.qdyth.f1001.common.vo.Person_qy;
import com.wb.qdyth.f1001.common.vo.PrintDataList;
import com.wb.qdyth.f1001.common.vo.PrintDataMain;
import com.wb.qdyth.f1001.common.vo.Psorder;
import com.wb.qdyth.f1001.common.vo.RetireInfoDTO;
import com.wb.qdyth.f1001.common.vo.ReturnPrintVO;
import com.wb.utils.web.common.DateTools;
import com.wb.utils.web.common.NumberTools;
import com.wb.utils.web.common.RmbUtil;




/**
 * 个人自助打印
 * @author xue
 * 2015-11-10
 */
public class PrintServiceImpl implements PrintService{
	private CommonService commonService;
	public ReturnPrintVO execGetPrintInfo(String aac001, String ptype) {
		ReturnPrintVO vo=null;
		if("pa1".equals(ptype)){//个人权益
			vo= getPsnInsureInfo(aac001,ptype);
		}else if("pb1".equals(ptype)){//养老参保凭证
			vo= getPsn110Cert(aac001,ptype);
		}else if("pc1".equals(ptype)){//医疗参保凭证
			vo= getPsn310Cert(aac001,ptype);
		}else if("pd2".equals(ptype)){//社会保险参保证明
			vo= getPsnInsureCertify(aac001,ptype);
		}else if("pe2".equals(ptype)){//养老保险接续单
			vo= getPsn110InsureCertify(aac001,ptype);
		}else if("pc2".equals(ptype)){
			vo= getPsnRetireInfo(aac001,ptype);
		}else if("pf2".equals(ptype)){//累积缴费证明
			vo= getPsnInsureCertifyPrint_lj(aac001,ptype);
		}
		return vo;
	}
	
	/**
	 * 获取个人权益信息
	 * @param aac001
	 * @param ptype
	 * @return
	 * data300 如果等于2，说明是机关事业，则不需要再查询，直接显示“机关事业参保人员，请到业务窗口核实个人权益单”；
	 */
	public ReturnPrintVO getPsnInsureInfo(String aac001, String ptype){
		ReturnPrintVO vo=null;
		
		String sql_cab016 = " select cab016 data01 from qdyth.ac0d@qdweb_jx where aac001=? ";
		NetDataMain data_cab016 = CommonJdbcUtils.queryFirst(sql_cab016, NetDataMain.class, aac001);
		
		if(data_cab016 != null && "2".equalsIgnoreCase(data_cab016.getData01())){
			vo = new ReturnPrintVO();
			vo.setData300("2");
			return vo;
		}
		
		String idcode=VerifyUtils.getVerifyCode(ptype, aac001);//同一天的同一个人的校验码是一样的
		vo=getInfoById(idcode);
		if(vo!=null){
			return vo;
		}
		vo=new ReturnPrintVO();
		/**
		 * 查询个人权益信息
		 */
		
		String sql="select * from (select * from qdyth.person_qy@qdweb_jx where aac001=?  ORDER BY aae001 desc) where rownum=1";
		Person_qy qy=CommonJdbcUtils.queryFirst(sql, Person_qy.class, aac001);
		String sqla="select * from qdyth.af01_100@qdweb_jx where aab301=?";
		if(qy!=null&&qy.getAab301()!=null){
			Person_qy qytemp=CommonJdbcUtils.queryFirst(sqla, Person_qy.class, qy.getAab301());
			if(qytemp!=null&&!"370299".equals(qy.getAab301())){
				qy.setAab069(qytemp.getAab069());
				qy.setAae005(qytemp.getAae005());
				qy.setAae006(qytemp.getAae006());
			}
			if(qytemp!=null&&"370299".equals(qy.getAab301())){
				qy.setAab069(qytemp.getAab069());
				qy.setAae006(qytemp.getAae006());
				String sqls="select * from qdyth.ab01@qdweb_jx where aab001=?";
				Person_qy person=CommonJdbcUtils.queryFirst(sqls, Person_qy.class, qy.getAab001());
				if(person!=null){				
				if(person.getCab016().equals("2")){
					qy.setAae005("86010725");
				}
				else{
					qy.setAae005("66773820");
				}
				
				
				}
				
			}
				
		}else{
			qy = new Person_qy();
		}
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMdd");
		qy.setYear(Integer.parseInt(df.format(date).substring(0,4)));
		qy.setMonth(Integer.parseInt(df.format(date).substring(4,6)));
		qy.setDay(Integer.parseInt(df.format(date).substring(6,8)));
		/**
		 * 记录个人权益信息
		 */
		PrintDataMain pdm=new PrintDataMain();
		pdm.setId(idcode);
		pdm.setType(ptype);
		pdm.setAae001(aac001);
		pdm.setAae036(new Date());
		pdm.setData01(qy.getQyid().toString())	;//number(16)			记录主键
		pdm.setData02(qy.getA000())	;//varchar2(4)	y		权益类型
		pdm.setData03(qy.getAae001()==null?"":qy.getAae001().toString());//	number(4)	y		年度
		pdm.setData04(qy.getAac001()==null?"":qy.getAac001().toString());//	number(16)	y		人员编号
		pdm.setData05(qy.getAae006());//	varchar2(100)	y		通讯地址
		pdm.setData06(qy.getAab001());//	varchar2(10)	y		单位管理码
		pdm.setData07(qy.getAae007());//	varchar2(6)	y		邮政编码
		pdm.setData08(qy.getAab004());//	varchar2(100)	y		单位名称
		pdm.setData09(qy.getAab301());//	varchar2(6)	y		行政区划
		pdm.setData10(qy.getAac002());//	varchar2(18)	y		社会保障号码
		pdm.setData11(qy.getAac003());//	varchar2(50)	y		姓名
		pdm.setData12(qy.getA001()==null||qy.getA001()==0?"--":qy.getA001().toString())	;//number(8)	y		养老首次参保
		pdm.setData13(qy.getA002()==null||qy.getA002()==0?"--":qy.getA002().toString())	;//number(8)	y		医疗首次参保
		pdm.setData14(qy.getA003()==null||qy.getA003()==0?"--":qy.getA003().toString())	;//number(8)	y		失业首次参保
		pdm.setData15(qy.getA004()==null||qy.getA004()==0?"--":qy.getA004().toString())	;//number(8)	y		工伤首次参保
		pdm.setData16(qy.getA005()==null||qy.getA005()==0?"--":qy.getA005().toString())	;//number(8)	y		生育首次参保
		pdm.setData17(qy.getA006()==null||qy.getA006()==0?"--":qy.getA006().toString())	;//number(16,2)	y		养老月缴费基数
		pdm.setData18(qy.getA007()==null||qy.getA007()==0?"--":qy.getA007().toString())	;//number(16,2)	y		医疗月缴费基数
		pdm.setData19(qy.getA008()==null||qy.getA008()==0?"--":qy.getA008().toString())	;//number(16,2)	y		失业月缴费基数
		pdm.setData20(qy.getA009()==null||qy.getA009()==0?"--":qy.getA009().toString())	;//number(16,2)	y		工伤月缴费基数
		pdm.setData21(qy.getA010()==null||qy.getA010()==0?"--":qy.getA010().toString())	;//number(16,2)	y		生育月缴费基数
		pdm.setData22(qy.getA011()==null||qy.getA011()==0?"--":qy.getA011().toString())	;//number(16,2)	y		养老单位缴费
		pdm.setData23(qy.getA012()==null||qy.getA012()==0?"--":qy.getA012().toString())	;//number(16,2)	y		养老个人缴费
		pdm.setData24(qy.getA013()==null||qy.getA013()==0?"--":qy.getA013().toString())	;//number(16,2)	y		医疗单位缴费
		pdm.setData25(qy.getA014()==null||qy.getA014()==0?"--":qy.getA014().toString())	;//number(16,2)	y		医疗个人缴费
		pdm.setData26(qy.getA015()==null||qy.getA015()==0?"--":qy.getA015().toString())	;//number(16,2)	y		失业单位缴费
		pdm.setData27(qy.getA016()==null||qy.getA016()==0?"--":qy.getA016().toString())	;//number(16,2)	y		失业个人缴费
		pdm.setData28(qy.getA017()==null||qy.getA017()==0?"--":qy.getA017().toString())	;//number(16,2)	y		工伤缴费
		pdm.setData29(qy.getA018()==null||qy.getA018()==0?"--":qy.getA018().toString())	;//number(16,2)	y		生育缴费
		pdm.setData30(qy.getA019()==null||qy.getA019()==0?"--":qy.getA019().toString())	;//number(16,2)	y		养老个人补缴欠费
		pdm.setData31(qy.getA020()==null||qy.getA020()==0?"--":qy.getA020().toString())	;//number(16,2)	y		医疗个人补缴欠费
		pdm.setData32(qy.getA021()==null||qy.getA021()==0?"--":qy.getA021().toString())	;//number(16,2)	y		失业个人补缴欠费
		pdm.setData33(qy.getA022()==null||qy.getA022()==0?"--":qy.getA022().toString())	;//number(16,2)	y		养老补历史月数
		pdm.setData34(qy.getA023()==null||qy.getA023()==0?"--":qy.getA023().toString())	;//number(16,2)	y		医疗补历史月数
		pdm.setData35(qy.getA024()==null||qy.getA024()==0?"--":qy.getA024().toString())	;//number(16,2)	y		失业补历史月数
		pdm.setData36(qy.getA025()==null||qy.getA025()==0?"--":qy.getA025().toString())	;//number(16,2)	y		养老截止本年末月数
		pdm.setData37(qy.getA026()==null||qy.getA026()==0?"--":qy.getA026().toString())	;//number(16,2)	y		医疗截止本年末月数
		pdm.setData38(qy.getA027()==null||qy.getA027()==0?"--":qy.getA027().toString())	;//number(16,2)	y		失业截止本年末月数
		pdm.setData39(qy.getA028()==null||qy.getA028()==0?"--":qy.getA028().toString())	;//number(16,2)	y		养老累计欠费月数
		pdm.setData40(qy.getA029()==null||qy.getA029()==0?"--":qy.getA029().toString())	;//number(16,2)	y		医疗累计欠费月数
		pdm.setData41(qy.getA030()==null||qy.getA030()==0?"--":qy.getA030().toString())	;//number(16,2)	y		失业累计欠费月数
		pdm.setData42(qy.getA031()==null||qy.getA031()==0?"--":qy.getA031().toString())	;//number(16,2)	y		养老截止上年末个人帐户累计
		pdm.setData43(qy.getA032()==null||qy.getA032()==0?"--":qy.getA032().toString())	;//number(16,2)	y		养老当年记账金额
		pdm.setData44(qy.getA033()==null||qy.getA033()==0?"--":qy.getA033().toString())	;//number(16,2)	y		养老截止上年末个人帐户累计在本年利息
		pdm.setData45(qy.getA034()==null||qy.getA034()==0?"--":qy.getA034().toString())	;//number(16,2)	y		养老当年记账利息
		pdm.setData46(qy.getA035()==null||qy.getA035()==0?"--":qy.getA035().toString())	;//number(16,2)	y		养老至本年末个人帐户存储额
		pdm.setData47(qy.getA036()==null||qy.getA036()==0?"--":qy.getA036().toString())	;//number(16,2)	y		医疗截止上年末个人帐户累计
		pdm.setData48(qy.getA037()==null||qy.getA037()==0?"--":qy.getA037().toString())	;//number(16,2)	y		医疗当年记账金额
		pdm.setData49(qy.getA038()==null||qy.getA038()==0?"--":qy.getA038().toString())	;//number(16,2)	y		医疗当年支出金额
		pdm.setData50(qy.getA039()==null||qy.getA039()==0?"--":qy.getA039().toString())	;//number(16,2)	y		医疗当年记账利息
		pdm.setData51(qy.getA040()==null||qy.getA040()==0?"--":qy.getA040().toString())	;//number(16,2)	y		医疗至本年末个人帐户存储额
		pdm.setData52(qy.getA041()==null||qy.getA041()==0?"--":qy.getA041().toString())	;//number(16,2)	y		"医疗费发生总额"
		pdm.setData53(qy.getA042()==null||qy.getA042()==0?"--":qy.getA042().toString())	;//number(16,2)	y		"基本医疗保险统筹金支付额"
		pdm.setData54(qy.getA043()==null||qy.getA043()==0?"--":qy.getA043().toString())	;//number(16,2)	y		"大额医疗补助金支付额"
		pdm.setData55(qy.getA044()==null||qy.getA044()==0?"--":qy.getA044().toString())	;//number(16,2)	y		"特殊人员医疗补助金支付额"
		pdm.setData56(qy.getA045()==null||qy.getA045()==0?"--":qy.getA045().toString())	;//number(16,2)	y		"医保大病医疗救助额"
		pdm.setData57(qy.getA046()==null||qy.getA046()==0?"--":qy.getA046().toString())	;//number(16,2)	y		"民政医疗救助额"
		pdm.setData65(qy.getA047()==null||qy.getA047()==0?"--":qy.getA047().toString())	;//number(16,2)	y		"个人实际负担额"
		pdm.setData66(qy.getA048()==null||qy.getA048()==0?"--":qy.getA048().toString())	;//number(16,2)	y		"一次性伤残补助金级别"
		pdm.setData67(qy.getA049()==null||qy.getA049()==0?"--":qy.getA049().toString())	;//number(16,2)	y		"一次性伤残补助金金额"
		pdm.setData68(qy.getA050()==null||qy.getA050()==0?"--":qy.getA050().toString())	;//number(16,2)	y		"1-4级伤残津贴  级别"
		pdm.setData69(qy.getA051()==null||qy.getA051()==0?"--":qy.getA051().toString())	;//number(16,2)	y		"1-4级伤残津贴  月标准"
		pdm.setData70(qy.getA052()==null||qy.getA052()==0?"--":qy.getA052().toString())	;//number(16,2)	y		"1-4级伤残护理费"
		pdm.setData71(qy.getA053()==null||qy.getA053()==0?"--":qy.getA053().toString())	;//number(16,2)	y		"一次性医疗补助金级别"
		pdm.setData72(qy.getA054()==null||qy.getA054()==0?"--":qy.getA054().toString())	;//number(16,2)	y		"一次性医疗补助金金额"
		pdm.setData73(qy.getA055()==null||qy.getA055()==0?"--":qy.getA055().toString())	;//number(16,2)	y		"生育医疗费用由生育保险基金支付金额"
		pdm.setData74(qy.getA056()==null||qy.getA056()==0?"--":qy.getA056().toString())	;//number(16,2)	y		"享受生育津贴月标准"
		pdm.setData75(qy.getA057()==null||qy.getA057()==0?"--":qy.getA057().toString())	;//number(16,2)	y		"享受生育津贴月数"
		pdm.setData76(qy.getA058()==null||qy.getA058()==0?"--":qy.getA058().toString())	;//number(16,2)	y		生育津贴发放天数
		pdm.setData77(qy.getA059()==null||qy.getA059()==0?"--":qy.getA059().toString())	;//number(16,2)	y		生育津贴发放金额
		pdm.setData78(qy.getA060()==null||qy.getA060()==0?"--":qy.getA060().toString())	;//number(16,2)	y		男职工补助金
		pdm.setData79(qy.getA061()==null||qy.getA061()==0?"--":qy.getA061().toString())	;//number(16,2)	y		视同缴费月数
		pdm.setData58(qy.getXh()==null?"--":qy.getXh().toString())	;//mbnuer	y		
		pdm.setData59(qy.getAab069());
		pdm.setData60(qy.getAae005());
		pdm.setData61(qy.getAae006());
		pdm.setData62(qy.getYear().toString());
		pdm.setData63(qy.getMonth().toString());
		pdm.setData64(qy.getDay().toString());
		CommonJdbcUtils.save(pdm);
		BeanUtils.copyProperties(pdm, vo);
		return vo;
	}
	/**
	 * 获取养老参保凭证
	 * @param aac001
	 * @param ptype
	 * @return
	 */
	public ReturnPrintVO getPsn110Cert(String aac001, String ptype){
		ReturnPrintVO vo=null;
		String idcode=VerifyUtils.getVerifyCode(ptype, aac001);//同一天的同一个人的校验码是一样的
		vo=getInfoById(idcode);
		if(vo!=null){
			return vo;
		}else{
			CertPrintSPDTO dto=new CertPrintSPDTO();
			dto.setAac001(Long.valueOf(aac001));
			dto.setId(idcode);
			dto.setType("1");
			CommonJdbcUtils.call("SPK_A2_WWCX.sp_a2_110310certifyprint",dto);
			if(dto.getRetcode()!=0){
				vo=new ReturnPrintVO();
				vo.setError(dto.getRetmsg());
			}else{
				vo=getInfoById(idcode);
			}
		}
		return vo;
	}
	/**
	 * 获取医疗参保凭证
	 * @param aac001
	 * @param ptype
	 * @return
	 */
	public ReturnPrintVO getPsn310Cert(String aac001, String ptype){
		ReturnPrintVO vo=null;
		String idcode=VerifyUtils.getVerifyCode(ptype, aac001);//同一天的同一个人的校验码是一样的
		vo=getInfoById(idcode);
		if(vo!=null){
			return vo;
		}else{
			CertPrintSPDTO dto=new CertPrintSPDTO();
			dto.setAac001(Long.valueOf(aac001));
			dto.setId(idcode);
			dto.setType("2");
			CommonJdbcUtils.call("SPK_A2_WWCX.sp_a2_110310certifyprint",dto);
			if(dto.getRetcode()!=0){
				vo=new ReturnPrintVO();
				vo.setError(dto.getRetmsg());
			}else{
				vo=getInfoById(idcode);
			}
		}
		return vo;
	}
	/**
	 * 社会保险参保证明
	 * @param aac001
	 * @param ptype
	 * @return
	 */
	public ReturnPrintVO getPsnInsureCertify(String aac001, String ptype){
		ReturnPrintVO vo=null;
		String idcode=VerifyUtils.getVerifyCode(ptype, aac001);//同一天的同一个人的校验码是一样的
		vo=getInfoById(idcode);
		if(vo!=null){
			return vo;
		}else{
			CertPrintSPDTO dto=new CertPrintSPDTO();
			dto.setAac001(Long.valueOf(aac001));
			dto.setId(idcode);
			CommonJdbcUtils.call("SPK_A2_WWCX.SP_A2_INSURECERTIFYPRINT",dto);
			if(dto.getRetcode()!=0){
				vo=new ReturnPrintVO();
				vo.setError(dto.getRetmsg());
			}else{
				vo=getInfoById(idcode);
			}
			if(vo==null)vo=new ReturnPrintVO();
		}
		return vo;
	}
	/**
	 * 个人累积参保缴费证明
	 * @param aac001
	 * @param ptype
	 * @return
	 */
	public ReturnPrintVO getPsnInsureCertifyPrint_lj(String aac001, String ptype){
		ReturnPrintVO vo=null;
		String idcode=VerifyUtils.getVerifyCode(ptype, aac001);//同一天的同一个人的校验码是一样的
		vo=getInfoById(idcode);
		if(vo!=null){
			return vo;
		}else{
			CertPrintSPDTO dto=new CertPrintSPDTO();
			dto.setAac001(Long.valueOf(aac001));
			dto.setId(idcode);
			//dto.setType("3");
			CommonJdbcUtils.call("SPK_A2_WWCX.SP_A2_INSURECERTIFYPRINT_LJ", dto);
			if(dto.getRetcode()!=0){
				vo=new ReturnPrintVO();
				vo.setError(dto.getRetmsg());
			}else{
				vo=getInfoById(idcode);
			}
			if(vo==null)vo=new ReturnPrintVO();
		}
		return vo;
	}
	/**
	 * 基本养老保障关系接续单
	 * @param aac001
	 * @param ptype
	 * @return
	 */
	public ReturnPrintVO getPsn110InsureCertify(String aac001, String ptype){
		ReturnPrintVO vo=null;
		String idcode=VerifyUtils.getVerifyCode(ptype, aac001);//同一天的同一个人的校验码是一样的
		vo=getInfoById(idcode);
		if(vo!=null){
			return vo;
		}else{
			/*CertPrintSPDTO dto=new CertPrintSPDTO();
			dto.setAac001(Long.valueOf(aac001));
			dto.setId(idcode);
			dto.setType(ptype);
			CommonJdbcUtils.execute("SPK_A2_WWCX.sp_a2_110jiexudan", dto);
			if(dto.getRetcode()!=0){
				vo=new ReturnPrintVO();
				vo.setError(dto.getRetmsg());
			}else{
				vo=getInfoById(idcode);
			}
			if(vo==null)vo=new ReturnPrintVO();*/
		}
		return vo;
	}
	public ReturnPrintVO getPsnRetireInfo(String aac001, String ptype){
		ReturnPrintVO vo=null;
		String idcode=VerifyUtils.getVerifyCode(ptype, aac001);//同一天的同一个人的校验码是一样的
		vo=getInfoById(idcode);
		if(vo!=null){
			return vo;
		}
		vo=new ReturnPrintVO();
		/**
		 * 查询个人信息
		 */
		
		RetireInfoDTO dataInfo = new RetireInfoDTO();
		String sql="select * from (select * from qdyth.ac01@qdweb_jx where aac001=?  ORDER BY aac001 desc) where rownum=1";
		RetireInfoDTO ac01Data=CommonJdbcUtils.queryFirst(sql, RetireInfoDTO.class, aac001);
		/*if(ac01Data==null){
			throw new BusinessException();
		}*/
		BeanUtils.copyProperties(ac01Data, dataInfo,
				new String[] { "aac006,aac007,cac001,aae005,aae006" });
		if(ac01Data.getAac004()!=null){
			String aac004=getAa10DataById("AAC004",ac01Data.getAac004());
			dataInfo.setAac004(aac004);
		}
		if(ac01Data.getAac005()!=null){
			String aac005=getAa10DataById("AAC005",ac01Data.getAac005());
			dataInfo.setAac005(aac005);
		}
		if (ac01Data.getAac006() != null) {// 出生日期转换
			Date d = DateTools.parseDate(ac01Data.getAac006().toString(),
					"yyyyMMdd");
			SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
			dataInfo.setAac006String(sf.format(d));
		}
		if (ac01Data.getAac007() != null) {// 参加工作时间
			Date d = DateTools.parseDate(ac01Data.getAac007().toString(),
					"yyyyMMdd");
			SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
			dataInfo.setAac007String(sf.format(d));
		}
		if (ac01Data.getCac001() != null&&ac01Data.getCac001()>0) {// 档案出生时间
			Date d = DateTools.parseDate(ac01Data.getCac001().toString(),
					"yyyyMMdd");
			SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
			dataInfo.setCac001String(sf.format(d));
		}
//		String sqlAc20="select * from qdyth.ac20@"
		List<RetireInfoDTO> ac20List = CommonJdbcUtils.query(
				"select * from qdyth.ac20@qdweb_jx where aae140 in ('110','120') and cae265='1' and aac001=?",RetireInfoDTO.class,
				aac001);
		if (ac20List == null || ac20List.isEmpty()) {
			ac20List = CommonJdbcUtils
			.query(
					"select * from qdyth.ac20@qdweb_jx where aae140='310' and cae265='1' and aac001=?",RetireInfoDTO.class,
					aac001);
			if (ac20List == null || ac20List.isEmpty()) {
				ac20List = CommonJdbcUtils
				.query(
						"select * from qdyth.ac20@qdweb_jx where aae140 in ('410','510') and cae265='1' and aac001=?",RetireInfoDTO.class,
						aac001);
			}
		}
		if (ac20List != null && !ac20List.isEmpty()) {
			RetireInfoDTO ac20 = ac20List.get(0);
			String sql1="select * from qdyth.ab01@qdweb_jx where aab001=?";
			RetireInfoDTO ab01Data = CommonJdbcUtils.queryFirst(sql1,RetireInfoDTO.class, ac20
					.getAab001());
			String sql2="select * from qdyth.ae10@qdweb_jx where aaz001=?";
			RetireInfoDTO ae10Data = CommonJdbcUtils.queryFirst(sql2,RetireInfoDTO.class, ab01Data
					.getAaz001());
			if(ae10Data.getAab020()!=null){
				String aab020=getAa10DataById("AAB020",ae10Data.getAab020());
				dataInfo.setAab020(aab020);
			}
			dataInfo.setAab001(ab01Data.getAab001());
			dataInfo.setAab004(ab01Data.getAab004());
			if(ac20.getAab301()!=null){
				String aab301=getAa10DataById("AAB301",ac20.getAab301());
				dataInfo.setAab301(aab301);
				dataInfo.setAab301a(ac20.getAab301());
			}
			

		}
		String sql3 = "select a.*,b.aaf031,c.aac160 from qdyth.IC09@qdweb_jx A,qdyth.af08@qdweb_jx B,qdyth.ac71@qdweb_jx C where a.caz071=b.caz071(+)" +
		" and a.aaz170=c.aaz170  and a.aac001=? ORDER BY A.AAZ170 DESC ";
		RetireInfoDTO ic09Data=CommonJdbcUtils.queryFirst(sql3, RetireInfoDTO.class, aac001);
		vo.setError("您未做过养老待遇核定，请确认！");
		vo.setData58("nullerror");
		if(ic09Data==null) return vo;
		if (ic09Data.getAic162() != null) {// 离退休日期
			Date d = DateTools.parseDate((ic09Data.getAic162()).toString(),
					"yyyyMMdd");
			SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月");
			dataInfo.setAic162String(sf.format(d));
			if(ic09Data.getCae527()!=null && "1".equals(ic09Data.getCae527())){
				dataInfo.setYearTime("temp");
			}else{
				if(ic09Data.getAic162()<20060101){
					dataInfo.setYearTime("before2006");
				}else if(ic09Data.getAic162()>=20060101 && ic09Data.getAic162()<=20101231){
					dataInfo.setYearTime("2006to2010");
				}else if(ic09Data.getAic162()>=20110101 && ic09Data.getAic162()<=20131231){
					dataInfo.setYearTime("2011to2013");
				}else if(ic09Data.getAic162()>=20140101){
					dataInfo.setYearTime("after2014");
				}
			}
		}
		if (ic09Data.getAac160() != null) {// 纳入统筹时间转换
			Date d = DateTools.parseDate((ic09Data.getAac160()).toString(),
					"yyyyMM");
			SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月");
			dataInfo.setAac160String(sf.format(d));
		}
		dataInfo.setAaf031(ic09Data.getAaf031());
		String aaa103=getAa10DataById("AAC082",ic09Data.getAac082());
		dataInfo.setAac082(aaa103);
		dataInfo.setCie002(ic09Data.getCie002()==null?BigDecimal.ZERO:ic09Data.getCie002());
		if(ic09Data.getAic001()==null){
			ic09Data.setAic001(0);
		}
		if(ic09Data.getAic090()==null){
			ic09Data.setAic090(0);
		}
		if(ic09Data.getCae200()==null){
			ic09Data.setCae200(0);
		}
		Integer workAge1 = ic09Data.getAic001() + ic09Data.getAic090()
		+ ic09Data.getCae200();
		Double workAge = workAge1.doubleValue() / 12;
		DecimalFormat df = new DecimalFormat("#.##");
		dataInfo.setWorkAge(df.format(workAge));
		String m = "";
		Double cae200 = NumberTools.round((ic09Data.getCae200()+ic09Data.getAic001()) / 12.0, 2);
		dataInfo.setCae200YearDouble(df.format(cae200));
		int qq = (cae200+"").indexOf(".");
		if((cae200+"").length()<=2)
			m = cae200+"年";
		else
		{
			String x = (cae200+"").substring(0,qq);
			String y = (cae200+"").substring(qq+1,(cae200+"").length());
			if(y.length()==1)
				y = y+"0";
			int b = ((NumberTools.multiply(new BigDecimal(y),new BigDecimal("12"))).divide(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();
			m = x+"年"+b+"个月";
		}
		dataInfo.setCae200Year(m);
		// 帐后年限
		Double aic090 = NumberTools.round(ic09Data.getAic090() / 12.0, 2);
		dataInfo.setAic090YearDouble(df.format(aic090));
		qq = (aic090+"").indexOf(".");
		if((aic090+"").length()<=2)
			m = aic090+"年";
		else
		{
			String x = (aic090+"").substring(0,qq);
			String y = (aic090+"").substring(qq+1,(aic090+"").length());
			if(y.length()==1)
				y = y+"0";
			int b = ((NumberTools.multiply(new BigDecimal(y),new BigDecimal("12"))).divide(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();
			m = x+"年"+b+"个月";
		}
		dataInfo.setAic090Year(m);
		// 合计年限
		dataInfo.setSumYearDouble(df.format(NumberTools.round((ic09Data.getCae200()+ic09Data.getAic001()+ic09Data.getAic090()) / 12.0, 2)));
		Double sumYear = NumberTools.round(cae200+aic090, 2);
		qq = (sumYear+"").indexOf(".");
		if((sumYear+"").length()<=2)
			m = sumYear+"年";
		else
		{
			String x = (sumYear+"").substring(0,qq);
			String y = (sumYear+"").substring(qq+1,(sumYear+"").length());
			if(y.length()==1)
				y = y+"0";
			int b = ((NumberTools.multiply(new BigDecimal(y),new BigDecimal("12"))).divide(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();
			m = x+"年"+b+"个月";
		}
		dataInfo.setSumYear(m);
		dataInfo.setStartToEnd(ic09Data.getCic023() + "-" + ic09Data.getCic024());
		// 工龄补贴
		double sumyear = Double.parseDouble(dataInfo.getSumYearDouble());
		if(sumyear>(int)sumyear)
			dataInfo.setWorkAgeBuTie(((int) (Double.parseDouble(dataInfo.getSumYearDouble())) + 1)+"");
		else
			dataInfo.setWorkAgeBuTie(((int) (Double.parseDouble(dataInfo.getSumYearDouble())))+"");
		// 计发比例：缴费满15年为20%，满10年不满15年为15%
		if (Double.parseDouble(dataInfo.getSumYearDouble()) > 15) {
			dataInfo.setJiFaBiLi("20%");
		} else {
			dataInfo.setJiFaBiLi("15%");
		}
		dataInfo.setCae040(ic09Data.getCae040());
		dataInfo.setAic164(ic09Data.getAic164());
		dataInfo.setAic165(ic09Data.getAic165());
		dataInfo.setAac026(new BigDecimal(ic09Data.getAac026().intValue()+""));
		// 每月核发养老金总额
		dataInfo.setCic016(ic09Data.getCic016());
		String sqlAc74="select b.* from qdyth.ac71@qdweb_jx a,qdyth.ac74@qdweb_jx b"+
					   " where a.aaz097=b.aaz097 and a.aaz170=?";
		RetireInfoDTO ac74Data = CommonJdbcUtils.queryFirst(sqlAc74, RetireInfoDTO.class, ic09Data.getAaz170());
		dataInfo.setAaz065(ac74Data.getAaz065());
		dataInfo.setAae010(ac74Data.getAae010());
		String sqlAa02="select * from qdyth.aa02@qdweb_jx where aae001=2005 and cab016='1' and aab301=?";
		/*RetireInfoDTO aa02Data=CommonJdbcUtils.queryFirst(sqlAa02, RetireInfoDTO.class,dataInfo.getAab301a());
		if(aa02Data != null){
			aaa015
		}*/
		BigDecimal aaa015=CommonJdbcUtils.queryFirst(sqlAa02, RetireInfoDTO.class,dataInfo.getAab301a()).getAaa015();
		dataInfo.setAaa015(NumberTools.divide(aaa015, new BigDecimal("12")).setScale(0, BigDecimal.ROUND_HALF_UP));
		
		// 查询AC73取待遇项目明细
		String sqlAc73="select * from qdyth.ac73@qdweb_jx where aaz170=?";
		List<RetireInfoDTO> ac73List = CommonJdbcUtils.query(sqlAc73, RetireInfoDTO.class, ic09Data.getAaz170());
		dataInfo.setBasicPensionOld(BigDecimal.ZERO);
		dataInfo.setBasicPension(BigDecimal.ZERO);
		dataInfo.setGzPensionOld(BigDecimal.ZERO);
		dataInfo.setGzPension(BigDecimal.ZERO);
		dataInfo.setGuoDuPensionOld(BigDecimal.ZERO);
		dataInfo.setGuoDuPension(BigDecimal.ZERO);
		dataInfo.setAdjustJinEOld(BigDecimal.ZERO);
		dataInfo.setAdjustJinE(BigDecimal.ZERO);
		dataInfo.setGuoDuBuTie(BigDecimal.ZERO);
		dataInfo.setCityButie(BigDecimal.ZERO);
		dataInfo.setElecBuTie(BigDecimal.ZERO);
		dataInfo.setHouseButie(BigDecimal.ZERO);
		dataInfo.setLifeButie(BigDecimal.ZERO);
		dataInfo.setWaterBuTie(BigDecimal.ZERO);
		dataInfo.setTiqiantuixiuchae(BigDecimal.ZERO);
		dataInfo.setAdjustJinEXs(BigDecimal.ZERO);
		for (RetireInfoDTO ac73dto : ac73List) {
			if ("I00001".equals(ac73dto.getAaa036())) {
				// //基础养老金
				if ("20".equals(ac73dto.getCae035()))// 老算法
					dataInfo.setBasicPensionOld(ac73dto.getAae129());
					
				else
					dataInfo.setBasicPension(ac73dto.getAae129());
			}
			if ("I00003".equals(ac73dto.getAaa036())) {
				// 个人账户养老金
				if ("20".equals(ac73dto.getCae035()))// 老算法
				{
					dataInfo.setGzPensionOld(ac73dto.getAae129());
					dataInfo.setJiFaXiShuOld(ac73dto.getAla043().toString());
				} else {
					dataInfo.setGzPension(ac73dto.getAae129());
					dataInfo.setJiFaXiShu(ac73dto.getAla043().toString());
				}
			}
			if ("I00002".equals(ac73dto.getAaa036())) {
				// 过渡性养老金
				if ("20".equals(ac73dto.getCae035()))// 老算法
					dataInfo.setGuoDuPensionOld(ac73dto.getAae129());
				else
					dataInfo.setGuoDuPension(ac73dto.getAae129());
			}
			if ("I00004".equals(ac73dto.getAaa036())) {
				// 过渡性调节金
				if ("20".equals(ac73dto.getCae035()))// 老算法
					dataInfo.setAdjustJinEOld(ac73dto.getAae129());
				else{
					dataInfo.setAdjustJinE(ac73dto.getAae129());
					dataInfo.setAdjustJinEXs((ac73dto.getAla043()==null?new BigDecimal("10"):(ac73dto.getAla043().multiply(new BigDecimal("100")))).setScale(0));
				}
			}
			if ("I00006".equals(ac73dto.getAaa036())) {
				// 提前退休差额,只有老算法中有
				if ("20".equals(ac73dto.getCae035()))// 老算法
				{
					dataInfo.setTiqiantuixiuchae(ac73dto.getAae129());
					dataInfo.setTiqiantuixiuchaebeizhu(ac73dto.getAae013());
				}
			}
			if ("IT0048".equals(ac73dto.getAaa036())) {
				// 过渡性补贴,只有老算法中有
				if ("20".equals(ac73dto.getCae035()))// 老算法
					dataInfo.setGuoDuBuTie(ac73dto.getAae129());
			}
			if ("IC0022".equals(ac73dto.getAaa036())) {
				// 开放城市补贴
				dataInfo.setCityButie(ac73dto.getAae129());
			}
			if ("IC0025".equals(ac73dto.getAaa036())) {
				// 水价补贴
				dataInfo.setWaterBuTie(ac73dto.getAae129());
			}
			if ("IC0026".equals(ac73dto.getAaa036())) {
				// 电费
				dataInfo.setElecBuTie(ac73dto.getAae129());
			}
			if ("IC0027".equals(ac73dto.getAaa036())) {
				// 物价补贴
				dataInfo.setLifeButie(ac73dto.getAae129());
			}
			if ("IC0029".equals(ac73dto.getAaa036())) {
				// 房屋补贴
				dataInfo.setHouseButie(ac73dto.getAae129());
			}
		}
		
		dataInfo.setCic016Old(dataInfo.getBasicPensionOld()
				.add(dataInfo.getGzPensionOld()).add(dataInfo.getGuoDuPensionOld())
				.add(dataInfo.getAdjustJinEOld()).add(dataInfo.getGuoDuBuTie()).add(dataInfo.getTiqiantuixiuchae()==null?BigDecimal.ZERO:dataInfo.getTiqiantuixiuchae()));
		dataInfo.setCic016New(dataInfo.getBasicPension().add(dataInfo.getGzPension())
				.add(dataInfo.getGuoDuPension()).add(dataInfo.getAdjustJinE()));
		//查询业务日志
		String sqlAe02="select a.* from qdyth.ae02@qdweb_jx a,qdyth.ac71@qdweb_jx b where a.aaz002=b.aaz002 and b.aaz170=?";
		
		RetireInfoDTO ae02dto = CommonJdbcUtils.queryFirst(sqlAe02, RetireInfoDTO.class, ic09Data.getAaz170());
		// 获取当前时间
		Date now = new Date();
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy年MM月dd日");
		dataInfo.setNowDate(sf2.format(now));
		if(ae02dto!=null)
		{
			dataInfo.setCae249(ae02dto.getCae249());
			dataInfo.setCae250(ae02dto.getCae250());
			if(ae02dto.getAae218()!=null && ae02dto.getAae218()>0){
				dataInfo.setAae218(ae02dto.getAae218());
			}else if(ae02dto.getAae217()!=null && ae02dto.getAae217()>0){
				dataInfo.setAae218(ae02dto.getAae217());
			}else{
				dataInfo.setAae218(Integer.parseInt(sf2.format(now)));
			}
			
		}
		if(dataInfo.getCic016New().compareTo(dataInfo.getCic016Old())>0){
			dataInfo.setTishi("若①＜②,取②;");
		}else if(ic09Data.getAic162()>=20110101 && ic09Data.getAic162()<20120101){
			dataInfo.setTishi("若①＞②,取②+（①—②）×80%（退休时间为2011年）;");
		}else if(ic09Data.getAic162()>=20120101 && ic09Data.getAic162()<20130101){
			dataInfo.setTishi("若①＞②,取②+（①—②）×50%（退休时间为2012年）;");
		}else if(ic09Data.getAic162()>=20130101 && ic09Data.getAic162()<20140101){
			dataInfo.setTishi("若①＞②,取②+（①—②）×20%（退休时间为2013年）");
		}
		
		
		
		
		/**
		 * 记录信息
		 */
		PrintDataMain pdm=new PrintDataMain();
		pdm.setId(idcode);
		pdm.setType(ptype);
		pdm.setAae001(aac001);
		pdm.setAae036(new Date());
		pdm.setData01(dataInfo.getAab001());
		pdm.setData02(dataInfo.getAab004());
		pdm.setData03(dataInfo.getAab020());
		pdm.setData04(dataInfo.getAab301());
		pdm.setData05(dataInfo.getAac147());
		pdm.setData06(dataInfo.getAac082());
		pdm.setData07(dataInfo.getAac003());
		pdm.setData08(dataInfo.getAac004());
		pdm.setData09(dataInfo.getAac005());
		pdm.setData10(dataInfo.getAac006String());
		pdm.setData11(dataInfo.getCae200Year());
		pdm.setData12(dataInfo.getAic090Year());
		pdm.setData13(dataInfo.getSumYear());
		pdm.setData14(dataInfo.getStartToEnd());
		pdm.setData15(dataInfo.getAac007String());
		pdm.setData16(dataInfo.getWorkAgeBuTie());
		pdm.setData17(dataInfo.getCac001String());
		pdm.setData18(dataInfo.getAae005());
		pdm.setData19(dataInfo.getAae006());
		pdm.setData20(dataInfo.getAaf031());
		pdm.setData21(dataInfo.getAaz065().toString());
		pdm.setData22(dataInfo.getAae010());
		pdm.setData23(dataInfo.getAaa015().toString());
		pdm.setData24(dataInfo.getJiFaBiLi());
		pdm.setData25(dataInfo.getBasicPensionOld().toString());
		pdm.setData26(dataInfo.getAic165());
		pdm.setData27(dataInfo.getJiFaXiShuOld());
		pdm.setData28(dataInfo.getGzPensionOld().toString());
		pdm.setData29(dataInfo.getAic164().toString());
		pdm.setData30(dataInfo.getCae200YearDouble());
		pdm.setData31(dataInfo.getGuoDuPensionOld().toString());
		pdm.setData32(dataInfo.getWorkAgeBuTie());
		pdm.setData33(dataInfo.getAdjustJinEOld().toString());
		pdm.setData34(dataInfo.getGuoDuBuTie().toString());
		pdm.setData35(dataInfo.getTiqiantuixiuchaebeizhu());
		pdm.setData36(dataInfo.getTiqiantuixiuchae().toString());
		pdm.setData37(dataInfo.getCic016Old().toString());
		pdm.setData38(dataInfo.getAac026().toString());
		pdm.setData39(dataInfo.getSumYearDouble());
		pdm.setData40(dataInfo.getBasicPension().toString());
		pdm.setData41(dataInfo.getCae040());
		pdm.setData42(dataInfo.getGzPension().toString());
		pdm.setData43(dataInfo.getAac026().toString());
		pdm.setData44(dataInfo.getGuoDuPension().toString());
		pdm.setData45(dataInfo.getCic016New().toString());
		pdm.setData46(dataInfo.getCic016().toString());
		pdm.setData47(dataInfo.getTishi());
		pdm.setData48(dataInfo.getCae249());
		pdm.setData49(dataInfo.getCae250());
		pdm.setData50(dataInfo.getAae218().toString());
		pdm.setData51(dataInfo.getCityButie().toString());
		pdm.setData52(dataInfo.getElecBuTie().toString());
		pdm.setData53(dataInfo.getWaterBuTie().toString());
		pdm.setData54(dataInfo.getLifeButie().toString());
		pdm.setData55(dataInfo.getHouseButie().toString());
		pdm.setData56(dataInfo.getAic162String());
		pdm.setData57(dataInfo.getAac160String());
		pdm.setData58(dataInfo.getYearTime());
		pdm.setData59(dataInfo.getAdjustJinEXs().toString());
		pdm.setData60(dataInfo.getAdjustJinE().toString());
		pdm.setData61(dataInfo.getCie002().toString());
		CommonJdbcUtils.save(pdm);
		BeanUtils.copyProperties(pdm, vo);
		return vo;
	}
	public String getAa10DataById(String aaa100,String aaa102){
		String aaa103=null;
		
		String sql="select aaa103 from qdyth.aa10@qdweb_jx where aaa100=? and aaa102=?";
		aaa103=CommonJdbcUtils.queryFirst(sql, RetireInfoDTO.class, aaa100, aaa102).getAaa103();
		return aaa103;
	}
	/**
	 * 根据单号查询
	 * @param id
	 * @return
	 */
	public ReturnPrintVO getInfoById(String id){
		ReturnPrintVO vo=new ReturnPrintVO();
		String sql="select * from PRINT_DATA_MAIN where id=?";
		vo=CommonJdbcUtils.queryFirst(sql, ReturnPrintVO.class, id.toUpperCase());
		if(vo!=null&&vo.getType().equalsIgnoreCase("pd2")){
			String ss="select * from PRINT_DATA_LIST where id=?";
			List<PrintDataList> list=CommonJdbcUtils.query(ss, PrintDataList.class,vo.getData16());
			vo.setPrintList1(list);
			 ss="select * from PRINT_DATA_LIST where id=? order by data11";
			List<PrintDataList> list2=CommonJdbcUtils.query(ss, PrintDataList.class,vo.getData17());
			vo.setPrintList2(list2);
		}
		if(vo!=null&&vo.getType().equalsIgnoreCase("pf2")){//累积缴费打印
			String ss="select * from PRINT_DATA_LIST where id=? order by data04 DESC";
			List<PrintDataList> list=CommonJdbcUtils.query(ss, PrintDataList.class,vo.getData16());
			vo.setPrintList1(list);
		}
		if(vo!=null&&vo.getType().equalsIgnoreCase("pe2")){//养老接续单
			String ss="select * from PRINT_DATA_LIST where id=? order by data01";
			List<PrintDataList> list=CommonJdbcUtils.query(ss, PrintDataList.class,id);
			vo.setPrintList1(list);
		}
		if(vo!=null&&vo.getType().equalsIgnoreCase("pc1")){
			String rmb=RmbUtil.NumberToChinese(vo.getData09()==null?"0":vo.getData09());
			vo.setData21(rmb);
		}
		
		return vo;
	}
	public ReturnPrintVO getPsnRetireList(String aac001, String ptype){
		ReturnPrintVO vo=null;
		String idcode=VerifyUtils.getVerifyCode(ptype, aac001);//同一天的同一个人的校验码是一样的
		vo=getInfoById(idcode);
		if(vo!=null){
			return vo;
		}
		vo=new ReturnPrintVO();
		
		return vo;
	}
	/*public String getYear(String aac001){
		
		String sql="select * from qdyth.ic09@qdweb_jx where aac001=?";
		RetireInfoDTO ic09Data=CommonJdbcUtils.queryFirst(sql,RetireInfoDTO.class , aac001);
		if(ic09Data.getAic162()<20060101){
			
			return 
		}
	}*/
	public String savePsorder(String aac001,Integer aae001,String aae005,String aae006,String aae007){
		//判断人员单位性质和人员离退休状态。20151014_01020   828--840行
		String cab016=null;
		String aac084=null;
		String result = "";
		
		//查单位性质
		String cab016sql = "select cab016 from qdyth.ab01@qdweb_jx where aab001=(select max(aab001) from qdyth.ac20@qdweb_jx where cae265='1' and aac001=?)";
		cab016=CommonJdbcUtils.queryFirst(cab016sql, RetireInfoDTO.class, aac001).getCab016();
		//查询人员离退休状态
		String aac084sql = "select aac084 from qdyth.ac01@qdweb_jx where aac001=?";
		aac084=CommonJdbcUtils.queryFirst(aac084sql, RetireInfoDTO.class, aac001).getAac084();

		if (( "1".equals(cab016) && !"0".equals(aac084) ) ||"2".equals(cab016)) {
			result = "机关事业单位在职人员和退休人员及企业退休人员无法定制个人权益记录单，如需查询请通过人社网在线查询或到社保经办机构现场查询";
		} else {
			Psorder po=new Psorder();
			 po.setAac001(Long.valueOf(aac001));
			 po.setAae001(aae001);
			 po.setAae005(aae005);
			 po.setAae006(aae006);
			 po.setAae007(aae007);
			 po.setAae016("0");
			 po.setAae036(new Date());
			 CommonJdbcUtils.save(po);
		}
		return result;
	}
	
	public ReturnPrintVO getReturnPrintVOById(String id,String sql){
		return CommonJdbcUtils.queryFirst(sql, ReturnPrintVO.class, id.toUpperCase());
	}
	public Psorder getPsorderByAac001Aae001(String aac001,Integer aae001){
		return CommonJdbcUtils.queryFirst("select * from psorder where aac001=? and aae001=?", Psorder.class, aac001,aae001);
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
}
