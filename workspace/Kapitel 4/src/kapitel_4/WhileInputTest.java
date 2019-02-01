package kapitel_4;

import java.util.Scanner;

public class WhileInputTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String input = sc.next(); // 진행 / 종료 중 하나를 입력
//		System.out.println(input);
		
		// 연산자 동등비교 : boolean, char, int, double 가능
		// String의 동등비교 : equals()메소드를 사용
		
//		while (input.equals("진행")) {
//		// while(true) { : 무한루프 반복문
//			System.out.println("프로그램 수행중입니다.");
//			System.out.println("계속 하려면 '진행'을 입력하세요.");
//			input = sc.next();
//		}
//		System.out.println("프로그램을 종료합니다.");

		while (true) {
			System.out.println("프로그램 수행중입니다.");
			System.out.println("계속 하려면 '진행'을 입력하세요.");
			String input = sc.next();
			if(input.equals("종료")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
	}

}
