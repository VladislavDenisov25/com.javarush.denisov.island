package entity;

import entity.island.Island;
import entity.island.Location;
import util.Random;
import util.Settings;

public abstract class Organism {

    private int column;
    private int line;
    private double hunger;

    public Location[][] location = Island.getInstance().getLocation();

    public Organism() {
        while (true) {
            column = Random.getRandomCount(Settings.COLUMNS);
            line = Random.getRandomCount(Settings.LINES);
            hunger = this.getType().getPrimaryHunger();
            if (location[column][line].getCountType(this) < this.getType().getMaxCountCell()) {
                location[column][line].animalLiveCount.put(this, Settings.MIN_CREATE_COUNT_EATABLE);
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

    public double getHunger() {
        return hunger;
    }

    public void setHunger(double hunger) {
        this.hunger = hunger;
    }
}
