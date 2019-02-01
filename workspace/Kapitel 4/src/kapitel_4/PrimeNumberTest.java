package kapitel_4;

public class PrimeNumberTest {

	public static void main(String[] args) {
		int su = (int)(Math.random()*100)+1;
		int i, count = 0;
		for (i = 1; i <=su; i++) {
			if (su%i == 0)
				{count++;
			}
		}
		if (count == 2) {
			System.out.println(su + "는 소수입니다.");
		}
		else {
			System.out.println(su + "는 소수가 아닙니다.");
		}
						
	}

}
