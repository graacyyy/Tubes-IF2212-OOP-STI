package entity;

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
}
