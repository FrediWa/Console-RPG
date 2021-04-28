package com.assignment;
import java.util.Random;

public class Enemy extends Player{


    public Enemy(String name, int level){
        this.health = 100;
        this.level = level;
        this.setPlayerName(name);
        this.stats.put("Strength", level);
        this.stats.put("Vitality", level);
    }

    public static Enemy generateRandomEnemy(double lvl) {
        Random rand = new Random();
        int nLvl = (int) Math.floor(lvl/10);
        int n = rand.nextInt(enemies[nLvl].length);
        String eName = enemies[nLvl][n];
        Enemy en = new Enemy(eName, (int) lvl);
        return(en);
    }


    private static String enemies[][] = {
            {"Goblin", "Boar"},
            {"Skeleton", "Orc", "Ghost"},
            {"Dragon", "Lich"}
    };
}
