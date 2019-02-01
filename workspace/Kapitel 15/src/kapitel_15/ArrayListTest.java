package kapitel_15;

import java.util.ArrayList;

class Emp {
	int id; // 사번
	String name; // 이름
	double pay; // 급여
	public Emp(int id, String name, double pay) {
		this.id = id;
		this.name = name;
		this.pay = pay;
	}
	public String toString() {
		return id + "-" + name + "-" + pay ;
	}
	
	
}


public class ArrayListTest {

	public static void main(String[] args) {
		// Emp 타입 데이터들만 저장되게 하려면?
		// 1) Emp타입 배열 생성 => 개수 변동 반영 불가
		// 2) ??
		
		ArrayList list = new ArrayList(5);
		list.add("java");
		list.add(100);
		list.add(3.14);
		list.add(1, "sql");
		Emp e1 = new Emp(100, "홍길동", 67000.99);
		Emp e2 = new Emp(200, "박길동", 77000.99);
		Emp e3 = new Emp(300, "김길동", 87000.99);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.remove(1);
		list.set(1, "newString");
		
		boolean exists = list.contains("java");
		System.out.println(exists);
		
		int index = list.indexOf("java1");
		System.out.println(index);
		
//		boolean exists2 = list.contains(e1);
//		System.out.println(exists2);
		
		
		System.out.println(list.size());
		for(int i = 0 ; i < list.size(); i++) {
			// id-name-pay 형식 출력
			System.out.println(list.get(i));
			if( list.get(i) instanceof Emp) {
			System.out.println(((Emp)list.get(i)).name);
			}
		}
		
		/*
		 * class ArrayList implements List{
		 * add(Object o){ ... }
		 * Object get (int i) {}
		 * size () 
		 * }
		 * 
		 * class ArrayList<T(type)> implements List{
		 * add(T) {...}
		 * T get (int i) {}
		 * size() 
		 * 
		 * ArrayList list1 = new Arraylist();
		 * ArrayList<Student> list2 = new Arraylist<Student>();
		 * 
		 * */
		
		
		
		
	}

}
