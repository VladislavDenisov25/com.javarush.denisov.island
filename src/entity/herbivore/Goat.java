package entity.herbivore;

import entity.Animal;
import entity.OrganismType;

public class Goat extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.GOAT;
    }
}
