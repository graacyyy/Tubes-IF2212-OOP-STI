package entity.plants;

import entity.zombies.*;

public class TangleKelp extends Plant{

    public TangleKelp(){

        super("Tangle Kelp", 25, 100, 2000, 0, -1, 20, true);
    }

    @Override
    public void instantKill(Zombie zombie) {
        
        zombie.setHealth(0);
    }
    
}