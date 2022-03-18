package exam08;

public class MethodSample {
	public int num1;
	public static int num2 = 10;
	
	public void method01() {
		System.out.println("일반 메서드 실행됨.");
	}
	public static void method02() {
		System.out.println("static(정적) 메서드 실행됨.");
	}
	
	public int method03() {
		return 0;
	}
	
	public int[] method04() {
		int result[] = new int[3];
		return result;
	}
	
	public String method05() {
		String result = new String();
		
		// return null; 가능
		return result;
	}
	
	public int[] method06(int[] arr) {
		System.out.println(arr);
		arr[0] = 10;
		return arr;
	}
	
	public void method07(int ... nums) {
		System.out.println(nums);
	}
}
