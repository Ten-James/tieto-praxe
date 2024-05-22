package org.example.scene;

import org.example.SceneManager;
import org.example.Setting;

public class GameMapScene implements IScene {
    SceneManager manager;
    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {

    }

    @Override
    public void render() {
        System.out.println("Mapa");
        System.out.println(Setting.instance.difficultyFactor);
    }
}
