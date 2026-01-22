package entity.island;

import util.Settings;

public class Island {

    private static final Location[][] location = new Location[Settings.COLUMNS][Settings.LINES];
    private static Island island;

    private Island() {
        for (int x = 0; x < location.length; x++) {
            for (int y = 0; y < location[x].length; y++) {
                if (location[x][y] == null) {
                    location[x][y] = new Location();
                }
            }
        }
    }

    public static Island getInstance() {
        if (island == null) {
            return new Island();
        }
        return island;
    }

    public Location[][] getLocation() {
        return location;
    }
}
