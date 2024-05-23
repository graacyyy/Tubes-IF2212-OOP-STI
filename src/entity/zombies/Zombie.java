package entity.zombies;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.IOException;
import java.awt.Rectangle;

// import javax.imageio.ImageIO;

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
    protected boolean jumped;

    int timer = 0;
    int freeze_timer = 0;
    int delay_timer = 0;
    protected Plant target = null;

    public Zombie(int x, int y){ 
      
        this.x = x;
        this.y = y;

        this.solidArea = new Rectangle();
        this.solidArea.x = x;
        this.solidArea.y = y;
        this.solidArea.width = 48;
        this.solidArea.height = 48;
    }

    // GETTER SETTER
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
    
    public int getX(){

        return x;
    }

    public int getY(){

        return y;
    }
    
    public void setFreezeTime(int time){
        freeze_timer = time;
    }

    // public void setIsAquatic(boolean is_aquatic){
    
    //     this.is_aquatic = is_aquatic;
    // }

    // public boolean getIsAquatic(){

    //     return this.is_aquatic;
    // }

    // public void setWalkingSpeed(double walking_speed){

    //     this.walking_speed = walking_speed;
    // }

    // public double getWalkingSpeed(){

    //     return this.walking_speed;
    // }

    // METHOD
    public void takeDamage(int attack_damage){
        
        health = health - attack_damage;
    }

    public boolean isDead(){
        
        return health <= 0;
    }

    //public void attack(Plant plant){
        
    //    plant.takeDamage(attack_damage);
    //}

    // public void setDefaultValues(){

    //     // x = 10*GamePanel.tileSize;
    //     y = 0*GamePanel.tileSize;
    //     // speed = 0.0001;
    //     // distanceToMove = speed*(1.0/60);
    // }    

    // public void getZombieImage(){
        
    //     zombie1 = setup("orc_left_1");
    //     zombie2 = setup("orc_left_2");
    // }

    // public BufferedImage setup(String imageName){
        
    //     BufferedImage image = null;

    //     try {
    //         image = ImageIO.read(new File("././res/zombie/" + imageName + ".png"));
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     return image;

    // }

    // public void move(){

    //     if (x > 0){
    //         x --;
    //     }

    //     spriteCounter++;
    //     if (spriteCounter > 30){
    //         if(spriteNum == 1){
    //             spriteNum = 2;
    //         }
    //         else if (spriteNum == 2){
    //             spriteNum = 1;
    //         }
    //         spriteCounter = 0;
    //     }
    // }

    // public void draw(Graphics2D g2){

    //     BufferedImage image = null;

    //     if (spriteNum == 1){
    //         image = zombie1;
    //     }
    //     else if (spriteNum == 2){
    //         image = zombie2;
    //     }

    //     g2.drawImage(image, x, y, GamePanel.tileSize, GamePanel.tileSize, null);
    // }

    //public void hit(Plant plant){

    //    plant.takeDamage(attack_damage);
    //}

    public void moveZombie(){
        if(jumped){
            for (Plant plant : GameMap.plants) {
                if (plant.getX() >= x - GamePanel.tileSize && plant.getX() <= x && plant.getY() == y){
                    x -= GamePanel.tileSize;
                    plant.setHealth(0);
                }
            }
        }
        else{
            x--;
        }
        // solidArea.x = x;
    }

    public void draw(Graphics2D g2){
        try {
            image = ImageIO.read(new File(fileimage));
        } catch (IOException e) {
        }
        
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
                if (timer >= 60*attack_speed){
                    target.takeDamage(attack_damage);
                    timer = 0;
                }else{
                    timer++;
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
                if (timer >= 60*attack_speed){
                    target.takeDamage(attack_damage);
                    timer = 0;
                }else{
                    timer++;
                }
                isMoving = true;
            }
        }
    }
}