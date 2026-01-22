package services;

import entity.OrganismType;
import entity.island.Island;
import repository.Fabric;
import util.Random;
import util.Settings;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Game {

    Island island = Island.getInstance();
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(Settings.MAX_CORE_POOL_SIZE);

    public void start() {
        createOrganizm();

        executorService.scheduleAtFixedRate(new TaskCreatePlant(), Settings.INITIAL_DELAY, Settings.PERIOD_CREATE_PLANT, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new TaskInfoCountAnimal(), Settings.INITIAL_DELAY, Settings.PERIOD_INFO_COUNT_ANIMAL, TimeUnit.SECONDS);

        ScheduledFuture<?> organismTask = executorService.scheduleAtFixedRate(new OrganismWorker(island), Settings.INITIAL_DELAY, Settings.PERIOD_LIVE_ANIMAL, TimeUnit.SECONDS);

        executorService.schedule(() -> {
            organismTask.cancel(true);
            executorService.shutdown();
        }, Settings.PERIOD_DELAY, TimeUnit.SECONDS);
    }

    public void createOrganizm() {
        OrganismType[] values = OrganismType.values();
        for (OrganismType value : values) {
            int randomCount = Random.getRandomCount(Settings.MIN_CREATE_COUNT_EATABLE, value.getMaxCountCell());
            for (int i = 0; i < randomCount; i++) {
                Fabric.createEatable(value);
            }
        }
    }
}
