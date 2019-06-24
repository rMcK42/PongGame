import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 499776485135926340L;

	public static final int WIDTH = 1000, HEIGHT = 750;

	private Thread thread;

	private boolean running = false;
	
	

	private Handler handler;
	private HUD hud;
	private Menu menu;
	private EnemyPlayer enemyPlayer;

	

	
	
	public static STATE gameState = STATE.Menu;
	
	
	public Game() {

		handler = new Handler();
		
		Menu menu = new Menu("Pong", this, handler, enemyPlayer);
		
		this.addKeyListener(new KeyInput(handler));

		//new Window(WIDTH, HEIGHT, "Pong", this);

		hud = new HUD();
		
		
		if (gameState == STATE.Menu) {
			
			
			//menu.setSize(WIDTH,HEIGHT);
			
			//menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//menu.setVisible(true);
		}else if(gameState == STATE.Game) {
			
			//new Window(WIDTH, HEIGHT, "Pong", this);
			
		//	handler.addObject(new Player(20, HEIGHT / 2 - 50, ID.Player, handler));
			//handler.addObject(new Ball(300, 300, ID.Ball, handler));
			//handler.addObject(new EnemyPlayer(WIDTH - 20, HEIGHT / 2 - 50, ID.EnemyPlayer, handler));
		} 
	
	
		
		
		

	}



	public synchronized void start() {

		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {

		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {

		this.requestFocus();

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		handler.tick();
		
		if(gameState == STATE.Game) {
			hud.tick();
		} else if(gameState == STATE.Menu) {
			
		}
		
		
		
		
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);
		
		if(gameState == STATE.Game) {
			
			hud.render(g);
		}else if(gameState == STATE.Menu) {
			
		}
		
		
	
		
		
		
		g.dispose();
		bs.show();
	}
	


	public static float clamp(float var, float min, float max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Game();

	}

}
