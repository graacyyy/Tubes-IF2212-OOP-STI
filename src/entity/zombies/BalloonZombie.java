package entity.zombies;

public class BalloonZombie extends Zombie{
    
    public BalloonZombie(int x, int y){

        super(x,y);
        name = "Balloon Zombie";
        health = 200;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = false;
    }
}
