package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;
// import java.io.File;
// import java.io.IOException;
import java.util.Random;

// import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entity.TileSelector;
import entity.plants.Plant;
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
import entity.zombies.Zombie;
import entity.ZombieSpawner;

import tile.GameMap;

public class GamePanel extends JPanel implements Runnable{
    
    // SCREEN SETTINGS
    final static int originalTileSize = 16; // 16x16
    final static int scale = 4;

    public final static int tileSize = originalTileSize * scale; // 64x64
    public final static int maxScreenCol = 11;
    public final static int maxScreenRow = 6; // jadiin 7 buat deck diatas
    public final static int screenWidth = tileSize * maxScreenCol; // 704 pixels
    public final static int screenHeight = tileSize * maxScreenRow; // 448 pixels

    
    //FPS
    int FPS = 60;
    
    // GAME OBJECTS
    GameMap gameMap = new GameMap();
    MouseHandler mh = new MouseHandler();
    KeyHandler kh = new KeyHandler();
    Random randomize = new Random();
    Thread gameThread;
    BufferedImage image3;
    int timer = 0;
    int selectedX, selectedY;
    // double speed = 2;
    // int xz, xb;
    Zombie zb;
    Plant pl;
    TileSelector tileSelector = new TileSelector();
    CollisionChecker collisionChecker = new CollisionChecker(this);
    

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addMouseListener(mh);
        this.addKeyListener(kh);
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

        // SPAWN ZOMBIE
        if (timer >= 60){
            int y = randomize.nextInt(0,6);

            if (y == 2 || y == 3){
                int x = randomize.nextInt(1,3);
                switch (x) {
                    case 1:
                    ZombieSpawner.spawn(new DolphinRiderZombie(10*tileSize, y*tileSize));
                        break;
                    case 2:
                    ZombieSpawner.spawn(new DuckyTubeZombie(10*tileSize, y*tileSize));
                        break;
                }
            }
            else {
                int x = randomize.nextInt(1,9);
                switch (x) {
                    case 1:
                    ZombieSpawner.spawn(new BalloonZombie(10*tileSize, y*tileSize));
                        break;
                    case 2:
                    ZombieSpawner.spawn(new BucketHead(10*tileSize, y*tileSize));
                        break;
                    case 3:
                    ZombieSpawner.spawn(new ConeHead(10*tileSize, y*tileSize));
                        break;
                    case 4:
                    ZombieSpawner.spawn(new FootballZombie(10*tileSize, y*tileSize));
                        break;
                    case 5:
                    ZombieSpawner.spawn(new Gargantuar(10*tileSize, y*tileSize));
                        break;
                    case 6:
                    ZombieSpawner.spawn(new ImpZombie(10*tileSize, y*tileSize));
                        break;
                    case 7:
                    ZombieSpawner.spawn(new NormalZombie(10*tileSize, y*tileSize));
                        break;
                    case 8:
                    ZombieSpawner.spawn(new PoleVaulting(10*tileSize, y*tileSize));
                        break;
                }
            }
            
            timer = 0;
        } else {
            timer++;
        }

        // COLLISION HANDLER
        Iterator<Zombie> zombieIterator = GameMap.zombies.iterator();
        while (zombieIterator.hasNext()) {
            Zombie zombie = zombieIterator.next();
            boolean zombieStopped = false;

            Iterator<Plant> plantIterator = GameMap.plants.iterator();
            while (plantIterator.hasNext()) {
                Plant plant = plantIterator.next();
                if(collisionChecker.isColliding(zombie, plant)){
                    zombie.setIsMoving(false);
                    zombie.attack(plant);
                    
                    if(plant.isDead(plant.getHealth())){
                        plantIterator.remove();
                    }

                    zombieStopped = true;
                    break;
                }
            }

            if(!zombieStopped){
                zombie.setIsMoving(true);
                zombie.actionPerformed();
            }
        }

        // TILESELECTOR HANDLER
        if (kh.enterPressed == true){
            kh.enterPressed = false;
            selectedX = tileSelector.getX();
            selectedY = tileSelector.getY();
            System.out.println("X: " + selectedX + " Y: " + selectedY);
        }           
        else if (kh.upPressed == true){
            kh.upPressed = false;
            if (tileSelector.getY() == 0){
                tileSelector.setY((maxScreenRow-1)*tileSize);
            }
            else tileSelector.setY(tileSelector.getY()-tileSize);
        }

        else if (kh.downPressed == true){
            kh.downPressed = false;
            if (tileSelector.getY() == (maxScreenRow-1)*tileSize){
                tileSelector.setY(0);
            }
            else tileSelector.setY(tileSelector.getY()+tileSize);
        }

        else if (kh.leftPressed == true){
            kh.leftPressed = false;
            if (tileSelector.getX() == 0){
                tileSelector.setX((maxScreenCol-1)*tileSize);
            }
            else tileSelector.setX(tileSelector.getX()-tileSize);
        }
        else if (kh.rightPressed == true){
            kh.rightPressed = false;
            if (tileSelector.getX() == (maxScreenCol-1)*tileSize){
                tileSelector.setX(0);
            }
            else tileSelector.setX(tileSelector.getX()+tileSize);
        }
        else if (kh.numPressed == true){
            kh.numPressed = false;
            System.out.println("Number pressed: " + kh.numKey);
        }

        // for (Zombie zombie : GameMap.zombies) {
        //     for (Plant plant : GameMap.plants) {
        //         collisionChecker.isColliding(zombie);
        //         if (!zombie.collisionOn){
        //             zombie.actionPerformed();
        //         }
        //         else{
        //             zombie.attack(plant);
        //             System.out.printf("healt:%d",plant.getHealth());
        //         }
        //         zombie.collisionOn = false;
        //     }
        // }

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

        for (Plant plant : GameMap.plants) {
            plant.draw(g2);
        }
        for (Zombie zombie : GameMap.zombies) {
            zombie.draw(g2);
        }

        tileSelector.draw(g2);
    
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

