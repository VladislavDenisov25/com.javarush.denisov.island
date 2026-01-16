package app;

import entity.Eatable;
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
            for (Eatable eatable : location.animalLiveCount.keySet()) {
                countAnimal.merge(eatable.getClass(), 1, Integer::sum);
            }
        }
        for (Class eatable : countAnimal.keySet()) {
            try {
                Class<?> aClass = Class.forName(eatable.getName());
                Eatable eatable1 = (Eatable) aClass.getDeclaredConstructor().newInstance();
                System.out.printf("%s = %d ", eatable1.getEmoji(), countAnimal.get(eatable));
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
                     | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
}
