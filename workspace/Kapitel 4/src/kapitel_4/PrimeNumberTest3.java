package kapitel_4;

public class PrimeNumberTest3 {

	public static void main(String[] args) {
		int su = (int)(Math.random()*100)+1;
		int i, count = 0;
		
		for (int k=2; k<=su; k++) {
			for (i = 2; i <=su; i++) {if (k%i == 0)
				{count++;}}
				if (count == 1) {System.out.println(k + "는 소수입니다.");}
				else {System.out.println(k + "는 소수가 아닙니다.");}
				count=0;
		}
	}

}
