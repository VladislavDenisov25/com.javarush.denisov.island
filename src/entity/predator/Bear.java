package entity.predator;

import entity.Animal;
import entity.OrganismType;

public class Bear extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.BEAR;
    }

}
