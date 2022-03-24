package exam04;

import java.util.Arrays;

public class GradeList {
	private Grade gradeList[];
	
	public GradeList() {}
	
	public GradeList(Grade gradeList[]) {
		this.gradeList = gradeList;
	}
	
	public Grade get(int idx) {
		return this.gradeList[idx];
	}
	
	public int length() {
		return this.gradeList.length;
	}
	
	public int findIndex(String subject) {
		int idx = -1;
		
		for(int i = 0; i < this.length(); i++) {
			if(this.gradeList[i].getSubject().equals(subject)) {
				idx = i;
			}
		}
		
		return idx;
	}
	
	public void add(Grade data) {
		this.gradeList = Arrays.copyOf(this.gradeList, this.length()+1);
		this.gradeList[this.length() - 1] = data;
	}
	public void add(String name) {
		Grade g = new Grade(name);
		this.add(g);
	}
	public void add(String name, double score) {
		Grade g = new Grade(name, score);
		this.add(g);
	}
	
	public void remove(String subject) {
		int idx = this.findIndex(subject);
		int cnt = 0;
		Grade temp[] = new Grade[this.length() - 1];
		
		for(int i = 0; i < this.length(); i++) {
			if(i != idx) {
				temp[cnt++] = this.gradeList[i];
			}
		}
		this.gradeList = temp;
	}
	
	public void changeSubject(String targetSub, String data) {
		int idx = this.findIndex(targetSub);
		this.gradeList[idx].setSubject(data);
	}
	
	public void update(String targetSub, String data, double grade) {
		int idx = this.findIndex(targetSub);
		this.gradeList[idx].setSubject(data);
		this.gradeList[idx].setGrade(grade);
	}
	
	public void changeGrade(String targetSub, double grade) {
		int idx = this.findIndex(targetSub);
		this.gradeList[idx].setGrade(grade);
	}
	
	public void update(String src, Grade dest) {
		int idx = this.findIndex(src);
		this.gradeList[idx] = dest;
	}
	
	public void update(int index, Grade grade) {
		if(_validIndex(index)) {
			this.gradeList[index] = grade;
		}
	}
	
	private boolean _validIndex(int index) {
		return (index >= 0 && index < this.length());
	}
}
