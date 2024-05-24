package main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entity.TileSelector;
import entity.plants.Bullet;
import entity.plants.Lilypad;
import entity.plants.Plant;
import entity.zombies.Zombie;
import entity.ZombieSpawner;
import entity.DeckManager;
import entity.PlantSpawner;
import entity.Sun;
import tile.GameMap;
import tile.UI;


public class GamePanel extends JPanel implements Runnable{

    
    // SCREEN SETTINGS
    final static int originalTileSize = 16;
    final static int scale = 4;

    public final static int tileSize = originalTileSize * scale;
    public final static int maxScreenCol = 11;
    public final static int maxScreenRow = 7;
    public final static int screenWidth = tileSize * maxScreenCol;
    public final static int screenHeight = tileSize * maxScreenRow; 

    //FPS
    int FPS = 60;
    
    // GAME OBJECTS
    public static int gametime = 0;
    public int timer = 0;
    
    public Thread gameThread;
    private boolean running = true;
    public Random randomize = new Random();
    
    public GameMap gameMap = new GameMap();
    public KeyHandler kh = new KeyHandler();
    public Zombie zb;
    public Plant pl;
    public boolean plantable;
    public boolean isLilypad;
    
    public TileSelector tileSelector = new TileSelector();
    public int selectedX, selectedY;

    public Font sun = new Font("Terminal", Font.BOLD, 14);
    public Font time = new Font("Terminal", Font.BOLD, 12);
    
    // SUN
    public int suntimer=0;
    public int suninterval=5;

    // LIGHTING EFFECT
    private float darknessLevel = 0.0f;
    private float maxDarkness = 0.6f;
    private float darknessSpeed = 0.001f;
    private boolean darkening = false;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
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

        while(running){

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
        
        // SUN OTOMATIS
        if(gametime <= 100){
            if(suntimer>=suninterval*60){
                Sun.addsun(25);
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

        if (kh.numPressed == true && (plantable || isLilypad)){
            if (kh.numKey == 7){
                GameMap.plants.removeIf(plant -> plant.getX() == selectedX && plant.getY() == selectedY);
            }
            else{
                PlantSpawner.spawn(kh.numKey, selectedX, selectedY, isLilypad);
            }
            isLilypad = false;
        }
    
        // SPAWN ZOMBIE
        if (gametime >= 20 && gametime <= 160){
            int chances = randomize.nextInt(1,10);
            if ((chances == 1 || chances == 4 || chances == 9) && timer >= 60*3){
                if (GameMap.zombies.size() < 10){
                    ZombieSpawner.spawn();
                } 
                timer = 0;
            }
            else timer++;
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

        // TILE SELECTOR HANDLE
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

        if (kh.numPressed == true){
            kh.numPressed = false;
            System.out.println("Number pressed: " + kh.numKey);
        }

        // LIGHTING EFFECT
        if (gametime >= 100 && gametime <= 190) {
            darkening = true;
        } else if (gametime >= 190 && gametime <= 300) {
            darkening = false;
        }

        if (darkening) {
            if (darknessLevel < maxDarkness) {
                darknessLevel += darknessSpeed;
                if (darknessLevel > maxDarkness) {
                    darknessLevel = maxDarkness;
                }
            }
        } else {
            if (darknessLevel > 0) {
                darknessLevel -= darknessSpeed;
                if (darknessLevel < 0) {
                    darknessLevel = 0;
                }
            }
        }
    
    } 
    
    public void setRunning(boolean running){
        this.running = running;
    }

    public boolean isRunning(){
        return running;
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // DRAW GAMEMAP
        gameMap.draw(g2);

        // DRAW BULLETS
        for (int i = 0; i < GameMap.bullets.size(); i++) {
            if(GameMap.bullets.get(i)!=null){
                GameMap.bullets.get(i).draw(g2);
            }
        }

        //DRAW PLANTS
        for (int i = 0; i < GameMap.plants.size(); i++) {
            if(GameMap.plants.get(i)!=null){
                GameMap.plants.get(i).draw(g2);
            }
        }

        // DRAW ZOMBIES
        for (int i = 0; i < GameMap.zombies.size(); i++) {
            if(GameMap.zombies.get(i)!=null){
                GameMap.zombies.get(i).draw(g2);
            }
        }

        // DRAW LIGHTING EFFECT
        if (darknessLevel > 0) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, darknessLevel));
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, screenWidth, screenHeight);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
        
        // DRAW TILESELECTOR
        tileSelector.draw(g2);
        
        // DRAW DECK
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
        
        // DRAW STRING
        drawSun(g2);
        drawGameTime(g2);
        drawTime(g2);

        g2.dispose();    
    }

    public void drawSun(Graphics2D g2){
        g2.setFont(sun);
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
        g2.setFont(time);
        g2.setColor(Color.WHITE);

        String text = ""+ gametime + "s";
        int x = (maxScreenCol-1)*tileSize-30;
        int y = tileSize-20;

        g2.drawString(text, x, y);
    }



}
