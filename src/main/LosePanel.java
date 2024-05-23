package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import tile.UI;

public class LosePanel extends JPanel implements Runnable {

    int FPS = 60;
    KeyHandler kh = new KeyHandler();
    private boolean running = true;
    Thread loseThread;

    // public LosePanel(GamePanel gamePanel, KeyHandler kh){
    public LosePanel(){
        // this.kh = kh;
        // this.gamePanel = gamePanel;
        this.setPreferredSize(new Dimension(GamePanel.screenWidth, GamePanel.screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
    }

    public void startLoseThread(){

        System.out.println("thread");
        loseThread = new Thread(this);
        loseThread.start();
        requestFocusInWindow();
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

        if(kh.upPressed){
            kh.upPressed = false;
            UI.commandNum--;
            if (UI.commandNum < 1){
                UI.commandNum = 2;
            }
        }

        if(kh.downPressed){
            kh.downPressed = false;
            UI.commandNum++;
            if (UI.commandNum > 2){
                UI.commandNum = 1;
            }
        }

        if(kh.enterPressed){
            kh.enterPressed = false;
            if (UI.commandNum == 1){
                TitlePanel.gameState = TitlePanel.titleState;
                Screen.playAgain();
                // switchToInventoryPanel();
                // removeKeyListener(kh);
                // Sun nya = 0
            } else {
                System.exit(0); 
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
        
        UI.drawLose(g2);
    }

    // public void switchToInventoryPanel() {
    //     stopThread();
    //     removeKeyListener(kh);
    //     System.out.println("Changed to ivent");
    //     GameMap.zombies.clear();
    //     GameMap.plants.clear();
    //     GameMap.bullets.clear();
    //     Inventory.selectedPlants.clear();
    //     DeckManager.deck.clear();
    //     GamePanel.gametime = 0;
    //     System.out.println(Inventory.selectedPlants.size());
    //     if (inventoryPanel == null) {
    //         inventoryPanel = new Inventory(gamePanel, kh);
    //     }
    //     JFrame window = Main.window;
    //     if (window != null) {
    //         window.remove(this);
    //         window.add(inventoryPanel);
    //         window.invalidate();
    //         window.validate();
    //         window.repaint();
    //         inventoryPanel.requestFocusInWindow();
    //     }
    // }

    // public static void stopThread() {
    //     running = false;
    // }
}
