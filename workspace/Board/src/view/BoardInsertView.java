package view;

import java.io.IOException;
import java.util.Scanner;

import dao.BoardDAO;
import vo.BoardVO;

public class BoardInsertView {
	public void input() throws Exception{
		System.out.println("게시물 저장 내용을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		//게시물번호 : 게시물 제목 : 게시물 내용 : 조회수
		String []tokens = line.split(":");
		BoardVO vo = new BoardVO(Integer.parseInt(tokens[0].trim())
				,tokens[1],tokens[2], Integer.parseInt(tokens[3].trim()));
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);	
	}
	}
