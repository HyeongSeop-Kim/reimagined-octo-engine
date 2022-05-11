package exam01.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			//InetAddress ip = InetAddress.getByName("localhost");

//			byte[] addr = new byte[] {(byte)172, (byte)30, (byte)1, (byte)29};
//			InetAddress ip = InetAddress.getByAddress(addr);

			/*
			 *  1. 네트워크 통신을 위한 IP 주소 정보 설정
			 */
			
			InetAddress clientIp = InetAddress.getLocalHost();
			int clientPort = 50000;
			
			byte[] addr = new byte[] {(byte)172, (byte)30, (byte)1, (byte)29};
			InetAddress serverIp = InetAddress.getByAddress(addr);
			int serverPort = 51000;
			
			/*
			 *  2. UDP 통신용 소켓 생성
			 */
			DatagramSocket udpSock = new DatagramSocket(clientPort, clientIp);
			
			/* 
			 * 3. 서버에 데이터 송신하기 위한 패킷 생성
			 * 	 (서버가 활성화 되어 있어야한다.)
			 */
			
			while(true) {
				System.out.print("전송할 메세지를 입력하세요 : ");
				String input = sc.nextLine();
				byte[] data = input.getBytes();
				DatagramPacket packet = new DatagramPacket(data, data.length, serverIp, serverPort);
				udpSock.send(packet); 
			}
			
			/*
			 *  4. 데이터 송신을 완료했으면 모든 자원 반납
			 */
			
			//udpSock.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
