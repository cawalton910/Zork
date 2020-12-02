import java.util.Random;

/**
 * ---------------------------------------------------------------------------
 * File name: Cell.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Chase Walton, waltonca@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Oct 31, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * Cell object of the Zork Game
 *
 * <hr>
 * Date created: Oct 31, 2020
 * <hr>
 * @author Chase Walton
 */
public class Cell {
	Random rng = new Random();
	private Boolean westExit =true;			//Boolean value to represent the west cell wall
	private Boolean eastExit =true;			//Boolean value to represent the east cell wall
	Monster monster;						//Monster reference
	Weapon weapon;							//Weapon reference
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * 
	 */
	public Cell() {
		if (rng.nextInt(100) >= 50) // 50% chance of monster spawning in the cell
		{
			monster = new Monster();	//Creates the monster
		}// end if
		westExit = true;		//Set the west exit open
		eastExit = true;		//Set the east exit open
	}
	/**
	 *
	 * Sets the monster in the cell     
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return void
	 */
	public void setMonster(Monster m)
	{
		this.monster = m;
	}
	/**
	 *
	 * gets the monster   
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return Monster
	 */
	public Monster getMonster() {
		return monster;
	}
	/**
	 *
	 * returns the weapon      
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return Weapon
	 */
	public Weapon getWeapon() {
		return weapon;
	}
	/**
	 *
	 * removes the monster      
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return void
	 */
	public void removeMonster() {
		monster = null;
	}
	/**
	 *
	 * adds the weapon      
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return void
	 */
	public void addWeapon(Weapon w) {
		this.weapon = w;
	}
	/**
	 *
	 * Closes the west exit, used to close the first cell room exit     
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return void
	 */
	public void closeWestExit() {
		westExit = false;
	}
	/**
	 *
	 * Returns true if the cell has an exit     
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return boolean
	 */
	public boolean hasExit(String t) {
		boolean bln = false;
		String s = t.toUpperCase();
		if(s.equals("GO EAST")) {	//If there is an east exit return true, else false
			if(eastExit==true) {
				bln=true;
			}
			else {
				bln=false;
			}
		}
		else if(s.equals("GO WEST")){	//If there is a west exit return true, else false
			if(westExit==true) {
				bln=true;
			}
			else {
			bln = false;
			}
			
		}
		else {
			
		}
		return bln; 
	}

}
