package exam01;

import java.util.Random;

public class Sample09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numArray[] = new int[5];
		boolean flag = false;
		Random rd = new Random();
		int randomNum = 0;
		
		for(int i = 0; i < 5;) {
			randomNum = rd.nextInt(19)+1;
			for(int j = 0; j <= i; j++) {
				if(numArray[j] == randomNum) {
					flag = true;
					break;
				}
			}
			if(flag == false) {
				numArray[i]=randomNum;
				System.out.print(numArray[i++] + " ");
			}
			flag = false;
		}
	}

}
