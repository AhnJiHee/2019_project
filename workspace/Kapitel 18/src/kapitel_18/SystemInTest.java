package kapitel_18;

import java.io.IOException;

public class SystemInTest {
//System.in : 키보드 장치 - windows - 자바가 구현해주는 바인딩 변수
// 문자를 int데이터로 출력
// char는 200이 넘어가는 값을 보여줄 수 없다 -> 한글 x 
	public static void main(String[] args) {
		System.out.println("입력 시작하세요");
		try {
			int result = 0;
			// ctrl + z 이 중단 키워드
			// 이 커맨드는 OS마다 다를 수 있다
			// 한글, 자바 데이터 타입을 인식하지 못하는게 한계
			while ( (result = System.in.read()) != -1) {
			System.out.println((char)result);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
