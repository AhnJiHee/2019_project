package vo;

public class BoardVO {
	int seq;//번호
	String title;//제목
	String contents; //내용
	int viewcount; //조회수

	

	public BoardVO() {
	}

	public BoardVO(int seq, String title, String contents, int viewcount) {
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.viewcount = viewcount;
	}
	/*create table board{
	seq number(5) constraint board_seq_pk primary key,
	title varchar2(100),
	contents varchar2(4000),
	viewcount number(5)
	};
	
	insert into board(1, '테스트제목', '테스트내용입니다', 0);
	commit;
	
	*/
	
	public String toString() {
		return seq + "=" + title + "="
				+ contents +"=" + viewcount;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
}
