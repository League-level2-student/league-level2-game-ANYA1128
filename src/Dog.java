	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Rectangle;
	import java.awt.image.BufferedImage;
	import javax.imageio.ImageIO;

	public class Dog extends GameObject{
	
		public static BufferedImage image;
		public static boolean needImage = true;
		public static boolean gotImage = false;	

		Dog(int x, int y, int width, int height) {
			super(x, y, width, height);
			super.speed = 15;
			// TODO Auto-generated constructor stub
			if (needImage) {
			    loadImage ("good.png");
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
		
		public void right() {
			x += speed;
		}

		public void left() {
			x -= speed;
		}

		public void down() {
			y += speed;
		}

		public void up() {
			y -= speed;
		}
	}


