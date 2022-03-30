package exam09;

public class PremiumCustomer extends Customer{
	private double discount;
	
	public PremiumCustomer(String name, int age, char gender) {
		this.setName(name);
		this.setAge(age);
		this.setGender(gender);
	}
	
	@Override
	public void buy(String productName, double price) {
		price = _calcDiscount(price);
		priceTotal += price;
		System.out.printf("%s님이 %s을(를) 할인율 %.2f 적용하여 %,.0f에 구입하셨습니다.\n"
				, getName(), productName, this.discount, price);
		
	}
	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	private double _calcDiscount(double price) {
		if(priceTotal > 1000000) {
			this.discount = 0.1;
		} else if(priceTotal > 1100000) {
			this.discount = 0.2;
		} else if(priceTotal > 1200000) {
			this.discount = 0.3;
		}
		price = price * (1-discount);
		return price;
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
