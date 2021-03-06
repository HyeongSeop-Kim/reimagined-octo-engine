package exam04;

public class Main {

	public static void main(String[] args) {
		Grade g1 = new Grade("국어", 81.3);
		Grade g2 = new Grade("영어", 75.1);
		Grade g3 = new Grade("수학", 94.7);
		
		Grade[] gArr = new Grade[3];
		
		gArr[0] = g1;
		gArr[1] = g2;
		gArr[2] = g3;
		
		GradeList gList = new GradeList(gArr);
		
		gList.add(new Grade("사회", 77.7));
		gList.remove("영어");
		gList.changeSubject("사회", "과학");
		gList.changeGrade("수학", 100);
		gList.add(new Grade("사회", 10));
		gList.add(new Grade("일본어", 20));
		
		System.out.println(gList.get(gList.findIndex("국어")).getGrade());
		System.out.println(gList.findIndex("영어"));
		System.out.println(gList.get(gList.findIndex("수학")).getGrade());
		System.out.println(gList.findIndex("사회"));
		System.out.println(gList.get(gList.findIndex("과학")).getGrade());
		
		System.out.println("총합 : " + gList.total());
		System.out.println("평균 : " + gList.avg());
		
		System.out.println("40점 미만 과목 : " + gList.getUnder()[0]);
		System.out.println("40점 미만 과목 : " + gList.getUnder()[1]);
		
		System.out.println("20점 미만 과목 : " + gList.getUnder(20)[0]);
		
		System.out.println("최고 득점 과목 : " + gList.getTop());
		
		String[] topScore = new String[3];
		topScore = gList.getTop(3);
		System.out.println("최고 득점 과목 : " + topScore[0]);
		System.out.println("2번째 최고 득점 과목 : " + topScore[1]);
		System.out.println("3번째 최고 득점 과목 : " + topScore[2]);
	}

}
