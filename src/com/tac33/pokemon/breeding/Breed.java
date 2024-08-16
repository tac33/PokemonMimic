package com.tac33.pokemon.breeding;

import com.tac33.pokemon.enums.*;
import com.tac33.pokemon.species.generic.*;
public class Breed {
	
	/*
	 * Breed two pokemon to produce a third.
	 * @param poke1
	 * @param poke2
	 */
	public static Pokemon breedPokemon(Pokemon poke1, Pokemon poke2) {
		/*
		 * Check compatible eggGroups, genders, and if pokemon is an egg.
		 */
		if (checkEggGroup(poke1, poke2) && checkGender(poke1, poke2)) {
			Pokemon mother = femalePoke(poke1, poke2);
			Pokemon baby = new Pokemon(mother);
			
			baby.setHpIV(baby.getRandomIV());
			baby.setAttackIV(baby.getRandomIV());
			baby.setDefenseIV(baby.getRandomIV());
			baby.setSpecialAttackIV(baby.getRandomIV());
			baby.setSpecialDefenseIV(baby.getRandomIV());
			baby.setSpeedIV(31);
			baby.setIsEgg(true);
			
			return baby;
		}
		
		System.out.println("Pokemon cannot be bred.");
		Pokemon empty = new Pokemon();
		empty.setSpecies(Species.EMPTY);
		return empty;
	}
	
	/*
	 * Check pokemon egg group compatibility
	 */
	public static boolean checkEggGroup(Pokemon poke1, Pokemon poke2) {
		boolean isCompatible = false;
		EggGroup[] arr1 = new EggGroup[2];
		arr1 = poke1.getEggGroup();
		EggGroup[] arr2 = new EggGroup[2];
		arr2 = poke2.getEggGroup();
		
		// Compare egg
		if (arr1[0] == EggGroup.NONE || arr2[0] == EggGroup.NONE) {
			isCompatible = false;
		} else if (arr1[0] == arr2[0]) {
			isCompatible = true;
		} else if (arr1[0] == arr2[1]) {
			isCompatible = true;
		} else if (arr1[1] == arr2[0]) {
			isCompatible = true;
		} else if (arr1[1] == arr2[1]) {
			isCompatible = true;
		}
		
		return isCompatible;
	}
	
	/*
	 * Check pokemon gender compatibility
	 * @return true if pokemon can breed
	 */
	public static boolean checkGender(Pokemon poke1, Pokemon poke2) {
		boolean isBreedable = false;
		Gender g1 = poke1.getGender();
		Gender g2 = poke2.getGender();
		
		if (g1 != g2 && (g1 != Gender.GENDERLESS && g2 != Gender.GENDERLESS)) {
			isBreedable = true;
		}
		
		return isBreedable;
	}
	
	/*
	 * Check if Pokemon is an Egg
	 */
	public static boolean checkIsEgg(Pokemon poke1, Pokemon poke2) {
		boolean isEgg = false;
		
		if (!poke1.getIsEgg() || !poke2.getIsEgg()) {
			isEgg = true;
		}
		
		return isEgg;
	}
	
	/*
	 * return female pokemon object, assumes one of the two is female.
	 */
	public static Pokemon femalePoke(Pokemon poke1, Pokemon poke2) {
		Gender g1 = poke1.getGender();
		Gender g2 = poke2.getGender();
		
		if (g1 == Gender.FEMALE) {
			return poke1;
		} else if (g2 == Gender.FEMALE) {
			return poke2;
		}
		
		return null;
	}
	
	public void checkHeldItem() {
		
	}

}
