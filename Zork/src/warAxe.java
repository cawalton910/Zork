/**
 * ---------------------------------------------------------------------------
 * File name: GreatSword.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Chase Walton, waltonca@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * A War Axe derived from weapon
 *
 * <hr>
 * Date created: Nov 10, 2020
 * <hr>
 * @author Chase Walton
 */
public class warAxe extends Weapon
{
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * 
	 */
	public warAxe() {
		super();
		damageBonus = 8; //War Axe has a +8 bonus
		type = "War Axe";
	}
	/**
	 *
	 * Returns the weapon bonus   
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
