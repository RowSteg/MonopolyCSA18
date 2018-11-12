
public class GameRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gameboard yeet = new Gameboard("RawSpacesList.txt");
		Graphic g = new Graphic();
		g.doGraphic();
		System.out.println("test");
		System.out.println(yeet.toString()); 
	}

}
