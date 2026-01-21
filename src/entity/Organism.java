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

    public Organism() { // создавать если есть место
        while (true) {
            column = Random.getRandomCount(Settings.COLUMNS);
            line = Random.getRandomCount(Settings.LINES);
            if (location[column][line].getCountType(this) < this.getType().getMaxCountCell()) {
                location[column][line].animalLiveCount.put(this, 1);
                return;
            }
        }

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
    public abstract OrganismType getType();



}
