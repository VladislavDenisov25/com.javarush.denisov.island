package entity.predator;

import entity.Animal;
import entity.OrganismType;

public class Wolf extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.WOLF;
    }
}
