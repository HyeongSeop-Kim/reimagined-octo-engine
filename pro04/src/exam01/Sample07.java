package exam01;

import java.util.Scanner;

public class Sample07 {

	public static void main(String[] args) {
		//
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		double avg = 0;
		int repInput;
		int numInput[];
		
		System.out.print("총 입력 횟수 : ");
		repInput = sc.nextInt();
		numInput = new int[repInput];
		
		for(int i = 0; i < repInput; i++) {
			System.out.print(i+1 + "번 째 정수값 입력 : ");
			numInput[i]=sc.nextInt();
			sum += numInput[i];
		}
		avg = (double)sum / repInput;
		
		System.out.printf("총 합 : %d\n", sum);
		System.out.printf("평균 : %.1f", avg);
	}

}
