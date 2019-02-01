package kapitel_5;

public class SortTest {

	public static void main(String[] args) {
	
		int i = 0;
		int j = 0;
		int k = 0;
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		int d = Integer.parseInt(args[3]);
		int e = Integer.parseInt(args[4]);
		int f = Integer.parseInt(args[5]);		
		int scores [] = {a, b, c, d, e, f};
		for ( int n : scores) {
			System.out.print(n+" ");
		}
		
//		// 1회 시행 명령
//		for ( i = 0; i < scores.length ; i++) {
//			if (scores[0] <= scores[i]) {
//				k = scores[0];
//				scores[0] = scores[i];
//				scores[i] = k;
//			}
//		}
//		
//		// 결과문 출력부
//		System.out.println();
//		for (int n : scores) {
//			System.out.print(n+ " ");
//		}
//		
		// 반복 시행 명령
		for ( j = 0; j < scores.length-1 ; j++ ) {
			for ( i = 0; i < scores.length ; i++) {
				if (j < i) {
				if (scores[j] >= scores[i]) {
					k = scores[j];
					scores[j] = scores[i];
					scores[i] = k;
				}
				}
			}
		}
		
		// 결과문 출력부
		System.out.println("\n오름차순 출력");
		for (int n : scores) {
			System.out.print(n+ " ");
		}
		
		
		
		
		
		
	}

}
