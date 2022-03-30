package exam07;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		Worker w1 = new Worker("홍길동", "사원");
		Worker w2 = new DeputySectionChief("고길동", "대리");
		Worker w3 = new SectionChief("김아람", "과장");
		((SectionChief)w3).setTeamLeader(true);
		Worker w4 = new DeputyDepartmentHead("윤봄", "차장");
		Worker w5 = new DeputyDepartmentHead("김길수", "차장");
		((DeputyDepartmentHead)w4).setDirector(true);
		
		Worker[] workArr = new Worker[] {w1, w2, w3, w4, w5};
		
		for(int i = 0; i < 24; i++) {
			int month = i % 12 == 0 ? 12 : i % 12;
			System.out.printf("=============\n%d 월 급여 지급 내역\n=============\n", month);
			for(int j = 0; j < workArr.length; j++) {
				System.out.printf("%s %s께서 %,.1f원을 수령하셨습니다.\t",workArr[j].getName(), workArr[j].getPosition(), workArr[j].salary());
			}
			if((rand.nextInt(9)+1)%4 == 0) {
				int idx = rand.nextInt(4) + 1;
				System.out.println(workArr[idx].getName() + "님이 법카를 사용하셨습니다.");
				((DeputySectionChief)workArr[idx]).corpCard(10000);
			}
			
			System.out.println();
		}
	}

}
