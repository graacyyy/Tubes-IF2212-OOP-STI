package entity.plants;

import entity.Entity;
import entity.zombies.*;
// import game.GameMap;

public abstract class Plant extends Entity {

    protected int cost;
    protected int range;
    protected int cooldown;
    protected boolean is_waterplant;
    static boolean is_cooldown = true;

    public Plant (String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown, boolean is_waterplant){

        super(name, health, attack_damage, attack_speed);
        this.cost = cost;
        this.range = range;
        this.cooldown = cooldown;
        this.is_waterplant = is_waterplant;
    }

    // Setter dan Getter

    public void setCost(int cost){

        this.cost = cost;
    }

    public int getCost(){

        return this.cost;
    }

    public void setRange(int range){

        this.range = range;
    }

    public int getRange(){

        return this.range;
    }

    public void setCooldown(int cooldown){

        this.cooldown = cooldown;
    }

    public int getCooldown(){

        return this.cooldown;
    }

    public void setIsWaterPlant(boolean is_waterplant){

        this.is_waterplant = is_waterplant;
    }

    public boolean getIsWaterPlant(){

        return this.is_waterplant;
    }

    // Methods
    public void attack(Zombie zombie){
        // Attack


        if (!is_cooldown){
            setAS(0);
        }
        else{

        }

        // Plant tidak melakukan attack selama cooldown
        /*setAS(getAS() + 1);
        if (getAS() >= getCooldown()){
            setAS(0);
        }
        */
    }

    public boolean isDead(int health){
        return getHealth() == 0;

    }
    
    // public boolean isPlantable(){
    //     // return is_cooldown = false;
    // }
    
    public abstract void instantKill(Zombie zombie);
}    