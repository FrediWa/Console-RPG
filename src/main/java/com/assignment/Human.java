package com.assignment;
import java.io.Serializable;

public class Human extends Player implements Serializable {
    Inventory inventory;
    int xp = 0;
    int xpToNextLevel;
    int maxHealth;
    public void levelUp(){
        System.out.println("Level up! \nChoose a stat to increase");
        System.out.println("Stat increase not yet implmented :(");
        this.level++;
    }
    public void showInfo(){
        System.out.printf("You are level %d\n", this.level);
        System.out.printf("XP: %d/%d\n", this.xp, this.xpToNextLevel);
        System.out.printf("You have %d money\n", this.getMoney());
    }
    public void victory(int enemyLvl){
        this.health = maxHealth;
        this.changeMoney((int)(Math.random() * 10 + 1));
        int xp = (int)(Math.random() * 10 + 1) + enemyLvl*2;
        System.out.printf("You got %d XP\n", xp);
        this.xp += xp;
        if(this.xp >= this.xpToNextLevel) {
            this.xp = 0;
            this.xpToNextLevel = (int)(Math.pow((this.level+1), 2.4));
            levelUp();
        }
    }
    public void addToInventory(Item i){
        this.inventory.addItem(i);
    }
    public void setInventory(Inventory inv){
        this.inventory = inv;
        inv.setOwner(this);
    }

    @Override
    public void hit(int damage) {
        super.hit(damage);
        if(health <= 0){
            System.out.println("Game over");
            System.exit(0);
        }
    }

    public Human(){
        Inventory p1 = new Inventory();
        this.setInventory(p1);
        level = 1;
        xpToNextLevel = (int)(Math.pow((this.level+1), 2.4));
        maxHealth = 100;
        health = maxHealth;
        System.out.println("Enter name for player: ");
        this.setPlayerName(Utils.getStringInput());
        stats.put("Strength", 2);
        stats.put("Vitality", 1);
    }
}
