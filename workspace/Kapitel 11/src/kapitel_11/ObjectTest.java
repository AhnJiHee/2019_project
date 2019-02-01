package kapitel_11;

public class ObjectTest {

	public static void main(String[] args) {
		MyObject o1 = new MyObject("청년취업");
		MyObject o2 = new MyObject("아카데미");
		MyObject o3 = new MyObject("아카데미");

		// getClass.getName() ; + 'a' + Integer.toHexString(i);
		// 다른 클래스 출력 내용 바꾸기 = toString만 override
		
		System.out.println(o1);//"청년취업" 출력
		System.out.println(o2);//"
		
		if (o1==o2) {
			System.out.println("o1 == o2 비교 같다");
		}
		if (o1.equals(o2)) {
			System.out.println("o1.equals(o2) 비교 같다");
		}
		if (o2.equals(o3)) {
			System.out.println("o2.equals(o3) 비교 같다");
		}
		if (o2.equals(new String("아카데미"))) {
			System.out.println("o2.equals(문자열) 비교 같다");
		}

// 변수의 동등성 비교하기
// 1. == 연산자 : 기본 + 참조 => override 불가능(주소값 비교)
// 2. Object equals() 메소드 : 참조 => override 가능

	}

}//ObjectTest

class MyObject /*extends Object*/{
	String msg;
	MyObject(String msg){
		this.msg=msg;
	}
	
	public String toString() {
		return msg;
	}

	public boolean equals(Object obj) {
		if (obj instanceof MyObject) {
			boolean result = 
					msg.equals( ((MyObject)obj).msg );
			return result;
		}
		else {
			return false;
		}
	}
	// 1> MyObject 타입 객체 전달
	//     => Object 타입의 obj는 상위클래스 객체이므로 MyObject로 명시적 형변환
	// 2> msg변수 내용 같은지 비교
	//		=> boolean에 기존에 생성된 msg(좌변)가 MyObject에 전달된 msg(우변)와 같은지 비교
	// 3> 1,2번 모두 만족해야 true
	
	// 이 안에는 toString(), equals() 도 모두 상속되어있다.
	// source - override/implements methods 이용
}











