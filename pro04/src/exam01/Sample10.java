package exam01;

public class Sample10 {

	public static void main(String[] args) {
		// 동적 배열 : 기존 배열의 크기보다 크거나 작은 새로운 배열을 만들어서 사용하는 형태
		int arr1[] = new int[] {1, 2, 3};
		
		int[] temp = new int[arr1.length + 1];
		
		for(int i = 0; i < arr1.length; i++) {
			temp[i] = arr1[i];
		}
		arr1 = temp;
		
		arr1[3] = 1;
		
	}

}
