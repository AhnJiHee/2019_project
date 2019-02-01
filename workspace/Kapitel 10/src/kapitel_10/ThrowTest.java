package kapitel_10;

public class ThrowTest {

	public static void main(String[] args) {
		
		//1> 예외 발생 상황은 정해져있다 : 처리 필요
		//System.out.println( 10 / 0 );
		//2> 메소드가 예외 상황을 전달 : 처리 필요
		//Class.forName("a");
		
		int id = -100;
		try {
			if (id <=0 ) {
				// 강제적 예외 발생
				throw new Exception("존재할 수 없는 사번");
			}
		}
		catch(Exception e) {
				System.out.println(e.getMessage());
		}
		
	
		System.out.println("사번 :" + id);
		
		
		
		
		
		
	}

}
