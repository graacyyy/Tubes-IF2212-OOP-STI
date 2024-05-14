package entity.plants;

import entity.zombies.*;

public class PeaShooter extends Plant {
    
    public PeaShooter(int x, int y) {

        super(x, y);
        name = "Pea Shooter";
        cost = 100;
        health = 100;
        attack_damage = 25;
        attack_speed = 4;
        range = -1;
        cooldown = 10;
        is_waterplant = false;
        fileimage = "././res/plant/peashooter_0.png";
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {
    }
}
