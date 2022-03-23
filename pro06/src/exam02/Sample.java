package exam02;

public class Sample {

	public static void main(String[] args) {
		ReportGrade rg = new ReportGrade("홍길동");
		String subjects[] = new String[] {"국어", "영어", "수학"};
		
		rg._setSubjects(subjects);
		System.out.println(rg.getName());
		rg._setGrade("국어", 90);
		rg._setGrade("수학", 20.2);
		rg._setGrade("영어", 100);
		rg.add("사회", 72.4);
		rg.remove("수학");
		rg.remove("과학");
		rg.remove(0);
		rg.remove(5);
		
		String[] s = rg.getSubjects();
		double[] g = rg.getGrades();		
		
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i] + " : " + g[i] + "점");
		}
		
		System.out.println(rg.getGrade("영어"));
	}

}
