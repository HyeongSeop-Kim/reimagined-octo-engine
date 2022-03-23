package exam03;

public class Page {
	private String name;	// 책 이름
	private int currentPage;		// 현재
	private int maxPage;		// 최대 쪽수
	
	public Page() {}
	
	public Page(String name, int maxPage) {
		this.name = name;
		this.maxPage = maxPage;
		this.currentPage = 1;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}public void setMaxPage(int currentPage, int maxPage) {
		this.currentPage = currentPage;
		this.maxPage = maxPage;
	}
	
	public int getMaxPage() {
		return this.maxPage;
	}
	
	public int nextPage() {
		if(this.currentPage < this.maxPage) {
			return ++this.currentPage;
		} else {
			System.out.println("마지막 페이지입니다.");
			return this.currentPage;
		}
	}
	
	public int nextPage(int cnt) {
		if(this.currentPage + cnt <= this.maxPage) {
			this.currentPage += cnt;
			return this.currentPage;
		} else {
			System.out.println("더 이상 넘길 수 없습니다. 마지막 페이지로 이동합니다.");
			this.currentPage = this.maxPage;
			return this.currentPage;
		}
	}
	
	public int beforePage() {
		if(this.currentPage > 1) {
			return --this.currentPage;
		} else {
			System.out.println("첫 페이지입니다.");
			return this.currentPage;
		}
	}
	
	public int beforePage(int cnt) {
		if(this.currentPage-cnt >= 1) {
			this.currentPage-=cnt;
			return this.currentPage;
		} else {
			System.out.println("더 이상 넘길 수 없습니다. 첫 페이지로 이동합니다.");
			this.currentPage = 1;
			return this.currentPage;
		}
	}
	
	public int movePage(int targetPage) {
		if(targetPage>maxPage) {
			System.out.println("최대 페이지를 넘어 이동할 수 없습니다.");
			return this.currentPage;
		} else if(targetPage<1) {
			System.out.println("잘못된 페이지 번호입니다.");
			return this.currentPage;
		} else {
			this.currentPage = targetPage;
			return this.currentPage;
		}
	}
	
	public void checkedPage() {
		
	}
}
