package chap18;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileClassTest {
public static void main(String[] args) {
	//키보드 파일명이나 디렉토리명 1개 입력
	//File 클래스 객체 생성
	//파일이면 구현 메소드 실행 결과 출력
	//디렉토리라면 내부 리스트(파일,디렉토리 등) 출력 /.list()사용
	System.out.print("파일명 또는 디렉토리명을 입력하세요");
	Scanner sc = new Scanner(System.in);
	String line = sc.nextLine();
	//src/chap18/FileClassTest.java
	//C:\eclipse\workspace\chap18\src\chap18\FileClassTest.java
	try{
		File f = new File(line);
		if(f.exists()) {
			if (f.isDirectory()) {
				for( String list : f.list()) {
				System.out.println(list);
				}
			}
			else/* if (f.isFile())*/ {
				System.out.println(f.isFile());
				System.out.println(f.canRead());
				System.out.println(f.canWrite());
				System.out.println(f.getCanonicalPath());//절대 경로 출력
				System.out.println(f.getName());
				System.out.println(f.length());

				long time = f.lastModified(); // 1/1000초단위
				Date timeDate = new Date(time); //Date 변환
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일hh시mm분ss초");
				String timeString = sdf.format(timeDate);
				System.out.println(timeString);
			} 
	}
	else {System.out.println("존재X");}
	
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
}
}