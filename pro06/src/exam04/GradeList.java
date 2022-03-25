package exam04;

import java.util.Arrays;

public class GradeList {
	private Grade gradeList[];
	
	public GradeList() {}
	
	public double getScore(int index) {
		if(_validIndex(index)) {
			double score = gradeList[index].getGrade();
			return score;
		}
		return 0;
		
	}
	
	public double total() {
		double total = 0;
		for(int i = 0; i < this.length(); i++) {
			total += this.getScore(i);
		}
		
		return total;
	}
	
	public double avg() {
		double avg = total() / this.length();		
		return avg;
	}
	
	public String[] getUnder() {
		String underScore[] = new String[0];
		
		for(int i = 0; i < this.length(); i++) {
			if(getScore(i) < 40) {
				underScore = Arrays.copyOf(underScore, underScore.length + 1);
				underScore[underScore.length - 1] = this.gradeList[i].getSubject();
			}
		}
		
		return underScore;
	}
	
	public String[] getUnder(double score) {
		String underScore[] = new String[0];
		
		for(int i = 0; i < this.length(); i++) {
			if(getScore(i) < score) {
				underScore = Arrays.copyOf(underScore, underScore.length + 1);
				underScore[underScore.length - 1] = this.gradeList[i].getSubject();
			}
		}
		
		return underScore;
	}
	
	public String getTop() {
		String topSubject = new String();
		topSubject = this.gradeList[0].getSubject();
		double topScore = getScore(0);
		for(int i = 1; i < this.length(); i++) {
			if(topScore < getScore(i)) {
				topScore = getScore(i);
				topSubject = this.gradeList[i].getSubject();
			}	
		}
		return topSubject;
	}
	
	public String[] getTop(int count) {
		Grade[] high = new Grade[count];
		
		for(int i = 0; i < high.length; i++) {
			high[i] = this.gradeList[i];
			for(int j = 0; j < this.length(); j++ ) {
				if(i >= 1) {
					if(high[i - 1].getGrade() > this.gradeList[j].getGrade() && high[i].getGrade() < this.gradeList[j].getGrade()) {
						high[i] = this.gradeList[j];
					} else {
						if(high[i].getGrade() < this.gradeList[j].getGrade()) {
							high[i] = this.gradeList[i];
						}
					}
				}
			}
		}
		
		String[] result = new String[count];
		for(int i = 0; i < high.length; i++) {
			result[i] = high[i].getSubject();
		}
		
		return result;
	}
	
	public String getBottom() {
		return null;
	}
	
	public String getBottom(int count) {
		return null;
	}
	
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
	
	public void sort() {
		for(int i = 0; i < length() - 1; i++) {
			for(int j = i + 1; j < length(); j++) {
				if(this.gradeList[i].getGrade() > this.gradeList[j].getGrade()) {
					Grade temp = this.gradeList[j];
					this.gradeList[j] = this.gradeList[i];
					this.gradeList[i] = temp;
				}
			}
		}
	}
	
	public void sort(boolean descending) {
		if(descending) {
			for(int i = 0; i < length() - 1; i++) {
				for(int j = i + 1; j < length(); j++) {
					if(this.gradeList[i].getGrade() < this.gradeList[j].getGrade()) {
						Grade temp = this.gradeList[j];
						this.gradeList[j] = this.gradeList[i];
						this.gradeList[i] = temp;
					}
				}
			}
		} else {
			sort();
		}
		
	}
	
