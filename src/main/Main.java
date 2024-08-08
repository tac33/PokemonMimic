package main;
import java.util.Scanner;

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
	
	public static void mainMenu() {
		System.out.println("Welcome to Pokemon Breeding Mimic!");
		System.out.println("1. Start Game \n2. Load \n3. Quit");
		boolean menuCheck = false;
		
		while(!menuCheck) {
			try {
				Scanner input = new Scanner(System.in);
				int choice = input.nextInt();
				if (choice == 1) {
					System.out.println("Game started");
					menuCheck = true;
					StartMenu();
				} else if (choice == 2) {
					System.out.println("Loading game...");
					menuCheck = true;
				} else if (choice == 3) {
					System.out.println("Game aborted");
					menuCheck = true;
				} 
				else {
					System.out.println("Invalid input, please try again.");
				}
				
				if (menuCheck == true) {
					System.out.println("Closed Main Menu.");
					input.close();				
				}
				
			} catch(Exception e) {
				System.out.println("Invalid Input. Must be an integer");
			}
		}
	}
	
	public static void StartMenu() {
		boolean menuCheck = false;
		
		System.out.println("1. Pokemon \n2. ItemShop \n3. Iventory \n4. Quit");
		while(!menuCheck) {
			try {
				Scanner input = new Scanner(System.in);
				int choice = input.nextInt();
				
				if (choice == 1) {
					System.out.println("Get Pokemon Menu");
					menuCheck = true;
				} else if (choice == 2) {
					System.out.println("Get Itemshop");
					menuCheck = true;
				} else if (choice == 3) {
					System.out.println("Get Inventory");
					menuCheck = true;
				} else if (choice == 4) {
					System.out.println("Quitting");
				}
				else {
					System.out.println("Invalid input, please try again.");
				}
				
				
			} catch(Exception e) {
				System.out.println("Invalid input, please try again.");
			}
		}
	}

}
