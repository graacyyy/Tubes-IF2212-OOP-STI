package entity.plants;

import entity.zombies.*;

<<<<<<< HEAD
<<<<<<< HEAD
public class Snowbullet extends Bullet {
    
    public Snowbullet(int x, int y, int damage){
=======
public class SnowBullet extends Bullet {
    
    public SnowBullet(int x, int y, int damage){
>>>>>>> origin/main
=======
public class SnowBullet extends Bullet {
    
    public SnowBullet(int x, int y, int damage){
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e

        super(x,y,damage);
        fileimage = "././res/bullet/SnowPea.png";
    }

    public void hit(Zombie zombie){
      
        zombie.setIsSlowed(true);
    }
}