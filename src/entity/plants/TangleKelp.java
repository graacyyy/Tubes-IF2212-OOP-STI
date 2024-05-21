package entity.plants;

import entity.zombies.*;
import main.GamePanel;
import tile.GameMap;

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        fileimage = "././res/plant/TangledKelp.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/TangledKelp.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
=======
        fileimage = "././res/plants/tanglekelp.png";
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