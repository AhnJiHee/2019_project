package kapitel_15;

import java.util.HashMap;

class Student{
	private int id;
	private String name;
	private int kor, eng, mat, sum, avg;
	
	public Student(int id, String name, int kor, int eng, int mat) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
//		sum = kor + eng + mat;
//		avg = sum / 3;
	}
	
	public String toString() {
		return id + " - " + name + " - " + kor + " - " + eng + " - " + mat
				+ " - " + sum + " - " + avg;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	
}


public class StudentMapTest {

	public static void main(String[] args) {
		Student st1 = new Student(1000, "김태리", 88, 77 , 99);
		Student st2 = new Student(2000, "송혜교", 68, 89 , 99);
		Student st3 = new Student(3000, "전지현", 100, 7, 99);
		Student st4 = new Student(4000, "이자바", 56, 77 , 23);
		
		//HashMap stuMap 변수 선언
		HashMap<Integer, Student> stuMap = new HashMap<Integer, Student>();
		stuMap.put(st1.getId(), st1);
		stuMap.put(st2.getId(), st2);
		stuMap.put(st3.getId(), st3);
		stuMap.put(st4.getId(), st4);
		//stuMap 4개 객체 저장 (st1.id, stl)
		
		// stuMap 각각 개체의 총점과 평균 -> sum, avg에 저장
		//
		System.out.println("학번 - 이름 - 국어 - 영어 - 수학 - 총점 - 평균");
		for ( Integer a : stuMap.keySet()) {
			Student st = stuMap.get(a);
			st.setSum (st.getKor() + st.getEng() + st.getMat());
			st.setAvg (st.getSum() / 3);
			System.out.println(stuMap.get(a));
		}
		

	}

}
