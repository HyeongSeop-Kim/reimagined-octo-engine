package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * 로또 번호 생성
		 * 		- 1~45 까지의 랜덤 번호를 생성하여 리스트에 답는다.
		 * 		- 중복된 값 없이 리스트에 담도록 한다.
		 * 		- 총 6개의 정수값을 리스트에 저장한다.
		 * 	    - 마지막 출력할 때는 오름차순으로 정렬하여 출력되도록한다.
		 */
		
		// List<Integer> numList = new ArrayList<Integer>();
		Set<Integer> numSet = new HashSet<Integer>();
		
		Random rd = new Random();
		
//		for(int i = 0; i < 6;) {
//			int randNum = rd.nextInt(45)+1;
//			if(!numList.contains(Integer.valueOf(randNum))) {
//				numList.add(randNum);
//				i++;
//			}
//		}
		for(int i = 0; i < 6;) {
			int randNum = rd.nextInt(45)+1;
			if(numSet.add(randNum)) {
				i++;
			}
		}
		
		List<Integer> numList = new ArrayList<Integer>(numSet);
		Collections.sort(numList);
		System.out.println(numList);

	}

}
