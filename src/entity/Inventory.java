package entity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.GamePanel;

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
    private BufferedImage playButton;
    private BufferedImage clearAllButton;

    private GamePanel gamePanel;

    public Inventory(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        initializePanel();
        loadImages();
        calculateImagePositions();
        storeOriginalPositions();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e.getX(), e.getY());
            }
        });
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

    private void displaySelectedPlants() {
        System.out.println("Selected Plants:");
        for (String plant : selectedPlants) {
            System.out.println(plant);
        }
    }

    private void handleMouseClick(int x, int y) {
        if (x >= 550 && x <= 650 && y >= 10 && y <= 40) {
            if (finaldeck.size() == 6) {
                switchToGamePanel();
            } else {
                JOptionPane.showMessageDialog(this, "You must select exactly 6 plants to start the game.");
            }
            return;
        }

        if (x >= 550 && x <= 650 && y >= 50 && y <= 80) {
            clearAllPlants();
            return;
        }

        for (int i = 0; i < finaldeck.size(); i++) {
            int imgX = i * 90;
            if (x >= imgX && x <= imgX + 90 && y >= 0 && y <= 90) {
                int index = finaldeck.get(i);
                String plantPath = imagePaths[index];
                finaldeck.remove(i);
                addPlantToInventory(index);
                removePlantFromDeck(plantPath);
                JOptionPane.showMessageDialog(this, extractPlantName(plantPath) + " removed from deck");
                repaint();
                displaySelectedPlants();
                return;
            }
        }

        for (int i = 0; i < imagePositions.length; i++) {
            int pos = imagePositions[i];
            int imgX = pos % 1000;
            int imgY = pos/ 1000;
            if (x >= imgX && x <= imgX + 90 && y >= imgY && y <= imgY + 90) {
                String plantPath = imagePaths[i];
                if (finaldeck.contains(i)) {
                    finaldeck.remove(Integer.valueOf(i));
                    addPlantToInventory(i);
                    removePlantFromDeck(plantPath);
                    JOptionPane.showMessageDialog(this, extractPlantName(plantPath) + " removed from deck");
                } else if (finaldeck.size() < 6) {
                    finaldeck.add(i);
                    removePlantFromInventory(i);
                    addPlantToDeck(plantPath);
                    JOptionPane.showMessageDialog(this, extractPlantName(plantPath) + " added to deck");
                } else {
                    JOptionPane.showMessageDialog(this, "You can only select up to 6 plants for the deck");
                }
                repaint();
                displaySelectedPlants();
                break;
            }
        }
    }

    private void addPlantToInventory(int index) {
        imagePositions[index] = originalPositions[index];
    }

    private void removePlantFromInventory(int index) {
        imagePositions[index] = -1;
    }

    private void clearAllPlants() {
        if (!finaldeck.isEmpty()) {
            for (int index : finaldeck) {
                addPlantToInventory(index);
            }
            finaldeck.clear();
            selectedPlants.clear();
            JOptionPane.showMessageDialog(this, "All plants removed from deck");
            repaint();
            displaySelectedPlants();
        }
    }

    private void switchToGamePanel() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.remove(this);
        frame.add(gamePanel);
        frame.revalidate();
        frame.repaint();
        gamePanel.startGameThread();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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

        if (finaldeck.size() != 6) {
            g.setColor(new Color(255, 0, 0, 128)); 
            g.fillRect(570, 10, 80, 30);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Plant Inventory");
        GamePanel gamePanel = new GamePanel();
        Inventory inventory = new Inventory(gamePanel);
        frame.add(inventory);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
