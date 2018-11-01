import java.util.Arrays;

public class Dice {
	
	public Dice() {
		
	}
	public int[] rollDice() {
		return new int[]{1 + (int)(Math.random() * 6), 1 + (int)(Math.random() * 6)};
	}
	public static void main(String[] args) {
		Dice dice = new Dice();
		System.out.println(Arrays.toString(dice.rollDice()));
	}
}
