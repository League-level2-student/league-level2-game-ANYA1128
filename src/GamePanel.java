import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	int WIDTH = 1000;
	int HEIGHT = 1000;
	int currentState = MENU;
	Timer timer;
	
	static final int yvalue = new Random().nextInt(800-300)+400;
	public static BufferedImage image;
	public static BufferedImage image2;
	public static BufferedImage image3;
	public static BufferedImage rock;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	Font titleFont = new Font("Comic Sans", Font.PLAIN, 48);
	Font instructionsFont = new Font("Comic Sans", Font.PLAIN, 23);
	Font scoreFont = new Font("Comic Sans", Font.PLAIN, 35);
	
	Dog dog = new Dog(100, 840, 100, 100);
	ObjectManager obj = new ObjectManager(dog);
	Rock theRock = new Rock(Rock.rockXValue, Rock.rockStartingHeight);

	GamePanel() {
		loadImage();
		//frame.addKeyListener(this);
		//repaint();
		startGame();
		
	}

	public void startGame() {
		timer = new Timer(1000 / 60, this);
		timer.start();

	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU) {
			drawMenuState(g);
		}
		if (currentState == GAME) {
			drawGameState(g);
		}

		
		}
	

	void loadImage() {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream("background.jpg"));
				image2 = ImageIO.read(this.getClass().getResourceAsStream("download.png"));
				image3 = ImageIO.read(this.getClass().getResourceAsStream("river.jpg"));
				rock = ImageIO.read(this.getClass().getResourceAsStream("rock.png"));

				
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	void updateMenuState() {
		
	}

	void updateEndState() {
		
	}
	void updateGameState() {
		obj.update();
		
		
	}

	void drawMenuState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, Game.WIDTH, Game.HEIGHT, null);
			g.drawImage(image2, 400, 600, 200, 200, null);
			g.setFont(titleFont);
			g.setColor(Color.BLACK);
			g.drawString("INSERT GAME NAME HERE", 380, 100);
			g.setFont(instructionsFont);
			g.drawString("Press ENTER to start", 570, 300);
			g.drawString("Press SPACE for instructions", 530, 400);

		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}

	}

	void drawGameState(Graphics g) {
		
		g.drawImage(image3, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		obj.draw(g);
		
		
		
			
		
		
		
		
		this.repaint();
		
	}

	void drawEndState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
		
		
		if(currentState==GAME) {
			updateGameState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			
				JOptionPane.showMessageDialog(null,
						"Welcome to the Game. This dog has lost its owner and has to return safely. In order to do so, it has to cross the river, avoid obstacles while running in the fields, and identify its owner. Good luck!!");
			}
				else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					currentState++;
					
					JOptionPane.showMessageDialog(null, "Welcome to your first task! Use the arrow keys to move onto the moving rocks. Jump by pressing the space bar. Good luck!");
					
					
					System.out.println(currentState);
				
				repaint();
			}
			}
		
		
		else if(currentState==GAME) {
			if (e.getKeyCode() == KeyEvent.VK_UP && dog.y >= 300) {
				System.out.println("UP");
				dog.up();

			} else if (e.getKeyCode() == KeyEvent.VK_DOWN && dog.y <=820) {
				System.out.println("DOWN");
				dog.down();

			} else if (e.getKeyCode() == KeyEvent.VK_LEFT && dog.x >= 0) {
				System.out.println("LEFT");
				dog.left();

			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && dog.x <= Game.WIDTH-100) {
				System.out.println("RIGHT");
				dog.right();
			}
		}
		
		}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
