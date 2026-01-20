package entity.predator;

import entity.Animal;
import entity.OrganismType;

public class Eagle extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.EAGLE;
    }
}
