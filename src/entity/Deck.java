package entity;

import entity.plants.Plant;

public class Deck {
    private Plant[] deck;
    public int size;
    public boolean recharged; 

    public Deck(Plant[] deck, boolean recharged){
        this.deck = new Plant[6];
        size = 0;
        this.recharged = recharged;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == 6;
    }

    public int indexOf(Plant plant){
        for (int i = 0; i < size; i++){
            if (deck[i] == plant){
                return i;
            }
        } return -1;
    }

    public void addPlant(Plant plant){
        if (!isFull()) {
            deck[size] = plant;
            size ++;
        }
    }

    public void removePlant(Plant plant){
        int index = indexOf(plant);
        if (index >= 0) {
            for (int i = index; i < size - 1; i++) {
                deck[i] = deck[i + 1];
            }
            size--;
        }
    }

    public void swapPlant(Plant plantA, Plant plantB){
        int index1 = indexOf(plantA);
        int index2 = indexOf(plantB);

        if (index1 >= 0 && index2 >= 0){
            Plant temp = deck[index1];
            deck[index1] = deck[index2];
            deck[index2] = temp;
        }
    }

    public void startRecharge(){
        
    }

    public void checkArea(){
<<<<<<< HEAD
<<<<<<< HEAD
        if 
=======
        
>>>>>>> origin/main
=======
        
>>>>>>> aa491725be7e0cc5fdf981fd0cb8a0f29146f91e
    }
}
