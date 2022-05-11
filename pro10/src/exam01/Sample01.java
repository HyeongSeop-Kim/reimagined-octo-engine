package exam01;

public class Sample01 {

	public static void main(String[] args) {
		MyException m = new MyException();
		System.out.println("에러 발생 전");
		try {
			m.exceptionThrows();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//m.exceptionNonThrows();
		System.out.println("에러 발생 후");
		
	}

}
