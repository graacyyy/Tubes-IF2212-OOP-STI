package entity.plants;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.zombies.Zombie;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Bullet {
    protected int x;
    protected int y;
    protected int damage;
    protected String fileimage;

    public Bullet(int x, int y, int damage){
        this.x = x;
        this.y = y;
        this.damage=damage;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }


    public void moveBullet(){
        x++;
    }


    public void drawBullet(Graphics2D g2){

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(fileimage));
         } catch (IOException e) {
                 e.printStackTrace();
             }

         g2.drawImage(image, x, y, GamePanel.tileSize, GamePanel.tileSize, null);
    }

    public void hit(Zombie zombie) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hit'");
    }
}
