import java.util.Scanner;

public class hanoi {

	public static void main(String[] args) {
		
		int result = 0;
		System.out.println("n의 값을 입력하시오 : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			result += i;
		}
		System.out.println(result);
	
	}

}
