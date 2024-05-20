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

    public void shootPea(){
      
        SnowBullet bullet = new SnowBullet(x, y, attack_damage);
        GameMap.bullets.add(bullet);
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {
        shootable = true;
        if (timer >= 90){
            for (Zombie zombie : GameMap.zombies) {
                if (zombie.getY() == y){
                    if (shootable){
                        shootPea();
                        shootable = false;
                        timer = 0;
                    }
                }
            }
        }
        else {
            timer++;
        }
    }
}
