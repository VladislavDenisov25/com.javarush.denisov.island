package entity;

import entity.herbivore.*;
import entity.predator.*;

public class Plant implements Eatable {

    @Override
    public Eatable createEatable(Eatable eatable){
        return switch (eatable.getClass().getSimpleName()){
            case "Plant" -> new Plant();
            default -> throw new IllegalStateException("Такие звери не обитают на острове: " + eatable.getClass().getSimpleName());
        };
    }
}
