package kapitel_2;

public class StudentVariable {

	public static void main(String[] args) {
		// 학생 정보 표현하기
		// 학번, 이름, 전화번호, 이메일, 성적, 총 이수학점
		// 상태 : 재학중(true) or 졸업(false)
		// A?B:C 조건 삼항 연산 => A가 참이면 B, 거짓이면 C를 출력한다
		
		String id = "09111222";
		String name = "이학생";
		String phone = "010-2222-4444";
		String email = "email@multi.com";
		double score = 4.5;
		int total = 145;
		boolean state = true;
			String result = state ? "재학중" : "졸업";
			System.out.println(result);
		System.out.println("학번 = " + id
				+ "\n이름 =" + name
				+ "\n폰번호 =" + phone
				+ "\n이메일 =" + email
				+ "\n성적 =" + score
				+ "\n총 이수학점 = " + total
				+ "\n재학상태 = " + result);
		
		System.out.println("\n=============\n");

		System.out.println(100 + 200); // 300
		System.out.println(100 + "200"); // 100200
		// 더하기 연산자 좌우의 값 중 하나라도 String이라면 둘다 String으로 인식
		// 고로 문자열 둘을 결합하는 결과가 출력		
		
		System.out.println("\n=============\n");
		
		int kor = 98;
		int eng = 99;
		int mat = 66;
		int sum = kor + eng + mat;
		// java : 정수 연산 결과는 정수다
		// sql, javascript, r, python : 결과 무조건 실수
		int avg = sum / 3;
		System.out.println("총합 = " + sum
				+"\n정수평균 = " + avg); 
		//평균값이 실수범위로 나오게 하려면
		//나누는 두 수 중에서 하나를 double형으로 변환
		double avgD = sum / (double)3;
		System.out.println("실수평균 = " + avgD );
	
	
		
	}

}
