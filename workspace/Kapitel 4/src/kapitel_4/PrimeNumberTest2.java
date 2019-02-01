package kapitel_4;

public class PrimeNumberTest2 {

	public static void main(String[] args) {
		
		int i, count = 0;
		int k = 0;
		
		for (int su = (int)(Math.random()*100)+1; su>1; su--) {
			for (i = 2; i <=su; i++) {if (su%i == 0)
				{count++;}}
				if (count == 1) {System.out.println(su + "는 소수입니다.");}
				else {System.out.println(su + "는 소수가 아닙니다.");}
				count=0;
		}
	}

}
