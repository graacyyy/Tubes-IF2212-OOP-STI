package entity;

public class Sun {
    
    protected static int sun_amount;

    public Sun(){
        sun_amount = 50;
    }

    public static void addsun(int amount){

        sun_amount += amount;   
    }

    public static void reducesun(int amount){

        sun_amount -= amount;
    }
    // public void addSunPeriodically() {
    //     new Timer().scheduleAtFixedRate(new TimerTask() {
    //         @Override
    //         public void run() {
    //             sun_amount += 25;
    //             // System.out.println("Sun bertambah," + ", Sun total: " + sun_amount);
    //         }
    //     }, 5000, (random.nextInt(5000) + 5000)); // Interval waktu acak antara 5 - 10 detik
    // }

    public static int getSunAmount() {
        return sun_amount;
    }

    public void setSunAmount(int sunAmount) {
        sun_amount = sunAmount;
    }
}
