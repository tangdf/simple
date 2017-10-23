package com.wb.qdyth.f1001.f100109.vs;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.wb.contain.listener.model.APPAA10;
import com.wb.exceptions.BusinessException;
import com.wb.jdbcutils.CommonJdbcUtils;
import com.wb.jdbcutils.Page;
import com.wb.qdyth.common.service.CommonService;
import com.wb.qdyth.f1001.common.vo.UserVO;
import com.wb.qdyth.f1001.f100109.utils.BankCallUtils;
import com.wb.qdyth.f1001.f100109.utils.BankInterfaceUtils;
import com.wb.qdyth.f1001.f100109.utils.BankRetInfoUtils;
import com.wb.qdyth.f1001.f100109.vo.Kc02;
import com.wb.qdyth.f1001.f100109.vo.LsgsPrcDTO;
import com.wb.qdyth.f1001.f100109.vo.PersonQueryVO;
import com.wb.qdyth.f1001.f100109.vo.Psbank;
import com.wb.qdyth.f1001.f100109.vo.RetCodeDTO;
import com.wb.qdyth.f1001.f100109.vo.SbkVO;
import com.wb.qdyth.f1001.f100109.vo.SendMessageHead;
import com.wb.qdyth.f1001.f100109.vo.SeqDTO;
import com.wb.qdyth.f1001.f100109.vo.StringObject;

/**
 * 个人自助打印
 * @author xue
 * 2015-11-10
 */
