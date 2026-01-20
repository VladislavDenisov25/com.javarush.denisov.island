package entity.herbivore;


import constants.Constants;
import entity.Animal;
import entity.OrganismType;

public class Buffalo extends Animal {
    @Override
    public OrganismType getType() {
        return OrganismType.BUFFALO;
    }
}
