package kapitel_7;
import java.lang.Math;

abstract class shape{
	abstract void circum ();
	abstract void area ();
}

class Rectangle extends shape{
	int width;
	int height;
	Rectangle (int w, int h) {
		width = w;
		height = h;
	}
	void circum () {
		System.out.println("둘레는 " + 2* (width + height) + "입니다.");
	}
	void area() {
		System.out.println("면적은 " + width * height + "입니다.");
	}
	
}

class Circle extends shape{
	int r ;
	Circle (int r) {
		this.r = r;
	}
	void circum () {
		System.out.println("둘레는 " + 2* r * Math.PI + "입니다.");
	}
	void area () {
		System.out.println("면적은 " + r * r * Math.PI + "입니다.");

	}
	
}




public class ShapeTest {

	public static void main(String[] args) {
		shape s = null;
		
		// cir 5 ... 반지름 5인 Circle 객체 생성
		// rec 6 8 ... 가로가 6, 세로가 8인 Rectangle 객체 생성
		// 면적, 둘레 구하는 기능이 공통적으로 가능해야 한다
		if (args.length == 2 && args[0].equals("cir")) {
			s = new Circle (Integer.parseInt( args[1] ) );
		}
		else if (args.length == 3 && args[0].equals("rec")) {
			s = new Rectangle
					(Integer.parseInt(args[1]), Integer.parseInt(args[2]));

		}
		// 공통 기능 메소드 + 다른 결과
		s. area();
		s. circum();
		

		
	}

}
