package entity.predator;

import entity.Animal;
import entity.OrganismType;

public class Boa extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.BOA;
    }
}
