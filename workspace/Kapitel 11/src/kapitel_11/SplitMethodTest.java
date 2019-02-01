package kapitel_11;

import java.util.StringTokenizer;

public class SplitMethodTest {

	public static void main(String[] args) {
		String address =
				"서울시:-강남구:- 역삼동:- 멀티캠퍼스: 10층-1003호";
		// 1) String 클래스의 split 메소드 사용하기
		String tokens [] = address.split(":-");
		System.out.println("분리된 토큰의 갯수 = " + tokens.length);
		for(int i=0; i<tokens.length; i++) {
			System.out.println(tokens[i]);
		}
		System.out.println("=============================");
		// 2) StringTokenizer 객체 사용하기 (생성자 + 메소드)
		StringTokenizer st = new StringTokenizer(address, ":-");
		// StringTokenizer에서 구분하는 문자는 'or'연산자로 인식이 된다
		// 즉, 분리기호가 여러개일 때 각각에 대해서 모두 분리시킨다
		while (st.hasMoreTokens()) { // st로 분리가 된 다음 토큰이 존재하는가?
			String token = st.nextToken(); // 토큰 읽어오기
			System.out.println(token);
		}
		
		
		
		
		
	}

}
