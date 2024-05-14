package entity.plants;

import entity.zombies.*;;

public class SnowPea extends Plant {

    public SnowPea(){

        super("Snow pea",175, 100, 25, 4, -1, 10, false);
    }

    public void delaySpeed(Zombie zombie){
        long startTime = System.currentTimeMillis();

        zombie.setWalkingSpeed(zombie.getWalkingSpeed()*0.5);
        zombie.setAS(zombie.getAS()*0.5);

        Thread thread = new Thread(() -> {
            try{
                long elapsedTime;
                do {
                    Thread.sleep(100);
                    elapsedTime = System.currentTimeMillis() - startTime;
                } while (elapsedTime < 3000);

                zombie.setWalkingSpeed(zombie.getWalkingSpeed()*2);
                zombie.setAS(zombie.getAS()*2);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void shootPea(){

    }
}
