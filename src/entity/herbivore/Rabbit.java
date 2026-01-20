package entity.herbivore;

import entity.Animal;
import entity.OrganismType;

public class Rabbit extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.RABBIT;
    }
}
