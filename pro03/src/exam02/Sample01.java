package exam02;

public class Sample01 {

	public static void main(String[] args) {
		// 반복문 : for, while, do while
		
		// for 문
		for (int i = 0; i < 5; i ++) {
			System.out.println(i + "번째 반복");
		}
		
		System.out.println("-------------");
		
		// 초기식 생략
		int i = 0;
		for (; i < 5; i ++) {
			System.out.println(i + "번째 반복");
		}

		System.out.println("-------------");
		
		// 조건식 생략
		for (i = 0; ; i ++) {
			if (i > 4) {
				break;
			}
			System.out.println(i + "번째 반복");
		}
		
		System.out.println("-------------");
		
		// 증감식 생략
		for (i = 0; i < 5;) {
			System.out.println(i + "번째 반복");
			i++;
		}
		
		System.out.println("-------------");
		
		// 전부 생략
		i=0;
		for (;;) {
			System.out.println(i + "번째 반복");
			if(i >= 4) {
				break;
			}
			i++;
		}
	}

}
