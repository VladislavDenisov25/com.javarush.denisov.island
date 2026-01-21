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
    Location[][] locations = Island.getInstance().getLocation();

    public TaskLiveAnimal(Organism organism) {
        this.organism = organism;
    }

    @Override
    public void run() {
        try {
           locations[organism.getColumn()][organism.getLine()].getLock().lock();
           if (organism != null && organism instanceof Animal) {
               ((Animal) organism).eat();
               ((Animal) organism).multiply();
               ((Animal) organism).move();
           }
        } finally {
            locations[organism.getColumn()][organism.getLine()].getLock().unlock();
        }
    }
}

