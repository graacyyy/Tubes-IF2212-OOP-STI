package entity;

public class Entity {
    private String name;
    private int health;
    private int attack_damage;
    private double attack_speed;

    public Entity (String name, int health, int attack_damage, double attack_speed){

        this.name = name;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
    }

    // Setter dan Getter 

    public void setName(String name){
        
        this.name = name;
    }

    public String getName(){
        
        return this.name;
    }

    public void setHealth(int health){
        
        this.health = health;
    }

    public int getHealth(){
        
        return this.health;
    }

    public void setAD(int attack_damage){
        
        this.attack_damage = attack_damage;
    }

    public int getAD(){
        
        return this.attack_damage;
    }

    public void setAS(double attack_speed){
        
        this.attack_speed = attack_speed;
    }

    public double getAS(){
        
        return this.attack_speed;
    }

}