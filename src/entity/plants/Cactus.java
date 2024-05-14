package entity.plants;

import entity.zombies.BalloonZombie;
import entity.zombies.Zombie;

public class Cactus extends Plant{
    
    public Cactus(){
        super("Cactus", 125,100, 40,3, -1, 20, false);
    }

    @Override
    public void instantKill(Zombie zombie){}
    
    public void popBalloon(Zombie zombie){
        if (zombie instanceof BalloonZombie){
            int newHealth = (int) (zombie.getHealth() * 0.5);
            zombie.setHealth(newHealth);
        }  
    }
}
