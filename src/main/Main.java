package main;
import java.util.Scanner;

import com.tac33.player.Player;
import com.tac33.pokemon.breeding.Breed;
import com.tac33.pokemon.enums.Species;
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
		 * 
		 * 
		 * 
		 * while(!isValid) {
			try {
				
			} catch(Exception e) {
				
			}
		}
		 */
	}
	
	/*
	 * Main menu GameState
	 *  Start - Start a new game
	 *  Load - load a previously saved game
	 *  Quit - Quit this menu
	 */
	public static void mainMenu() {
		boolean isValid = false;
		
		while(!isValid) {
			System.out.println("Welcome to Pokemon Breeding Mimic!");
			System.out.println("1. Start Game \n2. Load \n3. Quit");
			Scanner input = new Scanner(System.in);
			
			try {
				int choice = input.nextInt();
				if (choice == 1) {
					System.out.println("Game started");
					Player user = chooseStarter();
					gameMenu(user);
				} else if (choice == 2) {
					System.out.println("Loading game...");
					isValid = true;
				} else if (choice == 3) {
					System.out.println("Game aborted");
					isValid = true;
				} 
				else {
					System.out.println("Invalid input. Use integers 1-3.");
				}
				
				if (isValid == true) {
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
		boolean isValid = false;
		
		while(!isValid) {
			System.out.println("1. Your Pokemon \n2. Breed \n3. Iventory \n4. Item Shop \n5. Pokemon Shop \n6. Quit");
			try {
				Scanner input = new Scanner(System.in);
				int choice = input.nextInt();
				
				if (choice == 1) {
					pokemonState(user);
				} else if(choice == 2) {
					breedState(user);
				} else if (choice == 3) {
					inventoryState(user);
				} else if (choice == 4) {
					itemShopState(user);
				} else if (choice == 5) {
					pokemonShopState(user);
				} else if (choice == 6) {
					System.out.println("Quitting");
					isValid = true;
				}
				else {
					System.out.println("Invalid input. Use integers 1-5.");
				}
				
				
			} catch(Exception e) {
				System.out.println("Invalid input, please use an integer");
			}
		}
	}
	
	public static void breedState(Player user) {
		boolean isValid = false;
		int count = 0;
		
		Pokemon[] pokebox = user.getPokebox();
		
		while(!isValid) {
			System.out.println("1. Currently Breeding \n2. Breed Pokemon \n3. Quit");
			try {
				Scanner input = new Scanner(System.in);
				int choice = input.nextInt();
				
				/*
				 * 1. Show Pokemon Currently breeding
				 * 2. Choose Pokemon to breed.
				 * 3. Quit
				 * - Choose Poke1
				 * - Choose poke2
				 * -- Compatible? T- Breed F-Cannot breed
				 * - Back to Breed menu.
				 */
				if (choice == 1) {
					boolean empty = true;
					System.out.println("Currently Breeding: ");
					for(int i=0; i < pokebox.length; i++) {
						if (pokebox[i].getSpecies() != Species.EMPTY && pokebox[i].getIsBreeding()) {
							System.out.println((i + 1) + ". " + pokebox[i].getSpecies());
							empty = false;
						}
					}
					if (empty) {
						System.out.println("None");
					}
					System.out.println();
				} else if(choice == 2) {
					System.out.println("Choose two pokemon to breed using pokebox #. Press '0' to exit.");
					Pokemon poke1 = chooseBreedPoke(user);
					Pokemon poke2 = chooseBreedPoke(user);
					Pokemon baby = Breed.breedPokemon(poke1, poke2);
					if (baby.getSpecies() != Species.EMPTY) {
						poke1.setIsBreeding(true);
						poke2.setIsBreeding(true);
						user.addToPokebox(baby);
					}
					
				} else if (choice == 3) {
					System.out.println("Going back");
					isValid = true;
				}
				
				
			} catch(Exception e) {
				
			}
		}
		
		
	}
	
	
	public static Pokemon chooseBreedPoke(Player user) {
		boolean isValid = false;
		Pokemon[] pokebox = user.getPokebox();
		
		while(!isValid) {
			try {
				Scanner input = new Scanner(System.in);
				int choice = input.nextInt();
				
				if (choice > 0 && choice < 31) {
					isValid = true;
					return pokebox[choice - 1];
				} else {
					System.out.println("Please enter a number 1-30.");
				}
				
				
			} catch(Exception e) {
				System.out.println("Invalid input, please use an integer");
			}
		}
		
		return null;
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
		Scanner input = new Scanner(System.in);
		
		Pokemon[] pokebox = user.getPokebox();
		
		for(int i=0; i < pokebox.length; i++) {
			System.out.println((i + 1) + ". " + pokebox[i].getSpecies());
		}
		
		while(!isValid) {
			
			try {
				System.out.println("\nEnter Pokemon Box #");
				System.out.println("Type '0' to exit.");
				int choice = input.nextInt();
				
				if (choice == 0) {
					isValid = true;
				} else if (choice > 0 && choice < 31) {
					System.out.println(pokebox[choice - 1].toString());
					System.out.println("\nIVs");
					pokebox[choice-1].printIvs();
				} else {
					System.out.println("Please enter a number 1-30.");
				}
				
			} catch (Exception e) {
				System.out.println("Must be a number 1-30");
			}
			
		}
	}
	
	public static void inventoryState(Player user) {
		
	}
	
	public static void itemShopState(Player user) {
		
	}
	
	public static void pokemonShopState(Player user) {
		
	}

}
