import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gameboard {
	private ArrayList<Space> board;
	 
	public Gameboard(String inFile){
		board = new ArrayList<Space>();
		try {
			ArrayList<String[]> properties = new ArrayList<String[]>();
			Scanner in = new Scanner(new File(inFile));
			while(in.hasNextLine()) {
				properties.add(in.nextLine().split(","));
			}
			
			for(int i = 0; i<properties.size(); i++) { //Instantiates all properties into board
				String[] temp = properties.get(i);
				if(temp.length == 12 && !temp[9].equals("GRAY")) { //initializes all property types
					board.add(new Property(
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
							));	
				}else if(temp.length == 12 && temp[9].equals("GRAY")) { //initializes all railroad types
					board.add(new Railroad(
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
							));	
				}else if(temp.length == 5 && temp[4].equals("UTIL")) { //initializes all utility types
					board.add(new Utility(
									temp[0], //name of property
									Integer.parseInt(temp[3]), //xPos
									Integer.parseInt(temp[2]), //yPos
									Integer.parseInt(temp[1]) //price
							));
				}else if(temp.length == 5 && temp[4].equals("TAX")) { //initializes all tax types
					board.add(new Tax(
									temp[0], //name of property
									Integer.parseInt(temp[3]), //xPos
									Integer.parseInt(temp[2]), //yPos
									Integer.parseInt(temp[1]) //price
							));
				}else if(temp.length == 5 && temp[4].equals("CC")) { //initializes community chest and chance types
					board.add(new ChanceChest(
									temp[0], //name of property
									Integer.parseInt(temp[3]), //xPos
									Integer.parseInt(temp[2]), //yPos
									temp[1] //chance or chest
							));
				}else if(temp.length == 3) { //initializes corners
					board.add(new Space(
								temp[0], //name
								Integer.parseInt(temp[2]), //xPos
								Integer.parseInt(temp[1])  //yPos
							));
				}

			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch  block
			e.printStackTrace(); 
		}
		
	}
	
	public Space getSpace(int x, int y) {
		for(int i = 0; i < board.size(); i++) {
			if(board.get(i).getXPos() == x && board.get(i).getYPos() == y) {
				return board.get(i);
			}
		}
		return null;
	}
	
	public Space getSpace(int spaceNum) {
		return board.get(spaceNum);
	}
	
	public int getPosition(Space space) {
		for(int i = 0; i < board.size(); i++) {
			if(space.getName().equals(board.get(i).getName())) {
				return i;
			}
		}
		return 0;
	}
	
	public ArrayList<Space> getBoard() {
		return (ArrayList<Space>) board.clone();
	}
	
	public String toString() {
		String fin = "";
		
		for(int i = 0; i<board.size(); i++) {
			fin+=board.get(i).getName() + "\n";
		}		
		
		return fin;
	}
}
