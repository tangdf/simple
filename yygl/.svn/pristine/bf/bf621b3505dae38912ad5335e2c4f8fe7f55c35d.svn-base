package com.wb.qdyth.f1002.common.service;

import com.wb.jdbcutils.CommonJdbcUtils;
import com.wb.jdbcutils.Page;
import com.wb.qdyth.common.service.CommonService;
import com.wb.qdyth.f1002.common.vo.PersonBaseQueryVO;




/**
 * 居民养老查询公用Service
 * @author xue
 * 2015-9-25
 */
public class JmylServiceImpl implements JmylService {
	
	private CommonService commonService;
	/**
	 * 查询人员基本信息
	 * @return
	 */
	public PersonBaseQueryVO queryUserInfo(String aac001){
		StringBuffer sb =new StringBuffer();
		sb.append("select a.aac001,a.aac002,a.aac003,decode(a.aac004,'1','男','2','女') as aac004,(select aaa103 from aa10 where aaa100='AAC005' and aaa102=a.aac005) aac005,a.aac006,a.aac010,a.aae006,(select aaa103 from aa10 where aaa100='AAC009' and aaa102=a.aac009) aac009   ");
		sb.append(" FROM AC01_XNB a where a.aac001=? ");
		return CommonJdbcUtils.queryFirst(sb.toString(), PersonBaseQueryVO.class, aac001);
	}
	/**
	 * 个人账户查询
	 * @return
	 */
	public void queryAccountInfo(Page page,String aac001){
		StringBuffer queryQL =new StringBuffer();
		queryQL.append("SELECT A.AAC002,A.AAC003,(c.cae400+c.cae404) as AAE238,(c.cae401+c.cae405+ c.cae403+c.cae407) AS czbtljje,(c.cae402+c.cae406) as jtjfje,C.AAE240 ");
		queryQL.append("FROM AC01_XNB A, AC50_XNB C WHERE A.AAC001 = C.AAC001 ");
		queryQL.append(" and a.aac001 = ?");
		queryQL.append(" order by A.AAC002 desc ");
		CommonJdbcUtils.queryPageNT(page,queryQL.toString(), PersonBaseQueryVO.class, aac001);
	}
	/**
	 * 待遇项目查询（账户）
	 * @param aac001
	 * @return
	 */
	public PersonBaseQueryVO queryJmylAccountInfo(String aac001){
		StringBuffer sb =new StringBuffer();
		sb.append("SELECT a.aac002,a.aac003,(C.CAE400 + C.CAE404) AS grjfye FROM AC01_XNB A, AC50_XNB C ");
		sb.append(" WHERE A.AAC001 = C.AAC001 AND A.AAC001 = ? ");
		return CommonJdbcUtils.queryFirst(sb.toString(), PersonBaseQueryVO.class, aac001);
	}
	/**
	 * 待遇项目查询
	 * @return
	 */
	public void queryWealthInfo(Page page,String aac001){
		StringBuffer queryQL =new StringBuffer();
		queryQL.append("SELECT C.AIC160, F.AAA037, D.AAE041, DECODE(D.AAE042, '999912', null, D.AAE042) as aae042, D.AAE211,d.aae019 FROM AC01_XNB A, AC60_XNB C, AC61_XNB D, AA17_XNB F ");
		queryQL.append(" WHERE A.AAC001 = C.AAC001 AND C.AAZ257 = D.AAZ257 AND F.AAA027 = '370200' AND D.AAA036 = F.AAA036  ");
		queryQL.append(" and a.aac001 = ?");
		queryQL.append(" order by D.aae041 desc ");
		CommonJdbcUtils.queryPageNT(page,queryQL.toString(), PersonBaseQueryVO.class, aac001);
	}
	/**
	 * 查询缴费档次
	 * @param aac001
	 * @return
	 */
	public PersonBaseQueryVO queryJmylJfInfo(String aac001){
		StringBuffer sb =new StringBuffer();
		sb.append("SELECT A.AAC002,A.AAC003 ,(SELECT D.AAA044 FROM AA05_XNB D ");
		sb.append("WHERE C.AAZ289 = D.AAZ289 AND AAA027 = '370200') AS dnjfdc ");
		sb.append("FROM AC01_XNB A, AC20_XNB C WHERE A.AAC001 = C.AAC001 AND A.AAC001 = ? ");
		return CommonJdbcUtils.queryFirst(sb.toString(), PersonBaseQueryVO.class, aac001);
	}
	/**
	 * 缴费信息查询
	 * @return
	 */
	public void queryPayStautsInfo(Page page,String aac001){
		StringBuffer queryQL =new StringBuffer();
		queryQL.append("SELECT A.AAC002 ,A.AAC003,SUM(DECODE(C.AAE341, '1', C.AAE022, 0)) AS GRJFJE ,AAE002,AAE003,");
		queryQL.append(" SUM(DECODE(C.AAE341, '4', C.AAE022, '8', C.AAE022, 0)) AS CZBTJE,sum(decode(c.aae341, '6', c.aae022, '7', c.aae022, 0))as jtjfje,AAE079   ");
		queryQL.append(" FROM Ac01_Xnb A, AC43_xnb C WHERE A.AAC001 = C.AAC001 AND C.AAE078 IN ('1', '8') ");
		queryQL.append(" and a.aac001 = ?");
		queryQL.append("  GROUP BY AAE002, AAE079,AAC002,AAC003,AAE003 order by aae003");
		CommonJdbcUtils.queryPageNT(page,queryQL.toString(), PersonBaseQueryVO.class, aac001);
	}
	/**
	 * 待遇发放查询
	 * @return
	 */
	public void queryTreatDetailInfo(Page page,String aac001){
		StringBuffer queryQL =new StringBuffer();
		queryQL.append("select a.aac001,a.aae002,a.aae019,b.aac003 ");
		queryQL.append("from AC82_XNB a, AC01_XNB b where a.aac001=b.aac001 ");		
		queryQL.append(" and a.aac001 = ?");
		queryQL.append(" order by aae002 desc");
		CommonJdbcUtils.queryPageNT(page,queryQL.toString(), PersonBaseQueryVO.class, aac001);
	}
	public CommonService getCommonService() {
		return commonService;
	}
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
}
