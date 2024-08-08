package com.tac33.pokemon.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.tac33.pokemon.breeding.Breed;
import com.tac33.pokemon.enums.*;
import com.tac33.pokemon.species.generic.*;
import com.tac33.pokemon.species.Bulbasaur;
import com.tac33.pokemon.species.Charmander;
import com.tac33.pokemon.species.Squirtle;

public class PokemonTest {
	
	@Test
	public void testCharmander() {
		Pokemon poke2 = new Charmander();	
		PokemonType[] arr = new PokemonType[2];
		arr = poke2.getType();
		EggGroup[] eggs = new EggGroup[2];
		eggs = poke2.getEggGroup();
		
		assertEquals(Species.CHARMANDER, poke2.getSpecies());
		assertEquals(PokemonType.FIRE, arr[0]);
		assertEquals(PokemonType.NONE, arr[1]);
		assertEquals(0, poke2.getNatDexNumber());
		assertEquals(EggGroup.FIELD, eggs[0]);
		assertEquals(EggGroup.DRAGON, eggs[1]);
		assertEquals(Gender.MALE, poke2.getGender());
		assertEquals(1, poke2.getLevel());
	}
	
	@Test
	public void testSetType() {
		Pokemon poke = new Bulbasaur();
		PokemonType[] arr = new PokemonType[2];
		arr = poke.getType();
		
		assertEquals(PokemonType.GRASS, arr[0]);
		poke.setPokemonType1("fairy");
		arr = poke.getType();
		assertEquals(PokemonType.FAIRY, arr[0]);
		poke.setPokemonType1("DARK", "FairY");
		arr = poke.getType();
		assertEquals(PokemonType.DARK, arr[0]);
		assertEquals(PokemonType.FAIRY, arr[1]);
	}
	
	@Test
	public void testIVrange() {
		Pokemon poke = new Squirtle();
		int iv = poke.getAttackIV();
		boolean isInRange = false;
		
		if (iv >= 0 && iv <= 31) {
			isInRange = true;
		}
		
		assertEquals(true, isInRange);
	}
	
	@Test
	public void testEggCompatibility() {
		Pokemon poke1 = new Charmander();
		Pokemon poke2 = new Bulbasaur();
		
		boolean eggCompat = Breed.checkEggGroup(poke1, poke2);
		assertEquals(true, eggCompat);
		
		poke2.setEggGroup("none");
		eggCompat = Breed.checkEggGroup(poke1, poke2);
		assertEquals(false, eggCompat);
		
		poke2.setEggGroup("fairy", "field");
		eggCompat = Breed.checkEggGroup(poke1, poke2);
		assertEquals(true, eggCompat);
		
	}
	
	@Test
	public void testGender() {
		Pokemon poke1 = new Pokemon();
		Pokemon poke2 = new Pokemon();
		
		poke1.setGender("male");
		poke2.setGender("female");
		assertEquals(true, Breed.checkGender(poke1, poke2));
		
		poke1.setGender("male");
		poke2.setGender("male");
		assertEquals(false, Breed.checkGender(poke1, poke2));
		
		poke1.setGender("genderless");
		poke2.setGender("female");
		assertEquals(false, Breed.checkGender(poke1, poke2));
	}
	
	@Test
	public void testCopy() {
		Pokemon poke1 = new Bulbasaur();
		Pokemon poke2 = new Pokemon(poke1);
		
		poke2.setSpecies(Species.CHARMANDER);
		
		assertEquals(Species.CHARMANDER, poke2.getSpecies());
		assertEquals(Species.BULBASAUR, poke1.getSpecies());
		
		
	}
	
}
