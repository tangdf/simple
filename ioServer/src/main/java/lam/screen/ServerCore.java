package lam.screen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class ServerCore {
	@Resource
	private SimpleClientCore simpleClient;
	
	Logger logger = LoggerFactory.getLogger(ServerCore.class);
	private Vector<Socket> sockets  = new Vector<>(10);
//	private Vector<Future<String>> futures = new Vector<>();
	private BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>(8);
	
	private ServerSocket serverSocket;
	private int port = 9091;
	private boolean listening = true;
	private boolean connecting = true;
	private BufferedReader bufferedReader = null;
	
	private BufferedWriter bufferedWriter =null;
	
	@Async
	public Future<String> manyToOneListenLoop() throws IOException, InterruptedException{
		serverSocket = new ServerSocket(port);
		//Future<String> future = null;
		while(listening){
			Socket socket = serverSocket.accept();
			sockets.add(socket);
			this.OneToOneRequestLoop(socket);
	
			logger.debug(socket.getInetAddress().toString());
		}
		

		return new AsyncResult<String>("listenloop ends");
		
	}
	@Async
	public  Future<String> OneToOneRequestLoop(Socket socket) throws IOException, InterruptedException{
		
		bufferedReader = new BufferedReader(new InputStreamReader
				(socket.getInputStream(), "utf-8"));
		String message;
		while (((message = bufferedReader.readLine()) != null) && connecting) {
			logger.debug(message);
			messageQueue.put(message);
		}
		sockets.remove(socket);
		socket.close();
		
		return new AsyncResult<String>("requestloop ends");
	
		
	}
	@Async
	public  Future<String> OneToManyResponceLoop() throws InterruptedException, IOException{
		while (connecting) {
			String info = messageQueue.take();
			for (Socket socket : sockets) {
				if (socket.isClosed()) {
					sockets.remove(socket);
					continue;
				}
				bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
				bufferedWriter.write(socket.getInetAddress().toString()+"---->>"+info);
				bufferedWriter.newLine();
				bufferedWriter.flush();
				

			}
			logger.debug("number of socket connection : "+sockets.size());

		}
		return new AsyncResult<String>("responceloop ends");
	}
	
	public void shutdownServer() throws IOException{
		listening =false;
		connecting = false;
		Future<String> future =simpleClient.makeRequest("sorry server is shutingdown");
		
		try {
			logger.debug("future :"+future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferedReader.close();
		bufferedWriter.close();
		
	}

}
