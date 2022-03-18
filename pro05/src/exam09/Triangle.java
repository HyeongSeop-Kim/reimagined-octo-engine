package exam09;

public class Triangle {
	private double width;
	private double height;
	private double area;
	private double round;
	
	public Triangle() {}
	
	public Triangle(double width, double height) {
		setWidth(width);
		setHeight(height);
	}
	
	public void setWidth(double width) {
		this.width = width;
		_area();
		_round();
	}
	
	public void setHeight(double height) {
		this.height = height;
		_area();
		_round();
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getArea() {
		return area;
	}
	
	public double getRound() {
		return round;
	}
	
	private void _area() {
		area = this.width * this.height / 2;
	}
	
	private void _round() {
		round = this.width * 3;
	}
}
