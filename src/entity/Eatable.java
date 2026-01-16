package entity;

import entity.island.Island;
import entity.island.Location;

public interface Eatable {

    Location[] location = Island.getInstance().getLocation();
    String emoji = "";

    Eatable createEatable(Eatable eatable);
    String getEmoji();
    void setEatableLocation(Eatable eatable);
}
