package entity.plants;

import entity.zombies.*;

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
        fileimage = "././res/plant/Squash/Squash_1.png";       
>>>>>>> origin/main
=======
        is_waterplant = false; 
        fileimage = "././res/plant/Squash/Squash_1.png";       
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
    }

    @Override
    public void instantKill(Zombie zombie) {
        
        zombie.setHealth(0);
    }

    @Override
    public void actionPerformed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
