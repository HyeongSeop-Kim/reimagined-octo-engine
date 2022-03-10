package exam02;

import java.util.Scanner;

public class Sample05 {

	public static void main(String[] args) {
		// 메뉴가 주어지고 주어진 메뉴 번호의 범위를 벗어난 경우에만 3번의 반복 입력 기회를 주어
		// 올바른 값을 입력하도록 유도, 올바른 값을 입력했으면 반복문이 끝나게 만든다.
		
		Scanner sc = new Scanner(System.in);
		int menu;
		boolean flag = false;
		
		for (int i = 0; i < 3; i++) {
			System.out.println("다음에 나열된 메뉴중 하나의 번호를 선택하시오.");	
			System.out.print("1. 조회\n2. 추가\n3. 수정\n4. 삭제\n9. 종료\n");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1 :
				System.out.println("조회 메뉴를 선택했습니다.");
				flag = true;
				break;
			case 2 :
				System.out.println("추가 메뉴를 선택했습니다.");
				flag = true;
				break;
			case 3 :
				System.out.println("수정 메뉴를 선택했습니다.");
				flag = true;
				break;
			case 4 :
				System.out.println("삭제 메뉴를 선택했습니다.");
				flag = true;
				break;
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				flag = true;
				break;
			default :
				System.out.println("잘못된 메뉴 번호입니다.");
				if(i==2) {
					System.out.println("입력 횟수를 초과하였습니다. 프로그램을 종료합니다.");
				}
				break;
			}
			
			if(flag) {
				break;
			}
		}
		
		

	}

}
