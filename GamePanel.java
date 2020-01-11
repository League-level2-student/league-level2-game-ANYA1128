import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class GamePanel {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	public static BufferedImage image;
	public static BufferedImage imageBackground;
	public static boolean needImage = true;
	public static boolean gotImage = false;


	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font instructionsFont = new Font("Arial", Font.PLAIN, 23);
	Font scoreFont = new Font("Arial", Font.PLAIN, 35);

	//Rocketship rocket = new Rocketship(250, 700, 50, 50);
	//ObjectManager obj = new ObjectManager(rocket);

	GamePanel() {
		if (needImage) {
			loadImage("rocket.png");

		}
		frameDraw = new Timer(1000 / 100, this);
		frameDraw.start();
	}

	void startGame() {
		alienSpawn = new Timer(1000, obj);
		alienSpawn.start();

	}

	@Override
	public void paintComponent(Graphics g) {

		if (currentState == MENU) {
			drawMenuState(g);
		}

		else if (currentState == GAME) {
			drawGameState(g);

		}

		else if (currentState == END) {
			drawEndState(g);
			alienSpawn.stop();
		}
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				imageBackground = ImageIO.read(this.getClass().getResourceAsStream("background.jpg"));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	void updateMenuState() {
	}

	void updateGameState() {
		obj.update();
		if(rocket.isActive==false) {
			currentState=END;
		}
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 80);
		g.setFont(instructionsFont);
		g.drawString("Press ENTER to start", 130, 350);
		g.drawString("Press SPACE for instructions", 95, 600);
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(imageBackground, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}

		obj.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 97, 130);
		g.setFont(scoreFont);
		g.drawString("You killed "+obj.score+" enemies", 96, 350);
		g.setFont(instructionsFont);
		g.drawString("Press ENTER to restart", 120, 600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		repaint();
		if (currentState == MENU) {
			updateMenuState();
		}

		else if (currentState == GAME) {
			updateGameState();
		}

		else if (currentState == END) {
			updateEndState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
				Rocketship rocket2 = new Rocketship(250, 700, 50, 50);
				rocket = rocket2;
				ObjectManager obj2 = new ObjectManager(rocket2);
				obj = obj2;
			} else {
				currentState++;
			}
			
			if (currentState == GAME) {
				startGame();
			}
			
		}
			if(currentState==MENU) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				
					JOptionPane.showMessageDialog(null, "Welcome To League Invaders. Your mission is to kill all the aliens. To do so, press space to shoot and move your amazing rocket using the arrow keys. GOOD LUCK!!! ");
				}
			}
			
		
		if (currentState == GAME) {
		
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				obj.addProjectile(rocket.getProjectile());
			}
			if (e.getKeyCode() == KeyEvent.VK_UP && rocket.y >= 0) {
				System.out.println("UP");
				rocket.up();

			} else if (e.getKeyCode() == KeyEvent.VK_DOWN && rocket.y <= 710) {
				System.out.println("DOWN");
				rocket.down();

			} else if (e.getKeyCode() == KeyEvent.VK_LEFT && rocket.x >= 0) {
				System.out.println("LEFT");
				rocket.left();

			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && rocket.x <= 450) {
				System.out.println("RIGHT");
				rocket.right();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
