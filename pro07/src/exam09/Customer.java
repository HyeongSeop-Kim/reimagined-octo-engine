package exam09;

public abstract class Customer {
	private String name;
	private int age;
	private char gender;
	protected double priceTotal;

//	public Customer(String name, int age, char gender) {
//		this.name = name;
//		this.age = age;
//		this.gender = gender;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}
	
	public abstract void buy(String productName, double price);
	
	public abstract boolean refund(String productName);
	
	public abstract boolean basket(String productName, int count);
	
	public abstract String searchDelivery(String orderCode);
	
	public abstract int addPoint(int price);
	
	public abstract String[] suggestionProduct();

}
