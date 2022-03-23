package exam10;

public class Product {
	private String pName = "키보드";
	private int price = 250000;
	private String brand = "레오폴드";
	
	public Product() {
	}
	
	public void information() {
		System.out.println("제품 종류 : " + pName);
		System.out.println("가격 : " + price);
		System.out.println("브랜드 : " + brand);
	}
}
