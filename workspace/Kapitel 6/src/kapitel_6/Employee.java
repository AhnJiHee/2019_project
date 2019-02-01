package kapitel_6;

public class Employee {
// 클래스 만들 때 자동 삽입 코드 Employee(){} ... 기본 생성자
// 기본 생성자 형태 : 클래스명(){}
// 사용자 생성자를 정의하면 이는 자동으로 사라진다
	Employee(int id, String name, String dept, String title){
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.title = title;
	}
// 생성자를 추가로 정의하고 싶다?
// 클래스명은 동일
// 변수 갯수, 타입, 순서 중 1개 이상 다르게 정의
// => 생성자 overloading (중복정의) 라고 한다.
	Employee(int id, String name){
		this(id, name, "부서 미정", "직급 미정");
//		id = i;
//		name = n;
//		dept = "부서 미정";
//		title = "직급 미정";
// => 위 네 문장을 this( ) 호출로 한번에 퉁칠 수 있다! 
		
	}
	Employee () {
		this(-1, "이름 미정", "부서 미정", "직급 미정");
//		id = -1 ;
//		name = "이름 미정";
//		dept = "부서 미정";
//		title = "직급 미정";
	}	
	
// 회사원을 객체로 표현한다
	int id ; // 사번
	String name ; // 이름
	String dept ; // 부서
	String title ; // 직급
	//String sub[] = new String[5] ; 	// 부하직원배열로 만들기
// 변수, 생성자, 메소드는 정의의 순서가 정해져있지 않다

	public String toString() {
		return "사번은 " + id +
				"이고 이름은 " + name + " 부서는 " +
				dept + "이며 직급은 " + title + " 입니다.";
	}

	
	
	
	
}
//회사원 객체의 특성 파악 - Employee 클래스 정의
//얘는 main 메소드가 없기 때문에 실행이 불가능하다