package campus;


import java.util.*;
import multi.A;
// import package.* => 모든 클래스 호출
// import package.class => 특정 클래스 호출
/*java.lang 패키지는 필수로 클래스에 기본적으로 포함되어 있다
  현재 클래스와 같은 패키지에 존재하는 클래스도 마찬가지
 * */

public class B {

	public static void main(String[] args) {
		Date now = new Date();
		// 현재 날짜와 시간 타입
		System.out.println(now);
		Vector v = new Vector();
		// 배열 타입
		A a1 = new A ("me");
		

	}

}
