import java.util.Random;
/**
 * ---------------------------------------------------------------------------
 * File name: GameManger.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Chase Walton, waltonca@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Oct 31, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * Manager of the Zork game
 *
 * <hr>
 * Date created: Oct 31, 2020
 * <hr>
 * @author Chase Walton
 */
public class GameManger {
	Random rng = new Random();	
	Dungeon dungeonA;					//The reference to the dungeon the player plays
	private static Player playerA;		//The player of the game
	private int maxHit =5;				//Player's minimum damage
	private static String welcome = "Welcome to the Zork Game"+"\n____________________________________________"+
			"\nIn this game, there is a dungeon with from 5 to 10 cells. \nThe player begins in the west-most cell and tries to get"+
			"\nthe east-most cell which contains the dungeon exit."+
			"\nA successful exit from the final cell wins the game. \nAlong the way, each cell may have a monster that must be defeated."+
			"\nOne cell contains a weapon which may be used on the monster, if any,\n\nThe game continues until the player is defeated by a monster or until the player "+
			"successfully exits the east-most cell.\nIn each cell, a player may move one cell to the east or one cell to the west, if there is an exit in that direction.\n____________________________________________\n\n";
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * 
	 */
	public GameManger() {
		playerA = new Player();		//Initialize the player
		dungeonA = new Dungeon();	//Initialize the dungeon
	}
	
	
	/**
	 *
	 * Manages the fight between a player and a monster   
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return String
	 */
	public String fight() {
		String result = "";	
		Cell c = dungeonA.getCell();					//Retrieve the cell
		Monster m = c.getMonster();						//Retrieve the monster from the cell
		int monsterHealth = m.getCurrentHealth();		//Gets monsters health and stores it in monsterHealth
		int playerHealth = playerA.getCurrentHealth();	//Gets players health and stores it in playerHealth
		while(monsterHealth>0 && playerHealth>0) {		//While any participant is still alive stay in this loop
			if(playerHealth>0) {						//If player is still alive
				if(rng.nextInt(100)>=10){				//90% chance of player hitting
					m.takeDamage(maxHit);				//Call takeDamage to subtract health to monster
					monsterHealth = m.getCurrentHealth();	//Updates the monstersHealth
					result+="\nThe player hit the monster - "+m.toString();
				}
				else {										//If the player misses the monster
					monsterHealth = m.getCurrentHealth();	//Updates the monsters health
					result+="\nThe player missed! - "+m.toString();
				}
			}
			else {										//Assuming the player has been defeated
				result+="\nGame Over! Player is dead";	//Print game over
				System.exit(-1);			 			//If player dies end the game
			}
			if(monsterHealth>0) {						//Assuming monster is still alive
				if(rng.nextInt(100)>= 20) {				//80% chance of monster hitting
					playerA.takeDamage(4);				//Call takeDamage to subtract health from the player
					playerHealth = playerA.getCurrentHealth();	//Updates the players health
					result+="\nThe monster hit the player! - "+playerA.toString();	
				}
				else {	//Assuming the monster misses
					playerHealth = playerA.getCurrentHealth(); //Updates the players health
					result+="\nThe monster missed! - "+playerA.toString();
				}
			}
			else {					//Assuming monster is dead
				result+="\nThe Monster is dead\n\n";
				c.setMonster(null);	//Clears the monster
			}
			
		}
		return result;
	}
	/**
	 *
	 * Returns true if the String provided is correct and changes the player state. Returns false if the String provided is unrecognized
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return boolean
	 */
	public boolean movePlayer(String direction) {
		boolean blnResult = false;
		String temp = direction.toUpperCase();		//Change to upper case for ease
		Cell c = dungeonA.getCell();				//Retrieve the cell
		boolean bln = c.hasExit(direction);			//Does the cell have a exit in that direction
		if(bln==true && temp.equals("GO EAST")) {	//If there is an exit in the east direction increment or decrement player position
			dungeonA.incrementPlayerPosition();		//Increment players position in game
			blnResult =true;
		}
		else if(bln==true && temp.equals("GO WEST")) {	//If there is an exit in the west direction increment or decrement player position
			dungeonA.decrementPlayerPosition();			//Decrement the player position in game
			blnResult = true;			
		}
		return blnResult;
	}
	/**
	 *
	 * Returns true if the current cell has a monster, false if not. 
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return boolean
	 */
	public boolean checkForMonster() {
		boolean bln = false;
		Cell c = dungeonA.getCell();		//Retrieve the cell
		if(c.getMonster() != null) {		//If current cell has a monster return true
			bln = true;
		}
		else {					//If it does not have a monster
			bln = false;		//Return false
		}
		return bln;
	}
	/**
	 *
	 * Checks for weapons in the cell and automatically increases max hit.   
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return void
	 */
	public String checkForWeapon() {
		String strResult ="";
		Weapon w =null;						//Creates a null weapon reference
		if(dungeonA.getWeapon() != null) {	//If there is a weapon present
			w = dungeonA.getWeapon();		//Get the weapon
			maxHit+=w.getBonus();			//Increase max hit	
			strResult = "\nYou have found a "+w.toString()+"!";	//Print that you have found a weapon
			
		}	
		return strResult;
	}
	/**
	 *
	 * Checks for game victory
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return boolean
	 */
	public boolean checkForWin() {
		return dungeonA.checkForWin();		
	}
	/**
	 *
	 * Returns players health in formatted string
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return String
	 */
	
	public String getPlayerHealth() {
		
		return playerA.toString();
	}
	/**
	 *
	 * Returns the welcome message
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return String
	 */
	public String getWelcomeMsg() {
		return welcome;			
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
		String result = "";
		result+=dungeonA.toString();	//copies the dungeons toString
		return result;
	}
}
