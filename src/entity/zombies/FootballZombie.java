package entity.zombies;

public class FootballZombie extends Zombie {
    
    public FootballZombie(int x, int y){

        super(x,y);
        name = "Football Zombie";
        health = 360;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = true;
        fileimage = "././res/zombie/FootballZombie/FootballZombie_1.png";
    }
}
