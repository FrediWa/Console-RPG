package com.assignment;

import java.io.Serializable;

public class ShopItem implements Serializable {
    Item i;
    int price;
    public ShopItem(Item i, int price){
        this.i = i;
        this.price = price;
    }
}
