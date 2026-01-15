package entity;

import entity.herbivore.*;
import entity.predator.*;

public interface Eatable {

    Eatable createEatable(Eatable eatable);
}
