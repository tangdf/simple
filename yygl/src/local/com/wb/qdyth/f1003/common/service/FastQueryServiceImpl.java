package com.wb.qdyth.f1003.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.wb.jdbcutils.CommonJdbcUtils;
import com.wb.jdbcutils.Page;
import com.wb.qdyth.common.service.CommonService;
import com.wb.qdyth.f1003.common.vo.DbyljzcxVo;
import com.wb.qdyth.f1003.common.vo.GsrdcxVo;
import com.wb.qdyth.f1003.common.vo.JdcjcxVo;
import com.wb.qdyth.f1003.common.vo.JdzscxVo;
import com.wb.qdyth.f1003.common.vo.JmylbxQueryVO;
import com.wb.qdyth.f1003.common.vo.KscxYBVo;
import com.wb.qdyth.f1003.common.vo.LdnljdcxVo;
import com.wb.qdyth.f1003.common.vo.LgscxVo;




/**
 * 快速信息查询公用Service
 * @author xue
 * 2015-9-25
 */
public class FastQueryServiceImpl implements FastQueryService {
	
	private CommonService commonService;

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	/**
	 * 居民医疗保险信息查询 
	 * @return
	 */
  public void queryJmylxx(Page page,Long aac001,String aac002){
	  StringBuffer sb=new StringBuffer();
	  sb.append("SELECT *                                                                                                      ");
	  sb.append("  FROM (SELECT AC01.AAC001 AAC001,                                                                            ");
	  sb.append("               AC01.AAC003 AAC003,                                                                            ");
	  sb.append("               AC01.AAC147 AAC002,                                                                            ");
	  sb.append("               AB01.AAB004 AAB004,                                                                            ");
	  sb.append("               RC10.AAE001 AAE002,                                                                            ");
	  sb.append("               RC10.AAE041 AKC231,                                                                            ");
	  sb.append("               RC10.AAE042 AKC232,                                                                            ");
	  sb.append("               DECODE(RC10.CAE414, '1', '正常缴费', '2', '补收', '3', '退收') AAE143,                         ");
	  sb.append("               RC10.CAE415 RAC122,                                                                            ");
	  sb.append("               TO_CHAR(RC10.CAE372, 'yyyy-mm-dd') AAE039,                                                     ");
	  sb.append("               DECODE(RC10.CAE371, '0', '未到帐', '1', '已到帐') CAE371,                                      ");
	  sb.append("               (SELECT aaa146 FROM qdyth.aa26@qdweb_jx WHERE aab301=RC10.CAE409) RAC050,                      ");
	  sb.append("               TO_CHAR(RC10.CAE405, 'yyyy-mm-dd') AAE038,                                                     ");
	  sb.append("               (SELECT aaa103 FROM qdyth.aa10@qdweb_jx WHERE aaa100='CAE346' AND aaa102=rc10.cae346) AAC016   ");
	  sb.append("          FROM QDYTH.AC01@QDWEB_JX, QDYTH.AB01@QDWEB_JX, QDYTH.RC10@QDWEB_JX                                  ");
	  sb.append("         WHERE (AC01.AAC001 = RC10.AAC001)                                                                    ");
	  sb.append("           AND (AB01.AAB001 = RC10.AAB001)                                                                    ");
	  sb.append("           AND (NVL(RC10.AAE100, '1') = '1'))                                                                 ");
	  sb.append(" WHERE 1 = 1                                                                ");
	  List<Object> list=new ArrayList<Object>();
	  if(aac001!=null) {
		  sb.append(" and aac001=?");
		  list.add(aac001);
	  }
	  if( StringUtils.hasText(aac002)) {
		  sb.append(" and aac002=?");
		  list.add(aac002);
	  }
	  CommonJdbcUtils.queryPageNT(page,sb.toString(),JmylbxQueryVO.class,list.toArray());
  }
  /**
   * 鉴定成绩查询
   */
  public JdcjcxVo queryJdcjcxVo(String sfzh, String code){
		String sql = "select * from webm_cjcx where sfzh=? and code=?";
		JdcjcxVo jdcjcx = CommonJdbcUtils.queryFirst(sql, JdcjcxVo.class, sfzh, code);
		return jdcjcx;
	}
  /**
   * 鉴定成绩查询
   */
  public JdzscxVo queryJdzscxVo(String cardcode, String name){
		String sql = "select * from webm_kscj where cardcode=? and name=?";
		JdzscxVo jdzscxVo = CommonJdbcUtils.queryFirst(sql, JdzscxVo.class, cardcode, name);
		return jdzscxVo;
	}
	/**
	 * 工伤认定查询 
	 * @return
	 */
public void queryGsrdcx(Page page,Long aac001,String aac003){
	StringBuffer sb=new StringBuffer();
	sb.append("select decode(e.alc021,'1','伤残','2','死亡','3','职业病') as alc021,b.aac003,c.aab004,e.alc031, decode(e.ala015,'1','认定工伤','2','视同工伤','3','不予认定工伤','4','不予视同工伤','5','认定终止')  as ala015, e.aaz127,e.clz025,f.aab301,decode(f.clc207,'10','待受理','11','不予受理','12','已受理') as clc207, decode(alc022,null,n.aae013,(select aaa103 from qdyth.aa10@qdweb_jx m where m.aaa100='ALC022' and n.alc022=m.aaa102 )||'|'||n.aae013) alc022  " +
			"FROM qdyth.ac01@qdweb_jx b,qdyth.ab01@qdweb_jx c,qdyth.lc36@qdweb_jx n,qdyth.lc31@qdweb_jx e,qdyth.lc33@qdweb_jx f " +
			"WHERE e.aac001 = b.aac001 and e.aab001 = c.aab001 and e.aaz128 = f.aaz128 and  f.aae100 = '1' and e.clc200='1'  and n.aaz127(+) = e.aaz127 ") ;
	  List<Object> list=new ArrayList<Object>();
	  if(aac001!=null) {
		  sb.append(" and b.aac001=?");
		  list.add(aac001);
	  }
	  if( StringUtils.hasText(aac003)) {
		  sb.append(" and b.aac003=?");
		  list.add(aac003);
	  }
	  CommonJdbcUtils.queryPageNT(page,sb.toString(),GsrdcxVo.class,list.toArray());
}
/**
 * 劳动能力鉴定查询
 * @param aac002
 */
public void queryLdnljdcx(Page page,String aac002){
	StringBuffer queryQL=new StringBuffer();
	queryQL.append("select a.aac003,b.aab004,c.clc071 alc034,c.cle045,decode(c.ala019,'1','工伤（职业病）劳动能力鉴定','2','工伤相关项目鉴定','3','职工因病或非因工负伤劳动能力程度的鉴定','4','椎间盘突出症性质鉴定') as ala019,");
	queryQL.append("decode(c.clc090,'01','伤残壹级','02','伤残贰级','03','伤残叁级','04','伤残肆级','05','伤残伍级','06','伤残陆级','07','伤残柒级','08','伤残捌级','09','伤残玖级','10','伤残拾级','11','未达等级','12','符合完全丧失劳动能力的标准','13','符合大部分丧失劳动能力的标准','14','未达到部颁鉴定标准') as clc090,");
	queryQL.append("decode(c.ala040,'01','伤残壹级','02','伤残贰级','03','伤残叁级','04','伤残肆级','05','伤残伍级','06','伤残陆级','07','伤残柒级','08','伤残捌级','09','伤残玖级','10','伤残拾级','11','未达等级') as ala040,d.clc019,d.clc020 from ");
	queryQL.append("qdyth.ac01@qdweb_jx a,");
	queryQL.append("qdyth.ab01@qdweb_jx b,");
	queryQL.append("qdyth.lc03@qdweb_jx c, ");
	queryQL.append("qdyth.lc75@qdweb_jx d ");
	queryQL.append("where a.aac001=c.aac001 and b.aab001=c.aab001 and c.clz091=d.clz091(+) and c.clc090 is not null  and c.alc034 is not null");
	List<Object> list=new ArrayList<Object>();
	if(StringUtils.hasText(aac002)){
		queryQL.append(" and a.aac147 = ? and c.clc071<=to_char(sysdate,'yyyymmdd')");
		list.add(aac002);
	}else{
		queryQL.append(" and  c.clc071<= to_char(sysdate,'yyyymmdd') and c.clc071>=to_char(sysdate-10,'yyyymmdd')");
	}
	queryQL.append(" order by c.clc071 desc, a.aac001 desc");
	 CommonJdbcUtils.queryPageNT(page,queryQL.toString(),LdnljdcxVo.class,list.toArray());
}
/**
 * 大病医疗救助信息查询
 */
public void queryDbyljzcx(Page page,String aac002,String aac001){
	StringBuffer sb=new StringBuffer();
	sb.append("SELECT (SELECT CKB104 FROM QDYTH.KB01@QDWEB_JX WHERE AKB020 = A.AKB020) AS CKB104,");
	sb.append("       (SELECT AAA103                                                             ");
	sb.append("          FROM QDYTH.AA10@QDWEB_JX                                                ");
	sb.append("         WHERE AAA102 = A.CKC022                                                  ");
	sb.append("           AND AAA100 = 'CKC022') AS CKC022,                                      ");
	sb.append("       B.CKE012,                                                                  ");
	sb.append("       B.AAE030,                                                                  ");
	sb.append("       B.AAE031,                                                                  ");
	sb.append("       A.AKC264,                                                                  ");
	sb.append("       A.AKE039,                                                                  ");
	sb.append("       A.AKE029,                                                                  ");
	sb.append("       NVL(A.AKE038, 0) AS AKE038,                                                ");
	sb.append("       (NVL(A.AKC253, 0) + NVL(A.AKC254, 0)) AS GRXJZF,                           ");
	sb.append("       (NVL(A.AKE035, 0) + NVL(A.AKE103, 0)) AS BZBTZC,                           ");
	sb.append("       NVL(A.CKC070, 0) AS CKC070,                                                ");
	sb.append("       NVL(A.AKE101, 0) + NVL(A.AKE102, 0) - NVL(A.CKC070, 0) AKC266,             ");
	sb.append("       NVL(A.AKC253, 0) AS AKC253,                                                ");
	sb.append("       A.AAC001,                                                                  ");
	sb.append("       (CASE                                                                      ");
	sb.append("         WHEN A.CKE260 < DATE '2013-02-20' THEN                                   ");
	sb.append("          '过渡期第一批救助'                                                      ");
	sb.append("         WHEN A.CKE260 >= DATE '2013-02-20' AND A.CKE260 < DATE                   ");
	sb.append("          '2013-03-20' + 1 THEN                                                   ");
	sb.append("          '过渡期第二批救助'                                                      ");
	sb.append("         WHEN A.CKE260 >= DATE '2013-03-21' THEN                                  ");
	sb.append("          '过渡期第三批救助'                                                      ");
	sb.append("         ELSE                                                                     ");
	sb.append("          '过渡期救助'                                                            ");
	sb.append("       END) AS AKA030,                                                            ");
	sb.append("       DECODE(A.AKA030,                                                           ");
	sb.append("              '51002',                                                            ");
	sb.append("              DECODE(C.AAZ267,                                                    ");
	sb.append("                     '370200',                                                    ");
	sb.append("                     '青岛市社会保险事业局',                                      ");
	sb.append("                     '370202',                                                    ");
	sb.append("                     '市社会保险事业局市南分局',                                  ");
	sb.append("                     '370203',                                                    ");
	sb.append("                     '市社会保险事业局市北分局',                                  ");
	sb.append("                     '370205',                                                    ");
	sb.append("                     '市社会保险事业局四方分局',                                  ");
	sb.append("                     '370213',                                                    ");
	sb.append("                     '市社会保险事业局李沧分局',                                  ");
	sb.append("                     '370214',                                                    ");
	sb.append("                     '城阳区医疗保险管理中心',                                    ");
	sb.append("                     '370212',                                                    ");
	sb.append("                     '崂山区社会保险服务大厅',                                    ");
	sb.append("                     '370211',                                                    ");
	sb.append("                     '青岛经济技术开发区社会保障事业管理中心',                    ");
	sb.append("                     '370282',                                                    ");
	sb.append("                     '即墨市医疗保险管理中心',                                    ");
	sb.append("                     '370283',                                                    ");
	sb.append("                     '平度市医疗保险管理中心',                                    ");
	sb.append("                     '370285',                                                    ");
	sb.append("                     '莱西市医疗保险管理中心',                                    ");
	sb.append("                     '370281',                                                    ");
	sb.append("                     '胶州市医疗保险管理中心',                                    ");
	sb.append("                     '370284',                                                    ");
	sb.append("                     '原胶南市医疗保险管理中心'),                                 ");
	sb.append("              NULL) AS AAZ267,                                                    ");
	sb.append("       NVL(A.CKE412, 0) AS CKE412,                                                ");
	sb.append("       NVL(A.CKE413, 0) AS CKE413,                                                ");
	sb.append("       NVL(A.CKE414, 0) AS CKE414,                                                ");
	sb.append("       NVL(A.CKE415, 0) AS CKE415,                                                ");
	sb.append("       NVL(A.CKE412, 0) + NVL(A.CKE413, 0) + NVL(A.CKE414, 0) +                   ");
	sb.append("       NVL(A.CKE415, 0) AS JZZF,                                                  ");
	sb.append("       G.AAC003 AS AAC003                                                         ");
	sb.append("  FROM QDYTH.KC12@QDWEB_JX A,                                                     ");
	sb.append("       QDYTH.KC14@QDWEB_JX B,                                                     ");
	sb.append("       QDYTH.KC62@QDWEB_JX C,                                                     ");
	sb.append("       QDYTH.AC01@QDWEB_JX G                                                      ");
	sb.append(" WHERE A.CKA009 = B.CKA009(+)                                                     ");
	sb.append("   AND A.CKC016 = C.CKC016(+)                                                     ");
	sb.append("   AND A.AAC001 = G.AAC001                                                        ");
	sb.append("   AND NVL(B.CKC009, '1') = '1'                                                   ");
	sb.append("   AND A.CKC009 = '1'                                                             ");
	sb.append("   AND A.AKA030 = '51002'                                                         ");
	sb.append("   AND A.CKC016 NOT IN                                                            ");
	sb.append("       (SELECT D.CKC016                                                           ");
	sb.append("          FROM QDYTH.KC12@QDWEB_JX D,                                             ");
	sb.append("               QDYTH.KC14@QDWEB_JX E,                                             ");
	sb.append("               QDYTH.KC62@QDWEB_JX F                                              ");
	sb.append("         WHERE D.CKA009 = E.CKA009(+)                                             ");
	sb.append("           AND D.CKC016 = F.CKC016(+)                                             ");
	sb.append("           AND NVL(E.CKC009, '1') = '1'                                           ");
	sb.append("           AND D.CKC009 = '1'                                                     ");
	sb.append("           AND D.AKA030 = '51002'                                                 ");
	sb.append("           AND D.AAC001 = A.AAC001                                                ");
	sb.append("           AND NVL(F.CKE412, 0) + NVL(F.CKE413, 0) + NVL(F.CKE414, 0) +           ");
	sb.append("               NVL(F.CKE415, 0) <= 100)                                           ");
	List<Object> list=new ArrayList<Object>();
	if(StringUtils.hasText(aac002)){
		sb.append("   AND G.AAC147 = ?    ");
		list.add(aac002);
	}
	if(StringUtils.hasText(aac001)){
		sb.append("   AND a.AAC001 = ?    ");
		list.add(aac001);
	}
	CommonJdbcUtils.queryPage(page, sb.toString(), DbyljzcxVo.class, list.toArray());
}
/**
 * 老工伤查询
 */
	public void queryLgscx(Page page,String aac147){
		String sql="SELECT A.AAC003,B.ALC020,DECODE(B.CLC200, '1', '新工伤', '0', '老工伤') AS CLC200" +
				" FROM QDYTH.AC01@QDWEB_JX A, QDYTH.LC31@QDWEB_JX B WHERE A.AAC001 = B.AAC001" +
				" AND B.CLC200 = '0'";
		if(StringUtils.hasText(aac147)){
			sql=sql+" and a.aac147=? and b.alc031<=to_char(sysdate,'yyyymmdd')";
			CommonJdbcUtils.queryPage(page, sql, LgscxVo.class, aac147);
		}else{
			sql=sql+" and b.alc031>=to_char(sysdate-10,'yyyymmdd')";
			CommonJdbcUtils.queryPage(page, sql, LgscxVo.class);
		}
	}
	/**
	 * 职业介绍机构查询
	 */
	public void queryZyjsjjcx(Page page,String cxtj1,String cxtj2,String cxtj3){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("SELECT a.fname, decode(a.fboroughid,'37020100','市南区','37020200','市北区','37020300','四方区','37020400','李沧区','37020500','黄岛区','37020600','崂山区','37020700','城阳区',"+
				"'37020800','胶州市','37020900','胶南市','37021000','平度市','37021100','即墨市','37021200','莱西市','其他') fboroughid, a.ftel, a.faddr ");
		queryQL.append("FROM jorga_info a WHERE 1=1 ");
		List<Object> list=new ArrayList<Object>();
		if(StringUtils.hasText(cxtj1)){
			queryQL.append(" and a.fname like ? ");
			list.add("%"+cxtj1+"%");
		}
		if(StringUtils.hasText(cxtj2)){
			queryQL.append("and a.fboroughid=? ");
			list.add(cxtj2);
		}
		if(StringUtils.hasText(cxtj3)){
			queryQL.append(" and a.faddr like ? ");
			list.add("%"+cxtj3+"%");
		}
		queryQL.append(" order by fboroughid");
		CommonJdbcUtils.queryPage(page, queryQL.toString(), KscxYBVo.class,list.toArray());
	}
	/**
	 * 医疗保险药品目录
	 */
	public void queryYlbxMlcx(Page page,String cxtj1,String cxtj2,String cxtj3){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select * from(SELECT cke100,aka061,(select cke275 from qdyth.ke31@qdweb_jx where  ckz079=aka070 ) aka070,cke101," +
				"(case when substr(ckc064, 3, 1)=1 then '可用' when substr(ckc064, 3, 1)=0  then '不可用' else '' end) as ckc064,(select aaa103 from qdyth.aa10@qdweb_jx where aaa100='CKE154' and aaa102=cke154 ) cke154," +
				"cke121,cke110,nvl(to_char(aae031),' ') aae031," +
				"aka074,(case when aka069 is null then '' else cast(aka069*100 as varchar2(20))||'%' end) aka069,aka020," +
				"aae030, (case when substr(cke148,1,1)=1 then '职工' else '' end)||"+
				"(case when substr(cke148,1,1)=1 then ',农民工门诊' else '' end)||"+
				"(case when substr(cke148,1,1)=1 then ',公务员' else '' end)||"+
				"(case when substr(cke148,1,1)=1 then ',保健对象' else '' end)||"+
              	"(case when substr(cke148,1,1)=1 then ',离休' else '' end)||"+
              	"(case when substr(cke148,1,1)=1 then ',副司级离休' else '' end)||"+
              	"(case when substr(cke148,1,1)=1 then ',居民' else '' end)||"+
              	"(case when substr(cke148,1,1)=1 then ',儿童' else '' end) cke148" +
				" from qdyth.ka02@qdweb_jx a) where 1=1");
		List<Object> list=new ArrayList<Object>();
		if(StringUtils.hasText(cxtj1)){
			if(StringUtils.hasText(cxtj3) && cxtj3.equals("1")){
				if(cxtj1.equals("1")){
					queryQL.append(" and  cke101 like ? ");
					list.add("%"+cxtj2+"%");
				}else{
					queryQL.append(" and  aka061 like ? ");
					list.add("%"+cxtj2+"%");
				}
			}else if(StringUtils.hasText(cxtj3) && cxtj3.equals("2")){
				//拼音码的情况
				if(cxtj1.equals("1")){
					queryQL.append(" and  aka020 like ? ");
					list.add("%"+cxtj2.toUpperCase()+"%");
				}
			}
		}
		queryQL.append(" order by  aae030 desc ,aka061 desc ");
		CommonJdbcUtils.queryPage(page, queryQL.toString(), KscxYBVo.class,list.toArray());
	}
	/**
	 * 定点医院药房查询 
	 */
	public void queryDdyyyfcx(Page page,String cxtj1){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select * from(select ckb104,ckb106,(select aaa103 from qdyth.aa10@qdweb_jx where aaa100='AKA101' and aaa102=aka101 ) aka101 " +
				"from qdyth.kb01@qdweb_jx )where 1=1");
		List<Object> list=new ArrayList<Object>();
		if(StringUtils.hasText(cxtj1)){
			queryQL.append(" and ckb104 like ? ");
			list.add("%"+cxtj1+"%");
		}
		queryQL.append("order by aka101,ckb104");
		CommonJdbcUtils.queryPage(page, queryQL.toString(), KscxYBVo.class,list.toArray());
	}
	/**
	 * 诊疗项目及服务设施查询
	 */
	public void queryZlxmfwsscx(Page page,String cxtj1,String cxtj2){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select * from (select cke125,cke126,aka020,cke121,cke110,nvl(to_char(aae031),' ') aae031," +
				"(case when aka069 is null then '' else cast(aka069*100 as varchar2(20))||'%' end) aka069,(case when substr(ckc064, 3, 1)=1 then '可用' when substr(ckc064, 3, 1)=0  then '不可用' else '' end) as ckc064," +
				"aae013,aae030,(select aaa103 from qdyth.aa10@qdweb_jx where aaa100 = 'CKE154' and aaa102=a.cke154) as cke154," +
				"(case when substr(cke148,1,1)=1 then '职工' else '' end)||"+
				"(case when substr(cke148,1,1)=1 then ',农民工门诊' else '' end)||"+
				"(case when substr(cke148,1,1)=1 then ',公务员' else '' end)||"+
				"(case when substr(cke148,1,1)=1 then ',保健对象' else '' end)||"+
              	"(case when substr(cke148,1,1)=1 then ',离休' else '' end)||"+
              	"(case when substr(cke148,1,1)=1 then ',副司级离休' else '' end)||"+
              	"(case when substr(cke148,1,1)=1 then ',居民' else '' end)||"+
              	"(case when substr(cke148,1,1)=1 then ',儿童' else '' end) cke148" + 
				" from qdyth.ka03@qdweb_jx a) where 1=1 ");
		List<Object> list=new ArrayList<Object>();
		if(StringUtils.hasText(cxtj1)){
			if(StringUtils.hasText(cxtj2) && cxtj2.equals("1")){
				queryQL.append(" and cke126 like ? ");
				list.add("%"+cxtj1+"%");
			}else if(StringUtils.hasText(cxtj2) && cxtj2.equals("2")){
				queryQL.append(" and aka020 like ? ");
				list.add("%"+cxtj1.toUpperCase()+"%");
			}
		}
		queryQL.append(" order by aae030 desc,cke126");
		CommonJdbcUtils.queryPage(page, queryQL.toString(), KscxYBVo.class,list.toArray());
	}
	/**
	 * 病种目录查询
	 */
	public void queryBzmlcx(Page page,String cxtj1,String cxtj2){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("SELECT * from (select aka120,aka121, aka122,"+
			      "(select AAA103 from qdyth.aa10@qdweb_jx where aaa100 = 'CKE146' AND AAA102 = KA06.cke146) cke146,aka020,"+
			      "aae030,nvl(to_char(aae031),' ') aae031 from qdyth.ka06@qdweb_jx) where 1=1 ");
		List<Object> list=new ArrayList<Object>();
		if(StringUtils.hasText(cxtj1)){
			if(StringUtils.hasText(cxtj2) && cxtj2.equals("1")){
				queryQL.append(" and aka121 like ? ");
				list.add("%"+cxtj1+"%");
			}else if(StringUtils.hasText(cxtj2) && cxtj2.equals("2")){
				queryQL.append(" and aka020 like ? ");
				list.add("%"+cxtj1.toUpperCase()+"%");
			}
		}
		queryQL.append(" order by aae030 desc,aka121");
		CommonJdbcUtils.queryPage(page, queryQL.toString(), KscxYBVo.class,list.toArray());
	}
	/**
	 * 生育病种查询
	 */
	public void querySybzcx(Page page,String cxtj1,String cxtj2){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("SELECT * from (select aka120,aka121, aka122,"+
			      "(select AAA103 from qdyth.aa10@qdweb_jx where aaa100 = 'CKE146' AND AAA102 = KA06.cke146) cke146,aka020,"+
			      "aae030,nvl(to_char(aae031),' ') aae031 from qdyth.ka06@qdweb_jx where cke146='8') where 1=1 ");
		List<Object> list=new ArrayList<Object>();
		if(StringUtils.hasText(cxtj1)){
			if(StringUtils.hasText(cxtj2) && cxtj2.equals("1")){
				queryQL.append(" and aka121 like ? ");
				list.add("%"+cxtj1+"%");
			}else if(StringUtils.hasText(cxtj2) && cxtj2.equals("1")){
				queryQL.append(" and aka020 like ? ");
				list.add("%"+cxtj1.toUpperCase()+"%");
			}
		}
		queryQL.append(" order by aae030 desc,aka121");
		CommonJdbcUtils.queryPage(page, queryQL.toString(), KscxYBVo.class,list.toArray());
	}
	/**
	 * 生育医疗机构查询
	 */
	public void querySyyljjcx(Page page,String cxtj1){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select * from(select ckb104,ckb106,('')as aae005,(select aaa103 from qdyth.aa10@qdweb_jx where aaa100='AKA101' and aaa102=aka101 ) aka101 " +
				"from qdyth.kb01@qdweb_jx where substr(ckc064,3,1)='1') where 1=1");
		List<Object> list=new ArrayList<Object>();
		if(StringUtils.hasText(cxtj1)){
			queryQL.append(" and ckb104 like ? ");
			list.add("%"+cxtj1+"%");
		}
		queryQL.append("order by aka101,ckb104");
		CommonJdbcUtils.queryPage(page, queryQL.toString(), KscxYBVo.class,list.toArray());
	}
	/**
	 * 医保耗材查询
	 */
	public void queryYbhccx(Page page,String cxtj1,String cxtj2){
		StringBuffer queryQL=new StringBuffer();
		queryQL.append("select * from (select a.cke125,a.cke126,a.aka069,a.cke108,(select aaa103 from aa10 where aaa100 = 'CKE154' and aaa102 = a.cke154) cke154, a.aae030,"+
				  " a.aae031,a.aae013,decode(substr(a.cke148, 1, 1), '1', '职工 | ', '') ||decode(substr(a.cke148, 2, 1), '1', '农民工门诊 | ', '') ||"+
				  " decode(substr(a.cke148, 3, 1), '1', '公务员 | ', '') ||decode(substr(a.cke148, 4, 1), '1', '保健对象 | ', '') ||"+
				  " decode(substr(a.cke148, 5, 1), '1', '离休 | ', '') ||decode(substr(a.cke148, 6, 1), '1', '副司级离休 | ', '') ||"+
				  " decode(substr(a.cke148, 7, 1), '1', '居民 | ', '') ||decode(substr(a.cke148, 8, 1), '1', '儿童 | ', '') cke148,"+
				  " decode(substr(a.ckc064, 3, 1), '1', '有', '无' ) ckc064 " );
			queryQL.append(" from qdyth.ka03@qdweb_jx  a where a.cke106 in ('24', '27') and ckc009 = '1') where 1=1  ");
		List<Object> list=new ArrayList<Object>();
		if(StringUtils.hasText(cxtj1)){
			queryQL.append(" and cke126 like ? ");
			list.add("%"+cxtj1+"%");
		}
		if(StringUtils.hasText(cxtj2)){
			queryQL.append(" and cke125=  ?  ");
			list.add(cxtj2);
		}
		CommonJdbcUtils.queryPage(page, queryQL.toString(), KscxYBVo.class,list.toArray());
	}
}
