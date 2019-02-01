package kapitel_5;

public class ArrayTest3 {

	public static void main(String[] args) {
		
//		int scores[] = new int[5];
//		System.out.println(scores.length);
//		
//		// 자바의 배열은 정적인 길이를 가진다.
//		// => 배열의 길이를 바꿀 수 없다
//	
//		scores = new int[10];
//		System.out.println(scores.length);
//		// 다만 선언된 배열의 값을 다시 정의할 수 있다
//		// 이때 기존의 설정값들은 모두 삭제된다
		
		int scores[] = new int[5];
			for (int i = 0 ; i < scores.length ; i ++) {
			scores[i] = (i+1) * 10;			
			System.out.print(scores[i] + " ");
			}
			System.out.println();
		
		// 기존의 배열값 복사하기
		int scores2 [] = new int[10];
			System.arraycopy(scores, 0, scores2, 5, scores.length);
			//				  누구를, 어디부터, 누구한테, 어디부터, 얼마나
			for (int i = 0 ; i < scores2.length ; i ++) {
				System.out.print(scores2[i] + " ");
			}
		
		// 향상된 for 문
		// 위 arraycopy 이후에 사용한 for문과 정확히 똑같은 결과를 출력한다.
		System.out.println();
			for ( int sc : scores2) {
				System.out.print(sc + " ");
			}
			
		
		
	}

}
