package kapitel_7;

class Employee {
	int id;
	String name;
	String dept;
	String title = "사원";
	public void printField() {
		System.out.println(id + ":" + name + ":" + dept);
	}
}

class Manager extends Employee {
	
	public void printField() {
		super.printField();
//   = System.out.println(id + ":" + name + ":" + dept);
//   => 코드 재사용을 통한 효율성
		System.out.println(jobOfManage + ":" + cntOfSubs);
	}
	// 상위클래스와 동일한 메소드를 만들고 싶을 땐 선언부 그대로
	
	void test () {
		System.out.println(super.title);
		System.out.println(title);
	}
	
	String title = "관리직";
	String jobOfManage; // 관리 업무
	int cntOfSubs; // 관리사원 수
		
}

public class ManagerTest {

	public static void main(String[] args) {

		Manager m = new Manager() ;
		m.id = 100;
		m.name = "홍길동";
		m.dept = "전산";
		m.jobOfManage = "전산실 관리";
		m.cntOfSubs = 5;
		System.out.println(m.id + ":" + m.name + ":" + m.jobOfManage );
		m.test();
		m.printField(); // Employee에서 상속받은 메소드를 Manager에서 쓴다
							// 하지만 우선 실행 메소드는 Manager 수정본
		m.printField();
		
		

		
		
		
		
		
	}

}
