package entity.plants;

import entity.zombies.*;

public class Squash extends Plant {

    public Squash(){
        
        super("Squash", 50, 100, 5000, 0, 1, 20, false);
    }

    @Override
    public void instantKill(Zombie zombie) {
        
        zombie.setHealth(0);
    }

}
