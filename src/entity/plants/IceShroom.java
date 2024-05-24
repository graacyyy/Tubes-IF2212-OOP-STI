package entity.plants;

import entity.zombies.*;
import tile.GameMap;

public class IceShroom extends Plant{
    
    public IceShroom(int x, int y){

        super(x, y);
        name = "Ice Shroom";
        cost = 75;
        health = 100;
        attack_damage = 20;
        attack_speed = 0;
        range = -1;
        cooldown = 20;
        fileimage = "././res/plants/iceshroom.png";
    }

    // METHODS
    public void freeze(Zombie zombie){
    
        zombie.setIsFreezed(true);
        zombie.setIsMoving(false);
        zombie.setFreezeTime(0);
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {

        if (timer >= 3){
            for (Zombie zombie : GameMap.zombies) {
                freeze(zombie);
                System.out.println("freeze");
            }
            health = 0;
        }   
        else timer++;
    }
}