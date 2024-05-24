package main;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class Main {

    public static void main(String[] args) {

        Screen.start();
        playBackSound("././res/audio/title.wav");

    }

    public static void playBackSound(String soundFilePath) {

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


// package main;

// import java.io.File;
// import javax.sound.sampled.AudioInputStream;
// import javax.sound.sampled.AudioSystem;
// import javax.sound.sampled.Clip;
// import javax.sound.sampled.LineEvent;
// import javax.sound.sampled.LineListener;
// import javax.swing.JFrame;

// // import entity.plants.PeaShooter;
// // import entity.zombies.NormalZombie;
// // import tile.GameMap;

// public class Main {
//     static GamePanel gamePanel;

//     public static void main(String[] args) {
//         JFrame window = new JFrame();
//         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         window.setResizable(false);
//         window.setTitle("MichaelVSLalapan");

//         gamePanel = new GamePanel();
//         window.add(gamePanel);

//         window.pack();

//         window.setLocationRelativeTo(null);
//         window.setVisible(true);
//         gamePanel.startGameThread();
        
//         playBackSound("res/audio/title.wav");
//     }
  
//     private static void playBackSound(String soundFilePath) {
//         try {
//             File soundFile = new File(soundFilePath);
//             // System.out.println("Alamat file asli: " + soundFile.getAbsolutePath());
//             if (!soundFile.exists()) {
//                 throw new IllegalArgumentException("File not found: " + soundFilePath);
//             }
//             AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
//             Clip clip = AudioSystem.getClip();
//             clip.open(audioIn);

//             clip.addLineListener(new LineListener() {
//                 @Override
//                 public void update(LineEvent event) {
//                     if (event.getType() == LineEvent.Type.STOP) {
//                         // Biar ngulang lagi
//                         clip.setFramePosition(0);
//                         clip.start();
//                     }
//                 }
//             });
            
//             clip.start();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
    
//     public static void startThread(){
//         gamePanel.startGameThread();
//     }
// }