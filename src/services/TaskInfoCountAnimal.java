package services;

import entity.Organism;
import entity.OrganismType;
import entity.island.Island;
import entity.island.Location;

import java.util.HashMap;
import java.util.Map;

public class TaskInfoCountAnimal implements Runnable {

    @Override
    public void run() {

        Map<String, Integer> countAnimal = new HashMap<>();
        Location[][] location = Island.getInstance().getLocation();

        for (Location[] locations : location) {
            for (Location loc : locations) {
                for (Organism organism : loc.animalLiveCount.keySet()) {
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
