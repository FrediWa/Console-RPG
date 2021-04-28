package com.assignment;

import java.io.Serializable;

public class Game implements Serializable {
    Human p;
    Shop shop;
    public Game(Human p, Shop shop){
        this.p = p;
        this.shop = shop;
    }
    /*


    public static Game load(String saveData) {
    }
*/  public void saveGame(){
        FileUtils.saveObject(this, "savefile.txt");
    }
    public static Object load(){
        return FileUtils.loadObject("savefile.txt");
}
    public void start(){
        System.out.println("Greetings traveler");
        while(true){
            int select = 0;
            System.out.println("What do you want to do next?" +
                    "\n1. Buy things" +
                    "\n2. Check your inventory" +
                    "\n3. Go on an adventure" +
                    "\n4. Show player info" +
                    "\n5. Save and quit");
            select = Utils.getIntInput();


            switch (select) {
                case 1:
                    shop.openShop(p);
                    break;
                case 2:
                    p.inventory.viewInventory();
                    break;
                case 3:
                    this.fight();
                    break;
                case 4:
                    p.showInfo();
                    break;
                case 5:
                    this.saveGame();
                    System.out.println("Quit? [Yes/No]");
                    String sel = Utils.getStringInput();
                    System.out.println(sel);
                    if(sel.equals("Yes") || sel.equals("yes")){

                        System.exit( 0);
                    }
                    break;
                default:
                    System.out.println("Enter a valid option\n");
            }

        }


    }
    private void fight(){
        int eL = p.getPlayerLevel() + (int) Math.round(Math.random());
        System.out.println("Generating enemy of level" + eL);
        Enemy en = Enemy.generateRandomEnemy(eL);
        System.out.printf("You've encountered a level %d %s\n", en.level, en.getPlayerName());
        int select = 0;
        System.out.println("What do you want to do?" +
                "\n1. Fight it" +
                "\n2. Run away");
        select = Utils.getIntInput();
        if(select == 1){
            while(true){
                p.attack(en);
                if(en.isDead()){
                    p.victory(en.level);
                    break;
                }
                en.attack(p);
            }
        }else{
            System.out.println("Successfully ran away");
        }
        //Enemy en = new Enemy();
    }

}