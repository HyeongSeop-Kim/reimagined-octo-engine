package exam03.login.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class LoginServer {

	public static void main(String[] args) {
		/*
		 *  로그인 서버
		 *  	1. 클라이언트가 아이디와 패스워드로 연결 요청을 하면
		 *  		account.db 파일에 있는 사용자 정보를 확인
		 *  	2. account.db 파일에 동일한 아이디, 패스워드가 존재하는 경우
		 *  		로그인 승낙을함.
		 *  	3. account.db 파일에 동일한 아이디, 패스워드가 없는 경우
		 *  		연결 끊음.
		 */
		
		File accountFile = new File("C:/Users/KHS/account.db");
		String[] accountList = new String[0];
		
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(accountFile))) {
			StringBuilder sb = new StringBuilder();
			char[] buff = new char[1024];
			while(isr.ready()) {
				int size = isr.read(buff);
				sb.append(buff, 0, size);
			}
			String[] temp = sb.toString().split("\n");
			accountList = Arrays.copyOf(accountList, temp.length);
			accountList = temp;
			System.out.println(accountList[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(accountFile.exists()) {
			try {
				/*
				 *  1. 네트워크 통신을 위한 IP 주소 정보 설정
				 */
				byte[] addr = new byte[] {(byte)172, (byte)30, (byte)1, (byte)29};
				InetAddress serverIp = InetAddress.getByAddress(addr);
				int serverPort = 50000;
				
				/*
				 *  2. 서버용 소켓 생성 후 서버 IP, 서버 Port 바인딩
				 */
				ServerSocket serverSock = new ServerSocket();
				InetSocketAddress serverIpPort = new InetSocketAddress(serverIp, serverPort);
				serverSock.bind(serverIpPort);
				
				/*
				 *  3. 클라이언트 요청을 대기후 accept하여 클라이언트용 소켓 생성
				 */
				Socket sock = serverSock.accept();
				
				/*
				 *  4. 통신용 입출력 스트림 생성
				 */
				
				BufferedReader sIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				BufferedWriter sOut = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
							
				//boolean flag = false;
				System.out.println("1");
				boolean flag = false;
				while(true) {
					while(sIn.ready()) {
						String line = sIn.readLine();
						System.out.println(line);
						for(int i = 0; i < accountList.length; i++) {					
							if(line.equals(accountList[i])) {
								flag = true;
							}
						}
					}
					if(flag) {
						System.out.println("연결되었습니다.");
					}
				}
//				
				
//					for(int i = 0; i < accountList.length; i++) {					
//						if(line.equals(accountList[i])) {
//							flag = true;
//						}
//					}
				
				/*
				 *  5. 모든 데이터 수신을 완료하였으면 모든 자원 반납
				 */
//				if(flag) {
//					System.out.println("연결되었습니다.");
//				} else {
//					System.out.println("연결에 실패하였습니다.");
//					sIn.close();
//					sOut.close();
//					sock.close();
//					serverSock.close();
//				}
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("계정 정보가 없습니다.");
		}
	} 

}
