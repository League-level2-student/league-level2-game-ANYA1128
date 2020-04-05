import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ObjectManager implements ActionListener {
	Dog dog;
	ArrayList<Rock> rocks = new ArrayList<>();
	boolean rockAdded = false;
	boolean dogIsOnRock = false;

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
		dogIsOnRock = false;
		for (int i = 0; i < rocks.size(); i++) {
			if (dog.collisionBox.intersects(rocks.get(i).collisionBox)) {
				Rock theRock = rocks.get(i);
				// Rock prevRock = rocks.get(i-1);
				theRock.isMoving = false;

				theRock.isMovingBackwards = true;
				dog.x = theRock.x;
			
				dogIsOnRock = true;
				score++;

				
				 
				theRock.update();
				
				// dog.isActive = true;

			}
			
//			 public boolean isDogOnRock() {
//			        for( int i = 0; i < rocks.size(); i++ ) {
//			            Rock rock = rocks.get( i );
//			            int futureDogX = dog.x + dog.speed;
//			            int futureDogY = dog.y + dog.speed;
//			            
//			            Rectangle futureDogCollisionBox = new Rectangle( futureDogX, futureDogY, 1, 1 );
//			            Rectangle smolRockCollisionBox = new Rectangle( rock.x, rock.y, rock.width - dog.width, rock.height );
//			            
//			            if( croppedRockCollisionBox.intersects( futureDogCollisionBox ) ) {
//			                return true;
//			            }
//			        }
//			        return false;
//			    }
//
//			    void update() {
//			        
//			        if( isDogOnRock() ) {
//			            // If dog is ON a rock, dog can move
//			            dog.update();
//			            
//			        } else if( ( dog.y + dog.ySpeed ) >= 800 && ( dog.y + dog.ySpeed ) <= 840 ) {
//			            // If dog is NOT on a rock, limit movement to bottom of beach
//			            dog.update();
//			        
//			        }
//
//			        for( int i = 0; i < rocks.size(); i++ ) {
//
//			

			// System.out.println("rock has been jumped");

		}
		//add what needs to be done in case the dog is in the water
		if(dog.y<=820&&dog.y>=300&&!dogIsOnRock) {
			JOptionPane.showMessageDialog(null, "You have lost the game. This is your score: "+score);
			System.exit(0);
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
