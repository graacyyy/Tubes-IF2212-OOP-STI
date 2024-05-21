package entity.plants;

import entity.zombies.*;
import main.GamePanel;
import tile.GameMap;

public class Squash extends Plant {

    public Squash(int x, int y){

        super(x, y);
        name = "Squash";
        cost = 50;
        health = 100;
        attack_damage = 5000;
        attack_speed = 0;
        range = -1;
        cooldown = 20;
<<<<<<< HEAD
<<<<<<< HEAD
        is_waterplant = false;        
=======
        is_waterplant = false; 
<<<<<<< HEAD
        fileimage = "././res/plant/Squash/Squash_1.png";       
>>>>>>> origin/main
=======
        is_waterplant = false; 
        fileimage = "././res/plant/Squash/Squash_1.png";       
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
=======
        fileimage = "././res/plants/squash.png";       
>>>>>>> 99ce55be5f76d414ce047341f0f806ca01c111ab
    }

    @Override
    public void instantKill(Zombie zombie) {
        
        zombie.setHealth(0);
    }

    @Override
    public void actionPerformed() {
        if (timer >= 3){
            for (Zombie zombie : GameMap.zombies) {
                if (zombie.getX() <= x + GamePanel.tileSize && zombie.getX() >= x && zombie.getY() == y){
                    instantKill(zombie);
                    health = 0;
                }
            }
        }
        else timer++;
    }

}
