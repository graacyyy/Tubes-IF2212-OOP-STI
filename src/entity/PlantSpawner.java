package entity;

import entity.plants.Plant;
import tile.GameMap;

public class PlantSpawner {
    
    public static void spawn (Plant pl){
        GameMap.plants.add(pl);
    }
}
