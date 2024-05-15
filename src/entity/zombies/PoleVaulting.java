package entity.zombies;

public class PoleVaulting extends Zombie {

    public PoleVaulting(int x, int y){

        super(x,y);
        name = "Pole Vaulting Zombie";
        health = 175;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = false;
        fileimage = "././res/zombie/PoleVaulZombie/PoleVaultZombie_1.png";
    }
}
