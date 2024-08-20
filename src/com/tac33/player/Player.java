package com.tac33.player;

import java.util.HashMap;

import com.tac33.items.*;
import com.tac33.pokemon.enums.Species;
import com.tac33.pokemon.species.generic.Pokemon;

public class Player {
	private Pokemon[] pokebox = new Pokemon[30];
	private HashMap<Item, Integer> inventory = new HashMap<Item, Integer>();
	private int money;
	
	public Player() {
		for(int i=0; i < pokebox.length; i++) {
			Pokemon poke = new Pokemon();
			poke.setSpecies(Species.EMPTY);
			
			pokebox[i] = poke;
		}
	}
	
	/*
	 * Adds pokemon in the next empty slot
	 */
	public boolean addToPokebox(Pokemon poke) {
		
		for(int i=0; i < pokebox.length; i++) {
			if (pokebox[i].getSpecies() == Species.EMPTY) {
				pokebox[i] = poke;
				System.out.println("Pokemon added to pokebox");
				return true;
			}
		}
		System.out.println("Pokebox is full.");
		return false;
	}
	
	/*
	 * Set pokemon in specific pokebox index
	 */
	public void setInPokebox(int i, Pokemon p) {
		pokebox[i] = p;
	}
	
	
	/*
	 * Swap pokemon positions in pokebox
	 */
	public void swapPokemonInPokebox(int i, int x) {
		Pokemon temp;
		
		temp = pokebox[i];
		pokebox[i] = pokebox[x];
		pokebox[x] = temp;
		
	}
	
	public void removeFromPokebox(int x) {
		Pokemon empty = new Pokemon();
		empty.setSpecies(Species.EMPTY);
		
		pokebox[x - 1] = empty;
	}
	
	public Pokemon[] getPokebox() {
		
		return pokebox;
	}
	
	public void setInventoryItem(Item item, int quantity) {
		inventory.put(item, quantity);
	}
	
	public HashMap<Item, Integer> getInventory() {
		return inventory;
	}
	
	/*
	 * Add to inventory
	 */
	public void addToInventory(Item item, int quantity) {
		
		if (quantity <= 0) {
			System.out.println("Cannot have 0 quantity.");
			return;
		}
		
		// Add to quantity if the item already exist, else just add item
		if (inventory.containsKey(item)) {
			int prev = inventory.get(item);
			quantity = quantity + prev;
			inventory.put(item, quantity);
		} else {
			inventory.put(item, quantity);	
		}
	}
	
	/*
	 * Remove from Inventory
	 */
	public void removeFromInventory(Item item) {
		int subtract = inventory.get(item) - 1;
		inventory.put(item, subtract);
		if (inventory.get(item) <= 0) {
			inventory.remove(item);
		}
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
}
