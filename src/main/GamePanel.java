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
// import javax.swing.JFrame;
// import javax.imageio.ImageIO;
import javax.swing.JPanel;
// import javax.swing.SwingUtilities;

import entity.TileSelector;
import entity.plants.Bullet;
import entity.plants.Lilypad;
import entity.plants.Plant;
// import entity.zombies.NormalZombie;
import entity.zombies.Zombie;
import entity.ZombieSpawner;
import entity.DeckManager;
import entity.PlantSpawner;
import entity.Sun;
import tile.GameMap;
import tile.UI;


public class GamePanel extends JPanel implements Runnable{

    // STATE
    // public static int gameState;
    // public final static int titleState = 0;
    // public final static int playState = 1;
    // public final static int loseState = 2;
    // public final static int winState = 3;
    // public final static int plantState = 4;
    // public final static int zombieState = 5;
    // public final static int helpState = 6;
    // public final static int stepState = 7;
    // public final static int inventoryState = 8;

    
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
    public static int gametime = 0;
    GameMap gameMap = new GameMap();
    KeyHandler kh = new KeyHandler();
    Random randomize = new Random();
    Thread gameThread, titleThread;
    Zombie zb;
    Plant pl;
    TileSelector tileSelector = new TileSelector();
    CollisionChecker collisionChecker = new CollisionChecker(this);
    Font font = new Font("Terminal", Font.BOLD, 14);
    Font font2 = new Font("Terminal", Font.BOLD, 12);
    boolean plantable;
    boolean isLilypad;
    private boolean running = true;
    int timer = 0;
    int selectedX, selectedY;
    // int sun = 50;
    int suntimer=0;
    int suninterval=5;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
        // losePanel = new LosePanel();

