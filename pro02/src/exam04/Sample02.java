package exam04;

import java.util.Scanner;

public class Sample02 {
	// 이항 연산자 : 피연산자가 2개 있는 연산
	// 1+1,1*2, ...
	public static void main(String[] args) {
		// 산술 연산자
		// +, -, *, /(나누기), %(나머지)
		int num1, num2;
		
		num1 = 10;
		num2 = 3;
		
		System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
		System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
		System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
		System.out.printf("%d / %d = %f\n", num1, num2, (double)num1 / num2);
		System.out.printf("%d %% %d = %d\n", num1, num2, num1 % num2);
		
		// 비교 연산자
		// ==, !=, <, >, <=, >=
		System.out.printf("%d == %d -> %b\n", num1, num2, num1 == num2);
		System.out.printf("%d != %d -> %b\n", num1, num2, num1 != num2);
		System.out.printf("%d > %d -> %b\n", num1, num2, num1 > num2);
		System.out.printf("%d < %d -> %b\n", num1, num2, num1 < num2);
		System.out.printf("%d >= %d -> %b\n", num1, num2, num1 >= num2);
		System.out.printf("%d <= %d -> %b\n", num1, num2, num1 <= num2);
		
		Scanner sc = new Scanner(System.in);
		
		int num3, num4;
		
		System.out.print("값을 입력하세요 : ");
		num3 = sc.nextInt();
		System.out.print("값을 입력하세요 : ");
		num4 = sc.nextInt();
		System.out.printf("%d == %d -> %b", num3, num4, num3==num4);
	}
}
