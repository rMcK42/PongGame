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

	EnemyPlayer enemyPlayer;

	private int speed = 4;

	public Menu(String title, Game game, Handler handler, EnemyPlayer enemyPlayer) {
		super(title);
		this.game = game;
		this.handler = handler;
		this.enemyPlayer = enemyPlayer;

		JFrame menuframe = new JFrame(title);
		JFrame difficultyFrame = new JFrame("Difficulty");

		// main menu //
		JButton playButton = new JButton("Play!");
		JButton difficultyButton = new JButton("Choose Difficulty");
		JButton helpButton = new JButton("Help");

		playButton.setBounds(Game.WIDTH / 2 - 70, 100, 140, 40);
		difficultyButton.setBounds(Game.WIDTH / 2 - 70, 200, 140, 40);
		helpButton.setBounds(Game.WIDTH / 2 - 70, 300, 140, 40);

		menuframe.add(playButton);
		menuframe.add(difficultyButton);
		menuframe.add(helpButton);

		menuframe.setLayout(null);

		menuframe.getContentPane().setBackground(Color.black);

		menuframe.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		menuframe.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		menuframe.setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));

		menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuframe.setResizable(false);
		menuframe.setLocationRelativeTo(null);

		menuframe.setVisible(true);

		// difficulty Menu //
		JButton easyButton = new JButton("Easy");
		JButton normalButton = new JButton("Normal");
		JButton hardButton = new JButton("Hard");

		easyButton.setBounds(Game.WIDTH / 2 - 70, 100, 140, 40);
		normalButton.setBounds(Game.WIDTH / 2 - 70, 200, 140, 40);
		hardButton.setBounds(Game.WIDTH / 2 - 70, 300, 140, 40);

		difficultyFrame.add(easyButton);
		difficultyFrame.add(normalButton);
		difficultyFrame.add(hardButton);

		difficultyFrame.setLayout(null);

		difficultyFrame.getContentPane().setBackground(Color.black);

		difficultyFrame.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		difficultyFrame.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		difficultyFrame.setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));

		difficultyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		difficultyFrame.setResizable(false);
		difficultyFrame.setLocationRelativeTo(null);

		// help Menu //

		playButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				game.gameState = STATE.Game;

				handler.addObject(new Player(20, Game.HEIGHT / 2 - 50, ID.Player, handler));
				handler.addObject(new Ball(300, 300, ID.Ball, handler));
				handler.addObject(new EnemyPlayer(Game.WIDTH - 20, HEIGHT / 2 - 50, ID.EnemyPlayer, handler, speed));

				new Window(Game.WIDTH, Game.HEIGHT, "Pong", game);

				// frame.setVisible(false);

			}
		});

		difficultyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				menuframe.setVisible(false);
				difficultyFrame.setVisible(true);

			}
		});

		helpButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		easyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.gameState = STATE.Game;
				
				speed = 2;

				handler.addObject(new Player(20, Game.HEIGHT / 2 - 50, ID.Player, handler));
				handler.addObject(new Ball(300, 300, ID.Ball, handler));
				handler.addObject(new EnemyPlayer(Game.WIDTH - 20, HEIGHT / 2 - 50, ID.EnemyPlayer, handler, speed));

				new Window(Game.WIDTH, Game.HEIGHT, "Pong", game);
			}
		});

		normalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.gameState = STATE.Game;
				speed = 4;

				handler.addObject(new Player(20, Game.HEIGHT / 2 - 50, ID.Player, handler));
				handler.addObject(new Ball(300, 300, ID.Ball, handler));
				handler.addObject(new EnemyPlayer(Game.WIDTH - 20, HEIGHT / 2 - 50, ID.EnemyPlayer, handler, speed));

				new Window(Game.WIDTH, Game.HEIGHT, "Pong", game);
			}
		});

		hardButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				game.gameState = STATE.Game;
				
				speed = 10;

				handler.addObject(new Player(20, Game.HEIGHT / 2 - 50, ID.Player, handler));
				handler.addObject(new Ball(300, 300, ID.Ball, handler));
				handler.addObject(new EnemyPlayer(Game.WIDTH - 20, HEIGHT / 2 - 50, ID.EnemyPlayer, handler, speed));

				new Window(Game.WIDTH, Game.HEIGHT, "Pong", game);
			}
		});

	}

	public void tick() {

	}

	public void render(Graphics g) {

	}

}
