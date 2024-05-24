package entity.plants;

import entity.zombies.*;

import tile.GameMap;

public class PeaShooter extends Plant {

    protected int timer = 0;

    public PeaShooter(int x, int y) {

        super(x, y);
        name = "Pea Shooter";
        cost = 100;
        health = 100;
        attack_damage = 25;
        attack_speed = 4;
        range = -1;
        cooldown = 10;
        fileimage = "././res/plants/peashooter.png";
    }

    // METHODS
    public void shootPea(){

        PeaBullet bullet = new PeaBullet(x, y, attack_damage);
        GameMap.bullets.add(bullet);
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {

        shootable = true;
        if (!firstshoot){
            for (Zombie zombie : GameMap.zombies) {
                if (zombie.getY() == y){
                    if (shootable){
                        shootPea();
                        shootable = false;
                        firstshoot = true;
                    }
                }
            }
        }
        else{
            if (timer >= 60*attack_speed){
                for (Zombie zombie : GameMap.zombies) {
                    if (zombie.getY() == y){
                        if (shootable){
                            shootPea();
                            shootable = false;
                            timer = 0;
                        }
                    }
                }
            }
            else {
                timer++;
            }
        }
    }
}
