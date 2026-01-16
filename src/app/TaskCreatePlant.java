package app;

import entity.Plant;
import util.Settings;

import java.util.concurrent.ThreadLocalRandom;

public class TaskCreatePlant implements Runnable {

    Plant plant = new Plant();

    @Override
    public void run() {

        int countPlant = ThreadLocalRandom.current().nextInt(1, Settings.maxCreatCountPlant);
        for (int i = 0; i < countPlant; i++) {
            plant.setEatableLocation(plant.createEatable(new Plant()));
        }

    }
}
