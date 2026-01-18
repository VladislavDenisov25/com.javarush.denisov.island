package app;

import entity.Organism;
import entity.OrganismType;
import entity.island.Island;
import entity.island.Location;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class TaskInfoCountAnimal implements Runnable {
    @Override
    public void run() {
        Map<Class, Integer> countAnimal = new HashMap<>();

        for (Location location : Island.getInstance().getLocation()) {
            for (Organism organism : location.animalLiveCount.keySet()) {
                countAnimal.merge(organism.getClass(), 1, Integer::sum);
            }
        }
        for (Class eatable : countAnimal.keySet()) {
            String simpleName = eatable.getSimpleName();
            OrganismType organismType = OrganismType.valueOf(simpleName);
            System.out.printf("%s = %d ", organismType.getEmojiOrganism(), countAnimal.get(eatable));
        }
        System.out.println("S");
    }
}
