package entity.plants;

import entity.zombies.*;

public class Lilypad extends Plant {
    
    public Lilypad(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown,
            boolean is_waterplant) {
        super("Lilypad", 25, 100, 0, 0, 0, 10, true);
    }

    @Override
    public void instantKill(Zombie zombie) {}

    public void addHealthToPlant(Plant plant) {
        plant.setHealth(plant.getHealth() + this.getHealth());
    }
}
