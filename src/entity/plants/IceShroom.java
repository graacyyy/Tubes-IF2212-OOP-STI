package entity.plants;

import entity.zombies.*;

public class IceShroom extends Plant{
    
    public IceShroom(){
        super("Ice Shroom", 75,100,200,0,-1,20,false);
    }

    public void freeze(Zombie zombie){
        // freeze selama 5 detik
        long startTime = System.currentTimeMillis();

        synchronized (zombie){
            zombie.setSpeed(0);
        }
        
        Thread thread = new Thread(() -> {
            try{
                long elapsedTime;
                do{
                Thread.sleep(100);
                elapsedTime = System.currentTimeMillis() - startTime;
            } while (elapsedTime < 5000);

            synchronized (zombie){
                zombie.setSpeed(zombie.getSpeed());
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        });
        thread.start();
    }
}