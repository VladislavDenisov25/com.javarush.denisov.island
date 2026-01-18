package entity;

import entity.island.Island;
import entity.island.Location;
import util.Random;

public interface Organism {

    Location[] location = Island.getInstance().getLocation();

   static void setEatableLocation(Organism type) { // нужно делать проверку на уже имеющееся кол-во животных или растений и вообще метод тут???
        int index = Random.getRandomCount(location.length);
        location[index].animalLiveCount.put(type, 1);
    }

}
