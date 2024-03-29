import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public abstract class GameObject {

	protected float x, y;
	protected ID id;
	protected float velX;
	protected float velY;

	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;

	}

	public abstract void tick();

	public abstract void render(Graphics g);
	
	public abstract Rectangle2D getBounds();

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

}
