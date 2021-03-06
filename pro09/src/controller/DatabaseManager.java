package controller;

import java.util.Arrays;

import exception.GradeScoreException;
import model.vo.Grade;
import model.vo.Student;


public class DatabaseManager implements ImplDatabaseManager {

	private Student[] datas;
	
	//초기화 블롱
	{
		datas = new Student[5];
		datas[0] = new Student("홍길동");		datas[1] = new Student("김도원");
		datas[2] = new Student("박수아");		datas[3] = new Student("최종희");
		datas[4] = new Student("이정우");
		
		for(int i = 0; i < datas.length; i++) {
			datas[i].setGrades(new Grade[] {
					new Grade("국어"), new Grade("영어"), new Grade("수학"), new Grade("과학")
			});
		}
	}
	
	@Override
	public Grade[] search(String name) {
		int index = _findIndex(name);
		if(index == -1) {
			return null;
		}
		return datas[index].getGrades();
	}

	@Override
	public boolean add(String name) {
		int index = _findIndex(name);
		if(index == -1) {
			datas = Arrays.copyOf(datas, length() + 1);
			datas[length() - 1] = new Student(name);
			datas[length() - 1].setGrades(new Grade[] {
					new Grade("국어"), new Grade("영어"), new Grade("수학"), new Grade("과학")
			});
			return true;
		}
		return false;
	}

	@Override
	public Student modify(String name, String subject, int score) {
		int index = _findIndex(name);
		
		if(index != -1) {
			Grade[] grades = datas[index].getGrades();
			for(int i = 0; i < grades.length; i++) {
				if(subject.equals(grades[i].getName())) {
					grades[i].setScore(score);
					break;
				}
			}
			return datas[index];
		}
		return null;
	}

	@Override
	public boolean remove(String name) {
		int index = _findIndex(name);
		
		if(index != -1) {
			Student[] temp = new Student[length() - 1];
			System.arraycopy(datas, 0, temp, 0, index);
			System.arraycopy(datas, index + 1, temp, index, datas.length - (index + 1));
			datas = temp;
			return true;
		}
		return false;
	}
	
	private int _findIndex(String name) {
		int index = -1;
		
		for(int i = 0; i < length() ; i++) {
			if(datas[i].getName().equals(name)) {
				index = i;
			}
		}
		
		return index;
	}
	
	public boolean isExisted(String name) {
		boolean result = false;
		if(_findIndex(name) != -1) {
			result = true;
		}
		return result;
	}
	
	public int length() {
		return this.datas.length;
	}

	@Override
	public Student getStudent(String name) {
		int index = _findIndex(name);
		if(index != -1) {
			return datas[index];
		}
		return null;
	}
	
	@Override
	public Student login(String username, String password) {
		for(int i = 0; i < datas.length; i++) {
			if(username.equals(datas[i].getName()) && password.equals(datas[i].getPassword())) {
				return datas[i];
			}
		}
		return null;
	}

}
