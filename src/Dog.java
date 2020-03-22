import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Dog extends GameObject {

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	int XSpeed = 0;
	int YSpeed = 0;

	Dog(int x, int y, int width, int height) {
		super(x, y, width, height);
		super.speed = 5;
		// TODO Auto-generated constructor stub
		if (needImage) {
			loadImage("download.png");
		}
	}

	void draw(Graphics g) {

		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}

	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	
	public void update() {
		super.update();

		if (y >= 300 && up) {
			y -= speed;
		}
		if (y <=820 && down ) {
			y += speed;
		}
		if (x >= 10 && left) {
			x -= speed;
		}
		if (x <= Game.WIDTH-100 && right) {
			x += speed;
		}

		
		

	}
}
