package dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import vo.BoardVO;

public class BoardDAO_File {
	public void insertBoard(BoardVO vo) throws IOException {
			FileWriter fw = new FileWriter("board.txt", true);
			// FileWriter 생성자 두 번째 변수에 true를 넣으면
			// 만약 이미 저장된 파일이 있을 시에 여기에 내용을 추가한다
			fw.write(vo.toString()+"\n");
			// fw.write()의 괄호 안에는
			// char, int, String 모두 입력이 가능하다
			fw.close();
			// 파일에 write 하고 close 하지 않으면 아무 일도 일어나지 않으므로
			// 꼭 저장 후 종료해주어야 한다
			System.out.println("===> board.txt 파일에 게시물 저장을 완료했습니다.");
		}
	
	public BoardVO selectBoard(int seq) throws IOException{
		
		// 5개 이상 게시물이 저장된 상태
		// 1. board.txt 파일 입력 객체 (fr) 생성
		FileReader fr = new FileReader("board.txt");
		Scanner key = new Scanner(fr);
		String [] tokens = new String [4];
		ArrayList <String []> sentences = new ArrayList <String []> ();
		ArrayList <BoardVO> list = new ArrayList <BoardVO> ();
		
//		<내 풀이>
		while (key.hasNextLine()) {
			String s = key.nextLine();
			tokens = s.split("=");
			sentences.add(tokens);
		}
		
		for (int i = 0 ; i < sentences.size() ; i++) {
			int head = Integer.parseInt((sentences.get(i))[0]);
			if ( head == seq) {
				tokens = sentences.get(i);
			}
		}
		
		int token0 = Integer.parseInt(tokens[0]);
		int token3 = Integer.parseInt(tokens[3]);
		
		if (token0 < seq) {
			System.out.println(seq + "보다 작은 수를 입력하십시오.");
			return null;
		}
		BoardVO vo = new BoardVO (token0, tokens[1], tokens[2], token3);
		return vo;
		

//		<강사님 풀이>
//		while (key.hasNextLine()) {
//			String s = key.nextLine();
//			tokens = s.split("=");
//			BoardVO vo = new BoardVO
//					(Integer.parseInt(tokens[0]), tokens[1], tokens[2],
//							Integer.parseInt(tokens[3]));
//			list.add(vo);
//		}
//		
//		for (int i = 0; i < list.size(); i++) {
//			BoardVO vo = list.get(i);
//			int voseq = vo.getSeq();
//			if(voseq == seq) {
//				return vo;
//			}
//		}
//		return null;


	}
		
}