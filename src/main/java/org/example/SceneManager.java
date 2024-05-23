package org.example;

import org.example.enums.SceneEnum;
import org.example.scene.GameMapScene;
import org.example.scene.IScene;
import org.example.scene.InventoryScene;
import org.example.scene.MainScene;

import java.util.ArrayList;
import java.util.Scanner;


public class SceneManager {
    public ArrayList<IScene> sceneArray;
    private int index;

    public IScene getCurrentScene() {
        return sceneArray.get(index);
    }

    public void setCurrentScene(SceneEnum scene) {
        index = scene.ordinal();
    }

    public SceneManager() {
        sceneArray = new ArrayList<IScene>();
        index = SceneEnum.MAIN_SCENE.ordinal();


        // Adding scenes to array
        sceneArray.add(SceneEnum.MAIN_SCENE.ordinal(),new MainScene());
        sceneArray.add(SceneEnum.GAME_MAP_SCENE.ordinal(),new GameMapScene());
        sceneArray.add(SceneEnum.INV_SCENE.ordinal(),new InventoryScene());

        // Initializing all scenes
        for (IScene scene : sceneArray) {
            scene.init(this);
        }
    }

    public void loop(){
        String line = "";
        while (true) {
            getCurrentScene().update(line);
            getCurrentScene().render();
            Scanner sc = new Scanner(System.in);
            line = sc.nextLine();
        }
    }
}
