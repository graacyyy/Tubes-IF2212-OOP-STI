package entity.plants;

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
import entity.zombies.Zombie;
import main.CustomListener;
import main.GamePanel;

public abstract class Plant extends Entity implements CustomListener{
    protected int cost;
    protected int range;
    protected int cooldown;
    protected boolean is_waterplant;
    protected static boolean is_cooldown = true;

    public Plant(int x, int y){

        this.x = x;
        this.y = y;

        this.solidArea = new Rectangle();
        this.solidArea.x = x;
        this.solidArea.y = y;
        this.solidArea.width = 64;
        this.solidArea.height = 64;

        // setDefaultValues();
        // getPlantImage();
    }

    // GETTER SETTER

    public void setCooldown(int cooldown){

        this.cooldown = cooldown;
    }

    public int getCooldown(){

        return cooldown;
    }

    public int getHealth(){
        
        return health;
    }

    public int getX(){

        return x;
    }

    public int getY(){

        return y;
    }
    // public void setCost(int cost){

    //     this.cost = cost;
    // }

    // public int getCost(){

    //     return this.cost;
    // }

    // public void setRange(int range){

    //     this.range = range;
    // }

    // public int getRange(){

    //     return this.range;
    // }


    // public void setIsWaterPlant(boolean is_waterplant){

    //     this.is_waterplant = is_waterplant;
    // }

    // public boolean getIsWaterPlant(){

    //     return this.is_waterplant;
    // }

    // METHODS
    public void attack(Zombie zombie){
        
        zombie.takeDamage(attack_damage);
    }

    public void takeDamage(int attack_damage){

        health = health - attack_damage;
    }

    public boolean isDead(int health){
        
        return health <= 0;
    }
    
    // public boolean isPlantable(){
    //     return is_cooldown = false;
    // }
    
    public abstract void instantKill(Zombie zombie);

    // DRAW OBJECT
    // public void setDefaultValues(){
        
    //     // x = 2*GamePanel.tileSize;
    //     // y = 1*GamePanel.tileSize;
    // }

//     public void getPlantImage(){

//         plant1 = setup("peashooter_0");
//         plant2 = setup("peashooter_1");
//         plant3 = setup("peashooter_2");
//         plant4 = setup("peashooter_3");
//         plant5 = setup("peashooter_4");
//         plant6 = setup("peashooter_5");
//         plant7 = setup("peashooter_6");
//         // plant8 = setup("peashooter_7");
//         // plant9 = setup("peashooter_8");
//         // plant10 = setup("peashooter_9");
//         // plant11 = setup("peashooter_10");
//         // plant12 = setup("peashooter_11");
//         // plant13 = setup("peashooter_12");
//     }

//     public BufferedImage setup(String imageName){
        
//         BufferedImage image = null;

//         try {
//             image = ImageIO.read(new File("././res/plant/" + imageName + ".png"));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         return image;
//     }

//     public void update(){

//         spriteCounter++;
//         if (spriteCounter > 7){

//             int total = 7;

//             for (int i = 1; i <= total; i++) {
//                 if (spriteNum == i) {
//                     if (i == total) {
//                         spriteNum = 1;
//                     } else {
//                         spriteNum = i + 1;
//                     }
//                     break;
//                 }
//             }

//             spriteCounter = 0;
//         }
//     }

//     public void draw(Graphics2D g2){

//         BufferedImage image = null;

//         if (spriteNum == 1){
//             image = plant1;
//         }
//         else if (spriteNum == 2){
//             image = plant2;
//         }
//         else if (spriteNum == 3){
//             image = plant3;
//         }
//         else if (spriteNum == 4){
//             image = plant4;
//         }
//         else if (spriteNum == 5){
//             image = plant5;
//         }
//         else if (spriteNum == 6){
//             image = plant6;
//         }
//         else if (spriteNum == 7){
//             image = plant7;
//         }
//         // else if (spriteNum == 8){
//         //     image = plant8;
//         // }
//         // else if (spriteNum == 9){
//         //     image = plant9;
//         // }
//         // else if (spriteNum == 10){
//         //     image = plant10;
//         // }
//         // else if (spriteNum == 11){
//         //     image = plant11;
//         // }
//         // else if (spriteNum == 12){
//         //     image = plant12;
//         // }
//         // else if (spriteNum == 13){
//         //     image = plant13;
//         // }

//         g2.drawImage(image, x, y, GamePanel.tileSize, GamePanel.tileSize, null);
//     }

    public void draw(Graphics2D g2){

        try {
            image = ImageIO.read(new File(fileimage));
        } catch (IOException e) {
                e.printStackTrace();
            }

        g2.drawImage(image, x, y, GamePanel.tileSize, GamePanel.tileSize, null);
    }
}