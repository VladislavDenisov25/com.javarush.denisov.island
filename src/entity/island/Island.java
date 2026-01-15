package entity.island;

import util.Settings;

public class Island {

    private static final Location[] location =  new Location[Settings.X * Settings.Y]; // возможно двухмерный массив
    private static Island island;

    private Island() {
    }

   public static Island getInstance(){
        if (island == null){
            return new Island();
        }
        return island;
   }


    public  Location[] getLocation() {
        return location;
    }
}
