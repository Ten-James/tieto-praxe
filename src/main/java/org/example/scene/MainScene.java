package org.example.scene;

import org.example.Player;
import org.example.Setting;
import org.example.enums.SceneEnum;
import org.example.SceneManager;

public class MainScene implements IScene {
    // Get reference of player Singleton
    Player player = Player.instance;

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
        if (line.contains("2")) {
            manager.setCurrentScene(SceneEnum.INV_SCENE);
        }
    }

    @Override
    public void render() {
        System.out.println("hp: " + player.health);
        System.out.print("[1] Mapa ");
        System.out.print("[2] Inventory");
        System.out.println();

    }
}
