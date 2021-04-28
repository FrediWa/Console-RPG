package com.assignment;

import java.io.FileNotFoundException;

public class Main {


	public static void main(String[] args) {
		//FileUtils.writeTextFile("Hello!", "hello.txt");
		//
		//System.out.println(x);
		//
		String x = FileUtils.readTextFile("savefile.txt");

		if(x.equals("6e6f7420666f756e64a")){
			Human player = new Human();
			Weapon i1 = new Weapon("Iron Sword", 20, 100);
			player.inventory.addItem(i1);

			Shop shop = new Shop();
			shop.init(); //this optional method adds a few default things to the shop, hence not called from the constructor method

			Game game = new Game(player, shop);
			game.start();
		} else {
			Game game = (Game) Game.load();
			game.start();
		}


	}
}

