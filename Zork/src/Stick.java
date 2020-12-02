/**
 * ---------------------------------------------------------------------------
 * File name: Stick.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Chase Walton, waltonca@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Oct 31, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * Stick object derived from weapon
 *
 * <hr>
 * Date created: Oct 31, 2020
 * <hr>
 * @author Chase Walton
 */
public class Stick extends Weapon {
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * 
	 */
	public Stick() {
		super();
		damageBonus = 1; 		//Stick has a +1 damage bonus
		type = "Stick";
	}
	/**
	 *
	 * returns the weapon bonus   
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return int
	 */
	public int bonus() {
		return  damageBonus;
	}
}
