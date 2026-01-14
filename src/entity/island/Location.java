package entity.island;

import entity.Animal;
import entity.Eatable;

import java.util.HashMap;
import java.util.Map;

public class Location  {

  static  Location[] locations;
    private Location(int x, int y) {
        locations = new Location[x*y];
    }

    public static Location[] getInstans(){
        if (locations == null){
            locations = new Location[100];
        }
        return locations;
    }
    public static Map<Eatable, Integer> animalLiveCount = new HashMap<>();
}
