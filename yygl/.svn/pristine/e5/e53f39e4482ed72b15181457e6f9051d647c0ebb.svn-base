package com.wb.qdyth.f1001.f100109.utils;

import com.wb.qdyth.f1001.f100109.vo.StringObject;




public class BankRetInfoUtils {
	//截取位数出来，其他的剩余
	public static String splitStrToPosLen(StringObject target, int length, boolean flag){
		if(target==null)
			return null;
		if(target.getValue()==null)
			return null;
		if(target.getValue().length()<length)
			return null;
		String result = null;
		result = target.getValue().substring(0,length);
		target.setValue(target.getValue().substring(length));
		if(result==null)
			result = "";
		return result;
	}
	public static String formatStrToLen(String target, int length){
		String result = null;
		if(target==null){
			for(int i=0;i<length;++i)
				result += " ";
			return result;
		}
		if(target.length()==length)
			return target;
		if(target.length()<length){
			result = target;
			for(int i=0;i<(length-target.length());++i){
				result += " ";
			}
			return result;
		}
		if(target.length()>length){
			result = target.substring(0,length);
			return result;
		}
		return result;
	}
	public static String formatStrToLenNumber(String target, int length){
		String result = null;
		if(target==null){
			for(int i=0;i<length;++i)
			    result = "0"+result;
			return result;
		}
		if(target.length()==length)
			return target;
		if(target.length()<length){
			result = target;
			for(int i=0;i<(length-target.length());++i){
				result = "0"+result;
			}
			return result;
		}
		if(target.length()>length){
			result = target.substring(0,length);
			return result;
		}
		return result;
	}
}
