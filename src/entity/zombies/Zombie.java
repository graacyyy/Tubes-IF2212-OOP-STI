package entity.zombies;

import entity.Entity;

public abstract class Zombie extends Entity{

    private boolean is_aquatic;
    private double speed;

    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic, double speed){
        
        super(name, health, attack_damage, attack_speed);
        this.is_aquatic = is_aquatic;
        this.speed = speed;
    }

    // Setter dan Getter

    public void setIsAquatic(boolean is_aquatic){
    
        this.is_aquatic = is_aquatic;
    }

    public boolean getIsAquatic(){

        return this.is_aquatic;
    }

    public void setSpeed(double speed){

        this.speed = speed;
    }

    public double getSpeed(){

        return this.speed;
    }

    // Methods
    public boolean isDead(){
        return getHealth() == 0;
    }

    
}
