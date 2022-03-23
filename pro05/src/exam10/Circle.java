package exam10;

public class Circle {
	private final static double PI = 3.14;
	private int radius = 1;
	
	public Circle() {}
	
	public void incrementRadius() {
		radius++;
	}
	
	public void getAreaOfCircle() {
		System.out.println("원의 넓이 : " + radius*radius*PI);
	}
	
	public void getSizeOfCircle() {
		System.out.println("원의 둘레 : " + 2*radius*PI);
	}
}
