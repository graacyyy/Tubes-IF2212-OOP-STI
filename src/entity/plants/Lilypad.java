package entity.plants;

import entity.zombies.*;

public class Lilypad extends Plant {
    
    public Lilypad(int x, int y) {

        super(x, y);
        name = "Pea Shooter";
        cost = 25;
        health = 100;
        attack_damage = 0;
        attack_speed = 0;
        range = 0;
        cooldown = 10;
        is_waterplant = true;
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
