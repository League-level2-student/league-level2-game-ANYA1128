import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;
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
	public static BufferedImage image;
	public static BufferedImage image2;
	public static boolean needImage = true;
	public static boolean gotImage = false;


	Font titleFont = new Font("Comic Sans", Font.PLAIN, 48);
	Font instructionsFont = new Font("Comic Sans", Font.PLAIN, 23);
	Font scoreFont = new Font("Comic Sans", Font.PLAIN, 35);

	GamePanel(){
		loadImage();
	}
	public void startGame() {
		 timer = new Timer(1000/60,this);
		 timer.start();
		
	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU) {
			drawMenuState(g);
		}

		else if (currentState == GAME) {
			drawGameState(g);

		}
	}

		

	void loadImage() {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream("background.jpg"));
				image2 = ImageIO.read(this.getClass().getResourceAsStream("images-1.png"));
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

	void drawMenuState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, Game.WIDTH, Game.HEIGHT, null);
			g.drawImage(image2, 50, 900, 50, 50, null);
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
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(currentState==MENU) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				
					JOptionPane.showMessageDialog(null, "Welcome to the Game. This dog has lost its owner and has to return safely. In order to do so, it has to cross the river, avoid obstacles while running in the fields, and identify its owner. Good luck!!");
				}
			}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
