package entity.zombies;

public class ConeHead extends Zombie {
    
    public ConeHead(int x, int y){
        super(x,y);
        name = "Conehead Zombie";
        health = 250;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = false;
        fileimage = "././res/zombies/conehead.png";
    }

}
