import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Player extends GameObject {

	private static final float MAXBOUNCEANGLE = (float) 0.75;

	Handler handler;

	private float scale_constant = (float) 0.03;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {

		x += velX;
		y += velY;

		x = Game.clamp(x, 0, Game.WIDTH - 100);
		y = Game.clamp(y, 0, Game.HEIGHT - 140);

		collision();
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Ball) {

				if (tempObject.getBounds().intersects(this.x, this.y, 10, 0.1)
						|| tempObject.getBounds().intersects(this.x, this.y + 100, 10, 0.1)) {
					// collision code
					tempObject.setVelY(tempObject.getVelY() * -1);

				}
				if (tempObject.getBounds().intersects(this.x, this.y, 0.1, 100)
						|| tempObject.getBounds().intersects(this.x + 10, this.y, 0.1, 100)) {
					// collision code

					// tempObject.setVelX(tempObject.getVelX() * -1);
					// tempObject.velY += scale_constant * (tempObject.getBounds().getCenterY() -
					// ((this.y + 100) / 2) );

					// Game.clamp(tempObject.velY, -6, 6);
					
					float relativeIntersectY = (float) ((this.y+(100/2)) - tempObject.getBounds().getCenterY());
					float normalizedRelativeIntersectionY = (relativeIntersectY/(100/2));
					float bounceAngle = normalizedRelativeIntersectionY * MAXBOUNCEANGLE;
					
					tempObject.velX = (float) (10 * Math.cos(bounceAngle));
					tempObject.velY = (float) (10 *-Math.sin(bounceAngle));
				}

			}
		}
	}

	public void render(Graphics g) {

		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, 10, 100);
	}

	public Rectangle2D getBounds() {

		return new Rectangle2D.Float(x, y, 300, 300);
	}

}
