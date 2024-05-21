package entity.zombies;

import entity.plants.Plant;
import main.GamePanel;
import tile.GameMap;

public class PoleVaulting extends Zombie {

    public PoleVaulting(int x, int y){

        super(x,y);
        name = "Pole Vaulting Zombie";
        health = 175;
        attack_damage = 100;
        attack_speed = 1;
        is_aquatic = false;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        fileimage = "././res/zombie/PoleVaulZombie/PoleVaultZombie_1.png";
=======
        fileimage = "././res/zombie/PoleVaultZombie/PoleVaultZombie_1.png";
>>>>>>> origin/main
=======
        fileimage = "././res/zombie/PoleVaultZombie/PoleVaultZombie_1.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
=======
        fileimage = "././res/zombies/polevault.png";
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
            }
            else{
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
            else if(isSlowed){
            for (Plant plant : GameMap.plants){
                if (plant.getX() >= x - GamePanel.tileSize && plant.getX() <= x && plant.getY() == y){
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
                if (timer >= 60){
                    target.takeDamage(attack_damage);
                    timer = 0;
                }else{
                    timer++;
                }
                isMoving = true;
            }
        }
            else{
                if (timer >= 60){
                    target.takeDamage(attack_damage);
                    timer = 0;
                }else{
                    timer++;
                }
                isMoving = true;
            }
        }
>>>>>>> 99ce55be5f76d414ce047341f0f806ca01c111ab
    }
}
