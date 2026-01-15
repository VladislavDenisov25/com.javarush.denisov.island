package entity;

import entity.herbivore.*;
import entity.island.Island;
import entity.island.Location;
import entity.predator.*;

import java.util.Random;

public abstract class Animal implements Eatable {

    public Location[] location = Island.getInstance().getLocation();

    @Override
    public Eatable createEatable(Eatable eatable){
        return switch (eatable.getClass().getSimpleName()){
            case "Wolf" -> new Wolf();
            case "Fox" -> new Fox();
            case "Eagle" -> new Eagle();
            case "Boa" -> new Boa();
            case "Bear" -> new Bear();
            case "Sheep" -> new Sheep();
            case "Rabbit" -> new Rabbit();
            case "Mouse" -> new Mouse();
            case "Horse" -> new Horse();
            case "Duck" -> new Duck();
            case "Goat" -> new Goat();
            case "Deer" -> new Deer();
            case "Caterpillar" -> new Caterpillar();
            case "Buffalo" -> new Buffalo();
            case "Boar" -> new Boar();
            case "Plant" -> new Plant();
            default -> throw new IllegalStateException("Unexpected value: " + eatable.getClass().getSimpleName());
        };
    }

    public void setEatableLocation(Eatable eatable){
        Random randomLocation = new Random(location.length);
        location[randomLocation.nextInt()].animalLiveCount.put(eatable, 1);
    }
    double weigth = 0.0d;

    void eat(Eatable e) {}

    void move(Location l) {

    }

    void multiply() {

    }

    void die() {

    }
}
