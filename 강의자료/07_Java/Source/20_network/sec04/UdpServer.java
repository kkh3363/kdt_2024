package sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class UdpServer extends Thread {
	private static DatagramSocket datagramSocket = null;
	
	public static void main(String[] args) {
		System.out.println("서버를 시작합니다.");
		
		//UDP 서버 시작
		startServer();

	}
	public static void startServer() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					//클라이언트가 구독하고 싶은 뉴스 주제 얻기
					DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
					datagramSocket.receive(receivePacket);
					String newsKind = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
					
					//클라이언트의 IP와 Port 얻기
					SocketAddress socketAddress = receivePacket.getSocketAddress();

					//10개의 뉴스를 클라이언트로 전송
					for(int i=1; i<=10; i++) {
						String data = newsKind + ": 뉴스" + i;
						byte[] bytes = data.getBytes("UTF-8");
						DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
						datagramSocket.send(sendPacket);
					}
					
				}catch (Exception e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		//스레드 시작
		thread.start();
	}
	
}
