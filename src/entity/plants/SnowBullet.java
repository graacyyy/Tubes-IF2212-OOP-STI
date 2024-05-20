package entity.plants;

import entity.zombies.*;

public class SnowBullet extends Bullet {
    
    public SnowBullet(int x, int y, int damage){

        super(x,y,damage);
        fileimage = "././res/bullet/snowpea.png";
    }

    public void hit(Zombie zombie){
        zombie.setIsSlowed(true);
        zombie.setFreezeTime(0);
    }
}