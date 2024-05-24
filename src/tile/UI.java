package tile;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.TitlePanel;

public class UI {

    public static Font titleFont;
    static Font heading2;
    static String text;

    private static BufferedImage titleImage, loseImage, winImage, pauseImage, helpImage1;
    public static int commandNum = 1;

    static BufferedImage[] plantImages = new BufferedImage[10];
    static BufferedImage[] zombieImages = new BufferedImage[10];
    static BufferedImage[] stepImages = new BufferedImage[13];

    static {
        try {
            // BACKGROUND
            titleImage = ImageIO.read(new File("././res/menu/titlemenu.png"));
            loseImage = ImageIO.read(new File("././res/menu/gameover.png"));
            winImage = ImageIO.read(new File("././res/menu/winPage.png"));
            pauseImage = ImageIO.read(new File("././res/menu/pause.png"));
            helpImage1 = ImageIO.read(new File("././res/menu/help_1.png"));

            // PLANT LIST
            plantImages[0] = ImageIO.read(new File("././res/menu/plantList/1.png"));
            plantImages[1] = ImageIO.read(new File("././res/menu/plantList/2.png"));
            plantImages[2] = ImageIO.read(new File("././res/menu/plantList/3.png"));
            plantImages[3] = ImageIO.read(new File("././res/menu/plantList/4.png"));
            plantImages[4] = ImageIO.read(new File("././res/menu/plantList/5.png"));
            plantImages[5] = ImageIO.read(new File("././res/menu/plantList/6.png"));
            plantImages[6] = ImageIO.read(new File("././res/menu/plantList/7.png"));
            plantImages[7] = ImageIO.read(new File("././res/menu/plantList/8.png"));
            plantImages[8] = ImageIO.read(new File("././res/menu/plantList/9.png"));
            plantImages[9] = ImageIO.read(new File("././res/menu/plantList/10.png"));

            // ZOMBIE LIST
            zombieImages[0] = ImageIO.read(new File("././res/menu/zombieList/1.png"));
            zombieImages[1] = ImageIO.read(new File("././res/menu/zombieList/2.png"));
            zombieImages[2] = ImageIO.read(new File("././res/menu/zombieList/3.png"));
            zombieImages[3] = ImageIO.read(new File("././res/menu/zombieList/4.png"));
            zombieImages[4] = ImageIO.read(new File("././res/menu/zombieList/5.png"));
            zombieImages[5] = ImageIO.read(new File("././res/menu/zombieList/6.png"));
            zombieImages[6] = ImageIO.read(new File("././res/menu/zombieList/7.png"));
            zombieImages[7] = ImageIO.read(new File("././res/menu/zombieList/8.png"));
            zombieImages[8] = ImageIO.read(new File("././res/menu/zombieList/9.png"));
            zombieImages[9] = ImageIO.read(new File("././res/menu/zombieList/10.png"));

            // TUTORIAL
            stepImages[0] = ImageIO.read(new File("././res/menu/tutorial/1.png"));
            stepImages[1] = ImageIO.read(new File("././res/menu/tutorial/2.png"));
            stepImages[2] = ImageIO.read(new File("././res/menu/tutorial/3.png"));
            stepImages[3] = ImageIO.read(new File("././res/menu/tutorial/4.png"));
            stepImages[4] = ImageIO.read(new File("././res/menu/tutorial/5.png"));
            stepImages[5] = ImageIO.read(new File("././res/menu/tutorial/6.png"));
            stepImages[6] = ImageIO.read(new File("././res/menu/tutorial/7.png"));
            stepImages[7] = ImageIO.read(new File("././res/menu/tutorial/8.png"));
            stepImages[8] = ImageIO.read(new File("././res/menu/tutorial/9.png"));
            stepImages[9] = ImageIO.read(new File("././res/menu/tutorial/10.png"));
            stepImages[10] = ImageIO.read(new File("././res/menu/tutorial/11.png"));
            stepImages[11] = ImageIO.read(new File("././res/menu/tutorial/12.png"));
            stepImages[12] = ImageIO.read(new File("././res/menu/tutorial/13.png")); 
        } catch (IOException e) {}
    }
    
    public UI(){

        titleFont = new Font ("Terminal", Font.BOLD, 60);
        heading2 = new Font("Terminal", Font.PLAIN, 12);
    }

