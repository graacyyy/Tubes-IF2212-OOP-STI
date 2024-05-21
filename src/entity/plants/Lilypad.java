package entity.plants;

import entity.zombies.*;

public class Lilypad extends Plant {
    
    public Lilypad(int x, int y) {

        super(x, y);
        name = "Lilypad";
        cost = 25;
        health = 100;
        attack_damage = 0;
        attack_speed = 0;
        range = 0;
        cooldown = 10;
        is_waterplant = true;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        fileimage = "././res/plant/Lilypad.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/Lilypad.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
=======
        fileimage = "././res/plants/lilypad.png";
>>>>>>> 99ce55be5f76d414ce047341f0f806ca01c111ab
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {}
}
