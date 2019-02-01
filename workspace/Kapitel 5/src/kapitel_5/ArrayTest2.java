package kapitel_5;

import java.util.Scanner;
public class ArrayTest2 {

	public static void main(String[] args) {
		
//		int scores[] = new int [5];
//		int max = 0;
//		int min = 101;
//		System.out.println("====최댓값을 구할 데이터들====");
//		for (int i = 0; i < scores.length; i++) {
//			scores[i] = (int)(Math.random()*100)+1;
//			System.out.print(scores[i] + "  ");
//			if (max < scores[i]) {max = scores[i];}
//			if (min > scores[i]) {min = scores[i];}
//			
//		}
//		System.out.println("\n최댓값 : " + max +	"\n최솟값 : " + min );

	Scanner sc = new Scanner(System.in);
	String names[] = new String[5]; 
	String title [] = {"java", "html5", "javascript", "sql", "css", "jquery", "hadoop", "R", "python"};
	int scores[] = new int [5];

	names[0] = "송혜교";
	names[1] = "장나라";
	names[2] = "김유정";
	names[3] = "염정아";
	names[4] = "박보검";
	
	//System.out.println("====최댓값을 구할 데이터들====");
	for (int i = 0; i < scores.length; i++) {
		System.out.println(i + " 번째 이름 입력하세요");
		names[i] = sc.next();
		scores[i] = (int)(Math.random()*100)+1;
		System.out.println(names[i] + " 학생의 점수는 " + scores[i]);
		
		
//		if(scores[0] <= scores[i]) {scores[0]=scores[i];}
	}
//	for (k = 0; k < scores.length-1 ; k++) {
//		for (int i = 1 ; i < scores.length ; i++) {
//			if (scores[k] <= scores[i]) {
//				temp = scores[k];
//				scores[k] = scores[i];
//				scores[i] = temp;
//			}
//		}
//	}
	
	
	
	System.out.println("\n최댓값 : " + scores[0]);
	
	
	
	

  }

}
