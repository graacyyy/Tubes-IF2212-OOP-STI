package main;

import entity.plants.Plant;
import entity.zombies.Zombie;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public boolean isColliding(Zombie zombie, Plant plant){
        
        return zombie.getX() < plant.getX() + GamePanel.tileSize;
    }
}
