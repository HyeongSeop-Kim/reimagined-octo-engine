package exam03;

public class Sample02 {

	public static void main(String[] args) {
		// local variable은 반드시 initialized가 필요
		int x;
		x = 1;
		System.out.println(x);
		
		// 상수 : 한 번 initialized 한 후에는 값을 변경할 수 없다.
		final int i1;
		i1 = 2;
		
		final int i2 = 3;
		
		String str1 = "기차" + 123 + 45 + "출발";
		String str2 = 123 + 45 + "기차" + "출발";
		String str3 = "기차" + (123 + 45) + "출발";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}

}
