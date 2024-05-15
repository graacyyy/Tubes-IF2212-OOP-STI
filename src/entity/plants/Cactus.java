package entity.plants;

import entity.zombies.BalloonZombie;
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
    }

    public void popBalloon(Zombie zombie){
        if (zombie instanceof BalloonZombie){
            int newHealth = (int) (zombie.getHealth() * 0.5);
            zombie.setHealth(newHealth);
        }  
    }

    @Override
    public void instantKill(Zombie zombie){}

    @Override
    public void actionPerformed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}