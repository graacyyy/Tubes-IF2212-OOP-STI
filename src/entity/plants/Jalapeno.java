package entity.plants;

import entity.zombies.*;

public class Jalapeno extends Plant{
    
    public Jalapeno(){
        super("Jalapeno",125,100,10000,0,-1,20,false);
    }

    public void instantKill(Zombie zombie){
        zombie.setHealth(0);
    }
}
