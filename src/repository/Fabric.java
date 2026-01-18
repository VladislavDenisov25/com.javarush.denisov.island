package repository;

import entity.Organism;
import entity.OrganismType;
import entity.herbivore.*;
import entity.island.Island;
import entity.island.Location;
import entity.plant.Grass;
import entity.predator.*;
import util.Random;

public class Fabric {

    static Location[] location = Island.getInstance().getLocation();

   public static void createEatable(OrganismType type){
     Organism organism = switch (OrganismType.valueOf(String.valueOf(type))){
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
         case GRASS -> new Grass();
     };
       int index = Random.getRandomCount(location.length);
       location[index].animalLiveCount.put(organism, 1);
   }
}
