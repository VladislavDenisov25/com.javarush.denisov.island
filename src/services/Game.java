package services;

import entity.OrganismType;
import entity.island.Island;
import entity.island.Location;
import repository.Fabric;
import util.Random;
import util.Settings;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {

    Location[][] location = Island.getInstance().getLocation();
  ScheduledExecutorService executorService = Executors.newScheduledThreadPool(300);

    public void start() {
        executorService.scheduleAtFixedRate(new TaskInfoCountAnimal(), 0, 10, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new TaskCreatePlant(), 0, 1, TimeUnit.SECONDS);
        createOrganizm();
        for (int x = 0; x < location.length; x++) {
            for (int y = 0; y < location[x].length; y++) {
                // new runnable новый поток - жизнь одной клетки или складывать их в очередь и передать очередь
                executorService.schedule(new TaskLiveAnimal(x, y),0, TimeUnit.MILLISECONDS );
                }
            }
    }

    public void createOrganizm() { // тут можно сделать проверку на текущ кол-во животных в локации и создать нужное
        OrganismType[] values = OrganismType.values();
        for (OrganismType value : values) {
            int randomCount = Random.getRandomCount(Settings.minCreatCountEatable, value.getMaxCountCell());
            for (int i = 0; i < randomCount; i++) {
              Fabric.createEatable(value);
            }
        }
    }
}
