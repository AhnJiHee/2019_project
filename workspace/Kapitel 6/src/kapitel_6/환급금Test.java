package kapitel_6;

class student {
	// 필드변수 선언
	String 이름 ;
	String 소속 ;
	String 과정명 ;
	int 교육비 ;
	int 부가금 ;
	int 환급금 ;
	// 사용자 생성자
	student (String 이름, String 소속, String 과정명, int 교육비, int 부가금) {
		this.이름 = 이름;
		this.소속 = 소속;
		this.과정명 = 과정명;
		this.교육비 = 교육비;
		this.부가금 = 부가금;
	}
	int calc () {
		if ((과정명).equals("자바프로그래밍")) {환급금 = (int)(교육비 *0.25) + 부가금;}
		else if ((과정명).equals("JDBC프로그래밍")) {환급금 = (int)(교육비 *0.2) + 부가금;}
		else if ((과정명).equals("JSP프로그래밍")) {환급금 = (int)(교육비 *0.15) + 부가금;}
		else {System.out.println("잘못 입력되었습니다.");
		return 0;
		}
		return 환급금;
	}
}


public class 환급금Test {

	public static void main(String[] args) {
		// 명령형 매개변수 이용 2-1
		// Run-Run Configurations
		
		// 객체 생성 2-2
		student stu = new student(args[0], args[1], args[2].toUpperCase(),
				Integer.parseInt(args[3]), Integer.parseInt(args[4]));
		
		// 환급금 계산 2-3
		int result = stu.calc();
		if (result ==0) {
			return;
		}
		// else문 안에 return을 넣어두면 다음 실행문으로 넘어가지 않는다.
//		if ((stu.과정명).equals("자바프로그래밍") || (stu.과정명).equals("JDBC프로그래밍") 
//				|| (stu.과정명).equals("JSP프로그래밍")) {
		System.out.println("이름 "+stu.이름+"\n소속 "
				+stu.소속+"\n과정명 "+stu.과정명+"\n교육비 "
				+stu.교육비+"\n부가금 "+stu.부가금+"\n환급금 "+ result);		
//		}

	}

}
