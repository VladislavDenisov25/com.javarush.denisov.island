package entity.herbivore;

import entity.Animal;
import entity.OrganismType;

public class Caterpillar extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.CATERPILLAR;
    }
}
