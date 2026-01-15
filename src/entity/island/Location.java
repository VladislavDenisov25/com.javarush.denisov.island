package entity.island;

import entity.Animal;
import entity.Eatable;
import util.Settings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Location {

    private static Island island = Island.getInstance();
    private static Location[] locations = island.getLocation();

    public Location() {
    }

    public static void newLocation() {
        for (int i = 0; i < locations.length; i++) {
            if (locations[i] == null){
                locations[i] = new Location();
                System.out.println("Новая локация добавлена!");
                return;
        }
        }
        System.out.println("Размер острова слишком мал!");
    }

    public static Map<Eatable, Integer> animalLiveCount = new HashMap<>();
}
