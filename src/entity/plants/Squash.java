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
        is_waterplant = false; 
        fileimage = "././res/plants/squash.png";       
    }

    @Override
    public void instantKill(Zombie zombie) {
        
        zombie.setHealth(0);
    }

    @Override
    public void actionPerformed() {
        if (timer >= 3){
            for (Zombie zombie : GameMap.zombies) {
                if (zombie.getX() <= x + GamePanel.tileSize+30 && zombie.getX() >= x && zombie.getY() == y){
                    instantKill(zombie);
                    health = 0;
                }
            }
        }
        else timer++;
    }

}
