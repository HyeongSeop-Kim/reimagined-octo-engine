package exam04;

public class Grade {
	private String subject;
	private double grade;
	
	public Grade() {}
	
	public Grade(String subject) {
		this.subject = subject;
	}
	
	public Grade(String subject, double grade) {
		this.subject = subject;
		this.grade = grade;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
}
