package entity;

import entity.herbivore.*;
import entity.island.Island;
import entity.island.Location;
import entity.predator.*;


import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements Eatable {

    public double weight;

    public String emoji;

    void eat(Eatable e) {
    }

    void move(Location l) {

    }

    void multiply() {

    }

    void die() {

    }
}
