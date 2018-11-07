import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gameboard {
	private Space[][] board;
	
	public Gameboard(String inFile){
		board = new Space[11][11];
		try {
			ArrayList<String[]> properties = new ArrayList<String[]>();
			Scanner in = new Scanner(new File(inFile));
			while(in.hasNextLine()) {
				properties.add(in.nextLine().split(","));
			}
			
			for(int i = 0; i<properties.size(); i++) { //Instantiates all properties into board
				String[] temp = properties.get(i);
				board[Integer.parseInt(temp[10])][Integer.parseInt(temp[11])]
						= new Property(
								temp[0], //name of property
								Integer.parseInt(temp[11]), //xPos
								Integer.parseInt(temp[10]), //yPos
								temp[9], //color of property
								Integer.parseInt(temp[1]), //price
								Integer.parseInt(temp[2]), //house cost
								Integer.parseInt(temp[3]), //level 0 rent (base)
								Integer.parseInt(temp[4]), //level 1 rent
								Integer.parseInt(temp[5]), //level 2 rent
								Integer.parseInt(temp[6]), //level 3 rent
								Integer.parseInt(temp[7]), //level 4 rent
								Integer.parseInt(temp[8])   //level 5 rent (hotel)
						);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Space[][] getBoard() {
		return board.clone();
	}
}
