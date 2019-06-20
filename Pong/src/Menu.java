import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;









public class Menu extends JFrame {

	Game game;
	Handler handler;
	
	public Menu(String title, Game game, Handler handler) {
		super(title);
		this.game = game;
		this.handler = handler;
		
		
		JFrame frame = new JFrame(title);
		
		JButton playButton = new JButton("Play!");
		JButton difficultyButton = new JButton("Choose Difficulty");
		JButton helpButton = new JButton("Help");
		
		playButton.setBounds(Game.WIDTH/2 - 70,100,140,40);
		
		
		frame.add(playButton);
		frame.setLayout(null);
		
		frame.getContentPane().setBackground(Color.black);
		
		
		frame.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		frame.setMaximumSize(new Dimension (Game.WIDTH, Game.HEIGHT));
		frame.setMinimumSize(new Dimension (Game.WIDTH, Game.HEIGHT));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		
		
		playButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				game.gameState = STATE.Game;
				
				handler.addObject(new Player(20, Game.HEIGHT / 2 - 50, ID.Player, handler));
				handler.addObject(new Ball(300, 300, ID.Ball, handler));
				handler.addObject(new EnemyPlayer(Game.WIDTH - 20, HEIGHT / 2 - 50, ID.EnemyPlayer, handler));
				
				new Window(Game.WIDTH, Game.HEIGHT, "Pong", game);
				
				//frame.setVisible(false);
				
			}
		});
		
	}
	
	
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		
		
	}

}
