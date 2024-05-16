package entity.plants;

import entity.zombies.*;

public class SnowBullet extends Bullet {
    
    public SnowBullet(int x, int y, int damage){

        super(x,y,damage);
        fileimage = "././res/bullet/SnowPea.png";
    }

    public void hit(Zombie zombie){
      
        zombie.setIsSlowed(true);
    }
}