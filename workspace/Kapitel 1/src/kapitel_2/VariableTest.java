package kapitel_2;

public class VariableTest {

	public static void main(String[] args) {
		int i = 100;
		double pi = 3.14;
		boolean b1 = true;
		char c1 = 'a';
		i = 200;
		System.out.println("i변수=" + i); // i변수 = 100
		b1 = i > pi;
		System.out.println("b1=" + b1); // b1 = true
		System.out.println("c1=" + c1); // c1 = a
		c1 = '가';
		System.out.println("c1=" + c1); // c1 = 가
		c1 = '\n';
		System.out.println("c1=" + c1); // c1 = 공백
		b1 = i > c1;
		System.out.println("b1=" + b1); /* 200과 '\n'의 대소비교?
		컴퓨터에게 char 'a'는 97이라는 숫자로 기억된다
		'A'는 65, '0'은 48, '\n'에도 할당된 숫자가 있는데, 이것이 200보다 작다*/
		char c2 = 'a'; // 97
		char c3 = 'A'; // 65 
		boolean b2 = c2 > c3;
		System.out.println(b2);
		/* 이를 활용하면 숫자-영대문자-영소문자-한글
		 * 문자들을 사전에 나열된 순서로 나타낼 수 있다.
		 */
		
		
	}
	
}
