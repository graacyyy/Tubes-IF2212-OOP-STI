package entity.zombies;

import entity.Entity;

public abstract class Zombie extends Entity{

    private boolean is_aquatic;
    private double walking_speed;

    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic, double walking_speed){
        
        // super(name, health, attack_damage, attack_speed);
        super(name, health, attack_damage, attack_speed);
        this.is_aquatic = is_aquatic;
        this.walking_speed = walking_speed;
    }

    // Setter dan Getter

    public void setIsAquatic(boolean is_aquatic){
    
        this.is_aquatic = is_aquatic;
    }

    public boolean getIsAquatic(){

        return this.is_aquatic;
    }

    public void setWalkingSpeed(double walking_speed){

        this.walking_speed = walking_speed;
    }

    public double getWalkingSpeed(){

        return this.walking_speed;
    }

    // Methods
     public void takeDamage(int attack_damage){
        setHealth(getHealth()-attack_damage);
    }
    
    public boolean isDead(){
        return getHealth() <= 0;
    }

    
}
