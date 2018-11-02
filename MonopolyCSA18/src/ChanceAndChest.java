
public class ChanceAndChest {
	
	private String title;
	private int moneyChange;
	
	public ChanceAndChest(String title, int moneyChange) {
		
	}
	
	public void Charge(Player player1){
		player1.setAmountOfMoney(player1.getAmountOfMoney() + moneyChange);
	}
}
