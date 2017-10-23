package com.wb.qdyth.f2001.common.service;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wb.jdbcutils.CommonJdbcUtils;
import com.wb.jdbcutils.Page;
import com.wb.qdyth.common.bo.DfJgsj;
import com.wb.qdyth.common.bo.NetData;
import com.wb.qdyth.common.bo.NetDataList;
import com.wb.qdyth.common.bo.NetDataMain;
import com.wb.qdyth.common.bo.NetDataMains;
import com.wb.qdyth.common.service.CommonService;
import com.wb.qdyth.f2001.common.vo.ExportVO;
import com.wb.qdyth.f2001.common.vo.Kb77VO;
import com.wb.qdyth.f2001.common.vo.NetDataListVO;
import com.wb.qdyth.f2001.common.vo.NetDataMainAttachmentVO;
import com.wb.qdyth.f2001.common.vo.NetDataMainVO;
import com.wb.qdyth.f2001.common.vo.NetStatusVO;
import com.wb.qdyth.f2001.common.vo.Yyglchfry;
import com.wb.user.utils.BusinessContextUtils;
import com.wb.utils.web.common.StringTools;

public class YlbxServiceImpl implements YlbxService {
	private CommonService commonService;

	public NetDataMainVO yyglPersonValidation_error(NetDataMainVO netDataMainVO, String busiid) {
		String userid = String.valueOf(BusinessContextUtils.getUserContext().getId());
		String aac147 = netDataMainVO.getData02();
		StringBuffer sql_validation = new StringBuffer();
		// 如果是在职人员判断缴费信息
		//
		if (netDataMainVO.getData04().equals("2")) {
			StringBuffer strsql = new StringBuffer();
			strsql.setLength(0);
			strsql.append(" select nvl(count(1),0) as num ");
			strsql.append("   from ac43@qdweb_jx b,ac01@qdweb_jx a,ylfwjk.kb78@qdweb_jx c ");
			strsql.append("  where a.aac001=b.aac001 and b.aab001  = c.aab001 and c.userid = ? and  a.aac147=? ");
			strsql.append("    and b.aae078 = '1' and b.aae017 = '0' and b.aaa131 = '0' and b.aae003= to_number(to_char(add_months(sysdate,-1),'yyyymm')) ");
			Integer num = CommonJdbcUtils.queryFirst(strsql.toString(), Integer.class, userid, aac147);
			if (num == 0) {
				netDataMainVO.setStatus("3");
				netDataMainVO.setName("截止到上月此人未在本单位缴纳保险，不能提交！");
				return netDataMainVO;
			}
		}
		// 如果是该人员的身份证号码在该单位已经存在，那么不允许新增
		List<Object> paralist = new ArrayList<Object>();
		sql_validation.setLength(0);
		sql_validation.append(" select a.dataid ");
		sql_validation.append("   from net_data_list a ");
		sql_validation.append("  where exists (select 1 ");
		sql_validation.append("           from net_data b ");
		sql_validation.append("          where a.lsh = b.lsh ");
		sql_validation.append("            and b.busiid in ('200108', '200109', '200110') ");
		sql_validation.append("            and b.userid = ?) ");
		paralist.add(userid);
		sql_validation.append("    and a.data02 = ? ");
		paralist.add(aac147);
		if (netDataMainVO.getDataid() != null && netDataMainVO.getDataid() > 0) {
			sql_validation.append("    and a.dataid <> ? ");
			paralist.add(netDataMainVO.getDataid());
		}
		sql_validation.append("    and rownum = 1");
		Yyglchfry ryxx = CommonJdbcUtils.queryFirst(sql_validation.toString(), Yyglchfry.class, paralist.toArray());
		if (ryxx != null) {
			netDataMainVO.setStatus("3");
			netDataMainVO.setName("该人员身份证号码在本单位已存在，不允许重复上传！");
			return netDataMainVO;
		}

		return netDataMainVO;
	}

	public NetDataMainVO yyglPersonValidation_warn(NetDataMainVO netDataMainVO, String busiid) {
		String warn_info = "";
		String userid = String.valueOf(BusinessContextUtils.getUserContext().getId());
		// 身份证号码不在自己登录账号下重复，给出提出信息
		Kb77VO kb77vo = CommonJdbcUtils.queryFirst("select * from qdyth.kb77@qdweb_jx where userid = ? ", Kb77VO.class,userid);
		
		String aac147 = netDataMainVO.getData02();
		List<Object> paralist = new ArrayList<Object>();
		StringBuffer sql_validation = new StringBuffer();
		paralist.clear();
		sql_validation.setLength(0);
		sql_validation.append(" select 1 dataid ");
		sql_validation.append("   from dual ");
		sql_validation.append("  where     exists (select 1 ");
		sql_validation.append("           from net_data_list a ,net_data b ");
		sql_validation.append("          where a.lsh = b.lsh ");
		sql_validation.append("            and b.busiid in ('200108', '200109', '200110') ");
		sql_validation.append("            and  a.data02 = ? ");
		paralist.add(aac147);
		if (netDataMainVO.getDataid() != null && netDataMainVO.getDataid() > 0) {
			sql_validation.append("    and a.dataid <> ? ");
			paralist.add(netDataMainVO.getDataid());
		}
		sql_validation.append("         )");
		sql_validation.append("          or exists(select 1 from kf39@qdweb_jx c where c.aac147= ? and c.CKC009 in ('1', '3', '5') ");
		paralist.add(aac147);
		if(kb77vo!= null && StringUtils.hasText(kb77vo.getAkb020())){
			sql_validation.append("                       and c.akb020 <> ?   ");
			paralist.add(kb77vo.getAkb020());
		}
		sql_validation.append("         ) ");
		sql_validation.append("          or exists(select 1 from KF83@qdweb_jx d where d.aac147= ? and d.CKC009 in ('1', '3', '5') ");
		paralist.add(aac147);
		if(kb77vo!= null && StringUtils.hasText(kb77vo.getAkb020())){
			sql_validation.append("                       and d.akb020 <> ?   ");
			paralist.add(kb77vo.getAkb020());
		}
		sql_validation.append("         ) ");
		
		sql_validation.append("    and rownum = 1");
		Yyglchfry ryxx = CommonJdbcUtils.queryFirst(sql_validation.toString(), Yyglchfry.class, paralist.toArray());
		if (ryxx != null) {
			if (StringUtils.hasText(warn_info)) {
				warn_info = warn_info + "。该人员身份证号码存在其他单位的注册信息，是否继续上传?";
			} else {
				warn_info = "该人员身份证号码存在其他单位的注册信息，是否继续上传?";
			}
			netDataMainVO.setStatus("10");
			netDataMainVO.setName(warn_info);
		}
		return netDataMainVO;
	}

	/**
	 * 
	 * @param aac147
	 */
	public void dealWithRedundancies(String aac147) {
		// 1.若身份证号码重复，则将重复的记录标记，并记录到重复人员列表，供以后查询使用
		// 2.若身份证号码不存在重复，去掉重复记录标志，将重复人员列表中的记录删除，重复人员列表同意身份证号码应该存在两条，若只有一条应将一条信息删除
		String userid = String.valueOf(BusinessContextUtils.getUserContext().getId());
		String pro_name = "dealWithRedundancies";
		CommonJdbcUtils.executeProcedure(pro_name, aac147, userid);
	}

