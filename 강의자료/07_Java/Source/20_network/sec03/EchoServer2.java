package sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer2 extends Thread{
	protected static boolean cont = true;
    protected Socket connection = null;
	protected static int nCount=0;
    protected int nCurrentNo=0;
    
    private EchoServer2(Socket clientSocket) {
        connection = clientSocket;
	nCount++;
        nCurrentNo = nCount;
        start();
    }
    public void run() {
        BufferedReader in;

        System.out.println("클라이언트와 통신을 위한 새로운 스레드 생성");
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String msg;

            while ((msg = in.readLine()) != null) {
                System.out.println("읽은 메시지 메아리 : " + msg);
            }

            in.close();
            connection.close();
        } catch (IOException e) {
        }
    }
	public static void main(String[] args) throws IOException{
		ServerSocket server = null;
        server = new ServerSocket(5000);
       
        System.out.println("서버 소켓 생성");
        while (cont) {
        	System.out.println("["+ nCurrentNo + "] 연결 대기 중.....");
            new EchoServer2(server.accept());
        }
       
        server.close();

	}

}
