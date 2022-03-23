package exam03;

public class Sample01 {

	public static void main(String[] args) {
		Page pg = new Page("백설공주", 25);
		
		System.out.println("앞으로 한 쪽 넘기기 현재 페이지 : " + pg.beforePage());
		System.out.println("뒤로 한 쪽 넘기기 현재 페이지 : " + pg.nextPage());
		System.out.println("앞으로 한 쪽 넘기기 현재 페이지 : " + pg.beforePage());
		System.out.println("뒤로 26 쪽 넘기기 현재 페이지 : " + pg.nextPage(26));
		System.out.println("앞으로 5 쪽 넘기기 현재 페이지 : " + pg.beforePage(5));
		System.out.println("앞으로 23 쪽 넘기기 현재 페이지 : " + pg.beforePage(23));
		System.out.println("뒤로 10 쪽 넘기기 현재 페이지 : " + pg.nextPage(10));
		System.out.println("21페이지로 이동하기 현재 페이지 : " + pg.movePage(21));
		System.out.println("27페이지로 이동하기 현재 페이지 : " + pg.movePage(27));
		System.out.println("0페이지로 이동하기 현재 페이지 : " + pg.movePage(0));

	}

}
