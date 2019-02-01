package view;

import java.util.Scanner;

import dao.BoardDAO;

public class BoardUpdateView {
	public void input() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("포함시킬 내용을 입력하세요 : ");
		String oldString = sc.next();
		System.out.print("변경할 내용을 입력하세요 : ");
		String newString = sc.next();
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(oldString, newString);
		
	}
}
