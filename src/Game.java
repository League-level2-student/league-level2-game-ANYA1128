import java.awt.Component;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game {
	JFrame frame = new JFrame();
	public static final int WIDTH = 1400;
	public static final int HEIGHT = 1000;
	GamePanel gPanel = new GamePanel();
	
	public static void main(String[] args) {
	Game dog = new Game();
	dog.setup();
}
	void setup() {
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.add(gPanel);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}
}
