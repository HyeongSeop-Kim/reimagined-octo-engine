package exam06;

public class PremiumCustomer extends Customer{
	private double discount;
	
	public PremiumCustomer(String name, int age, char gender) {
		super(name, age, gender);
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
}
