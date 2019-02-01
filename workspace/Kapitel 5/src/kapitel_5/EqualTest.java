package kapitel_5;

public class EqualTest {

	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		double d = 10.0;
		
		// 참조 타입의 변수 : "new" 키워드 사용하여 데이터를 저장
		// String은 new를 사용할 수도 있고, 없이 사용하는 것도 가능
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		String s4 = new String("JaVa");
		
		System.out.println(i == j);
		System.out.println(i == d);
		// 형변환은 기본 타입끼리만 가능
		// String은 참조 타입이므로 형변환이 불가능하다
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		// 위 두 문장의 결과가 다른 이유
		// 아래의 경우 주소값이 새롭게 배정되기 때문
		// 즉, 컴퓨터가 인식을 하는 것은 실제값이 아니라 주소값이다.
		// == 는 두 문자열의 주소값을 비교하는 기본 연산자
		// 만약 주소값이 아니라 실제값을 비교하고 싶다면 메소드로 구현
		// 혹시 라이브러리에 기능이 구현되어있는지 확인
		// String 클래스 / equals() 메소드 를 사용하자
		// A.equals(B)의 형태로 적용
		System.out.println(s1.equals(s2));
		System.out.println(s3.equals(s4));
		// A.eqaulsIgnoreCase(B)는 대소문자 무시하고 비교
		System.out.println(s3.equalsIgnoreCase(s4));
		// not연산은 메소드 앞에 적용
		System.out.println(! s3.equalsIgnoreCase(s4));
		
		String s = null;
		System.out.println(s.equals(s1));
		//NullPointerException ... 가리키고 있는 실제값이 없는데 비교를 어떻게 하니
		//null : 변수는 선언하되, 문자열은 지정하지 않는다
		
		/*stack						heap
		 * s : xx						
		 * s4 : 400					400 : java
		 * s3 : 300					300 : java
		 * s2 : 100					
		 * s1 : 100					100 : java */ 
		
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		
		/*stack						heap
		 * s : xx						
		 * s4 : xx					
		 * s3 : xx				garbage collector
		 * s2 : xx				가 지우도록 허가하는 것
		 * s1 : xx					 			*/

		// 그런데 s1만 null인 상황이라면, s2가 여전히 100번지를 점유중이므로
		// gc가 이를 지울 수 없다.
		
		
	}

}
