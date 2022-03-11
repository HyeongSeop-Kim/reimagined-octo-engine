package exam02;

public class Sample08 {

	public static void main(String[] args) {
		// While 문
		int i = 0;
		while(i < 5) {
			System.out.println("i -> " + i);
			i++;
		}
		
		//do while 문
		i = 0;
		do {
			System.out.println("i => " + i);
			i++;
		}while(i < 5);
		
		// break, continue
		i = 0;
		while(i < 10) {
			i +=1;
			if(i %3 == 0) {
				System.out.println("i-> " + i);
			} else {
				continue;
			}
			System.out.println("이 출력은 i의 값이 3의 배수일 때만 실행됩니다.");
		}

	}

}
