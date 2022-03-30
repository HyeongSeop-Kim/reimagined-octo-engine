package exam07;

public class DeputySectionChief extends Worker {
	protected int creditCard;

	public DeputySectionChief(String name, String position) {
		super(name, position);
	}
	
	public int getCreditCard() {
		return this.creditCard;
	}
	
	public void corpCard(int amount) {
		if(this.getAnnualIncom() * 0.015 > this.creditCard + amount) {
			System.out.printf("%,d 원을 법인 카드로 지불하였습니다.\n", amount);
			creditCard += amount;
		} else {
			System.out.println("법인 카드의 한도를 초과하였습니다.");
			System.out.printf("현재까지 사용액은 %,d원 입니다. \n", this.creditCard);
			System.out.printf("한도내에서 %,.0f원 만큼만 사용할 수 있습니다.", this.getAnnualIncom() * 0.015 - this.creditCard);
		}
	}
	
}
