package exam02;

import java.util.Scanner;
import java.util.Random;

public class Sample13 {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		int qNum = rand.nextInt(100)+1;
		int aNum, temp = 0;
		
		while(true) {
			System.out.print("1~100 사이의 임의의 난수를 맞춰보세요. : ");
			aNum = sc.nextInt();
			
			if(aNum < 1 || aNum > 100) {
				System.out.println("1~100 사이의 숫자를 입력해주세요.");
			} else if(aNum < qNum) {
				System.out.println("UP !");
				temp++;
			} else if(aNum > qNum) {
				System.out.println("Down !");
				temp++;
			} else if (aNum == qNum) {
				System.out.println("정답입니다!!");
				System.out.printf("%d회만에 맞추셨습니다.", ++temp);
				break;
			}
		}
		
	}

}
