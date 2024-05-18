package entity;

import javax.swing.*;

import main.GamePanel;
// import main.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Inventory extends JPanel {
    private ArrayList<ImageIcon> inventoryImages;
    private ArrayList<ImageIcon> deck;
    private JPanel inventoryPanel;
    private JPanel deckPanel;
    private static final int MAX_DECK_SIZE = 6;
    private JButton nextButton;

    public Inventory() {
        inventoryImages = new ArrayList<>();
        deck = new ArrayList<>();
        initializeGUI();
    }

    private void initializeGUI() {
        setLayout(new BorderLayout());

        inventoryPanel = new JPanel(new GridLayout(2, 5, 5, 5));
        inventoryPanel.setBorder(BorderFactory.createTitledBorder("Inventory"));

        deckPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        deckPanel.setBorder(BorderFactory.createTitledBorder("Deck"));
        deckPanel.setPreferredSize(new Dimension(MAX_DECK_SIZE * 50 + 20, 250));

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToGamePanel();
            }
        });

        String[] imagePaths = {
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

        for (String imagePath : imagePaths) {
            try {
                ImageIcon icon = new ImageIcon(imagePath);
                inventoryImages.add(icon);
                JLabel label = new JLabel(icon);
                label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            if (deck.size() < MAX_DECK_SIZE) {
                                ImageIcon selectedImage = new ImageIcon(imagePath);
                                addPlantToDeck(selectedImage);
                                removeFromInventory(label);
                            } else {
                                JOptionPane.showMessageDialog(null, "You can only select up to " + MAX_DECK_SIZE + " plants for the deck.");
                            }
                        }
                    }
                });
                inventoryPanel.add(label);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        deckPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    Component[] components = deckPanel.getComponents();
                    for (Component component : components) {
                        if (component instanceof JLabel) {
                            JLabel label = (JLabel) component;
                            if (label.getBounds().contains(e.getPoint())) {
                                removePlantFromDeck(label);
                                addToInventory(label.getIcon());
                                break;
                            }
                        }
                    }
                }
            }
        });

        add(new JScrollPane(deckPanel), BorderLayout.NORTH);
        add(new JScrollPane(inventoryPanel), BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);
    }

    private void addPlantToDeck(ImageIcon selectedImage) {
        Image image = selectedImage.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        JLabel plantLabel = new JLabel(scaledIcon);
        plantLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        deckPanel.add(plantLabel);
        deckPanel.revalidate();
        deckPanel.repaint();
        deck.add(selectedImage);
    }

    private void removeFromInventory(JLabel label) {
        inventoryPanel.remove(label);
        inventoryPanel.revalidate();
        inventoryPanel.repaint();
    }

    private void removePlantFromDeck(JLabel label) {
        deckPanel.remove(label);
        deckPanel.revalidate();
        deckPanel.repaint();
        deck.remove(label.getIcon());
    }

    private void addToInventory(Icon icon) {
        JLabel label = new JLabel(icon);
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (deck.size() < MAX_DECK_SIZE) {
                        addPlantToDeck((ImageIcon) icon);
                        removeFromInventory(label);
                    } else {
                        JOptionPane.showMessageDialog(null, "You can only select up to " + MAX_DECK_SIZE + " plants for the deck.");
                    }
                }
            }
        });
        inventoryPanel.add(label);
        inventoryPanel.revalidate();
        inventoryPanel.repaint();
    }

    private void switchToGamePanel() {
        JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);
        window.getContentPane().removeAll();
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.revalidate();
        window.repaint();
        gamePanel.startGameThread();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Plant Inventory");

        Inventory inventory = new Inventory();
        window.add(inventory);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
