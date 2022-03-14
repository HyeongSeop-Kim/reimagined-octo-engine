package exam01;

public class Sample02 {

	public static void main(String[] args) {
		// 배열의 크기가 10인 배열을 선언하고 10 ~ 1 까지의 값으로 초기화 한다.
		int arr1[] = new int[10];
		
		for(int i = 0; i<10; i++) {
			arr1[i] = 10 - i;
			System.out.print(arr1[i] + "\t");
		}
		
		// 배열의 크기가 10 인 배열을 선언하고 2부터 시작하여 짝수값에 해당하는 값으로 초기화 한다.
		System.out.println("");
		
		int arr2[];
		arr2 = new int[10];
		
		for(int i = 0; i<10; i++) {
			arr2[i] = (i+1)*2;
			System.out.print(arr2[i] + "\t");
		}
		
		// 배열의 크기가 5 인 실수 배열을 선언하고 1 부터 0.5 씩 증가된 값으로 초기화 한다.
		System.out.println("");
		
		double arr3[];
		arr3 = new double[5];
		double temp=1;
		
		for(int i = 0; i<5; i++) {
			arr3[i] = temp;
			temp += 0.5;
			System.out.print(arr3[i] + "\t");
		}
		// 배열의 크기가 5 인 문자 배열을 선언하고 'A' ~ 'E'까지의 문자값으로 초기화한다.
System.out.println("");
		
		char arr4[];
		arr4 = new char[5];
		char init = 'A';
		
		for(int i = 0; i<5; i++) {
			arr4[i] = init++;
			System.out.print(arr4[i] + "\t");
		}
	}

}
