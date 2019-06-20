import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

public class Ball extends GameObject {

	Handler handler;
	HUD hud;

	public Ball(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		velX = -4;
		velY = 5;
		this.handler = handler;
	}

	public void tick() {
		x += velX;
		y += velY;

		if (y <= 0 || y >= Game.HEIGHT - 50)
			velY *= -1;

		score();

		if (x <= 0 || x >= Game.WIDTH - 32)
			velX *= -1;

		collision();

	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code

					// this.velX *= -1;
					// this.velY *= -1;
				}
			}

		}
	}

	private void score() {

		if (x <= 0) {

			hud.setComScore(hud.getComScore() + 1);

			this.x = Game.WIDTH / 2;
			this.y = (Game.HEIGHT / 2) - 100;

			velX = 4;
			velY = 3;

		}

		if (x >= Game.WIDTH - 32) {
			hud.setPlayerScore(hud.getPlayerScore() + 1);

			this.x = Game.WIDTH / 2;
			this.y = (Game.HEIGHT / 2) - 100;

			velX = -4;
			velY = 3;
		}

	}

	public void render(Graphics g) {

		g.setColor(Color.yellow);
		g.fillRect((int) x, (int) y, 16, 16);

	}

	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, 16, 16);
	}

}
