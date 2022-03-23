package exam02;

import java.util.Arrays;

public class ReportGrade {
	private String name;
	private String subjects[] = new String[0];
	private double grades[] = new double[1];
	
	public ReportGrade() {}
	public ReportGrade(String name) {
		this.name = name;
	}
	public ReportGrade(String name, String subjects[]) {
		setName(name);
		_setSubjects(subjects);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void _setSubjects(String subjects[]) {
		int cnt = 1;
		if(this.subjects.length == 0) {
			String temp[] = Arrays.copyOf(this.subjects, this.subjects.length+1);
			this.subjects = temp;
			this.subjects[0] = subjects[0];
		}
		for(int i = 0; i < subjects.length; i++) {
			boolean flag = false;
			for(int j = 0; j < this.subjects.length; j++) {
				if(this.subjects[j].equals(subjects[i])) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				String temp[] = Arrays.copyOf(this.subjects, this.subjects.length+1);
				this.subjects = temp;
				this.subjects[cnt++] = subjects[i];
			}
		}
		this.grades = Arrays.copyOf(this.grades, subjects.length);
	}
	
	public void _setGrade(String subject, double grade) {
		this.grades[this._findIndex(subject)] = grade;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String[] getSubjects() {
		return this.subjects;
	}
	
	public double[] getGrades() {
		return this.grades;
	}
	
	public double getGrade(String subject) {
		return this.grades[this._findIndex(subject)];
	}
	
	private int _findIndex(String subject) {
		int idx = -1;
		for(int i = 0; i < this.subjects.length; i++) {
			if(this.subjects[i].equals(subject)) {
				idx = i;
			}
		}
		return idx;
	}
	
	public void add(String subject, double grade) {
		int len = this.subjects.length;
		if(len == 0) {
			String temp[] = Arrays.copyOf(this.subjects, len+1);
			this.subjects = temp;
			this.subjects[0] = subject;
		}
		boolean flag = false;
		for(int i = 0; i < len; i++) {
			if(this.subjects[i].equals(subject)) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			String temp[] = Arrays.copyOf(this.subjects, len+1);
			this.subjects = temp;
			this.subjects[len] = subject;
			this.grades = Arrays.copyOf(this.grades, len+1);
			this.grades[len] = grade;
		}
	}
	
	public void remove(String subject) {
		int idx = this._findIndex(subject);
		if(idx == -1) {
			System.out.println("해당 과목이 존재하지 않습니다.");
		} else {
			for(int i = idx; i < this.subjects.length - 1; i++) {
				this.subjects[i] = this.subjects[i+1];
				this.grades[i] = this.grades[i+1];
			}
			String sTemp[] = new String[this.subjects.length - 1]; 
			System.arraycopy(this.subjects, 0, sTemp, 0, this.subjects.length-1);
			this.subjects = sTemp;
			
			double dTemp[] = new double[this.grades.length-1];
			System.arraycopy(this.grades, 0, dTemp, 0, this.grades.length-1);
			this.grades = dTemp;
		}		
	}
	
	public void remove(int idx) {
		if(0 <= idx && idx < this.subjects.length) {
			for(int i = idx; i < this.subjects.length - 1; i++) {
				this.subjects[i] = this.subjects[i+1];
				this.grades[i] = this.grades[i+1];
			}
			String sTemp[] = new String[this.subjects.length - 1]; 
			System.arraycopy(this.subjects, 0, sTemp, 0, this.subjects.length-1);
			this.subjects = sTemp;
			
			double dTemp[] = new double[this.grades.length-1];
			System.arraycopy(this.grades, 0, dTemp, 0, this.grades.length-1);
			this.grades = dTemp;
		} else {
			System.out.println("인덱스의 범위를 벗어났습니다.");
		}
	}
}
