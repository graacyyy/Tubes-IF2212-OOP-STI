package main;

import javax.swing.JFrame;

import entity.DeckManager;
import entity.Sun;
import tile.GameMap;

public class Screen {

    public static GamePanel gamePanel = new GamePanel();
    public static TitlePanel titlePanel = new TitlePanel();
    public static Inventory inventory = new Inventory();
    public static LosePanel losePanel = new LosePanel();
    public static WinPanel winPanel = new WinPanel();
    public static JFrame window;

    public static void start(){

        window = new JFrame();

        window.setTitle("MichaelVSLalapan");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.add(titlePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        titlePanel.startTitleThread();
    }

    public static void inventory(){

        inventory.clearAllPlants();
        GameMap.zombies.clear();
        GameMap.plants.clear();
        GameMap.bullets.clear();
        Inventory.selectedPlants.clear();
        DeckManager.deck.clear();
        Sun.setSunAmount(50);
        GamePanel.gametime = 0;

        window.remove(titlePanel);
        titlePanel.setRunning(false);
        window.setTitle("MichaelVSLalapan");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.add(inventory);
        inventory.setRunning(true);
        inventory.requestFocusInWindow();
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void play(){

        window.remove(inventory);
        inventory.setRunning(false);
        window.setTitle("MichaelVSLalapan");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.add(gamePanel);
        gamePanel.requestFocusInWindow();
        gamePanel.setRunning(true);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.startGameThread();
    }

    public static void lose(){

        window.remove(gamePanel);
        gamePanel.setRunning(false);
        window.setTitle("MichaelVSLalapan");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.add(losePanel);
        losePanel.setRunning(true);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        losePanel.startLoseThread();
    }

    public static void win(){

        window.remove(gamePanel);
        gamePanel.setRunning(false);
        window.setTitle("MichaelVSLalapan");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.add(winPanel);
        winPanel.setRunning(true);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        winPanel.startWinThread();
    }

    public static void playAgain(){

        if (losePanel.isRunning()){
            window.remove(losePanel);
            losePanel.setRunning(false);
        }
        
        if (winPanel.isRunning()){
            window.remove(winPanel);
            winPanel.setRunning(false);
        }

        window.setTitle("MichaelVSLalapan");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.add(titlePanel);
        titlePanel.requestFocusInWindow();
        titlePanel.setRunning(true);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        titlePanel.startTitleThread();
    }

}
