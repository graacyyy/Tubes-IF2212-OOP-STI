package entity.plants;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// import entity.zombies.BalloonZombie;
import entity.zombies.Zombie;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.CustomListener;
import main.GamePanel;
import tile.GameMap;

public class Bullet implements CustomListener{
    protected int x;
    protected int y;
    protected int damage;
    protected String fileimage;
    protected boolean hit;

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


    public void draw(Graphics2D g2){

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(fileimage));
         } catch (IOException e) {
                 e.printStackTrace();
             }

         g2.drawImage(image, x, y, GamePanel.tileSize, GamePanel.tileSize, null);
    }

    public void hit(Zombie zombie) {
        zombie.takeDamage(damage);
    }

    public boolean isHit(){
        return hit;
    }

    @Override
    public void actionPerformed() {
        moveBullet();
        for (Zombie zombie : GameMap.zombies){
            if (zombie.getX() >= x&&zombie.getX() <= x+GamePanel.tileSize && zombie.getY() == y){
                hit(zombie);
                hit = true;
            }
        }
    }

}