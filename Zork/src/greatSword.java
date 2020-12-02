/**
 * ---------------------------------------------------------------------------
 * File name: greatSword.java
 * Project name: Proj5-Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Christian Calhoun, CalhounC1@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * Great Sword derived from weapon
 *
 * <hr>
 * Date created: Nov 10, 2020
 * <hr>
 * @author Christian Calhoun
 */
public class greatSword extends Weapon
{
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * 
	 */
	public greatSword() {
		super();
		damageBonus = 9;		//A Great Sword has a +9 bonus
		type = "Great Sword";
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