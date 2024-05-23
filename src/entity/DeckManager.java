package entity;

import java.util.ArrayList;

import main.CustomListener;

public class DeckManager implements CustomListener{
    protected int index;
    protected int timer, cooldown;
    protected String plant;
    protected boolean isReady = false;
    public static ArrayList<DeckManager> deck = new ArrayList<DeckManager>();

    public DeckManager(int index, int cooldown, String plant) {
        this.index = index;
        this.cooldown = cooldown;
        this.plant = plant;
    }

    public boolean isReady() {
        return isReady;
    }

    @Override
    public void actionPerformed() {
        if (timer >= 60*cooldown) {
            isReady = true;
            Inventory.selectedPlants.remove(index);
            Inventory.selectedPlants.add(index, plant);
            timer = 0;
        }
        else {
            timer++;
        }
    }
}
