package exam01;

import java.util.Scanner;

public class Sample08 {

	public static void main(String[] args) {
		/*
		 *  사용자가 입력한 영문자열에서 입력된 문자의 수를 구하는 코드를 작성
		 *  	1. 영문자를 제외한 다른 문자는 무시한다.
		 *  	2. 영문자의 대/소문자를 구분하지 않고 문자수를 구한다.
		 *  예제
		 *  	영문자 입력 : hello java programing
		 *  
		 * 		입력한 영문자 분포
		 * 		a(3), e(1), g(2), ....
		 */
		
		Scanner sc = new Scanner(System.in);
		String sentenceInput = new String();
		
		System.out.print("영문자 입력 : ");
		sentenceInput = sc.nextLine();
	
		int[] cArr = new int[26];
		
		for(int i = 0; i < sentenceInput.length(); i++) {
			char c = sentenceInput.charAt(i);
			if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
				cArr[c % 32 - 1]++;
			}
//			if((c >= 'A' && c <= 'Z')) {
//				cArr[c - 'A'] += 1;
//			} else if((c >= 'a' && c <= 'z')) {
//				cArr[c - 'a'] += 1;
//			}
		}
		
		for(int i = 0; i < cArr.length; i++) {
			if(cArr[i] > 0) {
				System.out.printf("%c(%d)\t", (char)(i+97), cArr[i]);
			}
		}
		
		// 직접 짠 코드
		
//		int sentenceLength = 0, temp = 0;
//		boolean flag = false;
//		char spelling[], alpha[];
//		int alphaCnt[];
//		
//		
//		System.out.print("영문자 입력 : ");
//		sentenceInput = sc.nextLine();
//		sentenceLength = sentenceInput.length();
//		
//		spelling = new char[sentenceLength];
//		alpha = new char[sentenceLength];
//		alphaCnt = new int[sentenceLength];
//		spelling = sentenceInput.toCharArray();
//		
//		for(int i = 0; i < sentenceLength; i++) {
//			for(int j = 0; j < sentenceLength; j++) {
//				if(spelling[i]==' ') {
//					flag = true;
//					break;
//				} else if(alpha[j] == spelling[i]) {
//					flag = true;
//					alphaCnt[j]++;
//					break;
//				}
//			}
//			if(flag == false) {
//				alpha[temp]=spelling[i];
//				alphaCnt[temp++]++;
//			}
//			flag = false;
//		}
//		for(int i = 0; i < sentenceLength; i++) {
//			if(alphaCnt[i]!=0) {
//				System.out.printf("%c(%d), ",alpha[i],alphaCnt[i]);
//			}
//		}
		
		
	}

}
