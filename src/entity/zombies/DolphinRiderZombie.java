package entity.zombies;

import entity.plants.Plant;
import main.GamePanel;
import tile.GameMap;

public class DolphinRiderZombie extends Zombie {
    boolean instantKill;

    public DolphinRiderZombie(int x, int y){

        super(x,y);
        name = "Dolphin Rider Zombie";
        health = 175;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = true;
        fileimage = "././res/zombies/dolphinrider.png";
        jumped = false;
    }

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
                if (!instantKill){
                    target.setHealth(0);
                    instantKill = true;
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
