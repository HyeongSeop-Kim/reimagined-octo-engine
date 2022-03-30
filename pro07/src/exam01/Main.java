package exam01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Child child = new Child(1);
		
		System.out.println(child.number);
		child.number = 20;
		System.out.println(child.number);
		System.out.println(child.getNumber());
	}

}