    public static void drawTitle(Graphics2D g2){
        
        if (titleImage != null) {
            g2.drawImage(titleImage, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight,null);
        }

        g2.setFont(titleFont);
        g2.setColor(Color.white);

        if(TitlePanel.gameState == TitlePanel.titleState) {

            // MENU
            g2.setFont(titleFont);

            text = "START";
            int x = getXForCenteredText(g2, text);
            int y = (int) (GamePanel.tileSize*3.2f);
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }

            text = "HELP";
            x = getXForCenteredText(g2, text);
            y += GamePanel.tileSize*0.5f;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }

            text = "PLANT LIST";
            x = getXForCenteredText(g2, text);
            y += GamePanel.tileSize*0.5f;
            g2.drawString(text, x, y);
            if(commandNum == 3){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }

            text = "ZOMBIE LIST";
            x = getXForCenteredText(g2, text);
            y += GamePanel.tileSize*0.5f;
            g2.drawString(text, x, y);
            if(commandNum == 4){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }

            text = "EXIT";
            x = getXForCenteredText(g2, text);
            y += GamePanel.tileSize*0.5f;
            g2.drawString(text, x, y);
            if(commandNum == 5){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }

        }
    }

    public static int getXForCenteredText(Graphics2D g2, String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = GamePanel.screenWidth / 2 - length / 2;
        return x;
    }

    public static void drawLose(Graphics2D g2) {
        if (loseImage != null) {
            g2.drawImage(loseImage, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight,null);
        }

        g2.setFont(titleFont);
        g2.setColor(Color.white);

        if(TitlePanel.gameState == TitlePanel.loseState) {

            // MENU
            g2.setFont(titleFont);

            text = "PLAY AGAIN";
            int x = getXForCenteredText(g2, text);
            int y = (int) (GamePanel.tileSize*3.2f);
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }

            text = "EXIT";
            x = getXForCenteredText(g2, text);
            y += GamePanel.tileSize*0.5f;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }
        }
    }

    public static void drawWin(Graphics2D g2) {
        if (winImage != null) {
            g2.drawImage(winImage, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight,null);
        }

        g2.setFont(titleFont);
        g2.setColor(Color.white);

        if(TitlePanel.gameState == TitlePanel.winState) {

            // MENU
            g2.setFont(titleFont);

            text = "PLAY AGAIN";
            int x = getXForCenteredText(g2, text);
            int y = (int) (GamePanel.tileSize*4f);
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }

            text = "EXIT";
            x = getXForCenteredText(g2, text);
            y += GamePanel.tileSize*0.5f;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }
        }
    }

    public static void drawPause(Graphics2D g2) {
        if (pauseImage != null) {
            g2.drawImage(pauseImage, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight,null);
        }
    }

    public static void drawHelp(Graphics2D g2) {
        if (helpImage1 != null) {
            g2.drawImage(helpImage1, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight,null);
        }

        g2.setFont(titleFont);
        g2.setColor(Color.white);

        if(TitlePanel.gameState == TitlePanel.helpState) {

            // MENU
            g2.setFont(titleFont);

            text = "MENU";
            int x = getXForCenteredText(g2, text);
            int y = (int) (GamePanel.tileSize*5.5f);
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }

            text = "TUTORIAL";
            x = getXForCenteredText(g2, text);
            y += GamePanel.tileSize*0.5f;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }
        }
    }

    public static void drawStep(Graphics2D g2, int i) {
        if (TitlePanel.gameState == TitlePanel.stepState){
            if (stepImages[i] != null && i >= 0 && i < 13) {
                g2.drawImage(stepImages[i], 0, 0, GamePanel.screenWidth, GamePanel.screenHeight, null);
            }   
        }
    }

    public static void drawPlantList(Graphics2D g2, int i){
        if (TitlePanel.gameState == TitlePanel.plantState){
            if (plantImages[i] != null && i >= 0 && i < 10) {
                g2.drawImage(plantImages[i], 0, 0, GamePanel.screenWidth, GamePanel.screenHeight, null);
            }    
        }
    }

    public static void drawZombieList(Graphics2D g2, int i){
        if (TitlePanel.gameState == TitlePanel.zombieState){
            if (zombieImages[i] != null && i >= 0 && i < 10) {
                g2.drawImage(zombieImages[i], 0, 0, GamePanel.screenWidth, GamePanel.screenHeight, null);
            }    
        }
    }    
}
