package com.tac33.items;

import java.util.HashMap;

import com.tac33.items.enums.*;

public class Item {
	private Items name;
	private ItemType itemType;
	static HashMap<Items, String> description = new HashMap<Items, String>();
	
	
	
	public Item(Items name, ItemType itemType, String description) {
		this.setName(name);
		this.setItemType(itemType);
		Item.description.put(name, description);
		
	}



	/**
	 * @return the name
	 */
	public Items getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(Items name) {
		this.name = name;
	}



	/**
	 * @return the itemType
	 */
	public ItemType getItemType() {
		return itemType;
	}



	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	
	public String getDescription(Items item) {
		return description.get(item);
	}
}
