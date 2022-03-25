package examp05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Student s[] = new Student[6];
		s[0] = new Student("홍길동",17,1,1);
		s[1] = new Student("혁거세",17,1,1);
		s[2] = new Student("고주몽",17,1,1);
		s[3] = new Student("임꺽정",18,2,1);
		s[4] = new Student("이성계",17,1,2);
		s[5] = new Student("광개토",18,2,1);
		
		StudentList sList = new StudentList(s);
		sList.add("이방원", 18, 2, 2);
		
		String studentsName[] = sList.findStudents(1);
		
		for(int i = 0; i < studentsName.length; i++) {
			System.out.println(studentsName[i]);
		}
		
		sList.update("혁거세", 2, 2);

		studentsName = sList.findStudents(2);
		
		for(int i = 0; i < studentsName.length; i++) {
			System.out.println(studentsName[i]);
		}
		
		sList.remove("이성계");
		studentsName = sList.findStudents(2,1);
		
		for(int i = 0; i < studentsName.length; i++) {
			System.out.println(studentsName[i]);
		}
		
		System.out.println("홍길동은 " + sList.findGrade("홍길동") + "학년 " + sList.findGroup("홍길동") + "반 입니다.");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			do {
				System.out.println("1. 조회");
				System.out.println("2. 추가");
				System.out.println("3. 수정");
				System.out.println("4. 삭제");
				System.out.println("9. 종료");
			} while(!sc.hasNextInt());
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1:
					System.out.println("조회 기능 수행");
					break;
				case 2:
					System.out.println("추가 기능 수행");
					break;
				case 3:
					System.out.println("수정 기능 수행");
					break;
				case 4:
					System.out.println("삭제 기능 수행");
					break;
				case 9:
					System.out.println("프로그램 종료");
					break;
				default:
					System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
			}
			
		}
	}

}
