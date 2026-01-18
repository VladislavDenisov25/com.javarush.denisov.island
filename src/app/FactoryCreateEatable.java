package app;

import entity.Eatable;
import entity.EatableType;
import entity.Plant;
import entity.herbivore.*;
import entity.predator.*;

public abstract class FactoryCreateEatable {
   public static Eatable createEatable(EatableType type){
     return switch (EatableType.valueOf(String.valueOf(type))){
         case BOAR -> new Boar();
         case BUFFALO -> new Buffalo();
         case CATERPILLAR -> new Caterpillar();
         case DEER -> new Deer();
         case DUCK -> new Duck();
         case GOAT -> new Goat();
         case HORSE -> new Horse();
         case MOUSE -> new Mouse();
         case RABBIT -> new Rabbit();
         case SHEEP -> new Sheep();
         case BEAR -> new Bear();
         case BOA -> new Boa();
         case EAGLE -> new Eagle();
         case FOX -> new Fox();
         case WOLF -> new Wolf();
         case PLANT -> new Plant();
         default -> throw new IllegalStateException("Фабрика не работает с классом: " + type.getClass().getSimpleName());
     };
   }
}
