package entity.zombies;

public class BucketHead extends Zombie {

    public BucketHead(int x, int y){
        super(x,y);
        name = "BucketHead Zombie";
        health = 300;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = false;
        fileimage = "././res/zombies/buckethead.png";
        jumped = false;
    }
}
