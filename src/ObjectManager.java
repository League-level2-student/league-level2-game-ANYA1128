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
		rocks.add(new Rock(300, 760, 130, 120));

	}

	void addAlien() {

	}
int getScore() {
	return score;
}
	void update() {
		dog.update();
		for (int i = 0; i < rocks.size(); i++) {
			rocks.get(i).update();	
		}
	
		checkCollision();
		purgeObjects();

	}

	void checkCollision() {
		for (int i = 0; i < rocks.size(); i++) {
			if(dog.collisionBox.intersects(rocks.get(i).collisionBox)) {
				Rock theRock = rocks.get(i);
				theRock.isMoving = false;
				dog.isActive=true;
				
				System.out.println("rock has been jumped");
			}
			
		}
	}
		
		

	void draw(Graphics g) {

		dog.draw(g);
		for (int i = 0; i < rocks.size(); i++) {
			rocks.get(i).draw(g);
		}
		
	}

	void purgeObjects() {
		for (int i = 0; i < rocks.size(); i++) {
			if (rocks.get(i).isActive == false) {		
				rocks.remove(i);
				System.out.println("something");
				score++;

			}
		}
		
	}
  
 	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}

