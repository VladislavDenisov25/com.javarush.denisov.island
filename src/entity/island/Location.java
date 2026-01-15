package entity.island;

import entity.Eatable;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private static Island island = Island.getInstance();
    private static Location[] locations = island.getLocation();

    public Location() {
    }

    public static void newLocation() {
        for (int i = 0; i < locations.length; i++) {
            if (locations[i] == null) {
                locations[i] = new Location();
                System.out.println("Новая локация добавлена!");
                return;
            }
        }
        System.out.println("Размер острова слишком мал!");
    }

    public Map<Eatable, Integer> animalLiveCount = new HashMap<>();  //тут находятся животные и растения с одной локации
}
