package services;

import entity.Animal;
import entity.Organism;
import entity.OrganismType;
import entity.island.Island;
import entity.island.Location;
import repository.Fabric;
import util.Random;
import util.Settings;

import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {

    Location[][] location = Island.getInstance().getLocation();
  ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
ArrayBlockingQueue<TaskLiveAnimal> blockingQueue = new ArrayBlockingQueue<>(Settings.COLUMNS * Settings.LINES, true);


    public void start() { //
        // обходим все клетки острова и когда доходим до конкретной клетки формируем новую задачу и кладем ее в арайблокикнг кью
        createOrganizm();
        executorService.schedule(new TaskInfoCountAnimal(), 1,  TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(new TaskCreatePlant(), 0, 1, TimeUnit.SECONDS);

        for (int x = 0; x < location.length; x++) {
            for (int y = 0; y < location[x].length; y++) {
                Set<Organism> organisms = location[x][y].animalLiveCount.keySet();
                for (Organism organism : organisms) {
                    try {
                        blockingQueue.put(new TaskLiveAnimal(organism));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        }
        for (TaskLiveAnimal taskLiveAnimal : blockingQueue) {
            executorService.submit(taskLiveAnimal);
        }

        executorService.schedule(new TaskInfoCountAnimal(), 10,  TimeUnit.MILLISECONDS);
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