public class SbkServiceImpl implements SbkService{
	private CommonService commonService;
	 /**
	  * 社保卡申领进度查询
	  * @param page
	  * @param aac001
	  */
	 public void querySbkApplyProgress(Page page,String aac001){
		 StringBuffer queryQL=new StringBuffer();
		 	queryQL.append(" select distinct * ");
			queryQL.append(" from ( (select (select realnam from qdsbk.uaas_uams_user@qdweb_jx c where b.czyid = c.user_id and c.yxbz = 0) as realname, a.bkc156 as aaz701, a.aaz500, (select b.aaa103 from qdsbk.AZ60@qdweb_jx b where b.aaa102 = 'AAZ502' and b.aaa105 = a.aaz540) as aaz514, to_char(b.czkssj, 'yyyy-MM-dd hh24:mi:ss') as aae035, aaz544 as aae037, to_char(b.czjssj, 'yyyy-MM-dd hh24:mi:ss') as aae301, (select d.name from qdsbk.uaas_uams_user@qdweb_jx c, qdsbk.uap_organ_node@qdweb_jx d where b.czyid = c.user_id and c.org_id = d.nodeid and c.yxbz = 0) as czywd, (select d.principal_phone from qdsbk.uaas_uams_user@qdweb_jx c, qdsbk.uap_organ_node@qdweb_jx d where b.czyid = c.user_id and c.org_id = d.nodeid and c.yxbz = 0) as wddh, '是' as flag from qdsbk.az23@qdweb_jx a, qdsbk.tb_ywczrz@qdweb_jx b where a.bkc156 = b.ywczrzlsh and a.azc001 = ? ) "); 
			queryQL.append("  union all (select (select realnam from qdsbk.uaas_uams_user@qdweb_jx c, qdsbk.tb_ywczrz@qdweb_jx e where c.USER_ID = e.czyid and e.ywczrzlsh = b.ywczrzlsh and c.yxbz = 0) realname, b.ywczrzlsh as aaz701, b.sbkkh as aaz500, (select c.aaa103 from qdsbk.AZ60@qdweb_jx c where c.aaa102 = 'AAZ502' and c.aaa105 = b.aaz540) as aaz514, (select to_char(e.czkssj, 'yyyy-MM-dd hh24:mi:ss') from qdsbk.tb_ywczrz@qdweb_jx e where e.ywczrzlsh = b.ywczrzlsh) aae035, null as aae037, (select to_char(e.czjssj, 'yyyy-MM-dd hh24:mi:ss') from qdsbk.tb_ywczrz@qdweb_jx e where e.ywczrzlsh = b.ywczrzlsh) aae301, (select d.name from qdsbk.uaas_uams_user@qdweb_jx c, qdsbk.tb_ywczrz@qdweb_jx e, qdsbk.uap_organ_node@qdweb_jx d where c.USER_ID = e.czyid and c.org_id = d.nodeid and e.ywczrzlsh = b.ywczrzlsh and c.yxbz = 0) as czywd, (select d.principal_phone from qdsbk.uaas_uams_user@qdweb_jx c, qdsbk.tb_ywczrz@qdweb_jx e, qdsbk.uap_organ_node@qdweb_jx d where c.USER_ID = e.czyid and c.org_id = d.nodeid and e.ywczrzlsh = b.ywczrzlsh and c.yxbz = 0) as wddh, '否' as flag from qdsbk.tb_rymx@qdweb_jx b where b.flag = '1' and b.azc001 = ? ) ");
			queryQL.append("  union all (select (select realnam from qdsbk.tb_ywczrz@qdweb_jx b,qdsbk.uaas_uams_user@qdweb_jx c where b.ywczrzlsh = a.ywczrzlsh and b.czyid = c.user_id and c.yxbz = 0) as realname, a.ywczrzlsh as aaz701, a.sbkkh as aaz500, (select b.aaa103 from qdsbk.AZ60@qdweb_jx b where b.aaa102 = 'GRZLXXZT' and b.aaa105 = a.sjzt) as aaz514, (select to_char(c.czkssj, 'yyyy-MM-dd hh24:mi:ss') from qdsbk.tb_ywczrz@qdweb_jx c where c.ywczrzlsh = a.ywczrzlsh) as aae035, null as aae037, (select to_char(c.czjssj, 'yyyy-MM-dd hh24:mi:ss') from qdsbk.tb_ywczrz@qdweb_jx c where c.ywczrzlsh = a.ywczrzlsh) as aae301, (select d.name from qdsbk.tb_ywczrz@qdweb_jx b, qdsbk.uaas_uams_user@qdweb_jx c, qdsbk.uap_organ_node@qdweb_jx d where b.ywczrzlsh = a.ywczrzlsh and b.czyid = c.user_id and c.org_id = d.nodeid and c.yxbz = 0) as czywd, (select d.principal_phone from qdsbk.tb_ywczrz@qdweb_jx b, qdsbk.uaas_uams_user@qdweb_jx c, qdsbk.uap_organ_node@qdweb_jx d where b.ywczrzlsh = a.ywczrzlsh and b.czyid = c.user_id and c.org_id = d.nodeid and c.yxbz = 0) as wddh, '是' as flag from qdsbk.tb_grxx_zl_his@qdweb_jx a where a.grid = ? and (a.sjzt < 25 or a.sjzt > 30) and a.sjzt <> 33 ) ");
			queryQL.append("  union all (select (select realnam from qdsbk.tb_ywczrz@qdweb_jx b,qdsbk.uaas_uams_user@qdweb_jx c where b.ywczrzlsh = a.ywczrzlsh and b.czyid = c.user_id and c.yxbz = 0) as realname, a.ywczrzlsh as aaz701, a.sbkkh as aaz500, (select b.aaa103 from qdsbk.AZ60@qdweb_jx b where b.aaa102 = 'GRZLXXZT' and b.aaa105 = a.sjzt) as aaz514, (select to_char(c.czkssj, 'yyyy-MM-dd hh24:mi:ss') from qdsbk.tb_ywczrz@qdweb_jx c where c.ywczrzlsh = a.ywczrzlsh) as aae035, null as aae037, (select to_char(c.czjssj, 'yyyy-MM-dd hh24:mi:ss') from qdsbk.tb_ywczrz@qdweb_jx c where c.ywczrzlsh = a.ywczrzlsh) as aae301, (select d.name from qdsbk.tb_ywczrz@qdweb_jx b, qdsbk.uaas_uams_user@qdweb_jx c, qdsbk.uap_organ_node@qdweb_jx d where b.ywczrzlsh = a.ywczrzlsh and b.czyid = c.user_id and c.org_id = d.nodeid and c.yxbz = 0) as czywd, (select d.principal_phone from qdsbk.tb_ywczrz@qdweb_jx b, qdsbk.uaas_uams_user@qdweb_jx c, qdsbk.uap_organ_node@qdweb_jx d where b.ywczrzlsh = a.ywczrzlsh and b.czyid = c.user_id and c.org_id = d.nodeid and c.yxbz = 0) as wddh, '是' as flag from qdsbk.tb_grxx_zl@qdweb_jx a where a.grid = ? and (a.sjzt < 25 or a.sjzt > 30) and a.sjzt <> 33 ) ) m order by m.aae301 desc");
			CommonJdbcUtils.queryPage(page, queryQL.toString(), SbkVO.class, aac001,aac001,aac001,aac001);
	 }
	 /**
	  * 社保卡消费明细查询
	  * @param page
	  * @param aac001
	  */
	 public void querySbkConsume(Page page,String aac001){
		 StringBuffer queryQL=new StringBuffer();
			queryQL.append(" select ckc175, decode(cke319,'O',to_char(to_date(substr(ckc176, 0, 6), 'hh24miss'),'hh24:mi:ss'),'R',to_char(to_date(substr(ckc176, 0, 6),'hh24miss'),'hh24:mi:ss'),'0',ckc176,ckc176) ckc176," +
					" decode(ckc179,'4905',ckc178,'5003',ckc178,'7211',ckc178,'1204',abs(ckc178),'5000',abs(ckc178),'1214',abs(ckc178),0) ckc178s, " +
					" decode(ckc179,'4906',ckc178,'3907',ckc178,'1514',ckc178,'4100',abs(ckc178), '1114',abs(ckc178), '3903', abs(ckc178), '4902',abs(ckc178), '3906', abs(ckc178),'1104',abs(ckc178),'5002',abs(ckc178),0) ckc178a,ckc178,cke325,ckc180,cke322 from qdyth.kc80@qdweb_jx where 1=1 ");
			queryQL.append(" and aac001 = ?");
			queryQL.append("  order by CKC175 desc,CKC176 desc,CKC004 desc");
			CommonJdbcUtils.queryPage(page, queryQL.toString(), SbkVO.class, aac001);
	 }
	 /**
	  * 社保卡消费明细查询
	  * @param page
	  * @param aac001
	  */
	 public SbkVO querySbkConsumeSum(String aac001){
			String sql="select sum(decode(ckc179,'4905',ckc178,'5003',ckc178,'7211',ckc178,'1204',abs(ckc178),'5000',abs(ckc178),'1214',abs(ckc178),0)) ckc178s,sum(decode(ckc179,'4906',ckc178,'3907',ckc178,'1514',ckc178,'4100',abs(ckc178), '1114',abs(ckc178), '3903', abs(ckc178), '4902',abs(ckc178), '3906', abs(ckc178),'1104',abs(ckc178),0)) ckc178a,to_char(sysdate,'yyyy')||'年'||to_char(sysdate,'mm')||'月'||to_char(sysdate-1,'dd')||'日' presysdate from qdyth.kc80@qdweb_jx " +
					" where (cke319='O' or cke319='0' or cke319='') and aac001=?";
			return CommonJdbcUtils.queryFirst( sql, SbkVO.class, aac001);
	 }
	 
