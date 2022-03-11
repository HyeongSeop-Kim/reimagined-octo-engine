package exam02;

import java.util.Random;
import java.util.Scanner;

public class Sample12 {

	public static void main(String[] args) {
		// 12자의 시리얼 넘버를 생성, 사용자입력을 통해 생성할 시리얼 넘버의 수량 파악 후 출력
		// AAAA-AAAA-AAAA 형식
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		String serial = "";
		char start='A', end ='Z';
		char c;
		int rep;
		
		System.out.print("몇 개의 시리얼 넘버를 생성할까요? : ");
		rep = sc.nextInt();
		
		
		for(int i = 0; i < rep; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 4; k++) {
					c = (char)(random.nextInt(end - start + 1) + start);
					serial += c;
				}
				if (j==2) {
					break;
				}
				serial += '-';
			}
			System.out.println(serial);
			serial = "";
		}
		
	}

}
