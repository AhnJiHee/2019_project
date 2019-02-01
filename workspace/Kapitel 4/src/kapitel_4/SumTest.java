package kapitel_4;

public class SumTest {

	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1 ; i <= 10 ; i=i+2) {
			// System.out.println(i);
			//if(i%2 == 1) 
			sum = sum + i;
			System.out.println(i + ":" + sum);}
		
	}

}
