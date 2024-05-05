package entity.plants;

import entity.zombies.*;

public class IceShroom extends Plant{
    
    public IceShroom(){
        super("Ice Shroom", 75,100,200,0,-1,20,false);
    }

    public void freeze(Zombie zombie){
        zombie.setSpeed(0);
    }
}