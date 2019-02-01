package kapitel_4;

public class AlphaConversion {
	public static void main(String[] args) {
		// 대문자 A를 소문자 a로 바꾸려면, (char) A + 32
		
		while(true) {
			int A = (int)(Math.random()*200)+1;
			if (A>64 && A<91) 
				{System.out.println((char)A + "를 " + (char)(A+32) + "로 출력합니다.");}
			else if (A>96 && A<123)
				{System.out.println((char)A + "를 " + (char)(A-32) + "로 출력합니다.");}
			else if (A<51 || A>149) 
				{System.out.println("종료"); break;}
			else {System.out.println(A);}
		}
	}
}
		
		
	
