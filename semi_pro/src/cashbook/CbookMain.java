package cashbook;

import cashbook.view.CbookView;

public class CbookMain {

	public static void main(String[] args) {
		// 입출금 내역서 프로그램
		CbookView view = new CbookView();
		view.mainMenu();
	}

}