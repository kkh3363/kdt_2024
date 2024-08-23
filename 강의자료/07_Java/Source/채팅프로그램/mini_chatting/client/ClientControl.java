package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javafx.scene.Parent;
import javafx.scene.control.TextArea;

public class ClientControl {
	Parent parentFxml;
	public Socket curSocket;
	private String serverAddress;
	private int	port;
	
	public ClientControl( String serverAddress, int	port, Parent parentFxml) {
		this.parentFxml = parentFxml;
		curSocket = null;
		this.serverAddress = serverAddress;
		this.port = port;
	}
	public String getServerAddress() {
		return serverAddress;
	}
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public void connectServer() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					curSocket = new Socket(getServerAddress(), getPort());
					receive();
							
				} catch (Exception e) {
					if(!curSocket.isClosed()) {
						//stopClient 메소드를 호출해서 클라이언트를 종료
						stopClient();
						System.out.println("[서버 접속 실패]");
						//프로그램 자체를 종료시킨다.
						this.stop();
					}
				}
			}
		};
		thread.start(); 
	}
	public void stopClient() {
		try {
			// 소켓이 열려있는 상태라면 
			if(curSocket != null && !curSocket.isClosed()) {
				curSocket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	public void receive() {
		while(true) {
			try {
				
				InputStream in = curSocket.getInputStream();
				byte[] buffer = new byte[512];
				int length = in.read(buffer);
				if(length == -1 ) 
					throw new IOException();

				String message = new String(buffer, 0, length, "UTF-8");
				TextArea textArea = (TextArea)parentFxml.lookup("#textArea");
				textArea.appendText(message + "\n");
				
			} catch (Exception e) {
				//오류가 발생했을 때는 stopClient 호출 후 반복문 break;
				stopClient();
				break;
			}
		}
	}
	public void send(String message) {
			
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					OutputStream out = curSocket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
					
				} catch (Exception e) {
					//오류가 발생했다면
					stopClient();
				}
			}
		};
		thread.start();
	}
}
