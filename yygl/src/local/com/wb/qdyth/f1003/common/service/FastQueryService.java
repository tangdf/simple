package com.wb.qdyth.f1003.common.service;

import com.wb.jdbcutils.Page;
import com.wb.qdyth.f1003.common.vo.JdcjcxVo;
import com.wb.qdyth.f1003.common.vo.JdzscxVo;





/**
 * 快速信息查询公用Service
 * @author xue
 * 2015-9-25
 */
public interface FastQueryService {
	public void queryJmylxx(Page page,Long aac001,String aac002);
	public JdcjcxVo queryJdcjcxVo(String sfzh, String code);
	public JdzscxVo queryJdzscxVo(String cardcode, String name);
	public void queryGsrdcx(Page page,Long aac001,String aac003);
	public void queryLdnljdcx(Page page,String aac002);
	public void queryDbyljzcx(Page page,String aac002,String aac001);
	public void queryLgscx(Page page,String aac147);
	public void queryZyjsjjcx(Page page,String cxtj1,String cxtj2,String cxtj3);
	public void queryYlbxMlcx(Page page,String cxtj1,String cxtj2,String cxtj3);
	public void queryDdyyyfcx(Page page,String cxtj1);
	public void queryZlxmfwsscx(Page page,String cxtj1,String cxtj2);
	public void queryBzmlcx(Page page,String cxtj1,String cxtj2);
	public void querySybzcx(Page page,String cxtj1,String cxtj2);
	public void querySyyljjcx(Page page,String cxtj1);
	public void queryYbhccx(Page page,String cxtj1,String cxtj2);
}
