package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    
    public int x, y, positionx, positiony;
    public double speed;
    public double distanceToMove;
    
    public BufferedImage image;
    public String fileimage;
    // public BufferedImage zombie1, zombie2, zombie3, zombie4, zombie5, zombie6, plant1, plant2, plant3, plant4, plant5, plant6, plant7;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    protected String name;
    protected int health;
    protected int attack_damage;
    protected double attack_speed;

<<<<<<< HEAD
    // Setter dan Getter 

    public void setName(String name){
        
        this.name = name;
    }

    public String getName(){
        
        return this.name;
    }

    public void setHealth(int health){
        
        this.health = health;
    }

    public int getHealth(){
        
        return this.health;
    }

    public void setAD(int attack_damage){
        
        this.attack_damage = attack_damage;
    }

    public int getAD(){
        
        return this.attack_damage;
    }

    public void setAS(double attack_speed){
        
        this.attack_speed = attack_speed;
    }

    public double getAS(){
        
        return this.attack_speed;
    }

}
=======
    public Rectangle solidArea;
}
>>>>>>> 955d6d875befc0e87d6f9e1c6654bc5b89b57ba7
