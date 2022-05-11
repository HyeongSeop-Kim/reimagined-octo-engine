package model.vo;

import exception.GradeLevelException;
import exception.GradeScoreException;

public class Grade extends Subject {
	private double score;
	private char level;
	
	public Grade(String name) {
		super(name);
		this.level = 'F';
	}
	
	public Grade(String name, double score) {
		super(name);
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) throws GradeScoreException {
		if(!(score >=0 && score <= 100)) {
			throw new GradeScoreException("점수의 범위는 0 ~ 100 사이로 입력해야합니다.");
		}
		this.score = score;
		
		if(this.score <= 100 && this.score >= 90) {
			setLevel('A');
		} else if(this.score < 90 && this.score >= 80) {
			setLevel('B');
		} else if(this.score < 80 &&this.score >= 70) {
			setLevel('C');
		} else if(this.score < 70 &&this.score >= 60) {
			setLevel('D');
		} else if(this.score < 60 &&this.score >= 40) {
			setLevel('E');
		} else if(this.score > 0 && this.score <40) {
			setLevel('F');
		}
	}

	public char getLevel() {
		return level;
	}

	public void setLevel(char level) {
		if(!(level >= 'A' && level <= 'F')) {
			throw new GradeLevelException("등급은 A ~ F 안에서 설정해야합니다.");
		}
		this.level = level;
	}
	
	
}
