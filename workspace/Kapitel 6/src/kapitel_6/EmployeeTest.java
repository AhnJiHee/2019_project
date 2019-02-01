package kapitel_6;

//클래스로부터 객체들 복사 생성 : 실행 시작 : main 메소드 
public class EmployeeTest {
	

	public static void main(String[] args) {
		Employee e1 = new Employee(1234, "홍길동", "인사부", "사원");
		// 클래스명 주소참조변수명 = new(객체생성연산자) [클래스명() = 생성자] ;
		/*1. e1 변수가 stack 영역에 할당 (null)
		 *2. new heap 영역 Employee 클래스의 복사본 생성
		 *3. (Employee의 생성자가 정의되어 있다면 그 생성자를 호출하여 실행)
		 *4. 2번의 주소값을 1번으로 대입(=)
		 * */
	//	e1.id = 1234;
//		e1.name = "홍길동";
//		e1.dept = "인사부";
//		e1.title = "사원";
		System.out.println(e1);
//		System.out.println("사번은 " + e1.id +
//				"이고 이름은 " + e1.name + " 부서는 " +
//				e1.dept + "이며 직급은 " + e1.title + " 입니다.");
 		
		Employee e2 = new Employee(2234, "김유정");
		// 클래스명 변수명 = new(객체생성연산자) 클래스명() ;
	//	e2.id = 2234;
//		e2.name = "김유정";
//		e2.dept = "총무부";
//		e2.title = "대리";
		System.out.println(e2);
		
		// stack										heap
		//								100						200
		// 								id : 1234				id : 2234
		// 								name : 홍길동			name : 김유정
		// e2 : 200					dept : 인사부			dept : 총무부
		// e1 : 100					title : 대리				title : 대리
		// 객체가 증가함에 따라 eN의 주소가 각각 heap 영역에 할당된다
		// 항상 객체참조변수n.필드명 = " " 의 형태로 객체를 정의해야한다.
		// 객체 생성문은 생략할 수 없지만, 변수값 초기화는 매번 할 필요가 없다.
		
		Employee e3 = new Employee();
		System.out.println(e3);
		// 새로 생성한 객체가 생성문에 입력된 변수들을 가지고 있지 않은 경우
		// 생성자를 여러개 쓰면 되지!
	}

}
