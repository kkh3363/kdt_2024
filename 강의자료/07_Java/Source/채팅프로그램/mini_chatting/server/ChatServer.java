package server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class ChatServer extends Application {
	
	public static ExecutorService threadPool;
	public static Vector<Client> clients = new Vector<Client>();
	ServerSocket serverSocket;
	
	@Override
	public void start(Stage primaryStage) throws Exception  {
		Parent root = (Parent)FXMLLoader.load(getClass().getResource("RootServer.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("서버");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//자기 자신의 컴퓨터 주소 : local address
		String IP = "127.0.0.1";
		int port = 9876;
		ToggleButton runBtn = (ToggleButton) root.lookup("#runBtn");
		TextArea textArea = (TextArea) root.lookup("#textArea");
		
		runBtn.setOnAction(event -> {
			if(runBtn.getText().equals("시작하기")) {
				startServer(IP, port);
				// runLater를 써서 GUI요소를 출력할 수 있도록 해야 한다.
				Platform.runLater(()->{
					String message = String.format("[서버 시작]\n",IP, port);
					textArea.appendText(message);
					runBtn.setText("종료하기");
				}); 
			} else {
				// 버튼의 상태가 '종료하기' 였으므로 서버를 종료해주고, 버튼 text를 변경해준다.
				stopServer();
				Platform.runLater(()->{
					String message = String.format("[서버 종료]\n",IP, port);
					textArea.appendText(message);
					runBtn.setText("시작하기");
				}); 
			}
		});
		
		
	}
	
	public void startServer(String IP, int port) {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, port));
		} catch (Exception e) {
			e.printStackTrace();
			if(!serverSocket.isClosed()) {
				stopServer(); // 서버 종료
			}
			return;
		}
		
		// 쓰레들을 만들어서 하나의 클라이언트가 접속할 때까지 계속 기다리면 됨.
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						// 새로운 클라이언트가 접속할 수 있도록.
						Socket socket = serverSocket.accept();
						// 클라이언트가 접속을 했다면, 클라이언트 배열에 새롭게 접속한 클라이언트를 추가.
						clients.add(new Client(socket)); 
						System.out.println("[클라이언트 접속] "
								+ socket.getRemoteSocketAddress() 
								+ ": " + Thread.currentThread().getName());
					} catch (Exception e) {
						//오류가 발생했다면 서버를 작동중지시키고 break로 빠져나온다.
						if(!serverSocket.isClosed()) {
							stopServer();
						}
						break;
					}
				}
				
			}
		};
		
		// 쓰레드풀 초기화
		threadPool = Executors.newCachedThreadPool();
		// 그 다음, 쓰레드풀에 현재 클라이언트를 기다리는 쓰레드를 담을 수 있도록 처리.
		threadPool.submit(thread);

	}
	public void stopServer() {
		try {
			// stopServer는 서버를 완전하게 중지를 시키는 것이기 때문에
			// 모든 클라이언트들에 대한 정보를 끊어준다.
			
			// 현재 작동중인 모든 소켓 닫기
			Iterator<Client> iterator = clients.iterator();

			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove(); 
			}
			// 서버 소켓 객체 닫기
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			
			// 쓰레드 풀 종료하기
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
