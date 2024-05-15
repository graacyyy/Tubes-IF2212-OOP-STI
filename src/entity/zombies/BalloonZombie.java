package entity.zombies;

public class BalloonZombie extends Zombie{

    protected boolean isPopped = false;

    public BalloonZombie(int x, int y){

        super(x,y);
        name = "Balloon Zombie";
        health = 200;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = false;
    }

    public boolean getIsPopped(){
        return isPopped;
    }

    public void setIsPopped(boolean isPopped){
        
        this.isPopped = isPopped;
    }
}
