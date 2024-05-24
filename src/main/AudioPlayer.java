package main;

import java.io.File;
import javax.sound.sampled.*;

public class AudioPlayer {

    private static Clip clip;

    public static void playBackSound(String soundFilePath) {
        stopSound();
        try {
            File soundFile = new File(soundFilePath);
            if (!soundFile.exists()) {
                throw new IllegalArgumentException("File not found: " + soundFilePath);
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);

            clip.start();
        } catch (Exception e) {}
    }

    public static void playBackSound(String soundFilePath, boolean loop) {
        stopSound();
        try {
            File soundFile = new File(soundFilePath);
            if (!soundFile.exists()) {
                throw new IllegalArgumentException("File not found: " + soundFilePath);
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);

            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

            clip.start();
        } catch (Exception e) {}
    }

    public static void stopSound() {
        if (clip != null) {
            clip.stop();
            clip.flush();
            clip.close();
            clip = null;
        }
    }
}
