package services;

import entity.Animal;
import entity.Organism;
import entity.island.Island;
import entity.island.Location;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;


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

