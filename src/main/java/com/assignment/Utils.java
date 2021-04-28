package com.assignment;

import java.util.Scanner;

public class Utils {
    transient static Scanner sc = new Scanner(System.in);
    public static int getIntInput(){
        int sel = sc.nextInt();
        return sel;
    }
    public static String getStringInput(){
        String sel = sc.next();
        return sel;
    }
}
