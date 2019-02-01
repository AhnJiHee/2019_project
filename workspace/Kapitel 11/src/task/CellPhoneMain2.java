package task;

class CellPhone2 {
	
	// 변수 설정
	String model;
	double battery;
	
	// 생성자
	CellPhone2(String model){
		this.model = model;
	}
	
	// call 메소드
	void call(int time) {
		battery -= time * 0.5;
		if (battery <0) {
			battery = 0;
		}			
		System.out.println("통화 시간 : " + time + "분");
		if (time <0) {
				throw new IllegalArgumentException ("통화시간 입력 오류");
		}
	}
	
	//charge 메소드
	void charge(int time) {
		battery += time * 3;
		if (battery >100) {
			battery = 100;
		}
		System.out.println("충전 시간 : " + time + "분"); 
		if (time > 100) {
			throw new IllegalArgumentException ("충전시간 입력 오류");
		}
	}

	// printBattery 메소드
	void printBattery() {
		System.out.println("남은 배터리 양 : " + battery);
	}

	// isSame 메소드
	boolean isSame(CellPhone other) {
		return this.model.equalsIgnoreCase(other.model); 
	}
}

//*<<CellPhoneMain 실행결과>>
//충전 시간 : 20분
//남은 배터리 양 : 60.0
//통화 시간 : 300분
//남은 배터리 양 : 0.0
//충전 시간 : 50분
//남은 배터리 양 : 100.0
//통화 시간 : 40분
//남은 배터리 양 : 80.0
//통화시간입력오류
//동일 모델입니다. 
//
//*/

public class CellPhoneMain2 {
 
public static void main(String[] args) { 
	CellPhone myPhone = 
         new CellPhone("GALAXY-9");
		
//charge, call 메소드 호출 포함하여 try-catch 블록 정의
// throws 하고 있는 예외 처리한다.
// 각 예외 발생시 어떤 메소드에서 어떤 원인으로 발생했는지
// 출력한다

		try {
			myPhone.charge( 20 );  //20분간 충전을 한다.
			myPhone.printBattery();
			
			myPhone.call( 300 );  //300분간 통화를 한다.
			myPhone.printBattery();
			
			myPhone.charge( 50 );  //50분간 충전을 한다.
			myPhone.printBattery();
			
			myPhone.call( 40 );  //40분간 통화를 한다.
			myPhone.printBattery();
			
			myPhone.call( -20 );  //통화시간입력오류
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		CellPhone yourPhone = new CellPhone("galaxy-9");
		
		if( myPhone.isSame(yourPhone) ) {
			System.out.println("동일 모델입니다.");
		} else {
			System.out.println("다른 모델입니다.");
		} 
	} 
}



