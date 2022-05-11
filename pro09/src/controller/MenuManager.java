package controller;

import java.util.Scanner;

import model.vo.Account;
import model.vo.Grade;
import model.vo.Student;
import model.vo.Teacher;

public class MenuManager {
	Scanner sc = new Scanner(System.in);
	DatabaseManager db = new DatabaseManager();
	TeacherDatabaseManager tdb = new TeacherDatabaseManager();
	LoginMenuManager lMM = new LoginMenuManager();
	private Account loginAccount;
	
	public MenuManager(Account loginAccount) {
		this.loginAccount = loginAccount;
	}
		
	public void main() {
		if(loginAccount instanceof Teacher) {
//			Teacher teacher = (Teacher)loginAccount;
//			
//			if(teacher.getLoginDate() != null) {
//				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
//				String log = sFormat.format(teacher.getLoginDate());
//				System.out.println(log.toString());
//			}
//			teacher.setLoginDate(new Date());
			StringBuilder menu = new StringBuilder();
			menu.append("1. 성적 조회\n");
			menu.append("2. 학생 정보 추가\n");
			menu.append("3. 학생 정보 수정\n");
			menu.append("4. 학생 정보 삭제\n");
			menu.append("5. 패스워드 변경\n");
			menu.append("9. 로그아웃\n");
			menu.append(">>>");
			
			while(true) {
				boolean logout = false;
				System.out.print(menu.toString());
				int selectMenu = sc.nextInt();	sc.nextLine();
				
				switch(selectMenu) {
					case 1 :
						searchMenu();	break;
					case 2 :
						sutudentAddMenu();	break;
					case 3 :
						subjectModifyMenu();	break;
					case 4 :
						studentDeleteMenu();	break;
					case 5 :
						passwordChangeMenu();	break;
					case 9 :
						logout = true;
						break;
					default :
						System.out.println("잘못 입력하셨습니다.");
				}
				if(logout) {
					break;
				}
			}
		} else if(loginAccount instanceof Student) {
			Student student = (Student) loginAccount;
			StringBuilder menu = new StringBuilder();
			menu.append("1. 성적 조회\n");
			menu.append("2. 패스워드 변경\n");
			menu.append("9. 로그아웃\n");
			menu.append(">>>");
			
			while(true) {
				boolean logout = false;
				System.out.print(menu.toString());
				int selectMenu = sc.nextInt();	sc.nextLine();
				
				switch(selectMenu) {
					case 1 :
						searchMenu(student.getName());	break;
					case 2 :
						passwordChangeMenu();	break;
					case 9 :
						logout = true;
						break;
					default :
						System.out.println("잘못 입력하셨습니다.");
				}
				if(logout) {
					break;
				}
			}
			
		}
		
		
		
		/*
		 *  사용자 입력을 받아서 위의 메뉴에 해당하는 번호를 입력하면 다음의 메서드를 동작
		 *  	- 성적 조회 : searchMenu();
		 * 		- 학생 정보 추가 : sutudentAddMenu();
		 * 		- 성적 정보 수정 : subjectModifyMenu();
		 * 		- 학생 정보 삭제 : studentDeleteMenu();
		 * 		- 프로그램 종료 : System.exit(0); < 이 코드를 사용하여 프로그램 종료
		 */
	}

	public void searchMenu() {
		/*
		 *  DatabaseManager 클래스의 search 메서드를 사용하여 성적 정보가 출력될 수 있게 한다.
		 *  
		 *  -----------
		 *  이름 : 홍길동
		 *  -----------
		 *  국어		영어		수학		과학
		 *  xx점		xx점		xx점		xx점
		 *  x등급	x등급	x등급	x등급
		 *  -------------------
		 *  평균 : xx.xx점
		 *  -------------------
		 */
		
		
		while(true) {
			System.out.print("학생 이름 : ");
			String name = sc.nextLine();
			Grade[] grades = db.search(name);
			if(grades == null) {
				System.out.println("해당 학생 정보가 존재하지 않습니다. 다시 입력하세요.");
			} else {
				printGrades(name, grades);
				break;
			}
		}	
	}
	
	public void searchMenu(String stuName) {
		/*
		 *  DatabaseManager 클래스의 search 메서드를 사용하여 성적 정보가 출력될 수 있게 한다.
		 *  
		 *  -----------
		 *  이름 : 홍길동
		 *  -----------
		 *  국어		영어		수학		과학
		 *  xx점		xx점		xx점		xx점
		 *  x등급	x등급	x등급	x등급
		 *  -------------------
		 *  평균 : xx.xx점
		 *  -------------------
		 */
		
		
		while(true) {
			String name = stuName;
			Grade[] grades = db.search(name);
			
			printGrades(name, grades);
			break;
		}
	}
	
	private void subjectModifyMenu() {
		while(true) {
			System.out.print("학생 이름 : ");
			String name = sc.nextLine();
			
			Student stuInfo = db.getStudent(name);
	
			if(stuInfo != null) {
				Grade grades[] = stuInfo.getGrades();
				for(int i = 0; i < grades.length; i++) {
					String subject = grades[i].getName();
					System.out.print(grades[i].getName() + " 점수 : ");
					int score = sc.nextInt();
					stuInfo = db.modify(name, subject, score);
				}
				break;
			}
			
			System.out.println("해당 학생 정보가 존재하지 않습니다. 다시 입력하세요.");
		}
		
	}
	
	private void sutudentAddMenu() {
		while(true) {
			System.out.print("학생 이름 : ");
			String name = sc.nextLine();
			if(db.add(name)) {
				System.out.println("학생 정보가 추가되었습니다.");
				break;
			} else {
				System.out.println("이미 해당 학생의 정보가 존재합니다. 다시 입력하세요.");
			}
		}
		
		
	}

	private void studentDeleteMenu() {
		while(true) {
			System.out.print("학생 이름 : ");
			String name = sc.nextLine();
			if(db.remove(name)) {
				System.out.println("학생 정보가 삭제되었습니다.");
				break;
			} else {
				System.out.println("해당 학생 정보가 존재하지 않습니다. 다시 입력하세요.");
			}
		}
	}
	
	public void printGrades(String name, Grade[] grades) {
		StringBuilder sb = new StringBuilder();
		sb.append("이름 : " + name + "\n");
		sb.append("----------------\n");
		for(int i = 0; i < grades.length; i++) {
			sb.append(grades[i].getName() + "\t");
		}
		sb.append("\n");
		double avg = 0;
		for(int i = 0; i < grades.length; i++) {
			sb.append(grades[i].getScore() + "점\t");
			avg  += grades[i].getScore();
		}
		avg /= grades.length;
		sb.append("\n");
		for(int i = 0; i < grades.length; i++) {
			sb.append(grades[i].getLevel() + "등급\t");
		}
		sb.append("\n");
		sb.append("----------------\n");
		sb.append("평균 : " + avg + "\n");
		sb.append("----------------\n");
		System.out.print(sb.toString());
	}
	
	public void passwordChangeMenu() {
		System.out.print("현재 패스워드 : ");
		String  curPass = sc.nextLine();
		
		System.out.print("변경 패스워드 : ");
		String changePass = sc.nextLine();
		
		boolean result = loginAccount.changePassword(curPass, changePass);
		
		if(result) {
			System.out.println("패스워드 변경이 완료되었습니다.");
		} else {
			System.out.println("패스워드 변경에 실패했습니다. 현재 패스워드를 다시 확인하세요.");
		}
	}
	
}
