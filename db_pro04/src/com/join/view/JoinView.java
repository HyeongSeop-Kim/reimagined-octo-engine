package com.join.view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.join.controller.JoinController;
import com.join.menu.JoinMenu;
import com.join.vo.JoinVO;

/*
 *  CLI 화면에 회원가입, 탈퇴, 정보수정 등과 같은 메뉴 및 정보를
 *  보여주고 사용자가 데이터를 입력할 수 있는 화면을 제공하는 객체
 */

public class JoinView {
	private JoinController jc = new JoinController();
	private JoinMenu menu = new JoinMenu();
	private Scanner sc = new Scanner(System.in);

	public void show() {
		while(true) {
			System.out.print(menu.getMain());
			System.out.print(">>> ");
			String input = sc.nextLine();
			
			switch(input) {
			case "1" :
				this.joinMenu(); break;
			case "2" :
				this.loginMenu(); break;
			case "3" :
				System.exit(0);
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
			
			
			
		// 회원가입 및 로그인 요청에 맞추어 적절한 메서드를 호출
	}
	
	public void joinMenu() {
		// 회원 가입을 처리하기 위한 메서드
//		System.out.print("ID : ");
//		String userID = sc.nextLine();
//		System.out.print("PASSWORD : ");
//		String userPW = sc.nextLine();
//		System.out.print("이름 : ");
//		String name = sc.nextLine();
//		System.out.print("성별(남/여) : ");
//		char gender = sc.nextLine().charAt(0);
//		if(gender == '남') {
//			gender = 'M';
//		} else if(gender == '여') {
//			gender = 'F';
//		}
//		System.out.print("나이 : ");
//		int age = Integer.parseInt(sc.nextLine());
//		JoinVO data = new JoinVO(userID, userPW, name, gender, age, new Date());
		JoinVO data = new JoinVO();
		System.out.print("ID : ");
		data.setUserID(sc.nextLine());
		System.out.print("PASSWORD : ");
		data.setUserPW(sc.nextLine());
		System.out.print("이름 : ");
		data.setName(sc.nextLine());
		System.out.print("성별(남/여) : ");
		data.setGender(sc.nextLine());
		System.out.print("나이 : ");
		data.setAge(sc.nextLine());
		
		boolean result = jc.join(data);
		
		if(result) {
			System.out.println("회원 가입이 완료되었습니다.");
		} else {
			System.out.println("회원 가입에 실패하였습니다.(아이디 중복");
		}
	}
	
	public void loginMenu() {
		String userID, userPW;
		
		System.out.print("아이디 : ");
		userID = sc.nextLine();
		System.out.print("패스워드 : ");
		userPW = sc.nextLine();
		
		JoinVO account = jc.login(userID, userPW);
		
		if(account == null) {
			System.out.println("로그인 실패");
		} else {
			this.afterLoginMenu(account);
		}
	}

	private void afterLoginMenu(JoinVO account) {
		while(true) {
			System.out.print(menu.getAfterLogin(account.getUserID()));
			System.out.print(">>> ");
			String input = sc.nextLine();
			
			switch(input) {
				case "1" :
					System.out.println(account.getUserID());
					System.out.println(account.getName());
					System.out.println(account.getGender());
					System.out.println(account.getAge());
					
					System.out.println(account.getCreateDate());
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

					java.util.Date createDate = new java.util.Date(account.getCreateDate().getTime());
					String sDate = dateFormat.format(createDate);
					
					System.out.println(sDate);

					java.util.Date now = new java.util.Date();
					java.sql.Date sqlDate = new java.sql.Date(now.getTime());
					sqlDate = java.sql.Date.valueOf("2022-05-13");
					
					System.out.println(sqlDate);
					break;
				case "2" :
					System.out.println("아무것도 입력을 하지 않으면 이전 값을 유지합니다.");
					System.out.print("변경 할 패스워드 : ");
					input = sc.nextLine();
					input = input.isEmpty() ? account.getUserPW() : input;
					account.setUserPW(input);
					jc.update(account);
					
					System.out.print("변경 할 이름 : ");
					input = sc.nextLine();
					input = input.isEmpty() ? account.getName() : input;
					account.setName(input);
					
					System.out.print("변경 할 성별(남/여) : ");
					input = sc.nextLine();
					input = input.isEmpty() ? Character.toString(account.getGender()) : input;
					account.setGender(input);
					
					System.out.print("변경 할 나이 : ");
					input = sc.nextLine();
					input = input.isEmpty() ? Integer.toString(account.getAge()) : input;
					account.setAge(input);
					
					if(jc.update(account)) {
						System.out.println("정보 수정이 완료되었습니다.");
					} else {
						System.out.println("정보 수정에 실패하였습니다.");
					}
					break;
				case "3" :
					System.out.print("패스워드 : ");
					input = sc.nextLine();
					if(jc.remove(account, input)) {
						System.out.println("계정 삭제 작업이 완료되었습니다.");
						account = null;
						return;
					} else {
						System.out.println("계정 삭제 작업에 실패하였습니다.");
					}
					
					break;
				case "4" :
					account = null;
					return;
				default :
					System.out.println("잘못된 메뉴 번호입니다. 다시 입력하세요.");
			}
		}
		
	}


}
