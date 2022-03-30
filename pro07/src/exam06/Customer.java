package exam06;

class Customer {
	private String name;
	private int age;
	private char gender;
	protected double priceTotal;

	public Customer(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

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
	
	public void buy(String productName, double price) {
		priceTotal += price;
		System.out.printf("%s 님이 %s 을(를) %,.0f 원에 구입하셨습니다.\n", this.name, productName, price);
	}

}
