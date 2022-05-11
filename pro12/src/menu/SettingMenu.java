package menu;

import java.util.Scanner;

import db.PenaltyDatabase;

public class SettingMenu {
	Scanner sc= new Scanner(System.in);
	
	private void addMenu() {
		String menu = "";
		menu += "수정할 벌칙의 원래 이름과 수정할 이름을 입력사에ㅛ. 입력을 중단하려면 exit 를 입력하세요.\n";
		menu += ": ";
		
		while(true) {
			System.out.print(menu);
			String input = sc.nextLine();
			
			if(input.equals("exit")) {
				System.out.println("추가 작업을 중단 합니다.");
				break;
			}
			
			PenaltyDatabase pDB = new PenaltyDatabase();
			pDB.add(input);;
			System.out.println("입력한 벌칙을 추가하였습니다.");
		}
	}
	
	private void modifyMenu() {
		String menu = penaltyListUp() + "\n";
		menu += "수정할 벌칙의 원래 이름과 수정할 이름을 입력하세요. 입력을 중단하려면 exit 를 입력하세요.\n";
		menu += "수정할 벌칙의 번호 : ";
		
		while(true) {
			System.out.print(menu);
			String input = sc.nextLine();
			
			if(input.equals("exit")) {
				System.out.println("추가 작업을 중단 합니다.");
				break;
			}
			
			int number = Integer.parseInt(input);
			
			System.out.print("벌칙 입력 : ");
			input = sc.nextLine();
			
			PenaltyDatabase pDB = new PenaltyDatabase();
			pDB.modify(number, input);
			System.out.println("입력한 벌칙을 추가하였습니다.");
		}
	}
	
	private String penaltyListUp() {
		PenaltyDatabase pDB = new PenaltyDatabase();
		String data = pDB.load();
		String[] listUp = data.split("\n");
		
		String res = "";
		for(int i = 0; i < listUp.length; i++) {
			res += String.format("%d. %s\n", listUp[i]);
		}
		return res;
	}
	
	private void removeMenu() {
		String menu = penaltyListUp() + "\n";
		menu += "삭제할 벌칙 번호를 입력하세요. 입력을 중단하려면 exit 를 입력하세요.\n";
		menu += "삭제할 벌칙의 번호 : ";
		
		while(true) {
			System.out.print(menu);
			String input = sc.nextLine();
			
			if(input.equals("exit")) {
				System.out.println("추가 작업을 중단 합니다.");
				break;
			}
			
			int number = Integer.parseInt(input);
			
			System.out.print("벌칙 입력 : ");
			input = sc.nextLine();
			
			PenaltyDatabase pDB = new PenaltyDatabase();
			pDB.remove(number);
			System.out.println("입력한 벌칙을 추가하였습니다.");
		}
	}
	
}
