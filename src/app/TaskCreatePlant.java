package app;

import entity.Eatable;
import entity.Plant;
import util.Settings;

import java.util.concurrent.ThreadLocalRandom;

public class TaskCreatePlant implements Runnable {

    @Override
    public void run() {

        int countPlant = ThreadLocalRandom.current().nextInt(1, Settings.maxCreatCountPlant);
        for (int i = 0; i < countPlant; i++) {
            Eatable.setEatableLocation(FactoryCreateEatable.createEatable(new Plant()));
        }

    }
}
