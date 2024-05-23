package org.example.scene;

import org.example.Player;
import org.example.SceneManager;
import org.example.enums.SceneEnum;
import org.example.items.IConsumable;
import org.example.items.IEquipable;
import org.example.items.IItem;

public class InventoryScene implements IScene {
    SceneManager manager;
    Player player = Player.instance;

    int selectedItem = -1;

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;

    }

    @Override
    public void update(String line) {
        if (selectedItem != -1) {
            IItem item = player.inventory.get(selectedItem);
            if (item instanceof IConsumable consumable) {
                if (line.equals("c") && consumable.canBeConsumed()) {
                    consumable.onConsume();
                    player.inventory.remove(selectedItem);
                    selectedItem = -1;
                }
            }
        }
        //parse int from line
        try {
            int i = Integer.parseInt(line);
            if (i >= 0 && i < player.inventory.size()) {
                selectedItem = i;
            }
        } catch (NumberFormatException e) {
            if (line.equals("back")) {
                if (selectedItem != -1) {
                    selectedItem = -1;
                } else {
                    manager.setCurrentScene(SceneEnum.MAIN_SCENE);
                }
            }
        }

    }

    @Override
    public void render() {
        if (selectedItem != -1) {
            IItem item = player.inventory.get(selectedItem);
            System.out.println("Selected item: " + item.getName());

            if (item instanceof IEquipable) {
                System.out.println("Equipable");
            }

            if (item instanceof IConsumable) {
                System.out.println("[c] Consume");
            }
            return;
        }


        System.out.println("Inventory:");
        for (int i = 0; i < player.inventory.size(); i++) {
            System.out.println("[" + i + "] " + player.inventory.get(i).getName());
        }

    }
}
