package tile;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import main.GamePanel;

public class UI {
    Font titleFont, heading2;
    Graphics g2;
    String text;
    int commandNum = 0;
    
    public UI(){
        titleFont = new Font ("Terminal", Font.BOLD, 48);
        heading2 = new Font("Terminal", Font.PLAIN, 12);
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(titleFont);
        g2.setColor(Color.white);

        if(GamePanel.gameState == GamePanel.titleState) {
            // BACKGROUND
            
            // TITLE NAME
            g2.setFont(titleFont);
            text = "Michael Vs Lalapan";
            int x = getXForCenteredText(text);
            int y = GamePanel.tileSize*2;

            g2.drawString(text, x, y);

            // MENU
            g2.setFont(heading2);

            text = "START";
            x = getXForCenteredText(text);
            y += GamePanel.tileSize*0.7f;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }

            text = "HELP";
            x = getXForCenteredText(text);
            y += GamePanel.tileSize*0.5f;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-GamePanel.tileSize, y);
            }

        }
    }

    public int getXForCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = GamePanel.screenWidth/2 - length/2;
        return x;
    }

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
