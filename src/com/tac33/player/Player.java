package com.tac33.player;

import com.tac33.item.Item;
import com.tac33.pokemon.enums.Species;
import com.tac33.pokemon.species.generic.Pokemon;

public class Player {
	private Pokemon[] pokebox = new Pokemon[30];
	private int money;
	private Item[] inventory = new Item[50];
	
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
	
}
