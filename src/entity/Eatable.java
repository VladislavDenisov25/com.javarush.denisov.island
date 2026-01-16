package entity;

import entity.herbivore.*;
import entity.island.Island;
import entity.island.Location;
import entity.predator.*;

import java.util.concurrent.ThreadLocalRandom;

public interface Eatable {

    Location[] location = Island.getInstance().getLocation();
    String emoji = "";

    static Eatable createEatable(Eatable eatable){
        return switch (eatable.getClass().getSimpleName()) {
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

    String getEmoji();

    static void setEatableLocation(Eatable eatable){
        int randomLocation = ThreadLocalRandom.current().nextInt(location.length);
        location[randomLocation].animalLiveCount.put(eatable, 1);
    }
}
