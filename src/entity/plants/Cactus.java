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
        fileimage = "././res/plants/cactus.png";
    }

    public void shootPea(){
        CactusBullet bullet = new CactusBullet (x, y, attack_damage);
        GameMap.bullets.add(bullet);
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
