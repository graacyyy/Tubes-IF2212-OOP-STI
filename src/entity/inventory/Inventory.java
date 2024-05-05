package entity.inventory;
import java.util.ArrayList;

import entity.plants.Plant;

public class Inventory {
    private ArrayList<Plant> inventory;

    public Inventory(ArrayList<Plant> inventory) {
        this.inventory = inventory;

        inventory.add(Sunflower);
        inventory.add(Peashooter);
        inventory.add(WallNut);
        inventory.add(SnowPea);
        inventory.add(Squash);
        inventory.add(Lilypad);
        inventory.add(Jalapeno);
        inventory.add(Cactus);
        inventory.add(TangleKelp);
        inventory.add(IceShroom);
    }

    public void showInventory(){
        System.out.println("Inventory: ");

        for (Plant plant : inventory){
            System.out.println("Name: " + plant.getName());
            System.out.println("Cost: " + plant.getCost());
            System.out.println("Health: " + plant.getHealth());
            System.out.println("Attack Damage: " + plant.getAD());
            System.out.println("Attack Speed: " + plant.getAS());
            System.out.println("Range: " + plant.getRange());
            System.out.println("Cooldown: " + plant.getCooldown());
        }
    }

    public boolean isOnDeck(plant Plant){
        for (Plant plant : deck){
            return deck.contains(plant);
        }
    }
}
