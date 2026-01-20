package entity.herbivore;

import entity.Animal;
import entity.OrganismType;

public class Mouse extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.MOUSE;
    }
}
