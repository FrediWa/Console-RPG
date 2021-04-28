package com.assignment;
import java.io.Serializable;
import java.util.Random;

public class Weapon extends Item implements Serializable {
    int damage;
    int durability;
    public Weapon(String name, int damage, int durability){
        this.name = name;
        this.damage = damage;
        this.durability = durability;
    }


    enum WeaponType{
        MELEE, RANGED
    }
    public static Weapon generateRandomWeapon(int rarity, int level){
        Random rand = new Random();
        double variance = 1 + Math.random();
        String name = weaponNames[rarity][rand.nextInt(weaponNames[rarity].length)];
        int damage = (int)(variance*level*rarity*rarity + 20);
        int dur = (int)(variance*level*level*rarity*0.5);
        return new Weapon(name, damage, dur);
    }
    private static String weaponNames[][] = {
            {"Iron Sword"},//Common
            {"Diamond Sword"},//Rare
            {"Dragonstone Sword"},//Epic
            {"The Storm"}//Legendary
    };
    /*
    public Weapon getRandomWeapon(int level){
        return (new Weapon("Stick", 2, 10));
    }
*/
}

