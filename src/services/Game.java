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
    ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(Settings.MAX_CORE_POOL_SIZE);

    public void start() {
        createOrganizm();

        threadPool.scheduleAtFixedRate(new TaskCreatePlant(), Settings.INITIAL_DELAY, Settings.PERIOD_ONE_SECOND, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(new TaskInfoCountAnimal(), Settings.INITIAL_DELAY, Settings.PERIOD_LIVE_ANIMAL, TimeUnit.SECONDS);

        ScheduledFuture<?> organismTask = threadPool.scheduleAtFixedRate(new OrganismWorker(island), Settings.INITIAL_DELAY, Settings.PERIOD_ONE_SECOND, TimeUnit.SECONDS);

        threadPool.schedule(() -> {
            organismTask.cancel(true);
            threadPool.shutdown();
        }, Settings.PERIOD_LIVE_ANIMAL, TimeUnit.SECONDS);
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
