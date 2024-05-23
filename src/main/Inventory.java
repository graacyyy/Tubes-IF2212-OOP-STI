package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
// import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
// import javax.swing.SwingUtilities;


public class Inventory extends JPanel {
    private BufferedImage[] images = new BufferedImage[10];
    private String[] imagePaths = {
        "././res/deck/cactus.png",
        "././res/deck/iceshroom.png",
        "././res/deck/jalapeno.png",
        "././res/deck/lilypad.png",
        "././res/deck/peashooter.png",
        "././res/deck/snowpea.png",
        "././res/deck/squash.png",
        "././res/deck/sunflower.png",
        "././res/deck/tanglekelp.png",
        "././res/deck/wallnut.png",
    };

    private int[] imagePositions = new int[10];
    private int[] originalPositions = new int[10];
    public static ArrayList<Integer> finaldeck = new ArrayList<>();
    public static List<String> selectedPlants = new ArrayList<>();
    // public static String[] deck = new String[6];
    private BufferedImage playButton;
    private BufferedImage clearAllButton;
    private BufferedImage swapButton;
    // private GamePanel gamePanel;
    KeyHandler kh = new KeyHandler();
    private int selectedIndex = -1;
    private int firstSwapIndex = -1;
    private int secondSwapIndex = -1;
    private boolean swapMode = false;

    private boolean running = true;

    // public Inventory(GamePanel gamePanel, KeyHandler kh) {
    public Inventory() {
        // this.gamePanel = gamePanel;
        // this.kh = kh;
        initializePanel();
        loadImages();
        calculateImagePositions();
        storeOriginalPositions();
        setFocusable(true);
        addKeyListener(kh);
    }

    private void initializePanel() {
        setPreferredSize(new Dimension(704, 448));
        setDoubleBuffered(true);
        setBackground(Color.white);
    }

