package org.example.scene;

import org.example.Setting;
import org.example.enums.SceneEnum;
import org.example.SceneManager;

public class MainScene implements IScene {
    SceneManager manager;
    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        if (line.contains("4")) {
            Setting.instance.difficultyFactor = 10;
        }

        if (line.contains("1")) {
            manager.setCurrentScene(SceneEnum.GAME_MAP_SCENE);
        }
    }

    @Override
    public void render() {
        System.out.println("Main Menu");
        System.out.println("[1] Hrat");
        System.out.println("[2] nastaveni");
        System.out.println("[3] Credits");
        System.out.println("[4] Exit");

    }
}
