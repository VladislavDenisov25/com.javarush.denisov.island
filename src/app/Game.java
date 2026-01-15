package app;

import entity.island.Island;
import entity.island.Location;

public class Game {

    public void start() {
        Island island = Island.getInstance();
        Location.newLocation();
        Location.newLocation();

    }
}
