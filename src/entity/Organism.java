package entity;

import entity.island.Island;
import entity.island.Location;
import util.Random;
import util.Settings;

import java.util.concurrent.locks.ReentrantLock;

public abstract class Organism {

    private int column;
    private int line;

    public Location[][] location = Island.getInstance().getLocation();
    ReentrantLock lock = new ReentrantLock();
    public Organism() {
         column = Random.getRandomCount(Settings.COLUMNS);
         line = Random.getRandomCount(Settings.LINES);
         location[column][line].animalLiveCount.put(this, 1);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }
   public void move() {
        try {
            lock.tryLock();
            Location oldLocation = location[getColumn()][getLine()];
            int randomCount = Random.getRandomCount(4);
            switch (randomCount){
                case 0 -> setLine(getLine() + 1); // верх
                case 1 -> setLine(getLine() - 1); // вниз
                case 2 -> setColumn(getColumn() + 1); // вправо
                case 3 -> setColumn(getColumn() - 1); // вправо
            }
            if (getColumn() < 0 || getColumn() >= Settings.COLUMNS
                    || getLine() < 0 || getLine() >= Settings.LINES) {
                System.out.println(this.getClass().getSimpleName() + " Ушел с этого острова!");
            } else {
                location[getColumn()][getLine()].animalLiveCount.put(this, 1);
                System.out.println(this.getClass().getSimpleName() + " еще тут");
            }
            oldLocation.animalLiveCount.remove(this);
        } finally {
            lock.unlock();
        }
    }

}
