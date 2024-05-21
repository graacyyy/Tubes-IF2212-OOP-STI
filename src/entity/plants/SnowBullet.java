package entity.plants;

import entity.zombies.*;

<<<<<<< HEAD
public class Snowbullet extends Bullet {
    
    public Snowbullet(int x, int y, int damage){
=======
public class SnowBullet extends Bullet {
    
    public SnowBullet(int x, int y, int damage){
>>>>>>> origin/main

        super(x,y,damage);
        fileimage = "././res/bullet/SnowPea.png";
    }

    public void hit(Zombie zombie){
        zombie.setIsSlowed(true);
    }
}