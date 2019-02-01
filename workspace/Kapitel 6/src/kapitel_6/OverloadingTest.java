package kapitel_6;

class B{
	int add(int i, int j) {
		return i + j;
	}
	// 정수 덧셈 
	String add(String i, String j) {
		return i + j;
	}
	// 문자열 결합
	double add(double i, double j) {
		return i + j;
	}
	// 실수 덧셈
// => 메소드의 이름이 같아도 기능이 다르다
// => 세 가지 메소드가 오버로딩 돼있다
// => 동일한 기능을 다양한 매개변수에 적용하는 것이 가능

}


public class OverloadingTest {

	public static void main(String[] args) {
		B b1 = new B();
		double r1 = b1.add(1.1, 2.2);
		String r2 = b1.add("java", "jsp");
		int r3 = b1.add(1, 2);
		double r4 = b1.add(100, 200.22);
		System.out.println(r1+"\n"+r2+"\n"+r3+"\n"+r4);
	// 매개변수가 일치하는 것으로 자동으로 매칭된다
	// 이떄 double과 int를 입력하면 double로 자동 형변환된다
	
// 라이브러리 api 오버로딩의 예시
		int dec = Integer.parseInt("111");
		System.out.println(dec);
		// "100"을 2진수로 쓰기
		int bin = Integer.parseInt("111", 2);
		System.out.println(bin);

	}
}
