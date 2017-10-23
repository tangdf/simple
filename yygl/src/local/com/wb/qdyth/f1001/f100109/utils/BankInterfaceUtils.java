package com.wb.qdyth.f1001.f100109.utils;

import com.wb.qdyth.f1001.f100109.vo.RetMessageHead;
import com.wb.qdyth.f1001.f100109.vo.SendMessageHead;




public class BankInterfaceUtils {
	//字符后面补空格，数字前面补零
	public static StringBuffer assembSendMessageHead(SendMessageHead sendMessageHead){
		StringBuffer sendHeadInfo = new StringBuffer();
		sendHeadInfo.append(sendMessageHead.getTrxtype());
		sendHeadInfo.append(sendMessageHead.getActcode());
		sendHeadInfo.append(sendMessageHead.getLgntype());
		sendHeadInfo.append(sendMessageHead.getSource());
		sendHeadInfo.append(sendMessageHead.getLgninstcode());
		sendHeadInfo.append(sendMessageHead.getLgnpartner());
		sendHeadInfo.append(sendMessageHead.getLgnmerchcode());
		sendHeadInfo.append(sendMessageHead.getLgnusercode());
		sendHeadInfo.append(sendMessageHead.getTerm_trace());
		
		return sendHeadInfo;
	}
	
	//字符后面补空格，数字前面补零
	public static StringBuffer assembRetMessageHead(RetMessageHead retMessageHead){
		StringBuffer retHeadInfo = new StringBuffer();
		retHeadInfo.append(retMessageHead.getTrxtype());
		retHeadInfo.append(retMessageHead.getLgntype());
		retHeadInfo.append(retMessageHead.getRetcode());
		retHeadInfo.append(retMessageHead.getLgninstcode());
		retHeadInfo.append(retMessageHead.getLgnpartner());
		retHeadInfo.append(retMessageHead.getLgnmerchcode());
		retHeadInfo.append(retMessageHead.getLgnusercode());
		retHeadInfo.append(retMessageHead.getTerm_trace());
		
		return retHeadInfo;
	}
}
