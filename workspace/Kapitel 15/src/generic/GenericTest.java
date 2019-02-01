package generic;

class Box<T, E>{
	T contents;
	E classId;
	Box(T c){
		contents = c;
	}
	Box(T c, E id){
		contents = c;
		classId = id;
	}
	public void setContents(T c) {
		contents = c;
	}
	public T getContents() {
		return contents;
	}
}

class Paper{
	String size;
	Paper (String size){
		this.size = size;
	}
}

class Apple{
	String origin;
	Apple(String origin){
		this.origin = origin;
	}
}

public class GenericTest {

	public static void main(String[] args) {
		
		Paper p = new Paper("A4");
		Box<Paper, String> paperBox = new Box<Paper, String>(p, "공산품");
		Paper o1 = paperBox.getContents();
			System.out.println(o1.size);
			System.out.println(paperBox.classId);
//		Apple a = new Apple("청송");
//		Box<Paper, Integer> appleBox	= new Box<Paper, Integer>(a, 100);
//		Paper o2 = appleBox.getContents();
//			System.out.println(o2.origin);
//			System.out.println(appleBox.classId);


		
		
		
	}

}
