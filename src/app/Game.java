package app;

import entity.Animal;
import entity.Eatable;
import entity.herbivore.*;
import entity.island.*;
import entity.predator.*;
import util.Random;
import util.Settings;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {



    public void start() {

        for (int i = 0; i < 10; i++) {
            Location.newLocation();
        }
        creatHerbivore();
        creatPredator();
        ScheduledThreadPoolExecutor executorCreatePlant = new ScheduledThreadPoolExecutor(1);
        executorCreatePlant.scheduleAtFixedRate(new TaskCreatePlant(), 0, 1, TimeUnit.SECONDS);
        ScheduledThreadPoolExecutor executorInfoCountAnimal = new ScheduledThreadPoolExecutor(3);
        executorInfoCountAnimal.scheduleAtFixedRate(new TaskInfoCountAnimal(), 1, 10, TimeUnit.SECONDS);


    }

    public void creatHerbivore() {
        int countHerbivore = Random.getRandomCount(Settings.minCreatCountHerbivore, 100);
        for (int i = 0; i < countHerbivore; i++) {
            int animalNumberHerbivore = Random.getRandomCount(10);
            Eatable.setEatableLocation(Eatable.createEatable(switch (animalNumberHerbivore) {
                        case 0 -> new Boar();
                        case 1 -> new Buffalo();
                        case 2 -> new Caterpillar();
                        case 3 -> new Deer();
                        case 4 -> new Duck();
                        case 5 -> new Goat();
                        case 6 -> new Sheep();
                        case 7 -> new Horse();
                        case 8 -> new Mouse();
                        case 9 -> new Rabbit();
                        default -> throw new IllegalStateException("Unexpected value: " + animalNumberHerbivore);
                    }
            ));
        }
    }

    public void creatPredator() {
        int countPredator = Random.getRandomCount(Settings.minCreatCountPredator, 100);
        for (int i = 0; i < countPredator; i++) {
            int animalNumberPredator = Random.getRandomCount(5);
            Eatable.setEatableLocation(Eatable.createEatable(switch (animalNumberPredator) {
                        case 0 -> new Bear();
                        case 1 -> new Boa();
                        case 2 -> new Eagle();
                        case 3 -> new Fox();
                        case 4 -> new Wolf();
                        default -> throw new IllegalStateException("Unexpected value: " + animalNumberPredator);
                    }
            ));
        }
    }
}
