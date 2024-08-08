package com.tac33.pokemon.species;

import com.tac33.pokemon.enums.*;
import com.tac33.pokemon.species.generic.*;


public class Squirtle extends Pokemon {
	public Squirtle() {
		/*
		 * @param Species
		 * @param typePrimary
		 * @param typeSecondary
		 * @param natDexNumber
		 * @param eggPrimary
		 * @param eggSecondary
		 * @param level
		 * @param gender
		 */
		super(Species.SQUIRTLE, PokemonType.WATER, PokemonType.NONE, 2, EggGroup.WATER1, EggGroup.NONE, -1, 50.0);
	}
}
