package entity;
import java.util.ArrayList;

import entity.plants.Plant;
import entity.plants.Sunflower;
import entity.plants.PeaShooter;
import entity.plants.Wallnut;
import entity.plants.SnowPea;
import entity.plants.Squash;
import entity.plants.Lilypad;
import entity.plants.Cactus;
import entity.plants.TangleKelp;
import entity.plants.Jalapeno;
import entity.plants.IceShroom;


public class Inventory {
    private ArrayList<Plant> inventory;

    public Inventory(ArrayList<Plant> inventory) {
        this.inventory = inventory;

        inventory.add(new Sunflower());
        inventory.add(new PeaShooter());
        inventory.add(new Wallnut());
        inventory.add(new SnowPea());
        inventory.add(new Squash());
        inventory.add(new Lilypad());
        inventory.add(new Jalapeno());
        inventory.add(new Cactus());
        inventory.add(new TangleKelp());
        inventory.add(new IceShroom());
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
            System.out.println(" ");
        }
    }
}
