package com.tac33.pokemon.species;

import com.tac33.pokemon.enums.*;
import com.tac33.pokemon.species.generic.*;

public class Bulbasaur extends Pokemon {
	
	public Bulbasaur() {
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
		super(Species.BULBASAUR, PokemonType.GRASS, PokemonType.NONE, 1, EggGroup.FIELD, EggGroup.NONE, 1000, 90.0);
	}
}
