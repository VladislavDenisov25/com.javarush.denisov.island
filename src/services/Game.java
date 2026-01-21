package services;

import entity.OrganismType;
import entity.island.Island;
import entity.predator.Wolf;
import repository.Fabric;
import util.Random;
import util.Settings;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Game {

    Island island = Island.getInstance();
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

    public void start() {
        executorService.scheduleAtFixedRate(new TaskCreatePlant(), 1, 10, TimeUnit.SECONDS);
        createOrganizm();

        executorService.schedule(new TaskInfoCountAnimal(), 0, TimeUnit.SECONDS);



            ScheduledFuture<?> organismTask =
                    executorService.scheduleAtFixedRate(new OrganismWorker(island), 1, 1, TimeUnit.SECONDS);

            executorService.schedule(() -> {
                organismTask.cancel(true);
            }, 10, TimeUnit.SECONDS);
            ScheduledFuture<?> organismTask2 =
                    executorService.scheduleAtFixedRate(new OrganismWorker(island), 1, 1, TimeUnit.SECONDS);


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
