package exam01;

import java.util.Scanner;

public class Sample05 {

	public static void main(String[] args) {
		/*
		 *  카이사르 암호 만들기
		 *  	- 사용자 입력으로 영단어를 입력받아 암호화
		 *  	- 'z' 문자에 대한 쉬프트가 빌요한 경우 'a' 로 넘어가게 해야한다.
		 *  
		 *  출력 형식
		 *  	암호화 전 : apple
		 *  	암호화 후 : dssoh
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String sentence = new String();
		int sentenceLength = 0;
		int upperStart = 'A', upperEnd = 'Z';
		int lowerStart = 'a', lowerEnd = 'z';	
		
		System.out.print("암호화할 영어 문장을 입력해주세요. : ");
		sentence = sc.nextLine();
		sentenceLength = sentence.length();
		// 문자열-> 문자배열로 전환하는 method : 변수명.toCharArray();
		
		char encode[] = new char[sentenceLength];
		
		for(int i = 0; i < sentenceLength; i++) {
			if(sentence.charAt(i)>=upperStart && sentence.charAt(i)<=upperEnd) {
				if((sentence.charAt(i) + 3)>upperEnd) {
					encode[i] = (char)(sentence.charAt(i) + 3 - 26);
				} else {
					encode[i] = (char)(sentence.charAt(i) + 3);
				}
			} else if(sentence.charAt(i)>=lowerStart && sentence.charAt(i)<=lowerEnd) {
				if((sentence.charAt(i) + 3)>lowerEnd) {
					encode[i] = (char)(sentence.charAt(i) + 3 - 26);
				} else {
					encode[i] = (char)(sentence.charAt(i) + 3);
				}
			} else {
				encode[i]=sentence.charAt(i);
			}
		}
		
		String result = new String(encode);
		
		System.out.print("암호화 전 : " + sentence + "\n");
		System.out.print("암호화 후 : " + result);
//		for(int i = 0; i < sentenceLength; i++) {
//			System.out.print(encode[i]);
//		}
	}

}
