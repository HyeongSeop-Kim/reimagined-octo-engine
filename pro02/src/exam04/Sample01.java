package exam04;

public class Sample01 {

	// 단항 연산자 예제
	public static void main(String[] args) {
		// 논리 부정 연산자 -> !
		boolean b1 = true;
		boolean b2 = !b1;
		
		System.out.println("!true -> " + b2);

		// 증감 연산자 -> ++(1씩 증가), --(1씩 감소)
		int i1 = 1;
		++i1;
		
		System.out.println("++i1 -> " + i1);
		
		--i1;
		
		System.out.println("--i1 ->" + i1);
		
		// 증감 연산의 종류
		// 전위 연산 : 연산을 먼저 한 후에 연산결과를 사용하는 것
		// 후위 연산 : 값을 먼저 사용한 후 연산을 수행하는 것
		
		int i2 = 1;
		int i3 = ++i2;
		
		int i4 = 1;
		int i5 = i4++;
		
		System.out.printf("전위 결과 -> i2 = %d, i3 = %d\n", i2, i3);
		System.out.printf("후위 결과 -> i4 = %d, i5 = %d", i4, i5);
	}

}
