package entity.plants;

import entity.Entity;

public abstract class Plant extends Entity {

    private int cost;
    private int range;
    private int cooldown;
    private boolean is_waterplant;

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
    
}
