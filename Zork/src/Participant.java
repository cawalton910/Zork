/**
 * ---------------------------------------------------------------------------
* File name: Participant.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Chase Walton, waltonca@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Oct 31, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * Participant class of Zork Game
 *
 * <hr>
 * Date created: Oct 31, 2020
 * <hr>
 * @author Chase Walton
 */
public abstract class Participant {
	protected String examine;
	protected String type;
	protected int maxHealth;
	protected int currentHealth;
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * 
	 */
	public Participant() {
		
	}
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * @param int health
	 * @param String type
	 */
	public Participant(int health, String type) {
		this.maxHealth = health;
		currentHealth = maxHealth;
		this.type = type;
	}

	/**
	 *
	 * Removes health points from the participant    
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return void
	 */
	public void takeDamage(int q) {
		currentHealth-=q;			//Subtracts q health from currentHealth
		if(currentHealth<0) {		//Prevents the health from going below 0
			currentHealth = 0;
		}
	}
	/**
	 *
	 * Returns the current health    
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return int
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}
	/**
	 *
	 * toString   
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return String
	 */
	public String toString() {
		return type+" health points: "+currentHealth;
	}
}
