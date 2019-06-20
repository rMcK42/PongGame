import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class EnemyPlayer extends GameObject {

	private static final float MAXBOUNCEANGLE = (float) 0.75;



	Handler handler;

	

	private float scale_constant = (float) 0.03;
	

	public EnemyPlayer(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {

		x += velX;
		y += velY;
		
		
		
		x = Game.clamp(x, 0, Game.WIDTH - 48);
		y = Game.clamp(y, 0, Game.HEIGHT - 140);

		enemyMove();
		collision();
	}
	
	private void enemyMove() {
		
		//code for how enemy moves
		
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Ball) {
				
				if(tempObject.getBounds().getCenterY() > this.y + 50 && tempObject.x > Game.WIDTH /2) {
					this.y = this.y + 4;
				}
				if(tempObject.getBounds().getCenterY() < this.y + 50 && tempObject.x > Game.WIDTH /2) {
					this.y = this.y - 4;
				}
			}
		}
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Ball) {

				if (tempObject.getBounds().intersects(this.x, this.y, 10, 0.1)
						|| tempObject.getBounds().intersects(this.x, this.y + 100, 10, 0.1)) {
					 //collision code
					tempObject.setVelY(tempObject.getVelY() * -1);
					
					
					
					

				}
				if (tempObject.getBounds().intersects(this.x, this.y, 0.1, 100)
						|| tempObject.getBounds().intersects(this.x + 10, this.y, 0.1, 100)) {
					// collision code
					
					tempObject.setVelX(tempObject.getVelX() * -1);
					float relativeIntersectY = (float) ((this.y+(100/2)) - tempObject.getBounds().getCenterY());
					float normalizedRelativeIntersectionY = (relativeIntersectY/(100/2));
					float bounceAngle = normalizedRelativeIntersectionY * MAXBOUNCEANGLE;
					
					tempObject.velX = (float) (-10 * Math.cos(bounceAngle));
					tempObject.velY = (float) (-10 *-Math.sin(bounceAngle));
			}
			

			}
		}
	}

	public void render(Graphics g) {

		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 10, 100);
	}

	public Rectangle2D getBounds() {

		return new Rectangle2D.Float(x, y, 300, 300);
	}

}
