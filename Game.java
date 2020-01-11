import javax.swing.JFrame;

public class Game {
	JFrame frame = new JFrame();
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel gPanel = new GamePanel();
	
	public static void main(String[] args) {
	Game dog = new Game();
	dog.setup();
}
	void setup() {
		frame.add(gPanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.addKeyListener(gPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}
}
