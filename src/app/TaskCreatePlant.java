package app;

import entity.Eatable;
import entity.Plant;
import util.Settings;

import util.Random;


public class TaskCreatePlant implements Runnable {

    @Override
    public void run() {

        int countPlant = Random.getRandomCount(1, Settings.maxCreatCountPlant);
        for (int i = 0; i < countPlant; i++) {
            Eatable.setEatableLocation(FactoryCreateEatable.createEatable(new Plant()));
        }
        System.out.printf("На острове выросла новая трава в количестве %d\n", countPlant);
    }
}
