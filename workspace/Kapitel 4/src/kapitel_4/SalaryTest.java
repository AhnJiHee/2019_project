package kapitel_4;

import java.util.Scanner;

public class SalaryTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String title = sc.next();
		
		int baseSalary = 30000;
		int totalSalary = 0;
	
		// 사원 : 기본급 + 5000
		// 대리 : 기본급 * 1.2
		// 과장 : 기본급 * 1.5
		// 부장 : 기본급 * 2
		
		switch(title) {
		case "사원" : totalSalary = baseSalary + 5000; break;
		case "대리" : totalSalary = (int)(baseSalary * 1.2); break;
		case "과장" : totalSalary = (int)(baseSalary * 1.5); break;
		default : totalSalary = baseSalary * 2; break;
		}
		System.out.println(title + " 직급의 급여는 " + totalSalary + "원입니다.");
	}

}
