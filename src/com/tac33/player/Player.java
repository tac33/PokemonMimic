package com.tac33.player;

import com.tac33.item.Item;
import com.tac33.pokemon.species.generic.Pokemon;

public class Player {
	private Pokemon[] pokebox = new Pokemon[30];
	private int money;
	private Item[] inventory = new Item[50];
	
	/*
	 * Add new pokemon to pokebox
	 */
	public void addToPokebox(Pokemon p) {
		
		for(int i=0; i < pokebox.length; i++) {
			
			if (pokebox[i] == null) {
				pokebox[i] = p;
				System.out.println("Added to box");
			} else {
				System.out.println("pokebox is full");
			}
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
