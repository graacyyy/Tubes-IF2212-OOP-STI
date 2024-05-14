package entity.plants;

import entity.zombies.Zombie;

public class Wallnut extends Plant{
    
    public Wallnut(){
        super("Wall nut", 50, 1000, 0, 0, 0, 20, false);
    }

    @Override
    public void instantKill(Zombie zombie) {}
}
