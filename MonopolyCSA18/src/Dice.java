public class Dice {
	
	public Dice() {
	}
	
	public static int[] rollDice() {
		 return new int[]{1 + (int)(Math.random() * 6), 1 + (int)(Math.random() * 6)};
		 
	}
	
} 
