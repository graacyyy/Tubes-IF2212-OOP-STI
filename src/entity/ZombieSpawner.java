package entity;

import entity.zombies.Zombie;
import tile.GameMap;

public class ZombieSpawner {

    public static void spawn (Zombie zb){
        GameMap.zombies.add(zb);
    }
}
