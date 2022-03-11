package exam02;

import java.util.Scanner;

public class Sample09 {

	public static void main(String[] args) {
		
		// 문자열의 n번째 문자를 추출하는 method 
		String s = "Hello Java Programming";
		char c = s.charAt(6);
		System.out.println(c);
		
		// 문자열의 길이를 알아내는 method
		int len = s.length();
		System.out.println("문자열의 문자수 : " + len);
		
		// 문자열과 문자열을 비교하는 방법
		// 문자열 변수명.equals(문자열);
		
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = "문자열";
		
		if(str2.equals(str1)) {
			System.out.println("equals로 비교한 동일한 문자열 값입니다.");
		}

	}

}
