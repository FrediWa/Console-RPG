package com.assignment;


import java.io.Serializable;
import java.util.ArrayList;

public class Shop implements Serializable {
    private ArrayList<ShopItem> shopItems = new ArrayList<ShopItem>();
    public void openShop(Human customer){
        if(this.shopItems.size() == 0){
            System.out.println("The shop is empty :( \nCome back later");
        }else{
            System.out.println("Chose an item to buy. Enter 0 to exit shop");
            for(int i = 0; i < this.shopItems.size(); i++){
                System.out.printf("%d. %s (%s money)\n", (i+1), this.shopItems.get(i).i.name, this.shopItems.get(i).price);
            }
            int select = Utils.getIntInput();
            if(select != 0){
                ShopItem targetItem = this.shopItems.get(select-1);
                System.out.println(buyItem(targetItem, customer) == true ? "Item added to inventory" : "Not enough money");
            }


        }
    }
    public boolean buyItem(ShopItem shopItem, Human customer){
        if(customer.getMoney() > shopItem.price) {
            customer.addToInventory(shopItem.i);
            customer.changeMoney(-1 * shopItem.price);
            return true;
        }
        return false;
    }
    public void init(){
        shopItems.add(new ShopItem(Weapon.generateRandomWeapon(3,1), 200));
        shopItems.add(new ShopItem(Weapon.generateRandomWeapon(2,1), 100));
        shopItems.add(new ShopItem(Weapon.generateRandomWeapon(1,1), 50));
    }

}
