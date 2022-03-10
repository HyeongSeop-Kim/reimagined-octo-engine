package exam01;

import java.util.Scanner;

public class Sample06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String ampm = "오전";
		
		System.out.print("시간 입력 : ");
		int h = sc.nextInt();
		
		System.out.print("분 입력 : ");
		int m = sc.nextInt();
		
		if (h >= 12 && h <=23) {
			ampm = "오후";
//			h = h != 12 ? h - 12 : 12;
			if (h != 12) {
				h -= 12;
			} 
		} else if (h == 0) {
			h += 12;
		}
		
		System.out.printf("변환된 시간 %s %d시 %d분", ampm, h , m);
		
		switch(h / 12) {
		case 0 :
			if (h == 0) {
				h = 12;
			}
		case 1 :
			ampm = "오후";
			if (h != 12) {
				h -= 12;
			}
		}
		System.out.printf("변환된 시간 %s %d시 %d분", ampm, h , m);
	}

}
