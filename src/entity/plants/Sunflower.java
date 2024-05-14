package entity.plants;

import entity.zombies.*;
import game.Sun;

public class Sunflower extends Plant {
    
    public Sunflower(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown,
            boolean is_waterplant) {
        super("Sunflower", 50, 100, 0, 0, 0, 10, false);
    }

    @Override
    public void instantKill(Zombie zombie) {
    }

    public void produceSun(Sun sun){
        sun.setSunAmount(sun.getSunAmount() + 25);
    }
}
