package exam01;

import java.util.Arrays;

public class Sample06 {

	public static void main(String[] args) {
		// 반복문 사용한 깊은 복사
		int arr1[] = new int[] {1, 2, 3, 4, 5};
		int arr2[] = new int[arr1.length];
		
		for(int i = 0; i < arr1.length; i++)  {
			arr2[i] = arr1[i];
		}
		
		// 자바 기본 기능 사용한 깊은복사
		int arr3[] = new int[arr1.length];
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		
		arr1[0] = 10;
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr3[%d] -> %d\n", i, arr1[i], i, arr3[i]);
		}
		
		// Arrays 객체를 사용한 깊은 복사
		int[] arr4 = Arrays.copyOf(arr1,  arr1.length);
		
		arr1[1] = 20;
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr4[%d] -> %d\n", i, arr1[i], i, arr4[i]);
		}
		
		// .clone() method를 사용한 깊은 복사
		int[] arr5 = arr1.clone();
		
		arr1[2] = 30;
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr5[%d] -> %d\n", i, arr1[i], i, arr5[i]);
		}
	}

}