	 public PersonQueryVO queryGrxxzl(String aac001){
			StringBuffer sql = new StringBuffer();
			
		    //20150807 将社保卡卡号从zl表取
		    sql.append("select (select h.sbkkh from qdsbk.tb_grxx_zl@qdweb_jx h where h.grid = b.grid ) sbkh, " +
		    		"b.grid as aac001, b.xm as aac003,b.zjhm as aac002, (select x.aaa103 from qdsbk.az60@qdweb_jx x " +
		    		"where x.aaa102 = 'AAE008' and x.aaa105 = b.yhbm ) yhbm, (select x.orgname from qdsbk.uaas_uams_org@qdweb_jx x " +
		    		"where x.org_id = b.jbwd) jbwd from qdsbk.tb_grxx_tb_view@qdweb_jx b where b.grid = ? ");
		     
			List<PersonQueryVO> list = CommonJdbcUtils.query(sql.toString(),PersonQueryVO.class,aac001);
			String azz180 = "0";
			
			if(list.size() > 1){
				azz180 = "-1";
			}
			
			if (list.size() == 0) {
				azz180 = "-2";
			}
			PersonQueryVO v = new PersonQueryVO();
			
			if(list.size() >0){
				v = list.get(0);
			}
			
			v.setAzz180(azz180);
			return v;
		}
	 
