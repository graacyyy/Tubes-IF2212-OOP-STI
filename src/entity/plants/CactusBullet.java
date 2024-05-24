package entity.plants;

import entity.zombies.BalloonZombie;
import entity.zombies.Zombie;

public class CactusBullet extends Bullet{

    public CactusBullet(int x, int y, int damage){

        super(x,y,damage);
        fileimage = "././res/bullet/cactus.png";
    }
    
    @Override
    public void hit(Zombie zombie) {

        if (zombie instanceof BalloonZombie){
            ((BalloonZombie)zombie).popped(damage);
        }
        else{
            zombie.takeDamage(damage);
        }
        System.out.println("Cactus Bullet hit zombie");
    }
}