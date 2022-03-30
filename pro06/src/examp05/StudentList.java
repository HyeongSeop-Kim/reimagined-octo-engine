package examp05;

import java.util.Arrays;

public class StudentList {
	private Student[] sList;
	
	public StudentList() {}
	
	public StudentList(Student[] sList) {
		this.sList = sList;
	}
	
	// 학생 정보를 추가하는 기능
	public void add(String name, int age, int grade, int group) {
		Student student = new Student(name, age, grade, group);
		sList = Arrays.copyOf(sList, length() + 1);
		sList[length() - 1] = student;
	}
	
	// 학생 정보를 수정하는 기능
	public void update(String name, int grade, int group) {
		int idx = _findIndex(name);
		sList[idx].setGrade(grade);
		sList[idx].setGroup(group);
	}
	
	// 학생 정보를 삭제 하는 기능
	public void remove(String name) {
		int idx = _findIndex(name);
		Student temp[] = new Student[length() - 1];
		int cnt = 0;
		
		for(int i = 0; i < length(); i++) {
			if(i != idx) {
				temp[cnt++] = sList[i];
			}
		}
		
		sList = temp;
	}
	
	public void removeGrade(int grade) {
		Student temp[] = new Student[0];
		int cnt = 0;
		
		for(int i = 0; i < length(); i++) {
			if(sList[i].getGrade() != grade) {
				temp = Arrays.copyOf(temp, temp.length + 1);
				temp[cnt++] = sList[i];
			}
		}
		
		sList = temp;
	}
	
	// 학생 이름으로 학년, 반 정보 제공하는 기능
	public int findGrade(String name) {
		int idx = _findIndex(name);
		
		return sList[idx].getGrade();
	}
	
	public int findGroup(String name) {
		int idx = _findIndex(name);
		
		return sList[idx].getGroup();
	}
	
	// 학년 정보로 모든 학생의 이름을 제공하는 기능
	public String[] findStudents(int grade) {
		String result[] = new String[0];
		
		int cnt = 0;
		
		for(int i = 0; i < length(); i++) {
			if(sList[i].getGrade() == grade) {
				result = Arrays.copyOf(result, result.length + 1);
				result[cnt++] = sList[i].getName();
			}
		}
		
		return result;
	}
	
	// 학년, 반 정보로 모든 학생의 이름을 제공하는 기능
	public String[] findStudents(int grade, int group) {
		String result[] = new String[0];
		
		int cnt = 0;
		
		for(int i = 0; i < length(); i++) {
			if(sList[i].getGrade() == grade && sList[i].getGroup() == group) {
				result = Arrays.copyOf(result, result.length + 1);
				result[cnt++] = sList[i].getName();
			}
		}
		
		return result;
	}
	
	public int length() {
		return sList.length;
	}
	
	// 이름으로 해당 학생이 저장된 인덱스 번호를 찾는 메서드
	private int _findIndex(String name) {
		int idx = -1;
		
		for(int i = 0; i < length(); i++) {
			if(this.sList[i].getName().equals(name)) {
				idx = i;
			}
		}
		
		return idx;
	}
	
	public String getName(int idx) {
		return this.sList[idx].getName();
	}
	
	public int getGrade(int idx) {
		return this.sList[idx].getGrade();
	}
	
	public int getGroup(int idx) {
		return this.sList[idx].getGroup();
	}
}
