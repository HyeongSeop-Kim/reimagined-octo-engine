package exam02;

public class Sample02 {

	public static void main(String[] args) {
		// 1 ~ 99 까지 반복문을 사용하여 반복 출력 하시오.(단, 초기값 설정은 i = 1)
		for (int i = 1; i < 100; i++) {
			System.out.println(i);
		}
		// 1 ~ 99 까지 반복문을 사용하여 반복 출력 하시오.(단, 초기값 설정은 i = 0)
		for (int i = 0; i < 99; i++) {
			System.out.println(i+1);
		}
		// 1 ~ 99 까지 반복문을 사용하여 반복 출력 하시오.(단, 짝수만 출력)
		for (int i = 1 ; i < 98; i+=2) {
			System.out.println(i);
		}
	}

}
