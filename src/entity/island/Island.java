package entity.island;

import util.Settings;

public class Island {

    private static final Location[] location = new Location[Settings.X * Settings.Y];
    public static Island island;

    private Island() {
        for (int i = 0; i < location.length; i++) {
            if (location[i] == null) {
                location[i] = new Location();
            }
        }
    }

    public static Island getInstance() {
        if (island == null) {
            return new Island();
        }
        return island;
    }

    public Location[] getLocation() {
        return location;
    }
}
