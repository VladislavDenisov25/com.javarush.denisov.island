package services;

import entity.Animal;
import entity.Organism;
import entity.island.Location;

public class TaskLiveAnimal implements Runnable {

    public Organism organism;
    Location location;

    public TaskLiveAnimal(Organism organism, Location location) {
        this.organism = organism;
        this.location = location;
    }

    @Override
    public void run() {
        if (organism != null && organism instanceof Animal) {
            ((Animal) organism).eat();
            ((Animal) organism).multiply();
            ((Animal) organism).move();
        }
    }
}
