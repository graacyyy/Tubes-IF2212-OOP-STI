package tile;

// import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
// import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
// import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import main.GamePanel;
import main.TitlePanel;

public class UI {
    public static Font titleFont;
    static Font heading2;
    static String text;
    private static BufferedImage titleImage, loseImage, winImage, pauseImage, helpImage1, helpImage2;
    public static int commandNum = 1;

    static {
        try {
            titleImage = ImageIO.read(new File("././res/menu/titlemenu.png"));
            loseImage = ImageIO.read(new File("././res/menu/gameover.png"));
            winImage = ImageIO.read(new File("././res/menu/winPage.png"));
            pauseImage = ImageIO.read(new File("././res/menu/pause.png"));
            helpImage1 = ImageIO.read(new File("././res/menu/help_1.png"));
            helpImage2 = ImageIO.read(new File("././res/menu/help_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            // BACKGROUND
            
            // TITLE NAME
            // g2.setFont(titleFont);
            // text = "Michael Vs Lalapan";
            // int x = getXForCenteredText(g2, text);
            // int y = GamePanel.tileSize*2;

            // g2.drawString(text, x, y);

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
            // BACKGROUND
            
            // TITLE NAME
            // g2.setFont(titleFont);
            // text = "GAME OVER";
            // int x = getXForCenteredText(g2, text);
            // int y = GamePanel.tileSize*2;

            // g2.drawString(text, x, y);

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
            // BACKGROUND
            
            // TITLE NAME
            // g2.setFont(titleFont);
            // text = "GAME OVER";
            // int x = getXForCenteredText(g2, text);
            // int y = GamePanel.tileSize*2;

            // g2.drawString(text, x, y);

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

            text = "NEXT";
            int x = getXForCenteredText(g2, text);
            int y = (int) (GamePanel.tileSize*5.5f);
            g2.drawString(text, x, y);
            g2.drawString(">", x-GamePanel.tileSize, y);
        }
    }

    public static void drawStep(Graphics2D g2) {
        if (helpImage2 != null) {
            g2.drawImage(helpImage2, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight,null);
        }

        g2.setFont(titleFont);
        g2.setColor(Color.white);

        if(TitlePanel.gameState == TitlePanel.stepState) {

            // MENU
            g2.setFont(titleFont);

            text = "MENU";
            int x = getXForCenteredText(g2, text);
            int y = (int) (GamePanel.tileSize*5.5f);
            g2.drawString(text, x, y);
            g2.drawString(">", x-GamePanel.tileSize, y);
        }
    }
/* 
    public static void drawInventory(Graphics g2){
        if (GamePanel.gameState == GamePanel.inventoryState){
        
            // FRAME
        int frameX = GamePanel.tileSize*9;
        int frameY = GamePanel.tileSize;
        int frameWidth = GamePanel.tileSize*6;
        int frameHeight = GamePanel.tileSize*5;

        drawSubWindow(frameX, frameY, frameHeight, frameWidth);

        // SLOT
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;
        }

        // CURSOR
        int cursorX = slotXstart + (GamePanel.tileSize * slotCol);
        int cursorY = slotYstart + (GamePanel.tileSize * slotRow);
        int cursorHeight = GamePanel.tileSize;
        int cursorWidth = GamePanel.tileSize;

        // DRAW CURSOR
        g2.setColor(Color.white);
        ((Graphics2D) g2).setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);

    }

    public static void drawSubWindow(int x, int y, int width, int height){}; */

        // g2.drawString("Michael Vs Lalapan", 100, 100);
        
        // String text;
        // int textLength;

        // int x, y;

        // text = "Michael Vs Lalapan";
        // textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        // x = GamePanel.screenWidth/2 - textLength/2;
        // y = GamePanel.screenHeight/2 - ((GamePanel.tileSize)*3);
        // g2.drawString(text, x, y);

        // text = "START";
        // textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        // x = GamePanel.screenWidth/2 - textLength/2;
        // y = GamePanel.screenHeight/2 + ((GamePanel.tileSize)*3);
        // g2.drawString(text, x, y);

        // g2.setFont(heading2);
    
}
