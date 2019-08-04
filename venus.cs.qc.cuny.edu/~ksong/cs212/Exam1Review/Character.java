public interface Character {
	
	// Interfaces should not implement methods because each class has a different way of doing the same action
	// ie. a Warrior will use a sword to attack, a Mage will use a staff to attack
	
	void moveUp();
	void moveDown();
	void moveLeft();
	void moveRight();
	
	void attack();

}
