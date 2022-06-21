package cashbook.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cashbook.controller.CbookController;
import cashbook.dao.CbookDAO;
import cashbook.vo.CbookVO;

public class CbookView {

	Scanner sc = new Scanner(System.in);
	CbookController cc = new CbookController();
	CbookDAO cDAO = new CbookDAO();
	SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public void mainMenu() {
		String menu = "        입출금내역서\n"
					+ "--------------------------\n"
				    + "    1. 입출금 내역 조회\n"
				    + "    2. 입금 내역 추가\n"
				    + "    3. 출금 내역 추가\n"
				    + "    9. 프로그램 종료\n"
				    + "--------------------------";
		while(true) {
			System.out.println(menu);
			System.out.print("원하시는 작업 번호를 입력하세요 : ");
			
			String input = sc.nextLine();
			
			switch(input) {
				case "1" :
					this.showCbook();
					break;
				case "2" :
					this.addDeposit();
					break;
				case "3" :
					this.addExpense();
					break;
				case "9" :
					System.exit(0);
				default :
					System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
					break;
			}
		}
	}
	
	public void showCbook() {
		System.out.println("아래 형식에 맞추어 조회를 원하시는 기간을 입력해주세요.");
		System.out.println("미작성시 모든 기간이 조회됩니다.");
		System.out.println("ex) 2015-05-05~2020-06-06");
		System.out.print(">>> ");

		String input = sc.nextLine();
		
		if(input.equals("")) {
			String result = cc.inquiry();
			if(result != null) {
				System.out.println("+--------------------------------------------------------------------------------------------------------+");
				System.out.print("| " + "고유번호" + " | ");
				System.out.print(String.format("%9s", "날짜") + " | ");
				System.out.print(String.format("%11s", "현장명") + " | ");
				System.out.print(String.format("%21s", "적요") + " | ");
				System.out.print(String.format("%10s", "입금") + " | ");
				System.out.print(String.format("%10s", "지출") + " | ");
				System.out.print(String.format("%10s", "비고") + " | \n");
				System.out.println("+--------------------------------------------------------------------------------------------------------+");
				System.out.println(result);
				this.inquiryMenu();
			} 
		} else {
			String period[] = input.split("~");
			
			try {
				Date startDate = new Date(sFormat.parse(period[0]).getTime());
				Date endDate =  new Date(sFormat.parse(period[1]).getTime());

				if(startDate != null && endDate != null) {
					String result = cc.inquiry(startDate, endDate);
					if(result != null) {
						System.out.println("+--------------------------------------------------------------------------------------------------------+");
						System.out.print("| " + "고유번호" + " | ");
						System.out.print(String.format("%9s", "날짜") + " | ");
						System.out.print(String.format("%11s", "현장명") + " | ");
						System.out.print(String.format("%21s", "적요") + " | ");
						System.out.print(String.format("%10s", "입금") + " | ");
						System.out.print(String.format("%10s", "지출") + " | ");
						System.out.print(String.format("%10s", "비고") + " | \n");						
						System.out.println("+--------------------------------------------------------------------------------------------------------+");
						System.out.println(result);
						this.inquiryMenu();
					} 
				} 
			} catch (ParseException e) {
				System.out.println("잘못 입력하셨습니다. 형식에 맞추어 입력해주세요.");
			}
		}	
	}
	
	public void addDeposit() {
		CbookVO cvo = new CbookVO();
		
		String input;
		System.out.println("아래 형식에 맞추어 날짜를 입력하세요.");
		System.out.println("미작성시 오늘 날짜로 기록됩니다.");
		System.out.println("ex) 2015-05-05");
		System.out.print(">>> ");
		input = sc.nextLine();
		java.sql.Date inputDate;
		if(input.equals("")) {
			inputDate = new java.sql.Date(new Date().getTime());
			cvo.setTransactionDate(inputDate);
		} else {			
			try {
				inputDate = new java.sql.Date(sFormat.parse(input).getTime());
				cvo.setTransactionDate(inputDate);
			} catch (ParseException e) {
				System.out.println("잘못 입력하셨습니다. 형식에 맞추어 입력해주세요.");
				return;
			}
		}
		System.out.print("현장명 : ");
		input = sc.nextLine();
		cvo.setSiteName(input);
		System.out.print("적요 : ");
		input = sc.nextLine();
		cvo.setBreakdown(input);
		System.out.print("입금액 : ");
		input = sc.nextLine();
		cvo.setDeposit(Integer.parseInt(input));
		System.out.println(cc.showNoteList());
		System.out.print("비고 번호 : ");
		input = sc.nextLine();
		cvo.setNoteNum(Integer.parseInt(input));
		
		boolean result = cc.addDeposit(cvo);
		
		if(result) {
			System.out.println("추가되었습니다.");
		} else {
			System.out.println("작업에 실패하였습니다.");
		}
	}
	
