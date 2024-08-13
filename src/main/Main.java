package main;
import java.util.Scanner;

import com.tac33.player.Player;
import com.tac33.pokemon.breeding.Breed;
import com.tac33.pokemon.species.generic.*;
import com.tac33.pokemon.species.*;

public class Main {

	public static void main(String[] args) {
		
		mainMenu();
		
		/*
		 * Main Menu:
		 * - Start
		 * -- Pokemon
		 * --- Give Item
		 * --- Breed
		 * --- Check Stats
		 * --- Show Current Pokemon
		 * --- Back
		 * 
		 * -- ItemShop
		 * --- Buy Items
		 * --- Sell Items
		 * --- Sell Pokemon
		 * --- Back
		 * - Quit
		 * - Load
		 */
	}
	
	/*
	 * Main menu GameState
	 *  Start - Start a new game
	 *  Load - load a previously saved game
	 *  Quit - Quit this menu
	 */
	public static void mainMenu() {
		boolean menuCheck = false;
		
		while(!menuCheck) {
			System.out.println("Welcome to Pokemon Breeding Mimic!");
			System.out.println("1. Start Game \n2. Load \n3. Quit");
			try {
				Scanner input = new Scanner(System.in);
				int choice = input.nextInt();
				if (choice == 1) {
					System.out.println("Game started");
					Player user = chooseStarter();
					gameMenu(user);
				} else if (choice == 2) {
					System.out.println("Loading game...");
					menuCheck = true;
				} else if (choice == 3) {
					System.out.println("Game aborted");
					menuCheck = true;
				} 
				else {
					System.out.println("Invalid input. Use integers 1-3.");
				}
				
				if (menuCheck == true) {
					System.out.println("Closed Main Menu.");
					input.close();				
				}
				
			} catch(Exception e) {
				System.out.println("Invalid input, please use an integer "  +  e);
			}
		}
	}
	
	/*
	 * Main play GameState
	 * - your pokemon - get all pokemon currrently in your box
	 * - Iventory - get all items in your inventory
	 * - Item Shop - buy items
	 * - Pokemon Shop - buy pokemon
	 * - Quit - quit to main menu
	 */
	public static void gameMenu(Player user) {
		boolean menuCheck = false;
		
		while(!menuCheck) {
			System.out.println("1. Your Pokemon \n2. Iventory \n3. Item Shop \n4. Pokemon Shop \n5. Quit");
			try {
				Scanner input = new Scanner(System.in);
				int choice = input.nextInt();
				
				if (choice == 1) {
					pokemonState(user);
				} else if (choice == 2) {
					inventoryState(user);
				} else if (choice == 3) {
					itemShopState(user);
				} else if (choice == 4) {
					pokemonShopState(user);
				} else if (choice == 5) {
					System.out.println("Quitting");
					menuCheck = true;
				}
				else {
					System.out.println("Invalid input. Use integers 1-5.");
				}
				
				
			} catch(Exception e) {
				System.out.println("Invalid input, please use an integer");
			}
		}
	}
	
	/*
	 * Choose starter pokemon for the beginning of the game.
	 */
	public static Player chooseStarter() {
		
		boolean isValid = false;
		Player user = new Player();
		
		System.out.println("Choose your starting pokemon!");
		System.out.println("1. Bulbasaur \n2. Charmander \n3. Squirtle");
		Scanner input = new Scanner(System.in);
		
		while(!isValid) {
			
			try {
				int choice = input.nextInt();
				if (choice == 1) {
					Pokemon poke1 = new Bulbasaur();
					Pokemon poke2 = new Bulbasaur();
					poke1.setGender("male");
					poke2.setGender("female");
					System.out.println("You chose Bulbasaur!");
					
					user.setInPokebox(0, poke1);
					user.setInPokebox(1, poke2);
					isValid = true;
					
				} else if (choice == 2) {
					Pokemon poke1 = new Charmander();
					Pokemon poke2 = new Charmander();
					poke1.setGender("male");
					poke2.setGender("female");
					System.out.println("You chose Charmander!");
					
					user.setInPokebox(0, poke1);
					user.setInPokebox(1, poke2);
					isValid = true;
					
				} else if (choice == 3) {
					Pokemon poke1 = new Squirtle();
					Pokemon poke2 = new Squirtle();
					poke1.setGender("male");
					poke2.setGender("female");
					System.out.println("You chose Squirtle!");
					
					user.setInPokebox(0, poke1);
					user.setInPokebox(1, poke2);
					isValid = true;
				} else {
					System.out.println("Invalid input. Use integers 1-3.");
				}
				
			} catch (Exception e) {
				System.out.println("Invalid input, please use an integer");
			}
			
		}
		
		return user;
		
	}
	
	public static void pokemonState(Player user) {
		boolean isValid = false;
		
		System.out.println("get Pokemon Menu");
		Pokemon[] pokebox = user.getPokebox();
		
		for(int i=0; i < pokebox.length; i++) {
			System.out.println(i + " " + pokebox[i].getSpecies());
		}
		
		
		
		while(!isValid) {
			
			
		}
	}
	
	public static void inventoryState(Player user) {
		
	}
	
	public static void itemShopState(Player user) {
		
	}
	
	public static void pokemonShopState(Player user) {
		
	}

}
