package exam02;

import java.util.Scanner;

public class Sample10 {

	public static void main(String[] args) {
		// 1. 사용자가 입력할 수 있는 문자열의 길이를 제한하는 코드 작성(길이 제한은 최소 3자 최대 5자)
		// 2. 제한을 넘긴 경우 다시 입력하도록 한다.
		
		Scanner sc = new Scanner(System.in);
		String s = "";
		
		while(true) {
		System.out.print("3~5자의 문자열을 입력하세요 : ");
		s = sc.nextLine();
		
		if(s.length()<=5 && s.length()>=3) {
			break;
		}
		}
		
		// 1. 사용자가 입력한 영단어에서 'a', 'e', 'i', 'o', 'u' 문자의 수를 구해 출력
		
		System.out.print("문자열을 입력하세요. : ");
		String input = sc.nextLine();
		int cnt = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'a' || input.charAt(i) == 'e' 
				|| input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
				cnt++;
			}
		}
		System.out.printf("%d개 있습니다.", cnt);
		
		// 1. 사용자가 입력한 영단어에서 대문자/소문자의 수를 구해서 출력
		
	}

}
