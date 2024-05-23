package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import tile.UI;

public class WinPanel extends JPanel implements Runnable{

    int FPS = 60;
    KeyHandler kh = new KeyHandler();
    private boolean running = true;
    Thread winThread;

    public WinPanel(){
        this.setPreferredSize(new Dimension(GamePanel.screenWidth, GamePanel.screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
    }

    public void startWinThread(){

        System.out.println("thread");
        winThread = new Thread(this);
        winThread.start();
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

        if (kh.upPressed) {
            kh.upPressed = false;
            UI.commandNum--;
            if (UI.commandNum < 1) {
                UI.commandNum = 2;
            }
        }

        if (kh.downPressed) {
            kh.downPressed = false;
            UI.commandNum++;
            if (UI.commandNum > 2) {
                UI.commandNum = 1;
            }
        }

        if (kh.enterPressed) {
            kh.enterPressed = false;
            if (UI.commandNum == 1) {
                TitlePanel.gameState = TitlePanel.titleState;
                Screen.playAgain();
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
        
        UI.drawWin(g2);
    }

}
