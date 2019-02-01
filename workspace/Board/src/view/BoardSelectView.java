package view;

import java.io.IOException;
import java.util.Scanner;

import dao.BoardDAO;
import vo.BoardVO;

public class BoardSelectView {
	public void input() throws Exception{
		System.out.print("조회할 게시물 번호를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		Integer seq = sc.nextInt();
		//게시물번호만 데려오기
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.selectBoard(seq);
		System.out.println(vo);
	}
	}
