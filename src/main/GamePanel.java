package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
// import java.io.File;
// import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
// import javax.swing.JFrame;
// import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entity.TileSelector;
import entity.plants.Bullet;
// import entity.plants.Cactus;
import entity.plants.IceShroom;
import entity.plants.Jalapeno;
// import entity.plants.Lilypad;
import entity.plants.PeaShooter;
import entity.plants.Plant;
import entity.plants.SnowPea;
import entity.plants.Sunflower;
import entity.plants.TangleKelp;
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
// import entity.Deck;
import entity.PlantSpawner;
import entity.Sun;
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
    public final static int helpState = 6;
    public final static int stepState = 7;
    public final static int inventoryState = 8;

    public static boolean pause = false;
    
    // SCREEN SETTINGS
    final static int originalTileSize = 16; // 16x16
    final static int scale = 4;

    public final static int tileSize = originalTileSize * scale; // 64x64
    public final static int maxScreenCol = 11;
    public final static int maxScreenRow = 7; // jadiin 7 buat deck diatas
    public final static int screenWidth = tileSize * maxScreenCol; // 704 pixels
    public final static int screenHeight = tileSize * maxScreenRow; // 448 pixels

    //FPS
    int FPS = 60;
    
    // GAME OBJECTS
    GameMap gameMap = new GameMap();
    MouseHandler mh = new MouseHandler();
    KeyHandler kh = new KeyHandler();
    Random randomize = new Random();
    Thread gameThread, titleThread;
    BufferedImage image3;
    int timer = 0;
    public static int gametime = 0;
    int selectedX, selectedY;
    Zombie zb;
    Plant pl;
    TileSelector tileSelector = new TileSelector();
    CollisionChecker collisionChecker = new CollisionChecker(this);
    boolean plantable;
    // int sun = 50;
    Font font = new Font("Terminal", Font.BOLD, 14);
    Font font2 = new Font("Terminal", Font.BOLD, 12);

    int suntimer=0;
    int suninterval=5;

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

    public void startTitle() {
        
        System.out.println("thread");
        titleThread = new Thread(this);
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
                System.out.println("Game Time:" + gametime + "s");
            }
        }
    }

    public void update(){

        repaint();
            if(gametime <= 100){
                if(suntimer>=suninterval*60){
                    Sun.addsun(25);
                    System.out.println("Sun otomatis");
                    suninterval = randomize.nextInt(5,11) ;
                    suntimer=0;
                }else{
                    suntimer++;
                }
            }
            // SPAWN PLANT
            plantable = true;
            for (Plant plant : GameMap.plants) {
                if (selectedX == plant.getX() && selectedY == plant.getY()){
                    plantable = false;
                }
            }
    
            if (kh.numPressed == true && kh.numKey == 7){
                plantable = true;
            }
    
            if (kh.numPressed == true && plantable){
                kh.numPressed = false;
                int plantIndex = kh.numKey;
                switch (plantIndex) {
                    case 1:
                    if (Sun.getSunAmount() >= Sunflower.getCost()){
                        PlantSpawner.spawn(new Sunflower(selectedX, selectedY));
                        Sun.reducesun(Sunflower.getCost());
                    }
                        break;
                    case 2:
                    if (Sun.getSunAmount() >= TangleKelp.getCost()){
                        PlantSpawner.spawn(new TangleKelp(selectedX, selectedY));
                        Sun.reducesun(TangleKelp.getCost());
                    }
                        break;
                    case 3:
                    if (Sun.getSunAmount() >= Jalapeno.getCost()){
                        PlantSpawner.spawn(new Jalapeno(selectedX, selectedY));
                        Sun.reducesun(Jalapeno.getCost());
                    }
                        break;
                    case 4:
                    if (Sun.getSunAmount() >= IceShroom.getCost()){
                        PlantSpawner.spawn(new IceShroom(selectedX, selectedY));
                        Sun.reducesun(IceShroom.getCost());
                    }  
                        break;
                    case 5:
                    if (Sun.getSunAmount() >= PeaShooter.getCost()){
                        PlantSpawner.spawn(new PeaShooter(selectedX, selectedY));
                        Sun.reducesun(PeaShooter.getCost());
                    }
                        break;
                    case 6:
                    if (Sun.getSunAmount() >= SnowPea.getCost()){
                        PlantSpawner.spawn(new SnowPea(selectedX, selectedY));
                        Sun.reducesun(SnowPea.getCost());
                    }
                        break;
                    case 7:
                    GameMap.plants.removeIf(plant -> plant.getX() == selectedX && plant.getY() == selectedY);
                        break;
                }
            }
    
            // SPAWN ZOMBIE
            if (gametime >= 20 && gametime <= 160){
                int chances = randomize.nextInt(1,10);
                if (chances == 3 || chances == 5 || chances == 7){
                    if (timer >= 60 && GameMap.zombies.size() < 10){
                        int y = randomize.nextInt(1,7);
                        if (y == 3 || y == 4){
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
                    } 
                    else timer++;
                }
            }
    
            // ITERATOR 
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
                if (tileSelector.getY() == tileSize){
                    tileSelector.setY((maxScreenRow-1)*tileSize);
                }
                else tileSelector.setY(tileSelector.getY()-tileSize);
            }
    
            else if (kh.downPressed == true){
                kh.downPressed = false;
                if (tileSelector.getY() == (maxScreenRow-1)*tileSize){
                    tileSelector.setY(tileSize);
                }
                else tileSelector.setY(tileSelector.getY()+tileSize);
            }
    
            else if (kh.leftPressed == true){
                kh.leftPressed = false;
                if (tileSelector.getX() == tileSize){
                    tileSelector.setX((maxScreenCol-2)*tileSize);
                }
                else tileSelector.setX(tileSelector.getX()-tileSize);
            }
            else if (kh.rightPressed == true){
                kh.rightPressed = false;
                if (tileSelector.getX() == (maxScreenCol-2)*tileSize){
                    tileSelector.setX(tileSize);
                }
                else tileSelector.setX(tileSelector.getX()+tileSize);
            }
            else if (kh.numPressed == true){
                kh.numPressed = false;
                System.out.println("Number pressed: " + kh.numKey);
            }
            
            // GAME STATE HANDLER
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
        // }
        
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
        } 
        else if (gameState == helpState) {
            UI.drawHelp(g2);
        } 
        else if (gameState == stepState) {
            UI.drawStep(g2);
        } else if (gameState == inventoryState){
            UI.drawHelp(g2);
        } else {
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
            
            gameMap.drawDeck(g2);
            
            drawSun(g2);
            drawGameTime(g2);
            drawTime(g2);
            g2.dispose();
        }
    }

    public void drawSun(Graphics2D g2){
        g2.setFont(font);
        g2.setColor(Color.RED);

        String text = ""+ Sun.getSunAmount();
        int x = 10;
        int y = tileSize-8;

        g2.drawString(text, x, y);
    }

    public void drawGameTime(Graphics2D g2){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("./res/deck/gametime.png"));
        } catch (IOException e) {}

        g2.drawImage(image, 8*tileSize, 0, tileSize*3, tileSize, null);
    }
    
    public void drawTime(Graphics2D g2){
        g2.setFont(font2);
        g2.setColor(Color.WHITE);

        String text = ""+ gametime + "s";
        int x = (maxScreenCol-1)*tileSize-30;
        int y = tileSize-20;

        g2.drawString(text, x, y);
    }
}