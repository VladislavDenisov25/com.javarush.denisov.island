package entity;

import entity.island.Island;
import entity.island.Location;
import util.Random;
import util.Settings;

public abstract class Organism {
    private int column;
    private int line;


    static Location[][] location = Island.getInstance().getLocation();

    public Organism() {
         column = Random.getRandomCount(Settings.COLUMNS);
         line = Random.getRandomCount(Settings.LINES);
         location[column][line].animalLiveCount.put(this, 1);
    }

}
