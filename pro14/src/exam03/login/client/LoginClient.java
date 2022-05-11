package exam03.login.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LoginClient {

	public static void main(String[] args) {
		/*
		 *  로그인 클라이언트
		 *  	1. 아이디와 패스워드를 입력하여 서버에 로그인 요청
		 *  	2. 서버로부터 로그인 승낙을 받으면 연결됨
		 *  	3. 서버로부터 로그인 승낙을 받지 못하면 연결 종료
		 */
		Scanner sc = new Scanner(System.in);
		try {
			/* 
			 *  1. 네트워크 통신을 위한 IP 주소 정보 설정
			 */
			byte[] addr = new byte[] {(byte)172, (byte)30, (byte)1, (byte)29};
			InetAddress serverIp = InetAddress.getByAddress(addr);
			int serverPort = 50000;
			
			/* 
			 *  2. 클라이언트용 소켓 생성
			 */
			
			Socket sock = new Socket(serverIp, serverPort);
			
			/*
			 *  3. 통신용 입출력 스트림 생성
			 */
			
			BufferedReader sIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter sOut = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			while(true) {
				System.out.print("아이디 : ");
				String id = sc.nextLine();
				System.out.print("패스워드 : ");
				String pw = sc.nextLine();
				sOut.write(id + " " + pw);
				sOut.newLine();
				sOut.flush();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*
			 *  4. 데이터 송신을 완료하였으면 모든 자원 반납
			 */
			
			
//			sIn.close();
//			sOut.close();
//			sock.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
