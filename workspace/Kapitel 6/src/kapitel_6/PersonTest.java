package kapitel_6;

class Person {
	String name;
	int age;
	final static String nation = "대한민국";
	//1개 값 미리 정적 선언 .. 모든 객체 + 공유/수정 불가
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
}


public class PersonTest {

	public static void main(String[] args) {
		
		System.out.println(Person.nation);
		
		
		Person p1 = new Person("홍길동", 29);
		System.out.println("p1 객체의 이름은 " + p1.name + "이고 나이는 "
				+ p1.age + "이며 국적은 " + Person.nation + "입니다.");
		Person p2 = new Person("박보검", 23);
		System.out.println("p2 객체의 이름은 " + p2.name + "이고 나이는 "
				+ p2.age + "이며 국적은 " + Person.nation + "입니다.");
		
	System.out.println(Math.PI);
	// static 변수의 예 : 원주율 PI
	
	//	Math.PI = Math.PI + 1 ;
	// PI 값도 바뀌면 안되니까 final 지정이 돼있다.
	
	System.out.println(Integer.MAX_VALUE);
	// int의 최대값 출력 ... 4바이트 = 32비트
	// -2^31 ~ 2^31 -1
	
	// MAX_VALUE도 마찬가지로 고정값이므로 final
		
		

	}

}
