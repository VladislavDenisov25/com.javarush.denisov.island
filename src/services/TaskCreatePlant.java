package services;

import entity.OrganismType;
import repository.Fabric;
import util.Settings;
import util.Random;

public class TaskCreatePlant implements Runnable {
    @Override
    public void run() {

        int countPlant = Random.getRandomCount(Settings.MIN_CREATE_COUNT_EATABLE, OrganismType.GRASS.getMaxCountCell());
        for (int i = 0; i < countPlant; i++) {
            Fabric.createEatable(OrganismType.GRASS);
        }
    }
}
