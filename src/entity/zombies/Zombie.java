package entity.zombies;

import entity.Entity;

public abstract class Zombie extends Entity{

    private boolean is_aquatic;

    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic){
        
        super(name, health, attack_damage, attack_speed);
        this.is_aquatic = is_aquatic;
    }

    // Setter dan Getter

    public void setIsAquatic(boolean is_aquatic){
    
        this.is_aquatic = is_aquatic;
    }

    public boolean getIsAquatic(){

        return this.is_aquatic;
    }

    // Methods

    public boolean isDead(int health){
        
        return getHealth() == 0;
    }
}
