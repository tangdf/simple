package com.wb.qdyth.f1001.f100109.vs;

import java.util.List;

import com.wb.contain.listener.model.APPAA10;
import com.wb.jdbcutils.Page;
import com.wb.qdyth.f1001.common.vo.UserVO;
import com.wb.qdyth.f1001.f100109.vo.PersonQueryVO;
import com.wb.qdyth.f1001.f100109.vo.Psbank;
import com.wb.qdyth.f1001.f100109.vo.SbkVO;




/**
 * 个人自助打印
 * @author xue
 * 2015-11-10
 */
public interface SbkService {
	 /**
	  * 社保卡申领进度查询
	  * @param page
	  * @param aac001
	  */
	 public void querySbkApplyProgress(Page page,String aac001);
	 /**
	  * 社保卡消费明细查询
	  * @param page
	  * @param aac001
	  */
	 public void querySbkConsume(Page page,String aac001);
	 /**
	  * 社保卡消费明细查询
	  * @param page
	  * @param aac001
	  */
	 public SbkVO querySbkConsumeSum(String aac001);
		/**
		 * //社保卡卡金查询
		 * @param aac001
		 * @return
		 */
	public PersonQueryVO querySbkye(String aac001);
	/**
	 * 查询社保卡申领相关信息
	 * @param aac001
	 */
public UserVO querySbkApplyInfo(String aac001);
/**
 * 保存社保卡申领信息
 * @param personQueryVO
 * @return
 */
public Psbank saveSbkApplyInfo(UserVO personQueryVO);
/**
 * 查询银行列表
 * @return
 */
public List<APPAA10> queryYhlb();
/**
 * 银行网点
 * @return
 */
public List<APPAA10> queryWdbm(String aea001One);
/**
 * 银行网点(级联用)
 * @return
 */
public List<APPAA10> queryWdxx2(String nodeid);
/**
 * 银联挂失
 * @param aac001
 * @param cardNum
 */
public void doGsyl(String aac001, String cardNum);
/**
 * 口头挂失
 * @param aac001
 * @param aac002
 * @param ylkzt
 * @param userid
 * @return
 */
public void saveLsgs(String aac001, String aac002, String ylkzt, Long userid);
}
