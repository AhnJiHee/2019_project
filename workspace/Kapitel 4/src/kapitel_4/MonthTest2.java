package kapitel_4;

public class MonthTest2 {

	public static void main(String[] args) {
		int month = (int)(Math.random()*12) +1;
		switch(month) {
		case 1: //System.out.println(month + "월은 31일까지 존재합니다"); break;
		case 3: //System.out.println(month + "월은 31일까지 존재합니다"); break;
		case 5: //System.out.println(month + "월은 31일까지 존재합니다"); break;
		case 7: //System.out.println(month + "월은 31일까지 존재합니다"); break;
		case 8: //System.out.println(month + "월은 31일까지 존재합니다"); break;
		case 10: //System.out.println(month + "월은 31일까지 존재합니다"); break;
		case 12: System.out.println(month + "월은 31일까지 존재합니다"); break;
		case 4: //System.out.println(month + "월은 30일까지 존재합니다"); break;
		case 6: //System.out.println(month + "월은 30일까지 존재합니다"); break;
		case 9: //System.out.println(month + "월은 30일까지 존재합니다"); break;
		case 11: System.out.println(month + "월은 30일까지 존재합니다"); break;
		case 2: System.out.println(month + "월은 28일까지 존재합니다"); break;
		}
		
		System.out.println("=========");
		
		switch(month) {
		case 4: case 6: case 9: case 11:
			System.out.println(month + "월은 30일까지 존재합니다"); break;
		case 2:
			System.out.println(month + "월은 28일까지 존재합니다"); break;
		default:
			System.out.println(month + "월은 31일까지 존재합니다"); break;
		}
		
		System.out.println("=========");
		
		if (month == 2) {System.out.println(month + "월은 28일까지 존재합니다");}
		else if (month == 4) {System.out.println(month + "월은 30일까지 존재합니다");}
		else if (month == 6) {System.out.println(month + "월은 30일까지 존재합니다");}
		else if (month == 9) {System.out.println(month + "월은 30일까지 존재합니다");}
		else if (month == 11) {System.out.println(month + "월은 30일까지 존재합니다");}
		else {System.out.println(month + "월은 31일까지 존재합니다");}
		


		

	}

}
