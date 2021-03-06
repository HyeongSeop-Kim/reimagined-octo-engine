package exam05;

public class Main {

	public static void main(String[] args) {
		Person s1 = new Student("홍길동", 16);
		Person t1 = new Teacher("김철수", 28);
		
		System.out.println(s1.getName() + " | " + s1.getAge());
		System.out.println(t1.getName() + " | " + t1.getAge());

		Person[] p1 = new Person[3];
		p1[0] = new Teacher("김철수", 28);
		p1[1] = new Student("홍길동" , 16);
		p1[2] = new Student("박광만" , 16);
		
		for(int i = 0; i < p1.length; i++) {
			System.out.println(p1[i].getName() + " | " + p1[i].getAge());
		}
		
		Person s2 = new Student("홍길동", 16);
		Student s3 = (Student)s2;
		s3.setClassLevel(1);
		s3.setClassRoom(2);
		
		Person t2 = new Teacher("김철수", 28);
		Teacher t3 = (Teacher)t2;
		t3.setClassLevel(1);
		t3.setClassRoom(2);
		t3.setSubject("국어");
		
		Person[] p2 = new Person[2];
		p2[0] = s3;
		p2[1] = t3;
		
		for(int i = 0; i < p2.length; i++) {
			if(p2[i] instanceof Student) {
				Student s = (Student)p2[i];
				System.out.println(s.getClassLevel() + "학년 " + s.getClassRoom() + "반 학생");
			} else {
				Teacher t = (Teacher)p2[i];
				System.out.println(t.getClassLevel() + "학년 " + t.getClassRoom() + "반 " + t.getSubject() + " 담당 선생님");
			}
			
		}
	}

}
