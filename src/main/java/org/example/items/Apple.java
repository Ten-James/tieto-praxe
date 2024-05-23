package org.example.items;

import org.example.Player;

public class Apple implements IItem, IConsumable {
    @Override
    public boolean canBeConsumed() {
        return true;
    }

    @Override
    public void onConsume() {
        Player.instance.health += 10;
    }

    @Override
    public String getName() {
        return "Apple";
    }
}
