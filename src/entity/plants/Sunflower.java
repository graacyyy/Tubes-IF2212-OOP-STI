package entity.plants;

import entity.Sun;
import entity.zombies.*;
// import game.Sun;

public class Sunflower extends Plant {

    int timer = 0;
    int sec = 0;
    
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
<<<<<<< HEAD
=======
        fileimage = "././res/plant/Sunflower/Sunflower_1.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/Sunflower/Sunflower_1.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
=======
        fileimage = "././res/plants/sunflower.png";
>>>>>>> 99ce55be5f76d414ce047341f0f806ca01c111ab
    }

    @Override
    public void instantKill(Zombie zombie) {
    }

    @Override
    public void actionPerformed() {
        if (timer >= 60){
            sec++;
            timer = 0;
        } else timer++;
        
        if (sec == 3) {
            Sun.addsun(25);
            System.out.println("Sun dari sunflower");
            sec = 0;
        }
    }
}

    // public void produceSun(Sun sun){
    //     sun.setSunAmount(sun.getSunAmount() + 25);
    // }
