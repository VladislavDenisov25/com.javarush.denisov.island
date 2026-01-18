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
        for (Class aClass : countAnimal.keySet()) {
            String upperCase = aClass.getSimpleName().toUpperCase();
            OrganismType type = OrganismType.valueOf(upperCase);
            System.out.printf("%s = %d ", type.getEmojiOrganism(), countAnimal.get(aClass));
        }
        System.out.println();
    }
}
