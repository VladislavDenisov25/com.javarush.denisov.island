package app;

import entity.Organism;
import entity.OrganismType;
import util.Settings;

import util.Random;


public class TaskCreatePlant implements Runnable {

    @Override
    public void run() {

        int countPlant = Random.getRandomCount(Settings.minCreatCountEatable, OrganismType.GRASS.getMaxCountCell());
        for (int i = 0; i < countPlant; i++) {
            Organism.setEatableLocation(FactoryCreateOrganism.createEatable(OrganismType.GRASS));
        }
        System.out.printf("На острове выросла новая трава в количестве %d\n", countPlant);
    }
}
