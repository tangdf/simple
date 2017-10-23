package com.wb.qdyth.common.action;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wb.jdbcutils.CommonJdbcUtils;
import com.wb.qdyth.common.bo.PasswordResetVO;


@SuppressWarnings("unused")
public class SendSms {
	// 150325160639256034
	// 150325161659365457
	private static final Log log = LogFactory.getLog(SendSms.class);
	//private static  String SERVICE_ENDPOINT0 = "http://35.1.3.19/sms/webservice/sms.asmx?WSDL";
	//private static final String SERVICE_ENDPOINT = "http://35.1.3.19/sms/webservice/sms.asmx?WSDL";
	private static  String SERVICE_ENDPOINT = "http://188.5.38.119/sms/webservice/sms.asmx?WSDL";
	private static final String NameSpaceURI = "http://tempuri.org/";
	private static final String SOAPActionURI = "http://tempuri.org/GetSendMessageStatus";
	private static final String sendKey="12346";//12346(分配给电政办审批的号)
	private static final String orgCode="100";//1001（电政办代码）
	private static final String checkCode="8888";//8888（验证码）
	private static final String SENDNAME="sendName";//发送人[可为空]
	private static final String SENDGUID="sendGUID";//发送人唯一标识[可为空]
	private static final String SENDIP="sendIP";//发送人的IP[可为空]
	private static final String SENDMOBILE="sendMobile";//发送人的手机号[可为空]
	
	public static void main(String[] args) {
		String task=SendSms.SendMessageData("14753153963", "测试短信接口", "青岛人社局");
		System.out.println(task);
		//String info=SendSms.GetSendMessageStatus("150326145847722360");
		//System.out.println(info);
	}

	public static String SendMessageData(String strMobile,String messageContent,String sendName) {
		String result = null;
		//获取服务地址
		//判断是外网还是自助服务区
				String sql="select AAA103 errormesg  FROM aa10web WHERE aaa100='SMS_SERVICE_ENDPOINT'";
				PasswordResetVO vo = CommonJdbcUtils.queryFirst(sql, PasswordResetVO.class);
				if(vo!=null){
					setSERVICE_ENDPOINT(vo.getErrormesg());
				}
				
			try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(SERVICE_ENDPOINT);
			call.setOperationName(new QName("http://tempuri.org/","SendMessageData"));
			call.setSOAPActionURI("http://tempuri.org/SendMessageData");
			call.addParameter(new QName(NameSpaceURI,"strMobile"),
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
			call.addParameter(new QName(NameSpaceURI,"messageContent"),
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
			call.addParameter(new QName(NameSpaceURI,"sendKey"), org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
			call.addParameter(new QName(NameSpaceURI,"orgCode"), org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
			call.addParameter(new QName(NameSpaceURI,"checkCode"),
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
		/*	call.addParameter(new QName(NameSpaceURI,"sendName"), org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
			call.addParameter(new QName(NameSpaceURI,"sendGUID"), org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
			call.addParameter(new QName(NameSpaceURI,"sendIP"), org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
			call.addParameter(new QName(NameSpaceURI,"sendMobile"),
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数*/
			call.setReturnType(new QName("http://tempuri.org/","SendMessageData"), Vector.class);
			Object obj= call.invoke(new Object[] { strMobile,messageContent,"12346", "1001", "8888" });
			result= obj+"";
			// 给方法传递参数，并且调用方法
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void setSERVICE_ENDPOINT(String sERVICE_ENDPOINT) {
		SERVICE_ENDPOINT = sERVICE_ENDPOINT;
	}

	//获取发送状态信息
	public static String GetSendMessageStatus(String taskID) {
		String result = null ;
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(SERVICE_ENDPOINT);
			call.setOperationName(new QName("http://tempuri.org/","GetSendMessageStatus"));
			call.setSOAPActionURI("http://tempuri.org/GetSendMessageStatus");
			call.addParameter(new QName(NameSpaceURI,"sendKey"), org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
			call.addParameter(new QName(NameSpaceURI,"orgCode"), org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
			call.addParameter(new QName(NameSpaceURI,"checkCode"),
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
			call.addParameter(new QName(NameSpaceURI,"taskID"), org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);// 接口的参数
			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
			result = (String) call.invoke(new Object[] { "12346","1001", "8888", taskID });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}