package minichatting.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	//네트워크상에서 통신하기 위한 소켓 
	Socket socket;
	
	//매개변수를 통해 넘어오는 것을 이용해서 소켓을 초기화하는 생성자 
	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}
		
	// 클라이언트로부터 메시지를 전달 받는 메소드.
	public void receive() {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];
						int length = in.read(buffer);
						
						// 메시지를 읽어들일 때 오류가 발생했다면 알려줌. 
						while(length== -1) throw new IOException();
						
						System.out.println("[메시지 수신 성공] " 
								+ socket.getRemoteSocketAddress() // 클라이언트의 주소 정보 출력 
								+ "; " + Thread.currentThread().getName()); // Thread의 고유한 정보(이름값) 출력
						
						String message = new String(buffer, 0, length, "UTF-8");
						
						// 단순하게 메시지를 전달만 받는 것이 아니라, 전달받은 메시지를 다른 클라이언트에게도 보낼 수 있도록 만든다.
						for(Client client : ChatServer.clients) {
							client.send(message);
						}
						 
					}
				}catch (Exception e) {
					try {
						System.out.println("[메시지 수신 오류] "
								+ socket.getRemoteSocketAddress() // 메시지를 보낸 클라이언트를 주소 출력  
								+ ": " + Thread.currentThread().getName()); // 해당 Thread의 고유 이름도 출력.
					} catch (Exception e2) {
					}
				}
			}
		};
		// Thread를 안정적으로 관리하기 위해서 Thread를 ThreadPool에 등록해준다.
		ChatServer.threadPool.submit(thread) ;
	}
		
		
	// 클라이언트에게 메시지를 전송하는 메소드.
	public void send(String message) {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
				} catch (Exception e) {
					try {
						System.out.println("[메시지 송신 오류] "
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						
						// 오류가 발생했다면, ChatServer에 있는 모든 클라이언트를 담아둔 배열에서 현재 존재하는 클라이언트를 지워준다. 
						// 오류가 발생해서 해당 클라이언트가 서버로부터 접속이 끊겼으니까 당연히 서버 내에서도 해당 클라이언트가 접속이 끊겼다는 정보를 처리.
						// 즉, 클라이언트에서 오류가 생긴 클라이언트를 제거해준다.
						ChatServer.clients.remove(Client.this);
						socket.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				};
			}
		};
		ChatServer.threadPool.submit(thread);
	}
}
