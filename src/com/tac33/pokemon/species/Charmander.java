package com.tac33.pokemon.species;

import com.tac33.pokemon.enums.*;
import com.tac33.pokemon.species.generic.*;

public class Charmander extends Pokemon {
	public Charmander() {
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
		super(Species.CHARMANDER, PokemonType.FIRE, PokemonType.NONE, 0, EggGroup.FIELD, EggGroup.DRAGON, 1, 12.5);
	}
}
