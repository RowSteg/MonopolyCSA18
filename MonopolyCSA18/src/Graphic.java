import processing.core.PApplet;
public class Graphic extends PApplet {
	public static void main(String[] args) {
		
		Gameboard board = new Gameboard("RawSpacesList.txt");
		PApplet.main("Graphic");
	}

	
	public void settings() {
		size(550,550);
	}
	public void setup() {
		
	}
	public void draw() {
		fill(255);
		for(int i=0;i<550;i+=50) {
			rect(i,0,50,50);
			rect(0,i,50,50);
			rect(500,i,50,50);
			rect(i,500,50,50);
		}
		Gameboard board = new Gameboard("RawSpacesList.txt");
		sides(board);
	}
	public void drawProp(int i,char d,String c) {
		switch (c) {									//set the color to the property's color
			case "BROWN":
				fill(139,69,19);
				break;
			case "LT BLUE":
				fill(176,224,230);
				break;
			case "PURPLE":
				fill(255,20,147);
				break;
			case "ORANGE":
				fill(255,140,0);
				break;
			case "RED":
				fill(255,0,0);
				break;
			case "YELLOW":
				fill(255,255,0);
				break;
			case "GREEN":
				fill(0,128,0);
				break;
			case "DK BLUE":
				fill(0,0,255);
				break;
			default:
				fill(0);
		}
		
		if(d=='t')
			rect(i*50,40,50,10);
		if(d=='r')
			rect(500,i*50,10,50);
		if(d=='b')
			rect(i*50,500,50,10);
		if(d=='l')
			rect(40,i*50,10,50);
	}
	public char checkSide(int xPos,int yPos) {
		if (xPos==0) {
			return 'b';
		}
		if (xPos==10) {
			return 't';
		}
		if (yPos==0) {
			return 'l';
		}
		else {
			return 'r';
		}
		
	}
	public void sides(Gameboard board) {
		
		for (int i=1;i<=9;i++) {
			Space spac = board.getSpace(i,0);
			if (spac instanceof Property) {
				Property prop = (Property)spac;
				String color = prop.getColor();
				drawProp(i,'t',color);
			}
			
		}
		for (int i=1;i<=9;i++) {
			Space spac = board.getSpace(0,i);
			if (spac instanceof Property) {
				Property prop = (Property)spac;
				String color = prop.getColor();
				drawProp(i,'l',color);
			}
			
		}
		for (int i=1;i<=9;i++) {
			Space spac = board.getSpace(i,10);
			if (spac instanceof Property) {
				Property prop = (Property)spac;
				String color = prop.getColor();
				drawProp(i,'b',color);
			}
			
		}
		for (int i=1;i<=9;i++) {
			Space spac = board.getSpace(10,i);
			if (spac instanceof Property) {
				Property prop = (Property)spac;
				String color = prop.getColor();
				drawProp(i,'r',color);
			}
			
		}
	}
}
