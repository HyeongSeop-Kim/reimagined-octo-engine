package exam03;

import java.util.Arrays;
import java.util.Random;

public class Sample01 {

	public static void main(String[] args) {
		// 1.배열의 크기가 10인 정수 배열을 2개 생성 후 각 배열에 10 ~ 99 사이의 난수값으로 초기화 시키고 출력한다.

		int arr1[] = new int[10];
		int arr2[] = new int[10];
		
		Random rd = new Random();
		
		for(int i = 0; i < 10; i++) {
			arr1[i] = rd.nextInt(99) + 1;
			arr2[i] = rd.nextInt(99) + 1;
		}
		
		System.out.println("1. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr1));
		System.out.println("\t" + Arrays.toString(arr2));

		
		// 2. 1번 문제에서 생성한 첫번째 배열과 두번째 배열의 합을 구하여 새로운 세번째 배열을 만들고 출력한다.
		
		int arr3[] = new int[10];
		
		System.out.println();
		
		for(int i = 0; i < 10; i++) {
			arr3[i] = arr1[i] + arr2[i];
		}
		
		System.out.println("2. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr3));
		
		// 3. 2번 문제까지 진행하여 만들어진 3개의 배열을 이용하여 짝수값만 저장되어 있는 배열과 홀수값만 저장되어 있는 배열을 만들고 짝수 배열과 홀수 배열을 출력한다.
		
		int arr4[] = new int[0];
		int arr5[] = new int[0];
		int evenCnt = 0, oddCnt = 0;
		
	System.out.println();
		
		for(int i = 0; i < 10; i++) {
			if(arr1[i] % 2 == 0) {
				int temp[] = Arrays.copyOf(arr4,  arr4.length + 1);
				arr4 = temp;
				
				arr4[evenCnt++] = arr1[i];
			} else if(arr1[i] % 2 == 1) {
				int temp[] = Arrays.copyOf(arr5,  arr5.length + 1);
				arr5 = temp;
				
				arr5[oddCnt++] = arr1[i];
			}
			if(arr2[i] % 2 == 0) {
				int temp[] = Arrays.copyOf(arr4,  arr4.length + 1);
				arr4 = temp;
				
				arr4[evenCnt++] = arr2[i];
			} else if(arr2[i] % 2 == 1) {
				int temp[] = Arrays.copyOf(arr5,  arr5.length + 1);
				arr5 = temp;
				
				arr5[oddCnt++] = arr2[i];
			}
			if(arr3[i] % 2 == 0) {
				int temp[] = Arrays.copyOf(arr4,  arr4.length + 1);
				arr4 = temp;
				
				arr4[evenCnt++] = arr3[i];
			} else if(arr3[i] % 2 == 1) {
				int temp[] = Arrays.copyOf(arr5,  arr5.length + 1);
				arr5 = temp;
				
				arr5[oddCnt++] = arr3[i];
			}
		}
		
		System.out.println("3. 출력 결과");
		System.out.println("\t짝수 데이터 : " + Arrays.toString(arr4));
		System.out.println("\t홀수 데이터 : " + Arrays.toString(arr5));
		
		System.out.println();
		
		// 4. 짝수/홀수 배열에 있는 값들 중 중복된 값이 있는 경우 하나의 값만 남겨 새로운 배열로 만들고 출력한다.
		
		int arr6[] = new int[0];
		int arr7[] = new int[0];
		boolean flag = false;
		oddCnt = 0;		evenCnt = 0;
		
		for(int i = 0; i < arr4.length; i++) {
			if (i == 0) {
				int temp[] = Arrays.copyOf(arr6,  arr6.length + 1);
				arr6 = temp;
				arr6[evenCnt++] = arr4[i];
			}
			for(int j = 0; j < arr6.length; j++) {
				if(arr4[i] == arr6[j]) {
					flag=true;
					break;
				} 
			}
			if(flag==false) {
				int temp[] = Arrays.copyOf(arr6,  arr6.length + 1);
				arr6 = temp;
				arr6[evenCnt++] = arr4[i];
			}		
			flag=false;
		}
		
		for(int i = 0; i < arr5.length-1; i++) {
			if(arr5[i] != -1) {
				for(int j = i+1; j < arr5.length; j++) {
					if(arr5[i] == arr5[j]) {
						arr5[j] = -1;
					}
				}
			}
		}
		
		for(int i = 0; i < arr5.length; i++) {
			if (arr5[i] != -1) {
				int temp[] = Arrays.copyOf(arr7,  arr7.length + 1);
				arr7 = temp;
				arr7[oddCnt++] = arr5[i];
			}
		}
//		for(int i = 0; i < arr5.length; i++) {
//			if (i == 0) {
//				int temp[] = Arrays.copyOf(arr7,  arr7.length + 1);
//				arr7 = temp;
//				arr7[oddCnt++] = arr5[i];
//			}
//			for(int j = 0; j < arr7.length; j++) {
//				if(arr5[i] == arr7[j]) {
//					flag=true;
//					break;
//				} 
//			}
//			if(flag==false) {
//				int temp[] = Arrays.copyOf(arr7,  arr7.length + 1);
//				arr7 = temp;
//				arr7[oddCnt++] = arr5[i];
//			}		
//			flag=false;
//		}
		System.out.println("4. 출력 결과");
		System.out.println("\t중복이 제거된 짝수 데이터 : " + Arrays.toString(arr6));
		System.out.println("\t중복이 제거된 홀수 데이터 : " + Arrays.toString(arr7));
		
		// 5. 짝수/홀수 배열에 있는 값을 작은 값부터 큰값 순으로 정렬된 배열을 만들고 출력한다.
		
		for(int i = 0; i<arr6.length - 1; i++) {
			for(int j = i+1; j < arr6.length; j++) {
				if(arr6[j] < arr6[i]) {
					int temp = arr6[i];
					arr6[i] = arr6[j];
					arr6[j] = temp;
				}
			}	
		}
		
		for(int i = 0; i<arr7.length - 1; i++) {
			for(int j = i+1; j < arr7.length; j++) {
				if(arr7[j] < arr7[i]) {
					int temp = arr7[i];
					arr7[i] = arr7[j];
					arr7[j] = temp;
				}
			}	
		}
		
		int arr8[] = Arrays.copyOf(arr6,  arr6.length);
		int arr9[] = Arrays.copyOf(arr7,  arr7.length);

		System.out.println("\n5. 출력 결과");
		System.out.println("\t 정렬된 짝수 데이터 : " + Arrays.toString(arr8));
		System.out.println("\t 정렬된 홀수 데이터 : " + Arrays.toString(arr9));
		
		// 6. 짝수/홀수 배열로 나누어져 있는 것을 하나의 배열로 만들고 출력한다.
		
		int arr10[] = new int[arr8.length + arr9.length];
		
		System.arraycopy(arr8, 0, arr10, 0, arr8.length);
		System.arraycopy(arr9, 0, arr10, arr8.length, arr9.length);
		
		System.out.println("\n6. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr10));
	}

}
