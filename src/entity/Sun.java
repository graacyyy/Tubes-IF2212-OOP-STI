package entity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Sun {
    
    private int sun_amount;
    private Random random;

    public Sun(){
        this.sun_amount = 25;
        this.random = new Random();
    }

    public void addSunPeriodically() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                sun_amount += 25;
                // System.out.println("Sun bertambah," + ", Sun total: " + sun_amount);
            }
        }, 5000, (random.nextInt(5000) + 5000)); // Interval waktu acak antara 5 - 10 detik
    }

    public int getSunAmount() {
        return sun_amount;
    }

    public void setSunAmount(int sunAmount) {
        this.sun_amount = sunAmount;
    }
}
