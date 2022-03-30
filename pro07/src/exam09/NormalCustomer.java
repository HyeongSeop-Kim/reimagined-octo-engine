package exam09;

public class NormalCustomer extends Customer {
	public NormalCustomer(String name, int age, char gender) {
		this.setName(name);
		this.setAge(age);
		this.setGender(gender);
	}

	@Override
	public void buy(String productName, double price) {
		priceTotal += price;
		System.out.printf("%s 님이 %s 을(를) %,.0f 원에 구입하셨습니다.\n", this.getName(), productName, price);
	}

	@Override
	public boolean refund(String productName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean basket(String productName, int count) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String searchDelivery(String orderCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addPoint(int price) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] suggestionProduct() {
		// TODO Auto-generated method stub
		return null;
	}
}
