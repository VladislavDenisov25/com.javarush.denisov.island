package services;

import entity.Organism;
import entity.OrganismType;
import entity.island.Island;
import entity.island.Location;
import entity.predator.Wolf;
import repository.Fabric;
import util.Random;
import util.Settings;

import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {

    public void start() {

        createOrganizm();

        Location[][] location = Island.getInstance().getLocation();
        for (int i = 0; i < location.length; i++) {
            for (int i1 = 0; i1 < location[i].length; i1++) {
                for (Organism organism : location[i][i1].animalLiveCount.keySet()) {
                    System.out.println(organism.getClass());
                }
            }
        }
        System.out.println("-".repeat(100));
        for (Class aClass : OrganismType.BOA.getAttackAnimal().keySet()) {
            System.out.println(aClass);
        }
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        ScheduledThreadPoolExecutor executor1 = new ScheduledThreadPoolExecutor(1);
        executor.scheduleAtFixedRate(new TaskInfoCountAnimal(), 0, 10, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(new TaskCreatePlant(), 0, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(new TaskLiveAnimal(), 0, 1, TimeUnit.SECONDS);


    }

    public void createOrganizm() {
        OrganismType[] values = OrganismType.values();
        for (OrganismType value : values) {
            int randomCount = Random.getRandomCount(Settings.minCreatCountEatable, value.getMaxCountCell());
            for (int i = 0; i < randomCount; i++) {
              Fabric.createEatable(value);
            }
        }
    }
}
