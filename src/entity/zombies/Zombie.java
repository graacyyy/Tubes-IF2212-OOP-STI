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

public class Zombie extends Entity implements CustomListener{

    protected boolean is_aquatic;
    protected boolean isMoving = true;
    protected boolean isSlowed = false;

    public Zombie(int x, int y){ 
<<<<<<< HEAD
        
<<<<<<< HEAD
        super(name, health, attack_damage, attack_speed);
        this.is_aquatic = is_aquatic;
        this.walking_speed = walking_speed;
=======
        this.x = x;
        this.y = y;

        this.solidArea = new Rectangle();
        this.solidArea.x = x;
        this.solidArea.y = y;
        this.solidArea.width = 48;
        this.solidArea.height = 48;

        // setDefaultValues();
        // getZombieImage();
>>>>>>> 955d6d875befc0e87d6f9e1c6654bc5b89b57ba7
    }

    // GETTER SETTER
    public void setHealth(int health){
        
        this.health = health;
    }

    public int getHealth(){
        
        return health;
    }

=======
        this.x = x;
        this.y = y;

        this.solidArea = new Rectangle();
        this.solidArea.x = x;
        this.solidArea.y = y;
        this.solidArea.width = 48;
        this.solidArea.height = 48;

        // setDefaultValues();
        // getZombieImage();
    }

    // GETTER SETTER
    public void setHealth(int health){
        
        this.health = health;
    }

    public int getHealth(){
        
        return health;
    }

>>>>>>> origin/main
    public void setIsMoving(boolean isMoving){
            
            this.isMoving = isMoving;
    }

    public void setIsSlowed(boolean isSlowed){
        
        this.isSlowed = isSlowed;
    }
    
    public int getX(){

        return x;
    }

    public int getY(){

        return y;
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

    public void attack(Plant plant){
        
        plant.takeDamage(attack_damage);
    }

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

    public void moveZombie(){
        x--;
        solidArea.x = x;
    }

    public void draw(Graphics2D g2){
        try {
            image = ImageIO.read(new File(fileimage));
        } catch (IOException e) {
<<<<<<< HEAD
            e.printStackTrace();
=======
>>>>>>> origin/main
        }
        
        g2.drawImage(image, x, y, GamePanel.tileSize, GamePanel.tileSize, null);
    }

    @Override
    public void actionPerformed() {
        moveZombie();
    }
}