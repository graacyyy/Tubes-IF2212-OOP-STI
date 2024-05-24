package entity.plants;

import entity.zombies.*;
import tile.GameMap;

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
        fileimage = "././res/plants/jalapeno.png";
    }

    @Override
    public void instantKill(Zombie zombie){
        
        zombie.setHealth(0);
    }

    @Override
    public void actionPerformed() {

        if (timer >= 3){
            for (Zombie zombie : GameMap.zombies) {
                if (zombie.getY() == y){
                    instantKill(zombie);
                }
            }
            health = 0;
        }   
        else timer++;
    }
}
