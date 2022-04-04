package exam01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Sample07 {
		public void ex01() {
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");
			String strDate = sFormat.format(new Date());
			System.out.println(strDate);
			
			sFormat.applyPattern("a hh시 mm분 E요일");
			strDate = sFormat.format(new Date());
			System.out.println(strDate);
		}
		
		public void ex02() {
			// 주민등록번호로 생일 출력
			Scanner sc = new Scanner(System.in);
			GregorianCalendar g = new GregorianCalendar();
			
			String input="";
			while(true) {
				System.out.printf("주민등록번호 앞 6자리를 입력해주세요 : ");
				input = sc.nextLine();
				if(input.matches("\\d{6}")) {
					break;
				}
				System.out.println("주민등록번호 앞자리 6자만 입력하세요.");
			}
			
			
			SimpleDateFormat sFormat = new SimpleDateFormat("yyMMdd");
			try {
				Date birthday = sFormat.parse(input);
				System.out.println(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void ex03() {
			Scanner sc = new Scanner(System.in);
			GregorianCalendar g = new GregorianCalendar();
			
			System.out.printf("일자 : ");
			int dday = sc.nextInt();
			
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			g.add(Calendar.DATE, dday);
			String strDate = sFormat.format(g.getTime());
			if(dday >= 0) {
				System.out.println("현재 날짜에서 " + dday + "일 후 날짜는 " + strDate + " 입니다.");
			} else {
				System.out.println("현재 날짜에서 " + dday + "일 전 날짜는 " + strDate + " 입니다.");
			}
		}
		
		public void ex04() {
			GregorianCalendar now = new GregorianCalendar();
			GregorianCalendar birthday = new GregorianCalendar();
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy.MM.dd");
			Scanner sc = new Scanner(System.in);
			
			String input = "";
			while(true) {
				System.out.print("자신의 생일을 \"월.일\" 형식으로 입력하세요 : ");
				input = sc.nextLine();
				
				if(input.matches("\\d{1,2}\\.\\d{1,2}")) {
					break;
				}
				System.out.println("입력 형식을 다시 확인하세요.");
			}
			
			try {
				birthday.setTime(sFormat.parse(now.get(Calendar.YEAR) + "." + input));
				System.out.println(birthday.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(now.before(birthday)) {
				
			} else {
				System.out.println("이미 생일이 지났습니다.");
			}
			
			
		}
		
		public void ex05() {
			Date start = new Date();
			
			int tot = 0;
			for(long i = 1; i <= 10000000000L
					; i++) {
				tot += i;
			}
			
			Date end = new Date();
			long time = end.getTime() - start.getTime();
			System.out.println("실행 시간 : " + time / 1000.0 + " 초");
		}

		
	public void ex06() {
		GregorianCalendar gc = new GregorianCalendar();
		int[] leapYear = new int[0];
		for(int year = 2020; year < 2100; year++) {
			if(gc.isLeapYear(year)) {
				leapYear = Arrays.copyOf(leapYear, leapYear.length + 1);
				leapYear[leapYear.length - 1] = year;
			}
		}
		System.out.println(Arrays.toString(leapYear));
	}
	
	public void ex07() {
		Date[] dArr = new Date[0];
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd E요일");
		gc.set(2022, 3, 1);
		
		for(int i = gc.get(Calendar.DATE); i <= gc.getActualMaximum(Calendar.DATE); i++) {
			gc.set(2022, 3, i);
			switch(gc.get(Calendar.DAY_OF_WEEK)) {
				case Calendar.SATURDAY:	case Calendar.SUNDAY:
					dArr = Arrays.copyOf(dArr, dArr.length + 1);
					dArr[dArr.length - 1] = gc.getTime();
			}
		}
		
		for(int i = 0; i < dArr.length; i++) {
			System.out.println(sFormat.format(dArr[i]));
		}
	}
	
	public void ex08() { 
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		GregorianCalendar upload = new GregorianCalendar(2021, 3 - 1, 20, 14, 40, 30);
		Date now = new Date();
		
		System.out.println("업로드 시간 : " + sFormat.format(upload.getTime()));
		System.out.println("현재시간 시간 : " + sFormat.format(now));
		
		int beforeTime = (int)((now.getTime() - upload.getTime().getTime()) / 1000);
		
		if(beforeTime <= 60) {
			System.out.println(beforeTime + " 초 전");
		} else if(beforeTime <= 60 * 60) {
			System.out.println(beforeTime / 60 + " 분 전");
		} else if(beforeTime <= 60 * 60 * 24) {
			System.out.println(beforeTime / (60 * 60) + " 시간 전");
		} else if(beforeTime <= 60 * 60 * 24 * 7) {
			System.out.println(beforeTime / (60 * 60 * 24) + " 일 전");
		} else if(beforeTime <= 60 * 60 * 24 * 7 * 4) {
			System.out.println(beforeTime / (60 * 60 * 24 * 7) + " 주 전");
		} else if(beforeTime <= 60 * 60 * 24 * 7 * 4 * 12) {
			System.out.println(beforeTime / (60 * 60 * 24 * 7 * 4) + " 개월 전");
		} else {
			System.out.println(beforeTime / (60 * 60 * 24 * 7 * 4 * 12) + " 년 전");
		}
		
		System.out.println(sFormat.format(upload.getTime()));
	}
	
	public void ex09() { 
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar upload = new GregorianCalendar(2022, 5 - 1, 20);
		Date now = new Date();
		
		System.out.println("입력한 날짜 : " + sFormat.format(upload.getTime()));
		System.out.println("현재시간 날짜 : " + sFormat.format(now));
		
		int dDayTime = (int)((now.getTime() - upload.getTime().getTime()) / 1000);
		
		if(dDayTime < 0) {
			System.out.println("D-Day 까지 " + -dDayTime / (60 * 60 * 24) + "일 남음");
		} else if(dDayTime > 0) {
			System.out.println("D-Day 부터 " + dDayTime / (60 * 60 * 24) + "일 지남");
		} else {
			System.out.println("D-Day");
		}
		
		System.out.println(sFormat.format(upload.getTime()));
	}
	
	public static void main(String[] args) {
		Sample07 sample = new Sample07();
		
//		sample.ex01();
//		sample.ex02();
//		sample.ex03();
//		sample.ex04();
//		sample.ex05();
//		sample.ex06();
//		sample.ex07();
//		sample.ex08();
		sample.ex09();
		
		
		
		
		// 2020년 부터 2099 까지의 년도 중 윤년에 해당하는 년도를 정수 배열에 담아 출력
//		int[] leapYear = new int[0];
//		int startYear = Calendar.YEAR - 2;
//		int idx = 0;
//		
//		System.out.println(startYear);
//		for(int i = startYear; i<2100; i++) {
//			if(g.isLeapYear(i)) {
//				int[] temp = Arrays.copyOf(leapYear, leapYear.length + 1);
//				temp[idx++]= i;
//				leapYear = temp;
//			}
//		}
//		
//		System.out.println(Arrays.toString(leapYear));
		
		
		

	}

}
