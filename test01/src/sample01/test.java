package sample01;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("문자열을 입력해주세요 : ");
			String str = sc.nextLine();
			System.out.println(str.toString());
			if(str.equals("exit")) {
				break;
			} else {
				System.out.println(str.length() + "글자 입니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	

	}

}
