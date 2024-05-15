package main;

import javax.swing.JFrame;

// import entity.plants.PeaShooter;
// import entity.zombies.NormalZombie;
// import tile.GameMap;

public class Main {
    static GamePanel gamePanel;
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("MichaelVSLalapan");

        gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.startGameThread();
    }
}
