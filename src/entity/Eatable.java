package entity;

import entity.herbivore.*;
import entity.island.Island;
import entity.island.Location;
import entity.predator.*;
import util.Random;

import java.util.concurrent.ThreadLocalRandom;

public interface Eatable {

    Location[] location = Island.getInstance().getLocation();
    String emoji = "";


    String getEmoji();

    static void setEatableLocation(Eatable eatable) {
        int index = Random.getRandomCount(location.length);
        location[index].animalLiveCount.put(eatable, 1);
    }

}
