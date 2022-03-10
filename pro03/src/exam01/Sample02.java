package exam01;

import java.util.Scanner;

public class Sample02 {

	public static void main(String[] args) {
		// Scanner 를 사용하여 사용자 입력을 받고 다음의 출력 결과가 나오도록 하시오.
		// 1. 사용자 입력을 통해 정수 데이터를 입력받는다.
		// 2. 입력 받은 정수 데이터의 값이 1~99 사이의 값인지 확인을 한다.
		// 3. 1~99 사이의 값이 아닌 경우 "입력 값의 범위를 벗어났습니다." 메시지를 출력한다.
		// 4. 1~99 사이의 값일 경우 "올바른 값을 입력하였습니다." 메시지를 출력한다.
		
		Scanner sc = new Scanner(System.in);

		int num1;
		System.out.print("1~99 사이의 정수를 입력하세요. : ");
		num1=sc.nextInt();
		
		if(num1 >= 1 && num1 <= 99) {
			System.out.println("올바른 값을 입력하였습니다.");
		} else {
			System.out.println("입력 값의 범위를 벗어났습니다.");
		}
		

	}

}
