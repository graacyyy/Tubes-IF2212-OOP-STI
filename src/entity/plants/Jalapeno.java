package entity.plants;

import entity.zombies.*;

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
=======
        fileimage = "././res/plant/Jalapeno.png";
>>>>>>> origin/main
    }

    @Override
    public void instantKill(Zombie zombie){
        
        zombie.setHealth(0);
    }

    @Override
    public void actionPerformed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
