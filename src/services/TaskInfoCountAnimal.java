package services;

import entity.Organism;
import entity.OrganismType;
import entity.island.Island;
import entity.island.Location;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class TaskInfoCountAnimal implements Runnable {

    @Override
    public void run() {

            Map<String, Integer> countAnimal = new HashMap<>();
            Location[][] location = Island.getInstance().getLocation();

            for (int x = 0; x < location.length; x++) {
                for (int y = 0; y < location[x].length; y++) {
                    for (Organism organism : location[x][y].animalLiveCount.keySet()) {
                        countAnimal.merge(organism.getClass().getSimpleName(), 1, Integer::sum);
                    }
                }
            }
            for (String typeName : countAnimal.keySet()) {
                OrganismType type = OrganismType.valueOf(typeName.toUpperCase());
                System.out.printf("%s = %d ", type.getEmojiOrganism(), countAnimal.get(typeName));
            }
            System.out.println();
    }
}
