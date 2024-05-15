package entity.plants;

import entity.zombies.*;

public class Snowbullet extends Bullet {
    
    public Snowbullet(int x, int y, int damage){

        super(x,y,damage);
        fileimage = "././res/bullet/SnowPea.png";
    }

    public void hit(Zombie zombie){
        // super.hit(zombie);
        zombie.setIsSlowed(true);
    }


}
