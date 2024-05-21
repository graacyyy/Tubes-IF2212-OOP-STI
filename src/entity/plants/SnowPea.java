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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        fileimage = "././res/plant/SnowPeaShooter/SnowPeaShooter_1.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/SnowPeaShooter/SnowPeaShooter_1.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
    }

    public void delaySpeed(Zombie zombie){
        zombie.setIsSlowed(true);
=======
        fileimage = "././res/plants/snowpea.png";
>>>>>>> 99ce55be5f76d414ce047341f0f806ca01c111ab
    }

    public void shootPea(){
<<<<<<< HEAD
<<<<<<< HEAD
        Snowbullet bullet = new Snowbullet(x, y, attack_damage);
=======
        SnowBullet bullet = new SnowBullet(x, y, attack_damage);
>>>>>>> origin/main
=======
      
        SnowBullet bullet = new SnowBullet(x, y, attack_damage);
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
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
