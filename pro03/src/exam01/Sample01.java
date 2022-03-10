package exam01;

public class Sample01 {

	public static void main(String[] args) {
		// 조건문 : 조건에 따라 코드를 실행하거나 실행하지 않게 제어

		// if문
		
		int num1 = 10;
		
		if(num1 > 10) {
			System.out.println("num1에 저장된 값은 10 보다 큽니다.");
		}
		
		// if else 문
		
		int num2 = 5;
		
		if(num2 %2 == 0) {
			System.out.println("num2의 값은 짝수입니다.");
		} else {
			System.out.println("num2의 값은 홀수입니다.");
		}
		
		// if else if문
		
		int num3 = 100;
		
		if(num3 <= 39) {
			System.out.println("과락입니다.");
		} else if(num3 <= 59) {
			System.out.println("E 등급입니다.");
		} else if(num3 <=69 ) {
			System.out.println("D 등급입니다.");
		} else if(num3 <= 79) {
			System.out.println("C 등급입니다.");
		} else if(num3 <= 89) {
			System.out.println("B 등급입니다.");
		} else {
			if(num3 == 100) {
				System.out.println("만점입니다.");
			} else {
				System.out.println("A 등급입니다.");	
			}
		}
	}

}
