package entity.plants;

import entity.zombies.*;

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
=======
        fileimage = "././res/plant/TangledKelp.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/TangledKelp.png";
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