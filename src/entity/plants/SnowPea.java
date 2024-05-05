package entity.plants;

import entity.zombies.*;;

public class SnowPea extends Plant {

    public SnowPea(){

        super("Snow pea",175, 100, 25, 4, -1, 10, false);
    }

    public void delaySpeed(Zombie zombie){
        zombie.setAS(zombie.getAS()*0.5);
    }
}
