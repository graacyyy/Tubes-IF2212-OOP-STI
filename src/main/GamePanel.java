package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.IOException;
import java.util.Random;

// import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entity.plants.Plant;
import entity.zombies.Zombie;
// import entity.ZombieSpawner;

// import entity.ZombieSpawner;
import tile.GameMap;

public class GamePanel extends JPanel implements Runnable{
    
    // SCREEN SETTINGS
    final static int originalTileSize = 16; // 16x16
    final static int scale = 4;

    public final static int tileSize = originalTileSize * scale; // 64x64
    public final static int maxScreenCol = 11;
    public final static int maxScreenRow = 6;
    public final static int screenWidth = tileSize * maxScreenCol; // 704 pixels
    public final static int screenHeight = tileSize * maxScreenRow; // 384 pixels

    //FPS
    int FPS = 60;

    // GAME OBJECTS
    GameMap gameMap = new GameMap();
    MouseHandler mh = new MouseHandler();
    Thread gameThread;
    Random randomize = new Random();
    BufferedImage image3;
    int timer = 0;
    // double speed = 2;
    // int xz, xb;
    Zombie zb;
    Plant pl;
    

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addMouseListener(mh);
        this.setFocusable(true);
        // moveZombie();
        // moveBullet();
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        for (Zombie zombie : GameMap.zombies) {
            zombie.actionPerformed();
        }
        // if(timer>=60){
        //     // xz-=speed;
        //     xb+=speed;
        // }
        // else{
        //     timer++;
        // }

        // int mouseX = mh.getX();
        // int mouseY = mh.getY();

        // if (mh.getMouseClicked()){

        //     System.out.println(String.format("Mouse clicked at position x:%d y:%d", mouseX, mouseY));
        //     mh.clearMouseClick();
        // }
        // if(timer>=60){
        //     ZombieSpawner.spawn(new Zombie());
        //     timer=0;

        // int y = randomize.nextInt(1,7);
        // Zombie zb = new Zombie(10*GamePanel.tileSize, y*GamePanel.tileSize);    
        // ZombieSpawner.spawn(zb);
        // cl.actionPerformed();
        
        // }else{
        //     timer++;
        // }
        // repaint();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        gameMap.draw(g2);
        for (Zombie zombie : GameMap.zombies) {
            zombie.draw(g2);
        }
        for (Plant plant : GameMap.plants) {
            plant.draw(g2);
        }
    
        // drawBullet(g2);
        
        // pl.draw(g2);

        g2.dispose();
    }

    // public void moveZombie(){
    //     loadImageZombie();
    //     xz = 10*tileSize;
    // }

    // public void moveBullet(){

    //     loadImageBullet();
    //     xb = 0*tileSize;
    // }

    // public void loadImageZombie(){
    //     try {
    //         image1 = ImageIO.read(new File("././res/zombie/orc_left_1.png"));
    //     } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    // }

    // public void drawZombie(Graphics2D g2){
    //     try {
    //         image1 = ImageIO.read(new File("././res/zombie/orc_left_1.png"));
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     g2.drawImage(image1, xz, 1*tileSize, tileSize, tileSize, this);
    // }

    // public void drawPlant(Graphics2D g2){

    //     try {
    //         image2 = ImageIO.read(new File("././res/plant/peashooter_0.png"));
    //     } catch (IOException e) {
    //             e.printStackTrace();
    //         }

    //     g2.drawImage(image2, 0*tileSize, 1*tileSize, tileSize, tileSize, this);
    // }

    // public void loadImageBullet(){
    //     try {
    //         image3 = ImageIO.read(new File("././res/bullet/pea.png"));
    //     } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    // }

    // public void drawBullet(Graphics2D g2){

    //     g2.drawImage(image3, xb, 1*tileSize, tileSize, tileSize, this);
    // }
}

