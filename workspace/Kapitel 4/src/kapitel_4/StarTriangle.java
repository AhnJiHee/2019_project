package kapitel_4;

public class StarTriangle {

	public static void main(String[] args) {
		int su = (int)(Math.random()*10)+1;
		System.out.println(su);
		
		for(int line=1 ; line<=su ; line++) {
			System.out.print("*");
			for(int star=1 ; star<line ; star++) {
				System.out.print("*");
			}
		System.out.println();
		}
	}
}
