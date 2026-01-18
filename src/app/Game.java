package app;

import entity.Eatable;
import entity.herbivore.*;
import entity.island.*;
import entity.predator.*;
import util.Random;
import util.Settings;


import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {

    public void start() {

        for (int i = 0; i < 10; i++) {
            Location.newLocation();
        }

        ScheduledThreadPoolExecutor executorCreatePlant = new ScheduledThreadPoolExecutor(1);
        executorCreatePlant.scheduleAtFixedRate(new TaskCreatePlant(), 0, 1, TimeUnit.SECONDS);
        ScheduledThreadPoolExecutor executorInfoCountAnimal = new ScheduledThreadPoolExecutor(3);
        executorInfoCountAnimal.scheduleAtFixedRate(new TaskInfoCountAnimal(), 1, 10, TimeUnit.SECONDS);

    }
    public void createEatable(Eatable eatable){
        int countEatable = Random.getRandomCount(Settings.minCreatCountAnimal, Settings.animalMaxCount.get(eatable.getClass()));
        for (int i = 0; i < countEatable; i++) {
           Eatable.setEatableLocation(FactoryCreateEatable.createEatable(eatable));
        }

    }
}
