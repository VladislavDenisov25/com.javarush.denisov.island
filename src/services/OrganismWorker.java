package services;

import entity.Organism;
import entity.island.Island;
import entity.island.Location;

import java.util.*;

public class OrganismWorker implements Runnable {

    private final Island island;

    public OrganismWorker(Island island) {
        this.island = island;
    }

    @Override
    public void run() {

        if (Thread.currentThread().isInterrupted()) {
            return;
        }

        for (Location[] locations : island.getLocation()) {
            for (Location location : locations) {

                if (Thread.currentThread().isInterrupted()) {
                    return;
                }

                process(location);
            }
        }
    }

    private void process(Location location) {

        if (Thread.currentThread().isInterrupted()) {
            return;
        }

        Set<Organism> organisms = location.animalLiveCount.keySet();
        if (organisms == null || organisms.isEmpty()) {
            return;
        }

        Queue<TaskLiveAnimal> queue = new ArrayDeque<>();

        location.getLock().lock();
        try {
            for (Organism organism : organisms) {

                if (Thread.currentThread().isInterrupted()) {
                    return;
                }

                queue.add(new TaskLiveAnimal(organism, location));
            }
        } finally {
            location.getLock().unlock();
        }

        for (TaskLiveAnimal taskLiveAnimal : queue) {

            if (Thread.currentThread().isInterrupted()) {
                return;
            }

            taskLiveAnimal.run();
        }
    }
}