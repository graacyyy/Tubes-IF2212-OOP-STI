package entity.plants;

import entity.zombies.*;

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
=======
        fileimage = "././res/plant/IceShroom.png";
>>>>>>> origin/main
=======
        fileimage = "././res/plant/IceShroom.png";
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
    }

    public void freeze(Zombie zombie){
    
        zombie.setIsMoving(false);
    }

    @Override
    public void instantKill(Zombie zombie) {}

    @Override
    public void actionPerformed() {
        // TODO Auto-generated method stub
<<<<<<< HEAD
<<<<<<< HEAD
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
=======
>>>>>>> origin/main
=======
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
    }
}