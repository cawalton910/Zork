/**
 * ---------------------------------------------------------------------------
 * File name: longBow.java
 * Project name: Proj5-Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Christian Calhoun, CalhounC1@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * Long Bow derived from weapon
 *
 * <hr>
 * Date created: Nov 10, 2020
 * <hr>
 * @author Christian Calhoun
 */
public class longBow extends Weapon
{
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * 
	 */
	public longBow() {
		super();
		damageBonus = 4;	//A Long Bow has a +4 bonus
		type = "Long Bow";
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
