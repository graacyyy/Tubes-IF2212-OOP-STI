package entity.plants;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.Graphics2D;

import entity.Entity;
import entity.zombies.Zombie;
import main.CustomListener;
import main.GamePanel;

public abstract class Plant extends Entity implements CustomListener{
    
    protected int cost;
    protected int range;
    protected int cooldown;
    protected boolean is_cooldown = true;
    protected boolean shootable;
    protected boolean firstshoot = false;
    protected int timer = 0;

    public Plant(int x, int y){

        this.x = x;
        this.y = y;
    }

    // GETTER & SETTER
    public String getName(){

        return this.name;
    }

    public void setName(String name){

        this.name = name;
    }

    public int getCooldown(){

        return cooldown;
    }

    public int getHealth(){
        
        return health;
    }

    public void setHealth(int health){

        this.health = health;
    }

    public int getX(){

        return x;
    }

    public int getY(){

        return y;
    }

    public int getCost(){
        
        return cost;
    }

    public void setRange(int range){

         this.range = range;
     }

    public int getRange(){

         return this.range;
    }

    // METHODS
    public void attack(Zombie zombie){
        
        zombie.takeDamage(attack_damage);
    }

    public void takeDamage(int attack_damage){

        health = health - attack_damage;
    }

    public boolean isDead(){
        
        return health <= 0;
    }
    
    public abstract void instantKill(Zombie zombie);

    public void draw(Graphics2D g2){

        try {
            image = ImageIO.read(new File(fileimage));
        } catch (IOException e) {
                e.printStackTrace();
            }

        g2.drawImage(image, x, y, GamePanel.tileSize-16, GamePanel.tileSize-16, null);
    }
}