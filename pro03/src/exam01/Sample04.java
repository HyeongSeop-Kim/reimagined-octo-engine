package exam01;

import java.util.Scanner;
public class Sample04 {

	public static void main(String[] args) {
		// Scanner를 사용하여 사용자 입력을 받고 다음의 결과가 나오도록 하시오.
		// 1. 사용자 입력을 통해 국어, 영어 수학 점수를 입력 받는다. (정수 데이터를 입력받는다.)
		// 2. 입력 받은 정수 데이터의 값에 대해 총점과 평균을 구한다.
		// 3. 평균 점수가 60점 이상인 경우에만 다음의 메시지를 출력한다.
		/* 		축하합니다. 합격입니다.
		 * 			총점 : 213점
		 * 			국어 : 75점
		 * 			영어 : 70점
		 *			수학 : 68점
		 *			평균 : 71.0 점
		 * 4. 평균 점수가 60점 미만인 경우에는 다음의 메시지를 출력한다.
		 * 		평균 점수가 미달하였습니다.
		 * 5. 국어, 영어, 수학 과목중 40 점 미만의 과목이 있는 경우 다음의 메시지를 출력한다.
		 * 		과락된 과목이 있어 불합격 되었습니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int math, eng, kor, sum;
		float avg;
		
		System.out.print("국어 점수를 입력해주세요. : ");
		kor = sc.nextInt();
		System.out.print("수학 점수를 입력해주세요. : ");
		math = sc.nextInt();
		System.out.print("영어 점수를 입력해주세요. : ");
		eng = sc.nextInt();
		
		sum = kor + math + eng;
		avg = sum/3f;
		
		if(kor < 40 || eng < 40 || math < 40) {
			System.out.print("과락된 과목이 있어 불합격 되었습니다.");
		} else if(avg >= 60) {
			System.out.println("축하합니다. 합격입니다.");
			System.out.printf("총점 : %d 점\n", sum);
			System.out.printf("국어 : %d 점\n", kor);
			System.out.printf("영어 : %d 점\n", eng);
			System.out.printf("수학 : %d 점\n", math);
			System.out.printf("총점 : %.1f 점", avg);
		} else {
			System.out.print("평균 점수가 미달하였습니다.");
		}
	}

}
