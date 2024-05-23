package org.example;

import org.example.items.Apple;
import org.example.items.IItem;
import org.example.items.Sword;

import java.util.ArrayList;

public class Player {
    public int health;

    public ArrayList<IItem> inventory;

    public static final Player instance = new Player();

    public Player() {
        this.health = 100;
        this.inventory = new ArrayList<>();

        this.inventory.add(new Apple());
        this.inventory.add(new Sword());
    }
}
