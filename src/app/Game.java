package app;


import entity.Eatable;
import entity.herbivore.*;
import entity.island.*;
import entity.predator.*;
import util.Settings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    Predator predator = new Predator();
    Herbivore herbivore = new Herbivore();

    public void start() {

        for (int i = 0; i < 10; i++) {
            Location.newLocation();
        }
        infoCountAnimal();
        creatHerbivore();
        infoCountAnimal();
        creatPredator();
        infoCountAnimal();
    }

    public void creatHerbivore() {
        int countHerbivore = ThreadLocalRandom.current().nextInt(Settings.minCreatCountHerbivore, 100);
        for (int i = 0; i < countHerbivore; i++) {
            int animalNumberHerbivore = ThreadLocalRandom.current().nextInt(Settings.minCreatCountHerbivore);
            herbivore.setEatableLocation(herbivore.createEatable(switch (animalNumberHerbivore) {
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
        int countPredator = ThreadLocalRandom.current().nextInt(Settings.minCreatCountPredator, 100);
        for (int i = 0; i < countPredator; i++) {
            int animalNumberPredator = ThreadLocalRandom.current().nextInt(Settings.minCreatCountPredator);
            predator.setEatableLocation(predator.createEatable(switch (animalNumberPredator) {
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
    public void infoCountAnimal() {
        Map<String, Integer> countAnimal = new HashMap<>();

        for (Location location : Island.getInstance().getLocation()) {
            for (Eatable eatable : location.animalLiveCount.keySet()) {
                countAnimal.merge(eatable.getClass().getSimpleName(), 1, Integer::sum);
            }
        }

        for (String s : countAnimal.keySet()) {
            System.out.printf("%s = %d ", s, countAnimal.get(s));
        }
        System.out.println();
    }
}
