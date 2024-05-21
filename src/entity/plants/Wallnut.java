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
<<<<<<< HEAD
=======
        fileimage = "././res/plant/Wallnut/Wallnut_1.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/Wallnut/Wallnut_1.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
=======
        fileimage = "././res/plants/wallnut.png";
>>>>>>> 99ce55be5f76d414ce047341f0f806ca01c111ab
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {}
}
