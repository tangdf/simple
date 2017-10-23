package com.wb.qdyth.f1001.common.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.wb.jdbcutils.CommonJdbcUtils;
import com.wb.jdbcutils.Page;
import com.wb.qdyth.common.bo.NetData;
import com.wb.qdyth.common.bo.NetDataMain;
import com.wb.qdyth.common.service.CommonService;
import com.wb.qdyth.f1001.common.vo.BornInfoVO;
import com.wb.qdyth.f1001.common.vo.MedicalInfoVO;
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
public class EmpServiceImpl implements EmpService {
	
	private CommonService commonService;
	/**
	 * 查询人员基本信息
	 * @return
	 */
	public UserVO queryUserInfo(String aac001){
		UserVO personVO=new UserVO();
		String aab001="";
		StringBuffer sb =new StringBuffer();
		sb.append(" SELECT a.aab001,b.aab004,decode(b.cae247,'1','已参保','0','未参保')  AS aae119,(select c.aaa103 from aa10@qdweb_jx c where b.aab301=c.aaa102 and c.aaa100='AAB301') zab001,decode(a.aac031,'2','7',a.aac031) aac031,b.cab016 " +
				"FROM ac20@qdweb_jx a,ab01@qdweb_jx b "+
				"WHERE a.aab001 =b.aab001 AND a.cae265='1' AND a.aac001 = ? order by aac031");
		personVO=CommonJdbcUtils.queryFirst(sb.toString(), UserVO.class, aac001);
		if(personVO ==null){
			 personVO = new UserVO();
		}
		//单位类型和单位状态
		if(personVO.getAab001()!=null&&personVO.getAab001().length()>0){
			aab001=personVO.getAab001();
			String ae10Sql=" select c.aaa103 aab019, d.aaa103 aae119   from ab01@qdweb_jx a, ae10@qdweb_jx b, aa10@qdweb_jx c, aa10@qdweb_jx d  where a.aaz001 = b.aaz001    and b.aab019 = c.aaa102    and c.aaa100 = 'AAB019'    and b.cab009 = d.aaa102    and d.aaa100 = 'CAB009'    and a.aab001 = ?";
			UserVO vo=CommonJdbcUtils.queryFirst(ae10Sql, UserVO.class,personVO.getAab001());
			if(vo!=null){
				personVO.setAab019(vo.getAab019());
				personVO.setAae119(vo.getAae119());
			}
		}
		
		//个人信息
		StringBuffer sbPersonInfo = new StringBuffer();
		sbPersonInfo.append(" SELECT a.aac001,a.aac003,a.aae005,a.aae006,a.aae007,a.aac147 AS aac002,decode(a.aac004,'1','男','2','女','未说明性别') AS aac004, "); 
		sbPersonInfo.append(" a.aac007,a.aac006,decode(a.aac084,'0','在职','1','退休','2','离休') as aac008,(select b.aaa103 from aa10@qdweb_jx b where a.aac005 = b.aaa102 AND b.aaa100='AAC005') AS aac005,'否' AS aac019");                                   
		sbPersonInfo.append(" FROM ac01@qdweb_jx a   ");                                                         
		sbPersonInfo.append(" WHERE  aac001 = ? ");
		UserVO personInfoVO = CommonJdbcUtils.queryFirst(sbPersonInfo.toString(), UserVO.class, aac001);//2174122
		if(personInfoVO != null){
			String[] strArry = new String[]{"aab001","aab004","aab019","aae119","zab001"};
			BeanUtils.copyProperties(personInfoVO, personVO,strArry);
		}
		if(aab001!=null){//判断是不是交行单位
			personVO.setIsBank("0");
			String ss="select aab001 from v_jhdw@qdweb_jx a where a.aab001=?";
			UserVO isBank=CommonJdbcUtils.queryFirst(ss, UserVO.class, aab001);
			if(isBank!=null) {
				personVO.setIsBank("1");
			    personVO.setAab019("自由职业者");
			}
			}
		//出生时间和首次参加工作时间格式化
		if(null!=personVO.getAac006()&&personVO.getAac006().length()==8){
			personVO.setAac006(personVO.getAac006().substring(0, 4)+"-"+personVO.getAac006().substring(4, 6)+"-"+personVO.getAac006().substring(6, 8));
		}
		if(null!=personVO.getAac007()&&personVO.getAac007().length()==8){
			personVO.setAac007(personVO.getAac007().substring(0, 4)+"-"+personVO.getAac007().substring(4, 6)+"-"+personVO.getAac007().substring(6, 8));
		}
		
		//查看是否是公务员
		String sqlOfficer =" SELECT decode(aac012,'11','公务员或参照公务员','非公务员') AS ckc015 FROM ac01@qdweb_jx WHERE aac001 = ? ";
		UserVO personOfficerVO = CommonJdbcUtils.queryFirst(sqlOfficer.toString(), UserVO.class, aac001);
		if(personOfficerVO != null){
			personVO.setCkc015(personOfficerVO.getCkc015());
		}
		//查看是否有照片
		String sqlphoto =" SELECT count(*) photo FROM qdsbk.az02@qdweb_jx a, " +
				" ac01@qdweb_jx b  WHERE a.aac002=b.aac147 and b.aac001 = ? ";
		UserVO personPhotoVO = CommonJdbcUtils.queryFirst(sqlphoto.toString(), UserVO.class, aac001);
		if(!personPhotoVO.getPhoto().equals("0")){
			personVO.setPhoto("有制卡照片");
		}else{
			personVO.setPhoto("无制卡照片");
		}
		//查询制卡状态
		sqlphoto="SELECT max(aaz502) zkzt FROM QDSBK.AZ20@qdweb_jx A WHERE A.BKC156 IN (SELECT MAX(BKC156) FROM " +
		" QDSBK.AZ20@qdweb_jx WHERE AAA030 = '3' AND AZC001 = ? GROUP BY AZC001)  AND a.AZC001=?";
		UserVO personPhotoVOs=CommonJdbcUtils.queryFirst(sqlphoto, UserVO.class, aac001,aac001);
		personVO.setZkzt(personPhotoVOs.getZkzt());
		
		//查询社保卡信息
		StringBuffer sb_sbk = new StringBuffer();
		sb_sbk.setLength(0);
		sb_sbk.append(" SELECT (SELECT aaa103 FROM QDSBK.AZ60@qdweb_jx WHERE AAA102 = 'AAE008' and aaa105 = YHBM ) YHBM, ");
		sb_sbk.append("        (select name from qdyth.UAP_ORGAN_NODE@qdweb_jx where nodeid = jbwd) jbwd, ");
		sb_sbk.append("        (select address from qdyth.UAP_ORGAN_NODE@qdweb_jx where nodeid = jbwd) jbwddz");
		sb_sbk.append("        FROM QDSBK.TB_GRXX_TB@qdweb_jx where SCBZ = '1' and GRID = ? ");
		UserVO sb_sbk_vo = CommonJdbcUtils.queryFirst(sb_sbk.toString(), UserVO.class, aac001);
		if(sb_sbk_vo != null){
			personVO.setYhbm(sb_sbk_vo.getYhbm());
			personVO.setJbwd(sb_sbk_vo.getJbwd());
			personVO.setJbwddz(sb_sbk_vo.getJbwddz());
		}
		//保健类别
		String sqlHealthCare =" SELECT decode(cac215,'0','非保健类人员','1','一类保健','2','二类保健') aac017 FROM ac0b@qdweb_jx WHERE aac001 =? ";
		UserVO personHealthVO = CommonJdbcUtils.queryFirst(sqlHealthCare.toString(), UserVO.class, aac001);
		if(personHealthVO != null){
			personVO.setAac017(personHealthVO.getAac017());
		}else{
			personVO.setAac017("非保健类人员");
		}
		//退休类别
//		String sqlRetire =" SELECT c.aaa103 as aac022 FROM qddev_test.ic10@qdhis b,(select aaa102,aaa103 from qddev_test.aa10@qdhis where aaa100='AAC082') c WHERE b.aac082=c.aaa102 and b.aac001 = ? ";
		String sqlRetire =" SELECT c.aaa103 as aac022 FROM ic10@qdweb_jx b,(select aaa102,aaa103 from aa10@qdweb_jx where aaa100='AAC082') c WHERE b.aac082=c.aaa102 and b.aac001 = ? ";
		UserVO personRetireVO = CommonJdbcUtils.queryFirst(sqlRetire.toString(), UserVO.class, aac001);
		if(personRetireVO != null){
			personVO.setAac022(personRetireVO.getAac022());
		}
		if(personRetireVO!=null&&personRetireVO.getAac022()!=null&&personRetireVO.getAac022().contains("特殊工种")){
			personVO.setAac019("是");
		}
		//统筹类别
//		String sqlPlan =" SELECT c.aaa103 as aac021 FROM qddev_test.ac20@qdhis a,qddev_test.ab01@qdhis b,(select aaa102,aaa103 from qddev_test.aa10@qdhis where aaa100='AAA096') c WHERE b.aaa096=c.aaa102 and a.aab001=b.aab001 and a.aac001 = ? ";
		String sqlPlan =" SELECT c.aaa103 as aac021 FROM ac20@qdweb_jx a,ab01@qdweb_jx b,(select aaa102,aaa103 from aa10@qdweb_jx where aaa100='AAA096') c WHERE b.aaa096=c.aaa102 and a.aab001=b.aab001 and a.aac001 = ? ";
		UserVO personPlanVO = CommonJdbcUtils.queryFirst(sqlPlan.toString(), UserVO.class, aac001);
		if(personPlanVO != null){
			personVO.setAac021(personPlanVO.getAac021());
		}
		//视同缴费月数，累计缴费月数
		StringBuffer sqlMonth = new StringBuffer();
		sqlMonth.append(" SELECT nvl(a.AAE200,0) AS aic001,nvl(a.CAE200,0) AS aic002,aae140 FROM ac02@qdweb_jx a ");
		sqlMonth.append(" WHERE a.aac001 = ? AND a.aae140 IN ('110','120') AND a.aac008 ='1' ");
		UserVO personMonthVO = CommonJdbcUtils.queryFirst(sqlMonth.toString(), UserVO.class, aac001);
		if (personMonthVO != null) {
				personVO.setAic001(personMonthVO.getAic001());
				personVO.setAic002(personMonthVO.getAic002());

		} else {
			personVO.setAic001("0");
			personVO.setAic002("0");
		}
		return personVO;
	}
	/**
	 * 查询个人参保信息
	 * @return
	 */
	public void queryInsureInfo(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append(" SELECT distinct a.aac001,b.aac003,a.aae140 aaa,c.aae175 AS aae140, ");
		queryQL.append(" decode(a.aac031,'1','参保缴费','2','暂停缴费','3','终止缴费','4','退休审核期') AS aac031 ");
		queryQL.append(" FROM ac20@qdweb_jx a,ac01@qdweb_jx b,aa08@qdweb_jx c ");
		queryQL.append(" WHERE  a.aac001 = b.aac001 and a.cae265='1'  AND a.aae140 = c.aae140 ");
		queryQL.append(" and a.aac001 = ? ");
		queryQL.append(" order by aaa asc");
		CommonJdbcUtils.queryPageNT(page,queryQL.toString(), UserVO.class, aac001);
	}
	/**
	 * 人员基本信息修改
	 * @param vo
	 */
	public void saveBaseInfo(UserVO vo){
		//创建日志，获取流水号
		Long lsh=commonService.creatBusinessLog("1101");
		//保存net_data表
		NetData netdata=commonService.saveNetDate(lsh, "1101");
		//保存net_data_main表
		NetDataMain netdataMain = new NetDataMain();
		netdataMain.setLsh(lsh);
		netdataMain.setData01(vo.getAae005());//电话号码
		netdataMain.setData02(vo.getAae006());//联系地址
		netdataMain.setData03(vo.getAae007());//邮政编码
		netdataMain.setData04(netdata.getAac001());//人员编号
		CommonJdbcUtils.save(netdataMain);
	}
	public CommonService getCommonService() {
		return commonService;
	}
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	/**
	 * 当前年度缴费基数
	 * @return
	 */
	public void queryCurrentPay(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append(" SELECT b.aac003,a.aae041 AS aae030,a.aae042 AS aae031,c.aab001,c.aab004,nvl(a.aac040,0) aac040, ");              
		queryQL.append("  SUM(CASE a.AAE140 WHEN '110' THEN a.aae180 WHEN '120' THEN AAE180 ELSE 0 END) AS aic020, ");      
		queryQL.append("  SUM(CASE a.AAE140 WHEN '210' THEN a.AAE180 ELSE 0 END) AS ajc020,");                              
		queryQL.append("  SUM(CASE a.AAE140 WHEN '310' THEN a.AAE180 ELSE 0 END) AS akc010,");                              
		queryQL.append("  SUM(CASE a.AAE140 WHEN '410' THEN a.AAE180 ELSE 0 END) AS alc001,");                              
		queryQL.append("  SUM(CASE a.aae140 WHEN '510' THEN a.aae180 ELSE 0 END) AS amc001 ");                              
		queryQL.append(" FROM ac04@qdweb_jx a, ac01@qdweb_jx b, ab01@qdweb_jx c ");                                                    
		queryQL.append(" WHERE a.aac001 = b.aac001 AND a.aab001=c.aab001 AND substr(a.aae041,0,4)=to_char(SYSDATE,'yyyy')");
		queryQL.append(" AND a.aac001 = ? GROUP BY aac003,aae041,aae042,c.aab001,aab004,aac040 order by aae041 desc "); //8469221  2174122 4062531400 
		CommonJdbcUtils.queryPageNT(page,queryQL.toString(), PaymentVO.class, aac001);
	}
	/**
	 * 养老缴费明细查询+缴费合计查询
	 * @return
	 */
	public void queryAgedPay(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append(" SELECT b.aac003,a.aae002,a.aae003,c.aab004,d.aaa103 as aae143,NVL(SUM(DECODE(AAE341, '200001', (case when nvl(CAA017,0)+nvl(caa016,0)<>0 OR aae002 IN ('1900','180001') then AAE180 else 0 end), 0)),0) as aic020,");             
		queryQL.append(" SUM(CASE aae341 WHEN '200001' THEN nvl(CAA016,0)+nvl(CAA017,0) ELSE 0 END) AS aic021,");          
		queryQL.append(" SUM(CASE aae341 WHEN '100001' THEN nvl(CAA017,0) ELSE 0 END) AS aic024,");          
		queryQL.append(" SUM(CASE aae341 WHEN '600001' THEN nvl(CAA016,0)+nvl(CAA017,0) ELSE 0 END) AS cic070,");          
		queryQL.append(" decode(a.AAE078,'1','已实缴','0','未缴费') AS aae114");                      
		queryQL.append(" FROM ac43@qdweb_jx a,ac01@qdweb_jx b,ab01@qdweb_jx c,aa10@qdweb_jx d");                  
		queryQL.append(" WHERE a.aac001=b.aac001  and a.aae017='0' and a.aaa131='0' and a.cae260='0' and a.cae245='0' AND a.aab001 =c.aab001(+) AND a.aaa115 = d.aaa102");
		queryQL.append(" AND d.aaa100='AAA115' AND  a.aae140 IN ('110','120') AND a.aac001 = ?");//8469221  2174122 
		queryQL.append(" GROUP BY b.aac003,a.aae002,a.aae003,c.aab004,d.aaa103,a.AAE078 order by aae003 desc,aae002 desc");
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), PaymentVO.class, aac001);
	}
	public PaymentVO querySumPay(String aac001){
		PaymentVO vo=new PaymentVO();
		StringBuffer sql=new StringBuffer();
		sql.append("select sum(aic021) as aic021sum,sum(aic024) as aic024sum,sum(cic070) as cic070sum from");
		sql.append("( SELECT b.aac003,a.aae002,a.aae003,c.aab004,d.aaa103 as aae143,NVL(SUM(DECODE(AAE341, '200001', (case when nvl(CAA017,0)+nvl(caa016,0)<>0 OR aae002 IN ('1900','180001') then AAE180 else 0 end), 0)),0) as aic020,");             
		sql.append(" SUM(CASE aae341 WHEN '200001' THEN nvl(CAA016,0)+nvl(CAA017,0) ELSE 0 END) AS aic021,");          
		sql.append(" SUM(CASE aae341 WHEN '100001' THEN nvl(CAA017,0) ELSE 0 END) AS aic024,");          
		sql.append(" SUM(CASE aae341 WHEN '600001' THEN nvl(CAA016,0)+nvl(CAA017,0) ELSE 0 END) AS cic070,");          
		sql.append(" decode(a.AAE078,'1','已实缴','0','未缴费') AS aae114");                      
		sql.append(" FROM ac43@qdweb_jx a,ac01@qdweb_jx b,ab01@qdweb_jx c,aa10@qdweb_jx d");                  
		sql.append(" WHERE a.aac001=b.aac001  and a.aae017='0' and a.aaa131='0' and a.cae260='0' and a.cae245='0' AND a.aab001 =c.aab001(+) AND a.aaa115 = d.aaa102");
		sql.append(" AND d.aaa100='AAA115' AND  a.aae140 IN ('110','120') AND a.aac001 = ?");//8469221  2174122 
		sql.append(" GROUP BY b.aac003,a.aae002,a.aae003,c.aab004,d.aaa103,a.AAE078 order by aae003 desc,aae002 desc)");
		vo=CommonJdbcUtils.queryFirst(sql.toString(), PaymentVO.class, aac001);
		return vo;
	}
	/**
	 * 医疗缴费明细查询
	 * @return
	 */
	public void queryMedicalPay(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append(" SELECT b.aac003,a.aae002,a.aae003,c.aab004,d.aaa103 AS aae143,max(a.aae180) AS akc010,");     
		queryQL.append(" SUM(CASE WHEN a.aae341='200001' AND aae140='310' THEN caa017 ELSE 0 END) AS akc060, ");  
		queryQL.append(" SUM(CASE WHEN a.aae341='100001' AND aae140='310' THEN caa017 ELSE 0 END) AS caa024, ");  
		queryQL.append(" SUM(CASE aae140 WHEN '330' THEN abs(caa024) ELSE 0 END) AS zkc010,");                         
		queryQL.append(" SUM(CASE WHEN aae140 IN ('310','320','330') THEN caa017 ELSE 0 END) AS akc061,");        
		queryQL.append(" SUM(CASE aae140 WHEN '320' THEN caa017 ELSE 0 END) AS ckc030,");                         
		queryQL.append(" decode(a.AAE078,'1','已实缴','0','未缴费') AS aae114");                                  
		queryQL.append(" FROM  ac43@qdweb_jx a, ac01@qdweb_jx b, ab01@qdweb_jx c, aa10@qdweb_jx d");                              
		queryQL.append(" WHERE a.aac001=b.aac001  and a.aae017='0' and a.aaa131='0' and a.cae260='0' and a.cae245='0' AND a.aab001 =c.aab001(+) AND a.aaa115 = d.aaa102");
		queryQL.append(" AND d.aaa100='AAA115' AND  a.aae140 IN ('310','320','330') AND a.aac001 = ?"); //2174122 8469221
		queryQL.append(" GROUP BY b.aac003,a.aae002,a.aae003,c.aab004,d.aaa103,a.AAE078 order by a.aae003 desc,a.aae002 desc"); 
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), PaymentVO.class, aac001);
	}
	/**
	 * 失业缴费明细查询
	 * @return
	 */
	public void queryUnemploymentPay(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append(" SELECT b.aac003, a.aac001,a.aae002,a.aae003,c.aab004,d.aaa103 AS aae143,a.aae180 AS ajc020,"); 
		queryQL.append(" SUM(CASE aae341 WHEN '200001' THEN CAA016 ELSE 0 END) AS ajc030,");                               
		queryQL.append(" decode(a.AAE078,'1','已实缴','0','未缴费') AS aae115");                                        
		queryQL.append(" FROM  ac43@qdweb_jx a, ac01@qdweb_jx b, ab01@qdweb_jx c, aa10@qdweb_jx d");                                    
		queryQL.append(" WHERE a.aac001=b.aac001 and  a.aae017='0' and a.aaa131='0' and a.cae260='0' and a.cae245='0' AND a.aab001 =c.aab001(+) AND a.aaa115 = d.aaa102"); 
		queryQL.append(" AND d.aaa100='AAA115' AND  a.aae140 ='210' AND a.aac001 = ? ");  //2174122 8469221
		queryQL.append(" GROUP BY b.aac003,a.aac001,a.aae002,a.aae003,c.aab004,d.aaa103,a.aae180,a.AAE078 order by aae003 desc,a.aae002 desc");
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), PaymentVO.class, aac001);
	}
	/**
	 * 医疗保险审批查询
	 * @return
	 */
	public void queryMedicalApproval(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select * from ( SELECT(select aaa103 from  aa10@qdweb_jx where aaa100 = 'CKC042' AND AAA102 = A.ckc042) ckc042,b.aac003,b.aac001,"+
				"(select AKA121 from  KA06@qdweb_jx where AKA120 = A.AKA120 AND ROWNUM = 1) aka120,"+
				"aae030,(select CKB104 from  Kb01@qdweb_jx where akb020 = A.akb020 AND ROWNUM = 1) akb020,nvl(to_char(aae031),' ') aae031,a.aae013,a.ckc005 FROM  KC26@qdweb_jx a , ac01@qdweb_jx b "+
				"WHERE a.aac001=b.aac001) where ckc005='8'  ");
		queryQL.append(" and aac001 = ?");
		queryQL.append(" order by aae030 desc");
		CommonJdbcUtils.queryPageNT(page,queryQL.toString(),MedicalInfoVO.class,aac001);
	}
	/**
	 * 医疗住院结算查询
	 * @return
	 */
	public void queryMedicalSettlement(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select (SELECT ckb104 FROM  KB01@qdweb_jx  WHERE AKB020 = A.AKB020) AS ckb104,");
		queryQL.append("(SELECT aaa103 FROM  aa10@qdweb_jx  WHERE aaa102 = A.ckc022 and aaa100='CKC022') AS ckc022,");
		queryQL.append("b.cke012,b.aae030,b.aae031,a.akc264,a.ake039,a.ake029,a.aka030 as jslx,NVL(a.ake038,0)AS AKE038,(NVL(a.akc253,0)+NVL(a.akc254,0)) as grxjzf,(NVL(a.ake035,0)+NVL(a.ake103,0)) as bzbtzc,");
		queryQL.append(" NVL(a.ckc070,0)AS CKC070,NVL(a.ake101,0)+NVL(a.ake102,0)-NVL(a.ckc070,0) akc266,NVL(a.akc253,0) AS AKC253,a.aac001, " +
				" (CASE WHEN A.AKA030 = '51002' THEN " +
				"     (CASE WHEN A.CKE260 < DATE '2013-02-20' THEN '过渡期第一批救助' " +
				"           WHEN A.CKE260 >= DATE '2013-02-20' AND A.CKE260 < DATE '2013-03-20' + 1 THEN  '过渡期第二批救助' " +
				"           WHEN A.CKE260 >= DATE '2013-03-21' THEN '过渡期第三批救助' " +
				"           ELSE '过渡期救助' END) " +
				" ELSE " +
				" (SELECT AAA103 FROM  AA10@qdweb_jx"+
				"  WHERE AAA102 = A.AKA030 " +
				" AND AAA100 = 'AKA030') END )  AS AKA030, " +
				" decode(a.aka030,'51002',decode(c.aaz267,'370200','青岛市社会保险事业局','370202','市社会保险事业局市南分局','370203','市社会保险事业局市北分局'" +
				",'370205','市社会保险事业局四方分局','370213','市社会保险事业局李沧分局','370214','城阳区医疗保险管理中心'" +
				",'370212','崂山区社会保险服务大厅','370211','青岛经济技术开发区社会保障事业管理中心','370282','即墨市医疗保险管理中心'" +
				",'370283','平度市医疗保险管理中心','370285','莱西市医疗保险管理中心','370281','胶州市医疗保险管理中心'" +
				",'370284','原胶南市医疗保险管理中心'),null)AS aaz267, "+
				" NVL(a.cke412,0) AS cke412, " +
				" NVL(a.cke413,0) AS cke413, " +
				" NVL(a.cke414,0) AS cke414, " +
				" NVL(a.cke415,0) AS cke415, " +
				" NVL(a.cke412,0)+NVL(a.cke413,0)+NVL(a.cke414,0)+NVL(a.cke415,0) AS JZZF    " +
				" from   kc12@qdweb_jx a,  kc14@qdweb_jx b, "); 
		queryQL.append( "KC62@qdweb_jx C ");
		queryQL.append("where a.cka009=b.cka009(+) AND A.CKC016 = C.CKC016(+)  and  nvl(B.ckc009,'1')='1'  and A.ckc009='1' " );
		queryQL.append(" AND A.AKA030 NOT IN ('31001','32001') ");
		queryQL.append(" and  a.aac001 = ?");
		queryQL.append(" AND A.CKC016 NOT IN  ");
		queryQL.append("  (SELECT D.CKC016 FROM  KC12@qdweb_jx D, ");
		queryQL.append("KC14@qdweb_jx E, ");
		queryQL.append("KC62@qdweb_jx F  ");
		queryQL.append(" WHERE D.CKA009 = E.CKA009(+) ");
		queryQL.append(" AND D.CKC016 = F.CKC016(+) ");
		queryQL.append(" AND NVL(E.CKC009, '1') = '1' ");
		queryQL.append(" AND D.CKC009 = '1' ");
		queryQL.append(" AND D.AKA030 = '51002' ");
		queryQL.append(" AND D.AAC001 = A.AAC001 ");
		queryQL.append(" AND NVL(F.CKE412, 0) + NVL(F.CKE413, 0) + NVL(F.CKE414, 0) + NVL(F.CKE415, 0) <= 100) ");
		queryQL.append(" order by  aae030 desc ");
		CommonJdbcUtils.queryPageNT(page,queryQL.toString(),MedicalInfoVO.class,aac001);
	}
	/**
	 * 医疗年度情况查询
	 * @return
	 */
	public void queryMedicalAnnualInfo(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("SELECT A.CKE002,A.AAC001,MAX(A.AAE030) AS AAE030,COUNT(DECODE(SUBSTR(CKC119, 1, 1),'1',NULL,DECODE(SUBSTR(AKA030, 1, 3), '120', 1, NULL))) AS AKA030A,COUNT(DECODE(AKA030, '11002', 1, NULL)) " +
				"AS AKA030B,MAX(A.AAE031) AS AAE031,SUM(B.AKC264) AS AKC264,"+
			    "SUM(B.AKE039) AS AKE039,sum(b.ake101+b.ake102-b.ckc070) as akc266,SUM(B.AKE029) AS AKE029  " +
			    "FROM  KC44@qdweb_jx A,  KC12@qdweb_jx B, KC46@qdweb_jx f "+
			    "WHERE A.AAC001 = B.AAC001  and b.ckc016=f.ckc016 AND B.CKC009 = '1' AND B.CKE264 IS NULL AND A.CKC009='1'    AND TO_CHAR(B.CKE011,'yyyymmdd') >= A.AAE030 AND TO_CHAR(B.CKE011,'yyyymmdd') <= A.AAE031 " +
			    "   AND (B.CKC022 = '120' or B.AKA030 IN ('11002', '12001', '12004', '12007'))");
		queryQL.append(" and a.aac001=?");
		queryQL.append(" GROUP BY A.CKE002,A.AAC001 order by aae030 desc ");
		CommonJdbcUtils.queryPageNT(page,queryQL.toString(),MedicalInfoVO.class,aac001);
	}
	/**
	 * 在职养老账户查询
	 * @return
	 */
	public void queryPensionAccounts(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append(" SELECT aae001,a.aac001,b.aac147,b.aac003,nvl(aae253, 0)+nvl(aae256, 0) as aae253,nvl(aae254, 0)+nvl(aae257,0) as aae254,"
				+ "nvl(aae262, 0) as aae262,nvl(aae263, 0) as aae263,nvl(aae264, 0) as aae264,nvl(aae265, 0) as aae265,"
				+ "nvl(aae259, 0) as aae259,nvl(aae260, 0) as aae260,nvl(aae255, 0) as aae255,nvl(aae252, 0) as aae252 "
				+ "FROM "
				+ "ac51@qdweb_jx"
				+ " a,"
				+ "ac01@qdweb_jx"
				+ " b,"
				+ ""
				+ "ac20@qdweb_jx"
				+ " c  WHERE 1=1 ");
		queryQL.append(" and a.aac001 = ? ");// 8469221
		queryQL.append("  AND a.cae218='0' AND a.aac001 = b.aac001 AND a.aac001 =c.aac001 and c.cae265='1' AND c.aae140 IN ('110','120') order by aae001 desc");
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), PensionInfoVO.class, aac001);
	}
	/**
	 * 退休待遇项目查询+金额合计查询
	 * @return
	 */
	public void queryRetirementBenifits(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select a.aac001,a.aac003,a.aac147,c.aaz179,c.cae097,c.aae041, decode(c.aae042,999999,null,c.aae042) aae042,c.cae021,c.aae019,c.cae107,d.aaa037 ");
		queryQL.append("from  ac01@qdweb_jx a ,");
		queryQL.append(" ac60@qdweb_jx b,");
		queryQL.append(" ac61@qdweb_jx c ,");
		queryQL.append(" aa17@qdweb_jx d where ");
		queryQL.append("a.aac001=b.aac001 and b.aaz257=c.aaz257 and c.cae021 is null and  c.aaa036=d.aaa036 and b.cac006='2' AND c.aae100='1' and c.aae116='1' and c.aae042=999999 and b.cae110 = '1'");
		queryQL.append(" and a.aac001=? ");
		queryQL.append(" order by c.aaa036 ");
		CommonJdbcUtils.queryPageNT(page,queryQL.toString(),PensionInfoVO.class,aac001);
	}
	public PensionInfoVO querySumTreatment(String aac001){
		PensionInfoVO vo=new PensionInfoVO();
		StringBuffer sql=new StringBuffer();
		sql.append("select nvl(sum(c.aae019),0) as aae019sum from ");
		sql.append(" ac60@qdweb_jx a,");
		sql.append(" ac61@qdweb_jx c ");
		sql.append("where a.aaz257=c.aaz257 and c.cae021 is null and a.cac006='2' and c.aae100='1' and a.cae110='1' and a.aac001=? ");
		sql.append(" and c.aae116='1'  and c.aae042 = 999999 ");
		vo=CommonJdbcUtils.queryObject(sql.toString(), PensionInfoVO.class, aac001);
		return vo;
	}
	/**
	 * 养老金发放明细查询+金额合计查询
	 * @return
	 */
	public void queryPensionDetails(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select a.aac001,a.aac003,b.aae002,b.aae019 from ");
		queryQL.append(" ac01@qdweb_jx a,");
		queryQL.append(" ac82@qdweb_jx b");
		queryQL.append(" where a.aac001=b.aac001 and b.aae140 in ('110','120') and b.cae011='5' ");
		queryQL.append(" and a.aac001 = ?");
		queryQL.append(" order by b.aae002 desc ");
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), PensionInfoVO.class, aac001);
	}
	public PensionInfoVO querySumPensionDetails(String aac001){
		PensionInfoVO vo=new PensionInfoVO();
		StringBuffer sql=new StringBuffer();
		sql.append("select nvl(sum(a.aae019),0) as aae019sum ");
		sql.append("from  ac82@qdweb_jx a");
		sql.append(" where ");
		sql.append(" a.aae140 in ('110','120') and a.cae011='5' and a.aac001=? ");
		vo=CommonJdbcUtils.queryObject(sql.toString(), PensionInfoVO.class, aac001);
		return vo;
	}
	/**
	 * 工伤定期待遇补退明细查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryWorkInjuryTreatment1(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select a.aac001,a.aac003,a.aac147,b.aaz166,b.aae002,b.aae019,c.aaa103 from ");
		queryQL.append(" ac01@qdweb_jx a,");
		queryQL.append(" ac75@qdweb_jx b,");
		queryQL.append("aa10@qdweb_jx c where ");
		queryQL.append("a.aac001=b.aac001 and b.aaa077=c.aaa102 and b.aae002>=200401 and c.aaa100='AAA077' and ");
		queryQL.append("b.aae140='410' ");
		queryQL.append(" and a.aac001 = ?");
		queryQL.append(" order by b.aae002 desc ");	
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), WorkInjuryVO.class, aac001);
	}
	public WorkInjuryVO getWorkInjuryInfo(Long aaz166){
		StringBuffer sql = new StringBuffer();
		sql.append("select b.aaa037,a.*,c.aaa103 ");
		sql.append("from  ac76@qdweb_jx a,");
		sql.append(" aa17@qdweb_jx b,");
		sql.append(" aa10@qdweb_jx c ");
		sql.append("where a.aaa036=b.aaa036 and a.aaa078=c.aaa102 and c.aaa100='AAA078' ");
		sql.append("and a.aaz166=?");
		WorkInjuryVO vo=CommonJdbcUtils.queryFirst(sql.toString(), WorkInjuryVO.class, aaz166);
		return vo;
	}
	public WorkInjuryVO querySumWorkInjury1(String aac001){
		StringBuffer sql = new StringBuffer();
		sql.append("select nvl(sum(a.aae019),0) as aae019sum ");
		sql.append("from  ac75@qdweb_jx a where ");
		sql.append(" a.aae140 = '410' and a.aae002>=200401 and a.aac001=? ");
		WorkInjuryVO vo = CommonJdbcUtils.queryObject(sql.toString(),WorkInjuryVO.class, aac001);
		return vo;
	}
	/**
	 * 工伤定期待遇发放明细查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryWorkInjuryTreatment2(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append(" select c.aaa037, b.aae041, decode(b.aae042,999999,null,b.aae042) aae042, b.aae019 from ");
		queryQL.append(" ac60@qdweb_jx a,");
		queryQL.append(" ac61@qdweb_jx b,");
		queryQL.append(" aa17@qdweb_jx c where ");
		queryQL.append("a.aaz257 = b.aaz257 and a.aae140 = '410' and b.aaa036 = c.aaa036 ");
		queryQL.append(" and a.aac001 = ?");
		queryQL.append(" order by b.aae041 desc ");
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), WorkInjuryVO.class, aac001);
	}
	public WorkInjuryVO querySumWorkInjury2(String aac001){
		StringBuffer sql=new StringBuffer();
		sql.append("select nvl(sum(b.aae019),0) as aae019sum ");
		sql.append("from  ac60@qdweb_jx a,");
		sql.append(" ac61@qdweb_jx b where ");
		sql.append("a.aaz257 = b.aaz257 and a.aae140 = '410' and a.aac001=? ");
		sql.append("and b.aae041<=? and b.aae042>=? ");
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyyMM");
		Integer dateInteger=new Integer(df.format(date));
		WorkInjuryVO vo=CommonJdbcUtils.queryObject(sql.toString(), WorkInjuryVO.class, aac001,dateInteger,dateInteger);
		return vo;
	}
	/**
	 * 工伤一次性伤残补助金明细查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryWorkInjuryTreatment3(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select a.aac001,a.aac003,a.aac147,c.*,d.aaa037 from ");
		queryQL.append(" ac01@qdweb_jx a,");
		queryQL.append(" ac71@qdweb_jx b,");
		queryQL.append(" ac73@qdweb_jx c,");
		queryQL.append(" aa17@qdweb_jx d where ");
		queryQL.append("a.aac001=b.aac001 and c.aae041>=200401 and b.aaz170=c.aaz170 and c.aaa036=d.aaa036 and ");
		queryQL.append("c.aaa036='L00020' and b.cae009='1'  ");
		queryQL.append(" and a.aac001 = ?");
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), WorkInjuryVO.class, aac001);
	}
	public WorkInjuryVO querySumWorkInjury3(String aac001){
		StringBuffer sql=new StringBuffer();
		sql.append("select nvl(sum(b.aae129),0) as aae129sum ");
		sql.append("from  ac71@qdweb_jx a,");
		sql.append(" ac73@qdweb_jx b where ");
		sql.append("a.aaz170 = b.aaz170 and a.aae140='410' and a.aae211>=200401 and a.cae009='1' and b.aaa085='0' and b.aaa036='L00020' and a.aac001=? ");
		WorkInjuryVO vo=CommonJdbcUtils.queryObject(sql.toString(), WorkInjuryVO.class, aac001);
		return vo;
	}
	/**
	 * 工伤待遇明细查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryWorkInjuryTreatment4(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select a.aac001,a.aac003,b.aae002,b.aae019 from ");
		queryQL.append(" ac01@qdweb_jx a,");
		queryQL.append(" ac82@qdweb_jx b where ");
		queryQL.append("a.aac001=b.aac001 and b.aae140='410' and b.aae002>=200401 and b.cae011='5' ");
		queryQL.append( "and not exists (select * from  ae30@qdweb_jx c  WHERE b.aaz030 = c.aaz030 AND b.aae140 = '410' " +
				" AND c.caa121  IN ('4101','4102','4104','4105','4106'))");
		queryQL.append(" and a.aac001 = ?");
		queryQL.append(" order by aae002 desc");
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), WorkInjuryVO.class, aac001);
	}
	public WorkInjuryVO querySumWorkInjury4(String aac001){
		StringBuffer sql=new StringBuffer();
		sql.append("select nvl(sum(a.aae019),0) as aae019sum ");
		sql.append("from  ac82@qdweb_jx a ");
		sql.append(" where a.aae140='410' and a.aae002>=200401 and a.cae011='5' and  a.aac001= ? ");
		sql.append( "and not exists (select * from  ae30@qdweb_jx c  WHERE a.aaz030 = c.aaz030 AND" +
				" a.aae140 = '410'  AND c.caa121   IN ('4101','4102','4104','4105','4106'))");
		WorkInjuryVO vo=CommonJdbcUtils.queryObject(sql.toString(), WorkInjuryVO.class, aac001);
		return vo;
	}
	/**
	 * 生育待遇明细查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryBornTreatment(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select a.aac001,a.aac003,a.aac147,c.aae002,c.aae003,c.aae019,c.aaz219,d.aaa037 from ");
		queryQL.append(" ac01@qdweb_jx a,");
		queryQL.append(" ac82@qdweb_jx b,");
		queryQL.append(" ac83@qdweb_jx c,");
		queryQL.append(" aa17@qdweb_jx d,");
		queryQL.append(" ae30@qdweb_jx e where ");
		queryQL.append("a.aac001=b.aac001 and b.aaz220=c.aaz220 and c.aaa036=d.aaa036 and ");
		queryQL.append("b.aae140 ='510' and c.aae002>200304 and b.cae011='5' and  b.aaz030=e.aaz030 and e.caa121='5100' ");
		queryQL.append(" and a.aac001 = ?");
		queryQL.append(" order by c.aae003 desc ");
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), BornInfoVO.class, aac001);
	}
	public BornInfoVO querySumBornTreatment(String aac001){
		StringBuffer sql=new StringBuffer();
		sql.append("select nvl(sum(b.aae019),0) as aae019sum ");
		sql.append("from  ac82@qdweb_jx a,");
		sql.append(" ac83@qdweb_jx b, ");
		sql.append(" ae30@qdweb_jx c where ");
		sql.append("a.aaz220=b.aaz220 and a.aae140 = '510' and a.aac001=? and b.aae002>200304 and a.aaz030=c.aaz030 and c.caa121='5100' and a.cae011='5' ");
		BornInfoVO vo=CommonJdbcUtils.queryObject(sql.toString(), BornInfoVO.class, aac001);
		return vo;
	}
	/**
	 * 生育诊疗费查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryBornMedicalFee(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select * from ");
		queryQL.append("(select '手工报销' caa121,a.aac001,a.aac003,a.aac147,c.aae002,c.aae003,c.aae019,d.aaa037 from ");
		queryQL.append(" ac01@qdweb_jx a,");
		queryQL.append(" ac82@qdweb_jx b,");
		queryQL.append(" ac83@qdweb_jx c,");
		queryQL.append(" aa17@qdweb_jx d, ");
		queryQL.append(" ae30@qdweb_jx e where ");
		queryQL.append("a.aac001=b.aac001 and b.aaz220=c.aaz220 and c.aaa036=d.aaa036 and ");
		queryQL.append("b.aae140 ='510' and c.aae002>200304 and b.aaz030=e.aaz030 and e.caa121='5103' and b.cae011='5' ");
		queryQL.append("union all ");
		queryQL.append("select '医疗机构联网结算' caa121,a.aac001,a.aac003,a.aac147,b.aae002,b.aae002 aae003,f.ake039 aae019,'生育医疗费' aaa037 from ");
		queryQL.append(" ac01@qdweb_jx a,");
		queryQL.append(" ac82@qdweb_jx b,");
		queryQL.append(" ae30@qdweb_jx e, ");
		queryQL.append(" acf0@qdweb_jx f where ");
		queryQL.append("a.aac001=b.aac001 and b.aaz220=f.aaz220 and ");
		queryQL.append("b.aae140 ='510' and b.aae002>200304 and b.aaz030=e.aaz030 and e.caa121='5101' and b.cae011='5') ");
		queryQL.append(" where aac001 = ?");		
		queryQL.append(" order by caa121 ,aae003 desc ");
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), BornInfoVO.class, aac001);
	}
	public BornInfoVO querySumBornMedicalFee(String aac001){
		StringBuffer sql=new StringBuffer();
		sql.append("select nvl(sum(aae019),0) as aae019sum from ( ");
		sql.append("select a.aae019 ");
		sql.append("from  ac82@qdweb_jx a,");
		sql.append(" ae30@qdweb_jx b where ");
		sql.append("a.aaz030=b.aaz030 and b.caa121='5103' and a.aae140 = '510' " +
				"and a.aac001=? and a.aae002>200304 and a.cae011='5' ");
		sql.append("union all ");
		sql.append("select c.ake039 as aae019 ");
		sql.append("from ac82@qdweb_jx a,");
		sql.append(" acf0@qdweb_jx c,");
		sql.append(" ae30@qdweb_jx b where ");
		sql.append("a.aaz030=b.aaz030 and a.aaz220=c.aaz220 and b.caa121='5101' and a.aae140 = '510' " +
				"and a.aac001=? and a.aae002>200304 and a.cae011='5' )");
		BornInfoVO vo=CommonJdbcUtils.queryObject(sql.toString(), BornInfoVO.class, aac001);
		return vo;
	}
	/**
	 * 男职工补助金查询+详细信息查询+金额合计查询
	 * @return
	 */
	public void queryMaleAllowance(Page page,String aac001){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select a.aac001,a.aac003,a.aac147,c.aae002,c.aae003,c.aae019,c.aaz219,d.aaa037 from ");
		queryQL.append(" ac01@qdweb_jx a,");
		queryQL.append(" ac82@qdweb_jx b,");
		queryQL.append(" ac83@qdweb_jx c,");
		queryQL.append(" aa17@qdweb_jx d,");
		queryQL.append(" ae30@qdweb_jx e where ");
		queryQL.append("a.aac001=b.aac001 and b.aaz220=c.aaz220 and c.aaa036=d.aaa036 and ");
		queryQL.append("b.aae140 ='510' and c.aae002>200304 and b.aaz030=e.aaz030 and e.caa121='5102' and b.cae011='5'");
		queryQL.append(" and a.aac001 = ?");		
		queryQL.append(" order by c.aae003 desc ");
		CommonJdbcUtils.queryPageNT(page, queryQL.toString(), BornInfoVO.class, aac001);
	}
	public BornInfoVO querySumMaleAllowance(String aac001){
		StringBuffer sql=new StringBuffer();
		sql.append("select nvl(sum(b.aae019),0) as aae019sum ");
		sql.append("from  ac82@qdweb_jx a,");
		sql.append(" ac83@qdweb_jx b,");
		sql.append(" ae30@qdweb_jx c where ");
		sql.append("a.aaz220=b.aaz220 and a.aae140 = '510' and a.aac001=? and b.aae002>200304 and a.aaz030=c.aaz030 and c.caa121='5102' and a.cae011='5' ");
		BornInfoVO vo=CommonJdbcUtils.queryObject(sql.toString(), BornInfoVO.class, aac001);
		return vo;
	}
	/**
	 * 退休退职人员调待查询基本信息
	 */
	 public RetireResignQueryVO queryTxtzTdDetails(RetireResignQueryVO retireResignQueryVO){
	   RetireResignQueryVO queryVO= getBaseInfo(retireResignQueryVO);
	   if(queryVO==null)
		   return null;
	 //出生时间和首次参加工作时间格式化
		if(null!=queryVO.getAac006()&&queryVO.getAac006().length()==8){
			queryVO.setAac006(queryVO.getAac006().substring(0, 4)+"年"+queryVO.getAac006().substring(4, 6)+"月"+queryVO.getAac006().substring(6, 8)+"日");
		}
		if(null!=queryVO.getAac007()&&queryVO.getAac007().length()==8){
			queryVO.setAac007(queryVO.getAac007().substring(0, 4)+"年"+queryVO.getAac007().substring(4, 6)+"月"+queryVO.getAac007().substring(6, 8)+"日");
		}
		if(null!=queryVO.getAic162()&&queryVO.getAic162().length()==8){
			queryVO.setAic162(queryVO.getAic162().substring(0, 4)+"年"+queryVO.getAic162().substring(4, 6)+"月"+queryVO.getAic162().substring(6, 8)+"日");
		}
		 BigDecimal aae019sum=getPensionSum(retireResignQueryVO);
		 BigDecimal aae019sumexc=getExcPensionSum(retireResignQueryVO);
		 BigDecimal aae019sumall=getAllPensionSum(retireResignQueryVO);
		 queryVO.setAae019sum(aae019sum);
		 queryVO.setAae019sumall(aae019sumall);
		 queryVO.setAae019sumexc(aae019sumexc);
	   return queryVO;
	 }
	/**
	  *  退休退职人员调待查询基本信息
	  * @param retireResignQueryVO
	  * @return
	  */
	 public RetireResignQueryVO getBaseInfo(RetireResignQueryVO retireResignQueryVO){
		 StringBuffer sql = new StringBuffer();
		 Date nowDate=new Date();
		 java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy");
		 String now_date=format.format(nowDate);
		 sql.append("SELECT A.AAC001,A.AAC003,(SELECT D.AAA103 FROM qdyth.AA10@qdweb_jx D WHERE D.AAA100='AAC082' AND D.AAA102=A.AAC082) AAC082,B.AAC006,B.AAC007,A.AIC162,C.AAB004,A.AIC003,A.AIC111,A.AIC112,A.aic121,");
		 sql.append("(case when aae001>=201501 then NVL(AIC115, 0) + NVL(AIC117, 0) else  NVL(AIC113, 0) + NVL(AIC114, 0) + NVL(AIC115, 0) +  NVL(AIC116, 0) + NVL(AIC117, 0) end) XJ,");
		 sql.append("A.AIC114,A.AIC113,A.AIC116,A.AIC115,A.AIC117,A.AIC110,(CASE WHEN AAC160 > 201301 AND FLAG <> '1' THEN 201305 - AAC160 ELSE 4 END) BFYS,(CASE WHEN CAE110 = 1 AND AIC118 = 0 THEN AIC110 ELSE 0  END * (CASE WHEN AAC160 > 201301 AND FLAG <> '1' THEN 201305 - AAC160 ELSE 4 END)) BFHJ");
		 sql.append(" FROM qdyth.IC70@qdweb_jx A,qdyth.AC01@qdweb_jx B,qdyth.AB01@qdweb_jx C");
		 sql.append(" WHERE A.AAC001=B.AAC001 AND A.AAB001=C.AAB001 AND A.AAC001 = ? and a.aae001 like '"+now_date+"%'");
		 String sql3 = "select months_between(to_date(aae042,'yyyymm'),to_date(aae041,'yyyymm'))+1 bfys, aae019 BFHJ from qdyth.AC75@qdweb_jx where aac001=? and aae013 like ?||'调待补发'";
		 RetireResignQueryVO vo1=CommonJdbcUtils.queryFirst(sql3, RetireResignQueryVO.class,retireResignQueryVO.getAac001(),now_date);
        RetireResignQueryVO vo=CommonJdbcUtils.queryFirst(sql.toString(), RetireResignQueryVO.class,retireResignQueryVO.getAac001());
        if(vo!=null){
       	 if(vo1!=null){
       		 if(vo1.getBfhj()!=null && !vo1.getBfhj().equals("")){
       			 vo.setBfhj(vo1.getBfhj());
       		 }
       		 if(vo1.getBfys()!=null &&!vo1.getBfys().equals("")){
       			 vo.setBfys(vo1.getBfys());
       		 }
       	 }
       		 vo.setNow_date(now_date);
        }
        return vo;
	 }
	 /**
	  * 月基本养老待遇 合计
	  * @param retireResignQueryVO
	  * @return
	  */
	 public BigDecimal getPensionSum(RetireResignQueryVO retireResignQueryVO){
		 StringBuffer sql = new StringBuffer();
		 Date nowDate=new Date();
		 java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy");
		 String now_date=format.format(nowDate);
		 Long now_date1=Long.parseLong(now_date)*100+4;
		 sql.append("SELECT  SUM(A.AAE019) AAE019SUM FROM qdyth.AC61@qdweb_jx A, qdyth.IC70@qdweb_jx B, qdyth.AA17@qdweb_jx C");
		 sql.append(" WHERE A.AAE042 = 999999 AND A.AAZ257 = B.AAZ257 AND A.AAA036 = C.AAA036 AND A.AAE041 <= "+now_date1+"	 AND C.AAA037 NOT LIKE '"+now_date+"%'	 AND AAE116 =b.cae110  AND A.AAE100 = '1'  AND A.CAE021 IS NULL");
		 sql.append(" AND A.AAA036 IN (SELECT D.AAA036 FROM qdyth.AA18@qdweb_jx D WHERE D.AAB301 = B.AAB301	AND D.AAE140 = '110' AND D.CAE002 = '1'	AND D.CAB016 = '1' UNION ALL SELECT 'IX0019' FROM DUAL) ");
		 sql.append(" AND B.AAC001 = ? and b.aae001 like '"+now_date+"%'");
		 PensionVO pensionVO=CommonJdbcUtils.queryFirst(sql.toString(), PensionVO.class,retireResignQueryVO.getAac001());
		 return pensionVO.getAae019sum();
	 }
	 /**
	  * 月基本养老外待遇合计
	  * @param retireResignQueryVO
	  * @return
	  */
	 public BigDecimal getExcPensionSum(RetireResignQueryVO retireResignQueryVO){
		 StringBuffer sql = new StringBuffer();
		 Date nowDate=new Date();
		 java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy");
		 String now_date=format.format(nowDate);
		 Long now_date1=Long.parseLong(now_date)*100+4;
		 sql.append("SELECT  SUM(A.AAE019) AAE019SUM FROM qdyth.AC61@qdweb_jx A, qdyth.IC70@qdweb_jx B, qdyth.AA17@qdweb_jx C");
		 sql.append(" WHERE A.AAE042 = 999999 AND A.AAZ257 = B.AAZ257 AND A.AAA036 = C.AAA036 AND A.AAE041 <= "+now_date1+"	 AND C.AAA037 NOT LIKE '"+now_date+"%'	 AND AAE116 =b.cae110  AND A.AAE100 = '1'  AND A.CAE021 IS NULL");
		 sql.append(" AND A.AAA036 NOT IN (SELECT D.AAA036 FROM qdyth.AA18@qdweb_jx D WHERE D.AAB301 = B.AAB301	AND D.AAE140 = '110' AND D.CAE002 = '1'	AND D.CAB016 = '1' UNION ALL SELECT 'IX0019' FROM DUAL) ");
		 sql.append(" AND B.AAC001 = ? and b.aae001 like '"+now_date+"%'");
		 PensionVO pensionVO=CommonJdbcUtils.queryFirst(sql.toString(), PensionVO.class,retireResignQueryVO.getAac001());
		 return pensionVO.getAae019sum();
	 }
	 /**
	  * 本次调待前月养老金合计 
	  * @param retireResignQueryVO
	  * @return
	  */
	 public BigDecimal getAllPensionSum(RetireResignQueryVO retireResignQueryVO){
		 StringBuffer sql = new StringBuffer();
		 Date nowDate=new Date();
		 java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy");
		 String now_date=format.format(nowDate);
		 Long now_date1=Long.parseLong(now_date)*100+4;
		 sql.append("SELECT  SUM(A.AAE019) AAE019SUM FROM qdyth.AC61@qdweb_jx A, qdyth.IC70@qdweb_jx B, qdyth.AA17@qdweb_jx C");
		 sql.append(" WHERE A.AAE042 = 999999 AND A.AAZ257 = B.AAZ257 AND A.AAA036 = C.AAA036 AND A.AAE041 <= "+now_date1+"	 AND C.AAA037 NOT LIKE '"+now_date+"%'	 AND AAE116 =b.cae110  AND A.AAE100 = '1'  AND A.CAE021 IS NULL");
		// sql.append(" AND A.AAA036 IN (SELECT D.AAA036 FROM qdyth.AA18@qdweb_jx D WHERE D.AAB301 = B.AAB301	AND D.AAE140 = '110' AND D.CAE002 = '1'	AND D.CAB016 = '1') ");
		 sql.append(" AND B.AAC001 = ? and b.aae001 like '"+now_date+"%'");
		 PensionVO pensionVO=CommonJdbcUtils.queryFirst(sql.toString(), PensionVO.class,retireResignQueryVO.getAac001());
		 return pensionVO.getAae019sum();
	 }
	 /**
	  * 月基本养老待遇 
	  * @param retireResignQueryVO
	  * @return
	  */
	 public List<PensionVO> getPensionList(RetireResignQueryVO retireResignQueryVO){
		 StringBuffer sql = new StringBuffer();
		 Date nowDate=new Date();
		 java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy");
		 String now_date=format.format(nowDate);
		 Long now_date1=Long.parseLong(now_date)*100+4;
		 sql.append("SELECT  C.AAA037, A.AAE041, A.AAE019 FROM qdyth.AC61@qdweb_jx A, qdyth.IC70@qdweb_jx B, qdyth.AA17@qdweb_jx C");
		 sql.append(" WHERE A.AAE042 = 999999 AND A.AAZ257 = B.AAZ257 AND A.AAA036 = C.AAA036 AND A.AAE041 <= "+now_date1+"	 AND C.AAA037 NOT LIKE '"+now_date+"%'	 AND AAE116 =b.cae110  AND A.AAE100 = '1'  AND A.CAE021 IS NULL");
		 sql.append(" AND A.AAA036 IN (SELECT D.AAA036 FROM qdyth.AA18@qdweb_jx D WHERE D.AAB301 = B.AAB301	AND D.AAE140 = '110' AND D.CAE002 = '1'	AND D.CAB016 = '1' UNION ALL SELECT 'IX0019' FROM DUAL) ");
		 sql.append(" AND B.AAC001 = ? and b.aae001 like '"+now_date+"%'");
		 List<PensionVO> list=CommonJdbcUtils.query(sql.toString(), PensionVO.class,retireResignQueryVO.getAac001());
		 return list;
	 }
	 /**
	  * 月基本养老外待遇
	  * @param retireResignQueryVO
	  * @return
	  */
	 public List<PensionVO> getExcPensionList(RetireResignQueryVO retireResignQueryVO){
		 StringBuffer sql = new StringBuffer();
		 Date nowDate=new Date();
		 java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy");
		 String now_date=format.format(nowDate);
		 Long now_date1=Long.parseLong(now_date)*100+4;
		 sql.append("SELECT  C.AAA037, A.AAE041, A.AAE019 FROM qdyth.AC61@qdweb_jx A, qdyth.IC70@qdweb_jx B, qdyth.AA17@qdweb_jx C");
		 sql.append(" WHERE A.AAE042 = 999999 AND A.AAZ257 = B.AAZ257 AND A.AAA036 = C.AAA036 AND A.AAE041 <="+now_date1+"  AND C.AAA037 NOT LIKE '"+now_date+"%' AND AAE116 =b.cae110  AND A.AAE100 = '1'  AND A.CAE021 IS NULL");
		 sql.append(" AND A.AAA036 NOT IN (SELECT D.AAA036 FROM qdyth.AA18@qdweb_jx D WHERE D.AAB301 = B.AAB301	AND D.AAE140 = '110' AND D.CAE002 = '1'	AND D.CAB016 = '1' UNION ALL SELECT 'IX0019' FROM DUAL) ");
		 sql.append(" AND B.AAC001 = ? and b.aae001 like '"+now_date+"%'");
		 List<PensionVO> list=CommonJdbcUtils.query(sql.toString(), PensionVO.class,retireResignQueryVO.getAac001());
		 return list;
	 }
}
