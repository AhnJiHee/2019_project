package kapitel_11;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

//		1> Date 클래스
		
//		Date now = new Date();
//		// Date 클래스는 toString을 override해서 다른 결과를 출력하고 있다
//		// Mon Jan 07 13:22:32 KST 2019
//		System.out.println(now);
//		
//		Date d2 = new Date(999999999999999999L);
//		// 사용 지양 메소드 ... 구현 상의 문제, 사용 시의 문제점, 이름, 매개변수 등
//		// 여러 문제가 있으므로 사용을 자제하라는 표현(deprecated)
//		// Long type 입력 ... 1970.1.1.0.0.0.에서부터 현재까지 흐른 시간을 1/1000초 단위로
//		System.out.println(d2);
		
		
//		2> Calendar 클래스
		
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
		// 정보가 너무 방대하므로 필요한 데이터만 추출해야 한다
		// 년도, 월, 일, 시, 분, 초 추출 메소드 이용
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY) ;
		int minute = cal.get(Calendar.MINUTE) ;
		int second = cal.get(Calendar.SECOND) ;
		
		System.out.println(
				"현재 시각은 " + 	year + "년도 " + month + "월 "
				+ day + "일 " + hour + "시 "	+ minute + "분 "
				+ second + "초 입니다.");
		
		// 현재 날짜로부터 100일 후를 구하고 싶다면?
		// cal.get((Calendar.DAY_OF_YEAR) + 100);
		System.out.println(year);
		
//		3> SimpleDateFormat 클래스
		
		SimpleDateFormat sdf = 
				new SimpleDateFormat(" yyyy / MM / dd / hh:mm:ss ");
		// dd는 해당 달 중, DDD는 해당 연도 중 며칠
		// hh는 12시간 형태, HH는 24시간 형태
		System.out.println(sdf.format(new Date()));
		// 혹은
		String datestr = sdf.format(cal.getTime());
		System.out.println(datestr);
		
		double d = 500*Math.PI ;
		System.out.println(d);
		//
		DecimalFormat df = new DecimalFormat("#,###.00");
		// #대신 0을 주면 올림한 결과가 0일 때 이 0을 표현해준다
		String sd = df.format(d);
		System.out.println(sd);
		
		// Collection Framework
		// **List, **Map, **Set
		// List는 순서를 가지고 있는 목록
		
		

	}

}
