package examp05;

public class Student {
	private String name;
	private int age;
	private int grade;
	private int group;
	
	public Student() {
		
	}
//	public Student(String name) {
//		this.name = name;
//	}
//
//	public Student(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
//
//	public Student(String name, int age, int grade) {
//		this.name = name;
//		this.age = age;
//		this.grade = grade;
//	}

	public Student(String name, int age, int grade, int group) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}	
}
