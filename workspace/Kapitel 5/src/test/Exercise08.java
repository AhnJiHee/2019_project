package test;

public class Exercise08 {

	public static void main(String[] args) {
			int [][] array = {
					{95, 86},
					{83, 92, 96},
					{78, 83, 93, 87, 88},		
			};
			int sum = 0;
			double avg = 0.0;
		
			System.out.println(array[0][0]+array[0][1]);
			System.out.println(array[0].length);

			
			for (int i=0; i< array.length; i++) {
				for (int k=0; k<array[i].length; k++) {
					sum += array[i][k];
				}
			}
			avg = sum / 10.0;
			
			System.out.println("sum : " + sum);
			System.out.println("avg : " + avg);
			
	}

}
