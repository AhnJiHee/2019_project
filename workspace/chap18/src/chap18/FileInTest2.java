package chap18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInTest2 {
public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {		
			fr = new FileReader(args[0]);	
			fw = new FileWriter(args[1]); 							
			int result = 0;
			int num = 1;
			fw.write((num++)+" : ");	
			while( (result = fr.read()) != -1) {	
				fw.write(result); 
				if(	result == '\n') {
					fw.write((num++)+" : ");	
				}
			}			
		}catch(IOException e){
			System.out.println(e.getMessage());			
		}finally {
			try {
				fr.close();
				fw.close(); 
			}catch(IOException e){ 	}
		}

}
}