	public void addExpense() {
		CbookVO cvo = new CbookVO();
		
		String input;
		System.out.println("아래 형식에 맞추어 날짜를 입력하세요.");
		System.out.println("미작성시 오늘 날짜로 기록됩니다.");
		System.out.println("ex) 2015-05-05");
		System.out.print(">>> ");
		input = sc.nextLine();
		java.sql.Date inputDate;
		if(input.equals("")) {
			inputDate = new java.sql.Date(new Date().getTime());
			cvo.setTransactionDate(inputDate);
		} else {			
			try {
				inputDate = new java.sql.Date(sFormat.parse(input).getTime());
				cvo.setTransactionDate(inputDate);
			} catch (ParseException e) {
				System.out.println("잘못 입력하셨습니다. 형식에 맞추어 입력해주세요.");
				return;
			}
		}
		System.out.print("현장명 : ");
		input = sc.nextLine();
		cvo.setSiteName(input);
		System.out.print("적요 : ");
		input = sc.nextLine();
		cvo.setBreakdown(input);
		System.out.print("지출액 : ");
		input = sc.nextLine();
		cvo.setExpense(Integer.parseInt(input));
		System.out.println(cc.showNoteList());
		System.out.print("비고 번호 : ");
		input = sc.nextLine();
		cvo.setNoteNum(Integer.parseInt(input));
		
		boolean result = cc.addExpense(cvo);
		
		if(result) {
			System.out.println("추가되었습니다.");
		} else {
			System.out.println("작업에 실패하였습니다.");
		}		
	}
	
	public void inquiryMenu() {
		String menu = "--------------------------\n"
				    + "    1. 입출금 내역 수정\n"
				    + "    2. 입출금 내역 삭제\n"
				    + "    3. 뒤로 가기\n"
				    + "    9. 프로그램 종료\n"
				    + "--------------------------";
		while(true) {
			System.out.println(menu);
			System.out.print("원하시는 작업 번호를 입력하세요 : ");
			
			String input = sc.nextLine();
			
			switch(input) {
				case "1" :
					this.modifyData();
					break;
				case "2" :
					this.removeDate();
					break;
				case "3" :
					return;
				case "9" :
					System.exit(0);
				default :
					System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
					break;
			}
		}
	}
	
	public void modifyData() {
		CbookVO cvo = new CbookVO();
		
		String input;
		System.out.print("수정할 데이터의 고유번호를 입력해주세요 : ");
		input = sc.nextLine();
		int serialNum = Integer.parseInt(input);
		CbookVO currentData = cDAO.findData(serialNum);
		cvo.setSerialNum(serialNum);
		
		System.out.println("수정할 데이터를 입력해주세요. 미작성시 현재 데이터가 유지됩니다.");
		System.out.println("아래 형식에 맞추어 날짜를 입력하세요.");
		System.out.println("ex) 2015-05-05");
		System.out.print(">>> ");
		input = sc.nextLine();
		java.sql.Date inputDate;
		if(input.equals("")) {
			cvo.setTransactionDate(currentData.getTransactionDate(0));
		} else {			
			try {
				inputDate = new java.sql.Date(sFormat.parse(input).getTime());
				cvo.setTransactionDate(inputDate);
			} catch (ParseException e) {
				System.out.println("잘못 입력하셨습니다. 형식에 맞추어 입력해주세요.");
				return;
			}
		}
		System.out.print("현장명 : ");
		input = sc.nextLine();
		if(input.equals("")) {
			cvo.setSiteName(currentData.getSiteName(0));
		} else {
			cvo.setSiteName(input);
		}
		System.out.print("적요 : ");
		input = sc.nextLine();
		if(input.equals("")) {
			cvo.setBreakdown(currentData.getBreakdown(0));
		} else {
			cvo.setBreakdown(input);
		}
		System.out.print("입금액 : ");
		input = sc.nextLine();
		if(input.equals("")) {
			cvo.setDeposit(currentData.getDeposit(0));
		} else {
			cvo.setDeposit(Integer.parseInt(input));
		}
		System.out.print("지출액 : ");
		input = sc.nextLine();
		if(input.equals("")) {
			cvo.setExpense(currentData.getExpense(0));
		} else {
			cvo.setExpense(Integer.parseInt(input));
		}
		System.out.println(cc.showNoteList());
		System.out.print("비고 번호 : ");
		input = sc.nextLine();
		if(input.equals("")) {
			cvo.setNoteNum(currentData.getNoteNum(0));
		} else {
			cvo.setNoteNum(Integer.parseInt(input));
		}
		
		boolean result = cc.modify(cvo);
		if(result) {
			System.out.println("수정되었습니다.");
		} else {
			System.out.println("작업에 실패하였습니다.");
		}
	}
	
	public void removeDate() {
		CbookVO cvo = new CbookVO();
		
		String input;
		System.out.print("삭제할 데이터의 고유번호를 입력해주세요 : ");
		input = sc.nextLine();
		cvo.setSerialNum(Integer.parseInt(input));
		
		boolean result = cc.remove(cvo.getSerialNum(0));
		if(result) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("작업에 실패하였습니다.");
		}
	}
}
