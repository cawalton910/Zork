import java.util.Random;
/**
 * ---------------------------------------------------------------------------
 
* File name: Dungeon.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Chase Walton, waltonca@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Oct 31, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * Dungeon class of Zork game
 *
 * <hr>
 * Date created: Oct 31, 2020
 * <hr>
 * @author Chase Walton
 */
public class Dungeon {
	Random rng = new Random();				//New random rng object
	Player player;							//Player reference
	Cell[] cells;							//Array reference
	private int playerPosition;				//Holds the current player position(cell 0-10)
	private int totalCellsGenerated;		//Total amount of cells generated

	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Oct 31, 2020 
	 *
	 * 
	 */
	public Dungeon() {	
		totalCellsGenerated = (rng.nextInt(6))+5;					//Random number between 5-10
		cells = new Cell[totalCellsGenerated];						//Creates an array of cells 5-10
		int weaponPosition = rng.nextInt(totalCellsGenerated)+1;	//Selects the place for the weapon to be placed
		for(int i=0;i<totalCellsGenerated;i++) {	//For every cell stay in this loop
			if(i!=weaponPosition) {					//Creates all the cells and creates the cell with a weapon (50% chance)
			cells[i] = new Cell();					//Create regular cell
			}
			else {								//If for loop lands on cell with the weapon stop and add the weapon
				cells[i] = new Cell();			//Creates the cell to hold a weapon
				int intVal = rng.nextInt(5)+1;	//Randomly select one weapon
				switch(intVal) {				//Create the cell with that weapon
					case 1: cells[i].addWeapon(new Stick());
						break;
					case 2: cells[i].addWeapon(new Sword());
						break;
					case 3: cells[i].addWeapon(new longBow());
						break;
					case 4: cells[i].addWeapon(new greatSword());
						break;
					case 5: cells[i].addWeapon(new warAxe());
				}//end switch
			}
		}//end for
		cells[0].removeMonster(); 	//Remove potential monsters from first cell
		cells[0].closeWestExit();	//Close the west most exit
		setPlayerPosition(0);		//Set the player position to first cell
	}//end Dungeon()		
	/**
	 *
	 * Sets player position         
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @param position
	 * @return void
	 */
	public void setPlayerPosition(int position){
		{
			this.playerPosition = position;
		}
	}
	/**
	 *
	 * Increments player position by one         
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @param position
	 * @return void
	 */
	public void incrementPlayerPosition(){
		{
			setPlayerPosition(playerPosition+1);
		}
	}
	/**
	 *
	 * Decrements player position by one         
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @param position
	 * @return void
	 */
	public void decrementPlayerPosition(){
		{
			setPlayerPosition(playerPosition-1);
		}
	}
	/**
	 *
	 * Returns current cell       
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * 
	 * @return Cell
	 */
	public Cell getCell() {
		return cells[playerPosition];
	}
	/**
	 *
	 * Returns the weapon      
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return Weapon
	 */
	public Weapon getWeapon() {
		return cells[playerPosition].getWeapon();	
	}
	/**
	 *
	 * Returns a true or false value if the game is won   
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return Weapon
	 */
	public boolean checkForWin() {
		if(totalCellsGenerated == playerPosition) {	//If player has left the last cell return true, otherwise false
			return true;	
		}
		else {
			return false;
		}
	}
	/**
	 *
	 * Returns toString formats the visual array  
	 *
	 * <hr>
	 * Date created: Nov 10, 2020
	 *
	 * <hr>
	 * @return String
	 */
	public String toString() {
		String result ="";		//Return string
		int i = 0;				//Used to determine player position
		for(Cell s:cells) {		//For every cell
			result+="|";		
			if(playerPosition == i) {	//If player is in cell print P
				result+="P";
			}
			else {
				result+="_";
			}
			if(s.getMonster() != null) {	//If monster is in cell print M
				result+="M";
			}
			else {
				result+="_";
			}
			if(s.getWeapon() != null) {		//If there is a weapon in the cell print the type of weapon abbreviated.
				switch(s.getWeapon().getClass().getSimpleName())	//gets the weapon name
				{
					case "Stick": result += "St";			//Stick is "St"
						break;		
					case "Sword": result += "Sw";			//Sword is "Sw"
						break;						
					case "warAxe": result += "Wa";			//War Axe is "Wa"
						break;						
					case "longBow": result += "Lb";			//Long Bow is "Lb"
						break;						
					case "greatSword": result+="Gs";		//Great Sword is "Gs"
						break;
				}//end switch
			}//end if
			else { //If there is no weapon in the cell print a "_"
				result+="_";
			}
			result+="_| ";	//The last part of the cell
			i++;	//Used to determine player position
		}//end for
		return result;
	}//end toString
}
