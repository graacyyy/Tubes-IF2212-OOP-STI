package entity.zombies;

import entity.plants.Plant;
import main.GamePanel;
import tile.GameMap;

public class BalloonZombie extends Zombie{

    public BalloonZombie(int x, int y){

        super(x,y);
        name = "Balloon Zombie";
        health = 200;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = false;
        fileimage = "././res/zombie/ballonzombie.png";
        jumped = false;
    }

    public void popped(){
        if (!isPopped){
            health =  (int) (health*0.5);
        }
    }

    public void actionPerformed() {
        if (isFreezed){
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
                if (plant.getX() >= x - GamePanel.tileSize && plant.getX() <= x && plant.getY() == y){
                    target = plant;
                    isMoving = false;
                }
            }
            
            if (isMoving){
                if (timer >= 6){
                    moveZombie();
                    timer = 0;
                } else{
                    timer++;
                }
                freeze_timer++;
            }else{
                if (timer >= 60){
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
                if (plant.getX() >= x - GamePanel.tileSize && plant.getX() <= x && plant.getY() == y){
                    target = plant;
                    isMoving = false;
                }
            }
    
            if (isMoving){
                if (timer >= 3){
                    moveZombie();
                    timer = 0;
                } else{
                    timer++;
                }
            }
            else{
                if (timer >= 60){
                    target.takeDamage(attack_damage);
                    timer = 0;
                }else{
                    timer++;
                }
            }
            isMoving = true;
        }

    }

}
