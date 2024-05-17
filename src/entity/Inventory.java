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

    protected ArrayList<Plant> inventory;
    

    public Inventory(ArrayList<Plant> inventory) {
        this.inventory = inventory;

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
