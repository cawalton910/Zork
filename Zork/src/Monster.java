/**
 * ---------------------------------------------------------------------------
 * File name: Monster.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Chase Walton, waltonca@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Oct 31, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * Monster object derived from Participant
 *
 * <hr>
 * Date created: Oct 31, 2020
 * <hr>
 * @author Chase Walton
 */
public class Monster extends Participant {

	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * 
	 */
	public Monster() {
		super(20, "Monster");		//Monster has 20 health
		examine = "You!";
	}
}
