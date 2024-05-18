package entity.zombies;

public class DuckyTubeZombie extends Zombie {
    
    public DuckyTubeZombie(int x, int y){

        super(x,y);
        name = "Ducky Tube Zombie";
        health = 100;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = true;
        fileimage = "././res/zombies/duckytube.png";
    }
}
