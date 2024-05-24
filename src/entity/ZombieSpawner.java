package entity;

import java.util.Random;

import entity.zombies.BalloonZombie;
import entity.zombies.BucketHead;
import entity.zombies.ConeHead;
import entity.zombies.DolphinRiderZombie;
import entity.zombies.DuckyTubeZombie;
import entity.zombies.FootballZombie;
import entity.zombies.Gargantuar;
import entity.zombies.ImpZombie;
import entity.zombies.NormalZombie;
import entity.zombies.PoleVaulting;
import main.GamePanel;
import tile.GameMap;

public class ZombieSpawner {

    static Random randomize = new Random();

    public static void spawn (){
        int y = randomize.nextInt(1,7);
            // ZOMBIE IN WATER
            if (y == 3 || y == 4){
                int x = randomize.nextInt(1,3);
                switch (x) {
                    case 1:
                    GameMap.zombies.add(new DolphinRiderZombie(10*GamePanel.tileSize, y*GamePanel.tileSize));
                        break;
                    case 2:
                    GameMap.zombies.add(new DuckyTubeZombie(10*GamePanel.tileSize, y*GamePanel.tileSize));
                        break;
                }
            }
            // ZOMBIE ON LAND
            else {
                int x = randomize.nextInt(1,9);
                switch (x) {
                    case 1:
                    GameMap.zombies.add(new BalloonZombie(10*GamePanel.tileSize, y*GamePanel.tileSize));
                        break;
                    case 2:
                    GameMap.zombies.add(new BucketHead(10*GamePanel.tileSize, y*GamePanel.tileSize));
                        break;
                    case 3:
                    GameMap.zombies.add(new ConeHead(10*GamePanel.tileSize, y*GamePanel.tileSize));
                        break;
                    case 4:
                    GameMap.zombies.add(new FootballZombie(10*GamePanel.tileSize, y*GamePanel.tileSize));
                        break;
                    case 5:
                    GameMap.zombies.add(new Gargantuar(10*GamePanel.tileSize, y*GamePanel.tileSize));
                        break;
                    case 6:
                    GameMap.zombies.add(new ImpZombie(10*GamePanel.tileSize, y*GamePanel.tileSize));
                        break;
                    case 7:
                    GameMap.zombies.add(new NormalZombie(10*GamePanel.tileSize, y*GamePanel.tileSize));
                        break;
                    case 8:
                    GameMap.zombies.add(new PoleVaulting(10*GamePanel.tileSize, y*GamePanel.tileSize));
                        break;
                }
            }            
    }
}
