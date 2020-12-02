/**
 * ---------------------------------------------------------------------------
 * File name: Sword.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Chase Walton, waltonca@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Oct 31, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * Sword derived from weapon
 *
 * <hr>
 * Date created: Oct 31, 2020
 * <hr>
 * @author Chase Walton
 */
public class Sword extends Weapon {
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * 
	 */
	public Sword() {
		super();
		damageBonus = 5;	//Sword has a +5 damage bonus
		type = "Sword";
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
