package app;

import entity.OrganismType;
import entity.island.*;
import util.Random;
import util.Settings;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {
    Island island = Island.getInstance();
    public void start() {

        createOrganizm();

        System.out.println(island.getLocation().length);
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
              FactoryCreateOrganism.createEatable(value);
            }
        }
    }
}
