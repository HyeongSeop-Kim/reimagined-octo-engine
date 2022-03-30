package exam06;

import java.util.Random;

import exam05.Student;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		Customer[] cArr = new Customer[5];
		
		cArr[0] = new NormalCustomer("홍길동", 35, 'M');
		cArr[1] = new NormalCustomer("고길동", 35, 'M');
		cArr[2] = new NormalCustomer("강조석", 25, 'M');
		cArr[3] = new NormalCustomer("최조한", 38, 'M');
		cArr[4] = new NormalCustomer("라주성", 29, 'M');
		
		for(int i = 0; i < 100; i++) {
			int idx = rand.nextInt(5);
			cArr[idx].buy("xxxxxx", (int)(rand.nextInt(100000) + 10000) / 10000 * 10000);
			if(cArr[idx] instanceof NormalCustomer) {
				if(((NormalCustomer)cArr[idx]).getPriceTotal() > 1000000) {
					PremiumCustomer temp = new PremiumCustomer(cArr[idx].getName(), cArr[idx].getAge(), cArr[idx].getGender());
					temp.setPriceTotal(cArr[idx].getPriceTotal());
					cArr[idx] = temp;
					System.out.println(cArr[idx].getName() + "님이 프리미엄 회원으로 전환되었습니다.");
				}
			}
		}
	}

}
