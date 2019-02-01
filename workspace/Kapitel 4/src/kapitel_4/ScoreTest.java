package kapitel_4;

public class ScoreTest {

	public static void main(String[] args) {
		String name = "김학생";
		//점수변경 랜덤
		int kor = (int)(Math.random() * 100)+1;
		int eng = (int)(Math.random() * 100)+1;
		int mat = (int)(Math.random() * 100)+1;
		int sum = kor + eng + mat;
		int avg = sum / 3;
		double avgD = sum / 3.0;
		System.out.println("국어점수=" + kor);
		System.out.println("영어점수=" + eng);
		System.out.println("수학점수=" + mat);
		System.out.println("총점=" + sum);
		System.out.println("평균(정수)=" + avg);
		System.out.println("평균(실수)=" + avgD);
		
		// 90점 이상 A
		// 80점 이상 90점 미만 B 
		// 70점 이상 80점 미만 C
		// 60점 이상 70점 미만 D
		// 60점 미만 미수료
		if(avg>=90) {System.out.println("A등급");}
		else if(avg>=80) {System.out.println("B등급");}
		else if(avg>=70) {System.out.println("C등급");}
		else if(avg>=60) {System.out.println("D등급");}
		else {System.out.println("미수료");}
		
		int avg2 = avg / 10;
		switch(avg2) {
		case 9 :	System.out.println("A등급"); break;
		case 8 :	System.out.println("B등급"); break;
		case 7 :	System.out.println("C등급"); break;
		case 6 :	System.out.println("D등급"); break;
		default : System.out.println("미수료");
		}
	}

}
