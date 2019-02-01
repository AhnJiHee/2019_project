package chap18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//FileInTest : a.txt copy.txt //입력파일 존재X:오류-중단
//FileinTest : src/chap18/FileInTest.java copy.txt
//		==>입력파일존재O,출력파일존재X:empty파일생성
//		==>입력파일존재O,출력파일존재O:저장내용삭제
//FileinTest : src/chap18/SystemInTest.java copy.txt //입력파일존재O,출력파일존재O:저장내용유지-추가출력

public class FileInTest {
public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {	
			//현재프로젝트 / "src/chap18/FileInTest.java"
			//현재프로젝트 -> copy.txt 파일복사
		//1. java 파일 열기 / copy.txt파일열기
			fr = new FileReader(args[0]);	
			fw = new FileWriter(args[1],true); 
										//false or 공란 == 기존내용삭제
										//true == 기존내용 뒤에 추가
		//2. 파일 처음-끝 입력 
			int result = 0;
			while( (result = fr.read()) != -1) {
				//모니터 출력
				System.out.print((char)result);
				//copy.txt파일 출력 = 복사
				fw.write(result); //2바이트숫자값 - 자동문자변환				
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());			
		}finally {
		//3. 파일 닫기	
			try {
				fr.close(); //파일입력완료후 window 반납
				fw.close(); //버퍼->저장 이동
			}catch(IOException e){ 	}
		}

}
}
