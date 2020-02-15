import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Dog dog;
	ArrayList<Rock> rocks = new ArrayList<>();

	Random random = new Random();
	int score = 0;

	ObjectManager(Dog dog) {
		this.dog = dog;
	}

	void addRock(Rock rock) {
		rocks.add(new Rock(random.nextInt(Game.WIDTH), 300, 150, 150));

	}

	void addAlien() {

	}
int getScore() {
	return score;
}
	void update() {
		rocket.update();
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y >= LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
				
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if (projectiles.get(i).y<=0) {
			    	projectiles.get(i).isActive = false;
			}
		}
		checkCollision(); 
		purgeObjects();
		

	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if(rocket.collisionBox.intersects(aliens.get(i).collisionBox)) {
				aliens.get(i).isActive=false;
				rocket.isActive=false;
				
				System.out.println("not active");
			}
			for(int a = 0; a < projectiles.size(); a++) {
			if(aliens.get(i).collisionBox.intersects(projectiles.get(a).collisionBox)) {
				
					projectiles.get(a).isActive=false;
					aliens.get(i).isActive=false;
					System.out.println("alien killed");
				}
				
				}
		}
		
				
			}
	

	void draw(Graphics g) {

		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
			
				aliens.remove(i);
				score++;

			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				
				projectiles.remove(i);

			}
		}
	}
  
 	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}

