package entity.herbivore;

import entity.Animal;
import entity.OrganismType;

public class Deer extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.DEER;
    }
}
