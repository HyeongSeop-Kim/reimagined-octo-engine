package exam01;

public class Sample01 {

	public static void main(String[] args) {
		int i1 = 500;
		byte b1;
		
		b1 = (byte)i1;
		
		System.out.println(i1);
		System.out.println(b1);
		
		byte b2 = 100;
		int i2;
		
		i2 = b2;
		
		System.out.println(i2);
		System.out.println(b2);

		double d1 = 10.4;
		int i3 = 5;
		int i4;
		
		i4 = (int)(i3 + d1);
		System.out.println(i4);
		
		double d2 = 10.6;
		double d3 = 10.7;
		int i5, i6;
		
		i5 = (int)(d2+d3);
		i6 = (int)d2+(int)d3;
		
		System.out.println(i5);
		System.out.println(i6);
	}

}
