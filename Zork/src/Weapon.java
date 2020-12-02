
/**
 * ---------------------------------------------------------------------------
 
* File name: Weapon.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Chase Walton, waltonca@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Oct 31, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * Weapon class of Zork game
 *
 * <hr>
 * Date created: Oct 31, 2020
 * <hr>
 * @author Chase Walton
 */
public abstract class Weapon {

	protected String type;			//The type of weapon
	protected int damageBonus;		//Damage bonus of the weapon
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * 
	 */
	public Weapon() {
		type ="null";
	}
	/**
	 *
	 * Returns the damage bonus    
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return int
	 */
	public int getBonus() {
		return damageBonus;
	}
	/**
	 *
	 * Sets the bonus of the weapon if you want to modify it  
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return void
	 */
	public void setBonus(int i) {
		damageBonus = i;			//Sets the damageBonus of the weapon
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
		
		return type;
	}

}
