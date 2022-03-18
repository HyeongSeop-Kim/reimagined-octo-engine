package exam09;

public class Circle {
	private final static double PI = 3.14;
	private double radius;
	private double area;
	private double round;
	
	public Circle() {}
	
	public Circle(double radius) {
		setRadius(radius);
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
		_area();
		_round();
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return area;
	}
	
	public double getRound() {
		return round;
	}
	
	private void _area() {
		area = PI * radius * radius;
	}
	
	private void _round() {
		round = radius * 2 * PI;
	}
}
