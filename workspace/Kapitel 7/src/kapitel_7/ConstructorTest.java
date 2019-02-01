package kapitel_7;

class C1 /*extends Object*/ {
	int i ;
	C1 (String s){
		/* super();*/
		System.out.println("C1 생성자 호출");
		i = 10 * 10;
	}
}

class C2 extends C1 {
	int j ;
	C2 () {super("aaa");
		System.out.println("C2 생성자 호출");
		j = 10 * 10 * 10;
	}
}


public class ConstructorTest {

	public static void main(String[] args) {
		C2 c = new C2();
		// Object 객체 생성
		// -> C1 생성 -> 변수 i 초기화
		// -> 출력문 -> i = 100
		// -> C2 생성 -> 변수 j 초기화
		// -> 출력문 -> j = 1000
		System.out.println(c.j);
		System.out.println(c.i);
		
	}
}
