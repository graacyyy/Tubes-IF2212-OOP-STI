package entity.plants;

import entity.zombies.*;

import tile.GameMap;

public class SnowPea extends Plant {

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
=======
        fileimage = "././res/plant/SnowPeaShooter/SnowPeaShooter_1.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/SnowPeaShooter/SnowPeaShooter_1.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
    }

    public void delaySpeed(Zombie zombie){
        zombie.setIsSlowed(true);
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
