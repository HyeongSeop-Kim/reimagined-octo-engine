package exam01;

public class Child extends Parent {
	public Child(int number) {
		super(number);
	}
	@Override	// 안해도 상관 없으나 오버라이딩이 가능한 메서으인지 확인하기 위한 용도
	public int getNumber() {
		int num = super.getNumber();
		return num + 10;
	}
}
