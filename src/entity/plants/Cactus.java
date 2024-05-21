package entity.plants;

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
<<<<<<< HEAD
<<<<<<< HEAD
=======
        fileimage = "././res/plant/Cactus/Cactus_1.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/Cactus/Cactus_1.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
    }

    @Override
    public void instantKill(Zombie zombie){}

    @Override
    public void actionPerformed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
