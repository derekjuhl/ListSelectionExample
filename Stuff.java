package com.spconger.JListSelection;

import java.util.ArrayList;

public class Stuff {
	ArrayList<Item>items;
	
	public Stuff(){
		items = new ArrayList<Item>();
	}
	
	public void AddItem(Item i){
		items.add(i);
	}
	
	public Item getItem(String name){
		Item item=null;
		for(Item i:items){
			if(i.getName().equals(name)){
				item=i;
			}
		}
		return item;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
}
