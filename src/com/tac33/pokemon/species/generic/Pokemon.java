package com.tac33.pokemon.species.generic;

import java.util.Random;

import com.tac33.pokemon.enums.*;

public class Pokemon extends PokemonIVs {

	private String name;
	private int id = 0;
	private int level;
	private PokemonType typePrimary;
	private PokemonType typeSecondary;
	private EggGroup eggPrimary;
	private EggGroup eggSecondary;
	private Species species;
	private int natDexNumber;
	private Gender gender;
	private double femaleChance;
	private boolean isEgg = false;
	
	
	public Pokemon() {
		
	}
	
	/**
	 * Constructor
	 * @param species
	 * @param typePrimary
	 * @param typeSecondary
	 * @param natDexNumber
	 * @param eggPrimary
	 * @param eggSecondary
	 * @param level
	 * @param genderChance
	 */
	public Pokemon(Species species, PokemonType typePrimary, PokemonType typeSecondary, int natDexNumber, EggGroup eggPrimary, EggGroup eggSecondary, int level, double femaleChance){
		this.species = species;
		this.typePrimary = typePrimary;
		this.typeSecondary = typeSecondary;
		this.natDexNumber = natDexNumber;
		this.eggPrimary = eggPrimary;
		this.eggSecondary = eggSecondary;
		this.femaleChance = femaleChance;
		
		/* Max level 100, Min level 1. */
		if (level > 100) {
			this.level = 100;
		} else if (level < 1) {
			this.level = 1;
		} else {
			this.level = level;
		}
		/*
		 * Set Gender
		 */
		genderSelection(this.femaleChance);
		
		/*
		 * Set pokemon IVs
		 */
		this.setHpIV(getRandomIV());
		this.setAttackIV(getRandomIV());
		this.setDefenseIV(getRandomIV());
		this.setSpecialAttackIV(getRandomIV());
		this.setSpecialDefenseIV(getRandomIV());
		this.setSpeedIV(getRandomIV());
	}
	
	public Pokemon(Pokemon poke) {
		this.species = poke.species;
		this.typePrimary = poke.typePrimary;
		this.typeSecondary = poke.typeSecondary;
		this.natDexNumber = poke.natDexNumber;
		this.eggPrimary = poke.eggPrimary;
		this.eggSecondary = poke.eggSecondary;
		this.level = 1;
		genderSelection(poke.femaleChance);
	}

	/**
	 * @return the species
	 */
	public Species getSpecies() {
		return species;
	}
	
	public void setSpecies(Species species) {
		this.species = species;
	}

	/**
	 * @return the natDexNumber
	 */
	public int getNatDexNumber() {
		return natDexNumber;
	}

