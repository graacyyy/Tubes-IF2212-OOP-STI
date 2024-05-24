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
import main.Inventory;
import entity.plants.PeaShooter;
import entity.plants.Plant;
import tile.GameMap;
public class PlantSpawner {

    int x, y, numKey;
    boolean isLilypad;

    public static void spawn (int numKey, int x, int y, boolean isLilypad){

        if (isLilypad){
            if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/sunflower.png"){
                if (Sun.getSunAmount() >= (new Sunflower(x,y)).getCost()){
                    Plant plant = new Sunflower(x, y);
                    plant.setHealth(plant.getHealth() + 100);
                    GameMap.plants.add(plant);
                    Sun.reducesun((new Sunflower(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new Sunflower(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                    for (int i = 0; i < GameMap.plants.size(); i++) {
                        if (GameMap.plants.get(i) instanceof Lilypad){
                            if (x == GameMap.plants.get(i).x && y == GameMap.plants.get(i).y){
                                GameMap.plants.remove(i);
                            }
                        }
                    }
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/cactus.png"){
                if (Sun.getSunAmount() >= (new Cactus(x,y)).getCost()){
                    Plant plant = new Cactus(x, y);
                    plant.setHealth(plant.getHealth() + 100);
                    GameMap.plants.add(plant);
                    Sun.reducesun((new Cactus(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new Cactus(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                    for (int i = 0; i < GameMap.plants.size(); i++) {
                        if (GameMap.plants.get(i) instanceof Lilypad){
                            if (x == GameMap.plants.get(i).x && y == GameMap.plants.get(i).y){
                                GameMap.plants.remove(i);
                            }
                        }
                    }
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/iceshroom.png"){
                if (Sun.getSunAmount() >= (new IceShroom(x,y)).getCost()){
                    Plant plant = new IceShroom(x, y);
                    plant.setHealth(plant.getHealth() + 100);
                    GameMap.plants.add(plant);
                    Sun.reducesun((new IceShroom(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new IceShroom(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                    for (int i = 0; i < GameMap.plants.size(); i++) {
                        if (GameMap.plants.get(i) instanceof Lilypad){
                            if (x == GameMap.plants.get(i).x && y == GameMap.plants.get(i).y){
                                GameMap.plants.remove(i);
                            }
                        }
                    }
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/jalapeno.png"){
                if (Sun.getSunAmount() >= (new Jalapeno(x,y)).getCost()){
                    Plant plant = new Jalapeno(x, y);
                    plant.setHealth(plant.getHealth() + 100);
                    GameMap.plants.add(plant);
                    Sun.reducesun((new Jalapeno(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new Jalapeno(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                    for (int i = 0; i < GameMap.plants.size(); i++) {
                        if (GameMap.plants.get(i) instanceof Lilypad){
                            if (x == GameMap.plants.get(i).x && y == GameMap.plants.get(i).y){
                                GameMap.plants.remove(i);
                            }
                        }
                    }
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/peashooter.png"){
                if (Sun.getSunAmount() >= (new PeaShooter(x,y)).getCost()){
                    Plant plant = new PeaShooter(x, y);
                    plant.setHealth(plant.getHealth() + 100);
                    GameMap.plants.add(plant);
                    Sun.reducesun((new PeaShooter(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new PeaShooter(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                    for (int i = 0; i < GameMap.plants.size(); i++) {
                        if (GameMap.plants.get(i) instanceof Lilypad){
                            if (x == GameMap.plants.get(i).x && y == GameMap.plants.get(i).y){
                                GameMap.plants.remove(i);
                            }
                        }
                    }
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/snowpea.png"){
                if (Sun.getSunAmount() >= (new SnowPea(x,y)).getCost()){
                    Plant plant = new SnowPea(x, y);
                    plant.setHealth(plant.getHealth() + 100);
                    GameMap.plants.add(plant);
                    Sun.reducesun((new SnowPea(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new SnowPea(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                    for (int i = 0; i < GameMap.plants.size(); i++) {
                        if (GameMap.plants.get(i) instanceof Lilypad){
                            if (x == GameMap.plants.get(i).x && y == GameMap.plants.get(i).y){
                                GameMap.plants.remove(i);
                            }
                        }
                    }
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/squash.png"){
                if (Sun.getSunAmount() >= (new Squash(x,y)).getCost()){
                    Plant plant = new Squash(x, y);
                    plant.setHealth(plant.getHealth() + 100);
                    GameMap.plants.add(plant);
                    Sun.reducesun((new Squash(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new Squash(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                    for (int i = 0; i < GameMap.plants.size(); i++) {
                        if (GameMap.plants.get(i) instanceof Lilypad){
                            if (x == GameMap.plants.get(i).x && y == GameMap.plants.get(i).y){
                                GameMap.plants.remove(i);
                            }
                        }
                    }
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/wallnut.png"){
                if (Sun.getSunAmount() >= (new Wallnut(x,y)).getCost()){
                    Plant plant = new Wallnut(x, y);
                    plant.setHealth(plant.getHealth() + 100);
                    GameMap.plants.add(plant);
                    Sun.reducesun((new Wallnut(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new Wallnut(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                    for (int i = 0; i < GameMap.plants.size(); i++) {
                        if (GameMap.plants.get(i) instanceof Lilypad){
                            if (x == GameMap.plants.get(i).x && y == GameMap.plants.get(i).y){
                                GameMap.plants.remove(i);
                            }
                        }
                    }
                }
            }
        }

        else {
            if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/sunflower.png"){
                if (Sun.getSunAmount() >= (new Sunflower(x, y)).getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize) ){
                    GameMap.plants.add(new Sunflower(x, y));
                    Sun.reducesun((new Sunflower(x, y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new Sunflower(x, y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/cactus.png"){
                if (Sun.getSunAmount() >= (new Cactus(x,y)).getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    System.out.println(Sun.getSunAmount() + " " + (new Cactus(x,y)).getCost());
                    System.out.println("cukup");
                    GameMap.plants.add(new Cactus(x, y));
                    Sun.reducesun((new Cactus(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new Cactus(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/iceshroom.png"){
                if (Sun.getSunAmount() >= (new IceShroom(x,y)).getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new IceShroom(x, y));
                    Sun.reducesun((new IceShroom(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new IceShroom(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/jalapeno.png"){
                if (Sun.getSunAmount() >= (new Jalapeno(x,y)).getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add((new Jalapeno(x,y)));
                    Sun.reducesun((new Jalapeno(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new Jalapeno(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/lilypad.png"){
                if (Sun.getSunAmount() >= (new Lilypad(x,y)).getCost() && (y == 3*GamePanel.tileSize || y == 4*GamePanel.tileSize)){
                    GameMap.plants.add(new Lilypad(x, y));
                    Sun.reducesun((new Lilypad(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new Lilypad(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/peashooter.png"){
                if (Sun.getSunAmount() >= (new PeaShooter(x,y)).getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new PeaShooter(x, y));
                    Sun.reducesun((new PeaShooter(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new PeaShooter(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/snowpea.png"){
                if (Sun.getSunAmount() >= (new SnowPea(x,y)).getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new SnowPea(x, y));
                    Sun.reducesun((new SnowPea(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new SnowPea(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/squash.png"){
                if (Sun.getSunAmount() >= (new Squash(x,y)).getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new Squash(x, y));
                    Sun.reducesun((new Squash(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new Squash(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/tanglekelp.png"){
                if (Sun.getSunAmount() >= (new TangleKelp(x,y)).getCost() && (y == 3*GamePanel.tileSize || y == 4*GamePanel.tileSize)){
                    GameMap.plants.add(new TangleKelp(x, y));
                    Sun.reducesun((new TangleKelp(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new TangleKelp(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
            else if (Inventory.selectedPlants.get(numKey-1) == "././res/deck/wallnut.png"){
                if (Sun.getSunAmount() >= (new Wallnut(x,y)).getCost() && (y != 3*GamePanel.tileSize && y != 4*GamePanel.tileSize)){
                    GameMap.plants.add(new Wallnut(x, y));
                    Sun.reducesun((new Wallnut(x,y)).getCost());
                    DeckManager.deck.add(new DeckManager(numKey-1, (new Wallnut(x,y)).getCooldown(), Inventory.selectedPlants.get(numKey-1)));
                    Inventory.selectedPlants.remove(numKey-1);
                    Inventory.selectedPlants.add(numKey-1, null);
                }
            }
        }
    }
}