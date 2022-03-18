package exam09;

public class Sample01 {

	public static void main(String[] args) {
		// 1. 도형의 넓이, 둘레
		Circle c = new Circle(3);
		Rectangle r = new Rectangle(3, 4);
		Triangle t = new Triangle(3, 4);
		
		System.out.println("반지름이 " + c.getRadius() + "인 원의 넓이 : " + c.getArea());
		System.out.println("반지름이 " + c.getRadius() + "인 원의 둘레 : " + c.getRound());

		System.out.println("너비가 " + r.getWidth() + "이고 높이가 " + r.getHeight() + "인 사각형의 넓이 : " + r.getArea());
		System.out.println("너비가 " + r.getWidth() + "이고 높이가 " + r.getHeight() + "인 사각형의 둘레 : " + r.getRound());

		System.out.println("밑변이 " + t.getWidth() + "이고 높이가 " + t.getHeight() + "인 삼각형의 넓이 : " + t.getArea());
		System.out.println("한 변의 길이가 " + t.getWidth() + "인 정삼각형의 둘레 : " + t.getRound());
	}

}
