package app;

import entity.Eatable;
import entity.Plant;
import entity.herbivore.*;
import entity.predator.*;

public abstract class FactoryCreateEatable {
   public static Eatable createEatable(Eatable eatable){
     return  switch (eatable.getClass().getSimpleName()){
           case "Boar" -> new Boar();
           case "Buffalo" -> new Buffalo();
           case "Caterpillar" -> new Caterpillar();
           case "Deer" -> new Deer();
           case "Duck" -> new Duck();
           case "Goat" -> new Goat();
           case "Horse" -> new Horse();
           case "Mouse" -> new Mouse();
           case "Rabbit" -> new Rabbit();
           case "Sheep" -> new Sheep();
           case "Bear" -> new Bear();
           case "Boa" -> new Boa();
           case "Eagle" -> new Eagle();
           case "Fox" -> new Fox();
           case "Wolf" -> new Wolf();
           case "Plant" -> new Plant();
         default -> throw new IllegalStateException("Фабрика не работает с классом: " + eatable.getClass().getSimpleName());
     };
   }
}
