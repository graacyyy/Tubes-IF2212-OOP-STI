package entity.plants;

import entity.zombies.*;
// import game.Sun;

public class Sunflower extends Plant {
    
    public Sunflower(int x, int y) {

        super(x, y);
        name = "Sunflower";
        cost = 50;
        health = 100;
        attack_damage = 0;
        attack_speed = 0;
        range = 0;
        cooldown = 10;
        is_waterplant = false;
<<<<<<< HEAD
<<<<<<< HEAD
=======
        fileimage = "././res/plant/Sunflower/Sunflower_1.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/Sunflower/Sunflower_1.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
    }

    @Override
    public void instantKill(Zombie zombie) {
    }

    @Override
    public void actionPerformed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    // public void produceSun(Sun sun){
    //     sun.setSunAmount(sun.getSunAmount() + 25);
    // }
}
