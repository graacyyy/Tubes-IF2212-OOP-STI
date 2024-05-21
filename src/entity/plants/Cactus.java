package entity.plants;

import entity.zombies.Zombie;
import tile.GameMap;

public class Cactus extends Plant{
    
    public Cactus(int x, int y){
        
        super(x, y);
        name = "Cactus";
        cost = 125;
        health = 100;
        attack_damage = 40;
        attack_speed = 3;
        range = -1;
        cooldown = 20;
        is_waterplant = false;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        fileimage = "././res/plant/Cactus/Cactus_1.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/Cactus/Cactus_1.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
=======
        fileimage = "././res/plants/cactus.png";
    }

    public void shootPea(){
        CactusBullet bullet = new CactusBullet (x, y, attack_damage);
        GameMap.bullets.add(bullet);
>>>>>>> 99ce55be5f76d414ce047341f0f806ca01c111ab
    }

    @Override
    public void instantKill(Zombie zombie){}

    @Override
    public void actionPerformed() {
        shootable = true;
        if (timer >= 60){
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
