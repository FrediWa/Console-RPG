package com.assignment;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

abstract public class Player implements Serializable {
    int level;
    Map<String, Integer> stats = new HashMap<String, Integer>();
    private String name;
    public int health;
    private int money;
    private int attackBonus;
    private Weapon weapon;
    //private Weapon weapon = new Weapon("Bare hands", 0, -1);

    public int getPlayerLevel(){
        return this.level;
    }
    public boolean isDead(){
        return health <= 0;
    }
    public void setWeapon(Weapon w){
        System.out.println("You've equipped a " + w.name);
        this.attackBonus = w.damage;
        this.weapon = w;
    }
    public Weapon getWeapon(){
        return this.weapon;
    }

    public void setPlayerName(String name){
        this.name = name;
    }
    public String getPlayerName() {
        return this.name;
    }
    public void changeMoney(int dm){ this.money += dm; }
    public int getMoney(){ return this.money; }


    public void hit(int damage){
        this.health -= damage;
        if(this.health < 0){
            System.out.println("\n"+this.getPlayerName() + " died");
            //System.exit(0);
        }
    }
    public void attack(Player target){
        int damage = (int)(Math.random() * 10 + 1);
        damage += this.stats.get("Strength");
        damage += this.attackBonus;
        System.out.println(this.getPlayerName() + " attacked "+target.getPlayerName() +" for "+ damage+" damage");
        target.hit(damage);
    }

}
