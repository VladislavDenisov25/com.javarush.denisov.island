package app;

import entity.Plant;
import entity.predator.*;
import util.Settings;

import java.util.concurrent.ThreadLocalRandom;

public class TaskCreatePlant implements Runnable {

    Plant plant = new Plant();
    volatile int sumCountPlants = 0;

    @Override
    public void run() {

        int countPlant = ThreadLocalRandom.current().nextInt(1, Settings.minCreatCountPlant);
        for (int i = 0; i < countPlant; i++) {
            plant.setEatableLocation(plant.createEatable(new Plant()));
        }
        sumCountPlants += countPlant;
        System.out.printf("Выросла новая трава %s, общее количество растительности на острове %d \n", plant.getEmoji(), sumCountPlants);
    }
}
