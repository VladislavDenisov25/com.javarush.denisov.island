package entity.plant;

import entity.OrganismType;
import entity.Plant;

public class Grass extends Plant {
    @Override
    public OrganismType getType() {
        return OrganismType.GRASS;
    }


}
