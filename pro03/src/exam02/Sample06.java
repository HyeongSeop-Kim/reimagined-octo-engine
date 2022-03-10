package exam02;

import java.util.Scanner;

public class Sample06 {

	public static void main(String[] args) {
		// 1 ~ 사용자가 입력한 정수값까지 반복 출력하는 코드를 착성
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.print("1보다 큰 정수 값을 입력해주세요. : ");
		num = sc.nextInt();
		
		for (int i = 1; i <= num;) {
			for (int j = 0; j < 7; j++) {
					System.out.print(i + " ");
					i++;
					if(i > num) {
						break;
					}
			}
			System.out.println();
		}
		// 사용자가 입력한 정수값부터 ~1까지 반복 출력하는 코드를 작성
		System.out.print("1보다 큰 정수 값을 입력해주세요. : ");
		num = sc.nextInt();
		
		for (int i = num; i > 0;) {
			for (int j = 0; j < 7; j++) {
					System.out.print(i + " ");
					i--;
					if(i == 0) {
						break;
					}
			}
			System.out.println();
		}

		// 위 문제에서 반복 출력할 때 한 줄에 7개의 정수 값이 출력되도록 코드를 작성한다.
	}

}
