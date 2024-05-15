package entity.zombies;

public class Gargantuar extends Zombie {
    
    public Gargantuar(int x, int y){
        super(x,y);
        name = "Gargantuar Zombie";
        health = 500;
        attack_damage = 80;
        attack_speed = 1;
        is_aquatic = false;
        fileimage = "././res/zombie/GargantuarZombie/GargantuarZombie_1.png";
    }
}
