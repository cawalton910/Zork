import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * ---------------------------------------------------------------------------
 * File name: ZorkDriver.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Chase Walton, waltonca@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Oct 31, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * Driver of Zork
 *
 * <hr>
 * Date created: Oct 31, 2020
 * <hr>
 * @author Chase Walton
 */
public class ZorkDriver {
	/**
	 * main method      
	 *
	 * <hr>
	 * Date created: Oct 31, 2020
	 *
	 * <hr>
	 * @param args
	 */
	
	
	
	public static void main(String[] args) {
		
		boolean gameWon = false;					//Boolean that holds value of game status
		String input ="";							//Holds the users input
		Scanner kb = new Scanner(System.in);		//Creates a new scanner kb
		GameManger g = new GameManger();			//Creates the gameManager object
		JOptionPane.showMessageDialog(null, g.getWelcomeMsg());		//Prints the welcome message
		while(gameWon != true) {					//While the game is not won, stay in this loop
			try {
				System.out.println(g.toString());			//Print the dungeon
				System.out.println(g.getPlayerHealth());	//Print player health
				System.out.print(g.checkForWeapon());		//Check for weapon, adds bonus if so	
				boolean blnMonster = g.checkForMonster();	//Returns true if there is a monster
				if(blnMonster==true) {						//If there is a monster do this
					System.out.print("\nThere is a monster in here - the fight begins");
					String rst = g.fight();					//Calling the method fight to deal with it
					System.out.println(rst);				//Print result
					System.out.println(g.toString());		//Prints the dungeon again
					System.out.println(g.getPlayerHealth());//Prints the players health
				}
				boolean ff = false;
				boolean blnFormatter = false;
				while(blnFormatter == false) {								//While you do not enter a correct value, keep trying
					System.out.println("\nWhat direction would you like to move (Go East or Go West)");
					input = kb.nextLine();
					if((input.toUpperCase()).equals("GO EAST")) {			//Not case sensitive. Must equal "GO EAST"
						blnFormatter=true;	//Jump out of while
					}
					else if((input.toUpperCase()).equals("GO WEST")) {		//Not case sensitive. Must equal "GO WEST"
						blnFormatter=true;	//Jump out of while
					}
					else {													//All other inputs
						System.out.println("\nI don't know what you mean.");
					}
				}
				ff = g.movePlayer(input);	//Returns true if player is moved in that direction.
				while(ff==false) {			//If it can not advance stay in this loop
					System.out.print("\nCan not move that way try again.");
					System.out.println("\nWhat direction would you like to move (Go East or Go West)");
					input = kb.nextLine();
					ff = g.movePlayer(input);	//Attempts to move the player again
				}
				if(g.checkForWin() == true) {	//Check to see if that player has won
					gameWon = true;
				}
		
			}
			catch(Exception e) {	//Catch any exceptions that occur (should be none)
			System.out.println("Error: "+e.getMessage());
			System.exit(-1);
			}
			
		}//end while
		kb.close();
		System.out.println("\nGame Won!");
		System.exit(-1);	//Terminate program if won
	}//end main
}//end class
