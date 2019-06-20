import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	Handler handler = new Handler();

	private static int playerScore;
	private static int comScore;

	public void tick() {
		
		

	}

	public void render(Graphics g) {
		g.setColor(Color.green);

		// g.fillRect(15, 15, 200, 32);

		g.drawString("Player Score: " + playerScore, 15, 15);
		g.drawString("Computer Score: " + comScore, 850, 15);
	}

	public void scoreKeeper() {

		

	}

	public static int getPlayerScore() {
		return playerScore;
	}

	public static void setPlayerScore(int playerScore) {
		HUD.playerScore = playerScore;
	}

	public static int getComScore() {
		return comScore;
	}

	public static void setComScore(int comScore) {
		HUD.comScore = comScore;
	}

}
