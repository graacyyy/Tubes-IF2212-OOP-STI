package tile;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entity.plants.Plant;
import entity.zombies.Zombie;

import main.GamePanel;

public class GameMap {
    
    Tile[] tile;
    int mapTileNum[][];
    
    public GameMap(){

        tile = new Tile[10];
        mapTileNum = new int[GamePanel.maxScreenCol][GamePanel.maxScreenRow];

        getTileImage();
    }

    public void getTileImage(){

        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File("./res/tiles/grass01.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File("./res/tiles/floor01.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new File("./res/tiles/water01.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(new File("./res/tiles/earth.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void draw (Graphics2D g2){

        // Restricted Area
        for (int i = 0; i < GamePanel.maxScreenRow; i++){
            g2.drawImage(tile[1].image, 0*GamePanel.tileSize, i*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
        }

        // Plantable Area
        for (int i = 1; i < GamePanel.maxScreenCol; i++){
            g2.drawImage(tile[0].image, i*GamePanel.tileSize, 0*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
            g2.drawImage(tile[0].image, i*GamePanel.tileSize, 1*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
            g2.drawImage(tile[2].image, i*GamePanel.tileSize, 2*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
            g2.drawImage(tile[2].image, i*GamePanel.tileSize, 3*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
            g2.drawImage(tile[0].image, i*GamePanel.tileSize, 4*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
            g2.drawImage(tile[0].image, i*GamePanel.tileSize, 5*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
        }

        // Zombie Spawn Area
        for (int i = 0; i < GamePanel.maxScreenRow; i++){
            g2.drawImage(tile[3].image, 10*GamePanel.tileSize, i*GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize, null);
        }
    }
    
    public static ArrayList<Plant> plants = new ArrayList<>();
    public static ArrayList<Zombie> zombies = new ArrayList<>();
    // public static ArrayList<Plant> plants = new ArrayList<>();

}

// package game;

// public class GameMap {
//     private final int width = 11;
//     private final int height = 6;
//     private final Tile[][] mapGrid;

//     public GameMap() {
//         this.mapGrid = new Tile[height][width];
//         initializeMap();
//     }

//     private void initializeMap() {
//         for (int x = 0; x < height; x++) {
//             for (int y = 0; y < width; y++) {
//                 mapGrid[x][y] = new Tile('.', false, false, false);

//                 while (x == 2 && x == 3){
//                     while (y >= 1 && y <= 9){
//                         mapGrid[x][y].setIsPoolArea(true);;
//                     }
//                 }

//                 while (y == 0){
//                     mapGrid[x][y].setIsRestricted(true);
//                 }
//             }
//         }
//     }

//     public Tile[][] getMapGrid() {
//         return mapGrid;
//     }

//     public void displayMap() {
//         for (int x = 0; x < height; x++) {
//             for (int y = 0; y < width; y++) {
//                 System.out.print(mapGrid[x][y].getType() + "   ");
//             }
//             System.out.println();
//         }
//     }


