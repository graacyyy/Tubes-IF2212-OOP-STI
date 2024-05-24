package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
// import java.awt.event.KeyEvent;
// import java.io.File;

// import javax.sound.sampled.AudioInputStream;
// import javax.sound.sampled.AudioSystem;
// import javax.sound.sampled.Clip;
// import javax.sound.sampled.LineEvent;
// import javax.sound.sampled.LineListener;
// import javax.swing.JFrame;
import javax.swing.JPanel;

import tile.UI;

public class TitlePanel extends JPanel implements Runnable{
    
    public static int gameState;
    public final static int titleState = 0;
    public final static int playState = 1;
    public final static int loseState = 2;
    public final static int winState = 3;
    public final static int plantState = 4;
    public final static int zombieState = 5;
    public final static int helpState = 6;
    public final static int stepState = 7;
    
    int FPS = 60;
    KeyHandler kh = new KeyHandler();
    Thread titleThread;
    // JFrame window = new JFrame();
    private boolean running = true;
    
    int COLUMNS = 4;
    int ROWS = 3;
    int TOTAL_ITEMS = 10;
    int i = 0;
    // public TitlePanel(JFrame window, GamePanel gamePanel){
    public TitlePanel(){
        // this.window = window;
        // this.gamePanel = gamePanel;
        this.setPreferredSize(new Dimension(GamePanel.screenWidth, GamePanel.screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
        gameState = titleState;
    }

    
    public void startTitleThread() {
        
        System.out.println("thread");
        titleThread = new Thread(this);
        titleThread.start();
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
            }
        }
    }

    public void update(){
        
        repaint();

        if (TitlePanel.gameState == TitlePanel.titleState){
            if(kh.enterPressed){
                kh.enterPressed = true;
                if (UI.commandNum == 1){
                    // Switch to InventoryPanel
                    // switchToInventoryPanel();
                    // removeKeyListener(kh);
                } else if (UI.commandNum == 2) { 
                    TitlePanel.gameState = TitlePanel.helpState;
                } else if (UI.commandNum == 3) {
                    TitlePanel.gameState = TitlePanel.plantState;
                } else if (UI.commandNum == 4) {
                    TitlePanel.gameState = TitlePanel.zombieState;
                } else if (UI.commandNum == 5) {
                    System.exit(0); 
                }     
            }
            if(kh.upPressed){
                kh.upPressed = false;
                UI.commandNum--;
                if (UI.commandNum < 1){
                    UI.commandNum = 5;
                }
            }

            if(kh.downPressed){
                kh.downPressed = false;
                UI.commandNum++;
                if (UI.commandNum > 5){
                    UI.commandNum = 1;
                }
            }

            if(kh.enterPressed){
                kh.enterPressed = false;
                if (UI.commandNum == 1){
                    // TitlePanel.gameState = TitlePanel.playState;
                    Screen.inventory();
                } else if (UI.commandNum == 2) { 
                    TitlePanel.gameState = TitlePanel.helpState;
                } else if (UI.commandNum == 5){
                    System.exit(0); 
                }
            }
        }

        else if (TitlePanel.gameState == TitlePanel.stepState){
            if(kh.enterPressed) {
                kh.enterPressed = false;
                TitlePanel.gameState = TitlePanel.titleState;
            }
        } 
            
        else if (TitlePanel.gameState == TitlePanel.helpState){
            if(kh.enterPressed){
                kh.enterPressed = false;
                TitlePanel.gameState = TitlePanel.stepState;
            } 
        }

        else if (TitlePanel.gameState == TitlePanel.plantState){
            if (kh.leftPressed) {
                kh.leftPressed = false;
                if (i > 0) {
                    i--;
                }
            }
        
            if (kh.rightPressed) {
                kh.rightPressed = false;
                if (i < 9) {
                    i++;
                } 
            }
        
            if (kh.upPressed) {
                if (i - COLUMNS >= 0) {
                    i -= COLUMNS;
                }
                kh.upPressed = false;
            }

            if (kh.downPressed) {
                if (i + COLUMNS < TOTAL_ITEMS) {
                    i += COLUMNS;
                }
                kh.downPressed = false;
            }
            if (kh.menuPressed) {
                kh.menuPressed = false;
                gameState = titleState;
            }
        }
        else if (TitlePanel.gameState == TitlePanel.zombieState){
            COLUMNS = 3;
            ROWS = 4;

            if (kh.leftPressed) {
                kh.leftPressed = false;
                if (i > 0) {
                    i--;
                }
                
            }
        
            if (kh.rightPressed) {
                kh.rightPressed = false;
                if (i < 9) {
                    i++;
                }
            }
        
            if (kh.upPressed) {
                if (i - COLUMNS >= 0) {
                    i -= COLUMNS;
                }
                kh.upPressed = false;
            }

            if (kh.downPressed) {
                if (i + COLUMNS < TOTAL_ITEMS) {
                    i += COLUMNS;
                }
                kh.downPressed = false;
            }

            if (kh.menuPressed) {
                kh.menuPressed = false;
                gameState = titleState;
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

        if (gameState == titleState){
            UI.drawTitle(g2);
        }
        else if (gameState == helpState) {
            UI.drawHelp(g2);
        } 
        else if (gameState == stepState) {
            UI.drawStep(g2);
        }
        else if (gameState == plantState){
            UI.drawPlantList(g2, i);
        }
        else if (gameState == zombieState){
            UI.drawZombieList(g2, i);
        }
    }

    // public void switchToInventoryPanel() {
    //     if (inventoryPanel == null) {
    //         inventoryPanel = new Inventory(gamePanel, kh);
    //     }
    //     window.remove(this);
    //     window.add(inventoryPanel);
    //     window.revalidate();
    //     window.repaint();
    //     stopThread();
    //     inventoryPanel.requestFocusInWindow();
    // }
    
    // public static void stopThread() {
    //     running = false;
    // }

    // public static void main(String[] args){

    //     JFrame window = new JFrame();
    //     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     window.setResizable(false);
    //     window.setTitle("MichaelVSLalapan");

    //     GamePanel gamePanel = new GamePanel();
    //     TitlePanel titlePanel = new TitlePanel(window, gamePanel);
    //     window.add(titlePanel);
        
    //     window.pack();

    //     window.setLocationRelativeTo(null);
    //     window.setVisible(true);

    //     titlePanel.startTitle();

    //     playBackSound("res/audio/title.wav");
    // }

    //     private static void playBackSound(String soundFilePath) {
    //     try {
    //         File soundFile = new File(soundFilePath);
    //         // System.out.println("Alamat file asli: " + soundFile.getAbsolutePath());
    //         if (!soundFile.exists()) {
    //             throw new IllegalArgumentException("File not found: " + soundFilePath);
    //         }
    //         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
    //         Clip clip = AudioSystem.getClip();
    //         clip.open(audioIn);

    //         clip.addLineListener(new LineListener() {
    //             @Override
    //             public void update(LineEvent event) {
    //                 if (event.getType() == LineEvent.Type.STOP) {
    //                     // Biar ngulang lagi
    //                     clip.setFramePosition(0);
    //                     clip.start();
    //                 }
    //             }
    //         });
            
    //         clip.start();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

}
