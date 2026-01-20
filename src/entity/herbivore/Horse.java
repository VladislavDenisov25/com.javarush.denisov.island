package entity.herbivore;

import entity.Animal;
import entity.OrganismType;

public class Horse extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.HORSE;
    }
}
