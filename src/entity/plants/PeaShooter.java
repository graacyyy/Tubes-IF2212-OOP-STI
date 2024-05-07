package entity.plants;

import entity.zombies.*;

public class PeaShooter extends Plant {
    
    public PeaShooter(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown,
            boolean is_waterplant) {
        super("PeaShooter", 100, 100, 25, 4, -1, 10, false);
    }

    @Override
    public void instantKill(Zombie zombie) {
        // TODO
    }
}
