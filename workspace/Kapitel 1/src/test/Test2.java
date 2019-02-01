package test;

public class Test2 {

	public static void main(String[] args) {
		int cntOfBooks = 97;
		int cntOfStu = 12;
		int books = cntOfBooks / cntOfStu;
		int left = cntOfBooks % cntOfStu;
		
		String result = cntOfBooks > cntOfStu 
				? "1명의 학생 당 " + books + "권 씩 가질 수 있습니다"
				+ "\n남아있는 책은 " + left + "권입니다."
				: "나눠줄 수 없습니다.";
		System.out.println(result);
		
		//if문장을 이용해서 구하는 방법
		String resultA = "";
		if (cntOfBooks > cntOfStu) {
			int share = cntOfBooks / cntOfStu;
			int remain = cntOfBooks % cntOfStu;
			resultA = "1명의 학생 당 " + share + "권 씩 가질 수 있습니다."
			+ "\n남아있는 책은 " + remain + "권입니다.";}
		else {resultA = "나눠줄 수 없습니다.";}
		System.out.println(resultA);}
		
	}

