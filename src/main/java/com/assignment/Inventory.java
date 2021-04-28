package com.assignment;
import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {
    private Human owner;
    private ArrayList<Item> items = new ArrayList<Item>();
    public void viewInventory(){
        if(this.items.size() == 0){
            System.out.println("Your inventory is empty\nExplore to find loot or buy items from the shop");
        }else{
            System.out.println("Chose an item to use");
            for(int i = 0; i < this.items.size(); i++){
                System.out.printf("%d. %s\n", (i+1), this.items.get(i).name);
            }
            int select = Utils.getIntInput();
            Item targetItem = this.items.get(select-1);
            if(targetItem instanceof Weapon){
                owner.setWeapon((Weapon) targetItem);
            }
        }
    }
    public void setOwner(Human target){
        this.owner = target;
    }
    public void addItem(Item item){
        this.items.add(item);
    }

}
