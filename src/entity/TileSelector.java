package entity;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class TileSelector {

    protected int x;
    protected int y;
    
    public TileSelector(){

        setDefaultValues();
    }

    public void setDefaultValues(){

        x = 0;
        y = 0;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }   

    public void draw(Graphics2D g2){
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File("././res/ /tileselector.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g2.drawImage(image, x, y, GamePanel.tileSize, GamePanel.tileSize, null);
    }

}