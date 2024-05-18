package entity.plants;

import entity.zombies.*;

import tile.GameMap;

public class SnowPea extends Plant {

    int timer = 0;

    public SnowPea(int x, int y){

        super(x, y);
        name = "Snow Pea";
        cost = 175;
        health = 100;
        attack_damage = 25;
        attack_speed = 4;
        range = -1;
        cooldown = 10;
        is_waterplant = false;
        fileimage = "././res/plants/snowpea.png";
    }

    public void delaySpeed(Zombie zombie){
        zombie.setIsSlowed(true);
    }

    public void shootPea(){
      
        SnowBullet bullet = new SnowBullet(x, y, attack_damage);
        GameMap.bullets.add(bullet);
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {
        if (timer >= 60){
            for (Zombie zombie : GameMap.zombies) {
                if (zombie.getY() == y){
                    shootPea();
                }
            }
            timer = 0;
        }
        else {
            timer++;
        }
    }
}
