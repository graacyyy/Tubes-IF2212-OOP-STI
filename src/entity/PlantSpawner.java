package entity;

import entity.plants.Cactus;
import entity.plants.IceShroom;
import entity.plants.Jalapeno;
import entity.plants.Lilypad;
import entity.plants.SnowPea;
import entity.plants.Squash;
import entity.plants.Sunflower;
import entity.plants.TangleKelp;
import entity.plants.Wallnut;
import main.GamePanel;
// import main.GamePanel;
import entity.plants.PeaShooter;
import tile.GameMap;
public class PlantSpawner {

    int x, y, numKey;
    boolean isLilypad;

    public static void spawn (int numKey, int x, int y, boolean isLilypad){
        System.out.println("Selected Plants:");
        // for (String plant : Inventory.selectedPlants) {
        //     System.out.println(plant);
        // }
        if (isLilypad){
            if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/sunflower.png"){
                if (Sun.sun_amount >= Sunflower.getCost() ){
                    GameMap.plants.add(new Sunflower(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, Sunflower.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/cactus.png"){
                if (Sun.sun_amount >= Cactus.getCost()){
                    GameMap.plants.add(new Cactus(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, Cactus.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/iceshroom.png"){
                if (Sun.sun_amount >= IceShroom.getCost()){
                    GameMap.plants.add(new IceShroom(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, IceShroom.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/jalapeno.png"){
                if (Sun.sun_amount >= Jalapeno.getCost()){
                    GameMap.plants.add(new Jalapeno(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, Jalapeno.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/peashooter.png"){
                if (Sun.sun_amount >= PeaShooter.getCost()){
                    GameMap.plants.add(new PeaShooter(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, PeaShooter.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/snowpea.png"){
                if (Sun.sun_amount >= SnowPea.getCost()){
                    GameMap.plants.add(new SnowPea(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, SnowPea.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/squash.png"){
                if (Sun.sun_amount >= Squash.getCost()){
                    GameMap.plants.add(new Squash(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, Squash.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/wallnut.png"){
                if (Sun.sun_amount >= Wallnut.getCost()){
                    GameMap.plants.add(new Wallnut(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, Wallnut.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
        }

        else {
            if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/sunflower.png"){
                if (Sun.sun_amount >= Sunflower.getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize) ){
                    GameMap.plants.add(new Sunflower(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, Sunflower.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/cactus.png"){
                if (Sun.sun_amount >= Cactus.getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new Cactus(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, Cactus.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/iceshroom.png"){
                if (Sun.sun_amount >= IceShroom.getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new IceShroom(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, IceShroom.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/jalapeno.png"){
                if (Sun.sun_amount >= Jalapeno.getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new Jalapeno(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, Jalapeno.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/lilypad.png"){
                if (Sun.sun_amount >= Lilypad.getCost() && (y == 3*GamePanel.tileSize || y == 4*GamePanel.tileSize)){
                    GameMap.plants.add(new Lilypad(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, Lilypad.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/peashooter.png"){
                if (Sun.sun_amount >= PeaShooter.getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new PeaShooter(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, PeaShooter.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/snowpea.png"){
                if (Sun.sun_amount >= SnowPea.getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new SnowPea(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, SnowPea.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/squash.png"){
                if (Sun.sun_amount >= Squash.getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new Squash(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, Squash.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/tanglekelp.png"){
                if (Sun.sun_amount >= TangleKelp.getCost() && (y == 3*GamePanel.tileSize || y == 4*GamePanel.tileSize)){
                    GameMap.plants.add(new TangleKelp(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, TangleKelp.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/wallnut.png"){
                if (Sun.sun_amount >= Wallnut.getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new Wallnut(x, y));
                    DeckManager.deck.add(new DeckManager(numKey-1, Wallnut.getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
        }
    }

}