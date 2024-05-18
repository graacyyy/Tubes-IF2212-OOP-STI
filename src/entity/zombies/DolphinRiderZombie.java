package entity.zombies;

public class DolphinRiderZombie extends Zombie {
    
    public DolphinRiderZombie(int x, int y){

        super(x,y);
        name = "Dolphin Rider Zombie";
        health = 175;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = true;
        fileimage = "././res/zombies/dolphinrider.png";
    }
}
