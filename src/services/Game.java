package services;

import entity.OrganismType;
import repository.Fabric;
import util.Random;
import util.Settings;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {

    public void start() {

        createOrganizm();

        ScheduledThreadPoolExecutor executorInfoCountAnimal = new ScheduledThreadPoolExecutor(1);
        executorInfoCountAnimal.scheduleAtFixedRate(new TaskInfoCountAnimal(), 0, 10, TimeUnit.SECONDS);
        ScheduledThreadPoolExecutor executorCreatePlant = new ScheduledThreadPoolExecutor(1);
        executorCreatePlant.scheduleAtFixedRate(new TaskCreatePlant(), 5, 1, TimeUnit.SECONDS);

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
