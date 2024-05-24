package tile;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entity.plants.Bullet;
import entity.plants.Plant;
import entity.zombies.Zombie;

import main.GamePanel;

public class GameMap {
    
    public Tile[] tile;
    public int mapTileNum[][];
    
    //ENTITIES IN GAME MAP
    public static ArrayList<Plant> plants = new ArrayList<>();
    public static ArrayList<Zombie> zombies = new ArrayList<>();
    public static ArrayList<Bullet> bullets = new ArrayList<>();
    
    public GameMap(){

        tile = new Tile[20];
        mapTileNum = new int[GamePanel.maxScreenCol][GamePanel.maxScreenRow];

        getTileImage();
    }

    public void getTileImage(){

        try{
            // GAME AREA
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File("././res/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File("././res/tiles/home.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new File("././res/tiles/pool.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(new File("././res/tiles/spawn.png"));

            // DECK 
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(new File("././res/deck/deck01.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(new File("././res/deck/deck02.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(new File("././res/deck/deck03.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(new File("././res/deck/deck04.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(new File("././res/deck/deck05.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(new File("././res/deck/deck06.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(new File("././res/deck/deck07.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(new File("././res/deck/deck08.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void draw (Graphics2D g2){

        // RESTRICTED AREA
        for (int i = 0; i < GamePanel.maxScreenRow; i++){
            g2.drawImage(tile[1].image, 0*GamePanel.tileSize, i*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
        }

        // PLANTABLE AREA
        for (int i = 1; i < GamePanel.maxScreenCol; i++){
            g2.drawImage(tile[0].image, i*GamePanel.tileSize, 0*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
            g2.drawImage(tile[0].image, i*GamePanel.tileSize, 1*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
            g2.drawImage(tile[0].image, i*GamePanel.tileSize, 2*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
            g2.drawImage(tile[0].image, i*GamePanel.tileSize, 3*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
            g2.drawImage(tile[0].image, i*GamePanel.tileSize, 4*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
            g2.drawImage(tile[0].image, i*GamePanel.tileSize, 5*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
            g2.drawImage(tile[0].image, i*GamePanel.tileSize, 6*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
        }

        // ZOMBIE SPAWN AREA
        g2.drawImage(tile[3].image, 10*GamePanel.tileSize, 0*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize*(GamePanel.maxScreenRow), null);

        // POOL AREA
        g2.drawImage(tile[2].image, 1*GamePanel.tileSize, 3*GamePanel.tileSize, GamePanel.tileSize*(GamePanel.maxScreenCol-2), GamePanel.tileSize*2, null);

    }

    public void drawDeck(Graphics2D g2){

        for (int i = 0; i < 8; i++){
            g2.drawImage(tile[i+4].image, i*GamePanel.tileSize, 0*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
        }
    }
}