    private void loadImages() {
        try {
            playButton = ImageIO.read(new File("././res/play.png"));
            clearAllButton = ImageIO.read(new File("././res/clear.png"));
            swapButton = ImageIO.read(new File("././res/swap.png"));
            for (int i = 0; i < imagePaths.length; i++) {
                images[i] = ImageIO.read(new File(imagePaths[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading images: " + e.getMessage());
        }
    }

    private void calculateImagePositions() {
        int index = 0;
        for (int y = 2; y <= 3; y++) {
            for (int x = 0; x < 5; x++) {
                imagePositions[index++] = x * 90 + y * 90 * 1000;
            }
        }
    }

    private void storeOriginalPositions() {
        for (int i = 0; i < imagePositions.length; i++) {
            originalPositions[i] = imagePositions[i];
        }
    }

    private String extractPlantName(String filePath) {
        String fileName = new File(filePath).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex != -1) ? fileName.substring(0, dotIndex) : fileName;
    }

    private void addPlantToDeck(String filePath) {
        selectedPlants.add(filePath);
    }

    private void removePlantFromDeck(String filePath) {
        selectedPlants.remove(filePath);
    }

    public void displaySelectedPlants() {
        System.out.println("Selected Plants:");
        for (String plant : selectedPlants) {
            System.out.println(plant);
        }
    }

    private void handleKeyPress() {
        if (kh.enterPressed) {
            kh.enterPressed = false;
            if (swapMode) {
                handleSwapSelection();
                return;
            }
            if (selectedIndex == 10) {
                if (finaldeck.size() == 6) {
                    // switchToGamePanel();
                    TitlePanel.gameState = TitlePanel.playState;
                    Screen.play();
                }
                else {
                    JOptionPane.showMessageDialog(this, "You must select exactly 6 plants to start the game.");
                }
                return;
            } 
            else if (selectedIndex == 11) { 
                clearAllPlants();
                return;
            }
            else if (selectedIndex == 12) {
                swapMode = !swapMode;
                firstSwapIndex = -1;
                secondSwapIndex = -1;
                JOptionPane.showMessageDialog(this, "Swap mode " + (swapMode ? "enabled" : "disabled") + ". Select two plants to swap.");
                return;
            } 
            else if (selectedIndex >= 0 && selectedIndex < 10) { 
                String plantPath = imagePaths[selectedIndex];
                if (finaldeck.contains(selectedIndex)) {
                    finaldeck.remove(Integer.valueOf(selectedIndex));
                    addPlantToInventory(selectedIndex);
                    removePlantFromDeck(plantPath);
                }
                else if (finaldeck.size() < 6) {
                    finaldeck.add(selectedIndex);
                    removePlantFromInventory(selectedIndex);
                    addPlantToDeck(plantPath);
                }
                else {
                    JOptionPane.showMessageDialog(this, "You can only select up to 6 plants for the deck");
                }
                repaint();
                displaySelectedPlants();
            }
    }

    if (kh.upPressed) {
        kh.upPressed = false;
        if (selectedIndex < 5) {
            selectedIndex = 10; 
        } else {
            selectedIndex -= 5;
        }
        repaint();
    }

    if (kh.downPressed) {
        kh.downPressed = false;
        if (selectedIndex >= 5 && selectedIndex < 10) {
            selectedIndex = 11; 
        } 
        else if (selectedIndex >= 10){
            selectedIndex = 12;
        }
        else {
            selectedIndex += 5;
        }
        repaint();
    }

    if (kh.leftPressed) {
        kh.leftPressed = false;
        selectedIndex = (selectedIndex - 1 + 13) % 13; 
        repaint();
    }

    if (kh.rightPressed) {
        kh.rightPressed = false;
        selectedIndex = (selectedIndex + 1) % 13; 
        repaint();
    }

        if (kh.numPressed) {
            kh.numPressed = false;
            int numKey = kh.numKey;
            if (numKey >= 1 && numKey <= 6) {
                int index = numKey - 1; 
                if (finaldeck.size() > index) {
                    int plantIndex = finaldeck.get(index);
                    finaldeck.remove(Integer.valueOf(plantIndex));
                    addPlantToInventory(plantIndex);
                    String plantPath = imagePaths[plantIndex];
                    removePlantFromDeck(plantPath);
                    JOptionPane.showMessageDialog(this, extractPlantName(plantPath) + " removed from deck");
                    repaint();
                    displaySelectedPlants();
                }
            }
        }
    }

    private void handleSwapSelection() {
        if (selectedIndex >= 0 && selectedIndex < 10) {
            if (firstSwapIndex == -1) {
                firstSwapIndex = selectedIndex;
                JOptionPane.showMessageDialog(this, "First plant selected");
            } else if (secondSwapIndex == -1) {
                secondSwapIndex = selectedIndex;
                JOptionPane.showMessageDialog(this, "Second plant selected");
                swapSelectedPlants();
            }
        }
    }

    private void swapSelectedPlants() {
        if (firstSwapIndex != -1 && secondSwapIndex != -1 && firstSwapIndex != secondSwapIndex) {
            boolean firstInDeck = finaldeck.contains(firstSwapIndex);
            boolean secondInDeck = finaldeck.contains(secondSwapIndex);

            if (firstInDeck && secondInDeck) {
                int firstIndexInDeck = finaldeck.indexOf(firstSwapIndex);
                int secondIndexInDeck = finaldeck.indexOf(secondSwapIndex);
                int temp = finaldeck.get(firstIndexInDeck);
                finaldeck.set(firstIndexInDeck, finaldeck.get(secondIndexInDeck));
                finaldeck.set(secondIndexInDeck, temp);

                if (selectedIndex == firstSwapIndex) {
                selectedIndex = secondSwapIndex;
                } 
                else if (selectedIndex == secondSwapIndex) {
                selectedIndex = firstSwapIndex;
                }
            } 
            else if (!firstInDeck && !secondInDeck) {
                if (selectedIndex == firstSwapIndex) {
                    selectedIndex = secondSwapIndex;
                } 
                else if (selectedIndex == secondSwapIndex) {
                    selectedIndex = firstSwapIndex;
                }
                
                BufferedImage tempPosition = images[firstSwapIndex];
                images[firstSwapIndex] = images[secondSwapIndex];
                images[secondSwapIndex] = tempPosition;


            } 
            else {
                JOptionPane.showMessageDialog(this, "Both selected plants must be in the same area (both in inventory or both in deck) to swap.");
                firstSwapIndex = -1;
                secondSwapIndex = -1;
                return;
            }
            repaint();
            JOptionPane.showMessageDialog(this, "Swap is Succesfull!");
            firstSwapIndex = -1;
            secondSwapIndex = -1;
            swapMode = false;
        } 
        else {
            JOptionPane.showMessageDialog(this, "Invalid swap. Please select two different plants.");
            firstSwapIndex = -1;
            secondSwapIndex = -1;
            swapMode = false;
        }
    }


    private void addPlantToInventory(int index) {
        imagePositions[index] = originalPositions[index];
    }

    private void removePlantFromInventory(int index) {
        imagePositions[index] = -1;
    }

    public void clearAllPlants() {
        if (!finaldeck.isEmpty()) {
            for (int index : finaldeck) {
                addPlantToInventory(index);
            }
            finaldeck.clear();
            selectedPlants.clear();
            // JOptionPane.showMessageDialog(this, "All plants removed from deck");
            repaint();
            displaySelectedPlants();
        }
    }

    public void setRunning(boolean running){
        this.running = running;
    }

    public boolean isRunning(){
        return running;
    }

    // public void switchToGamePanel() {
    //     removeKeyListener(kh);
    //     JFrame frame = Main.window;
    //     if (frame != null){
    //         frame.remove(this);
    //         frame.add(gamePanel);
    //         frame.invalidate();
    //         frame.validate();
    //         frame.repaint();
    //         running = false;
    //         gamePanel.startGameThread();
    //         gamePanel.requestFocusInWindow();
    //     }
    // }    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
        BufferedImage backgroundImage = ImageIO.read(new File("././res/inventory.png"));
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < images.length; i++) {
            int pos = imagePositions[i];
            if (pos != -1) {
                int x = pos % 1000;
                int y = pos / 1000;
                g.drawImage(images[i], x, y, 90, 90, null);
            }
        }
        for (int i = 0; i < finaldeck.size(); i++) {
            int x = i * 90;
            g.drawImage(images[finaldeck.get(i)], x, 0, 90, 90, null);
        }
        g.drawImage(playButton, 570, 10, 80, 30, null);
        g.drawImage(clearAllButton, 570, 50, 80, 30, null);
        g.drawImage(swapButton, 570, 90, 80, 30, null);

        if (finaldeck.size() != 6) {
            g.setColor(new Color(255, 0, 0, 128));
            g.fillRect(570, 10, 80, 30);
        }

        g.setColor(Color.WHITE);
        if (selectedIndex >= 0 && selectedIndex < 10) {
            int x=0;
            int y=0;
            if(selectedIndex>4){
                x = 90*(selectedIndex-5);
                y = 90*3;
            }else{
                x = 90*(selectedIndex);
                y = 90*2;
            }
  
                g.drawRect(x, y, 90, 90);
            
        } else if (selectedIndex == 10) {
            g.drawRect(570, 10, 80, 30);
        } else if (selectedIndex == 11) {
            g.drawRect(570, 50, 80, 30);
        } else if (selectedIndex == 12) {
            g.drawRect(570, 90, 80, 30);
        }

    }

    @Override
    public void addNotify() {
        super.addNotify();
        setFocusable(true);
        requestFocusInWindow();
        new Thread(() -> {
            while (running) {
                handleKeyPress();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         JFrame frame = new JFrame("Inventory");
    //         GamePanel gamePanel = new GamePanel();
    //         KeyHandler kh = new KeyHandler();
    //         Inventory inventory = new Inventory(gamePanel, kh);
    //         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //         frame.getContentPane().add(inventory);
    //         frame.pack();
    //         frame.setLocationRelativeTo(null);
    //         frame.setVisible(true);
    //     });
    // }
}
