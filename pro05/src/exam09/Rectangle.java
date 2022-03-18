package exam09;

public class Rectangle {
	private double width;
	private double height;
	private double area;
	private double round;
	
	public Rectangle() {}
	
	public Rectangle(double width, double height) {
		widthHeight(width, height);
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
	
	public void widthHeight(double width, double height) {
		this.width = width;
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
		area = width * height;
	}
	
	private void _round() {
		round = (width + height) * 2;
	}
}
