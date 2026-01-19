package services;

import entity.Animal;
import entity.Organism;
import entity.island.Island;
import entity.island.Location;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class TaskLiveAnimal implements Runnable {
    Location[][] locations = Island.getInstance().getLocation();
    ReentrantLock rent = new ReentrantLock();
    @Override
    public void run() {
        try {
            rent.tryLock();
            for (int x = 0; x < locations.length; x++) {
                for (int y = 0; y < locations[x].length; y++) {
                    for (Organism organism : locations[x][y].animalLiveCount.keySet()) {
                        if (organism instanceof Animal){
                            organism.move();
                        }
                    }
                }
            }
        } finally {
            rent.unlock();
        }
    }
}
