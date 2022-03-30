package exam02;

public class Main {

	public static void main(String[] args) {
		Student s = new Student("홍길동");
		s.setAge(16);
		s.setGender('M');
		s.setClassLevel(1);
		s.setClassRoom(2);
		System.out.println(s.getName());
		
		Teacher t = new Teacher("");
		t.setAge(30);
		t.setGender('M');
		t.setClassLevel(1);
		t.setClassRoom(2);
		t.setSubject("수학");
		System.out.println(s.getName());
		
		System.out.println(s.getGender());
		System.out.println(t.getGender());
		
		System.out.println(s);
		System.out.println(t);
		
		Student s1 = new Student("홍길동");
		s1.setAge(16);
		s1.setGender('M');
		s1.setClassLevel(2);
		s1.setClassRoom(4);
		System.out.println(s1.getName());
		
		System.out.println(s.equals(s1));
	}

}
