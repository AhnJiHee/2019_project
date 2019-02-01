package chap18;

import java.util.Scanner;

public class ScannerTest {
public static void main(String[] args) {
	System.out.println("입력 시작하세요.");
	Scanner key = new Scanner(System.in);
//	String line = key.nextLine(); //String(한글 포함)
//	System.out.println(line);
	String word = key.next();//String(공백이전 단어)
	int num1 = key.nextInt();
	double num2 = key.nextDouble();
	System.out.println(word);
	System.out.println(num1+num2);
}
}
