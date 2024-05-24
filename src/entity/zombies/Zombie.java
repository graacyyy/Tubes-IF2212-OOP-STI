package entity.zombies;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.Graphics2D;

import entity.Entity;
import entity.plants.Plant;
import main.CustomListener;
import main.GamePanel;
import tile.GameMap;

public class Zombie extends Entity implements CustomListener{
    
    protected boolean is_aquatic;
    protected boolean isMoving = true;
    protected boolean isSlowed = false;
    protected boolean isFreezed = false;
    protected boolean isPopped = false;
    protected boolean firstDamage = false;

    protected int timer = 0;
    protected int freeze_timer = 0;
    protected int delay_timer = 0;
    protected Plant target = null;

    public Zombie(int x, int y){ 
      
        this.x = x;
        this.y = y;
    }

    // GETTER & SETTER
    public void setHealth(int health){
        
        this.health = health;
    }

    public int getHealth(){
        
        return health;
    }

    public void setIsMoving(boolean isMoving){
            
            this.isMoving = isMoving;
    }

    public void setIsSlowed(boolean isSlowed){
        
        this.isSlowed = isSlowed;
    }
    
    public void setIsFreezed(boolean isFreezed){
        
        this.isFreezed = isFreezed;
    }
    
    public void setFreezeTime(int time){

        freeze_timer = time;
    }

    public int getX(){

        return x;
    }

    public int getY(){

        return y;
    }
    
    // METHODs
    public void takeDamage(int attack_damage){
        
        health = health - attack_damage;
    }

    public boolean isDead(){
        
        return health <= 0;
    }

    public void moveZombie(){

        x--;
    }

    public void draw(Graphics2D g2){

        try {
            image = ImageIO.read(new File(fileimage));
        } catch (IOException e) {}
        
        g2.drawImage(image, x, y-20, GamePanel.tileSize+10, GamePanel.tileSize+10, null);
    }

    @Override
    public void actionPerformed() {

        if (isFreezed){
            System.out.println("test");
            if (freeze_timer >= 120){
                isFreezed = false;
                freeze_timer = 0;
                isMoving = true;
            }
            else {
                freeze_timer++;
            }
        }
        else if(isSlowed){
            for (Plant plant : GameMap.plants){
                if (plant.getX() >= x - GamePanel.tileSize+30 && plant.getX() <= x && plant.getY() == y){
                    target = plant;
                    isMoving = false;
                }
            }
            
            if (isMoving){
                if (timer >= 20){
                    moveZombie();
                    timer = 0;
                } else{
                    timer++;
                }
                freeze_timer++;
            }else{
                if (!firstDamage){
                    target.takeDamage(attack_damage);
                    firstDamage = true;
                }
                else{
                    if (timer >= 60*attack_speed){
                        target.takeDamage(attack_damage);
                        timer = 0;
                    }else{
                        timer++;
                    }
                }
                isMoving = true;
                freeze_timer++;
            }

            if(freeze_timer>=180){
                freeze_timer=0;
                isSlowed=false;
            }
        }
        else{
            for (Plant plant : GameMap.plants){
                if (plant.getX() >= x - GamePanel.tileSize+30 && plant.getX() <= x && plant.getY() == y){
                    target = plant;
                    isMoving = false;
                }
            }
    
            if (isMoving){
                if (timer >= 10){
                    moveZombie();
                    timer = 0;
                } else{
                    timer++;
                }
            }else{
                if (!firstDamage){
                    target.takeDamage(attack_damage);
                    firstDamage = true;
                }
                else{
                    if (timer >= 60*attack_speed){
                        target.takeDamage(attack_damage);
                        timer = 0;
                    }else{
                        timer++;
                    }
                }
            }
            isMoving = true;
        }
    }
}