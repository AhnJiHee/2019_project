package kapitel_10;

public class ExceptionTest {

	public static void main(String[] args) {
		// 2개 값을 입력하되, j는 0이 아니어야 하고, i, j는 정수 값만 취할 수 있다
		try {
		// 예외 발생 가능성이 있는 문장을 정의한다
		// 예외 발생 안하면 try 블록 실행 
		// 예외 발생 하면 catch 블록 실행 (try는 중단)
		// 어떠한 경우에도 프로그램은 끝까지 실행된다
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[1]);
			System.out.println(i / j);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			 System.out.println("2개 입력 변수가 필요합니다");
			// e.printStackTrace();
			// => 원인을 모를 때 발생 라인, 블록, 원인 메시지 출력
		}
		finally {
			System.out.println("항상 출력됩니다");
		}
/*		catch(NumberFormatException e) {
			 System.out.println("0~9 사이의 값만 입력하세요");
		}
		catch(ArithmeticException e) {
			 System.out.println("0은 입력할 수 없습니다");	
		}*/
//		catch (Exception e) {  /* 이 외 종류의 에외 발생 시 */
//			System.out.println("모든 예외 동일 처리합니다");
//		}
//		
		System.out.println("main완료");
		
//		String s = null;
//		String s2 = "java";
//		if(s.equals(s2)) {}
		
//		int [] i = null;
//		i = new int [5];
//		i [0] = 100;
		
		
		/*
		 * 100 100 입력 시 : 정상 시행
		 * 100 입력 시 : ArrayIndexOutOfBoundsException 
		 * 					: 입력 변수 개수가 부족
		 * aa bb 입력 시 : NumberFormatException
		 * 					: 문자는 숫자 형태가 아니다
		 * 100 0 입력 시 : AtrithmeticException
		 * 					: 산술오류... 0으로 나눌 수 없다
		 * <해법>
		 * 1) 예외 발생을 피해서 다른 문장을 실행하게 흐름을 변경한다
		 * 2) 예외 발생하지 않으면 원래 문장 실행
		*/
		
		
		
		
		
		
		
		

	}

}
