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
        fileimage = "././res/plant/Wallnut/Wallnut_1.png";
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
