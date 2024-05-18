package entity.plants;

import entity.zombies.*;

public class TangleKelp extends Plant{

    public TangleKelp(int x, int y){

        super(x, y);
        name = "Tangle Kelp";
        cost = 25;
        health = 100;
        attack_damage = 2000;
        attack_speed = 0;
        range = -1;
        cooldown = 20;
        is_waterplant = true;
        fileimage = "././res/plants/tanglekelp.png";
    }

    @Override
    public void instantKill(Zombie zombie) {
        
        zombie.setHealth(0);
    }

    @Override
    public void actionPerformed() {}
}