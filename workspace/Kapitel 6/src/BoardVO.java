
import java.util.Date;

public class BoardVO {
  // 게시물 작성하려면 ... 번호, 제목, 내용, 작성자, 시간, 암호, 조회수
	private int seq;
	private String title;
	private String contents;
	private String writer;
	private Date time;
	private int password;
	private int viewcount;
	// 정보는 은닉하되, getter/setter로 게시/수정 기능까지 부여해주었다
	
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	
}

