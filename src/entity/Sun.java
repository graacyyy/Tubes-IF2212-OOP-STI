package entity;

public class Sun {
    
    protected static int sun_amount;

    public static void addsun(int amount){
        
        sun_amount += amount;   
    }

    public static void reducesun(int amount){

        sun_amount -= amount;
    }

    public static int getSunAmount(){

        return sun_amount;
    }

    public static void setSunAmount(int sunAmount){

        sun_amount = sunAmount;
    }
}
