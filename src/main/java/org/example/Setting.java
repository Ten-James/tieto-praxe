package org.example;

public class Setting {
    public static Setting instance = new Setting();

    public double difficultyFactor;

    public Setting() {
        this.difficultyFactor = 1.0;
    }

}
