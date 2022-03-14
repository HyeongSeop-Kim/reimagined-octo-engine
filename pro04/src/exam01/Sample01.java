package exam01;

public class Sample01 {

	public static void main(String[] args) {
		 /*
		  * Array(배열) : 동일한 자료형의 데이터를 하나의 묶음으로 만들어 관리
		  * 배열로 저장된 값은 Index 번호가 0번부터 부여되어 개별 값에 접근 할 수 있다.
		  * 선언 방법 : 자료형[] 배열명; or 자료형 배열명[];
		  * 배열에 저장할 값의 갯수(배열크기) 정하는 법 : 배열명 = NEW 자료형[배열크기];
		  * 초기값 설정 : 배열명[위치값] = 초기값;
		  *
		  * 배열 선언 후 즉시 크기 설정 및 초기값 저장하는 방법
		  * 자료형[] 배열명 = new 자료형[] {초기값1, 초기값2, ...}; 
		  */
		 
		int arr1[];
		arr1 = new int[3];
		arr1[0] = 1;	arr1[1] = 2;	arr1[2] = 3;
		
		// 반복문을 사용하여 초기화
		for(int i = 0; i < 3; i++) {
			arr1[i] = i+1;
		}
		
		System.out.println(arr1[0] + ", " + arr1[1] + ", " + arr1[2]);
		
		int arr2[] = new int[] {1, 2, 3};
		
		//
		for(int i = 0; i < 3; i++) {
			System.out.print(arr2[i] + "\t");
		}
		
		
		
	}

}
