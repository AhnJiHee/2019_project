package kapitel_5;

public class MainTest {

	public static void main(String[] args) {
		System.out.println("입력변수의 갯수 = " + args.length);
		for(int i = 0; i < args.length; i++) {
			System.out.println("입력변수 = " + args[i]);
		}
		// String 데이터를 int로 바꾸기
		// 그런데 형변환 연산자는 기본타입만 가능하다
		// Integer.parseInt()
		System.out.println(args[0] + args[1]);
		int first = Integer.parseInt(args[0]);
		int second = Integer.parseInt(args[1]);
		System.out.println(first+second);
		
		double third = Double.parseDouble(args[2]);
		System.out.println(third + third);
		

		
		
		
		
		

	}

}
