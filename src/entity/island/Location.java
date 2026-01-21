package entity.island;

import entity.Organism;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Location {

    public Map<Organism, Integer> animalLiveCount = new HashMap<>();
    ReentrantLock lock = new ReentrantLock(true);

    public int getCountType(Organism organism){// сколько таких типов на локации
      int countType = 0;
        for (Organism org : animalLiveCount.keySet()) {
            if (org.getClass() == organism.getClass()){
                countType++;
            }
        }
       return countType;
    }

    public void putAnimalLiveCount(Organism organism){
        animalLiveCount.put(organism, 1);
    }
    public void removeAnimalLiveCount(Organism organism){
        animalLiveCount.remove(organism);
    }

    public ReentrantLock getLock() {
        return lock;
    }
}
