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
import entity.plants.Bullet;
import entity.plants.Cactus;
import entity.plants.IceShroom;
import entity.plants.Jalapeno;
import entity.plants.Lilypad;
import entity.plants.PeaShooter;
import entity.plants.Plant;
import entity.plants.SnowPea;
// import entity.plants.Squash;
// import entity.plants.Sunflower;
// import entity.plants.Wallnut;
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
import entity.Deck;
import entity.PlantSpawner;

import tile.GameMap;
import tile.UI;


public class GamePanel extends JPanel implements Runnable{

    // STATE
    public static int gameState;
    public final static int titleState = 0;
    public final static int playState = 1;
    public final static int loseState = 2;
    public final static int winState = 3;
    public final static int plantState = 4;
    public final static int zombieState = 5;
    public static boolean pause = false;
    
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
    public static int gametime = 0;
    int selectedX, selectedY;
    // double speed = 2;
    // int xz, xb;
    Zombie zb;
    Plant pl;
    TileSelector tileSelector = new TileSelector();
    CollisionChecker collisionChecker = new CollisionChecker(this);
    Deck deck = new Deck(new Plant[6], true);
    boolean isPlanted = false;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addMouseListener(mh);
        this.addKeyListener(kh);
        this.setFocusable(true);
        gameState = titleState;
        // moveZombie();
        // moveBullet();
    }

    public void startGameThread() {
        System.out.println("thread");
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

        while(!pause){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
                gametime++;
            }
        }
    }

    public void update(){
        repaint();
        // SPAWN PLANT
        if (kh.numPressed == true){
            kh.numPressed = false;
            int plantIndex = kh.numKey;
            switch (plantIndex) {
                case 1:
                if (!isPlanted){
                    PlantSpawner.spawn(new Cactus(selectedX, selectedY));
                }
                    break;
                case 2:
                if (!isPlanted){
                    PlantSpawner.spawn(new IceShroom(selectedX, selectedY));
                }
                    break;
                case 3:
                if (!isPlanted){
                    PlantSpawner.spawn(new Jalapeno(selectedX, selectedY));
                }
                    break;
                case 4:
                if (!isPlanted){
                    PlantSpawner.spawn(new Lilypad(selectedX, selectedY));
                }
                    break;
                case 5:
                if (!isPlanted){
                    PlantSpawner.spawn(new PeaShooter(selectedX, selectedY));
                }
                    break;
                case 6:
                if (!isPlanted){
                    PlantSpawner.spawn(new SnowPea(selectedX, selectedY));
                }
                    break;
                case 7:
                if (isPlanted){
                    GameMap.plants.removeIf(plant -> plant.getX() == selectedX && plant.getY() == selectedY);
                }
                isPlanted = false;
                    break;
            }
        }

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

        Iterator<Bullet> bulletIterator = GameMap.bullets.iterator();
        while (bulletIterator.hasNext()){
            Bullet bullet = bulletIterator.next();
            bullet.actionPerformed();
            if (bullet.isHit()){
                bulletIterator.remove();
            }
        }

        Iterator<Plant> planIterator = GameMap.plants.iterator();
        while (planIterator.hasNext()){
            Plant plant = planIterator.next();
            plant.actionPerformed();
            if (plant.isDead()){
                planIterator.remove();
            }
        }

        Iterator<Zombie> zombieIterator = GameMap.zombies.iterator();
        while (zombieIterator.hasNext()){
            Zombie zombie = zombieIterator.next();
            zombie.actionPerformed();
            if (zombie.isDead()){
                zombieIterator.remove();
            }
        }

        // TILESELECTOR HANDLER
        if (kh.enterPressed == true){
            kh.enterPressed = false;
            selectedX = tileSelector.getX();
            selectedY = tileSelector.getY();
            System.out.println("X: " + selectedX + " Y: " + selectedY);
            // if (kh.numPressed == true){
            //     isPlanted = true;
            // }
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

        if (gametime >= 200){
            if (GameMap.zombies.size() <= 0){
                gameState = winState;
            } else {
                gameState = loseState;
                UI.commandNum = 1;
            }
        } else {
            for (Zombie zombie : GameMap.zombies) {
                if (zombie.getX() == 0) {
                    gameState = loseState;
                    UI.commandNum = 1;
                    break; 
                }
            }
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

        if (gameState == titleState){
            UI.drawTitle(g2);
        } else if (gameState == loseState) {
            UI.drawLose(g2);
        } else if (gameState == winState) {
            UI.drawWin(g2);
        }else {
            gameMap.draw(g2);

            for (int i = 0; i < GameMap.bullets.size(); i++) {
                if(GameMap.bullets.get(i)!=null){
                    GameMap.bullets.get(i).draw(g2);
                }
            }

            for (int i = 0; i < GameMap.plants.size(); i++) {
                if(GameMap.plants.get(i)!=null){
                    GameMap.plants.get(i).draw(g2);
                }
            }
            
            for (int i = 0; i < GameMap.zombies.size(); i++) {
                if(GameMap.zombies.get(i)!=null){
                    GameMap.zombies.get(i).draw(g2);
                }
            }

            tileSelector.draw(g2);
        
            // drawBullet(g2);
            
            // pl.draw(g2);

            g2.dispose();
        }
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

