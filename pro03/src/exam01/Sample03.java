package exam01;

import java.util.Scanner;

public class Sample03 {

	public static void main(String[] args) {
		double rate = 0, sMoney = 0, dMoney = 0;
		int menu = 0;
		String mStr = "";
		String result = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원달러 환율 값 입력 : ");
		rate = sc.nextDouble();
		
		System.out.println("달러를 원화로 계산하겠습니까? 아니면 원화를 달러로 계산하겠습니까?");
		System.out.print("(1:달러->원화, 2:원화->달러) -> ");
		menu = sc.nextInt();
		
		mStr = menu == 1 ? "달러" : "원화";
		System.out.print(mStr + "값 입력 : ");
		sMoney = sc.nextDouble();
		System.out.print("");
		
		if(menu == 1) {
			dMoney = sMoney * rate;
			result = "%,.0f 달러는 %,.0f 원 입니다.";
		} else if(menu == 2) {
			dMoney = sMoney / rate;
			result = "%,.0f 원은 약 %,.2f 달러 입니다.";
		}
		
		System.out.printf(result, sMoney, dMoney);
	}

}
