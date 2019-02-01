package kapitel_5;

public class ArrayTest1 {

	public static void main(String[] args) {

		int scores[] = new int [5];
		System.out.println(scores.length);
			// for (int i=0 ; i < scores.length ; i++) {
			//	System.out.println(scores[i]);
		// 총합, 평균, 개수 구하기
			int sum = 0;
			int avg = 0;
			for (int i = 0; i < scores.length; i++) {
				scores[i] = (int)(Math.random()*100)+1;
				System.out.println(scores[i]);
				sum += scores[i];
			}
			System.out.println(sum);
			avg = sum / scores.length;
			System.out.println(avg);
			
			//}
			
		
		
		
		
		
		
		
	}

}
