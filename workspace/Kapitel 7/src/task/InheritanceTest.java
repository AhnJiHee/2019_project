package task;
//-상속과 오버라이딩을 이용하여 
//각 직종의 회사원들의 급여를 계산하시오.

class Employee {
	int id;
	String name;
	int mainSalary;
	int normalSalary;
	int totalSalary;
	
	Employee (int id, String name, int mainSalary, int normalSalary){
		this.id = id;
		this.name = name;
		this.mainSalary = mainSalary;
		this.normalSalary = normalSalary;
	}
	void totalSalary() {
		totalSalary = mainSalary + normalSalary;
	}
	void printAll() {
		System.out.println(id + ":" + name + ":" + mainSalary + ":" + totalSalary);
	}
	
}

class Manager extends Employee{
	int mgrSalary;
	
	Manager (int id, String name, int mainSalary,
					int normalSalary, int mgrSalary){
		super(id, name, mainSalary, normalSalary);
		this.mgrSalary = mgrSalary;
}

	void totalSalary() {
		super.totalSalary();
		totalSalary += mgrSalary;
	}
}

class Engineer extends Employee{
	int certSalary;
	int skillSalary;
	
	Engineer (int id, String name, int mainSalary,
					int normalSalary, int certSalary, int skillSalary){
		super(id, name, mainSalary, normalSalary);
		this.certSalary = certSalary;
		this.skillSalary = skillSalary;
	}
	void totalSalary() {
		super.totalSalary();
		totalSalary += certSalary + skillSalary;
	}
}
	
class Secretary extends Employee{
	int servSalary;
	
	Secretary (int id, String name, int mainSalary,
					int normalSalary, int servSalary){
		super(id, name, mainSalary, normalSalary);
		this.servSalary = servSalary;
	}
	void totalSalary() {
		super.totalSalary();
		totalSalary += servSalary;
	}
}

class InheritanceTest{
public static void main(String args[]){

	Employee e [] = new Employee[4];
	// 1.상속 2.생성자(타입 순서 갯수....)
	e[0] = new Employee
	(1000,"이사원",10000,5000);
	e[1] = new Manager
	(2000,"김간부",20000,10000,10000);
	e[2] = new Engineer
	(3000,"박기술",15000,7500,5000,5000);
	e[3] = new Secretary
	(4000,"최비서",15000,7000,10000);
	
	System.out.println("사원:이름:본봉:총급여");
	for(int i=0; i<e.length; i++){
		e[i].totalSalary();
		e[i].printAll();
		
		
		//  객체가 Secretary 일 때 servSalary를 출력해보자
		if (i==3) {
		System.out.println(((Secretary)e[i]).servSalary);
		}
		// 현재 main에서 실행하는 메소드는 Employee에서 오고 있으므로
		// Secretary의 변수값을 참조하고 싶으면 클래스 형변환 해주어야된다.
		
		
		// 그런데 i가 3일 때의 객체는 입력하는 경우에 따라 Secretary가 아닐 수도 있다.
		if (e[i] instanceof Secretary) {
		System.out.println(((Secretary)e[i]).servSalary);
		}
		// a instanceof A ... a 변수가 A 클래스의 객체인가
		
	}
	
	}
}	
