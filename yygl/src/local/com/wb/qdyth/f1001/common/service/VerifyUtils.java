package com.wb.qdyth.f1001.common.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VerifyUtils {

	/**
	 * 获取校验码
	 * @param type
	 * @param pcode
	 * @return
	 */
	public static String getVerifyCode(String type,String pcode){
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd");
		String datetime=sdf.format(new Date());
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<pcode.length();i++){
			sb.append(pcode.charAt(i));
			if(i<6)sb.append(datetime.substring(i,i+1));
		}
		return type.toUpperCase()+sb.toString();
	}

	public static void main(String[] args) {
		String a="A1",b="3702021398",c="";
		StringBuffer sb=new StringBuffer();
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd");
		c=sdf.format(new Date());
		for(int i=0;i<b.length();i++){
			sb.append(b.charAt(i));
			if(i<6)sb.append(c.substring(i,i+1));
		}
		System.out.println(a+sb.toString());
	}
}
