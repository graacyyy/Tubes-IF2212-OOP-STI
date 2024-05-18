package entity.plants;

import entity.zombies.*;

public class Jalapeno extends Plant{
    
    public Jalapeno(int x, int y) {
        
        super(x, y);
        name = "Jalapeno";
        cost = 125;
        health = 100;
        attack_damage = 10000;
        attack_speed = 0;
        range = -1;
        cooldown = 20;
        is_waterplant = false;
        fileimage = "././res/plants/jalapeno.png";
    }

    @Override
    public void instantKill(Zombie zombie){
        
        zombie.setHealth(0);
    }

    @Override
    public void actionPerformed() {}
}
