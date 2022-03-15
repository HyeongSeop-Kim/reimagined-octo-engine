package exam02;

import java.util.Random;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * 1~16까지의 정수를 4X4 배열에 순차적으로 저장하고 표 형식으로 줄력하시오.
		 */
		
		int arr1[][] = new int[4][4];
		int temp = 1;
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.print("+---+---+---+---+\n");
			for(int j = 0; j < arr1[i].length; j++) {
				arr1[i][j] = temp++;
				System.out.printf("|%3d", arr1[i][j]);
			}
			System.out.print("|\n");
		}
		System.out.print("+---+---+---+---+\n");
		
		/*
		 * 1~49 사이의 임의의 정수를 5X6 배열에 순차적으로 저장하고 표 형식으로 출력하시오.
		 */
		
		int arr2[][] = new int[5][6];
		int randNum = 0;
		
		Random rd = new Random();
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.print("+---+---+---+---+---+---+\n");
			for(int j = 0; j < arr2[i].length; j++) {
				randNum = rd.nextInt(49)+1;
				arr2[i][j] = randNum;
				System.out.printf("|%3d", arr2[i][j]);
			}
			System.out.print("|\n");
		}
		System.out.print("+---+---+---+---+---+---+\n");
		
		/*
		 * 1~49 사이의 임의이 정수를 5XN 배열에 순차적으로 저장하고 표 형식으로 출력하시오.
		 * N의 경우 3 ~ 6 사이의 임의의 크기로 만들어 저장되도록 한다.
		 */
		
		int arr3[][] = new int[5][];
		int arrNum = 0;
		randNum = 0;
		
		for(int i = 0; i < arr3.length; i++) {
			arrNum = rd.nextInt(4)+3;
			arr3[i] = new int[arrNum];
			
			
			for(int j = 0; j < arr3[i].length; j++) {
				randNum = rd.nextInt(49)+1;
				arr3[i][j] = randNum;
			}
		}
		
		int maxLength = 0;
		
		for(int i = 0; i < arr3.length; i++) {
			if (maxLength < arr3[i].length) {
				maxLength = arr3[i].length;
			}	
		}
		
		for(int i = 0; i < arr3.length; i++) {
			for(int j = 0; j < maxLength; j++) {
				System.out.print("+---");
			}
			System.out.print("+\n");
			for(int j = 0; j < arr3[i].length; j++) {
				System.out.printf("|%3d", arr3[i][j]);
			}
			if(arr3[i].length < maxLength) {
				for(int j = 0; j < maxLength - arr3[i].length; j++) {
					System.out.print("|   ");
				}
			}
			System.out.print("|\n");
		}
		for(int i = 0; i < maxLength; i++) {
			System.out.print("+---");
		}
		System.out.print("+\n");
		
	}

}
