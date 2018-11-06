import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gameboard {
	private Space[][] board;
	
	public Gameboard(String inFile){
		try {
			Scanner in = new Scanner(new File(inFile));
			
			int row = 10;
			int col = 10;
			
			while(col>=0) {
				
				
				col--;
			}
			
			while(row>=0) {
				
				
				row--;
			}
			
			while(col<=10) {
				
				
				col++;
			}
			
			while(row<10) {
				
				
				row++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
