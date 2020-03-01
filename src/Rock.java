import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rock extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public boolean isMoving = true;
	Rock(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 3;
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("rock.png");
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
		if(isMoving) {
			x+=speed;	
		}
		if(x>Game.WIDTH) {
			speed=-speed;
		}
		else if(x<0) {
			speed=-speed;
		}
		super.update();
	}

	public void draw(Graphics g) {
	
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
}

