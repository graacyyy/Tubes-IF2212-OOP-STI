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
        fileimage = "././res/plants/sunflower.png";
    }

    @Override
    public void instantKill(Zombie zombie) {
    }

    @Override
    public void actionPerformed() {}

    // public void produceSun(Sun sun){
    //     sun.setSunAmount(sun.getSunAmount() + 25);
    // }
}
