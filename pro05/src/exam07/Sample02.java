package exam07;

public class Sample02 {

	public static void main(String[] args) {
		Constructor c1 = new Constructor(10);
		System.out.println(c1.num1);
		
		Constructor c2 = new Constructor(10, 20);
		System.out.println(c2.num1);
		
		Constructor c3 = new Constructor(10, 20, 30);
		System.out.println(c3.num1);
		
		Constructor c4 = new Constructor(10, 20, 30, 40);
		System.out.println(c4.num1);
	}

}
