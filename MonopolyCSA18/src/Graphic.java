import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import processing.core.*;
public class Graphic extends PApplet {

	private static Gameboard board;
	private static int playNum=1;
	private static Player[] play;
	private char side;
	private int[] option = {0,0};
	private boolean roll;
	private int turn = 1;
	private boolean owned;
	private Property prop;
	private boolean rolled = false;
	private static int space = 10;
	
	public static void main(String[] args) { 
		
		PApplet.main("Graphic");
		
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
			printColors();
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
			drawPlayer(playerPos(play[i]),playerSide(play[i]),play[i]);
		}
		
		//Switching sides for movement
		
		
		rect(550,0,275,75);
		
		line(275,550,275,700);
		line(0,625,550,625);
		
		textSize(40);
		fill(0); 
		text("Roll Dice",50,600);
		if(board.getSpace(0) instanceof Property) {		//this code is just for debugging the property get rid of it if it makes you angry
			drawDisplay((Property)board.getSpace(0));
		}
		
		text("End Turn",325,600);
		/*if(0<mouseX && mouseX<275 && 550<mouseY && mouseY<625 && roll) {
			option = Dice.rollDice();
			System.out.println(option[0] + option[1]);
			play[0].playMove(option[0] + option[1], board);
		}*/
		
		//System.out.println(play[turn-1].getName() + " has " + play[turn-1].getAmountOfMoney());
	}
	
	public static void setSpace(int x) {
		space = x;
	}
	
	public static void setPlayNum(int x) {
		playNum = x;
		
	}
	
	public static Player[] getPlayers() {
		return play;
	}
	
	public void drawProp(int i,char d,String c) {
		int temp[] = convertColor(c);
		fill(temp[0],temp[1],temp[2]);
		
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
			else if (spac instanceof ChanceChest) {
				ChanceChest cc = (ChanceChest)spac;
				
			}
			else if (spac instanceof Railroad) {
				Railroad rr = (Railroad)spac;
			}
			else if (spac instanceof Tax) {
				Tax tax = (Tax)spac;	
			}
			else {
				Space space = (Space)spac;
				if(space.getName().equals("Go")){
					textSize(50);
					text("GO", 520, 20);
				}
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
			else if (spac instanceof ChanceChest) {
				ChanceChest cc = (ChanceChest)spac;
				
			}
			else if (spac instanceof Railroad) {
				Railroad rr = (Railroad)spac;
			}
			else if (spac instanceof Tax) {
				Tax tax = (Tax)spac;	
			}
			else {
				Space space = (Space)spac;
				//if(space.getName().equals("Go")){
				fill(0);
					textSize(30);
					text("GO", 2, 535);
			//	}
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
			else if (spac instanceof ChanceChest) {
				ChanceChest cc = (ChanceChest)spac;
				
			}
			else if (spac instanceof Railroad) {
				Railroad rr = (Railroad)spac;
			}
			else if (spac instanceof Tax) {
				Tax tax = (Tax)spac;	
			}
			else {
				Space space = (Space)spac;
				if(space.getName().equals("Go")){
					textSize(50);
					text("GO", 520, 20);
				}
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
			else if (spac instanceof ChanceChest) {
				ChanceChest cc = (ChanceChest)spac;
				
			}
			else if (spac instanceof Railroad) {
				Railroad rr = (Railroad)spac;
			}
			else if (spac instanceof Tax) {
				Tax tax = (Tax)spac;	
			}
			else {
				Space space = (Space)spac;
				if(space.getName().equals("Go")){
					textSize(50);
					text("GO", 520, 20);
				}
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
		int c[] = convertColor(play.getColor());
		fill(c[0],c[1],c[2]);
	
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

	public static int getSpace() {
		return space;
	}
	public void drawDisplay(Property proper) {
		prop = proper;
		
		int c[] = convertColor(prop.getColor());
		fill(255);
		rect(175,125,200,300);
		fill(c[0],c[1],c[2]);
		rect(175,125,200,50);
		fill(0);
		textSize(20);
		if(prop.getName().length()<=15)
			text(prop.getName(),200,160);
		else {
			textSize(15);
			text(prop.getName(),200,160);
		}
		text("RENT: $"+prop.getRent(),220,210);	//print Rent 
		textSize(15);
		text("Purchase Cost:          $"+prop.getPrice(),180,235);
		if(!prop.getColor().equals("GRAY"))
			text("House Cost:              $"+prop.getHousePrice(),180,255);	//prints house cost
		text("Mortgage Value:        $"+prop.getPrice()/2,180,275);				//prints mortgage value
		if(prop.isOwned()) {
			int pc[] =convertColor(prop.getOwner().getColor());			
			//fill(pc[0],pc[1],pc[2]);
			fill(0);
			text("Owned By: "+prop.getOwner().getName(),200,305);				//prints player name in their color
			if(prop.getOwner() != play[turn-1]) {
				play[turn-1].setAmountOfMoney(play[turn-1].getAmountOfMoney() - prop.getRent());
				prop.getOwner().setAmountOfMoney(prop.getOwner().getAmountOfMoney() + prop.getRent());
			}
		}
		else {
			text("Owned By: Nobody",200,305);
			fill(255);
			rect(200, 350, 150, 50);
			textSize(22);
			fill(0);
			text("Buy Property", 210, 380);
			owned = false;
		}
	}
	public void clearDisplay() {
		noStroke();
		fill(205);
		rect(100, 100, 350, 350);
		stroke(0);
	}
	public static void printColors() {
		System.out.println("color options:");
		try {
			Scanner input = new Scanner(new File("colors.txt"));
			
			while(input.hasNextLine()) {
				String[] c=input.nextLine().split(",");
				for(int i=0;i<c.length;i+=4) {
					System.out.print(c[i]+", ");
					
				}
			
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	public static int[] convertColor(String color){			//takes in name of color and gives an array of rgb values of that color. note: All caps pls
		try {
			Scanner input = new Scanner(new File("colors.txt"));
			
			while(input.hasNextLine()) {
				String[] c=input.nextLine().split(",");
				for(int i=0;i<c.length;i++) {
					if(c[i].equals(color.toLowerCase())) {
						return new int[] {Integer.parseInt(c[i+1]),Integer.parseInt(c[i+2]),Integer.parseInt(c[i+3])};
					}
				}
			
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return new int[] {0,0,0};
		
	}
	public char playerSide(Player play) {
		int xpos=play.getXPos();
		int ypos=play.getYPos();
		char side =' ';
		if(xpos==0) {
			side='l';

		}
		else if(ypos==0) {
			side='t';

		}
		else if(xpos==10) {
			side='r';

		}
		else if(ypos==10) {
			side='b';

		}

		return side;
		
	}
	public int playerPos(Player play) {
		int xpos=play.getXPos();
		int ypos=play.getYPos();
		int pos=0;
		if(xpos==0) {

			pos=ypos;
		}else if(ypos==0) {
	
			pos=xpos;
		}else if(xpos==10) {
	
			pos=ypos;
		}else if(ypos==10) {

			pos=xpos;
		}
		return pos;
		
	}
	
	public void mouseClicked() {
		if(0<mouseX && mouseX<275 && 550<mouseY && mouseY<625 && rolled  == false) {
			option = Dice.rollDice();
			play[turn-1].playMove(option[0] + option[1], board);
			if(board.getSpace(play[turn-1].getSpace()) instanceof Property) {		//this code is just for debugging the property get rid of it if it makes you angry
				//clearDisplay();
				drawDisplay((Property)board.getSpace(play[turn-1].getSpace()));
			}else {
				clearDisplay();
			}
			
			rolled = true;
			System.out.println("dice rolled");
		}
		
		if(200<mouseX && mouseX<350 && 350<mouseY && mouseY<400 && rolled) {
			owned = true;
			prop.setOwner(play[turn-1]);
			play[turn-1].setAmountOfMoney(play[turn-1].getAmountOfMoney() - prop.getPrice());
			if(board.getSpace(play[turn-1].getSpace()) instanceof Property) {		//this code is just for debugging the property get rid of it if it makes you angry
				//clearDisplay();
				drawDisplay((Property)board.getSpace(play[turn-1].getSpace()));
			}else {
				clearDisplay();
			}
			
			System.out.println("property bought");
			System.out.println(play[turn-1].getName() + " has " + play[turn-1].getAmountOfMoney());
			/*
			turn++;
			if(turn > playNum) {
				turn = 1;
			}
			*/
		}
		
		if(275<mouseX && mouseX<550 && 550<mouseY && mouseY<625) {
			if(playNum <= 1) {
				System.out.println(play[turn-1].getName() + " has won with " + play[turn-1].getAmountOfMoney() + "!");
				rolled = true;
			}
			System.out.println(play[turn-1].getName() + " has " + play[turn-1].getAmountOfMoney());
			if(play[turn-1].getAmountOfMoney() <=0) {
				System.out.println(play[turn-1].getName() + " has lost");
				turn++;
				while(turn <= playNum) {
					System.out.println(play[turn-1].getName() + " has " + play[turn-1].getAmountOfMoney());
					turn++;
				}
				
				turn = 1;
				Player[] temp = new Player[playNum-1];
				for(int i=0,j=0; i<playNum; i++) { //Creates Players
					if(play[i].getAmountOfMoney() > 0) {
						temp[j] = play[i];
						j++;
					}
				}
				playNum--;
				play = temp;
				
				if(playNum <= 0) {
					System.out.println(play[turn-1].getName() + " has won with " + play[turn-1].getAmountOfMoney() + "!");
				}
				rolled = false;
				
			}else {
				turn++;
				if(turn > playNum) {
					turn = 1;
				}
				rolled = false;
			}
			System.out.println("turn ended");
		}
	}
}


