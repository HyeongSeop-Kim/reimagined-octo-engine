package exam01;

public class Grade {
	private String name;
	private double score;
	private char rank;
	
	public Grade() {}
	public Grade(String name) {
		setName(name);
	}
	public Grade(String name, double score) {
		setName(name);
		setScore(score);
	}
	
	
	private void _setRank(double score) {
		if(score >=90) {
			rank='A';
		} else if(score >= 80) {
			rank='B';
		} else if(score >= 70) {
			rank='C';
		} else if(score >= 60) {
			rank='D';
		} else if(score >= 50) {
			rank='E';
		} else {
			rank='F';
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(double score) {
		this.score = score;
		_setRank(score);
	}
	public String getName() {
		return name;
	}
	public double getScore() {
		return score;
	}
	public char getRank() {
		return rank;
	}
}