	/**
	 * 医疗机构信息保存
	 */
	public NetDataMainVO saveYljgInfo(MultipartFile[] files, NetDataMainVO netDataMainVO, String busiid) {
		// 判断内网审核人员审核量化评分表信息是否已经提交,
		netDataMainVO.setStatus("1");
		String userid = String.valueOf(BusinessContextUtils.getUserContext().getId());
		String sqlk = "select a.memo  from net_data a,net_status b  where a.lsh=b.lsh and  a.busiid='200118'  and a.userid=? ";// and

		NetData vo = CommonJdbcUtils.queryFirst(sqlk, NetData.class, userid);
		if (vo != null) {
			if ("提交".equals(vo.getMemo())) {
				netDataMainVO.setStatus("2");
				return netDataMainVO;
			}
		}
		// 判断图片大小
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				if (file!=null && !file.isEmpty()) {
					if (file.getSize() > 1024 * 600) {
						netDataMainVO.setName(file.getOriginalFilename() + "文件大小大于600KB,请重新上传！");
						netDataMainVO.setStatus("3");
						return netDataMainVO;
					}
				}
			}
		}
		Long dataid = netDataMainVO.getDataid();
		String df_lsh = "";
		String sql_dfwj = "";
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String sj = df.format(dt);
		String sql_jgsj = "select * from df_jgsj where userid = ?";
		DfJgsj jgsj = CommonJdbcUtils.queryFirst(sql_jgsj, DfJgsj.class, userid);
		String ys = "";
		String gjys = "";
		String yj = "";
		String hs = "";
		String zjhs = "";
		String wj = "";
		String cws = "";
		String data03 = "";
		String data04 = "";
		String mj = "";
		String zysj = "";
		if (jgsj != null) {
			ys = jgsj.getYs() == null ? "" : jgsj.getYs();
			gjys = jgsj.getGjys() == null ? "" : jgsj.getGjys();
			yj = jgsj.getYj() == null ? "" : jgsj.getYj();
			hs = jgsj.getHs() == null ? "" : jgsj.getHs();
			zjhs = jgsj.getZjhs() == null ? "" : jgsj.getZjhs();
			wj = jgsj.getWj() == null ? "" : jgsj.getWj();
			cws = jgsj.getCws() == null ? "" : jgsj.getCws();
			data03 = jgsj.getData03() == null ? "" : jgsj.getData03();
			data04 = jgsj.getData04() == null ? "" : jgsj.getData04();
			mj = jgsj.getMj() == null ? "" : jgsj.getMj();
			zysj = jgsj.getZysj() == null ? "" : jgsj.getZysj();
		}

		if (dataid != null) {// 如果数据库中已经存在信息，则更新信息
			if ("200108".equals(busiid) || "200109".equals(busiid) || "200110".equals(busiid)) {
				String sql = "select * from net_data_list where dataid=? and lsh=? ";
				Long lsh = netDataMainVO.getLsh();
				NetDataList netDataList = CommonJdbcUtils.queryFirst(sql, NetDataList.class, dataid, lsh);

				if (netDataList == null) {
					netDataMainVO.setStatus("3");
					netDataMainVO.setName("系统无该数据记录，请刷新页面后重新操作！");
					return netDataMainVO;
				}

				// 医师、医护、医技人员保存前判断
				netDataMainVO = yyglPersonValidation_error(netDataMainVO, busiid);
				if ("3".equalsIgnoreCase(netDataMainVO.getStatus())) {
					return netDataMainVO;
				}
				String aac147_pre = "";
				if (!netDataMainVO.getData02().equalsIgnoreCase(netDataList.getData02())) {
					aac147_pre = netDataList.getData02();
				}

				BeanUtils.copyProperties(netDataMainVO, netDataList);
				CommonJdbcUtils.update(netDataList);
				if (files != null) {
					commonService.uploadfile_wq(files, Long.toString(netDataList.getDataid()), busiid);
				}
				df_lsh = String.valueOf(lsh);
				// 保存机构数据
				if ("200108".equals(busiid)) {
					String sql_df3 = "select count(*) ys from net_data_list where lsh =?";
					String sql_df4 = "select count(*) gjys from net_data_list where lsh =? and data09 = '3' ";
					ys = CommonJdbcUtils.queryFirst(sql_df3, String.class, df_lsh);
					gjys = CommonJdbcUtils.queryFirst(sql_df4, String.class, df_lsh);
				} else if ("200110".equals(busiid)) {
					String sql_df3 = "select count(*) hs from net_data_list where lsh =?";
					String sql_df4 = "select count(*) zjhs from net_data_list where lsh =? and data09 in('2','3') ";
					hs = CommonJdbcUtils.queryFirst(sql_df3, String.class, df_lsh);
					zjhs = CommonJdbcUtils.queryFirst(sql_df4, String.class, df_lsh);
				} else if ("200109".equals(busiid)) {
					String sql_df3 = "select count(*) yj from net_data_list where lsh = ? ";
					yj = CommonJdbcUtils.queryFirst(sql_df3, String.class, df_lsh);
				}
				sql_dfwj = "select count(*) from net_data_list" + " where lsh in" + "( select lsh from net_data where userid =? "
						+ " and busiid in('200108','200109','200110')" + ")";
				wj = CommonJdbcUtils.queryFirst(sql_dfwj, String.class, userid);
				// 先保存人员信息，后对身份证号码重复性处理。
				// 1.若身份证号码重复，则将重复的记录标记，并记录到重复人员列表，供以后查询使用
				// 2.若身份证号码不存在重复，去掉重复记录标志，将重复人员列表中的记录删除，重复人员列表同意身份证号码应该存在两条，若只有一条应将一条信息删除
				if (StringUtils.hasText(aac147_pre) && !aac147_pre.equalsIgnoreCase(netDataList.getData02())) {
					dealWithRedundancies(netDataMainVO.getData02());
					dealWithRedundancies(aac147_pre);
				}

			} else if ("2001".equals(busiid)) {
				String sql = "select * from net_data_main_s where dataid=? and lsh=? ";
				Long lsh = netDataMainVO.getLsh();
				NetDataMains netDataMains = CommonJdbcUtils.queryFirst(sql, NetDataMains.class, dataid, lsh);
				if (netDataMains != null) {
					BeanUtils.copyProperties(netDataMainVO, netDataMains);
					CommonJdbcUtils.update(netDataMains);
				}
				// ----------- //保存打分用数据
				cws = netDataMainVO.getData13();
				data03 = netDataMainVO.getData08();
				data04 = netDataMainVO.getData12();
				// -------------
			}else {
				String sql = "select * from net_data_main where dataid=? and lsh=? ";
				Long lsh = netDataMainVO.getLsh();
				NetDataMain netDataMain = CommonJdbcUtils.queryFirst(sql, NetDataMain.class, dataid, lsh);
				if (netDataMain != null) {
					BeanUtils.copyProperties(netDataMainVO, netDataMain);
					CommonJdbcUtils.update(netDataMain);
					if (files != null) {
						commonService.uploadfile_wq(files, Long.toString(netDataMain.getLsh()), busiid);
					}
					if("200103".equals(busiid)){ //执业时间
						zysj = 	netDataMainVO.getData26().replace("-", "");		
					}
					if("200107".equals(busiid)){ //面积						
						mj = netDataMainVO.getData25();
					}
				}
			}

			// return netDataMainVO;
		} else {
			if ("200108".equals(busiid) || "200109".equals(busiid) || "200110".equals(busiid)) {
				String sql = "select * from net_data where busiid=? and userid=? ";
				NetData netData = CommonJdbcUtils.queryFirst(sql, NetData.class, busiid, userid);

				// 医师、医护、医技人员保存前判断
				netDataMainVO = yyglPersonValidation_error(netDataMainVO, busiid);
				if ("3".equalsIgnoreCase(netDataMainVO.getStatus())) {
					return netDataMainVO;
				}

				if (netData != null) {
					Long lshs = netData.getLsh();
					NetDataList netDataList = new NetDataList();
					BeanUtils.copyProperties(netDataMainVO, netDataList);
					netDataList.setLsh(lshs);
					CommonJdbcUtils.save(netDataList);
					if (files != null) {
						commonService.uploadfile_wq(files, Long.toString(netDataList.getDataid()), busiid);
					}
					df_lsh = String.valueOf(lshs);
				} else {
					long lsh = commonService.creatBusinessLog(busiid);
					commonService.saveNetDate(lsh, busiid);
					NetDataList netDataList = new NetDataList();
					BeanUtils.copyProperties(netDataMainVO, netDataList);
					netDataList.setLsh(lsh);
					CommonJdbcUtils.save(netDataList);
					if (files != null) {
						commonService.uploadfile_wq(files, Long.toString(netDataList.getDataid()), busiid);
					}
					df_lsh = String.valueOf(lsh);
				}
				// 保存机构数据
				if ("200108".equals(busiid)) {
					String sql_df3 = "select count(*) ys from net_data_list where lsh =? ";
					String sql_df4 = "select count(*) gjys from net_data_list where lsh =? and data09 = '3' ";
					ys = CommonJdbcUtils.queryFirst(sql_df3, String.class, df_lsh);
					gjys = CommonJdbcUtils.queryFirst(sql_df4, String.class, df_lsh);
				} else if ("200110".equals(busiid)) {
					String sql_df3 = "select count(*) hs from net_data_list where lsh =?";
					String sql_df4 = "select count(*) zjhs from net_data_list where lsh =? and data09 in('2','3') ";
					hs = CommonJdbcUtils.queryFirst(sql_df3, String.class, df_lsh);
					zjhs = CommonJdbcUtils.queryFirst(sql_df4, String.class, df_lsh);
				} else if ("200109".equals(busiid)) {
					String sql_df3 = "select count(*) yj from net_data_list where lsh =?";
					yj = CommonJdbcUtils.queryFirst(sql_df3, String.class, df_lsh);
				}
				sql_dfwj = "select count(*) from net_data_list" + " where lsh in" + "( select lsh from net_data where userid =?"
						+ " and busiid in('200108','200109','200110')" + ")";
				wj = CommonJdbcUtils.queryFirst(sql_dfwj, String.class, userid);

				// 先保存人员信息，后对身份证号码重复性处理。
				// 1.若身份证号码重复，则将重复的记录标记，并记录到重复人员列表，供以后查询使用
				// 2.若身份证号码不存在重复，去掉重复记录标志，将重复人员列表中的记录删除，重复人员列表同意身份证号码应该存在两条，若只有一条应将一条信息删除
				dealWithRedundancies(netDataMainVO.getData02());

			} else if ("2001".equals(busiid)) {
				long lsh = commonService.creatBusinessLog(busiid);
				commonService.saveNetDate(lsh, busiid);
				NetDataMains netDataMains = new NetDataMains();
				BeanUtils.copyProperties(netDataMainVO, netDataMains);
				netDataMains.setLsh(lsh);
				CommonJdbcUtils.save(netDataMains);
				netDataMainVO.setLsh(lsh);
				netDataMainVO.setDataid(netDataMains.getDataid());

				// --------------//保存打分用数据
				cws = netDataMainVO.getData13();
				data03 = netDataMainVO.getData08();
				data04 = netDataMainVO.getData12();
				// -----------------
			} else {
				// long lsh=commonService.getlsh(busiid,
				// netDataMainVO.getData01());
				long lsh = commonService.creatBusinessLog(busiid);
				commonService.saveNetDate(lsh, busiid);
				NetDataMain netDataMain = new NetDataMain();
				BeanUtils.copyProperties(netDataMainVO, netDataMain);
				netDataMain.setLsh(lsh);
				CommonJdbcUtils.save(netDataMain);
				if (files != null) {
					commonService.uploadfile_wq(files, Long.toString(lsh), busiid);
				}
				netDataMainVO.setLsh(lsh);
				netDataMainVO.setDataid(netDataMain.getDataid());

				if("200103".equals(busiid)){ //执业时间
					zysj = netDataMainVO.getData26().replace("-", "");
					
				}
				if("200107".equals(busiid)){ //面积						
					mj = netDataMainVO.getData25();
				}
			}
			// return netDataMainVO;
		}
		List<Object> list = new ArrayList<Object>();
		if (jgsj != null) {
			String sql_df = "update df_jgsj set mj = ?, cws = ?,data03 = ?,data04 = ?," + "ys = ?,gjys = ?,yj = ?,hs = ?,zjhs = ?,"
					+ "wj = ? ,data02 = ?,zysj = ? where userid = ?";
			list.add(mj);
			list.add(cws);
			list.add(data03);
			list.add(data04);
			list.add(ys);
			list.add(gjys);
			list.add(yj);
			list.add(hs);
			list.add(zjhs);
			list.add(wj);
			list.add(sj);
			list.add(zysj);
			list.add(userid);
			CommonJdbcUtils.execute(sql_df, list.toArray());
		} else {
			String sql_df = "INSERT INTO df_jgsj (userid,mj,cws,data03,data04,ys,gjys,yj,hs,zjhs,wj,data02,zysj)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			list.add(userid);
			list.add(mj);
			list.add(cws);
			list.add(data03);
			list.add(data04);
			list.add(ys);
			list.add(gjys);
			list.add(yj);
			list.add(hs);
			list.add(zjhs);
			list.add(wj);
			list.add(sj);
			list.add(zysj);
			CommonJdbcUtils.execute(sql_df, list.toArray());
		}
		return netDataMainVO;
	}

	/**
	 * 评分表信息保存
	 */
	public String saveDataListInfo(List<NetDataListVO> list, Long lsh, String busiid) {
		// 判断是否已经提交
		String userid = String.valueOf(BusinessContextUtils.getUserContext().getId());
		String sqlk = "select b.* from net_data a,net_status b where a.lsh=b.lsh and a.busiid=? and a.userid=? ";
		NetStatusVO vos = CommonJdbcUtils.queryFirst(sqlk, NetStatusVO.class, busiid, userid);
		if (vos != null) {
			if ("2".equals(vos.getLink())) {
				return "2";
			} else if ("3".equals(vos.getLink())) {
				return "3";
			} else if ("4".equals(vos.getLink())) {
				return "4";
			}
		}
		List<NetDataList> list1 = new ArrayList<NetDataList>();
		for (int i = 0; i < list.size(); i++) {
			NetDataListVO vo = list.get(i);

			NetDataList netDataList = new NetDataList();
			BeanUtils.copyProperties(vo, netDataList);
			if (vo.getDataid() != null) {
				CommonJdbcUtils.update(netDataList);
			} else {
				list1.add(netDataList);
			}
		}
		if (list1 != null && list1.size() > 0) {
			CommonJdbcUtils.save(list1);
		}

		return "1";
	}

	/**
	 * 受理信息提交
	 */
	public String saveAllListInfo() {
		Long userid = BusinessContextUtils.getUserContext().getId();
		String data15 = BusinessContextUtils.getUserContext().getName();
		// 判断是否提交
		String sql = "select * from net_data a where a.busiid like '%2001%' and a.userid=? and a.memo is null and exists "
				+ "(select 1 from net_status b where a.lsh=b.lsh and b.clzt='1') ";
		List<NetData> list = CommonJdbcUtils.query(sql, NetData.class, userid);
		if (list.size() >= 1) {
			List<Object> list1 = new ArrayList<Object>();
			sql = "update net_data a set a.memo='提交' where a.busiid like '%2001%' and a.userid=? and a.memo is null and exists "
					+ "(select 1 from net_status b where a.lsh=b.lsh and b.clzt='1') ";
			list1.add(userid);
			CommonJdbcUtils.execute(sql, list1.toArray());

			List<Object> list2 = new ArrayList<Object>();
			sql = "update net_status a set a.link='2',a.clzt='2'" + " where a.lsh in(select b.lsh from net_data b where b.userid = ?)";
			list2.add(userid);
			CommonJdbcUtils.execute(sql, list2.toArray());

			// 记录状态
			List<Object> list3 = new ArrayList<Object>();
			Date upDate = new Date();
			DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
			String clsj = df.format(upDate);
			String sql2 = "INSERT INTO NET_BACK VALUES (?,'1',?,?)";
			list3.add(userid);
			list3.add(data15);
			list3.add(clsj);
			CommonJdbcUtils.execute(sql2, list3.toArray());
			return "1";
		} else {

			return "2";
		}
	}

	/**
	 * 查询是否在申报期
	 */
	public Kb77VO checkTime() {
		String loginname = BusinessContextUtils.getUserContext().getLoginName();
		String sql = "select loginname from kb77@qdweb_jx where loginname=?  and to_char(sysdate,'yyyymmdd')>=starttime and to_char(sysdate,'yyyymmdd')<=endtime ";
		String sql1 = "select * from kb77@qdweb_jx where loginname=?  ";
		String name = CommonJdbcUtils.queryFirst(sql, String.class, loginname);
		Kb77VO vo = CommonJdbcUtils.queryFirst(sql1, Kb77VO.class, loginname);
		if (name != null && !"".equals(name)) {
			vo.setBz("1");
		} else {
			vo.setBz("2");
		}
		return vo;

	}

	/**
	 * 删除医疗设备信息
	 */
	public void deleteDataListInfo(String dataid, String busiid, Long lsh) {

		String[] ss = dataid.split(",");
		// Long[] bb=new Long[ss.length];
		for (int i = 0; i < ss.length; i++) {
			Long s = Long.valueOf(ss[i]);
			if ("200108".equals(busiid) || "200109".equals(busiid) || "200110".equals(busiid)) {
				String sql = "delete from net_data_main_attachment where lsh=? ";
				CommonJdbcUtils.execute(sql, ss[i]);
			}
			String sql = "select * from net_data_list where dataid=? and lsh=? ";
			NetDataList netDataList = CommonJdbcUtils.queryFirst(sql, NetDataList.class, s, lsh);
			sql = "delete from net_data_list where dataid=? ";
			CommonJdbcUtils.execute(sql, s);
			dealWithRedundancies(netDataList.getData02());
		}
		String userid = String.valueOf(BusinessContextUtils.getUserContext().getId());
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String sj = df.format(dt);
		String sql_jgsj = "select * from df_jgsj where userid = ?";
		DfJgsj jgsj = CommonJdbcUtils.queryFirst(sql_jgsj, DfJgsj.class, userid);
		if (jgsj != null) {
			List<Object> list = new ArrayList<Object>();
			String ys = jgsj.getYs() == null ? "" : jgsj.getYs();
			String gjys = jgsj.getGjys() == null ? "" : jgsj.getGjys();
			String yj = jgsj.getYj() == null ? "" : jgsj.getYj();
			String hs = jgsj.getHs() == null ? "" : jgsj.getHs();
			String zjhs = jgsj.getZjhs() == null ? "" : jgsj.getZjhs();
			String wj = jgsj.getWj() == null ? "" : jgsj.getWj();

			if ("200108".equals(busiid)) {
				String sql_df3 = "select count(*) ys from net_data_list where lsh =?";
				String sql_df4 = "select count(*) gjys from net_data_list where lsh =? and data09 = '3' ";
				ys = CommonJdbcUtils.queryFirst(sql_df3, String.class, lsh);
				gjys = CommonJdbcUtils.queryFirst(sql_df4, String.class, lsh);
			} else if ("200110".equals(busiid)) {
				String sql_df3 = "select count(*) hs from net_data_list where lsh =?";
				String sql_df4 = "select count(*) zjhs from net_data_list where lsh =? and data09 in('2','3') ";
				hs = CommonJdbcUtils.queryFirst(sql_df3, String.class, lsh);
				zjhs = CommonJdbcUtils.queryFirst(sql_df4, String.class, lsh);
			} else if ("200109".equals(busiid)) {
				String sql_df3 = "select count(*) yj from net_data_list where lsh =?";
				yj = CommonJdbcUtils.queryFirst(sql_df3, String.class, lsh);
			}
			String sql_dfwj = "select count(*) from net_data_list" + " where lsh in" + "( select lsh from net_data where userid =?"
					+ " and busiid in('200108','200109','200110')" + ")";
			wj = CommonJdbcUtils.queryFirst(sql_dfwj, String.class, userid);
			String sql_df = "update df_jgsj set ys = ?,gjys = ?," + "yj = ?,hs = ?,zjhs = ?," + "wj =?,data02 =? where userid = ?";
			list.add(ys);
			list.add(gjys);
			list.add(yj);
			list.add(hs);
			list.add(zjhs);
			list.add(wj);
			list.add(sj);
			list.add(userid);
			CommonJdbcUtils.execute(sql_df, list.toArray());
		}
		
	}

	/**
	 * 附件删除
	 */
	public void deleteDataAttachMentInfo(String fileid) {

		String[] ss = fileid.split(",");
		for (int i = 0; i < ss.length; i++) {
			Long s = Long.valueOf(ss[i]);
			String sql = "delete from NET_DATA_MAIN_ATTACHMENT where fileid=? ";
			CommonJdbcUtils.execute(sql, s);
		}
	}

	/***
	 * 根据附件id查询
	 */
	public NetDataMainAttachmentVO queryDataAttachMentById(Long fileid) {
		String sql = "select * from NET_DATA_MAIN_ATTACHMENT where fileid=? ";
		NetDataMainAttachmentVO vo = CommonJdbcUtils.queryFirst(sql, NetDataMainAttachmentVO.class, fileid);
		return vo;

	}

	/**
	 * 医疗机构信息查询
	 */
	public void queryYlbxInfo(Page page, String cxtj1, String cxtj2, String cxtj3) {
		Long userid = BusinessContextUtils.getUserContext().getId();
		StringBuffer queryQL = new StringBuffer();
		queryQL.append("select a.lsh,");
		queryQL.append("(case a.busiid when '2001' then '医药机构基础信息申请' when '200103' then '医疗机构执业许可证'  ");
		queryQL.append(" when '200104' then '药品使用质量管理规范确认书'  when '200105' then '营业执照'  ");
		queryQL.append("when '200106' then '医院等级证书或相应等级批准文件'  when '200107' then '医疗服务场所产权或租赁合同' ");
		queryQL.append("when '200108' then '医师人员信息'  when '200109' then '医技人员信息'  ");
		queryQL.append("when '200110' then '护理人员信息'  when '200111' then '设备清单'  ");
		queryQL.append("when '200112' then '程序及系统开发清单'  when '200113' then '配备药品目录清单' ");
		queryQL.append("when '200114' then '缴纳社会保险费票据及参保人员花名册'  when '200115' then '医院医疗收费标准与物价部门制定价格标准对比清单' ");
		queryQL.append("when '200116' then '国家、省、市组织人事部门认可的专业学术称号专家'  when '200117' then '国家、省、市重点学科证明材料'  ");
		queryQL.append("when '200118' then '量化评分表'  end)  name, ");
		queryQL.append("(case b.clzt when '1' then '受理' when '2' then '提交' when '3' then '初审通过' when '4' then '初审不通过' when '5' then '复审通过' when '6' then '复审不通过' end) status,b.memo ");
		queryQL.append("from net_data a,net_status b where a.lsh=b.lsh and a.busiid like '%2001%' and a.userid=" + userid + " ");
		List<Object> list = new ArrayList<Object>();
		queryQL.append(" order by a.lsh");
		CommonJdbcUtils.queryPage(page, queryQL.toString(), NetDataMainVO.class, list.toArray());

	}

	/**
	 * 附件查询
	 */
	public void queryFjInfo(Page page, String lsh) {
		StringBuffer queryQL = new StringBuffer();
		queryQL.append("select fileid,file_name ");
		queryQL.append("FROM NET_DATA_MAIN_ATTACHMENT where lsh=?  ");
		// List<Object> list=new ArrayList<Object>();
		CommonJdbcUtils.queryPage(page, queryQL.toString(), NetDataMainAttachmentVO.class, lsh);

	}

	/**
	 * 附件查询
	 */
	public void queryAllFjInfo(Page page, String busiid, String data01) {
		Long userid = BusinessContextUtils.getUserContext().getId();
		StringBuffer queryQL = new StringBuffer();
		// queryQL.append("select a.fileid,a.file_name ");
		// queryQL.append("FROM NET_DATA_MAIN_ATTACHMENT a,net_data b where a.lsh=b.lsh and b.busiid=?  ");
		if ("200103".equals(busiid) && "执业时间".equals(data01)) {
			queryQL.append("select a.fileid,a.file_name FROM NET_DATA_MAIN_ATTACHMENT a where a.lsh in (select  to_char(b.lsh) from net_data b where  b.busiid in('200103','200105') and b.userid=? ) ");
			CommonJdbcUtils.queryPage(page, queryQL.toString(), NetDataMainAttachmentVO.class, userid);
		} else {
			queryQL.append("select a.fileid,a.file_name FROM NET_DATA_MAIN_ATTACHMENT a where a.lsh=(select  to_char(b.lsh) from net_data b where  b.busiid=? and b.userid=? ) ");
			CommonJdbcUtils.queryPage(page, queryQL.toString(), NetDataMainAttachmentVO.class, busiid, userid);
		}
		// List<Object> list=new ArrayList<Object>();

	}

	/**
	 * 医疗设备信息查询
	 */
	public void queryYlsb(Page page, String lsh) {
		StringBuffer queryQL = new StringBuffer();
		queryQL.append("select a.* from net_data_list a where a.lsh=? ");
		List<Object> list = new ArrayList<Object>();
		list.add(lsh);
		CommonJdbcUtils.queryPage(page, queryQL.toString(), NetDataListVO.class, list.toArray());

	}

	/**
	 * 查询医师、医技、护理人员信息
	 */
	public void queryNetDataList(Page page, String busiid, NetDataListVO netDataListVO) {
		String data01 = netDataListVO.getData01();
		String data02 = netDataListVO.getData02();
		String data14 = netDataListVO.getData14();
		String data17 = netDataListVO.getData17();
		Long lsh = netDataListVO.getLsh();
		StringBuffer queryQL = new StringBuffer();
		String userid = String.valueOf(BusinessContextUtils.getUserContext().getId());
		queryQL.append("select a.dataid,a.lsh,a.data01,a.data03,a.data02,a.data04,a.data05,a.data06,"
				+ "a.data07,a.data08,a.data09,a.data10,a.data11,a.data52,c.fileid clr,b.memo clzt "
//				+" from net_data_list a,net_data b"
//				+" where a.lsh=b.lsh and b.busiid=? and b.userid=?");
				+" from net_data_list a join net_data b on a.lsh = b.lsh and b.busiid=? and b.userid=?" 
				+" left join NET_DATA_MAIN_ATTACHMENT c on a.dataid = c.lsh and c.file_name = '职称'");//是否有职称附件
		List<Object> list = new ArrayList<Object>();
		list.add(busiid);
		list.add(userid);
		if (StringUtils.hasText(data01)) {
			queryQL.append(" and a.data01 like ? ");
			list.add(data01);
		}
		if (StringUtils.hasText(data02)) {
			queryQL.append(" and a.data02=?");
			list.add(data02);
		}
		if (lsh != null) {
			queryQL.append(" and a.lsh=? ");
			list.add(lsh);
		}
		queryQL.append(" order by a.data52 ");
		CommonJdbcUtils.queryPage(page, queryQL.toString(), NetDataListVO.class, list.toArray());

	}

	/**
	 * 量化评分表主信息查询
	 */
	public void queryLhpfb(Page page, String busiid, NetDataListVO netDataListVO) {
		String userid = String.valueOf(BusinessContextUtils.getUserContext().getId());
		List<Object> list = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("");
		sql.append("select a.lsh,a.objname,a.userid,to_char(a.time,'yyyymmdd') time,b.clzt from net_data a,net_status b where a.lsh= b.lsh and a.memo='提交' and a.busiid='200118' and a.userid=? ");
		list.add(userid);
		if (netDataListVO.getLsh() != null) {// 流水号
			sql.append("and a.lsh=? ");
			list.add(netDataListVO.getLsh());
		}
		if (StringTools.hasText(netDataListVO.getTimeStart()) && netDataListVO.getTimeStart() != null) {
			sql.append(" and a.time >= to_date(?,'yyyy-MM-dd')");
			// list.add(DateTools.getYYYYMMDD(netDataListVO.getTimeStart()));
			list.add(netDataListVO.getTimeStart());
		}
		if (StringTools.hasText(netDataListVO.getTimeEnd()) && netDataListVO.getTimeEnd() != null) {
			sql.append(" and a.time < to_date(?,'yyyy-MM-dd') + 1");
			// list.add(DateTools.getYYYYMMDD(netDataListVO.getTimeEnd()));
			list.add(netDataListVO.getTimeEnd());
		}
		sql.append(" order by a.objname,a.lsh  ");
		CommonJdbcUtils.queryPage(page, sql.toString(), NetDataListVO.class, list.toArray());

	}

	/**
	 * 量化评分表查询
	 */
	public void queryLhpfbInfo(Page page, String busiid, NetDataListVO netDataListVO) {
		String bz = netDataListVO.getBz();
		String data01 = netDataListVO.getData01();
		String data03 = netDataListVO.getData03();
		Long lsh = netDataListVO.getLsh();
		StringBuffer queryQL = new StringBuffer();
		String userid = String.valueOf(BusinessContextUtils.getUserContext().getId());
		// 获取医院信息
		StringBuffer sql1 = new StringBuffer();
		sql1.setLength(0);
		sql1.append("SELECT a.lsh,a.data13,a.data08,a.data12,a.data40 ");
		sql1.append(" FROM NET_DATA_MAIN_S a,NET_DATA_MAIN b");
		sql1.append(" WHERE a.lsh in (SELECT LSH FROM NET_DATA ");
		sql1.append(" WHERE userid = ? and BUSIID='2001' )"); //and memo = '提交'
		
		NetDataListVO dto = CommonJdbcUtils.queryFirst(sql1.toString(), NetDataListVO.class, userid);
		if(dto!=null){
//			if ("1".equals(bz)) {
				//String dtonMsg = "自动打分成功";
				//查询net_data_list流水号
				String sql="select a.lsh from net_data_list a,net_data b where a.lsh=b.lsh and b.busiid=? and b.userid=?";
				NetDataListVO vo = CommonJdbcUtils.queryFirst(sql, NetDataListVO.class,busiid, userid);
//				if (!StringTools.hasText(dto.getData40())) {// 是否已经形成自动打分机制
					String name = "SPK_D1_PFB_WW";
					Integer code = CommonJdbcUtils.executeProcedure(name, vo.getLsh(),Long.valueOf(userid),
							dto.getData08(),dto.getData12());
					System.out.println("返回值=====" + code);
//				}
//			}
		}
		
		
		if ("1".equals(bz)) {
			queryQL.append("select a.listid,a.dataid,a.lsh,a.status,a.data01,a.data02,a.data03,a.data04,"
					+ "a.data05,a.data06,a.data07, a.data08,a.data09,a.data10,a.data11,a.data12,a.data13,"
					+ "a.data14,a.data15,a.data16,a.data17,a.data18,a.data19,a.data20,"
					+ " decode(a.data17,1,a.data21,'') data21,decode(a.data17,1,a.data22,'') data22"
					+ ",a.data23,a.data24,a.data25,a.data26,a.data27,a.data28,a.data29,a.data30,"
					+ " a.data31,a.data32,a.data33,a.data34,a.data35,a.data36,a.data37,"
					+ "a.data38,a.data39,a.data40,a.data41,a.data42,a.data43,a.data44,a.data45,a.data46,"
					+ "a.data47,a.data48,a.data49,a.data50,a.data51,a.data52,a.data53,a.data54,a.data55,"
					+ "a.data56,a.data57,a.data58,a.data59,a.data60,a.data61,a.data62,a.data63,a.data64,"
					+ "a.data65,a.data66,a.data67,a.data68,a.data69,a.data70,a.data71,a.data72,a.data73,"
					+ "a.data74,a.data75,a.data76,a.data77,a.data78,a.data79,a.data80,a.data81,a.data82,"
					+ "a.data83,a.data84,a.data85,a.data86,a.data87,a.data88,a.data89,a.data90,a.data91,"
					+ "a.data92,a.data93,a.data94,a.data95,a.data96,a.data97,a.data98,a.data99,a.data100"
					+ " from net_data_list a,net_data b,net_status c" + " where a.lsh=b.lsh and b.lsh=c.lsh and b.busiid=? and b.userid=?");// "
																																			// +
			// " and c.clzt not in('3','5')
		} else {
			queryQL.append("select a.listid,a.dataid,a.lsh,a.status,a.data01,a.data02,a.data03,a.data04,"
					+ "a.data05,a.data06,a.data07,a.data08,a.data09,a.data10,a.data11,a.data12,a.data13,"
					+ "a.data14,a.data15,a.data16,a.data17,a.data18,a.data19,a.data20,"
					+ "decode(a.data17,1,a.data21,'') data21,decode(a.data17,1,a.data22,'') data22,"
					+ "a.data23,a.data24,a.data25,a.data26,a.data27,a.data28,a.data29,a.data30,"
					+ "a.data31,a.data32,a.data33,a.data34,a.data35,a.data36,a.data37,"
					+ "a.data38,a.data39,a.data40,a.data41,a.data42,a.data43,a.data44,a.data45,a.data46,"
					+ "a.data47,a.data48,a.data49,a.data50,a.data51,a.data52,a.data53,a.data54,a.data55,"
					+ "a.data56,a.data57,a.data58,a.data59,a.data60,a.data61,a.data62,a.data63,a.data64,"
					+ "a.data65,a.data66,a.data67,a.data68,a.data69,a.data70,a.data71,a.data72,a.data73,"
					+ "a.data74,a.data75,a.data76,a.data77,a.data78,a.data79,a.data80,a.data81,a.data82,"
					+ "a.data83,a.data84,a.data85,a.data86,a.data87,a.data88,a.data89,a.data90,a.data91,"
					+ "a.data92,a.data93,a.data94,a.data95,a.data96,a.data97,a.data98,a.data99,a.data100"
					+ " from net_data_list a,net_data b" + " where a.lsh=b.lsh and b.busiid=? and b.userid=?   ");
		}

		// queryQL.append(" and a.lsh=(select max(lsh) from net_data where busiid=? and userid=? )  ");
		List<Object> list = new ArrayList<Object>();
		list.add(busiid);
		list.add(userid);
		// list.add(busiid);
		// list.add(userid);
		if (StringUtils.hasText(data01)) {
			queryQL.append(" and a.data01 like ? ");
			list.add(data01);
		}
		if (StringUtils.hasText(data03)) {
			queryQL.append(" and a.data03=?");
			list.add(data03);
		}
		if (lsh != null) {
			queryQL.append(" and a.lsh=? ");
			list.add(lsh);
		}
		queryQL.append(" order by a.dataid ");
		CommonJdbcUtils.queryPage(page, queryQL.toString(), NetDataListVO.class, list.toArray());

	}

	/**
	 * 根据业务id查询受理材料信息
	 */
	public NetDataMainVO queryNetDataMain(String busiid) {
		StringBuffer queryQL = new StringBuffer();
		// String
		// userid=String.valueOf(BusinessContextUtils.getUserContext().getId());
		Long userid = BusinessContextUtils.getUserContext().getId();
		if ("2001".equals(busiid)) {
			queryQL.append("select a.* ");
			queryQL.append("FROM net_data_main_s a,net_data b,net_status c WHERE a.lsh=b.lsh and b.lsh=c.lsh and b.busiid=? and b.userid=?  ");
		} else {
			queryQL.append("select a.* ");
			queryQL.append("FROM net_data_main a,net_data b,net_status c WHERE a.lsh=b.lsh and b.lsh=c.lsh and b.busiid=? and b.userid=?  ");
			List<NetDataMain> list = CommonJdbcUtils.query(queryQL.toString(), NetDataMain.class, busiid, userid);
			if (list != null && list.size() > 1) {
				// queryQL.append(" and c.clzt not in('4','6') ");
				queryQL.append(" and a.lsh=(select max(lsh) from net_data where busiid='" + busiid + "' and userid=" + userid + " ) ");
			}

		}
		NetDataMain netDataMain = CommonJdbcUtils.queryFirst(queryQL.toString(), NetDataMain.class, busiid, userid);
		NetDataMainVO netDataMainVO = new NetDataMainVO();
		if (netDataMain != null) {
			BeanUtils.copyProperties(netDataMain, netDataMainVO);
			return netDataMainVO;
		} else {
			return null;
		}

	}

	/**
	 * 根据业务id查询net_data_list
	 */
	public List<NetDataListVO> queryNetDataList(String lsh) {
		StringBuffer queryQL = new StringBuffer();
		queryQL.append("select a.* from net_data_list a where a.lsh=? ");
		List<NetDataListVO> list = CommonJdbcUtils.query(queryQL.toString(), NetDataListVO.class, Long.valueOf(lsh));

		return list;

	}

	public String checkLhpfb(String busiid) {
		if ("200118".equals(busiid)) {
			String userid = String.valueOf(BusinessContextUtils.getUserContext().getId());
			String sql = "select a.* from net_data a,net_status b where a.lsh=b.lsh and  a.busiid=? and a.userid=? ";// and
																														// b.clzt
																														// not
																														// in('3','5')
			NetData netData = CommonJdbcUtils.queryFirst(sql, NetData.class, busiid, userid);
			if (netData == null) {
				long lsh = commonService.creatBusinessLog(busiid);
				commonService.saveNetDate(lsh, busiid);
				// NetDataList netDataList=new NetDataList();
				// BeanUtils.copyProperties(netDataMainVO, netDataList);
				// netDataList.setLsh(lsh);
				List<NetDataList> list = getNetDataList(lsh);
				CommonJdbcUtils.save(list);
				return "1";
			} else {
				return "2";
			}
		}
		return "3";

	}

	public List<NetDataList> getNetDataList(Long lsh) {
		List<NetDataList> list = new ArrayList<NetDataList>();
		for (int i = 0; i < 20; i++) {
			NetDataList vo = new NetDataList();
			vo.setLsh(lsh);
			vo.setData19(BusinessContextUtils.getUserContext().getName());// 经办人
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = new java.util.Date();
			String time = sdf.format(date);
			vo.setData20(time);// 经办时间
			if (i == 0) {
				vo.setData01("执业时间");
				vo.setData29("同一执业地点满3个月");
				vo.setData04("5");
				vo.setData30("营业每满1年加1分");
				vo.setData08("2");
				vo.setData10("200103");
				vo.setData35("《医疗机构执业许可证》正、副本");
				vo.setData36("1");
				list.add(vo);
			} else if (i == 1) {
				vo.setData01("药品使用质量管理");
				vo.setData29("符合药品使用质量管理规范");
				vo.setData04("3");
				vo.setData10("200104");
				vo.setData35("《药品使用质量管理规范确认书》正、副本");
				vo.setData36("2");
				list.add(vo);
			} else if (i == 2) {
				vo.setData01("医院等级");
				vo.setData29("有相应等级批准文件");
				vo.setData04("3");
				vo.setData30("取得经卫生计生部门评审的医院等级证书的加5分");
				vo.setData08("5");
				vo.setData10("200106");
				vo.setData35("医院等级证书或相应等级批准文件");
				vo.setData36("3");
				list.add(vo);
			} else if (i == 3) {
				vo.setData01("医疗业务用房建筑面积");
				vo.setData29("达到医院建设基本标准面积");
				vo.setData04("3");
				vo.setData30("每增加500平方米加1分");
				vo.setData08("2");
				vo.setData10("200107");
				vo.setData35("医疗服务场所产权或租赁合同、租赁凭证");
				vo.setData36("4");
				list.add(vo);
			} else if (i == 4) {
				vo.setData01("临床科室设置数量");
				vo.setData29("达到医院基本标准临床科室设置数量");
				vo.setData04("3");
				vo.setData10("200103");
				vo.setData35("《医疗机构执业许可证》正、副本");
				vo.setData36("5");
				list.add(vo);
			} else if (i == 5) {
				vo.setData01("医技科室设置数量");
				vo.setData29("达到医院基本标准医技科室设置数量");
				vo.setData04("3");
				vo.setData10("200103");
				vo.setData35("《医疗机构执业许可证》正、副本");
				vo.setData36("6");
				list.add(vo);
			} else if (i == 6) {
				vo.setData01("核定床位数量");
				vo.setData29("达到医院基本标准床位数量");
				vo.setData04("3");
				vo.setData10("200103");
				vo.setData35("《医疗机构执业许可证》正、副本");
				vo.setData36("7");
				list.add(vo);
			} else if (i == 7) {
				vo.setData01("注册执业于该医疗机构的临床医师人员数量");
				vo.setData29("达到医院基本标准医师配置数量");
				vo.setData04("5");
				vo.setData30("高级职称人数达到3人以上的，每增加一人加1分。");
				vo.setData08("3");
				vo.setData10("200108");
				vo.setData35("专业技术资格证、医师执业证书");
				vo.setData36("8");
				list.add(vo);
			} else if (i == 8) {
				vo.setData01("注册执业于该医疗机构的医技人员数量");
				vo.setData29("每个医技科室不少于1人");
				vo.setData04("3");
				vo.setData10("200109");
				vo.setData35("专业技术资格证、医技人员相关证书");
				vo.setData36("9");
				list.add(vo);
			} else if (i == 9) {
				vo.setData01("注册执业于该医疗机构的护师（士）数量");
				vo.setData29("达到医院基本标准护师（士）配置数量");
				vo.setData04("3");
				vo.setData30("中级职称人数达到5人以上的，每增加一人加1分");
				vo.setData08("2");
				vo.setData10("200110");
				vo.setData35("专业技术资格证、护士执业证书");
				vo.setData36("10");
				list.add(vo);
			} else if (i == 10) {
				vo.setData01("床位与卫生技术人员配备比");
				vo.setData29("达到医院基本标准每床与卫生技术人员配备比");
				vo.setData04("3");
				vo.setData30("配备比每增加0.1加1分");
				vo.setData08("3");
				vo.setData10("200119");
				vo.setData35("");
				vo.setData36("11");
				list.add(vo);
			} else if (i == 11) {
				vo.setData01("床位与护士配备比");
				vo.setData29("达到医院基本标准每床与护士配备比");
				vo.setData04("3");
				vo.setData30("配备比每增加0.1加1分");
				vo.setData08("3");
				vo.setData10("200119");
				vo.setData35("");
				vo.setData36("12");
				list.add(vo);
			} else if (i == 12) {
				vo.setData01("医疗机构设备");
				vo.setData29("达到医院基本标准基本设备和病房每床单元设备配置要求");
				vo.setData04("3");
				vo.setData10("200111");
				vo.setData35("自拟清单，包括设备名称、数量、购进时间；附设备发票复印件");
				vo.setData36("13");
				list.add(vo);
			} else if (i == 13) {
				vo.setData01("信息系统及病案管理");
				vo.setData29("有完善的住院、门诊信息管理系统和药品、耗材进销存信息管理系统，具备与医保系统接口条件，并且满足医保监管要求。确保参保患者可直接使用社会保障卡挂号、就医和费用结算。病案管理规范，能够及时、完整、准确上传病历首页等信息");
				vo.setData04("6");
				vo.setData30("建立完善的电子病历系统的，加2分；开放HIS基础数据，确保医保监管系统能够及时、准确直接获得完整数据的，加5分");
				vo.setData08("5");
				vo.setData10("200112");
				vo.setData35("自拟清单，包括系统开发商名称、使用时间、接口类型，与开发商签订的服务协议。");
				vo.setData36("14");
				list.add(vo);
			} else if (i == 14) {
				vo.setData01("基本医疗保险目录内药品占比");
				vo.setData29("配备的所有药品中，基本医疗保险目录内药品种类占比达到80%以上。（西药种类按通用名计算、中成药种类按药品标准中的正式名称计算，中药饮片除外。）");
				vo.setData04("3");
				vo.setData10("200113");
				vo.setData35("自拟药品目录（基本医疗保险目录内药品加标注）");
				vo.setData36("15");
				list.add(vo);
			} else if (i == 15) {
				vo.setData01("参加社会保险");
				vo.setData29("为符合条件的全体人员按时、足额缴纳社会保险费");
				vo.setData04("5");
				vo.setData10("200114");
				vo.setData35("缴纳社会保险费票据");
				vo.setData36("16");
				list.add(vo);
			} else if (i == 16) {
				vo.setData01("建立完善的医疗服务管理制度和规范的财务制度");
				vo.setData29("有完善的内部管理等各项规章制度、规范的医疗护理技术操作规程。依照法律、行政法规和国务院财政部门的规定建立财务、会计制度。");
				vo.setData04("3");
				vo.setData10("200119");
				vo.setData35("");
				vo.setData36("17");
				list.add(vo);
			} else if (i == 17) {
				vo.setData01("医疗服务项目收费标准");
				vo.setData30("执行物价部门制定的医疗服务项目价格标准的，加2分；全部医疗服务项目收费低于物价部门制定的价格标准10%以上的，加5分。");
				vo.setData08("5");
				vo.setData10("200115");
				vo.setData35("本院医疗收费标准与物价部门制定的价格标准对比");
				vo.setData36("18");
				list.add(vo);
			} else if (i == 18) {
				vo.setData01("医疗专家数量。第一执业地点是该医疗机构的医疗专业专家数量（同一人不重复计数）");
				vo.setData30("获得国家、省、市组织人事部门认可的专业学术称号的，分别每人加5分、3分和2分。其中，院士每人加10分。");
				vo.setData08("10");
				vo.setData10("200116");
				vo.setData35("相关证明材料");
				vo.setData36("19");
				list.add(vo);
			} else if (i == 19) {
				vo.setData01("医疗机构的临床科室属于国家、省、市重点学科的数量");
				vo.setData30("国家级重点学科每增加一个加5分，省级重点学科每增加一个加3分，市级重点学科每增加一个加2分。");
				vo.setData08("10");
				vo.setData10("200117");
				vo.setData35("相关证明材料");
				vo.setData36("20");
				list.add(vo);
			}

		}
		return list;

	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	/**
	 * 回退
	 */
	@Override
	public String updateListForS(Long lsh) {
		Long userid = BusinessContextUtils.getUserContext().getId();
		String data15 = BusinessContextUtils.getUserContext().getName();
		// 是否提交
		List<Object> list1 = new ArrayList<Object>();
		String sql = "update net_data a set a.memo = NULL where a.userid=?";
		list1.add(userid);
		CommonJdbcUtils.execute(sql, list1.toArray());

		// 是否自动打分
		List<Object> list2 = new ArrayList<Object>();
		String sql1 = "update NET_DATA_MAIN_S set data40='' where lsh=(select lsh from net_data where busiid = '2001' and userid = ?) ";
		list2.add(userid);
		CommonJdbcUtils.execute(sql1, list2.toArray());

		// 回退记录
		List<Object> list3 = new ArrayList<Object>();
		Date upDate = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String clsj = df.format(upDate);
		String sql2 = "INSERT INTO NET_BACK VALUES (?,'2',?,?)";
		list3.add(userid);
		list3.add(data15);
		list3.add(clsj);
		CommonJdbcUtils.execute(sql2, list3.toArray());

		// 修改状态
		List<Object> list4 = new ArrayList<Object>();
		String sql3 = "update net_status set link = '1' ,clzt = '1' where lsh in(select b.lsh from net_data b where b.userid = ?)";
		list4.add(userid);
		CommonJdbcUtils.execute(sql3, list4.toArray());

		// 回退打过的分
		List<Object> list5 = new ArrayList<Object>();
		String sql4 = "update net_data_list set data21 = '' ,data22 = '' where lsh =?";
		list5.add(lsh);
		CommonJdbcUtils.execute(sql4, list5.toArray());
		return "1";

	}

	/**
	 * 处理状态查询
	 */
	@Override
	public void queryClzt(Page page, String userid) {
		StringBuffer sql = new StringBuffer();
		List<Object> list = new ArrayList<Object>();
		sql.append(" select * from net_back where userid = ?");
		list.add(userid);
		CommonJdbcUtils.queryPage(page, sql.toString(), NetDataListVO.class, list.toArray());

	}

	@Override
	public NetDataMainVO validateYsInfo(NetDataMainVO netDataMainVO, String busiid) {
		netDataMainVO.setStatus("1");
		netDataMainVO.setName("校验成功，继续提交！");
		Long dataid = netDataMainVO.getDataid();
		if (dataid != null) {
			String sql = "select * from net_data_list where dataid=? and lsh=? ";
			Long lsh = netDataMainVO.getLsh();
			NetDataList netDataList = CommonJdbcUtils.queryFirst(sql, NetDataList.class, dataid, lsh);

			if (netDataList == null) {
				netDataMainVO.setStatus("3");
				netDataMainVO.setName("系统无该数据记录，请刷新页面后重新操作！");
				return netDataMainVO;
			}

			// 医师、医护、医技人员保存前判断
			netDataMainVO = yyglPersonValidation_error(netDataMainVO, busiid);
			if ("3".equalsIgnoreCase(netDataMainVO.getStatus())) {
				return netDataMainVO;
			}
			netDataMainVO = yyglPersonValidation_warn(netDataMainVO, busiid);
			if ("10".equalsIgnoreCase(netDataMainVO.getStatus())) {
				return netDataMainVO;
			}
		} else {
			// 医师、医护、医技人员保存前判断
			netDataMainVO = yyglPersonValidation_error(netDataMainVO, busiid);
			if ("3".equalsIgnoreCase(netDataMainVO.getStatus())) {
				return netDataMainVO;
			}
			netDataMainVO = yyglPersonValidation_warn(netDataMainVO, busiid);
			if ("10".equalsIgnoreCase(netDataMainVO.getStatus())) {
				netDataMainVO.setStatus("10");
			}
		}
		return netDataMainVO;
	}
	@Override
	public void queryNetDataList2(Page page, String busiid,
			NetDataListVO netDataListVO) {
		String data01 = netDataListVO.getData01();
		StringBuffer queryQL = new StringBuffer();
		queryQL.append("SELECT cause,data01,data02,data03,data04,data05,data06,data07,data08,data09,data10,data11 FROM err_data_list WHERE pc=? and lx=?");
		List<Object> list = new ArrayList<Object>();
		list.add(data01);
		list.add(busiid);
		CommonJdbcUtils.queryPage(page, queryQL.toString(), NetDataListVO.class, list.toArray());
		
	}
	//导入excel返回前台的信息
	public String getError(String message,List<NetDataMainVO> vos,String busiid) {
        JSONObject obj = new JSONObject();
        obj.put("message", message);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pc=sdf.format(new Date());
        obj.put("pc", pc);
        String sql="insert into err_data_list(err_id,pc,lx,cause,data01,data02,data03,data04,data05,data06,data07,data08,data09,data10,data11) values(seq_err_id.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        for(int i=0;i<vos.size();i++){
        	CommonJdbcUtils.execute(sql, pc,busiid,vos.get(i).getName(),vos.get(i).getData01(),vos.get(i).getData02(),vos.get(i).getData03(),vos.get(i).getData04(),vos.get(i).getData05(),vos.get(i).getData06(),vos.get(i).getData07(),vos.get(i).getData08(),vos.get(i).getData09(),vos.get(i).getData10(),vos.get(i).getData11());
        }
        return obj.toString();
    }

	@Override
	public List<ExportVO> exportYs(String busiid, String pc) {
		StringBuffer queryQL = new StringBuffer();
//		queryQL.append("SELECT cause,data01,data02,data03,data04,data05,data06,data07,data08,data09,data10,data11 FROM err_data_list WHERE pc=? and lx=?");
		queryQL.append("SELECT cause,data01,data02,decode(data03,'1','男','2','女')data03,decode(data04,'1','退休','2','在职')data04,");
		queryQL.append("data05,data06,decode(data07,'1','临床','2','中医','3','口腔','4','公共卫生')data07,data08,");
		queryQL.append("decode(data09,'0','无','1','初级','2','中级','3','高级')data09,data10,data11 FROM err_data_list ");
		queryQL.append(" WHERE pc=? and lx=?");
		List<Object> list = new ArrayList<Object>();
		list.add(pc);
		list.add(busiid);
		List<ExportVO> volist = CommonJdbcUtils.query(queryQL.toString(), ExportVO.class, list.toArray());
		return volist;
	}

}
