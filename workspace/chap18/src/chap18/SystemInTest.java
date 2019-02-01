package chap18;

import java.io.IOException;
//System.in : 키보드 장치 - windows - 바인딩 변수명
public class SystemInTest {
public static void main(String[] args) {
	System.out.println("입력 시작하세요.");
	try {
		int result =0;
		while( (result = System.in.read()) != -1) 
		System.out.println(result);
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
}
}
