package entity.plants;

import entity.zombies.*;
// import main.GamePanel;
import tile.GameMap;

public class IceShroom extends Plant{
    
    public IceShroom(int x, int y){

        super(x, y);
        name = "Ice Shroom";
        cost = 75;
        health = 100;
        attack_damage = 200;
        attack_speed = 0;
        range = -1;
        cooldown = 20;
        is_waterplant = false;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        fileimage = "././res/plant/IceShroom.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/IceShroom.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
=======
        fileimage = "././res/plants/iceshroom.png";
>>>>>>> 99ce55be5f76d414ce047341f0f806ca01c111ab
    }

    public void freeze(Zombie zombie){
    
        zombie.setIsFreezed(true);
        zombie.setIsMoving(false);
        zombie.setFreezeTime(0);
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {
<<<<<<< HEAD
        // TODO Auto-generated method stub
<<<<<<< HEAD
<<<<<<< HEAD
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
=======
>>>>>>> origin/main
=======
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
=======
        if (timer >= 3){
            for (Zombie zombie : GameMap.zombies) {
                freeze(zombie);
                System.out.println("freeze");
            }
            health = 0;
        }   
        else timer++;
>>>>>>> 99ce55be5f76d414ce047341f0f806ca01c111ab
    }
}