        // moveZombie();
        // moveBullet();
    }

    public void startGameThread() {

        System.out.println("thread");
        gameThread = new Thread(this);
        gameThread.start();
    }

    // public void startTitle() {
        
    //     System.out.println("thread");
    //     titleThread = new Thread(this);
    //     gameThread.start();
    // }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(running){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                System.out.println("update");
                repaint();
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
        System.out.println("test");

        // SUN OTOMATIS
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
            isLilypad = false;
            for (Plant plant : GameMap.plants) {
                if (selectedX == plant.getX() && selectedY == plant.getY()){
                    if (plant instanceof Lilypad){
                        isLilypad = true;
                        break;
                    }
                    plantable = false;
                }
            }
    
            if (kh.numPressed == true && kh.numKey == 7){
                plantable = true;
            }
        // System.out.println(kh.numPressed);
        // System.out.println(plantable);
            if (kh.numPressed == true && (plantable || isLilypad)){
                if (kh.numKey == 7){
                    GameMap.plants.removeIf(plant -> plant.getX() == selectedX && plant.getY() == selectedY);
                }
                else{
                    PlantSpawner.spawn(kh.numKey, selectedX, selectedY, isLilypad);
                    System.out.println("test");
                }
                isLilypad = false;
            }
    
            // SPAWN ZOMBIE
            if (gametime >= 20 && gametime <= 160){
                int chances = randomize.nextInt(1,10);
                if (chances == 2 || chances == 5 || chances == 9){
                    if (timer >= 60 && GameMap.zombies.size() < 10){
                        ZombieSpawner.spawn();
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

            Iterator<DeckManager> deckIterator = DeckManager.deck.iterator();
            while (deckIterator.hasNext()){
                DeckManager deck = deckIterator.next();
                deck.actionPerformed();
                if (deck.isReady()){
                    deckIterator.remove();
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

            
            // GAME STATE HANDLER
            if (gametime >= 200){
                if (GameMap.zombies.size() <= 0){
                    TitlePanel.gameState = TitlePanel.winState;
                    Screen.win();
                } 
            } else {
                for (Zombie zombie : GameMap.zombies) {
                    if (zombie.getX() == 0) {
                        UI.commandNum = 1;
                        TitlePanel.gameState = TitlePanel.loseState;
                        Screen.lose();
                        break; 
                    }
                }
            }

            // KEYHANDLER
            if (kh.enterPressed) {
                kh.enterPressed = false;
                selectedX = tileSelector.getX();
                selectedY = tileSelector.getY();
            }
    
            if (kh.upPressed) {
                kh.upPressed = false;
                if (tileSelector.getY() == tileSize) {
                    tileSelector.setY((maxScreenRow - 1) * tileSize);
                } else {
                    tileSelector.setY(tileSelector.getY() - tileSize);
                }
            }
    
            if (kh.downPressed) {
                kh.downPressed = false;
                if (tileSelector.getY() == (maxScreenRow - 1) * tileSize) {
                    tileSelector.setY(tileSize);
                } else {
                    tileSelector.setY(tileSelector.getY() + tileSize);
                }
            }
    
            if (kh.leftPressed) {
                kh.leftPressed = false;
                if (tileSelector.getX() == tileSize) {
                    tileSelector.setX((maxScreenCol - 2) * tileSize);
                } else {
                    tileSelector.setX(tileSelector.getX() - tileSize);
                }
            }
    
            if (kh.rightPressed) {
                kh.rightPressed = false;
                if (tileSelector.getX() == (maxScreenCol - 2) * tileSize) {
                    tileSelector.setX(tileSize);
                } else {
                    tileSelector.setX(tileSelector.getX() + tileSize);
                }
            }
                // if(kh.upPressed == true){
                //     kh.upPressed = false;
                //     UI.commandNum--;
                //     if (UI.commandNum < 1){
                //         UI.commandNum = 2;
                //     }
                // }
    
                // if(kh.downPressed == true){
                //     kh.downPressed = false;
                //     UI.commandNum++;
                //     if (UI.commandNum > 2){
                //         UI.commandNum = 1;
                //     }
                // }
    
                // if(kh.enterPressed){
                //     kh.enterPressed = false;
                //     if (UI.commandNum == 1){
                //         TitlePanel.gameState = TitlePanel.playState;
                //     } else {
                //         System.exit(0); 
                //     }
                // } 
    
                // if (kh.enterPressed == true){
                //     kh.enterPressed = false;
                //     selectedX = tileSelector.getX();
                //     selectedY = tileSelector.getY();
                //     System.out.println("X: " + selectedX + " Y: " + selectedY);
                // }           
                // if (kh.upPressed == true){
                //     kh.upPressed = false;
                //     if (tileSelector.getY() == tileSize){
                //         tileSelector.setY((maxScreenRow-1)*tileSize);
                //         System.out.println("Tile X " + tileSelector.getX() + "Tile Y: " + tileSelector.getY());
    
                //     }
                //     else {
                //         tileSelector.setY(tileSelector.getY()-tileSize);
                //         System.out.println("Tile X " + tileSelector.getX() + "Tile Y: " + tileSelector.getY());
                //     }
                // }
        
                // if (kh.downPressed == true){
                //     kh.downPressed = false;
                //     if (tileSelector.getY() == (maxScreenRow-1)*tileSize){
                //         tileSelector.setY(tileSize);
                //         System.out.println("Tile X " + tileSelector.getX() + "Tile Y: " + tileSelector.getY());
                //     }
                //     else {
                //         tileSelector.setY(tileSelector.getY()+tileSize);
                //         System.out.println("Tile X " + tileSelector.getX() + "Tile Y: " + tileSelector.getY());
                //     }
                // }
        
                // if (kh.leftPressed == true){
                //     kh.leftPressed = false;
                //     if (tileSelector.getX() == tileSize){
                //         tileSelector.setX((maxScreenCol-2)*tileSize);
                //         System.out.println("Tile X " + tileSelector.getX() + "Tile Y: " + tileSelector.getY());
                //     }
                //     else {
                //         tileSelector.setX(tileSelector.getX()-tileSize);
                //         System.out.println("Tile X " + tileSelector.getX() + "Tile Y: " + tileSelector.getY());
                //     }
                // }
                // if (kh.rightPressed == true){
                //     kh.rightPressed = false;
                //     if (tileSelector.getX() == (maxScreenCol-2)*tileSize){
                //         tileSelector.setX(tileSize);
                //         System.out.println("Tile X " + tileSelector.getX() + "Tile Y: " + tileSelector.getY());
                //     }
                //     else {
                //         tileSelector.setX(tileSelector.getX()+tileSize);
                //         System.out.println("Tile X " + tileSelector.getX() + "Tile Y: " + tileSelector.getY());
                //     }
                // }
                // if (kh.numPressed == true){
                //     kh.numPressed = false;
                //     System.out.println("Number pressed: " + kh.numKey);
                // }
    } 
    
    public void setRunning(boolean running){
        this.running = running;
    }

    public boolean isRunning(){
        return running;
    }
    
    // public void switchToLosePanel(){
    //     JFrame frame = Main.window;
    //     if (frame != null) {
    //         this.setVisible(false);
    //         frame.remove(this);
    //         frame.add(losePanel);
    //         frame.revalidate();
    //         frame.repaint();
    //         stopThread();
    //         losePanel.startLose();
    //         losePanel.requestFocusInWindow();
    //     }
    // }

    // public void stopThread(){
    //     pause = true;
    // }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

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
        
        tileSelector.draw(g2);

        for (int i = 0; i < GameMap.zombies.size(); i++) {
            if(GameMap.zombies.get(i)!=null){
                GameMap.zombies.get(i).draw(g2);
            }
        }
        
        
        gameMap.drawDeck(g2);
        
        for (int i = 0; i < Inventory.selectedPlants.size(); i++) {
            if(Inventory.selectedPlants.get(i)!=null){
                try {
                    BufferedImage image = ImageIO.read(new File(Inventory.selectedPlants.get(i)));
                    g2.drawImage(image, (i+1)*tileSize, 2, tileSize, tileSize-10, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        drawSun(g2);
        drawGameTime(g2);
        drawTime(g2);
        g2.dispose();    
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