	/**
	 * @param natDexNumber the natDexNumber to set
	 */
	public void setNatDexNumber(int natDexNumber) {
		this.natDexNumber = natDexNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * @return the type1
	 */
	public PokemonType[] getType() {
		PokemonType[] pokes = new PokemonType[2];
		pokes[0] = this.typePrimary;
		if (this.typeSecondary == null) {
			this.typeSecondary = PokemonType.NONE;
		}
		pokes[1] = this.typeSecondary;
		return pokes;
	}
	
	/**
	 * @param typePrimary the type1 to set
	 */
	public void setPokemonType1(String type) {
		String upper = type.toUpperCase();
		switch(upper) {
			case "NORMAL":
				this.typePrimary = PokemonType.NORMAL;
				break;
			case "FIRE":
				this.typePrimary = PokemonType.FIRE;
				break;
			case "WATER":
				this.typePrimary = PokemonType.WATER;
				break;
			case "GRASS":
				this.typePrimary = PokemonType.GRASS;
				break;
			case "ELECTRIC":
				this.typePrimary = PokemonType.ELECTRIC;
				break;
			case "PSYCHIC":
				this.typePrimary = PokemonType.PSYCHIC;
				break;
			case "ICE":
				this.typePrimary = PokemonType.ICE;
				break;
			case "DRAGON":
				this.typePrimary = PokemonType.DRAGON;
				break;
			case "DARK":
				this.typePrimary = PokemonType.DARK;
				break;
			case "FAIRY":
				this.typePrimary = PokemonType.FAIRY;
				break;
			case "FIGHTING":
				this.typePrimary = PokemonType.FIGHTING;
				break;
			case "FLYING":
				this.typePrimary = PokemonType.FLYING;
				break;
			case "POISON":
				this.typePrimary = PokemonType.POISON;
				break;
			case "GROUND":
				this.typePrimary = PokemonType.GROUND;
				break;
			case "ROCK":
				this.typePrimary = PokemonType.ROCK;
				break;
			case "BUG":
				this.typePrimary = PokemonType.BUG;
				break;
			case "GHOST":
				this.typePrimary = PokemonType.GHOST;
				break;
			case "STEEL":
				this.typePrimary = PokemonType.STEEL;
				break;
			case "NONE":
				this.typePrimary = PokemonType.NONE;
		}
	}
	
	/**
	 * @param Set this instance Type1
	 * @param Set this instance type2
	 */
	public void setPokemonType1(String type, String type2) {
		String upper = type.toUpperCase();
		String upper2 = type2.toUpperCase();
		
		/* Set type1 */
		switch(upper) {
			case "NORMAL":
				this.typePrimary = PokemonType.NORMAL;
				break;
			case "FIRE":
				this.typePrimary = PokemonType.FIRE;
				break;
			case "WATER":
				this.typePrimary = PokemonType.WATER;
				break;
			case "GRASS":
				this.typePrimary = PokemonType.GRASS;
				break;
			case "ELECTRIC":
				this.typePrimary = PokemonType.ELECTRIC;
				break;
			case "PSYCHIC":
				this.typePrimary = PokemonType.PSYCHIC;
				break;
			case "ICE":
				this.typePrimary = PokemonType.ICE;
				break;
			case "DRAGON":
				this.typePrimary = PokemonType.DRAGON;
				break;
			case "DARK":
				this.typePrimary = PokemonType.DARK;
				break;
			case "FAIRY":
				this.typePrimary = PokemonType.FAIRY;
				break;
			case "FIGHTING":
				this.typePrimary = PokemonType.FIGHTING;
				break;
			case "FLYING":
				this.typePrimary = PokemonType.FLYING;
				break;
			case "POISON":
				this.typePrimary = PokemonType.POISON;
				break;
			case "GROUND":
				this.typePrimary = PokemonType.GROUND;
				break;
			case "ROCK":
				this.typePrimary = PokemonType.ROCK;
				break;
			case "BUG":
				this.typePrimary = PokemonType.BUG;
				break;
			case "GHOST":
				this.typePrimary = PokemonType.GHOST;
				break;
			case "STEEL":
				this.typePrimary = PokemonType.STEEL;
				break;
			default:
				this.typePrimary = PokemonType.NONE;
		}
		
		/* Set type2 */
		switch(upper2) {
			case "NORMAL":
				this.typeSecondary = PokemonType.NORMAL;
				break;
			case "FIRE":
				this.typeSecondary = PokemonType.FIRE;
				break;
			case "WATER":
				this.typeSecondary = PokemonType.WATER;
				break;
			case "GRASS":
				this.typeSecondary = PokemonType.GRASS;
				break;
			case "ELECTRIC":
				this.typeSecondary = PokemonType.ELECTRIC;
				break;
			case "PSYCHIC":
				this.typeSecondary = PokemonType.PSYCHIC;
				break;
			case "ICE":
				this.typeSecondary = PokemonType.ICE;
				break;
			case "DRAGON":
				this.typeSecondary = PokemonType.DRAGON;
				break;
			case "DARK":
				this.typeSecondary = PokemonType.DARK;
				break;
			case "FAIRY":
				this.typeSecondary = PokemonType.FAIRY;
				break;
			case "FIGHTING":
				this.typeSecondary = PokemonType.FIGHTING;
				break;
			case "FLYING":
				this.typeSecondary = PokemonType.FLYING;
				break;
			case "POISON":
				this.typeSecondary = PokemonType.POISON;
				break;
			case "GROUND":
				this.typeSecondary = PokemonType.GROUND;
				break;
			case "ROCK":
				this.typeSecondary = PokemonType.ROCK;
				break;
			case "BUG":
				this.typeSecondary = PokemonType.BUG;
				break;
			case "GHOST":
				this.typeSecondary = PokemonType.GHOST;
				break;
			case "STEEL":
				this.typeSecondary = PokemonType.STEEL;
				break;
			default:
				this.typeSecondary = PokemonType.NONE;
		}
	}
	
	/**
	 * @return the egg
	 */
	public EggGroup[] getEggGroup() {
		EggGroup[] group = new EggGroup[2];
		group[0] = this.eggPrimary;
		if(this.eggSecondary == null ) {
			this.eggSecondary = EggGroup.NONE;
		}
		group[1] = this.eggSecondary;
		return group;
	}
	
	/**
	 * @param Set eggPrimary
	 */
	public void setEggGroup(String egg1) {
		String upper = egg1.toUpperCase();
	
		switch(upper) {
		case "MONSTER":
			this.eggPrimary = EggGroup.MONSTER;
			break;
		case "HUMANLIKE":
			this.eggPrimary = EggGroup.HUMANLIKE;
			break;
		case "FIELD":
			this.eggPrimary = EggGroup.FIELD;
			break;
		case "FLYING":
			this.eggPrimary = EggGroup.FLYING;
			break;
		case "DRAGON":
			this.eggPrimary = EggGroup.DRAGON;
			break;
		case "BUG":
			this.eggPrimary = EggGroup.BUG;
			break;
		case "WATER1":
			this.eggPrimary = EggGroup.WATER1;
			break;
		case "WATER2":
			this.eggPrimary = EggGroup.WATER2;
			break;
		case "WATER3":
			this.eggPrimary = EggGroup.WATER2;
			break;
		case "GRASS":
			this.eggPrimary = EggGroup.GRASS;
			break;
		case "AMORPHOUS":
			this.eggPrimary = EggGroup.AMORPHOUS;
			break;
		case "MINERAL":
			this.eggPrimary = EggGroup.MINERAL;
			break;
		default:
			this.eggPrimary = EggGroup.NONE;
		}
	}
	
	/**
	 * @param Set eggPrimary
	 * @param Set eggSecondary
	 */
	public void setEggGroup(String egg1, String egg2) {
		String upper = egg1.toUpperCase();
		String upper2 = egg2.toUpperCase();
		
		switch(upper) {
		case "MONSTER":
			this.eggPrimary = EggGroup.MONSTER;
			break;
		case "FAIRY":
			this.eggPrimary = EggGroup.FAIRY;
			break;
		case "HUMANLIKE":
			this.eggPrimary = EggGroup.HUMANLIKE;
			break;
		case "FIELD":
			this.eggPrimary = EggGroup.FIELD;
			break;
		case "FLYING":
			this.eggPrimary = EggGroup.FLYING;
			break;
		case "DRAGON":
			this.eggPrimary = EggGroup.DRAGON;
			break;
		case "BUG":
			this.eggPrimary = EggGroup.BUG;
			break;
		case "WATER1":
			this.eggPrimary = EggGroup.WATER1;
			break;
		case "WATER2":
			this.eggPrimary = EggGroup.WATER2;
			break;
		case "WATER3":
			this.eggPrimary = EggGroup.WATER2;
			break;
		case "GRASS":
			this.eggPrimary = EggGroup.GRASS;
			break;
		case "AMORPHOUS":
			this.eggPrimary = EggGroup.AMORPHOUS;
			break;
		case "MINERAL":
			this.eggPrimary = EggGroup.MINERAL;
			break;
		default:
			this.eggPrimary = EggGroup.NONE;
		}
		
		switch(upper2) {
		case "MONSTER":
			this.eggSecondary = EggGroup.MONSTER;
			break;
		case "FAIRY":
			this.eggSecondary = EggGroup.FAIRY;
			break;
		case "HUMANLIKE":
			this.eggSecondary = EggGroup.HUMANLIKE;
			break;
		case "FIELD":
			this.eggSecondary = EggGroup.FIELD;
			break;
		case "FLYING":
			this.eggSecondary = EggGroup.FLYING;
			break;
		case "DRAGON":
			this.eggSecondary = EggGroup.DRAGON;
			break;
		case "BUG":
			this.eggSecondary = EggGroup.BUG;
			break;
		case "WATER1":
			this.eggSecondary = EggGroup.WATER1;
			break;
		case "WATER2":
			this.eggSecondary= EggGroup.WATER2;
			break;
		case "WATER3":
			this.eggSecondary = EggGroup.WATER2;
			break;
		case "GRASS":
			this.eggSecondary = EggGroup.GRASS;
			break;
		case "AMORPHOUS":
			this.eggSecondary = EggGroup.AMORPHOUS;
			break;
		case "MINERAL":
			this.eggSecondary = EggGroup.MINERAL;
			break;
		default:
			this.eggSecondary = EggGroup.NONE;
		}
		
	}
	
	/*
	 * @param g set Gender of Pokemon
	 */
	public void setGender(String g) {
		String upper = g.toUpperCase();
		
		switch(upper) {
		case "MALE":
			this.gender = Gender.MALE;
			break;
		case "FEMALE":
			this.gender = Gender.FEMALE;
			break;
		default:
			this.gender = Gender.GENDERLESS;
		}
	}
	
	public Gender getGender() {
		return this.gender;
	}
	
	/*
	 * Determines gender of pokemon based on chances of females
	 */
	private void genderSelection(double femaleChance) {
		Random rand = new Random();
		int n = rand.nextInt(101);
		double d = Double.valueOf(n);
		
		if (d > femaleChance) {
			this.gender = Gender.MALE;
		} else {
			this.gender = Gender.FEMALE;
		}
		
	}
	
	/**
	 * @return the isEgg
	 */
	public boolean isEgg() {
		return isEgg;
	}

	/**
	 * @param isEgg the isEgg to set
	 */
	public void setEgg(boolean isEgg) {
		this.isEgg = isEgg;
	}

	public String toString() {
		String output = String.format("Pokemon: %s \nPrimary Type: %s \nSecondary Type: %s \nLevel: %s \nEgg Primary: %s \nEgg Secdondary: %s \nNatDex: %s \nGender: %s ", species, typePrimary, typeSecondary, level, eggPrimary, eggSecondary, natDexNumber, gender);
		return output;
	}
	
}
