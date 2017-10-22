package lam.screen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class SimpleClientCore {
	private String host = "127.0.0.1";
	private int port = 9091;
	private boolean connecting = true;
	@Resource
	private ClientFrame clientFrame;
	/*@Resource
	private ServerConfig config;*/
	Logger logger =LoggerFactory.getLogger(SimpleClientCore.class);
	private Socket socket =null;
	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;
	
	public void connectToServer() throws UnknownHostException, IOException{
		connecting =true;
		socket = new Socket(host, port);
		bufferedReader = new BufferedReader(new InputStreamReader
				(socket.getInputStream(), "utf-8"));
		bufferedWriter = new BufferedWriter(new OutputStreamWriter
				(socket.getOutputStream(),"utf-8"));
		
	}

	public Future<String> makeRequest(String string) throws IOException {
		// TODO Auto-generated method stub
		if (bufferedWriter == null) {
			logger.debug("null writer exception");
			return null;
		}
		bufferedWriter.write(string);
		bufferedWriter.newLine();
		bufferedWriter.flush();;
		return new AsyncResult<String>("requestends");
		
	}
	@Async
	public Future<String> analysisResponce() throws IOException{
		if(bufferedReader == null){
			logger.debug("null reader exception");
			return null;
		}
		String info;
		//如果 客户点没有主动关闭连接 并且服务器没有关闭  则循环 追加服务器广播的信息
		while(connecting && ((info =bufferedReader.readLine())!=null)){
			clientFrame.getjTextArea0().append(info+System.lineSeparator());
		}
		return new AsyncResult<String>("analysis ends");
		
	}
	@Async
	public void disconnectToServer() throws IOException{
		connecting =false;
		if (bufferedReader!= null) {
			bufferedReader.close();
		}
		if (bufferedWriter!= null) {
			bufferedWriter.close();
		}
		socket.close();
	}

}
