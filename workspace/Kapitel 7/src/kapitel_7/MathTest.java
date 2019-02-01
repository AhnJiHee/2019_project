package kapitel_7;

final class Math {
	public int abs(int data) {
		if (data < 0) {
			return data*-1;
		}
		else return data;
	}
}

class MyMath /*extends Math*/ {
//	public int abs(int data) {
//		if (data < 0) {
//			return data*-1;
//		}
//		else return data;
//	}
	public int abs(int data) {
		Math m = new Math();
		return m.abs(data);
	}
	
	void power() {
		
		System.out.println("제곱을 구합니다.");
	}
}


public class MathTest {

	public static void main(String[] args) {
		MyMath m = new MyMath();
		m.power();
		System.out.println(m.abs(10));
		System.out.println(m.abs(-10));

	}
}
