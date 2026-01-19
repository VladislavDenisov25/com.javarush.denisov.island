package services;

import entity.OrganismType;
import entity.island.Island;
import entity.island.Location;
import repository.Fabric;
import util.Random;
import util.Settings;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {

    Location[][] location = Island.getInstance().getLocation();
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

    public void start() {
        executor.scheduleAtFixedRate(new TaskInfoCountAnimal(), 0, 10, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(new TaskCreatePlant(), 0, 1, TimeUnit.SECONDS);
        createOrganizm();

        for (int x = 0; x < location.length; x++) {
            for (int y = 0; y < location[x].length; y++) {
                // new runnable новый поток - жизнь одной клетки или складывать их в очередь и передать очередь
                executor.scheduleAtFixedRate(new TaskLiveAnimal(x, y), 0, 1, TimeUnit.SECONDS);
                }
            }
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
