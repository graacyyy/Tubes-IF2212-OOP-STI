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
        is_waterplant = false;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        fileimage = "././res/plant/Jalapeno.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/Jalapeno.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
=======
        fileimage = "././res/plants/jalapeno.png";
>>>>>>> 99ce55be5f76d414ce047341f0f806ca01c111ab
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
