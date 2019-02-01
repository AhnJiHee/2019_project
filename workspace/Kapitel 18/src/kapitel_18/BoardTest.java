package kapitel_18;

import java.util.Scanner;

// XXXVO = XXXDO = XXXDTO
// Value Object = Data Object = Data Transfer Object
// => 게시물 1개를 표현하는 여러 값을 저장하는 용도의 객체
class BoardVO{
	int seq;
	String title;
	String contents;
	int viewcount;
	
	public BoardVO(String board) {
		String[] tokens = board.split(":");
		seq = Integer.parseInt(tokens[0]);
		title = tokens[1];
		contents = tokens[2];
		viewcount = Integer.parseInt(tokens[3]);
	}
	public String toString() {
		return "번호 = " + seq + " 제목 = " + title + " 내용 = " 
				+ contents + " 조회수 = " + viewcount;
	}
}

// XXXDAO : Data Access Object (VO의 데이터에 접근, 변수 사용하는 클래스)
// 저장/수정/삭제/조회 예제
class BoardDAO {
	public void insertBoard(BoardVO vo) {
		System.out.println(vo + "\n게시물이 저장되었습니다");
		// vo가 출력되는 방식을 바꾸려면
		// BoardVO로 가서 overriding 해야지
	}
}

public class BoardTest {

	public static void main(String[] args) {
		// 1. 게시물 저장
		// 2. 게시물 수정
		// 3. 게시물 조회
		// 번호 입력 : 
		
		System.out.println("게시물 정보를 입력하세요");
		// 1) 입력 받는 단계
		Scanner sc = new Scanner(System.in);
		String board = sc.nextLine();
		
		// 2) 입력 받은 내용을 게시물로 저장하는 단계
		BoardVO vo = new BoardVO(board);
		
		// 3) 저장된 게시글을 불러와 저장 메시지를 출력하는 단계
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		// 한줄 내용
		// 1:게시물저장:1개의 게시물을 저장합니다:0
	
	}

}
