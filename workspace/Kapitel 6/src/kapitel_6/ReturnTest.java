package kapitel_6;

//하나의 소스에 두 개 이상의 클래스를 포함시킬 수 있다
//단, 1) public 선언된 클래스명 = java파일명
//or 2) main 메소드를 가지고 있는 클래스명 = java파일명
//메소드 정의/구현이 곧 실행은 아니다
//이를 실행하려면 main에서 호출이 있어야 한다.

class A {
	int ma() {
		int i = 10;
		return i * i;
		// 리턴 타입이 int라고 메소드 앞에 표시해주어야 한다
		// 리턴은 가장 마지막 줄에 써야한다
	}
	double mb() {
		return 3.14;
	}	
	String mc(){
		String s = "java";
		return s + s;
	}
	void md(int j){
		// j*j >= 100이면 출력 / 아니면 중단
		if (j * j >=100) {
			System.out.println(j*j);
		} else {
			return; // void-return은 메소드 중단
		}
		System.out.println("md 메소드 종료");
		
	}
}


public class ReturnTest {

	public static void main(String[] args) {
		A a1 = new A ();
		// 실행 문장 => 메모리에 변화가 생김.
		// 객체 생성이 1순위
		int result = a1.ma();
		System.out.println(result);
		double result2 = a1.mb();
		System.out.println(result2);
		String result3 = a1.mc();
		System.out.println(result3);
		a1.md(1);
		a1.md(10);
		System.out.println("main종료");
		
		

	}

}
