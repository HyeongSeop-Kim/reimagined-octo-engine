package exam05;

import java.util.Random;

public class Sample01 {

	public static void main(String[] args) {
		Circle cc1 = new Circle();
		Circle cc2 = new Circle();
		
		cc1.radius = 1.5;	cc1.diamiter = cc1.radius * 2;	cc1.area = cc1.radius * cc1.radius * Circle.PI;
		cc2.radius = 3.5;	cc2.diamiter = cc2.radius * 2;	cc2.area = cc2.radius * cc2.radius * Circle.PI;
		
		Rectangle rtg1 = new Rectangle();
		Rectangle rtg2 = new Rectangle();
		Random rd = new Random();
		
		rtg1.width = cc1.diamiter;	rtg1.height = rd.nextInt(7) + 3;	rtg1.area = rtg1.height * rtg1.width;
		rtg2.width = cc2.diamiter;	rtg2.height = rd.nextInt(7) + 3;	rtg2.area = rtg2.height * rtg2.width;
		
		System.out.println("원1의 넓이 : " + cc1.area);
		System.out.println("원2의 넓이 : " + cc2.area);
		System.out.println("사각형1의 넓이 : " + rtg1.area);
		System.out.println("사각형2의 넓이 : " + rtg2.area);
	}

}
