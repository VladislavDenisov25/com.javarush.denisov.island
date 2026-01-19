package services;

import entity.Animal;
import entity.Organism;
import entity.island.Island;
import entity.island.Location;

import java.util.concurrent.locks.ReentrantLock;


public class TaskLiveAnimal implements Runnable {

    ReentrantLock lock = new ReentrantLock();
    public Location locations;

    public TaskLiveAnimal(int x, int y) {
        this.locations = Island.getInstance().getLocation()[x][y];
    }

    @Override
    public void run() {
        try {
            lock.tryLock();
            for (Organism organism : locations.animalLiveCount.keySet()) {
                if (organism instanceof Animal) {
                    ((Animal) organism).eat();
                    ((Animal) organism).multiply();
                    ((Animal) organism).move();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

