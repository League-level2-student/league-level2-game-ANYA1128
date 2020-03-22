import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ObjectManager implements ActionListener {
	Dog dog;
	ArrayList<Rock> rocks = new ArrayList<>();
	boolean rockAdded = false;

	Random random = new Random();
	int score = 0;

	ObjectManager(Dog dog) {
		this.dog = dog;
	}


	void addRock(Rock rock) {
		rocks.add(rock);

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
			if (dog.collisionBox.intersects(rocks.get(i).collisionBox)) {
				Rock theRock = rocks.get(i);
				theRock.isMoving = false;
				
				
				
				theRock.y=dog.y;
				theRock.isMovingBackwards = true;
				dog.x=theRock.x;
				theRock.update();
				score++;
				dog.isActive = true;
				
				

			}

			System.out.println("rock has been jumped");

		}
	

		boolean rocksMoving = false;
		for (int v = 0; v < rocks.size(); v++) {
			if (rocks.get(v).isMoving == true) {
				rocksMoving = true;
				break;
			}

		}
		if (rocksMoving == false) {
			rockAdded = false;
		}
		if (rockAdded == false) {
			
			addRock(new Rock(Rock.rockXValue, Rock.rockStartingHeight - Rock.rockHeight));
			Rock.rockStartingHeight = Rock.rockStartingHeight - Rock.rockHeight;
			rockAdded = true;
		}
	}

	void draw(Graphics g) {

		
		for (int i = 0; i < rocks.size(); i++) {
			rocks.get(i).draw(g);
		}
		dog.draw(g);
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
		
	}
}
