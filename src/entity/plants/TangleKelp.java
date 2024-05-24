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
        fileimage = "././res/plants/tanglekelp.png";
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