package app;

import entity.Eatable;
import entity.EatableType;
import entity.island.*;


import util.Random;
import util.Settings;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {

    public void start() {

        for (int i = 0; i < 10; i++) {
            Location.newLocation();
        }
       init();
        ScheduledThreadPoolExecutor executorCreatePlant = new ScheduledThreadPoolExecutor(1);
        executorCreatePlant.scheduleAtFixedRate(new TaskCreatePlant(), 0, 1, TimeUnit.SECONDS);
        ScheduledThreadPoolExecutor executorInfoCountAnimal = new ScheduledThreadPoolExecutor(3);
        executorInfoCountAnimal.scheduleAtFixedRate(new TaskInfoCountAnimal(), 1, 10, TimeUnit.SECONDS);

    }
    public void init(){
        EatableType[] values = EatableType.values();
        for (EatableType value : values) {
            int randomCount = Random.getRandomCount(Settings.minCreatCountAnimal, value.getMaxCountCell());
            for (int i = 0; i < randomCount; i++) {
                Eatable.setEatableLocation(FactoryCreateEatable.createEatable(value));
            }

        }


    }
}
