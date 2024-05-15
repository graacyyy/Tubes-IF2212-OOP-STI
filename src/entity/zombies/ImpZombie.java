package entity.zombies;

public class ImpZombie extends Zombie {

    public ImpZombie(int x, int y){
        
        super(x,y);
        name = "Imp Zombie";
        health = 90;
        attack_damage = 80;
        attack_speed = 1;
        is_aquatic = false;
    }
}
