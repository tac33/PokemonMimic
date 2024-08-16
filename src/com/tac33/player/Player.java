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
	 * Set pokemon in specific pokebox index
	 */
	public void setInPokebox(int i, Pokemon p) {
		pokebox[i] = p;
	}
	
	
	/*
	 * Swap pokemon positions in pokebox
	 */
	public void replacePokemonInPokebox(int i, int x) {
		Pokemon temp;
		
		temp = pokebox[i];
		pokebox[i] = pokebox[x];
		pokebox[x] = temp;
		
	}
	
	public Pokemon[] getPokebox() {
		
		return pokebox;
	}
	
}
