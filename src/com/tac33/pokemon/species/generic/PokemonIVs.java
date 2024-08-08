package com.tac33.pokemon.species.generic;

import java.util.Random;

public abstract class PokemonIVs {
private int hpIV;
private int attackIV;
private int defenseIV;
private int specialAttackIV;
private int specialDefenseIV;
private int speedIV;
/**
 * @return the hpIV
 */
public int getHpIV() {
	return hpIV;
}
/**
 * @param hpIV the hpIV to set
 */
public void setHpIV(int hpIV) {
	this.hpIV = hpIV;
}
/**
 * @return the attackIV
 */
public int getAttackIV() {
	return attackIV;
}
/**
 * @param attackIV the attackIV to set
 */
public void setAttackIV(int attackIV) {
	this.attackIV = attackIV;
}
/**
 * @return the defenseIV
 */
public int getDefenseIV() {
	return defenseIV;
}
/**
 * @param defenseIV the defenseIV to set
 */
public void setDefenseIV(int defenseIV) {
	this.defenseIV = defenseIV;
}
/**
 * @return the specialAttackIV
 */
public int getSpecialAttackIV() {
	return specialAttackIV;
}
/**
 * @param specialAttackIV the specialAttackIV to set
 */
public void setSpecialAttackIV(int specialAttackIV) {
	this.specialAttackIV = specialAttackIV;
}
/**
 * @return the specialDefenseIV
 */
public int getSpecialDefenseIV() {
	return specialDefenseIV;
}
/**
 * @param specialDefenseIV the specialDefenseIV to set
 */
public void setSpecialDefenseIV(int specialDefenseIV) {
	this.specialDefenseIV = specialDefenseIV;
}
/**
 * @return the speedIV
 */
public int getSpeedIV() {
	return speedIV;
}
/**
 * @param speedIV the speedIV to set
 */
public void setSpeedIV(int speedIV) {
	this.speedIV = speedIV;
}

public void setIVs(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed) {
	this.hpIV = hp;
	this.attackIV = attack;
	this.defenseIV = defense;
	this.specialAttackIV = specialAttack;
	this.specialDefenseIV = specialDefense;
	this.speedIV = speed;
}

/*
 * return IV stats in array
 */
public int[] getIVs() {
	int[] arr = new int[6];
	arr[0] = this.hpIV;
	arr[1] = this.attackIV;
	arr[2] = this.defenseIV;
	arr[3] = this.specialAttackIV;
	arr[4] = this.specialDefenseIV;
	arr[5] = this.speedIV;
	
	return arr;
}

/*
 * Return random number 0-31
 */
public int getRandomIV() {
	Random rand = new Random();
	
	/*
	 * Random number 0-31.
	 */
	int n = rand.nextInt(32);
	
	return n;
}



}
