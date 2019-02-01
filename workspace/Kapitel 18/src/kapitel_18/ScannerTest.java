package kapitel_18;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		System.out.println("입력 시작하세요");
		Scanner key = new Scanner(System.in);
//		String line = key.nextLine(); // 한 줄 전체를 읽어 String으로 출력
		String word = key.next(); // 공백 이전 단어
		int i = key.nextInt();
		double d = key.nextDouble();
//		System.out.println(line);
		System.out.println(word);
		System.out.println(i+d);
		
	}

}
