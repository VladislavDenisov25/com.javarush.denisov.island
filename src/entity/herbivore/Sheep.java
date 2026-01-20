package entity.herbivore;

import entity.Animal;
import entity.OrganismType;

public class Sheep extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.SHEEP;
    }
}
