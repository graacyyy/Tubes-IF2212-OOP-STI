package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.Inventory;
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
    
    Thread titleThread;
    int FPS = 60;
    KeyHandlerUI kh = new KeyHandlerUI(this);
    JFrame window = new JFrame();
    Inventory inventoryPanel;
    GamePanel gamePanel;
    static boolean startTitle = true;
    
    public TitlePanel(JFrame window, GamePanel gamePanel){

        this.window = window;
        this.setPreferredSize(new Dimension(GamePanel.screenWidth, GamePanel.screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
        this.gamePanel = gamePanel;
        gameState = titleState;
        // moveZombie();
        // moveBullet();
    }

    public void startTitle() {
        
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

        while(startTitle){

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
    }

    public void switchToInventoryPanel() {
        if (inventoryPanel == null) {
            inventoryPanel = new Inventory(gamePanel);
        }
        window.remove(this);
        window.add(inventoryPanel);
        window.revalidate();
        window.repaint();
        startTitle = false;
    }

    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("MichaelVSLalapan");

        GamePanel gamePanel = new GamePanel();
        TitlePanel titlePanel = new TitlePanel(window, gamePanel);
        window.add(titlePanel);
        
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        titlePanel.startTitle();

        playBackSound("res/audio/title.wav");
    }

        private static void playBackSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            // System.out.println("Alamat file asli: " + soundFile.getAbsolutePath());
            if (!soundFile.exists()) {
                throw new IllegalArgumentException("File not found: " + soundFilePath);
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);

            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        // Biar ngulang lagi
                        clip.setFramePosition(0);
                        clip.start();
                    }
                }
            });
            
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
