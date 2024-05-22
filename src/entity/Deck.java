package entity;

public class Deck {
    public static String[] deck ;

    public Deck(){

        for (int i = 0; i < Inventory.selectedPlants.size(); i++){
            for (String plant : Inventory.selectedPlants) {
                if (plant == "././res/deck/cactus.png"){
                    deck[i] = "Cactus";
                }
                else if (plant == "././res/deck/iceshroom.png"){
                    deck[i] = "Ice Shroom";
                }
                else if (plant == "././res/deck/jalapeno.png"){
                    deck[i] = "Jalapeno";
                }
                else if (plant == "././res/deck/lilypad.png"){
                    deck[i] = "Lilypad";
                }
                else if (plant == "././res/deck/peashooter.png"){
                    deck[i] = "Peashooter";
                }
                else if (plant == "././res/deck/snowpea.png"){
                    deck[i] = "Snow Pea";
                }
                else if (plant == "././res/deck/squash.png"){
                    deck[i] = "Squash";
                }
                else if (plant == "././res/deck/sunflower.png"){
                    deck[i] = "Sunflower";
                }
                else if (plant == "././res/deck/tanglekelp.png"){
                    deck[i] = "Tangle Kelp";
                }
                else if (plant == "././res/deck/wallnut.png"){
                    deck[i] = "Wallnut";
                }
            }
        }
    }

    // public boolean isEmpty(){
    //     return size == 0;
    // }

    // public boolean isFull(){
    //     return size == 6;
    // }

    public String plant(int index){
        return deck[index];
    }

    public void startRecharge(){
        
    }

    public void checkArea(){
        
    }
}
