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
import entity.plants.PeaShooter;
import tile.GameMap;

public class PlantSpawner {

    int x, y, numKey;

    public static void spawn (int numKey, int x, int y){

        if (numKey == 1){
            if (Deck.deck[0] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[0] == "Cactus"){
                GameMap.plants.add(new Cactus(x, y));
            }
            else if (Deck.deck[0] == "Ice Shroom"){
                GameMap.plants.add(new IceShroom(x, y));
            }
            else if (Deck.deck[0] == "Jalapeno"){
                GameMap.plants.add(new Jalapeno(x, y));
            }
            else if (Deck.deck[0] == "Lilypad"){
                GameMap.plants.add(new Lilypad(x, y));
            }
            else if (Deck.deck[0] == "Peashooter"){
                GameMap.plants.add(new PeaShooter(x, y));
            }
            else if (Deck.deck[0] == "Snow Pea"){
                GameMap.plants.add(new SnowPea(x, y));
            }
            else if (Deck.deck[0] == "Squash"){
                GameMap.plants.add(new Squash(x, y));
            }
            else if (Deck.deck[0] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[0] == "Tangle Kelp"){
                GameMap.plants.add(new TangleKelp(x, y));
            }
            else if (Deck.deck[0] == "Wallnut"){
                GameMap.plants.add(new Wallnut(x, y));
            }
        }
        else if (numKey == 2){
            if (Deck.deck[1] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[1] == "Cactus"){
                GameMap.plants.add(new Cactus(x, y));
            }
            else if (Deck.deck[1] == "Ice Shroom"){
                GameMap.plants.add(new IceShroom(x, y));
            }
            else if (Deck.deck[1] == "Jalapeno"){
                GameMap.plants.add(new Jalapeno(x, y));
            }
            else if (Deck.deck[1] == "Lilypad"){
                GameMap.plants.add(new Lilypad(x, y));
            }
            else if (Deck.deck[1] == "Peashooter"){
                GameMap.plants.add(new PeaShooter(x, y));
            }
            else if (Deck.deck[1] == "Snow Pea"){
                GameMap.plants.add(new SnowPea(x, y));
            }
            else if (Deck.deck[1] == "Squash"){
                GameMap.plants.add(new Squash(x, y));
            }
            else if (Deck.deck[1] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[1] == "Tangle Kelp"){
                GameMap.plants.add(new TangleKelp(x, y));
            }
            else if (Deck.deck[1] == "Wallnut"){
                GameMap.plants.add(new Wallnut(x, y));
            }
        }
        else if (numKey == 3){
            if (Deck.deck[2] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[2] == "Cactus"){
                GameMap.plants.add(new Cactus(x, y));
            }
            else if (Deck.deck[2] == "Ice Shroom"){
                GameMap.plants.add(new IceShroom(x, y));
            }
            else if (Deck.deck[2] == "Jalapeno"){
                GameMap.plants.add(new Jalapeno(x, y));
            }
            else if (Deck.deck[2] == "Lilypad"){
                GameMap.plants.add(new Lilypad(x, y));
            }
            else if (Deck.deck[2] == "Peashooter"){
                GameMap.plants.add(new PeaShooter(x, y));
            }
            else if (Deck.deck[2] == "Snow Pea"){
                GameMap.plants.add(new SnowPea(x, y));
            }
            else if (Deck.deck[2] == "Squash"){
                GameMap.plants.add(new Squash(x, y));
            }
            else if (Deck.deck[2] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[2] == "Tangle Kelp"){
                GameMap.plants.add(new TangleKelp(x, y));
            }
            else if (Deck.deck[2] == "Wallnut"){
                GameMap.plants.add(new Wallnut(x, y));
            }
        }
        else if (numKey == 4){
            if (Deck.deck[3] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[3] == "Cactus"){
                GameMap.plants.add(new Cactus(x, y));
            }
            else if (Deck.deck[3] == "Ice Shroom"){
                GameMap.plants.add(new IceShroom(x, y));
            }
            else if (Deck.deck[3] == "Jalapeno"){
                GameMap.plants.add(new Jalapeno(x, y));
            }
            else if (Deck.deck[3] == "Lilypad"){
                GameMap.plants.add(new Lilypad(x, y));
            }
            else if (Deck.deck[3] == "Peashooter"){
                GameMap.plants.add(new PeaShooter(x, y));
            }
            else if (Deck.deck[3] == "Snow Pea"){
                GameMap.plants.add(new SnowPea(x, y));
            }
            else if (Deck.deck[3] == "Squash"){
                GameMap.plants.add(new Squash(x, y));
            }
            else if (Deck.deck[3] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[3] == "Tangle Kelp"){
                GameMap.plants.add(new TangleKelp(x, y));
            }
            else if (Deck.deck[3] == "Wallnut"){
                GameMap.plants.add(new Wallnut(x, y));
            }
        }
        else if (numKey == 5){
            if (Deck.deck[4] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[4] == "Cactus"){
                GameMap.plants.add(new Cactus(x, y));
            }
            else if (Deck.deck[4] == "Ice Shroom"){
                GameMap.plants.add(new IceShroom(x, y));
            }
            else if (Deck.deck[4] == "Jalapeno"){
                GameMap.plants.add(new Jalapeno(x, y));
            }
            else if (Deck.deck[4] == "Lilypad"){
                GameMap.plants.add(new Lilypad(x, y));
            }
            else if (Deck.deck[4] == "Peashooter"){
                GameMap.plants.add(new PeaShooter(x, y));
            }
            else if (Deck.deck[4] == "Snow Pea"){
                GameMap.plants.add(new SnowPea(x, y));
            }
            else if (Deck.deck[4] == "Squash"){
                GameMap.plants.add(new Squash(x, y));
            }
            else if (Deck.deck[4] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[4] == "Tangle Kelp"){
                GameMap.plants.add(new TangleKelp(x, y));
            }
            else if (Deck.deck[4] == "Wallnut"){
                GameMap.plants.add(new Wallnut(x, y));
            }
        }
        else if (numKey == 6){
            if (Deck.deck[5] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[5] == "Cactus"){
                GameMap.plants.add(new Cactus(x, y));
            }
            else if (Deck.deck[5] == "Ice Shroom"){
                GameMap.plants.add(new IceShroom(x, y));
            }
            else if (Deck.deck[5] == "Jalapeno"){
                GameMap.plants.add(new Jalapeno(x, y));
            }
            else if (Deck.deck[5] == "Lilypad"){
                GameMap.plants.add(new Lilypad(x, y));
            }
            else if (Deck.deck[5] == "Peashooter"){
                GameMap.plants.add(new PeaShooter(x, y));
            }
            else if (Deck.deck[5] == "Snow Pea"){
                GameMap.plants.add(new SnowPea(x, y));
            }
            else if (Deck.deck[5] == "Squash"){
                GameMap.plants.add(new Squash(x, y));
            }
            else if (Deck.deck[5] == "Sunflower"){
                GameMap.plants.add(new Sunflower(x, y));
            }
            else if (Deck.deck[5] == "Tangle Kelp"){
                GameMap.plants.add(new TangleKelp(x, y));
            }
            else if (Deck.deck[5] == "Wallnut"){
                GameMap.plants.add(new Wallnut(x, y));
            }
        }
    }
}
