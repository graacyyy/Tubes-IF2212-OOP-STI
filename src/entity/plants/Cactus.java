package entity.plants;

import entity.zombies.Zombie;

public class Cactus extends Plant{
    
    public Cactus(int x, int y){
        
        super(x, y);
        name = "Cactus";
        cost = 125;
        health = 100;
        attack_damage = 40;
        attack_speed = 3;
        range = -1;
        cooldown = 20;
        is_waterplant = false;
        fileimage = "././res/plants/cactus.png";
    }

    @Override
    public void instantKill(Zombie zombie){}

    @Override
    public void actionPerformed() {}
    
}
