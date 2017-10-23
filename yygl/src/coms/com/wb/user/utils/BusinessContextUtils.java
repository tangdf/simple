package com.wb.user.utils;

import java.util.Date;

import com.wb.user.model.UaasUserVO;

/**
 * 
 * @author xue
 * 2015-9-27
 */
public class BusinessContextUtils {
	private static BusinessUserContexThreadLocal userContext =new BusinessUserContexThreadLocal();
	public static UaasUserVO getUserContext(){
		return userContext.get();
	}
	
	public static void setUserContext(UaasUserVO uaasUserVO){
		userContext.set(uaasUserVO);
	}
}