	/**
	 * //社保卡卡金查询
	 * @param aac001
	 * @return
	 */
		public PersonQueryVO querySbkye(String aac001) {
			PersonQueryVO grxxlrVO = queryGrxxzl(aac001);
			// 查询余额
			if (grxxlrVO != null && grxxlrVO.getAac001() != null && !"".equals(grxxlrVO.getAac001())) {

				String ret3951 = callBankBalance(grxxlrVO.getAac001());
				String retCode = ret3951.substring(5, 11);
				// 抛出银联具体错误信息
				if (!"000000".equals(retCode)) {
					/*
					 * String sql = "select * from kf71 where cke309=?"; RetCodeDTO retCodeDTO =
					 * CommonJdbcDaoUtils.getFirst(sql, RetCodeDTO.class, retCode); throw new
					 * BusinessException(retCodeDTO.getCke310());
					 */
				}
				else {
					// 对返回信息进行处理
					StringObject target = new StringObject(ret3951);
					System.out.println("target:"+target.getValue().toString());
					BankRetInfoUtils.splitStrToPosLen(target, 115, true);
					System.out.println("targetnew:"+target.getValue().toString());
					char[] charsy = target.getValue().toString().toCharArray();
					// 判断是汉字还是字符
					int jqs = 0;
					int zcd = 0;
					try {
						for (int j = 0; zcd < 30; j++) {
							if (("" + charsy[j]).getBytes("GBK").length > 1) {
								zcd = zcd + 2;
							}
							else {
								zcd = zcd + 1;
							}
							jqs = jqs + 1;
						}
					}
					catch (Exception e) {
						// throw new BusinessException("解析返回信息出错！");
					}
					
					BankRetInfoUtils.splitStrToPosLen(target, jqs, true);// 截取姓名
					String ckz004 = BankRetInfoUtils.splitStrToPosLen(target, 19, true);// 截取卡号
					String ckc187str = BankRetInfoUtils.splitStrToPosLen(target, 12, true);// 截取账户金余额
					String ckc002 = BankRetInfoUtils.splitStrToPosLen(target, 2, true);// 截取卡状态
					if ("A".equals(ckc002.trim())) {
						ckc002 = "激活卡";
						grxxlrVO.setAaa030("1");
					} else if ("K".equals(ckc002.trim())) {
						ckc002 = "口头挂失";
					} else if ("L".equals(ckc002.trim())) {
						ckc002 = "正式挂失";
					} else if ("G".equals(ckc002.trim())) {
						ckc002 = "注销卡";
					} else if ("T".equals(ckc002.trim())) {
						ckc002 = "被换过的卡";
					}
					grxxlrVO.setYlkzt(ckc002);
					grxxlrVO.setCkz004(ckz004);
					Double ckc187 = new BigDecimal(ckc187str).divide(new BigDecimal("100")).doubleValue();
					grxxlrVO.setYe(ckc187.toString());
				}
				
			}

			return grxxlrVO;

		}
		/**
		 * 根据aac001调用银联查询余额接口,如果要显示余额需要对返回值ret3951处理一下
		 * @param aac001
		 * @return
		 */
		public String callBankBalance(String aac001) {

			// 调银联余额查询接口，判断卡状态是否为注销，若为非注销，则继续进行注销操作
			// 封装头信息
			SendMessageHead sendMessageHead = new SendMessageHead();
			sendMessageHead.setTrxtype("3951");
			sendMessageHead.setActcode("0");
			sendMessageHead.setLgntype("0");
			sendMessageHead.setSource("CT");// 柜面
			sendMessageHead.setLgninstcode("12063702");
			sendMessageHead.setLgnpartner("               ");// 15个空格
			sendMessageHead.setLgnmerchcode("               ");// 15个空格
			sendMessageHead.setLgnusercode("IVR                 ");// 所有的操作员代码都是这个
			// 通过cup_seq获取端末流水号，没有业务意义，但是每次都要不一样
			/*
			 * SeqDTO dto3951 = CommonJdbcDaoUtils.get("select lpad(to_char(cup_seq.nextval),16,'0') as seq from dual",
			 * SeqDTO.class);
			 */
			String seqSql = "select lpad(to_char(qdyth.cup_seq.nextval@qdsirac_zc),16,'0') as seq from dual";
			SeqDTO dto3951 = (SeqDTO) CommonJdbcUtils.queryFirst(seqSql, SeqDTO.class);
			sendMessageHead.setTerm_trace(dto3951.getSeq());

			StringBuffer sendInfo = BankInterfaceUtils.assembSendMessageHead(sendMessageHead);
			// 个人编号增加其长度到十位
			int len1 = aac001.length();
			int interval1 = 8 - len1;
			if (interval1 > 0) {
				for (int i = 0; i < interval1; i++) {
					aac001 = "0" + aac001;
				}
			}

			int len = aac001.length();
			int interval = 10 - len;
			if (interval != 0) {
				for (int i = 0; i < interval; i++) {
					aac001 += " ";
				}
			}
			StringBuffer sendInfo3951 = new StringBuffer();
			sendInfo3951.append(sendInfo);
			sendInfo3951.append(aac001);
			// 正常返回，发送未成功，发送成功接收未成功的情况在call方法里都已经封装进去了。
			// //因为涉及到银联的同步，所以先查询一下银联的情况
			// 调用3951账户余额查询(通过职工编号查询)接口
			String ret3951 = null;
			try {
				ret3951 = BankCallUtils.call(dto3951.getSeq(), sendInfo3951.toString(), 10000);
			}
			catch (RuntimeException e) {
				String fhm = e.getMessage();
				if ("0001".equals(fhm)) {
					throw new BusinessException("调用银联接口失败【前置机没有返回数据】!");
				}
				else if ("0002".equals(fhm)) {
					throw new BusinessException("调用银联接口失败【前置机返回数据不正确】!");
				}
				else if ("0009".equals(fhm)) {
					throw new BusinessException("从前置机获取返回数据超时!");
				}
				else {
					throw new BusinessException("调用银联接口失败!");
				}
			}
			return ret3951;
		}
		/**
		 * 查询社保卡申领相关信息
		 * @param aac001
		 */
	public UserVO querySbkApplyInfo(String aac001){
		 UserVO personQueryVO;
		 personQueryVO= queryUserInfo(aac001);
		 personQueryVO.setAac001(aac001);
		 String sql="select a.lsh,a.aae017,a.phone2,a.phone0,b.name as aae006,a.nodeid from psbank a,v_bank b where a.nodeid=b.nodeid and a.aac001=? and a.nodeid is not null and a.nodeid <> 'undefined' and a.aae006 is not null and a.phone1 is not null ";
		 Psbank pb=CommonJdbcUtils.queryFirst(sql, Psbank.class, aac001);
		 if(pb!=null){
			 personQueryVO.setExt2(pb.getPhone1());
			 personQueryVO.setExt3(pb.getPhone2());
			 personQueryVO.setExt1(pb.getPhone0());
		 }
		 //获取内网绑定银行信息
		 String sql1="SELECT a.jbwd as nodeid, b.name as aae006 FROM qdsbk.tb_grxx_zl@qdweb_jx a, v_bank b WHERE a.jbwd = b.nodeid and a.grid = ? ";
		 Psbank pbb = CommonJdbcUtils.queryFirst(sql1, Psbank.class, aac001);
		 if(pbb != null){
			 personQueryVO.setNodeid(pbb.getAae006());
			 PersonQueryVO vo = queryWdxx(pbb.getNodeid());
			 personQueryVO.setWddh(vo.getWddh().trim());
			 personQueryVO.setWddz(vo.getWddz().trim());
			 personQueryVO.setJbyh(vo.getJbyh().trim());
			 personQueryVO.setLsh1("0");
		 }
		 else if(pb != null){
			 personQueryVO.setNodeid(pb.getAae006());
			 PersonQueryVO vo = queryWdxx(pb.getNodeid());
			 personQueryVO.setWddh(vo.getWddh().trim());
			 personQueryVO.setWddz(vo.getWddz().trim());
			 personQueryVO.setJbyh(vo.getJbyh().trim());
			 personQueryVO.setLsh(pb.getLsh().toString());
		 }
		 return personQueryVO;
	}
	/**
	 * 查询银行列表
	 * @return
	 */
	public List<APPAA10> queryYhlb(){
		 String sql="select a.nodeid as aaa102, a.name as aaa103 from qdyth.uap_organ_node@qdweb_jx a where a.PARENTNODEID = '10000011' and a.REMOVED = '0' order by a.nodeid ";
		 return CommonJdbcUtils.query(sql, APPAA10.class);
	}
	/**
	 * 银行网点
	 * @return
	 */
	public List<APPAA10> queryWdbm(String aea001One){
		 String sql="select a.nodeid as aaa102, a.name as aaa103 from qdyth.uap_organ_node@qdweb_jx a where a.PARENTNODEID = ? and a.REMOVED = '0' order by a.nodeid  ";
		 return CommonJdbcUtils.query(sql, APPAA10.class,aea001One);
	}
	/**
	 * 银行网点(级联用)
	 * @return
	 */
	public List<APPAA10> queryWdxx2(String nodeid){
		 String sql="select a.address as aaa102, a.principal_phone as aaa103 from qdyth.uap_organ_node@qdweb_jx a where a.nodeid = ?  ";
		 return CommonJdbcUtils.query(sql, APPAA10.class,nodeid);
	}
	/**
	 * 保存社保卡申领信息
	 * @param personQueryVO
	 * @return
	 */
	public Psbank saveSbkApplyInfo(UserVO personQueryVO){
		String sql="select a.* from psbank a where a.aac001=? and a.nodeid is not null and a.nodeid <> 'undefined' and a.aae006 is not null and a.phone1 is not null ";
		Psbank pbb=CommonJdbcUtils.queryFirst(sql,Psbank.class,personQueryVO.getAac001());
		if(pbb!=null){
			throw new BusinessException("您已经绑定过银行，不允许重复绑定！");
		}
		sql="SELECT a.grid as aac001 FROM  qdsbk.tb_grxx_zl@qdweb_jx a WHERE a.zjhm = ? and rownum = 1 ";
		pbb=CommonJdbcUtils.queryFirst(sql, Psbank.class, personQueryVO.getAac002());
		if(pbb!=null){
			throw new BusinessException("您已经制卡，不允许再次绑定！");
		}
		String lsh=CommonJdbcUtils.getSequenceValue("seq_net_lsh");
		//保存银行反馈表
		Psbank pb=new Psbank();
		pb.setAac001(Long.valueOf(personQueryVO.getAac001()));
		pb.setLsh(Long.valueOf(lsh));
		pb.setAae006(personQueryVO.getAae006());//地址
		pb.setAae036(new Date());
		pb.setPhone0(personQueryVO.getExt1());//固话
		pb.setPhone1(personQueryVO.getAae005());//移动电话1
		pb.setPhone2(personQueryVO.getExt3());//移动电话2
		pb.setNodeid(personQueryVO.getNodeid());//绑定银行id
		CommonJdbcUtils.save(pb);
		return pb;
	}
	/**
	 * 查询银行网点信息
	 * @param nodeid
	 * @return
	 */
		public PersonQueryVO queryWdxx(String nodeid) {
			String sql = "select (select name from qdyth.uap_organ_node@qdweb_jx where nodeid = a.PARENTNODEID) as jbyh, a.address as wddz, a.principal_phone as wddh from qdyth.uap_organ_node@qdweb_jx a where a.nodeid = ? ";
			return CommonJdbcUtils.queryFirst(sql.toString(), PersonQueryVO.class, nodeid);
		}
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
	 * 银行挂失
	 */
		public void doGsyl(String aac001, String cardNum){
			int len = cardNum.length();
			int interval = 19 - len;
			if (interval > 0) {
				for (int i = 0; i < interval; i++) {
					cardNum = cardNum + " ";
				}
			}

			SendMessageHead sendMessageHead = new SendMessageHead();
			sendMessageHead.setTrxtype("3920");
			sendMessageHead.setActcode("1");
			sendMessageHead.setLgntype("0");
			sendMessageHead.setSource("CT");
			sendMessageHead.setLgninstcode("12063702");
			sendMessageHead.setLgnpartner("               ");// 15个空格
			sendMessageHead.setLgnmerchcode("               ");// 15个空格
			sendMessageHead.setLgnusercode("IVR                 ");// 所有的操作员代码都是这个
			// 通过cup_seq获取端末流水号，没有业务意义，但是每次都要不一样
			String seqSql = "select lpad(to_char(qdyth.cup_seq.nextval@qdsirac_zc),16,'0') as seq from dual";
			SeqDTO dto3951 = (SeqDTO) CommonJdbcUtils.queryFirst(seqSql, SeqDTO.class);
			sendMessageHead.setTerm_trace(dto3951.getSeq());

			StringBuffer sendInfo = BankInterfaceUtils.assembSendMessageHead(sendMessageHead);

			// 个人编号增加其长度到10位
			int lenbl = aac001.length();
			int intervalbl = 8 - lenbl;
			if (intervalbl > 0) {
				for (int i = 0; i < intervalbl; i++) {
					aac001 = "0" + aac001;
				}
			}
			int lenl = aac001.length();
			int interval1 = 20 - lenl;
			if (interval1 != 0) {
				for (int i = 0; i < interval1; i++) {
					aac001 += " ";
				}
			}
			StringBuffer sendInfo3920 = new StringBuffer();
			sendInfo3920.append(sendInfo);
			sendInfo3920.append(cardNum);
			sendInfo3920.append("11");
			sendInfo3920.append(aac001);
			sendInfo3920.append("1"); // 挂失接挂标志：口头挂失
			// 正常返回，发送未成功，发送成功接收未成功的情况在call方法里都已经封装进去了。 //
			String ret3920 = null;
			try {
				ret3920 = BankCallUtils.call(dto3951.getSeq(), sendInfo3920.toString(), 10000);
			}
			catch (RuntimeException e) {
				String fhm = e.getMessage();
				if ("0001".equals(fhm)) {
					throw new BusinessException("调用银联接口失败【前置机没有返回数据】!");
				}
				else if ("0002".equals(fhm)) {
					throw new BusinessException("调用银联接口失败【前置机返回数据不正确】!");
				}
				else if ("0009".equals(fhm)) {
					throw new BusinessException("从前置机获取返回数据超时!");
				}
				else {
					throw new BusinessException("调用银联接口失败!");
				}
			}
			String retCodecw = ret3920.substring(5, 11); // 抛出银联具体错误信息
			if (!"000000".equals(retCodecw)) {
				String sqlpd = "select * from qdyth.kf71@qdweb_jx where cke309='" + retCodecw + "'";

				RetCodeDTO retCodeDTO = (RetCodeDTO) CommonJdbcUtils.queryFirst(sqlpd, RetCodeDTO.class);
				throw new BusinessException(retCodeDTO.getCke310());
			}
		}
		/**
		 * 口头挂失
		 * @param aac001
		 * @param aac002
		 * @param ylkzt
		 * @param userid
		 * @return
		 */
		public void saveLsgs(String aac001, String aac002, String ylkzt, Long userid) {
			String sql = "select aaz500, aaz501, aaa030 from qdsbk.az20@qdweb_jx where azc001=? and aaz502='5' ";
			PersonQueryVO vo = CommonJdbcUtils.queryFirst(sql, PersonQueryVO.class, new Object[]{ aac001 });
			sql = "select * from qdyth.kc02@qdweb_jx where aac001 = ? and ckc002 = '1' ";
			Kc02 kc02 = CommonJdbcUtils.queryFirst(sql, Kc02.class, new Object[]{ aac001 });
			if(vo == null || kc02==null){
				throw new BusinessException("没有可口头挂失的社保卡！");
			}
			
			String cardNum = kc02.getCkz004();
			if("3".equals(vo.getAaa030()) && "1".equals(kc02.getCkc164()) && "1".equals(ylkzt)){
				doGsyl(aac001, cardNum);
			}
			
			LsgsPrcDTO dto=new LsgsPrcDTO();
			dto.setV_aac001(aac001);
			dto.setV_aaz500(vo.getAaz500());
			dto.setV_aaz501(vo.getAaz501());
			dto.setV_ckc002(kc02.getCkc002());
			dto.setV_ckz004(kc02.getCkz004());
			dto.setV_czyid(userid.toString());
			CommonJdbcUtils.call("GRCX_SBK_LSGS", dto);
			if(!"0".equals(dto.getRetcode())){
				throw new BusinessException(dto.getRetmsg());
			}
		}
	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
}
