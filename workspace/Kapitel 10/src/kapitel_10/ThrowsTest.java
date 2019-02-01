package kapitel_10;

class Test{
	void ma (int i) throws ArithmeticException {
		System.out.println(100 / i);
	}
	void mb() throws ArithmeticException {
		ma(0);
	}
	
//	void mb () {
//		try {
//			ma(0); 
//		} catch (ArithmeticException e) {
//			System.out.println("0으로 나누기 불가");
//		}
//	}
//	void mc () {
//		try{
//			ma(0);
//		}catch(ArithmeticException e) {
//			ma (100);
//		}
//	}
}
/* 왜 떠넘기는가?
 * 똑같은 수행문을 실행해서 호출하는 메소드마다
 * 예외를 각각 다르게 처리하고 싶으니까
 * 
 * 만약 떠넘기고 싶으면 계속 throw 해서 최종 호출자(java)에게 
 * 예외 처리를 전달할 수 있다
 * */



public class ThrowsTest {

	public static void main(String[] args)
			/*throws ArithmeticException*/ {
		// 자바 시스템에 전달 = 기본적 처리 기능
		Test t = new Test();
		try {
			t.mb();	
		}catch(ArithmeticException e) {
			System.out.println("0 나누기 오류");
		}
	
		try{
			Class.forName(args[0]);
			System.out.println("존재하는 클래스입니다.");
		}catch(ClassNotFoundException e) {
			System.out.println("그런 이름의 클래스는 존재하지 않습니다.");
		}
		
		//throws ClassNotFoundException 가 포함 ... 처리 필요
		
		
		
		
		
		
	}

}
