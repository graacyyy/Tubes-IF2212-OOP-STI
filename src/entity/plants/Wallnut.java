package entity.plants;

import entity.zombies.Zombie;

public class Wallnut extends Plant{
    
    public Wallnut(int x, int y){

        super(x, y);
        name = "Wallnut";
        cost = 50;
        health = 1000;
        attack_damage = 0;
        attack_speed = 0;
        range = 0;
        cooldown = 20;
        is_waterplant = false;
<<<<<<< HEAD
<<<<<<< HEAD
=======
        fileimage = "././res/plant/Wallnut/Wallnut_1.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/Wallnut/Wallnut_1.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