	private boolean _validIndex(int index) {
		return (index >= 0 && index < this.length());
	}
	
//private Grade[] gList;
//	
//	public GradeList() {
//		this.gList = new Grade[0];
//	}
//	
//	// 추가
//	public void add(Grade grade) {
//		this.gList = Arrays.copyOf(this.gList, length() + 1);
//		this.gList[length() - 1] = grade;
//	}
//	
//	public void add(String name) {
//		Grade g = new Grade(name);
//		this.add(g);
//	}
//	
//	public void add(String name, double score) {
//		Grade g = new Grade(name, score);
//		this.add(g);
//	}
//	
//	// 수정
//	//     - 수정 할 과목을 찾아서 과목명을 수정 -> 변경전 과목명, 변경후 과목명
//	//     - 수정 할 과목을 찾아서 점수를 수정 -> 찾을 과목명, 수정할 점수
//	//     - 수정 할 과목을 찾아서 과목과 점수를 수정 -> 변경전 과목명, 변경후 과목명, 수정할 점수
//	//     - 수정 할 데이터가 저장되어 있는 인덱스를 지정하여 과목명을 수정
//	//     - 수정 할 데이터가 저장되어 있는 인덱스를 지정하여 점수를 수정
//	//     - 수정 할 데이터가 저장되어 있는 인덱스를 지정하여 과목명과 점수를 수정
//	public void update(String src, String dest) {
//		int idx = this.findIndex(src);
//		if(idx >= 0) {
//			this.gList[idx].setName(dest);
//		}
//	}
//	
//	public void update(String src, double score) {
//		int idx = this.findIndex(src);
//		if(idx >= 0) {
//			this.gList[idx].setScore(score);
//		}
//	}
//	
//	public void update(String src, String dest, double score) {
//		int idx = this.findIndex(src);
//		if(idx >= 0) {
//			this.gList[idx].setName(dest);
//			this.gList[idx].setScore(score);
//		}
//	}
//	
//	public void update(String src, Grade dest) {
//		int idx = this.findIndex(src);
//		if(idx >= 0) {
//			this.gList[idx] = dest;
//		}
//	}
//	
//	public void update(int index, String name) {
//		if(_validIndex(index)) {
//			this.gList[index].setName(name);
//		}
//	}
//	
//	public void update(int index, double score) {
//		if(_validIndex(index)) {
//			this.gList[index].setScore(score);
//		}
//	}
//	
//	public void update(int index, String name, double score) {
//		if(_validIndex(index)) {
//			this.gList[index].setName(name);
//			this.gList[index].setScore(score);
//		}
//	}
//	
//	public void update(int index, Grade grade) {
//		if(_validIndex(index)) {
//			this.gList[index] = grade;
//		}
//	}
//	
//	// 삭제
//	public void remove(String name) {
//		int index = findIndex(name);
//		if(index >= 0) {
//			_remove(index);
//		}
//	}
//	
//	public void remove(int index) {
//		if(_validIndex(index)) {
//			_remove(index);
//		}
//	}
//	
//	private void _remove(int index) {
//		int idx = 0;
//		Grade[] temp = new Grade[length() - 1];
//		for(int i = 0; i < length(); i++) {
//			if(i != index) {
//				temp[idx++] = this.gList[i];
//			}
//		}
//		this.gList = temp;
//	}
//	
//	// 조회
//	//     - 과목명으로 점수 조회
//	//     - 인덱스로 과목명 조회
//	//     - 인덱스로 과목명, 점수 조회
//	public double getScore(String name) {
//		int idx = findIndex(name);
//		if(idx >= 0) {
//			return this.gList[idx].getScore();
//		}
//		return 0;
//	}
//	
//	public String getName(int index) {
//		if(_validIndex(index)) {
//			return this.gList[index].getName();
//		}
//		return null;
//	}
//	
//	public Grade getGrade(int index) {
//		if(_validIndex(index)) {
//			Grade data = new Grade(this.gList[index].getName(), this.gList[index].getScore());
//			return data;
//		}
//		return null;
//	}
//	
//	public int findIndex(String name) {
//		for(int i = 0; i < length(); i++) {
//			Grade data = this.gList[i];
//			if(data.getName().equals(name)) {
//				return i;
//			}
//		}
//		return -1;
//	}
//	
//	public int length() {
//		return this.gList.length;
//	}
//	
//	// 유효한 범위의 인덱스 인지 확인하는 메서드
//	private boolean _validIndex(int index) {
//		return (index >= 0 && index < length());
//	}
}
