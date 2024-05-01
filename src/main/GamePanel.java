package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16
    final int scale = 4;

    final int tileSize = originalTileSize * scale; // 64x64
    final int maxScreenCol = 11;
    final int maxScreenRow = 6;
    final int screenWidth = tileSize * maxScreenCol; // 704 pixels
    final int screenHeight = tileSize * maxScreenRow; // 384 pixels

    Thread gameThread;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(gameThread != null){
            // System.out.println("The loop is running");
        }
    }
}
