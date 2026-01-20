package entity.herbivore;

import entity.Animal;
import entity.OrganismType;

public class Boar extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.BOAR;
    }
}
