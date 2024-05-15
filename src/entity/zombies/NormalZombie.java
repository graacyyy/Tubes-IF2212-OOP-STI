package entity.zombies;

public class NormalZombie extends Zombie{

    public NormalZombie(int x, int y){
        
        super(x,y);
        name = "Normal Zombie";
        health = 125;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = false;
        fileimage = "././res/zombie/orc_left_1.png";
    }
    
}
