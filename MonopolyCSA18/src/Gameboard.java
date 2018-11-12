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
				if(temp.length == 12 && !temp[9].equals("GRAY")) { //initializes all property types
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
				}else if(temp.length == 12 && temp[9].equals("GRAY")) { //initializes all railroad types
					board[Integer.parseInt(temp[10])][Integer.parseInt(temp[11])]
							= new Railroad(
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
				}else if(temp.length == 5 && temp[4].equals("UTIL")) { //initializes all utility types
					board[Integer.parseInt(temp[2])][Integer.parseInt(temp[3])]
							= new Utility(
									temp[0], //name of property
									Integer.parseInt(temp[3]), //xPos
									Integer.parseInt(temp[2]), //yPos
									Integer.parseInt(temp[1]) //price
							);
				}else if(temp.length == 5 && temp[4].equals("TAX")) { //initializes all tax types
					board[Integer.parseInt(temp[2])][Integer.parseInt(temp[3])]
							= new Tax(
									temp[0], //name of property
									Integer.parseInt(temp[3]), //xPos
									Integer.parseInt(temp[2]), //yPos
									Integer.parseInt(temp[1]) //price
							);
				}else if(temp.length == 5 && temp[4].equals("CC")) { //initializes community chest and chance types
					board[Integer.parseInt(temp[2])][Integer.parseInt(temp[3])]
							= new ChanceChest(
									temp[0], //name of property
									Integer.parseInt(temp[3]), //xPos
									Integer.parseInt(temp[2]), //yPos
									temp[1] //chance or chest
							);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
	}
	public Space getSpace(int xPos,int yPos) {
		return board[yPos][xPos];
	}
	public Space[][] getBoard() {
		return board.clone();
	}
	
	public String toString() {
		String fin = "";
		
		int row = 9;
		int col = 0;
		
		while(row>=1) {
			fin+=board[row][col].getName() + "\n";

			row--;
		}
		
		row = 0;
		col = 1;
		
		
		while(col<=9) {
			fin+=board[row][col].getName() + "\n";
			
			col++;
		}
		
		row = 1;
		col = 10;
		
		while(row<=9) {
			fin+=board[row][col].getName() + "\n";
			
			row++;
		}
		
		row = 10;
		col = 9;
		
		while(col>=1) {
			fin+=board[row][col].getName() + "\n";
			
			col--;
		}
		
		
		return fin;
	}
}
