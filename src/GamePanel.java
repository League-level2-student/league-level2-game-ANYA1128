import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;



public class GamePanel extends JPanel implements ActionListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int WIDTH = 1000;
	int HEIGHT = 1000;
	int currentState = MENU;
	Timer timer;
	public static BufferedImage image;
	public static BufferedImage imageBackground;
	public static boolean needImage = true;
	public static boolean gotImage = false;


	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font instructionsFont = new Font("Arial", Font.PLAIN, 23);
	Font scoreFont = new Font("Arial", Font.PLAIN, 35);

	GamePanel(){
		
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

		

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				imageBackground = ImageIO.read(this.getClass().getResourceAsStream("park.jpg"));
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
			g.drawImage(imageBackground, 0, 0, Game.WIDTH, Game.HEIGHT, null);
			
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}


	}

	void drawGameState(Graphics g) {
		
	}

	void drawEndState(Graphics g) {
		if (gotImage) {
			g.drawImage(imageBackground, 0, 0, Game.WIDTH, Game.HEIGHT, null);
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

}
