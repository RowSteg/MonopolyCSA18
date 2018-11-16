import java.util.Scanner;

import processing.core.*;
public class Graphic extends PApplet {

	private static Gameboard board;
	private static int playNum;
	private static Player[] play;
	private char side = 'l';
	private static int spae = 10;
	
	public static void main(String[] args) { 
		
		PApplet.main("Graphic");
		//doGraphic();
	} 
	
	public static void setBoard(Gameboard boardT) {
		board = boardT;
	}
	
	public void settings() {
		size(550,700);
	}
	public void setup() { 
		play = new Player[playNum];
		for(int i=0; i<playNum; i++) { //Creates Players
			Scanner in = new Scanner(System.in);
			System.out.println("Name:");
			String nam = in.nextLine();
			Scanner in2 = new Scanner(System.in);
			System.out.println("Color:");
			String col = in2.nextLine();
			
			play[i] = new Player(nam,col);
		}
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
		
		for(int i = 0; i<playNum; i++) {
			drawPlayer(spae,side,play[i]);
		}
		
		//Switching sides for movement
		if(spae == 0 && side == 'l') {
			side = 't';
			spae = 0;
		}
		if(spae == 10 && side == 't') {
			side = 'r';
			spae = 0;
		}
		if(spae == 10 && side == 'r') {
			side = 'b';
			spae = 0;
		}
		
		rect(550,0,275,75);
		
		line(275,550,275,700);
		line(0,625,550,625);
		
		textSize(40);
		fill(0);
		text("Roll Dice",50,600);
		
		if(0<mouseX && mouseX<275 && 550<mouseY && mouseY<625 && mousePressed) {
			int[] option = Dice.rollDice();
			
			play[1].playMove(option[0]+option[1]);
		}
	}
	
	public static void setSpae(int x) {
		spae = x;
	}
	
	public static void setPlayNum(int x) {
		playNum = x;
	}
	
	public static Player[] getPlayers() {
		return play;
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
			case "GRAY":
				fill(100);
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
	
	public void sides(Gameboard board) {
		
		for (int i=1;i<=9;i++) {
			Space spac = board.getSpace(i,0);
			if (spac instanceof Property) {
				Property prop = (Property)spac;
				String color = prop.getColor();
				int num = prop.getLevel();
				drawProp(i,'t',color);
				drawHouse(i,'t',num);
			}
			
		}
		for (int i=1;i<=9;i++) {
			Space spac = board.getSpace(0,i);
			if (spac instanceof Property) { 
				Property prop = (Property)spac;
				String color = prop.getColor();
				int num = prop.getLevel();
				drawProp(i,'l',color);
				drawHouse(i,'t',num);
			}
			
		}
		for (int i=1;i<=9;i++) {
			Space spac = board.getSpace(i,10);
			if (spac instanceof Property) {
				Property prop = (Property)spac;
				String color = prop.getColor();
				int num = prop.getLevel();
				drawProp(i,'b',color);
				drawHouse(i,'t',num);
			}
			
		}
		for (int i=1;i<=9;i++) {
			Space spac = board.getSpace(10,i);
			if (spac instanceof Property) {
				Property prop = (Property)spac;
				String color = prop.getColor();
				int num = prop.getLevel();
				drawProp(i,'r',color);
				drawHouse(i,'t',num);
			}
			
		}
	}
	public void drawHouse(int x,char s, int n) { //takes in the position on the side as an int, the side as a char, and the number of house it is(ex: 2nd house on that property)
		fill(28, 219, 47);	//sets to green color
		if(n!=0) {
			if(n>=5) {	//if it's greater than 4 houses it'll just make 1 hotel
				drawHotel(x,s);
			}
			else {
				for(int i=0;i<n;i++) {	//makes as many houses as it needs
					if(s=='t')
						rect(x*50+6+(i*10),41,8,8);
					if(s=='l')
						rect(41,x*50+6+(i*10),8,8);
					if(s=='b')
						rect(x*50+6+(i*10),501,8,8);
					if(s=='r')
						rect(501,x*50+6+(i*10),8,8);
				}
			}
		}
	}
	public void drawHotel(int x,char s) {	//takes in the position on the side as int, the side it's on as char
		fill(221, 5, 5);	//sets to red color
		if(s=='t')
			rect(x*50+15,41,20,8);
		if(s=='l')
			rect(41,x*50+15,8,20);
		if(s=='b')
			rect(x*50+15,501,20,8); 
		if(s=='r')
			rect(501,x*50+15,8,20);
	}
	public void drawPlayer(int x,char s,Player play) {	//takes in the position on the side as int, the side it's on as char, and the player object
		
	switch (play.getColor()) {									//set the color to the property's color
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
		case "GRAY":
			fill(100);
			break;
		default:
			fill(0);
	}
		/*if(x==0&&s=='t'&&!play.inJail) {
			ellipse(10,10,15,15);
		} 
		else {*/
			if(s=='t')
				ellipse(x*50+25,25,15,15);
			if(s=='l')
				ellipse(25,x*50+25,15,15);
			if(s=='b')
				ellipse(x*50+25,525,15,15);
			if(s=='r')
				ellipse(525,x*50+25,15,15);
		//}
	}

	public static int getSpae() {
		return spae;
	}
}
