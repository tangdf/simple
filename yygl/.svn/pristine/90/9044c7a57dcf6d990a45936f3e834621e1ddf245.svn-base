package com.wb.qdyth.f1001.f100109.utils;


import com.wondersgroup.security.scmutils.CStringList;
import com.wondersgroup.security.scmutils.CodecUtils;
import com.wondersgroup.security.xmldb.xDataSet;
import com.wondersgroup.security.xmlmom.CxmlmomReg;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class BankCallUtils
{
  private static String HOST = "172.16.3.10";
  private static int PORT = 11000;
  private static int TIMEOUT = 2000;
  private static final String REQ_SERVICE = "pkgBank.CallBankB64";
  private static final String QRY_SERVICE = "pkgBank.QueryCallBankB64";
  private static final int QRY_TIME = 250;
  private static boolean DEBUG = false;

  public void setHost(String host)
  {
    HOST = host;
  }

  public void setPort(int port) {
    PORT = port;
  }

  public void setTimeout(int timeout) {
    TIMEOUT = timeout;
  }

  public void setDebug(boolean debug) {
    DEBUG = debug;
  }

  public static String call(String bid, String msg)
  {
    return call(bid, msg, 30000);
  }

  public static String call(String bid, String msg, int timeout)
  {
    int count = 0;

    int maxCount = timeout / 250;

    String result = null;

    CxmlmomReg.initSocketParam(HOST, PORT, TIMEOUT);
    CxmlmomReg.xconn.initTransactionClientOnly();

    CStringList reqSend = new CStringList();
    Vector reqRecv = new Vector();

    String body = createMsg(msg);

    log(String.format("閾惰仈璇锋眰:璇锋眰鏁版嵁銆�s銆�, new Object[] { msg }"));

    reqSend.add(body);
    CxmlmomReg.xconn.cmdCall("pkgBank.CallBankB64", reqSend, reqRecv);

    String status = (String)reqRecv.get(0);
    if (status == null) {
      err("璋冪敤閾惰仈鎺ュ彛澶辫触銆愬墠缃満娌℃湁杩斿洖鏁版嵁銆�");
      throw new RuntimeException("0001");
    }

    if (!("OK".equals(status))) {
      err("璋冪敤閾惰仈鎺ュ彛澶辫触銆愬墠缃満杩斿洖鏁版嵁涓嶆纭�!");
      throw new RuntimeException("0002");
    }

    if (DEBUG) {
      log("reqRecv:銆� + getRecordData(reqRecv) + ");
    }

    CStringList qrySend = new CStringList();
    Vector qryRecv = null;

    String slsh = pad(bid, 16);
    qrySend.add(slsh);

    while ((result == null) || ("NULL".equals(result)))
    {
      if (count++ > maxCount) {
        err("浠庡墠缃満鑾峰彇杩斿洖鏁版嵁瓒呮椂!");
        throw new RuntimeException("0009");
      }

      try
      {
        Thread.sleep(250L);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      log(String.format("杞鏁版嵁锛屾祦姘村彿:銆�s銆戯紝绗�d娆�, new Object[] { slsh, Integer.valueOf(count) }"));
      qryRecv = new Vector();
      CxmlmomReg.xconn.cmdCall("pkgBank.QueryCallBankB64", qrySend, qryRecv);

      status = (String)qryRecv.get(0);

      if ("OK".equals(status)) {
        result = base64ToString(qryRecv);
      }

    }

    return result;
  }

  private static String getRecordData(Vector v)
  {
    String result = null;
    byte[] data = (byte[])v.get(1);

    xDataSet ds = new xDataSet();
    ds.openByteDataSet(data);
    ds.openRecord("DATA");
    result = ds.readRecord("DATA");
    ds.closeRecord();
    ds.closeDataSet();

    return result;
  }

  private static String base64ToString(Vector v)
  {
    String result = getRecordData(v);
    try
    {
      result = new String(CodecUtils.base64ToByte(result), "GBK");
    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return result;
  }

  private static String stringTobase64(String msg)
  {
    try
    {
      log(msg);
      return CodecUtils.byteToBase64(msg.getBytes("GBK"));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return msg;
  }

  private static String encode(String msg)
  {
    if ((msg == null) || ("NULL".equals(msg)) || (msg.length() <= 4))
      return msg;

    return msg;
  }

  private static String createMsg(String msg)
  {
    return stringTobase64(msg);
  }

  public static String pad(String str, int length, boolean left)
  {
    StringBuffer sb = new StringBuffer(length);
    sb.append(str);
    while (sb.length() < length) {
      if (left)
        sb.insert(0, "0");
      else
        sb.append("0");

    }

    return sb.toString();
  }

  public static String pad(String str, int length) {
    return pad(str, length, true);
  }

  private static String getCurrentDateTime() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss.SSS");

    return format.format(new Date());
  }

  private static void log(String msg)
  {
    System.out.println(getCurrentDateTime() + ":" + msg);
  }

  private static void err(String msg)
  {
    System.err.println(getCurrentDateTime() + ":" + msg);
  }

  public static void main(String[] args)
    throws InterruptedException, UnsupportedEncodingException
  {
    System.out.println(System.getProperty("file.encoding"));

    for (int i = 90001; i < 90002; ++i)
    {
      String lsh = "7" + pad(String.valueOf(i), 15);
      String msg = "395100CT12063702                              IVR                 " + lsh + "04844193鍥�";

      String ret = call(lsh, msg, 10000);
      err("ret:" + ret);
    }
  }
}